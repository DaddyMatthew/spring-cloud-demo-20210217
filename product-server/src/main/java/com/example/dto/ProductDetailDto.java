package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {
    private Integer id;

    private String name;

    private Double price;

    private String detail;

    private String categoryName;

}
