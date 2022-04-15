package com.example.graduationproject.entity.logistics;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("delivery")
public class Delivery {
    private Long id;
    private String oid;
    private String msg;
    private String date;
}
