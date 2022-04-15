package com.example.graduationproject.entity.basis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("car")
public class Car {
    private Long id;
    private String name;
    private String number;//车牌
    private String driver;//司机
    private String driverPhone;
    private int speed;//车速
    private int loading;//载重
    private String size;//尺寸
    private String date;//出厂日期
    private String state;//状态
}
