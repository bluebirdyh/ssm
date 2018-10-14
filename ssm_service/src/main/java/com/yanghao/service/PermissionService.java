package com.yanghao.service;

import com.yanghao.domain.Permission;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
public interface PermissionService {
    List<Permission> findAll(int page, int size);

    void save(Permission permission);
}
