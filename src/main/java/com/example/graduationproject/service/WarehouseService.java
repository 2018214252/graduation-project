package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.storage.Warehouse;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.WarehouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    public void insertWarehouse(Warehouse warehouse) {
        warehouseMapper.insert(warehouse);
    }
    public void deleteWarehouse(Long id){
        warehouseMapper.deleteById(id);
    }

    public void updateWarehouse(Warehouse warehouse){
        warehouseMapper.updateById(warehouse);
    }

    public List<Warehouse> selectWarehouse(QueryWrapper<Warehouse> wrapper) {
        return warehouseMapper.selectList(wrapper);
    }

}
