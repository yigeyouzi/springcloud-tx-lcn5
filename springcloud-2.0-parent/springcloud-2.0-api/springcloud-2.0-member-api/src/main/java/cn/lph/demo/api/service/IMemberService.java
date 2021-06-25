package cn.lph.demo.api.service;

import cn.lph.demo.api.entity.UserEntity;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IMemberService {

    @RequestMapping("member")
    public UserEntity getMember();

}
