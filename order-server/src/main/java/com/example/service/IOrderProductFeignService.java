package com.example.service;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT-SERVER")
public interface IOrderProductFeignService {

    @PostMapping(value = "/api/order-product/queryProductList")
    ResponseDto<List<ProductDto>> queryProductByOrder(@RequestBody RequestDto<OrderDto> requestDto);
}
