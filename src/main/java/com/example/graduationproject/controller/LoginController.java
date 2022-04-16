package com.example.graduationproject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.common.EncryptComponent;
import com.example.graduationproject.common.Role;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.entity.logistics.Delivery;
import com.example.graduationproject.service.UserService;
import com.example.graduationproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(value = "处理登录/未登录操作请求")
@RestController
@RequestMapping("/api/")
@Slf4j
public class LoginController {
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User u = userService.getUser(queryWrapper);
        log.debug(user.getUsername());
        log.debug(user.getPassword());
        if (u == null || !encoder.matches(user.getPassword(), u.getPassword())) {
            return ResultVO.error(401, "用户名密码错误");
        }
        String token = encryptComponent.encrypt(Map.of("uid", u.getId(), "role", u.getRole()));
        log.debug(token);
        response.addHeader("token", token);
        return ResultVO.success(Map.of("user", u));
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public ResultVO registered(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        if(userService.getUser(queryWrapper)!=null){
            return ResultVO.error(400,"用户名已注册");
        }
        user.setRole(Role.USER);
        userService.insertUser(user);
        return ResultVO.success(Map.of());
    }
}

