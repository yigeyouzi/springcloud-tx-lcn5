package cn.lph.demo.entity;



import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "stock")
public class stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY 自增
    private int id;

    private int  commodityId;

    private int stock;


}
