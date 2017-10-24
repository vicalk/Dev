package com.repair.car.controller;

import com.repair.car.model.LoginForm;
import com.repair.car.services.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String LOGIN_FORM = "loginForm";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {

        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(name = "error", required = false) String error,
                        HttpSession session) {

        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        model.addAttribute(LOGIN_FORM, new LoginForm());
        return "login";
    }


}