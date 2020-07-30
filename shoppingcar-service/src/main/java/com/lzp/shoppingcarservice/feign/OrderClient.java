package com.lzp.shoppingcarservice.feign;

import com.lzp.shoppingcarservice.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@FeignClient(name = "order-service-application", url = "http://localhost:8081")
public interface OrderClient {

    @PostMapping("/order/makeOrder")
    @ResponseBody
    String makeOrder(@RequestBody Order order);
}
