package com.example.service.impl;

import com.example.dto.*;
import com.example.mapper.DscOrderProductListMapper;
import com.example.mapper.DscProductCategoryMapper;
import com.example.mapper.DscProductItemMapper;
import com.example.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    private DscOrderProductListMapper orderProductListMapper;
    @Autowired
    private DscProductCategoryMapper productCategoryMapper;
    @Autowired
    private DscProductItemMapper productItemMapper;

    @Override
    public List<ProductDetailDto> queryProductDetailByOrder(DscOrder dto) {

        DscOrderProductListExample productListExample = new DscOrderProductListExample();
        productListExample.createCriteria().andIdOrderEqualTo(dto.getId());
        List<DscOrderProductList> orderProducts = orderProductListMapper.selectByExample(productListExample);

        List<Integer> idProductItems = orderProducts.stream().map(DscOrderProductList::getIdProductItem).collect(Collectors.toList());
        DscProductItemExample productItemExample = new DscProductItemExample();
        productItemExample.createCriteria().andIdIn(idProductItems);
        List<DscProductItem> productItems = productItemMapper.selectByExample(productItemExample);

        List<Integer> idProductCategories = productItems.stream().map(DscProductItem::getIdProductCategory).collect(Collectors.toList());
        DscProductCategoryExample productCategoryExample = new DscProductCategoryExample();
        productCategoryExample.createCriteria().andIdIn(idProductCategories);
        List<DscProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);

        List<ProductDetailDto> results = productItems.stream().map(i -> {
            DscProductCategory category = productCategories.stream().filter(j -> j.getId().equals(i.getIdProductCategory())).findFirst().orElse(null);
            return new ProductDetailDto()
                    .setId(i.getId()).setName(i.getName()).setPrice(i.getPrice()).setDetail(i.getDetail())
                    .setCategoryName(category.getName());
        }).collect(Collectors.toList());
        return results;
    }
}
