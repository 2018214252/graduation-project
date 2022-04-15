package com.example.graduationproject.entity.basis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("network")
public class Network {
    private Long id;
    private String name;
    private String type;//类型
    private String tel;//固定电话
    private String head;//负责人
    private String mp;//移动电话
    private String address;//地址
    private String city;//城市
    private String state;//状态
}
