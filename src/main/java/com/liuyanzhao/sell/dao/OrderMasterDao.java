package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 9:53
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenId(String buyerOpenid, Pageable pageable);
}
