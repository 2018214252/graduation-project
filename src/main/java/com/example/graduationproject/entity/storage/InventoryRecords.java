package com.example.graduationproject.entity.storage;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("inventory_records")
public class InventoryRecords {
    private Long id;
    private int type;//进or出or移库
    private String head;//负责人
    private String name;//农产品名称
    private String whname;//仓库名
    private int quantity;//数量
    private String date;
}
