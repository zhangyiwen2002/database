package com.example.bedemo.result;


public class Result<T> {
    private int code; // 状态码
    private String message; // 结果描述信息
    private T data; // 返回的结果

    //通用成功(带返回结果)
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }


    //通用失败(返回结果为null)
    public static <T> Result<T> fail() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(ResultCode.FAIL.getMessage());
        return result;
    }

    //具体业务失败(返回结果为null)
    public static <T> Result<T> fail(ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }
    //自定义失败
    public static <T> Result<T> fail(int code,String message) {
        return new Result(code,message);
    }
    //构造函数(默认+2个参数的)
    public Result() {
    }
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
    // getter和setter
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}



