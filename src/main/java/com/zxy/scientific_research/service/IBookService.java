package com.zxy.scientific_research.service;

import com.zxy.scientific_research.bean.Book;
import com.zxy.scientific_research.common.ServerResponse;

import java.util.List;
import java.util.Map;

public interface IBookService {
    ServerResponse<Book> addBook(Map<String, Object> map);

    ServerResponse<List<Book>> findAll();

    ServerResponse<Book> findByBno(String bno);

    ServerResponse<String> deleteByBno(String bno);

    ServerResponse<Book> updateByBno(Book book);

    ServerResponse<List<Book>> findListByTno(String tno);

    ServerResponse<Integer> updateStatusByBno(String bno, Integer bstatus);
}
