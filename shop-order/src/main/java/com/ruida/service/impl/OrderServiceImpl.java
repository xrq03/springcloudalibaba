package com.ruida.service.impl;

import com.ruida.dao.OrderDao;
import com.ruida.domain.Order;
import com.ruida.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
@Autowired
private OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}
