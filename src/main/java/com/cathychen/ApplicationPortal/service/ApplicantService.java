package com.cathychen.ApplicationPortal.service;

import com.cathychen.ApplicationPortal.domain.Applicant;

public interface ApplicantService {
	Applicant selectApplicantById(Integer ApplicantId);

	int insertApplicant(Applicant applicant);

	Applicant selectApplicantByEmail(String email);
}
