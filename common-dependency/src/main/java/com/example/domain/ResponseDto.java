package com.example.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@Data
@Accessors(chain = true)
@ToString
public class ResponseDto<T> {
    private String code;
    private String message;
    private T body;

    public static <R> ResponseDto<R> success() {
        return new ResponseDto<R>().setCode("200");
    }
}
