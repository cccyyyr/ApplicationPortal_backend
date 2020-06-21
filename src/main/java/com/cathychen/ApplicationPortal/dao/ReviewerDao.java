package com.cathychen.ApplicationPortal.dao;

import com.cathychen.ApplicationPortal.connectFront.ReviewService;
import com.cathychen.ApplicationPortal.domain.Reviewer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewerDao {
    public Reviewer selectReviewerById(Integer ReviewerId);

    public int insertReviewer(Reviewer Reviewer);

    public Reviewer selectReviewerByEmail(String email);
  
}  
