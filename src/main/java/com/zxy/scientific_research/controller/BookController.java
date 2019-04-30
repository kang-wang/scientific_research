package com.zxy.scientific_research.controller;

import com.zxy.scientific_research.bean.Book;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/10 22:04
 */
@RestController
@RequestMapping(value = "/book/", method = RequestMethod.POST, consumes = "application/json")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @RequestMapping(value = "addBook")
    public ServerResponse<Book> addBook(@RequestBody Map<String,Object> map) {
        return iBookService.addBook(map);
    }

    @RequestMapping(value = "findAll")
    public ServerResponse<List<Book>> findAll() {
        return iBookService.findAll();
    }

    @RequestMapping(value = "findByBno")
    public ServerResponse<Book> findByBno(@RequestParam("bno") String bno) {
        return iBookService.findByBno(bno);
    }

    @RequestMapping(value = "deleteByBno")
    public ServerResponse<String> deleteByBno(@RequestParam("bno") String bno) {
        return iBookService.deleteByBno(bno);
    }

    @RequestMapping(value = "updateByBno")
    public ServerResponse<Book> updateByBno(@RequestBody Book book) {
        return iBookService.updateByBno(book);
    }

    @RequestMapping(value = "findListByTno")
    public ServerResponse<List<Book>> findListByTno(@RequestParam("tno") String tno) {
        return iBookService.findListByTno(tno);
    }

    @RequestMapping(value = "updateStatusByBno")
    public ServerResponse<Integer> updateStatusByBno(@RequestParam(value = "bno") String bno, @RequestParam(value = "bstatus") Integer bstatus) {
        return iBookService.updateStatusByBno(bno, bstatus);
    }
}
