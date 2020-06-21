package com.cathychen.ApplicationPortal.service.impl;

import com.cathychen.ApplicationPortal.dao.ReviewerDao;
import com.cathychen.ApplicationPortal.domain.Reviewer;
import com.cathychen.ApplicationPortal.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewerServiceImpl implements ReviewerService {
	@Autowired  
	private ReviewerDao ReviewerDao;
	
	@Override
	public Reviewer selectReviewerById(Integer ReviewerId) {
		return ReviewerDao.selectReviewerById(ReviewerId);  
	}

	@Override
	public int insertReviewer(Reviewer Reviewer) {
		return ReviewerDao.insertReviewer(Reviewer);
	}

	@Override
	public Reviewer selectReviewerByEmail(String ReviewerEmail) {
		return ReviewerDao.selectReviewerByEmail(ReviewerEmail);
	}


}
