package com.example.service;

import com.example.domain.RequestDto;
import com.example.domain.ResponseDto;
import com.example.dto.DscOrder;
import com.example.dto.ProductDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT-SERVER")
public interface IOrderProductFeignService {

    @PostMapping(value = "/orderProduct/queryProductDetailByOrder")
    ResponseDto<List<ProductDetailDto>> queryProductByOrder(@RequestBody RequestDto<DscOrder> requestDto);

}
