package com.example.controller;

import com.example.domain.RequestDto;
import com.example.domain.ResponseDto;
import com.example.dto.OrderDto;
import com.example.service.IOrderFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/queryOrder")
    @HystrixCommand(fallbackMethod = "queryOrderFallback")
    public ResponseDto<OrderDto> queryOrder(@RequestBody RequestDto<String> requestDto) {
        return orderFeignService.queryOrder(requestDto);
    }

    // 方法签名一定要和api方法（queryOrder）一致
    private ResponseDto<OrderDto> queryOrderFallback(RequestDto<String> requestDto) {
        return new ResponseDto().setCode("500").setMessage("服务器貌似开了个小差~");
    }


}
