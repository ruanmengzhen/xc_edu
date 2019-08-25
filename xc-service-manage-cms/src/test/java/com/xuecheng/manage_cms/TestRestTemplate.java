package com.xuecheng.manage_cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 测试 restTemplate
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRestTemplate {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRestTemplate(){
        ResponseEntity<Map> map = restTemplate.getForEntity("http://localhost:31001//cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        System.out.println(map);
    }
}
