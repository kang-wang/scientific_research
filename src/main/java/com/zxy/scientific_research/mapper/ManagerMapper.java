package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Manager;

import java.util.List;

public interface ManagerMapper {
    int deleteByPrimaryKey(String mno);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String mno);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    List findAll();

    int updatePassByPrimaryKey(Manager manager);

    int selectCount();
}