package com.example.service;

import com.example.domain.Test;
import com.example.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// @Service 这个注解意思是 这个service教给spring来管理
@Service
public class TestService {
   @Resource
   private TestMapper testMapper;
   public List<Test> list(){
      return testMapper.list();
   }
}
