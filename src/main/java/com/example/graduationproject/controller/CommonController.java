package com.example.graduationproject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.entity.logistics.Delivery;
import com.example.graduationproject.entity.logistics.Order;
import com.example.graduationproject.entity.storage.Warehouse;
import com.example.graduationproject.service.DeliveryService;
import com.example.graduationproject.service.OrderService;
import com.example.graduationproject.service.UserService;
import com.example.graduationproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Api(value = "处理通用操作请求", tags = {"Common"})
@RestController
@RequestMapping("/api/common/")
@Slf4j
public class CommonController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeliveryService deliveryService;

    @ApiOperation("创建账号")
    @PostMapping("user")
    public ResultVO insertUser(@RequestBody User user){
        userService.insertUser(user);
        return ResultVO.success(Map.of());
    }

    @ApiOperation("新建订单")
    @PostMapping("order")
    public ResultVO insertOrder(@RequestBody Order order){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式(年-月-日-时-分-秒)
        String createTime = dateFormat.format(now);//格式化然后放入字符串
        order.setDate(createTime);
        orderService.insertOrder(order);
        return ResultVO.success(Map.of());
    }

    @ApiOperation("查询配送记录")
    @GetMapping("deliverys/{oid}")
    public ResultVO getDeliverys(@PathVariable String oid) {
        QueryWrapper<Delivery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("oid",oid);
        return ResultVO.success(Map.of("deliverys", deliveryService.selectDelivery(queryWrapper)));
    }
}
