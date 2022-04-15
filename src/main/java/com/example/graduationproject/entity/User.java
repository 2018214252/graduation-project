package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {
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
}
