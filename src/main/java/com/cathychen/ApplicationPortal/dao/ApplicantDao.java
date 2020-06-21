package com.cathychen.ApplicationPortal.dao;

import com.cathychen.ApplicationPortal.domain.Applicant;
import com.cathychen.ApplicationPortal.domain.Application;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicantDao {
    public Applicant selectApplicantById(Integer ApplicantId);

    public int insertApplicant(Applicant applicant);

    void updateApplicant(Application app);

    public Applicant selectApplicantByEmail(String email);
}
