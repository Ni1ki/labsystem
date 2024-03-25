package com.example.labsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserdashboardController {
	
//	@GetMapping("/userdashboard")
//    public String viewUserdashboardPage(Model model) {
//		model.addAttribute("patient");
//        System.out.print("Get / ");    
//        return "userdashboard";
//    }
	
	@GetMapping("/userdashboard/payment")
    public String viewPaymentPage(Model model) {
		model.addAttribute("patient");
        System.out.print("Get / ");    
        return "payment";
    }

}
