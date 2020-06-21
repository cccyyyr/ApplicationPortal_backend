package com.cathychen.ApplicationPortal.domain;

import lombok.Data;

@Data
public class Applicant {  
    private Integer ApplicantId;  
    private String ApplicantName;  
    private String ApplicantPassword;  
    private String ApplicantEmail;  

    @Override  
    public String toString() {  
        return "Applicant [ApplicantId=" + ApplicantId + ", ApplicantName=" + ApplicantName  
                + ", ApplicantPassword=" + ApplicantPassword + ", ApplicantEmail=" + ApplicantEmail  
                + "]";  
    }  
      
}  
