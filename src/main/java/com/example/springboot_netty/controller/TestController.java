package com.example.springboot_netty.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping
    public String test(){
        return "访问成功...";
    }


    /*
        用于ctwing发送消息测试
     */
    @PostMapping
    public void testDevice(@RequestBody Map<String, Object> map){
//        log.info("接收到请求...");
        if (map != null) {
            String result = JSONObject.toJSONString(map);
            log.info("接收到的数据:{}", result);

//            log.info("接收到的数据...");
//            Set<String> strings = map.keySet();
//            System.out.println(strings.size());
//            for (String key : strings) {
//                System.out.print(key + ": ");
//                System.out.println(map.get(key));
//            }
        }else {
            log.info("接收数据失败...");
        }
    }
}
