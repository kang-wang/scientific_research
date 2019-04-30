package com.zxy.scientific_research.service;

import com.zxy.scientific_research.bean.Manager;
import com.zxy.scientific_research.common.ServerResponse;

import java.util.List;

public interface IManagerService {

    ServerResponse<Manager> register(Manager manager);

    ServerResponse<List<Manager>> findAll();

    ServerResponse<Manager> login(Manager manager);

    ServerResponse<String> updatePass(Manager manager);

    ServerResponse<Manager> findByMno(String mno);

    ServerResponse<String> deleteByMno(String mno);
}
