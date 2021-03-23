package com.example.service.impl;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import com.example.service.IProductFeignService;

import java.util.List;

public class ProductFallbackService implements IProductFeignService {
    @Override
    public ResponseDto<List<ProductDto>> queryProductList(RequestDto<OrderDto> requestDto) {
        System.out.println("feign fallback query product list error");
        return null;
    }
}
