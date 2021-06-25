package cn.lph.demo.api.service.impl;

import cn.lph.demo.api.fegin.StockServiceFegin;
import cn.lph.demo.api.service.IOrderService;
import cn.lph.demo.api.entity.UserEntity;
import cn.lph.demo.api.fegin.MemberServiceFegin;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "orderToUserInfoFallback")
public class OrderServiceImpl implements IOrderService {
    @Resource
    MemberServiceFegin memberServiceFegin;
    @Resource
    StockServiceFegin stockServiceFegin;
    @HystrixCommand
    @RequestMapping("order")
    @Override
    public String OrderToMember() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       UserEntity userEntity= memberServiceFegin.getMember();
        return "订单服务获取到用户服务信息--------------name:"+userEntity.getName()+"---age:"+userEntity.getAge();
    }

    @Transactional
    @LcnTransaction
    @RequestMapping("addOrder")
    @Override
    public int addOrderAndStock(int i) throws Exception {

            System.out.println("添加订单并减库存，已经进入订单项目，开始减库存");
         int result=      stockServiceFegin.invenReduction(i);
            System.out.println(1/0);
            return result;


    }

    @HystrixCommand
    @GetMapping("/orderToUserInfo")
    public String orderToUserInfoHystrix() {
        System.out.println("orderToUserInfo:" + "当前线程池名称:" + Thread.currentThread().getName());
        UserEntity userEntity= memberServiceFegin.getMember();
        return "订单服务获取到用户服务信息--------------name:"+userEntity.getName()+"---age:"+userEntity.getAge();

    }


    public String orderToUserInfoFallback() {
        return "系统错误!!!!";
    }

}
