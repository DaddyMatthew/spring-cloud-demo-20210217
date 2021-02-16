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

    public static List<ProductDto> createList() {
        return Lists.newArrayList(
                new ProductDto("001", "椅子", 10.5d),
                new ProductDto("002", "桌子", 50.5d),
                new ProductDto("003", "沙发", 100.5d));
    }
}
