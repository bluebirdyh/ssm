package com.yanghao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yanghao.domain.Role;
import com.yanghao.respository.IRoleRespository;
import com.yanghao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRoleRespository roleRespository;

    @Override
    public List<Role> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return roleRespository.findAll(page,size);
    }

    @Override
    public void save(Role role) {
        roleRespository.save(role);
    }
}
