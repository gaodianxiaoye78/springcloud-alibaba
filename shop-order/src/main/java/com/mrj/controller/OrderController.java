package com.mrj.controller;

import com.alibaba.fastjson.JSON;
import com.mrj.domain.Order;
import com.mrj.domain.Product;
import lombok.extern.slf4j.Slf4j;
import com.mrj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{pid}")
    public Order createOrder(@PathVariable("pid") Integer pid) {
        log.info("查询{}号商品信息", pid);
        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
        log.info("查询到的{}号商品信息为:{}", pid, JSON.toJSONString(product));

        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());

        orderService.save(order);
        return order;
    }

}
