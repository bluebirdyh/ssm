package com.yanghao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yanghao.domain.Permission;
import com.yanghao.respository.IPermissionRespository;
import com.yanghao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private IPermissionRespository permissionRespository;

    @Override
    public List<Permission> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return permissionRespository.findAll(page,size);
    }

    @Override
    public void save(Permission permission) {
        permissionRespository.save(permission);
    }
}
