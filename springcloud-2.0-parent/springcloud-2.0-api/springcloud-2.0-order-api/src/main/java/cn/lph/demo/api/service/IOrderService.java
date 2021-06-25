package cn.lph.demo.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {

    @RequestMapping("order")
    public String  OrderToMember();

    /**
     * 用户下单后调用库存服务进行扣库存
     *
     * @return
     */
    @GetMapping(value = "/addOrderAndStock")
    public int addOrderAndStock(int i) throws Exception;
}
