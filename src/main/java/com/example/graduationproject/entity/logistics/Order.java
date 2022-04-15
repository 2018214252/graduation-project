package com.example.graduationproject.entity.logistics;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("orderr")
public class Order {
    private String id;
    private Long customerNumber;//客户编号
    private String name;//收件人
    private String proName;//产品名称
    private int quantity;//订购数量
    private int unitPrice;//单价
    private int sumPrice;//总价
    private String address;//收货地址
    private String phone;//联系电话
    private String state;//状态
    private String date;//订购日期
    private String feedback;//反馈意见
    private Long deliveryNumber;//配送编号
    private String remark;//备注
    private String warehouse;
    private String car;
    private String driver;
    private String driverPhone;
}
