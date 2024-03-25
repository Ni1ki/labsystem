package com.example.labsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.labsystem.model.Medicaltest;
import com.example.labsystem.service.MedicaltestService;

@Controller
public class MedicaltestController {
	
	@Autowired
    private MedicaltestService Mservice;
	
	@GetMapping("/admindashboard/medicaltest")
    public String viewMedicaltestPage(Model model) {
        List<Medicaltest> listmedicaltest = Mservice.listAll();
        model.addAttribute("listmedicaltest", listmedicaltest);
        System.out.print("Get / ");    
        return "adminmedicaltest";
    }
	
	@GetMapping("/userdashboard/medicaltest")
    public String viewUserMedicaltestPage(Model model) {
        List<Medicaltest> listmedicaltest = Mservice.listAll();
        model.addAttribute("listmedicaltest", listmedicaltest);
        System.out.print("Get / ");    
        return "usermedicaltest";
    }
	
    @GetMapping("/admindashboard/medicaltest/add")
    public String add(Model model) {
        model.addAttribute("medicaltest", new Medicaltest());
        return "createmedicaltest";
    }
    
    @RequestMapping(value = "/savemedicaltest", method = RequestMethod.POST)
    public String saveMedicaltest(@ModelAttribute("medicaltest") Medicaltest std) {
        Mservice.save(std);
        return "redirect:/admindashboard/medicaltest";
    }
    
    @RequestMapping("/admindashboard/medicaltest/edit/{id}")
    public ModelAndView showEditMedicaltestPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editmedicaltest");
        Medicaltest std = Mservice.get(id);
        mav.addObject("medicaltest", std);
        return mav;
        
    }
    
    @RequestMapping("/admindashboard/medicaltest/delete/{id}")
    public String deleteMedicaltest(@PathVariable(name = "id") int id) {
        Mservice.delete(id);
        return "redirect:/admindashboard/medicaltest";
    }


}
