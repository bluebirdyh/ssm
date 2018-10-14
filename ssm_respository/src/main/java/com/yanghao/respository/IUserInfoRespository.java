package com.yanghao.respository;

import com.yanghao.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("select * from users")
    List<UserInfo> findAll(int page, int size);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "statusStr",column = "statusStr"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yanghao.respository.IRoleRespository.findByUserId"))
    })
    UserInfo findById(String id);

    @Insert("insert into users(username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);
}
