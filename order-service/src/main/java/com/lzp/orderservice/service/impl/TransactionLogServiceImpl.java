package com.lzp.orderservice.service.impl;

import com.lzp.orderservice.dao.TransactionLogDao;
import com.lzp.orderservice.model.TransactionLog;
import com.lzp.orderservice.service.TransactionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/29
 **/
@Service
public class TransactionLogServiceImpl implements TransactionLogService {

    @Autowired
    private TransactionLogDao transactionLogDao;

    @Override
    public int query(String transactionId) {
        TransactionLog transactionLog = transactionLogDao.query(transactionId);
        return transactionLog == null ? -1 : 1;
    }

}
