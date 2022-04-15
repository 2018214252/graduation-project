package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.storage.MoveRecords;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.MoveRecordsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class MoveRecordsService {
    @Autowired
    private MoveRecordsMapper moveRecordsMapper;

    public void insertMoveRecords(MoveRecords moveRecords) {
        moveRecordsMapper.insert(moveRecords);
    }

    public void deleteMoveRecords(Long id) {
        moveRecordsMapper.deleteById(id);
    }

    public void updateMoveRecords(MoveRecords moveRecords) {
        moveRecordsMapper.updateById(moveRecords);
    }

    public List<MoveRecords> selectMoveRecords(QueryWrapper<MoveRecords> wrapper) {
        return moveRecordsMapper.selectList(wrapper);
    }
}
