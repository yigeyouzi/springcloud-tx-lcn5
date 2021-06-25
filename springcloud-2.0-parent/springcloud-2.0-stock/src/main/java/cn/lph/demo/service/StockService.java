package cn.lph.demo.service;

import cn.lph.demo.entity.stock;
import cn.lph.demo.repository.StockRepository;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;



    public stock save(stock stock){
     return    stockRepository.save(stock);
    }
    public stock findByCommodityId(int commodityId){
        return    stockRepository.findByCommodityId(commodityId).get(0);
    }


}
