package com.yanghao.web.controller;

import com.github.pagehelper.PageInfo;
import com.yanghao.domain.UserInfo;
import com.yanghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*2018/10/13 0013
   杨浩*/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService  userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "2") int size){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list=userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("userList",pageInfo);
        mv.setViewName("users-page-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject(userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }
}
