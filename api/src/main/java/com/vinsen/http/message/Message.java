package com.vinsen.http.message;

import lombok.Data;

@Data
public class Message {

    public int code;

    public String message;

    public Object data;

    public Message() {
    }

    public Message(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
