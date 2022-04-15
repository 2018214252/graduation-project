package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.basis.Network;
import com.example.graduationproject.entity.logistics.Delivery;
import com.example.graduationproject.entity.logistics.Order;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.DeliveryMapper;
import com.example.graduationproject.mapper.NetworkMapper;
import com.example.graduationproject.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;

    public void insertOrder(Order order) {
        order.setId(getLocalTrmSeqNum());
        Delivery delivery = Delivery.builder()
                .oid(order.getId())
                .date(order.getDate())
                .msg("已下单")
                .build();
        deliveryMapper.insert(delivery);
        orderMapper.insert(order);
    }

    public void deleteOrder(Long id) {
        orderMapper.deleteById(id);
    }

    public void updateOrder(Order order) {
        orderMapper.updateById(order);
    }

    public List<Order> selectOrder(QueryWrapper<Order> wrapper) {
        return orderMapper.selectList(wrapper);
    }


    private static int sequence = 0;
    private static int length = 6;

    public static synchronized String getLocalTrmSeqNum() {
        sequence = sequence >= 999999 ? 1 : sequence + 1;
        String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
        String s = Integer.toString(sequence);
        return "CJ"+datetime + addLeftZero(s, length);
    }

    public static String addLeftZero(String s, int length) {
        // StringBuilder sb=new StringBuilder();
        int old = s.length();
        if (length > old) {
            char[] c = new char[length];
            char[] x = s.toCharArray();
            if (x.length > length) {
                throw new IllegalArgumentException(
                        "Numeric value is larger than intended length: " + s
                                + " LEN " + length);
            }
            int lim = c.length - x.length;
            for (int i = 0; i < lim; i++) {
                c[i] = '0';
            }
            System.arraycopy(x, 0, c, lim, x.length);
            return new String(c);
        }
        return s.substring(0, length);
    }

}

