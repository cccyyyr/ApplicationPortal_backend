package com.cathychen.ApplicationPortal.service.impl;

import com.cathychen.ApplicationPortal.dao.ApplicantDao;
import com.cathychen.ApplicationPortal.domain.Applicant;
import com.cathychen.ApplicationPortal.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired  
	private ApplicantDao ApplicantDao;
	
	@Override
	public Applicant selectApplicantById(Integer ApplicantId) {
		return ApplicantDao.selectApplicantById(ApplicantId);  
	}

	@Override
	public int insertApplicant(Applicant applicant) {
		return ApplicantDao.insertApplicant(applicant);
	}

	@Override
	public Applicant selectApplicantByEmail(String email) {
		return ApplicantDao.selectApplicantByEmail(email);
	}


}
