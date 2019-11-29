package com.liuyanzhao.sell.converter;

import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 16:54
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();

        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
