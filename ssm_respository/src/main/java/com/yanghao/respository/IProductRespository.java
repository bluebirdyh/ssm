package com.yanghao.respository;

import com.yanghao.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*2018/10/9 0009
   杨浩*/
@Repository
public interface IProductRespository {

    //@Select("select * from product")
    public List<Product> findAll(int page, int size);

    @Select("select * from product where id=#{productId}")
    public Product findById(String productId);
}
