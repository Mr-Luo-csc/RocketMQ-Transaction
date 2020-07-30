package com.lzp.shoppingcarservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;

    /** 使用 ',' 分割开 **/
    private String goodsId;

    private String userName;

    private float price;
}
