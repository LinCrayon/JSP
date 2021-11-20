package com.lsq.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     //@RestController 的意思就是 Controller里面的方法都以 json 格式输出，不用再写什么 jackjson 配置的了！
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
