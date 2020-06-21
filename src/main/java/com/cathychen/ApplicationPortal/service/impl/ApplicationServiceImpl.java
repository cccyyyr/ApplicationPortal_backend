package com.cathychen.ApplicationPortal.service.impl;

import com.cathychen.ApplicationPortal.dao.ApplicationDao;
import com.cathychen.ApplicationPortal.domain.Application;
import com.cathychen.ApplicationPortal.domain.RAPair;
import com.cathychen.ApplicationPortal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired  
	private ApplicationDao applicationDao;
	
	@Override
	public Application selectApplicationById(Integer ApplicationId) {
		return applicationDao.selectApplicationById(ApplicationId);
	}

	@Override
	public int insertApplication(Application Application) {
		return applicationDao.insertApplication(Application);
	}

	@Override
	public Set<Integer> selectReviewerGroup(Integer ApplicationId) {
		return applicationDao.selectReviewerGroup(ApplicationId);
	}

	@Override
	public void insertReviewer2Application(List<RAPair> list) {
		applicationDao.insertReviewer2Application(list);
	}

	@Override
	public void updateStatus(Boolean newStatus, Integer ApplicationId) {
		applicationDao.updateStatus(newStatus, ApplicationId);
	}



}
