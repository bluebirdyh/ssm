package com.yanghao.web.controller;

import com.github.pagehelper.PageInfo;
import com.yanghao.domain.Product;
import com.yanghao.service.Impl.ProductServiceImpl;
import com.yanghao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*2018/10/9 0009
   杨浩*/
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(Model model,@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                          @RequestParam(name = "size", required = true, defaultValue = "2") int size){
        List<Product> all = productService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(all);
        model.addAttribute("pageInfo",pageInfo);
        return "product-list";
    }
}
