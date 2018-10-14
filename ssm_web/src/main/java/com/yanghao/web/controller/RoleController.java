package com.yanghao.web.controller;

import com.github.pagehelper.PageInfo;
import com.yanghao.domain.Role;
import com.yanghao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "2") int size){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-page-list");
        List<Role> list=roleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("roleList",pageInfo);
        return mv;
    };

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }
}
