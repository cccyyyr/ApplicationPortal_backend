package com.cathychen.ApplicationPortal.service;

import com.cathychen.ApplicationPortal.domain.Reviewer;

public interface ReviewerService {
	Reviewer selectReviewerById(Integer ReviewerId);

	int insertReviewer(Reviewer Reviewer);

	Reviewer selectReviewerByEmail(String ReviewerEmail);
}
