package com.zxy.scientific_research.service;

import com.zxy.scientific_research.bean.Project;
import com.zxy.scientific_research.common.ServerResponse;

import java.util.List;
import java.util.Map;

public interface IProjectService {
    ServerResponse<List<Project>> findAll();

    ServerResponse<Project> findByPno(String pno);

    ServerResponse<String> deleteByPno(String pno);

    ServerResponse<Project> updateByPno(Project project);

    ServerResponse<List<Project>> findListByTno(String tno);

    ServerResponse<Project> addProject(Map<String, Object> map);

    ServerResponse<Integer> updateStatusByPno(String pno, Integer pstatus);
}
