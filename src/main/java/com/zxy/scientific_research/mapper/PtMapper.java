package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Pt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PtMapper {
    int deleteByPrimaryKey(Integer ptno);

    int insert(Pt record);

    int insertSelective(Pt record);

    Pt selectByPrimaryKey(Integer ptno);

    int updateByPrimaryKeySelective(Pt record);

    int updateByPrimaryKey(Pt record);

    //根据教师查询项目
    List<Pt> findListByTno(String tno);
    //根据项目查询教师
    List<Pt> findListByPno(String pno);
    Pt selectByPnoAndTno(@Param(value = "pno") String pno,@Param(value = "tno") String tno);
    //根据pno删除对应教师与项目的对应关系
    int deleteByPno(@Param(value = "pno") String pno);
    //根据tno删除对应教师与项目的对应关系
    int deleteByTno(@Param(value = "tno") String tno);
}