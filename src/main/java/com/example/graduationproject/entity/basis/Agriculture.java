package com.example.graduationproject.entity.basis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("agriculture")
public class Agriculture {
    private Long id;
    private String name;
    private String type;//类型
    private String origin;//产地
    private String manufacturer;//生产商
    private String processor;//加工商
    private String processingtime;//加工日期
    private String effectivedate;//保质期
    private String storage;//储存环境
    private int price;
    private String remark;//备注
    private boolean fresh;
}
