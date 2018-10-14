package com.yanghao.web.controller;

import com.github.pagehelper.PageInfo;
import com.yanghao.domain.Permission;
import com.yanghao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                          @RequestParam(name = "size", required = true, defaultValue = "2") int size){
        List<Permission> list=permissionService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(list);
        model.addAttribute("permissionList",pageInfo);
        return "permission-page-list";
    }


    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }

    /**
     * role-add-permission
     * @param id
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll2")
    public String findAll(Model model,
                          @RequestParam(name = "roleId",required = true) String id,
                          @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                          @RequestParam(name = "size", required = true, defaultValue = "2") int size){
        List<Permission> list=permissionService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(list);
        model.addAttribute("permissionList",pageInfo);
        model.addAttribute("roleId",id);
        return "role-add-permission-page-list";
    }
}
