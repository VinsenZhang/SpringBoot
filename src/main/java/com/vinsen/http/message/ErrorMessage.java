package com.vinsen.http.message;

import com.alibaba.fastjson.JSONObject;

public class ErrorMessage extends Message {

    public ErrorMessage() {
        super(0, "error", new JSONObject());
    }

    public ErrorMessage(String errMsg, Object object) {
        super(0, errMsg, object);
    }
}
