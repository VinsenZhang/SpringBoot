package com.vinsen.http;


public enum ResponseCode {
    Success(200000, "Success"),
    Server_Error(200500, "服务异常"),
    ;

    public int code;

    public String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
