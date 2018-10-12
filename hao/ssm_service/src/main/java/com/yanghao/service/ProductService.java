package com.yanghao.service;

import com.yanghao.domain.Product;

import java.util.List;

/*2018/10/9 0009
   杨浩*/

public interface ProductService {

    public List<Product> findAll(int page, int size);
}
