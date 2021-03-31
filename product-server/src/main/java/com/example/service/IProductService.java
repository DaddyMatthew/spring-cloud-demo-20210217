package com.example.service;

import com.example.dto.DscOrder;
import com.example.dto.ProductDetailDto;

import java.util.List;

public interface IProductService {

    List<ProductDetailDto> queryProductDetailByOrder(DscOrder dto);
}
