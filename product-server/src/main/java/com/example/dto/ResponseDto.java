package com.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Matthew on 2021/2/15
 *
 * @author Matthew
 */
@Data
@Accessors(chain = true)
public class ResponseDto<T> {
    private String code;
    private String message;
    private T body;

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
