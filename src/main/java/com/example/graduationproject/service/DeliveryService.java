package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.logistics.Delivery;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.DeliveryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;

    public void insertDelivery(Delivery delivery) {
        deliveryMapper.insert(delivery);
    }
    public void deleteDelivery(Long id){
        deliveryMapper.deleteById(id);
    }

    public void updateDelivery(Delivery delivery){
        deliveryMapper.updateById(delivery);
    }

    public List<Delivery> selectDelivery(QueryWrapper<Delivery> wrapper) {
        return deliveryMapper.selectList(wrapper);
    }
}
