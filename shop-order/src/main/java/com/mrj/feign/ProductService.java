package com.mrj.feign;

import com.mrj.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("service-product")
public interface ProductService {
    @RequestMapping("/product/{pid}")
    Product getProduct(@PathVariable("pid") Integer pid);
}
