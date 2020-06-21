package com.cathychen.ApplicationPortal.web;

import com.cathychen.ApplicationPortal.domain.Applicant;
import com.cathychen.ApplicationPortal.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired 
	private ApplicantService applicantService;
	@RequestMapping(value = "")
	public String getIndex(Model model){      
        Applicant applicant = applicantService.selectApplicantById(1);
        model.addAttribute("Applicant", applicant);
        return "index";    
    } 
}
