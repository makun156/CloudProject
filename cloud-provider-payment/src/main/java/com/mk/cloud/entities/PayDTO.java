package com.mk.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    //支付流水号
    private String payNo;
    //支付订单号
    private String orderNo;
    //用户账号id
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
