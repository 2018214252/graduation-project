package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.graduationproject.entity.logistics.Order;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private int role;
    private int level;
    private String name;
    private String sex;
    private String phone;
    private String mailbox;//邮箱
    private String cardno;//身份证号
    private List<Order> orders;
}
