package com.yanghao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanghao.domain.Product;
import com.yanghao.respository.IProductRespository;
import com.yanghao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*2018/10/9 0009
   杨浩*/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private IProductRespository productRespository;

    @Override
    public List<Product> findAll(int page, int size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return productRespository.findAll(page,size);
    }
}
