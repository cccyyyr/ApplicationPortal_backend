package com.cathychen.ApplicationPortal.connectFront;


import com.cathychen.ApplicationPortal.api.LoginRequest;
import com.cathychen.ApplicationPortal.api.ReviewRequest;
import com.cathychen.ApplicationPortal.api.SignUpRequest;
import com.cathychen.ApplicationPortal.domain.*;
import com.cathychen.ApplicationPortal.service.ApplicantService;
import com.cathychen.ApplicationPortal.service.ApplicationService;
import com.cathychen.ApplicationPortal.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ReviewBiz {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private ReviewerService reviewerService;

    public Boolean signUpIsReviewer(SignUpRequest su){
        if(su.getIsReviewer()){
            if(reviewerService.selectReviewerByEmail(su.getEmail()) != null){
                return null;
            }
            Reviewer re = new Reviewer();
            re.setReviewerEmail(su.getEmail());
            re.setReviewerName(su.getName());
            re.setReviewerPassword(su.getPassword());
            reviewerService.insertReviewer(re);
            return true;
        } else {
            if(applicantService.selectApplicantByEmail(su.getEmail()) != null){
                return null;
            }
            Applicant app = new Applicant();
            app.setApplicantEmail(su.getEmail());
            app.setApplicantName(su.getName());
            app.setApplicantPassword(su.getPassword());
            applicantService.insertApplicant(app);
            return false;
        }
    }

    public Boolean loginIsReviewer(LoginRequest li){
        String email = li.getEmail();
        Applicant a = applicantService.selectApplicantByEmail(email);
        Reviewer r = reviewerService.selectReviewerByEmail(email);
        if(a != null){
            return li.getPassword().equals(a.getApplicantPassword())
                    ? false
                    : null;
        } else if (r != null) {
            return li.getPassword().equals(r.getReviewerPassword())
                    ? true
                    : null;
        } else {
            return null;
        }
    }

    public void saveApplication(Application app) {
        int id = app.getApplicationId();
//        if(applicationService.selectApplicationById(id) != null){
//           applicationService.updateApplication(app);
//        }
        applicationService.insertApplication(app);
        List<Reviewer> list = app.getReviewerList();
        List<RAPair> ra = new LinkedList<RAPair>();
        for(Reviewer r: list){
            ra.add(new RAPair(r.getReviewerId(),app.getApplicationId()));
        }
        applicationService.insertReviewer2Application(ra);
    }


    public void saveReview(ReviewRequest rev) {
        Boolean decision = rev.getDecision();
        Integer ApplicationId = rev.getApplication().getApplicationId();
        applicationService.updateStatus(decision,ApplicationId);
    }

    public Set<Integer> getReviewerGroup(int appId){
        return applicationService.selectReviewerGroup(appId);
    }

}
