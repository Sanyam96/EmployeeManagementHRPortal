package com.nagarro.controllers;

import com.nagarro.constant.Constants;
import com.nagarro.models.Employee;
import com.nagarro.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Sanyam Goel created on 17/9/18
 */
@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEmployeeList(Model model, HttpServletRequest request) {
        String response;
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null && httpSession.getAttribute("userId") != null) {
            List<Employee> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
            response = "employeeListPage";
        } else {
            response = "redirect:/login";
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        employeeService.addAllEmployees(file);
        return "redirect:/employee";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "editEmployeePage";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void downloadFile(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=" + Constants.CSV_FILE_NAME);
        try (ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE)) {
            employeeService.addEmployeeDetailsToFile(csvBeanWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}