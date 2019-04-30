package com.zxy.scientific_research.mapper;

import com.zxy.scientific_research.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(String bno);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bno);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> findAll();

    List<Book> findsByBnos(@Param(value = "list") List list);

    int updateStatusByBno(@Param(value = "bno") String bno, @Param(value = "bstatus") String bstatus);
}