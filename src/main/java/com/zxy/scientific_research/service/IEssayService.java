package com.zxy.scientific_research.service;

import com.zxy.scientific_research.bean.Essay;
import com.zxy.scientific_research.common.ServerResponse;

import java.util.List;
import java.util.Map;

public interface IEssayService {
    ServerResponse<Essay> findByEno(String eno);

    ServerResponse<List<Essay>> findAll();

    ServerResponse<Essay> addEssay(Map<String, Object> map);

    ServerResponse<String> deleteByEno(String eno);

    ServerResponse<Essay> updateByEno(Essay essay);

    ServerResponse<List<Essay>> findListByTno(String tno);

    ServerResponse<Integer> updateStatusByPno(String eno, Integer estatus);
}
