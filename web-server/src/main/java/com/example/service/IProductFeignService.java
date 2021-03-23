package com.example.service;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import com.example.service.impl.ProductFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "PRODUCT-SERVER", fallback = ProductFallbackService.class)
public interface IProductFeignService {

    @PostMapping(value = "/api/order-product")
    ResponseDto<List<ProductDto>> queryProductList(RequestDto<OrderDto> requestDto);
}
