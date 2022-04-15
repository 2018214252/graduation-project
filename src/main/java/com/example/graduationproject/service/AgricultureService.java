package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Agriculture;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.mapper.AgricultureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class AgricultureService {
    @Autowired
    private AgricultureMapper agricultureMapper;

    public void insertAgriculture(Agriculture agriculture) {
        agricultureMapper.insert(agriculture);
    }
    public void deleteAgriculture(Long id){
        agricultureMapper.deleteById(id);
    }

    public void updateAgriculture(Agriculture agriculture){
        agricultureMapper.updateById(agriculture);
    }

    public List<Agriculture> selectAgriculture(QueryWrapper<Agriculture> wrapper) {
        return agricultureMapper.selectList(wrapper);
    }
}
