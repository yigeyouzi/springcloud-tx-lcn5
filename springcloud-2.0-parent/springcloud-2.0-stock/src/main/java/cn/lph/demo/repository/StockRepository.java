package cn.lph.demo.repository;

import cn.lph.demo.entity.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<stock, Integer>, JpaSpecificationExecutor<stock> {

    List<stock> findByCommodityId(int commodityId);

    List<stock>  findAll();

    stock save(stock stock);

}