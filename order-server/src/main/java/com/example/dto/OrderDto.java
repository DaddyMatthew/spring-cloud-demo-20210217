package com.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class OrderDto {
    private String id;
    private String orderNo;
    private List<ProductDto> productList;
}
