package com.zxy.scientific_research.service;

import com.zxy.scientific_research.bean.Teacher;
import com.zxy.scientific_research.common.ServerResponse;

import java.util.List;
import java.util.Map;

public interface ITeacherService {
    ServerResponse<Teacher> register(Teacher teacher);

    ServerResponse<Teacher> findByTno(String tno);

    ServerResponse<Teacher> deleteByTno(String tno);

    ServerResponse<List<Teacher>> findAll();

    ServerResponse<List<Teacher>> findByTname(String tname);

    ServerResponse<String> updatePass(Teacher teacher);

    ServerResponse<String> updateTeacher(Teacher teacher);

    ServerResponse<Teacher> login(Teacher teacher);

    //根据条件查询
    ServerResponse<List<Teacher>> findByConditions(Map<String, Object> map);
}
