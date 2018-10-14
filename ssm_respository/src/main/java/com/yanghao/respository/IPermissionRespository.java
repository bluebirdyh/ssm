package com.yanghao.respository;

import com.yanghao.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
@Repository
public interface IPermissionRespository {

    @Select("select * from permission")
    List<Permission> findAll(int page, int size);

    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByRoleId(String id);

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
