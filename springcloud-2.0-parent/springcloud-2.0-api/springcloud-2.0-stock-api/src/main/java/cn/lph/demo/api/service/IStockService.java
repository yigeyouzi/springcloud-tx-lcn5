package cn.lph.demo.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IStockService {

    @RequestMapping("stock")
    public int invenReduction(@RequestParam("commodityId") int commodityId);

    @RequestMapping("all")
    public Object  invenReduction( );
}
