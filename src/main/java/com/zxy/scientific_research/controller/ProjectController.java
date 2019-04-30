package com.zxy.scientific_research.controller;

import com.zxy.scientific_research.bean.Project;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/10 19:57
 */
@RestController
@RequestMapping(value = "/project/", method = RequestMethod.POST, consumes = "application/json")
public class ProjectController {
    @Autowired
    private IProjectService iProjectService;

    @RequestMapping(value = "addProject")
    public ServerResponse<Project> addProject(@RequestBody Map<String,Object> map) {
        return iProjectService.addProject(map);
    }

    @RequestMapping(value = "findAll")
    public ServerResponse<List<Project>> findAll() {
        return iProjectService.findAll();
    }

    @RequestMapping(value = "findByPno")
    public ServerResponse<Project> findByPno(@RequestParam("pno") String pno) {
        return iProjectService.findByPno(pno);
    }

    @RequestMapping(value = "deleteByPno")
    public ServerResponse<String> deleteByPno(@RequestParam("pno") String pno) {
        return iProjectService.deleteByPno(pno);
    }

    @RequestMapping(value = "updateByPno")
    public ServerResponse<Project> updateByPno(@RequestBody Project project) {
        return iProjectService.updateByPno(project);
    }

    @RequestMapping(value = "findListByTno")
    public ServerResponse<List<Project>> findListByTno(@RequestParam("tno") String tno) {
        return iProjectService.findListByTno(tno);
    }

    @RequestMapping(value = "updateStatusByPno")
    public ServerResponse<Integer> updateStatusByPno(@RequestParam(value = "pno") String pno, @RequestParam(value = "pstatus") Integer pstatus) {
        return iProjectService.updateStatusByPno(pno, pstatus);
    }
}
