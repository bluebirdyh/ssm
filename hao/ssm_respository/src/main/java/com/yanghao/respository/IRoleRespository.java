package com.yanghao.respository;

import com.yanghao.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
@Repository
public interface IRoleRespository {

    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    List<Role> findByUserId(String id);
}
