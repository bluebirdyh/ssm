package com.yanghao.web.controller;

import com.yanghao.domain.Role_permission;
import com.yanghao.service.Role_permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*2018/10/13 0013
   杨浩*/
@Controller
@RequestMapping("role-permission")
public class Role_permissionController {

    @Autowired
    private Role_permissionService role_permissionService;

    @RequestMapping("/save")
    public String add(Role_permission role_permission){
        role_permissionService.save(role_permission);
        return null;
    }
}
