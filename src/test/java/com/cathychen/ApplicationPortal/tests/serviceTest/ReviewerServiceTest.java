package com.cathychen.ApplicationPortal.tests.serviceTest;

import com.cathychen.ApplicationPortal.tests.baseTest.SpringTestCase;
import com.cathychen.ApplicationPortal.domain.Reviewer;
import com.cathychen.ApplicationPortal.service.ReviewerService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewerServiceTest extends SpringTestCase {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired  
    private ReviewerService ReviewerService; 
	@Test  
    public void selectReviewerByIdTest(){  
        Reviewer Reviewer = ReviewerService.selectReviewerById(1);
        System.out.println(Reviewer);
    }
    @Test
    public void insertReviewerTest(){
	    Reviewer Reviewer = new Reviewer();
	    Reviewer.setReviewerEmail("ca@gmail.com");
	    Reviewer.setReviewerName("t");
	    Reviewer.setReviewerPassword("hi");
	    int h = ReviewerService.insertReviewer(Reviewer);
	    System.out.println(h);
    }

}
