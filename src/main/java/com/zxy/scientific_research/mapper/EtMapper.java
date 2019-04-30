package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Et;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EtMapper {
    int deleteByPrimaryKey(Integer etno);

    int insert(Et record);

    int insertSelective(Et record);

    Et selectByPrimaryKey(Integer etno);

    int updateByPrimaryKeySelective(Et record);

    int updateByPrimaryKey(Et record);
    //根据教师查询论文
    List<Et> findsListByTno(String tno);
    //根据论文查询教师
    List<Et> findsListByEno(String tno);

    Et selectByEnoAndTno(@Param(value = "eno") String eno, @Param(value = "tno") String tno);
    //根据eno删除对应教师与论文的对应关系
    int deleteByEno(@Param(value = "eno") String eno);
    //根据tno删除对应教师与论文的对应关系
    int deleteByTno(@Param(value = "tno") String tno);
}