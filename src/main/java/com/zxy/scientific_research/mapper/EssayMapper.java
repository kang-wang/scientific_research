package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Essay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EssayMapper {
    int deleteByPrimaryKey(String eno);

    int insert(Essay record);

    int insertSelective(Essay record);

    Essay selectByPrimaryKey(String eno);

    int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);

    List<Essay> findAll();

    List<Essay> findsByEnos(@Param(value = "list") List list);

    int updateStatusByEno(@Param(value = "eno") String eno, @Param("estatus") String s);
}