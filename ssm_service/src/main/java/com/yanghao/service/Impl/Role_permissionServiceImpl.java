package com.yanghao.service.Impl;

import com.yanghao.domain.Role_permission;
import com.yanghao.respository.IRole_permissionRespository;
import com.yanghao.service.Role_permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*2018/10/13 0013
   杨浩*/
@Service
@Transactional
public class Role_permissionServiceImpl implements Role_permissionService {

    @Autowired
    private IRole_permissionRespository role_permissionRespository;

    @Override
    public void save(Role_permission role_permission) {
        role_permissionRespository.save(role_permission);
    }
}
