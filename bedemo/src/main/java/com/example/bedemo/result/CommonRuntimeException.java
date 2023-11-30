package com.example.bedemo.result;

import lombok.Getter;

@Getter
public class CommonRuntimeException extends RuntimeException{
    private Integer status;

    /**
     * 自己临时自定义状态码和状态信息
     * @param status 状态
     * @param message 状态信息
     */
    public CommonRuntimeException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    /**
     *
     * @param exceptionEnum  从枚举对象中获取状态码和状态信息
     */
    public CommonRuntimeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }

}
