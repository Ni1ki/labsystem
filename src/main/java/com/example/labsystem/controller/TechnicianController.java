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

import com.example.labsystem.model.Technician;
import com.example.labsystem.service.TechnicianService;

@Controller
public class TechnicianController {
	
	@Autowired
    private TechnicianService service;
	
	@GetMapping("/admindashboard/technician")
    public String viewTechnicianPage(Model model) {
        List<Technician> listtechnician = service.listAll();
        model.addAttribute("listtechnician", listtechnician);
        System.out.print("Get / ");    
        return "admintechnician";
    }
	
    @GetMapping("/admindashboard/technician/add")
    public String add(Model model) {
        model.addAttribute("technician", new Technician());
        return "createtechnician";
    }
    
    @RequestMapping(value = "/savetechnician", method = RequestMethod.POST)
    public String saveTechnician(@ModelAttribute("technician") Technician std) {
        service.save(std);
        return "redirect:/admindashboard/technician";
    }
    
    @RequestMapping("/admindashboard/technician/edit/{id}")
    public ModelAndView showEditTechnicianPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edittechnician");
        Technician std = service.get(id);
        mav.addObject("technician", std);
        return mav; 
    }
    
    @RequestMapping("/admindashboard/technician/delete/{id}")
    public String deletetechnician(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admindashboard/technician";
    }

}
