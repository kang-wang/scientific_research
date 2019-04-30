package com.zxy.scientific_research.controller;

import com.zxy.scientific_research.bean.Teacher;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/08 20:46
 */
@RestController
@RequestMapping(value = "/teacher/", method = RequestMethod.POST, consumes = "application/json")
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;

    //注册
    @RequestMapping(value = "register")
    public ServerResponse<Teacher> register(@RequestBody Teacher teacher) {
        return iTeacherService.register(teacher);
    }

    //根据编号查询
    @RequestMapping(value = "findByTno")
    public ServerResponse<Teacher> findByTno(@RequestParam(value = "tno") String tno) {
        return iTeacherService.findByTno(tno);
    }

    //根据编号删除
    @RequestMapping(value = "deleteByTno")
    public ServerResponse<Teacher> deleteByTno(@RequestParam(value = "tno") String tno) {
        return iTeacherService.deleteByTno(tno);
    }

    //查询所有
    @RequestMapping(value = "findAll")
    public ServerResponse<List<Teacher>> findAll() {
        return iTeacherService.findAll();
    }

    //根据姓名查询
    @RequestMapping(value = "findByTname")
    public ServerResponse<List<Teacher>> findByTname(@RequestParam(value = "tname") String tname) {
        return iTeacherService.findByTname(tname);
    }

    //根据条件查询
    @RequestMapping(value = "findByConditions")
    public ServerResponse<List<Teacher>> findByConditions(@RequestBody Map<String,Object> map) {
        return iTeacherService.findByConditions(map);
    }

    //修改密码
    @RequestMapping(value = "updatePass")
    public ServerResponse<String> updatePass(@RequestBody Teacher teacher) {
        return iTeacherService.updatePass(teacher);
    }

    //修改教师信息
    @RequestMapping(value = "updateTeacher")
    public ServerResponse<String> updateTeacher(@RequestBody Teacher teacher) {
        return iTeacherService.updateTeacher(teacher);
    }

    //登录
    @RequestMapping(value = "login")
    public ServerResponse<Teacher> login(@RequestBody Teacher teacher) {
        return iTeacherService.login(teacher);
    }

}
