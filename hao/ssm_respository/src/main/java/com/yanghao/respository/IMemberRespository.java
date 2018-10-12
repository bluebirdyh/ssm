package com.yanghao.respository;

import com.yanghao.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*2018/10/12 0012
   杨浩*/
@Repository
public interface IMemberRespository {

    @Select("select * from member where id=#{mebmerId}")
    Member findById(String mebmerId);
}
