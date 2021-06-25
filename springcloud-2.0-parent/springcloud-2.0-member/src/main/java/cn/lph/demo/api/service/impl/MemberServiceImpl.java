package cn.lph.demo.api.service.impl;

import cn.lph.demo.api.service.IMemberService;
import cn.lph.demo.api.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements IMemberService {

    @RequestMapping("member")
    @Override
    public UserEntity getMember()
    {

        UserEntity userEntity=new UserEntity();
        userEntity.setAge(22);
        userEntity.setName("小明");
        return userEntity;
    }
}
