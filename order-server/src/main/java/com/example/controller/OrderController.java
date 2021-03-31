package com.example.controller;

import com.example.domain.RequestDto;
import com.example.domain.ResponseDto;
import com.example.dto.DscOrder;
import com.example.dto.ProductDetailDto;
import com.example.service.IOrderProductFeignService;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IOrderProductFeignService iOrderProductFeignService;

    @RequestMapping(value = "/queryOrderByNo", method = RequestMethod.POST)
    public ResponseDto<DscOrder> queryOrder(@RequestBody RequestDto<String> requestDto) {
        DscOrder order = iOrderService.queryOrderByNo(requestDto.getBody());
        ResponseDto<List<ProductDetailDto>> productsResponseDto = iOrderProductFeignService.queryProductByOrder(RequestDto.create(order));
        order.setProducts(productsResponseDto.getBody());
        return ResponseDto.<DscOrder>success().setBody(order);
    }
}
