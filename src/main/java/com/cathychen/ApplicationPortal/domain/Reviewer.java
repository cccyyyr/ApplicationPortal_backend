package com.cathychen.ApplicationPortal.domain;

import lombok.Data;

@Data
public class Reviewer {
    private Integer ReviewerId;
    private String ReviewerName;
    private String ReviewerPassword;
    private String ReviewerEmail;

    @Override
    public String toString() {
        return "Reviewer [ReviewerId=" + ReviewerId + ", ReviewerName=" + ReviewerName
                + ", ReviewerPassword=" + ReviewerPassword + ", ReviewerEmail=" + ReviewerEmail
                + "]";
    }


}
