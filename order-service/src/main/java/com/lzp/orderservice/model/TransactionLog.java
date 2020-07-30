package com.lzp.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/29
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionLog {

    private String id;

    private String business;

    private int orderId;
}
