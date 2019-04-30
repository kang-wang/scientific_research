package com.zxy.scientific_research.controller;

import com.zxy.scientific_research.bean.Essay;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.service.IEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/10 21:01
 */
@RestController
@RequestMapping(value = "/essay/", method = RequestMethod.POST, consumes = "application/json")
public class EssayController {

    @Autowired
    private IEssayService iEssayService;

    @RequestMapping(value = "findByEno")
    public ServerResponse<Essay> findByEno(@RequestParam(value = "eno") String eno) {
        return iEssayService.findByEno(eno);
    }

    @RequestMapping(value = "findAll")
    public ServerResponse<List<Essay>> findAll() {
        return iEssayService.findAll();
    }

    @RequestMapping(value = "addEssay")
    public ServerResponse<Essay> addEssay(@RequestBody Map<String,Object> map) {
        return iEssayService.addEssay(map);
    }

    @RequestMapping(value = "deleteByEno")
    public ServerResponse<String> deleteByEno(@RequestParam("eno") String eno) {
        return iEssayService.deleteByEno(eno);
    }

    @RequestMapping(value = "updateByEno")
    public ServerResponse<Essay> updateByEno(@RequestBody Essay essay) {
        return iEssayService.updateByEno(essay);
    }

    @RequestMapping(value = "findListByTno")
    public ServerResponse<List<Essay>> findListByTno(@RequestParam("tno") String tno) {
        return iEssayService.findListByTno(tno);
    }

    @RequestMapping(value = "updateStatusByEno")
    public ServerResponse<Integer> updateStatusByEno(@RequestParam(value = "eno") String eno, @RequestParam(value = "estatus") Integer estatus) {
        return iEssayService.updateStatusByPno(eno, estatus);
    }
}
