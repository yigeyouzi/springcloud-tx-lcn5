package cn.lph.demo.api.fegin;

import cn.lph.demo.api.service.IStockService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client-stock")
public interface StockServiceFegin extends IStockService {
}
