package com.yanghao.respository;

import com.yanghao.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*2018/10/12 0012
   杨浩*/
@Repository
public interface IUserInfoRespository {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "statusStr",column = "statusStr"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select ="com.yanghao.respository.IRoleRespository.findByUserId"))
    })
    UserInfo findByUsername(String username);
}
