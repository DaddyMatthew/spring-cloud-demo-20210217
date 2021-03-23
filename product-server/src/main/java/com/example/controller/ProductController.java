package com.example.controller;

import com.example.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.common.dto.ResponseDto;

import java.util.List;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/queryList")
    public ResponseDto queryProductList() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setBody(ProductDto.createProductList());
        responseDto.setCode(this.serverPort);
        return responseDto;
    }

    @GetMapping(value = "/queryById")
    public ResponseDto queryById(@RequestParam("product_id") String id) {
        List<ProductDto> list = ProductDto.createProductList();
        ProductDto dto = list.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);

        ResponseDto responseDto = new ResponseDto();
        if (dto == null) {
            responseDto.setMessage(String.format("can't found product [%s]", id));
        } else {
            responseDto.setBody(dto);
        }
        responseDto.setCode(this.serverPort);
        return responseDto;
    }
}
