package com.example.labsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.labsystem.dto.PatientDto;
import com.example.labsystem.model.Patient;
import com.example.labsystem.service.AdminPatientService;
import com.example.labsystem.service.PatientService;

@Controller
public class AdminPatientController {
	
	@Autowired
    private AdminPatientService service;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/admindashboard/patient")
    public String viewAdminPatientPage(Model model) {
        List<Patient> listpatient = service.listAll();
        model.addAttribute("listpatient", listpatient);
        System.out.print("Get / ");    
        return "adminpatient";
    }
	
    @GetMapping("/admindashboard/patient/add")
    public String add(Model model) {
        model.addAttribute("patient", new Patient());
        return "createpatient";
    }
    
    @PostMapping("/savenewpatient")
	public String add(@ModelAttribute("patient") PatientDto patientDto, Model model) {
		patientService.save(patientDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "redirect:/admindashboard/patient";
	}
    
    @RequestMapping(value = "/savepatient", method = RequestMethod.POST)
    public String savePatient(@ModelAttribute("doctor") Patient std) {
        service.save(std);
        return "redirect:/admindashboard/patient";
    }
    
    @RequestMapping("/admindashboard/patient/edit/{id}")
    public ModelAndView showEditPatientPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editpatient");
        Patient std = service.get(id);
        mav.addObject("patient", std);
        return mav;
        
    }
    
    @RequestMapping("/admindashboard/patient/delete/{id}")
    public String deletepatient(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admindashboard/patient";
    }
    	
    
//    @PostMapping("/admindashboard/patient/edit/{id}")
//    public String editPatient(@PathVariable(name = "id") int id, @ModelAttribute("patient") PatientDto patientDto, Model model) {
//        // Update the patient information in the service
//    	patientService.edit(id, patientDto);
//        model.addAttribute("message", "Patient updated successfully!");
//        return "redirect:/admindashboard/patient";
//    }
//
//    @RequestMapping("/admindashboard/patient/delete/{id}")
//    public String deletePatient(@PathVariable(name = "id") int id) {
//        // Delete the patient by ID
//    	patientService.delete(id);
//        return "redirect:/admindashboard/patient";
//    }
    


}
