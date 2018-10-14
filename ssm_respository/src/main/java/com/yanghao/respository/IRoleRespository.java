package com.yanghao.respository;

import com.yanghao.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
@Repository
public interface IRoleRespository {

    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yanghao.respository.IPermissionRespository.findByRoleId"))
    })
    List<Role> findByUserId(String id);

    @Select("select * from role")
    List<Role> findAll(int page, int size);

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
