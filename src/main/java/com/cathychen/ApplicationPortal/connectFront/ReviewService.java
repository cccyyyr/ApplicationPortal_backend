package com.cathychen.ApplicationPortal.connectFront;

import com.cathychen.ApplicationPortal.Common.Response;
import com.cathychen.ApplicationPortal.Common.Responses;
import com.cathychen.ApplicationPortal.api.LoginRequest;
import com.cathychen.ApplicationPortal.api.ReviewRequest;
import com.cathychen.ApplicationPortal.api.SignUpRequest;
import com.cathychen.ApplicationPortal.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewBiz rb;

    public Response<String> apply(Application request){
        if(request == null){
            return Responses.fail(0, "Application is null");
        }
        if(request.getApplicationStatus() != null){
            return Responses.fail(0, "Application is already reviewed.");
        }
        if(request.getReviewerList().isEmpty()){
            return Responses.fail(0, "There is no reviewer available");
        }
        rb.saveApplication(request);
        return Responses.of("Applied Successfully");
    }

    public Response<Boolean> review(ReviewRequest request){
        if(request == null){
            return Responses.fail(0, "ReviewRequest is null");
        }
        Application ar = request.getApplication();
        if(ar == null){
            return Responses.fail(0, "Application is null");
        }
        Boolean decision = request.getDecision();
        if(decision == null){
            return Responses.fail(0, "Reviewer hasn't made a decision");
        }
        if(ar.getApplicationStatus() != null){
            if(request.getReviewer().getReviewerId() != ar.getApplicationPrimaryReviewerID()) {
                return Responses.fail(0, "Application is already reviewed. You are not authorized to override.");
            } else if (decision == ar.getApplicationStatus()){
                return Responses.fail(0, "Reviewer has not made a change.");
            }
        }
        int applicationId = ar.getApplicationId();
        if(!rb.getReviewerGroup(applicationId).contains(request.getReviewer().getReviewerId())){
            return Responses.fail(0, "Reviewer is not authorized");
        }
        rb.saveReview(request);
        return Responses.of(request.getDecision());
    }

    public Response<Boolean> LogIn(LoginRequest request){
        Boolean logInIsReviewer = rb.loginIsReviewer(request);
        if(logInIsReviewer == null){
            return Responses.fail(0, "User Not Found or Password Not Correct");
        } else if (logInIsReviewer == true){
            return Responses.of(true, "Logged in as Reviewer");
        } else{
            return Responses.of(true, "Logged in as Applicant");
        }
    }

    public Response<Boolean> signUp(SignUpRequest request){
        if(request.getIsReviewer() == null){
            return Responses.fail(0, "Identity not specified");
        } else {
            Boolean isReviewer = rb.signUpIsReviewer(request);
            if(isReviewer == null){
                return Responses.fail(0, "Email already registered. Please log in.");
            }
            if(isReviewer == true){
                return Responses.of(true, "Signed Up as Reviewer");
            } else {
                return Responses.of(true, "Signed Up as Applicant");
            }
        }
    }
}
