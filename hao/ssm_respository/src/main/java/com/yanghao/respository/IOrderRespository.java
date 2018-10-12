package com.yanghao.respository;

import com.yanghao.domain.Member;
import com.yanghao.domain.Orders;
import com.yanghao.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*2018/10/10 0010
   杨浩*/
@Repository
public interface IOrderRespository {

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yanghao.respository.IProductRespository.findById"))
            //@Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.yanghao.respository.IMemberRespository.findById")),
            //@Result(property = "travellers", column = "id", javaType = java.util.List.class,many = @Many(select = "com.yanghao.respository.ITravellerRespository.findById"))
    })
    public List<Orders> findAll(int page,int size);


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yanghao.respository.IProductRespository.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.yanghao.respository.IMemberRespository.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class,many = @Many(select = "com.yanghao.respository.ITravellerRespository.findById"))
    })
    Orders findById(String id);
}


