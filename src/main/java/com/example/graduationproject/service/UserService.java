package com.example.graduationproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.basis.Organization;
import com.example.graduationproject.mapper.CarMapper;
import com.example.graduationproject.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;

    public void insertUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.insert(user);
    }

    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    public User getUser(QueryWrapper<User> wrapper) {
        return userMapper.selectOne(wrapper);
    }

    public List<User> selectUsers(QueryWrapper<User> wrapper) {
        return userMapper.selectList(wrapper);
    }
}
