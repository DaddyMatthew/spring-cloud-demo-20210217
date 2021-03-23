package com.example.controller;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/api/order-product")
public class OrderProductController {

    @RequestMapping(value = "/queryProductList", method = RequestMethod.POST)
    public ResponseDto<List<ProductDto>> queryProductList(@RequestBody RequestDto<OrderDto> requestDto) throws InterruptedException {
        if (requestDto.getBody().getOrderNo().indexOf("1") > 0) {
            TimeUnit.SECONDS.sleep(4);
        }
        return new ResponseDto<List<ProductDto>>().setCode("200").setBody(this.createProductList(requestDto.getBody().getOrderNo()));
    }

    private List<ProductDto> createProductList(String orderNo) {
        return Lists.newArrayList(
                new ProductDto("1", "椅子A-" + orderNo, 100d),
                new ProductDto("2", "椅子B-" + orderNo, 100d),
                new ProductDto("3", "椅子C-" + orderNo, 100d)
        );
    }
}
