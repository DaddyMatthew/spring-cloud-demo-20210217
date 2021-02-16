package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "/api/v2/user/")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/queryProduct")
    public Object queryProduct() {
        Object o = restTemplate.getForObject("http://product-server/api/v1/product/queryById?product_id=" + "001", Object.class);
        return o;
    }
}
