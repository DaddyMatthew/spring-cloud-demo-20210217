package com.example.service;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ORDER-SERVER")
public interface IOrderFeignService {

    @PostMapping("/api/order/queryOrder")
    ResponseDto<OrderDto> queryOrder(RequestDto<String> requestDto);
}
