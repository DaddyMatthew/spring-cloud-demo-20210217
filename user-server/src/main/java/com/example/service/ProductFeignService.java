package com.example.service;

import com.example.common.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVER")
public interface ProductFeignService {

    @GetMapping(value = "/api/product/queryById")
    ResponseDto queryById(@RequestParam("product_id") String id);
}
