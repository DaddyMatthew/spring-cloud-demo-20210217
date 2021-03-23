package com.example.service.impl;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import com.example.service.IProductFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductFallbackService implements IProductFeignService {
    @Override
    public ResponseDto<List<ProductDto>> queryProductList(RequestDto<OrderDto> requestDto) {
        log.info("@@@@ feign fallback query product list error");
        return new ResponseDto<List<ProductDto>>().setCode("500").setMessage("fallback implement method - 0002");
    }
}
