package com.ds.watchtable.service;

import com.ds.watchtable.dto.OrderDTO;
import com.ds.watchtable.entity.Order;

public interface OrderService {
    default Order dtoToEntity(OrderDTO orderDTO){
        Order order = Order.builder()
                .orderNum(orderDTO.getOrderNum())
                .orderList(orderDTO.getOrderList())
                .build();
        return order;
    }

    default OrderDTO entityToDTO(Order order){
        OrderDTO orderDTO = OrderDTO.builder()
                .orderNum(order.getOrderNum())
                .orderList(order.getOrderList())
                .build();
        return orderDTO;
    }
}
