package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.storage.Inventory;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.InventoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    public void insertInventory(Inventory inventory) {
        inventoryMapper.insert(inventory);
    }
    public void deleteInventory(Long id){
        inventoryMapper.deleteById(id);
    }

    public void updateInventory(Inventory inventory){
        inventoryMapper.updateById(inventory);
    }

    public List<Inventory> selectInventory(QueryWrapper<Inventory> wrapper) {
        return inventoryMapper.selectList(wrapper);
    }

    public Inventory getInventory(QueryWrapper<Inventory> wrapper){
        return inventoryMapper.selectOne(wrapper);
    }
}
