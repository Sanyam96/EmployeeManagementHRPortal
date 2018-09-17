package com.nagarro.controllers;

import com.nagarro.models.User;
import com.nagarro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Sanyam Goel created on 17/9/18
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String authenticate(Model model, HttpServletRequest request) {
        String response;
        HttpSession httpSession = request.getSession(false);
        if(httpSession!= null && httpSession.getAttribute("userId")!=null) {
            response = "redirect:/employee";
        } else {
            response = "loginPage";
            model.addAttribute("message","");
        }
        return response;
    }

    @RequestMapping(value="login",method=RequestMethod.POST)
    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        User user = userService.authenticateUser(username, password);
        String response;
        if(user == null) {
            response = "loginPage";
            model.addAttribute("message","Username or Password Incorrect");
        } else {
            request.getSession().setAttribute("userId", user.getId());
            request.getSession().setAttribute("username", user.getUsername());
            response = "redirect:/employee";
        }
        return response;
    }

    @RequestMapping(value="logout",method=RequestMethod.POST)
    public String logout(HttpServletRequest request) {
        request.getSession(false).removeAttribute("username");
        request.getSession(false).removeAttribute("userId");
        return "redirect:/login";
    }
}
