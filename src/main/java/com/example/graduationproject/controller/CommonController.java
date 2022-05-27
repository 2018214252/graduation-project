package com.example.graduationproject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.common.Recommend;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.entity.UserDTO;
import com.example.graduationproject.entity.logistics.Delivery;
import com.example.graduationproject.entity.logistics.Order;
import com.example.graduationproject.entity.storage.InventoryRecords;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @Autowired
    private Recommend recommend;


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

    @ApiOperation("查询订单记录")
    @GetMapping("orders/{uid}")
    public ResultVO getOrders(@PathVariable String uid) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_number",uid);
        return ResultVO.success(Map.of("orders", orderService.selectOrder(queryWrapper)));
    }

    @ApiOperation("查询推荐商品")
    @GetMapping("recommend/{uid}")
    public ResultVO getRecommend(@PathVariable Long uid) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_number", uid);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(uid);
        userDTO.setOrders(orderService.selectOrder(queryWrapper));
        //System.out.println(userDTO.getOrders().size());

        List<UserDTO> userdtos = new ArrayList<>();
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        List<User> users = userService.selectUsers(queryWrapper2);
        for(User u:users){
            UserDTO user = new UserDTO();
            user.setId(u.getId());
            QueryWrapper<Order> queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("customer_number", u.getId());
            user.setOrders(orderService.selectOrder(queryWrapper3));
            System.out.println(user.getOrders().size());
            userdtos.add(user);
        }


        return ResultVO.success(Map.of("a", recommend.recommend(userDTO,userdtos)));
    }
}
