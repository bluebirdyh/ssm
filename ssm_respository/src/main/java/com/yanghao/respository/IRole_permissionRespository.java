package com.yanghao.respository;

import com.yanghao.domain.Role_permission;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/*2018/10/13 0013
   杨浩*/
@Repository
public interface IRole_permissionRespository {

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void save(Role_permission role_permission);
}
