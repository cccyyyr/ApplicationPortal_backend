package com.cathychen.ApplicationPortal.tests.serviceTest;


import com.cathychen.ApplicationPortal.domain.Application;
import com.cathychen.ApplicationPortal.domain.RAPair;
import com.cathychen.ApplicationPortal.service.ApplicationService;
import com.cathychen.ApplicationPortal.tests.baseTest.SpringTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.Date;

import static org.junit.Assert.*;

public class ApplicationServiceTest extends SpringTestCase {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired  
    private ApplicationService ApplicationService;
//	@Test
//    public void selectApplicantByIdTest(){
//        Application application = ApplicationService.selectApplicationById(1);
//        System.out.println(application);
//    }
//    @Test
//    public void insertApplicantTest(){
//	    Application app = new Application();
//		app.setApplicationDate(new Date());
//		app.setApplicationDetail("nothing");
//		app.setApplicationPrimaryReviewerID(1);
//		app.setApplicationApplicantID(1);
//		app.setApplicationStatus(null);
//	    int h = ApplicationService.insertApplication(app);
//	    System.out.println(h);
//		Application application = ApplicationService.selectApplicationById(1);
//		System.out.println(application);
//    }

    @Test
	public void insertRAPair(){
		RAPair a = new RAPair(1, 1);
		RAPair b = new RAPair(2, 1);
		RAPair c = new RAPair(1, 3);
		List<RAPair> list = new LinkedList<RAPair>();
		list.add(a);
		list.add(b);
		list.add(c);
		ApplicationService.insertReviewer2Application(list);
	}

	@Test
	public void testReviewerGroup(){
    	Set<Integer> actual = ApplicationService.selectReviewerGroup(1);
    	Set<Integer> expected = new HashSet<Integer>();
    	expected.add(1);
    	expected.add(2);
    	assertEquals(actual, expected);
    }

	@Test
	public void updateApplication(){
		Application app = new Application();
		app.setApplicationDate(new Date());
		app.setApplicationDetail("nothing");
		app.setApplicationPrimaryReviewerID(1);
		app.setApplicationApplicantID(1);
		app.setApplicationStatus(null);
		ApplicationService.insertApplication(app);
		ApplicationService.updateStatus(true, 1);
	}

}
