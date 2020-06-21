package com.cathychen.ApplicationPortal.tests.serviceTest;


import com.cathychen.ApplicationPortal.domain.Applicant;
import com.cathychen.ApplicationPortal.service.ApplicantService;
import com.cathychen.ApplicationPortal.tests.baseTest.SpringTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ApplicantServiceTest extends SpringTestCase {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired  
    private ApplicantService ApplicantService; 
	@Test  
    public void selectApplicantByIdTest(){  
        Applicant applicant = ApplicantService.selectApplicantById(1);
        System.out.println(applicant);
    }
    @Test
    public void insertApplicantTest(){
	    Applicant applicant = new Applicant();
	    applicant.setApplicantEmail("ca@gmail.com");
	    applicant.setApplicantName("t");
	    applicant.setApplicantPassword("hi");
	    int h = ApplicantService.insertApplicant(applicant);
	    System.out.println(h);
    }

    @Test
	public void selectNull(){
		Applicant a = ApplicantService.selectApplicantById(200);
		assertNull(a);
	}

	@Test
	public void selectApplicantByEmail(){
		String email = "my@gmail";
		Applicant a = ApplicantService.selectApplicantByEmail(email);
		assertTrue(a.getApplicantId()==16);
	}

}
