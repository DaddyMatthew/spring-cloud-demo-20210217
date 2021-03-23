package com.example.dto;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@Data
@AllArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private Double price;

    public static List<ProductDto> createProductList(String orderNo) {
        return Lists.newArrayList(
                new ProductDto("1", "椅子A-" + orderNo, 100d),
                new ProductDto("2", "椅子B-" + orderNo, 100d),
                new ProductDto("3", "椅子C-" + orderNo, 100d)
        );
    }

    public static List<ProductDto> createProductList() {
        return Lists.newArrayList(
                new ProductDto("1", "椅子A", 100d),
                new ProductDto("2", "椅子B", 100d),
                new ProductDto("3", "椅子C", 100d)
        );
    }
}
