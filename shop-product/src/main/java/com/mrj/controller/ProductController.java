package com.mrj.controller;

import com.alibaba.fastjson.JSON;
import com.mrj.domain.Product;
import com.mrj.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product getProduct(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.findById(pid);
        log.info("商品信息查询成功,内容为{}", product);
        return product;
    }

}
