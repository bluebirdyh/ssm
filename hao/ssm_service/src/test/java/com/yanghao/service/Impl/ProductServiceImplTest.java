package com.yanghao.service.Impl;

import com.yanghao.domain.Product;
import com.yanghao.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*2018/10/10 0010
   杨浩*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_spring.xml")
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    @Test
    public void findAll() {
        List<Product> all = productService.findAll(page, size);
        System.out.println(all+"===============");
    }
}