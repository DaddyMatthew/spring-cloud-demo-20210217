package com.example.controller;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.dto.OrderDto;
import com.example.dto.ProductDto;
import com.example.service.IProductFeignService;
import com.example.service.IProductFeignService2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/api/web")
@Slf4j
public class ProductController {
    @Autowired
    private IProductFeignService productFeignService;
    @Autowired
    private IProductFeignService2 productFeignService2;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/queryProductList")
//    @HystrixCommand(fallbackMethod = "errorQuery")
    public ResponseDto<List<ProductDto>> queryProductList(@RequestBody RequestDto<OrderDto> requestDto) {
        return productFeignService.queryProductList(requestDto);
    }

    @RequestMapping(value = "/queryProductList-2")
    @HystrixCommand(fallbackMethod = "errorQuery", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public ResponseDto<List<ProductDto>> queryProductList2(@RequestBody RequestDto<OrderDto> requestDto) {
        return productFeignService2.queryProductList(requestDto);
    }

    private ResponseDto<List<ProductDto>> errorQuery(@RequestBody RequestDto<OrderDto> requestDto) {
        String sendValue = stringRedisTemplate.opsForValue().get("query_product_list");
        if (StringUtils.isBlank(sendValue)) {
            log.info("@@@@ query product list error, set redis notice {}", requestDto.getBody().getOrderNo());
            stringRedisTemplate.opsForValue().set("query_product_list", requestDto.getBody().getOrderNo(), 20, TimeUnit.SECONDS);
        } else {
            log.info("@@@@ query product list error, already set redis notice {}, wait for 20 seconds", requestDto.getBody().getOrderNo());
        }
        return new ResponseDto<List<ProductDto>>().setCode("500").setMessage("HystrixCommand fallback implement method - 0001");
    }


}
