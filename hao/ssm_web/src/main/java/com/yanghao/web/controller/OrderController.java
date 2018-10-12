package com.yanghao.web.controller;

import com.github.pagehelper.PageInfo;
import com.yanghao.domain.Orders;
import com.yanghao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
    @RequestParam(name = "size", required = true, defaultValue = "2") int size){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("orders-page-list");
        List<Orders> list = orderService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject(pageInfo);
        return mv;
    }

    @RequestMapping("/findById")
    public String findById(Model model,String id){
        Orders orders=orderService.findById(id);
        model.addAttribute(orders);
        return "orders-show";
    }
}
