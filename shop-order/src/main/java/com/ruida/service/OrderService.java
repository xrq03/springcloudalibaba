package com.ruida.service;

import com.ruida.domain.Order;

public interface OrderService {
    public void save(Order order);
    //// 将订单信息保存到数据库或者调用其他服务进行处理
}
