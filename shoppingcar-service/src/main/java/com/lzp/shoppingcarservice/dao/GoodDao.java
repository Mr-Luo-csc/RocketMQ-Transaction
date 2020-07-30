package com.lzp.shoppingcarservice.dao;

import com.lzp.shoppingcarservice.model.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@Repository
public interface GoodDao {

    @Delete(value = "<script>" +
            "delete from t_rocket_good where id in " +
            "<foreach collection=\"ids\" item=\"id\" open=\"(\" separator=\",\" close=\")\"> #{id} </foreach>" +
            "</script>")
    void removeShopCar(@Param(value = "ids") List<Integer> goodsId);

    @Select(value = "select * from t_rocket_good where id = #{orderId}")
    Good getByOrderId(@Param(value = "orderId") int orderId);

}
