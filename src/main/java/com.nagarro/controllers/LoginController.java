package com.nagarro.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.constant.Constants;
import com.nagarro.models.Employee;
import com.nagarro.models.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author Sanyam Goel created on 17/9/18
 */
@Controller
public class LoginController {
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String init(Model model) {
//
//        // to retrieve single entry
//        RestTemplate restTemplate = new RestTemplate();
//        String e = restTemplate.getForObject(Constants.REST_API_SLUG+Constants.GET_EMPLOYEE+"122", String.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Employee employee = null;
//        try {
//            employee = objectMapper.readValue(e, Employee.class);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        System.out.println(employee);
//        System.out.println(employee.toString());
//
//
//        // to retrieve all employees
//        String empe = restTemplate.getForObject(Constants.REST_API_SLUG+Constants.GET_ALL_EMPLOYEES, String.class);
//        List<Employee> employeeList = null;
//        try {
//            employeeList = objectMapper.readValue(empe, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        System.out.println(employeeList.size());
//        System.out.println(employeeList.get(0).toString());
//        System.out.println(employeeList);
//
//
//
//        model.addAttribute("msg", "Please Enter Your Login Details");
//        return "login";
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
//        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
//            if (loginBean.getUserName().equals("user") && loginBean.getPassword().equals("user")) {
//                model.addAttribute("msg", loginBean.getUserName());
//                return "employees";
//            } else {
//                model.addAttribute("error", "Invalid Details");
//                return "login";
//            }
//        } else {
//            model.addAttribute("error", "Please enter Details");
//            return "login";
//        }
//    }
//
//    @RequestMapping(value = "/emp", method = RequestMethod.GET)
//    public ModelAndView getEmployees() {
//        ModelAndView modelAndView = new ModelAndView();
//
////        // to retrieve single entry
////        RestTemplate restTemplate = new RestTemplate();
////        String e = restTemplate.getForObject(Constants.REST_API_SLUG+Constants.GET_EMPLOYEE+"122", String.class);
////        ObjectMapper objectMapper = new ObjectMapper();
////        Employee employee = null;
////        try {
////            employee = objectMapper.readValue(e, Employee.class);
////        } catch (IOException e1) {
////            e1.printStackTrace();
////        }
////        System.out.println(employee);
////        System.out.println(employee.toString());
////
////
////        // to retrieve all employees
////        String empe = restTemplate.getForObject(Constants.REST_API_SLUG+Constants.GET_ALL_EMPLOYEES, String.class);
////        List<Employee> employeeList = null;
////        try {
////            employeeList = objectMapper.readValue(empe, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
////        } catch (IOException e1) {
////            e1.printStackTrace();
////        }
////        System.out.println(employeeList.size());
////        System.out.println(employeeList.get(0).toString());
////        System.out.println(employeeList);
//
//
//
//
//        modelAndView.addObject("hell", "11");
//        modelAndView.setViewName("ok");
//        return modelAndView;
//    }
}
