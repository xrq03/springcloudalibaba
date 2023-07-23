package com.ruida.dao;

import com.ruida.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//在这段代码中，@Repository注解标记了该接口是一个数据访问层的存储库接口。
//接口继承了JpaRepository接口，并使用泛型指定了实体类Order和主键类型为Long
public interface OrderDao extends JpaRepository<Order,Long> {
}
