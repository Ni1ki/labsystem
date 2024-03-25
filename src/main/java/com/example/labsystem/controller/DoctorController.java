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

import com.example.labsystem.model.Doctor;
import com.example.labsystem.service.DoctorService;

@Controller
public class DoctorController {
	
	@Autowired
    private DoctorService service;
	
	@GetMapping("/admindashboard/doctor")
    public String viewDoctorPage(Model model) {
        List<Doctor> listdoctor = service.listAll();
        model.addAttribute("listdoctor", listdoctor);
        System.out.print("Get / ");    
        return "admindoctor";
    }
	
    @GetMapping("/admindashboard/doctor/add")
    public String add(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "createdoctor";
    }
    
    @RequestMapping(value = "/savedoctor", method = RequestMethod.POST)
    public String saveDoctor(@ModelAttribute("doctor") Doctor std) {
        service.save(std);
        return "redirect:/admindashboard/doctor";
    }
    
    @RequestMapping("/admindashboard/doctor/edit/{id}")
    public ModelAndView showEditDoctorPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editdoctor");
        Doctor std = service.get(id);
        mav.addObject("doctor", std);
        return mav;
        
    }
    
    @RequestMapping("/admindashboard/doctor/delete/{id}")
    public String deletedoctor(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admindashboard/doctor";
    }

}
