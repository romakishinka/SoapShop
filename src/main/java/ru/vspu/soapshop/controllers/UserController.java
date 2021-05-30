package ru.vspu.soapshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vspu.soapshop.model.Location;
import ru.vspu.soapshop.model.Role;
import ru.vspu.soapshop.model.User;
import ru.vspu.soapshop.service.LocationService;
import ru.vspu.soapshop.service.SecurityService;
import ru.vspu.soapshop.service.UserService;
import ru.vspu.soapshop.validator.UserValidator;


/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/main";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "");
        }

        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "mainHeaderAdmin";

    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String main(Model model) {
        User user = userService.findByUsername(securityService.findLoggedInUsername());
        if(user == null)
            return "main";
        for (Object obj : user.getRoles().toArray()) {
            if (((Role) obj).getName().equals("ROLE_ADMIN"))
                return "mainHeaderAdmin";
        }
        return "main";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "about";
    }

    @RequestMapping(value ="/location", method=RequestMethod.GET)
    public String getLocation(Model model){
        model.addAttribute("location", new Location());
        return "location";
    }

    @RequestMapping(value ="/location", method = RequestMethod.POST)
    public String getLocation(@ModelAttribute("location") Location location){
        User user = userService.findByUsername(securityService.findLoggedInUsername());
        location.setUserId(user.getId());
        locationService.saveLocation(location);
        return "redirect:/basket/toorder";
    }

}
