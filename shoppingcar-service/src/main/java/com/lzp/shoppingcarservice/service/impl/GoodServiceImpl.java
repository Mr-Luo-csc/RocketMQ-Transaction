package com.lzp.shoppingcarservice.service.impl;

import com.lzp.shoppingcarservice.dao.GoodDao;
import com.lzp.shoppingcarservice.model.Good;
import com.lzp.shoppingcarservice.model.Order;
import com.lzp.shoppingcarservice.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@Service
@Slf4j
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public void removeShopCar(Order order) {

        //更新库之前先查询,实现幂等性
        Good good = goodDao.getByOrderId(order.getId());
        int result = good == null ? -1 : 1;
        if (result > 0) {
            String idsStr = order.getGoodsId();
            String[] split = idsStr.split(",");
            List<Integer> ids = new ArrayList<>();
            for (String s : split) {
                ids.add(Integer.parseInt(s));
            }
            goodDao.removeShopCar(ids);
            log.info("已为订单号码{}的用户购物车商品移除完成.", order.getId());
        } else {
            log.info("购物车商品移除完成,订单已处理:{}", order.getId());
        }
    }

}
