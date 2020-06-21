package com.cathychen.ApplicationPortal.service;

import com.cathychen.ApplicationPortal.domain.Application;
import com.cathychen.ApplicationPortal.domain.RAPair;

import java.util.List;
import java.util.Set;

public interface ApplicationService {
	Application selectApplicationById(Integer ApplicationId);

	int insertApplication(Application Application);

	Set<Integer> selectReviewerGroup(Integer ApplicationId);

	void insertReviewer2Application(List<RAPair> list);

	void updateStatus(Boolean newStatus, Integer ApplicationId);
}
