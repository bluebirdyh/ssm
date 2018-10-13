package com.yanghao.respository;

import com.yanghao.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
@Repository
public interface ITravellerRespository {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findById(String id);
}
