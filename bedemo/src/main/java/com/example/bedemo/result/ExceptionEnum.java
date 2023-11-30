package com.example.bedemo.result;


import lombok.Getter;

@Getter
public enum ExceptionEnum {
    //系统异常
    USER_ERROR(4000,"该用户不存在"),
    ARTICLE_ERROR(4000,"该文章不存在"),
    CLOCKIN_ERROR(4000,"当日重复打卡"),
    //注册失败
    PHONE_DUPLICATED(4001,"手机号已被注册"),

    //登录失败
    PHONE_NOT_FOUND(4002,"手机号不存在，请注册"),
    PASSWORD_ERROR(4002,"密码错误");

    private int status;
    private String message;

    //枚举对象中的构造方法不能为public，不能被外部调用
    ExceptionEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
