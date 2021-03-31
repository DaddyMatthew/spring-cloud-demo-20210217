package com.example.controller;

import com.example.domain.RequestDto;
import com.example.domain.ResponseDto;
import com.example.dto.DscOrder;
import com.example.dto.ProductDetailDto;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderProduct")
public class OrderProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/queryProductDetailByOrder", method = RequestMethod.POST)
    public ResponseDto<List<ProductDetailDto>> queryProductDetailByOrder(@RequestBody RequestDto<DscOrder> requestDto) throws InterruptedException {
        List<ProductDetailDto> products = iProductService.queryProductDetailByOrder(requestDto.getBody());
        return ResponseDto.<List<ProductDetailDto>>success().setBody(products);
    }


}
