package com.example.controller;

import com.example.common.dto.ResponseDto;
import com.example.service.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "/api/productUser/")
public class ProdUserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductFeignService productFeignService;

    @GetMapping(value = "/queryProduct")
    public Object queryProduct() {
        Object o = restTemplate.getForObject("http://product-server/api/product/queryById?product_id=" + "001", Object.class);
        return o;
    }

    @GetMapping(value = "/queryProductRest/{product_id}")
    public Object queryProductRest(@PathVariable(name = "product_id") String product_id) {
        ResponseDto o = productFeignService.queryById(product_id);
        return o;
    }
}
