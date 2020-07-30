package com.lzp.shoppingcarservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(value = "com.lzp.shoppingcarservice.dao")
@EnableFeignClients(basePackages = "com.lzp.shoppingcarservice.feign")
public class ShoppingCarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCarServiceApplication.class, args);
    }

}
