package cn.lph.demo.api.service.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceImpl {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
