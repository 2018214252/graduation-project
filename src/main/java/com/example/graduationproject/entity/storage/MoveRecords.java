package com.example.graduationproject.entity.storage;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("move_records")
public class MoveRecords {
    private Long id;
    private String head;//负责人
    private String originalWarehouse;//原仓库
    private String targetWarehouse;//目标仓库
    private String date;
}
