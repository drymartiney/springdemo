package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 9:54
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrOrderId(String orderId);
}
