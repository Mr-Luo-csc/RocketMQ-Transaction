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
public class Good {

    private int id;

    private String goodName;

    private int orderId;

}
