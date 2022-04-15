package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.basis.Network;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.NetworkMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class NetworkService {
    @Autowired
    private NetworkMapper networkMapper;

    public void insertNetwork(Network network) {
        networkMapper.insert(network);
    }
    public void deleteNetwork(Long id){
        networkMapper.deleteById(id);
    }

    public void updateNetwork(Network network){
        networkMapper.updateById(network);
    }

    public List<Network> selectNetwork(QueryWrapper<Network> wrapper) {
        return networkMapper.selectList(wrapper);
    }
}
