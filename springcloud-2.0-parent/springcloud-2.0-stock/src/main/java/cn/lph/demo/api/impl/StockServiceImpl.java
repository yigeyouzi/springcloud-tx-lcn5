package cn.lph.demo.api.impl;


import cn.lph.demo.api.service.IStockService;
import cn.lph.demo.entity.stock;
import cn.lph.demo.service.StockService;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StockServiceImpl implements IStockService {

    @Resource
    StockService stockService;

    @RequestMapping("stock")
    @Override
    @LcnTransaction(propagation = DTXPropagation.REQUIRED) //分布式事务注解
    @Transactional
    public int invenReduction(@RequestParam("commodityId") int commodityId) {

        stock stock=    stockService.findByCommodityId(commodityId);
       if (stock!=null){
           stock.setStock(stock.getStock()-1);
           stockService.save(stock);
           System.out.println("库存服务减库存成功");
           return stock.getStock();
       }else {
           System.out.println("库存服务减库存失败");
           return -1;
       }



    }

    @Override
    public Object invenReduction() {
        return null;
    }
  /*  @RequestMapping("all")
    @Override
    public Object invenReduction() {
     List<stock> stock=   stockRepository.findAll();
        System.out.println(stock.get(0).toString());
        return stock.get(0).getCommodityId();
    }*/
}
