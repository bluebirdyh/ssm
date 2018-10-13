package com.yanghao.service;

import com.yanghao.domain.Orders;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
public interface OrderService {
    List<Orders> findAll(int page,int size);

    Orders findById(String id);
}
