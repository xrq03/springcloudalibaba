package com.ruida.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//订单
@Entity(name = "shop_order")//@Entity说明这个class是实体类，并且使用默认的orm规则
@Data//默认不提供get，set方法
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;//订单id
    private Integer uid;//用户id
    private String username;//用户名
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价
    private Integer number;//购买数量
}