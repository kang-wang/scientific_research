package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tno);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tno);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> findAll();

    List<Teacher> findListByTname(String tname);

    int updatePassByPrimaryKey(Teacher teacher);

    List<Teacher> findByTnos(Set set);
}