package com.yanghao.respository;

import com.yanghao.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;

import java.util.List;

/*2018/10/9 0009
   杨浩*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_mybatis.xml")
public class IProductRespositoryTest {

    @Autowired
    private IProductRespository productRespository;

    @Test
    public void findAll() throws IOException {
        List<Product> all = productRespository.findAll(page, size);
        System.out.println(all);

    }
}