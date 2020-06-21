package com.cathychen.ApplicationPortal.tests.serviceTest;

import com.cathychen.ApplicationPortal.Common.Response;
import com.cathychen.ApplicationPortal.Common.Responses;
import com.cathychen.ApplicationPortal.api.LoginRequest;
import com.cathychen.ApplicationPortal.api.SignUpRequest;
import com.cathychen.ApplicationPortal.connectFront.ReviewService;
import com.cathychen.ApplicationPortal.tests.baseTest.SpringTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.font.TrueTypeFont;

public class ReviewServiceTest extends SpringTestCase {
    @Autowired
    ReviewService rs;

    @Test
    public void testSignUp(){
        SignUpRequest request = new SignUpRequest();
        request.setIsReviewer(false);
        request.setEmail("my@gmail");
        request.setName("kap");
        request.setPassword("doh");
        rs.signUp(request);
    }

    @Test
    public void signUpAsReviewer(){
        SignUpRequest request = new SignUpRequest();
        request.setIsReviewer(true);
        request.setEmail("not@gmail");
        request.setName("kap");
        request.setPassword("doh");
        rs.signUp(request);
    }

    @Test
    public void testLogInAsReviewer(){
        LoginRequest request = new LoginRequest();
        request.setEmail("not@gmail");
        request.setPassword("doh");
        System.out.println(rs.LogIn(request));
    }
    @Test
    public void testLogIn(){
        LoginRequest request = new LoginRequest();
        request.setEmail("my@gmail");
        request.setPassword("doh");
        System.out.print(rs.LogIn(request));
    }

    @Test
    public void testSignUpAlready(){
        SignUpRequest request = new SignUpRequest();
        request.setIsReviewer(true);
        request.setEmail("not@gmail");
        request.setName("kap");
        request.setPassword("doh");
        System.out.println(rs.signUp(request));
    }
}
