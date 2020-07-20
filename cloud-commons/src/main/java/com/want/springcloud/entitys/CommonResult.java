package com.want.springcloud.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author want
 * @createTime 2020.07.15.21:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResult<T> {
    private Integer code;
    private String msg;
    T data;

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(Integer code) {
        this(code,"SUCCESS");
    }

    public CommonResult(T data) {
        this(200,"SUCCESS",data);
    }
}
