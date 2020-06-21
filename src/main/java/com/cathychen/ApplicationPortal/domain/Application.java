package com.cathychen.ApplicationPortal.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Application {
    private Integer ApplicationId;

    private Integer ApplicationApplicantID;

    private String ApplicationDetail;

    private Date ApplicationDate;

    private List<Reviewer> reviewerList;

    private Integer ApplicationPrimaryReviewerID;

    private Boolean ApplicationStatus;
}
