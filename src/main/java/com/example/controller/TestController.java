package com.example.controller;

import com.example.domain.Test;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Value("${test.hello:321312312312}")
    @Resource
    private TestService testService;
    private String testHello;
//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello"+testHello;
    };
    @GetMapping("/list")
    public List<Test> list() {
      return testService.list();
    };
    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "hello post"+name;
    }
}
