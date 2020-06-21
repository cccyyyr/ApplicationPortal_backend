package com.cathychen.ApplicationPortal.api;

import com.cathychen.ApplicationPortal.domain.Application;
import com.cathychen.ApplicationPortal.domain.Reviewer;
import lombok.Data;

@Data
public class ReviewRequest {
    private Application Application;
    private Reviewer reviewer;

    /*
    null -> has not yet reviewed
    true -> pass
    false -> failed
     */
    private Boolean decision;
}
