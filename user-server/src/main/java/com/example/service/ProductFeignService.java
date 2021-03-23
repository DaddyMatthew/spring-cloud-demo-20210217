package com.example.controller;

import com.example.common.dto.ResponseDto;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "PRODUCT-SERVER")
public interface ProductFeignController {

    @RequestMapping(value = "/api/v1/product/queryById")
    ResponseDto queryById(@Param("product_id") String id);
}
