package com.example.graduationproject.entity.basis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("organization")
public class Organization {
    private Long id;
    private String name;
    private String type;//类型
    private String tel;//固定电话
    private String mp;//移动电话
    private String address;//地址
    private Long preid;//上级机构
    private String state;//状态
}
