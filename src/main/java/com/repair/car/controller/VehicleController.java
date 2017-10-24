package com.repair.car.controller;


import com.repair.car.model.VehicleRegisterForm;
import com.repair.car.model.VehicleSearchForm;
import com.repair.car.services.VehicleService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(VehicleController.class);
    private static final String VEHICLE_REGISTER_FORM = "vehicleRegisterForm";
    private static final String VEHICLE_SEARCH_FORM = "vehicleSearchForm";
    private static final String VEHICLE_LIST = "vehicleList";

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/vehicleCreate", method = RequestMethod.GET)
    public String vehicleRegister(Model model) {

        System.err.println("qq");
        model.addAttribute(VEHICLE_REGISTER_FORM, new VehicleRegisterForm());
        return "vehicleCreate";
    }

    @RequestMapping(value = "/admin/vehicleCreate", method = RequestMethod.POST)
    public String vehicleRegister(Model model,@Valid @ModelAttribute(VEHICLE_REGISTER_FORM)
                                          VehicleRegisterForm vehicleRegisterForm,
                                  BindingResult bindingResult, HttpSession session,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            model.addAttribute(VEHICLE_REGISTER_FORM, vehicleRegisterForm);
            return "vehicleCreate";
        }

        try {


            vehicleService.vehicleRegister(vehicleRegisterForm);
            redirectAttributes.addFlashAttribute("success", true);



        } catch (Exception exception) {

            redirectAttributes.addFlashAttribute("error", true);
            logger.error("Vehicle registration failed: " + exception);

        }

        return "redirect:/admin/vehicleCreate";
    }

    @RequestMapping(value = "/admin/vehicleSearch", method = RequestMethod.GET)
    public String vehicleSearch(Model model) {
        model.addAttribute(VEHICLE_SEARCH_FORM, new VehicleSearchForm());
        model.addAttribute(VEHICLE_LIST,vehicleService.findAllVehicles());


 return "vehicleSearch";
    }

    @RequestMapping(value = "/vehicleSearch", method = RequestMethod.POST)
    public String vehicleSearch(Model model,@ModelAttribute(VEHICLE_SEARCH_FORM) VehicleSearchForm vehicleSearchForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {

        List<VehicleRegisterForm> vehicleList = vehicleService.vehicleSearch(vehicleSearchForm.getSearchText(),vehicleSearchForm.getSearchType());

        if (vehicleList.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No Vehicles found");
            System.err.println("empty");
        }
        model.addAttribute(VEHICLE_LIST, vehicleList );
        return "userSearch";
    }



}






























