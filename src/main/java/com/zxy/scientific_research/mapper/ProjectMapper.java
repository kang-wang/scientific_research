package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(String pno);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String pno);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> findAll();

    List<Project> findsByPnos(@Param(value = "list") List list);

    int updateStatusByPno(@Param(value = "pno") String pno, @Param(value = "pstatus") String pstatus);
}