package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.mapper.CarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public void insertCar(Car car) {
        carMapper.insert(car);
    }
    public void deleteCar(Long id){
        carMapper.deleteById(id);
    }

    public void updateCar(Car car){
        carMapper.updateById(car);
    }

    public List<Car> selectCar(QueryWrapper<Car> wrapper) {
        return carMapper.selectList(wrapper);
    }
}
