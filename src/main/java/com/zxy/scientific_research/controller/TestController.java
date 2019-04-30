package com.zxy.scientific_research.controller;

import com.zxy.scientific_research.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/18 12:52
 */
@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @RequestMapping(value = "testGet", method = RequestMethod.GET)
    public ServerResponse<String> testGet() {
        return ServerResponse.createBySuccessMessage("GET 请求允许访问");
    }

    @RequestMapping(value = "testGetWithParam", method = RequestMethod.GET)
    public ServerResponse<String> testGetWithParam(@RequestParam(value = "no") String no) {
        return ServerResponse.createBySuccess("GET 请求参数允许访问",no);
    }

    @RequestMapping(value = "testPost", method = RequestMethod.POST)
    public ServerResponse<String> testPost() {
        return ServerResponse.createBySuccessMessage("POST 请求允许访问");
    }

    @RequestMapping(value = "testPostParam", method = RequestMethod.POST)
    public ServerResponse<String> testPostParam(@RequestParam(value = "no") String no) {
        return ServerResponse.createBySuccess("POST 请求参数允许访问",no);
    }
}
