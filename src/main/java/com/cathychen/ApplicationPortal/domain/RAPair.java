package com.cathychen.ApplicationPortal.domain;

import lombok.Data;

@Data
public class RAPair {
    public int ReviewerId;
    public int ApplicationId;
    public RAPair(int r, int a){
        this.ApplicationId = a;
        this.ReviewerId = r;
    }
}
