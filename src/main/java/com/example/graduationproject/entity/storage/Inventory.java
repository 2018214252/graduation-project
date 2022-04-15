package com.example.graduationproject.entity.storage;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("inventory")
public class Inventory {
    private Long id;
    private String name;//农产品名称
    private Long warehouse;//所在仓库
    private String whname;//仓库名
    private int quantity;//数量
    private int price;//单价
}
