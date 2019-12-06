package com.liuyanzhao.sell.service.impl;

import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Anthor: chen
 * Date: 2019/12/6
 * Time: 15:24
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayServiceImpl bestPayService;
    @Override
    public void create(OrderDTO orderDTO) {
        PayRequest payRequest=new PayRequest();
        bestPayService.pay(payRequest);
    }
}
