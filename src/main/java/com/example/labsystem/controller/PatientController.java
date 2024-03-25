package com.example.labsystem.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.labsystem.dto.PatientDto;
import com.example.labsystem.service.PatientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.labsystem.model.Patient;


@Controller
public class PatientController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/")
    public String viewHomePage(Model model) {
		model.addAttribute("patient");
        System.out.print("Get / ");    
        return "home";
    }
	
	@GetMapping("/registration")
	public String viewRegistrationPage(Model model) {
		model.addAttribute("patient", new Patient());
        System.out.print("Get / ");
        System.out.println(model.addAttribute("patient"));
        return "register";
    }
	
//	@GetMapping("/loginpage")
//	public String viewLoginPage(Model model) {
//		model.addAttribute("patient");
//        System.out.print("Get / ");    
//        return "loginpage";
//    }
	
	
	@PostMapping("/registration")
	public String savePatient(@ModelAttribute("patient") PatientDto patientDto, Model model) {
		patientService.save(patientDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {  
        return "login";
    }
	
	@GetMapping("userdashboard")
	public String userdashboard(Model model, Principal principal) { 
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("patient", userDetails);
        return "userdashboard";
    }
//	@GetMapping("/userdashboard")
//	public String userdashboard(Model model, Principal principal) {
//	    UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//
//	    if (userDetails instanceof Patient) {
//	        Patient patient = (Patient) userDetails;
//	        model.addAttribute("patient", patient);
//	        return "userdashboard";
//	    } else {
//	        // Handle the case where the UserDetails is not a Patient (e.g., throw an exception or redirect)
//	        return "redirect:/error";
//	    }
//	}
	
	@GetMapping("admindashboard")
	public String admindashboard(Model model, Principal principal) {  
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("patient", userDetails);
        return "admindashboard";
    }
	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        // Perform any cleanup or additional logout actions if needed
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/"; // Redirect to the home page after logout
    }

}
