package com.example.bedemo.result;

public enum ResultCode {
    //通用状态码
    SUCCESS(200, "成功"),
    FAIL(-1, "失败"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错"),
    //业务状态码
    PHONE_NOT_FOUND(4001,"id不存在"),
    PHONE_DUPLICATED(4002,"手机号重复");
    private int code;
    private String message;
    // 构造函数和getter方法
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
