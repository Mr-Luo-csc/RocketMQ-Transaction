package com.lzp.orderservice.dao;

import com.lzp.orderservice.model.TransactionLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/29
 **/
@Repository
public interface TransactionLogDao {

    @Insert(value = "insert into t_rocket_transaction_log value(#{trans.id},#{trans.business},#{trans.orderId})")
    void insert(@Param(value = "trans") TransactionLog transactionLog);

    @Select(value = "select * from t_rocket_transaction_log where id = #{transactionId}")
    TransactionLog query(@Param(value = "transactionId") String transactionId);

}
