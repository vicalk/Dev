package com.repair.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {

        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(Model model) {

        return "user";
    }

}
