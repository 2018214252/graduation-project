package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.storage.InventoryRecords;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.InventoryRecordsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class InventoryRecordsService {
    @Autowired
    private InventoryRecordsMapper inventoryRecordsMapper;

    public void insertInventoryRecords(InventoryRecords inventoryRecords) {
        inventoryRecordsMapper.insert(inventoryRecords);
    }
    public void deleteInventoryRecords(Long id){
        inventoryRecordsMapper.deleteById(id);
    }

    public void updateInventoryRecords(InventoryRecords inventoryRecords){
        inventoryRecordsMapper.updateById(inventoryRecords);
    }

    public List<InventoryRecords> selectInventoryRecords(QueryWrapper<InventoryRecords> wrapper) {
        return inventoryRecordsMapper.selectList(wrapper);
    }
}
