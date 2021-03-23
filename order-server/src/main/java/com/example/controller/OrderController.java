package com.example.controller;

import com.example.dto.OrderDto;
import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.ProductDto;
import com.example.service.IOrderProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
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
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private IOrderProductFeignService orderProductFeignService;

    @RequestMapping(value = "/queryOrder")
    public ResponseDto<OrderDto> queryOrder(@RequestBody RequestDto<String> dto) {
        OrderDto orderDto = new OrderDto().setId("1").setOrderNo(dto.getBody());
        ResponseDto<List<ProductDto>> productRes = orderProductFeignService.queryProductByOrder(new RequestDto<OrderDto>().setBody(orderDto));
        return new ResponseDto<OrderDto>().setCode("200").setBody(orderDto.setProductList(productRes.getBody()));
    }
}
