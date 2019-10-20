package com.horseboarding.horseboarding.controllers;


import com.horseboarding.horseboarding.models.Horse;
import com.horseboarding.horseboarding.models.HorseType;
import com.horseboarding.horseboarding.models.data.HorseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HorseController {

    @Autowired
    private HorseDao horseDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("facilities", horseDao.findAll());
        model.addAttribute("title", "Horse Boarding");
        return "index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddFacilityForm(Model model) {
        model.addAttribute("title", "Add Horse Facility");
        model.addAttribute(new Horse());
        model.addAttribute("horseTypes", HorseType.values());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddFacilityForm(@ModelAttribute @Valid Horse newFacility, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Facility");
            return "add";
        }
        horseDao.save(newFacility);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveFacilityForm(Model model) {
        model.addAttribute("facilities", horseDao.findAll());
        model.addAttribute("title", "Remove Facilities");
        return "remove";
    }

}
