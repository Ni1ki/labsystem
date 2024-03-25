package com.example.labsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.labsystem.model.Appointment;
import com.example.labsystem.model.Medicaltest;
import com.example.labsystem.service.AppointmentService;
import com.example.labsystem.service.MedicaltestService;

@Controller
public class AppointmentController {
	
	@Autowired
    private AppointmentService service;
	
	@Autowired
    private MedicaltestService Mservice;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/userdashboard/appointment")
    public String viewAppointmentPage(Model model) {
        List<Appointment> listappointment = service.listAll();
        model.addAttribute("listappointment", listappointment);
        System.out.print("Get / ");    
        return "appointment";
    }
	
	@GetMapping("/admindashboard/appointment")
    public String viewAdminAppointmentPage(Model model) {
        List<Appointment> listappointment = service.listAll();
        model.addAttribute("listappointment", listappointment);
        System.out.print("Get / ");    
        return "adminappointment";
    }
	
//	@GetMapping("/admindashboard/testresult")
//    public String viewAdminAppointmentResultPage(Model model) {
//        List<Appointment> listappointment = service.listAll();
//        model.addAttribute("listappointment", listappointment);
//        System.out.print("Get / ");    
//        return "admintestresult";
//    }
	
	@GetMapping("/admindashboard/testresult")
	public String viewAdminAppointmentResultPage(Model model) {
	    List<Appointment> allAppointments = service.listAll();
	    List<Appointment> approvedAppointments = new ArrayList<>();

	    for (Appointment appointment : allAppointments) {
	        if ("approved".equals(appointment.getStatus())) {
	            approvedAppointments.add(appointment);
	        }
	    }

	    model.addAttribute("listappointment", approvedAppointments);
	    System.out.print("Get / ");
	    return "admintestresult";
	}
	
	@GetMapping("/userdashboard/testresult")
	public String viewUserResultPage(Model model) {
	    List<Appointment> allAppointments = service.listAll();
	    List<Appointment> approvedAppointments = new ArrayList<>();

	    for (Appointment appointment : allAppointments) {
	        if ("approved".equals(appointment.getStatus()) && !"pending".equals(appointment.getResult())) {
	            approvedAppointments.add(appointment);
	        }
	    }

	    model.addAttribute("listappointment", approvedAppointments);
	    System.out.print("Get / ");
	    return "userresult";
	}
	
	
	@GetMapping("/userdashboard/appointment/add")
	public String add(Model model) {
		List<Medicaltest> listmedicaltest = Mservice.listAll();
        model.addAttribute("listmedicaltest", listmedicaltest);
	    Appointment defaultAppointment = new Appointment();
	    defaultAppointment.setDate("pending");  
	    defaultAppointment.setTime("pending"); 
	    defaultAppointment.setStatus("pending");
	    defaultAppointment.setResult("pending");

	    model.addAttribute("appointment", defaultAppointment);
	    return "createappointment";
	}
    
    @RequestMapping(value = "/saveadminappointment", method = RequestMethod.POST)
    public String saveAdminappointment(@ModelAttribute("appointment") Appointment appointment) {
    	if (appointment.getResult() == null) {
            appointment.setResult("pending");
        }
        service.save(appointment);
        return "redirect:/admindashboard/appointment";
    }
    
    @RequestMapping(value = "/savetestresult", method = RequestMethod.POST)
    public String saveTestResult(@ModelAttribute("appointment") Appointment appointment) {
    	if (appointment.getResult() == null) {
            appointment.setResult("pending");
        }
        service.save(appointment);
        return "redirect:/admindashboard/testresult";
    }
    
    
    @RequestMapping(value = "/saveappointment", method = RequestMethod.POST)
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        if (appointment.getDate() == null) {
            appointment.setDate("pending");
        }
        if (appointment.getTime() == null) {
            appointment.setTime("pending"); 
        }
        if (appointment.getStatus() == null) {
            appointment.setStatus("pending");
        }
        if (appointment.getResult() == null) {
            appointment.setResult("pending");
        }
        if (appointment.getResult() == null) {
            appointment.setResult("pending");
        }

        service.save(appointment);

        return "redirect:/userdashboard/appointment";
    }
    
    @RequestMapping("/admindashboard/appointment/edit/{id}")
    public ModelAndView showEditAppointmentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editappointment");
        Appointment std = service.get(id);
        mav.addObject("appointment", std);
        mav.addObject("redirectUrl", "/admindashboard/appointment");
        return mav;
    }
    
//    @RequestMapping("/admindashboard/testresult/edit/{id}")
//    public ModelAndView showEditTestResultPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edittestresult");
//        Appointment std = service.get(id);
//        mav.addObject("appointment", std);
//        mav.addObject("redirectUrl", "/admindashboard/testresult");
//        return mav;
//    }
    
    @RequestMapping("/admindashboard/testresult/edit/{id}")
    public ModelAndView showEditTestResultPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edittestresult");
        Appointment appointment = service.get(id);
        mav.addObject("appointment", appointment);
        mav.addObject("redirectUrl", "/admindashboard/testresult");
        return mav;
    }

//    @RequestMapping("/admindashboard/testresult/edit/{id}")
//    public ModelAndView showEditTestResultPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edittestresult");
//        Appointment appointment = service.get(id);
//        mav.addObject("appointment", appointment);
//        mav.addObject("redirectUrl", "/admindashboard/testresult");
//        return mav;
//    }
    
    @RequestMapping("/userdashboard/appointment/delete/{id}")
    public String deleteappointment(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/userdashboard/appointment";
    }

}
