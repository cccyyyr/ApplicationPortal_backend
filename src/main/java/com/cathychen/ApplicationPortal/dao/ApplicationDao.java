package com.cathychen.ApplicationPortal.dao;

import com.cathychen.ApplicationPortal.domain.Application;
import com.cathychen.ApplicationPortal.domain.RAPair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface ApplicationDao {
    public Application selectApplicationById(Integer applicationId);

    public int insertApplication(Application application);

    public Set<Integer> selectReviewerGroup(@Param("id") Integer id);

    public void insertReviewer2Application(List<RAPair> list);

    public void updateStatus(@Param("a") Boolean a, @Param("b") Integer b);
}
