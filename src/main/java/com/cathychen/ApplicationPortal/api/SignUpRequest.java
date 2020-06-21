package com.cathychen.ApplicationPortal.api;

import lombok.Data;

@Data
public class SignUpRequest {
    private Boolean isReviewer;
    private String name;
    private String email;
    private String password;
}
