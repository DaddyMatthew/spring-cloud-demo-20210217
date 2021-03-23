package com.example.controller;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import com.example.service.IOrderFeignService;
import com.example.service.IProductFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "/api/web")
public class OrderController {

    @Autowired
    private IOrderFeignService orderFeignService;
    @Autowired
    private IProductFeignService productFeignService;

    @RequestMapping(value = "/queryOrder")
    @HystrixCommand(fallbackMethod = "queryOrderFallback")
    public ResponseDto<OrderDto> queryOrder(@RequestBody RequestDto<String> requestDto) {
        return orderFeignService.queryOrder(requestDto);
    }

    // 方法签名一定要和api方法（queryOrder）一致
    private ResponseDto queryOrderFallback(RequestDto<String> requestDto) {
        return new ResponseDto().setCode("500").setMessage("服务器貌似开了个小差~");
    }

    @RequestMapping(value = "/queryProductList")
    public ResponseDto<List<ProductDto>> queryProductList(@RequestBody RequestDto<OrderDto> requestDto) {
        return productFeignService.queryProductList(requestDto);
    }
}
