package com.yanghao.service;

import com.yanghao.domain.Role;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
public interface RoleService {
    List<Role> findAll(int page, int size);

    void save(Role role);
}
