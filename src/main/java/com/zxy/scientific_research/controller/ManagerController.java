package com.zxy.scientific_research.controller;

import com.zxy.scientific_research.bean.Manager;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/01 20:04
 */
@RestController
@RequestMapping(value = "/manager/", method = RequestMethod.POST, consumes = "application/json")
public class ManagerController {


    @Autowired
    private IManagerService iManagerService;

    @RequestMapping(value = "register")
    public ServerResponse<Manager> register(@RequestBody Manager manager) {
        return iManagerService.register(manager);
    }
    @RequestMapping(value = "findAll")
    public ServerResponse<List<Manager>> findAll() {
        return iManagerService.findAll();
    }

    @RequestMapping(value = "login")
    public ServerResponse<Manager> login(@RequestBody Manager manager) {
        return iManagerService.login(manager);
    }

    @RequestMapping(value = "updatePass")
    public ServerResponse<String> updatePass(@RequestBody Manager manager) {
        return iManagerService.updatePass(manager);
    }

    @RequestMapping(value = "findByMno")
    public ServerResponse<Manager> findByMno(@RequestParam("mno") String mno) {
        return iManagerService.findByMno(mno);
    }

    @RequestMapping(value = "deleteByMno")
    public ServerResponse<String> deleteByMno(@RequestParam("mno") String mno) {
        return iManagerService.deleteByMno(mno);
    }
}
