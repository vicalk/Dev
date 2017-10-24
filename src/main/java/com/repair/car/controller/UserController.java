package com.repair.car.controller;

import com.repair.car.converters.UserConverter;
import com.repair.car.domain.User;
import com.repair.car.model.UserRegisterForm;
import com.repair.car.model.UserSearchForm;
import com.repair.car.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String REGISTER_FORM = "userRegisterForm";
    private static final String SEARCH_FORM = "userSearchForm";
    private static final String USER_LIST = "userList";

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin/userCreate", method = RequestMethod.GET)
    public String userRegister(Model model) {


        model.addAttribute(REGISTER_FORM, new UserRegisterForm());
        return "userCreate";
    }


    @RequestMapping(value = "/admin/userCreate", method = RequestMethod.POST)
    public String userRegister(Model model,@Valid @ModelAttribute(REGISTER_FORM)
                                   UserRegisterForm userRegisterForm,
                           BindingResult bindingResult, HttpSession session,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ",
                    bindingResult.getErrorCount()));
            model.addAttribute(REGISTER_FORM, userRegisterForm);
            return "userCreate";
        }


        try {
            User user = UserConverter.buildUserObject(userRegisterForm);
            userService.register(user);


        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("User registration failed: " + exception);
        }


        redirectAttributes.addFlashAttribute("success", "You have sucessfully completed registration");
        return "redirect:/admin/userCreate";


    }

    @RequestMapping(value = "/admin/userSearch", method = RequestMethod.GET)
    public String userSearch(Model model) {
        model.addAttribute(SEARCH_FORM, new UserSearchForm());
        model.addAttribute(USER_LIST,userService.findAllUsers());

        System.err.println("GET ALL");

        return "userSearch";

    }

    @RequestMapping(value = "/admin/userSearch", method = RequestMethod.POST)
    public String userSearch(Model model,@ModelAttribute(SEARCH_FORM) UserSearchForm userSearchForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {

        List<UserRegisterForm> userList = userService.userSearch(userSearchForm.getUserSearchText(),userSearchForm.getUserSearchType());
        System.err.println("POST");

        if (userList==null) {
            redirectAttributes.addFlashAttribute("errorMessage", "No Users found");
            System.err.println("empty");
        }
        model.addAttribute(USER_LIST, userList );
        return "userSearch";
    }

    @RequestMapping(value = "/admin/userSearch/{id}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Long userId) {
        userService.deleteById(userId);
        System.err.println("delete");
        return "redirect:/admin/userSearch";
    }

//
//    @RequestMapping(value = "/admin/userSearch/{id}/edit", method = RequestMethod.GET)
//    public String editUser(@PathVariable("id") Long userId, Model model) {
//
//
//        User user = userService.findById(userId);
//        model.addAttribute("editUserForm", user);
//
//        populateDefaultModel(model);
//
//        return "users/userform";
//
//    }

}


