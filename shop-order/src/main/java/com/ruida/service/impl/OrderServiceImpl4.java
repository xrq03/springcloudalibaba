package com.ruida.service.impl;

import com.ruida.dao.OrderDao;
import com.ruida.dao.TxLogDao;
import com.ruida.domain.Order;
import com.ruida.domain.TxLog;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl4 {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private TxLogDao txLogDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void createOrderBefore(Order order){
        String txId= UUID.randomUUID().toString();
        //发送半事务消息
        rocketMQTemplate.sendMessageInTransaction(
                "tx_producer_group",
                "tx_topic",
                MessageBuilder.withPayload(order).setHeader("txId",txId).build(),
                order
        );
    }
    @Transactional
    public void createOrder(String txId,Order order){
        orderDao.save(order);
        TxLog txLog=new TxLog();
        txLog.setTxLogId(txId);
        txLog.setDate(new Date());
        txLogDao.save(txLog);
    }
    //模拟发送事务消息

}
