package com.yanghao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yanghao.domain.Orders;
import com.yanghao.respository.IOrderRespository;
import com.yanghao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private IOrderRespository orderRespository;

    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return orderRespository.findAll(page,size);
    }

    @Override
    public Orders findById(String id) {
        return orderRespository.findById(id);
    }
}
