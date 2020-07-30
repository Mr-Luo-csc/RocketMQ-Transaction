package com.lzp.shoppingcarservice.controller;

import com.lzp.shoppingcarservice.model.Order;
import com.lzp.shoppingcarservice.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@RestController
@Slf4j
public class GoodController {

    @Autowired
    private GoodService goodService;

   /* @PostMapping(value = "/good/removeShopCar")
    public String removeShopCar() {

        Order order = new Order();

        try {
            goodService.removeShopCar(order);
        } catch (Exception e) {
            log.error("操作失败,{}", e);
            return "操作失败";
        }

        return "操作成功";
    }*/

}
