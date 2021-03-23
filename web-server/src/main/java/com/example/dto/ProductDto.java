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
}
