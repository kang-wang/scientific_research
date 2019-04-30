package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Bt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BtMapper {
    int deleteByPrimaryKey(Integer btno);

    int insert(Bt record);

    int insertSelective(Bt record);

    Bt selectByPrimaryKey(Integer btno);

    int updateByPrimaryKeySelective(Bt record);

    int updateByPrimaryKey(Bt record);

    //根据教师查询著作
    List<Bt> findListByTno(String tno);
    //根据著作查询教师
    List<Bt> findListByBno(String bno);
    Bt selectByBnoAndTno(@Param(value = "bno") String bno, @Param(value = "tno") String tno);
    //根据bno删除对应教师与著作的对应关系
    int deleteByBno(@Param(value = "bno") String bno);
    //根据tno删除对应教师与著作的对应关系
    int deleteByTno(@Param(value = "tno") String tno);
}