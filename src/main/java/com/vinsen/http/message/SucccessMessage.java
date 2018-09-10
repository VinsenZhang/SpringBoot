package com.vinsen.http.message;

import com.alibaba.fastjson.JSONObject;
import com.vinsen.http.ResponseCode;

public class SucccessMessage extends Message {

    public SucccessMessage() {
        super(ResponseCode.Success.code, "success", new JSONObject());
    }

    public SucccessMessage(Object object) {
        super(ResponseCode.Success.code, "success", object);
    }
    public SucccessMessage(String successMsg, Object object) {
        super(ResponseCode.Success.code, successMsg, object);
    }
}
