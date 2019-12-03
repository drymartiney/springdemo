package com.liuyanzhao.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.entity.OrderDetail;
import com.liuyanzhao.sell.enums.ResultEnum;
import com.liuyanzhao.sell.exception.SellException;
import com.liuyanzhao.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/12/3
 * Time: 10:07
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();

        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转化】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAMS_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
