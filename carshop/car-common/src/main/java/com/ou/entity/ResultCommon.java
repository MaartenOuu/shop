package com.ou.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResultCommon<T> {

    private Integer code;
    private String message;
    private T data;

    public ResultCommon(Integer code, String message, T data){
       this(code,message);
        this.data=data;
    }

    public ResultCommon(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}
