package com.vinsen.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhangshengwen
 */
@Data
public class User {

    private int id;

    private int tj_id;

    private int tj_tj_id;

    private String phone;

    private BigDecimal money;

    private String nickname;

    private String ip;

    private String source;

    private String kou;

    private String fix_kou;

    private String time;

    private String activation_time;

    private int status;

    private int closure_time;

    private String openid;

    private String unionid;

    private String portrait;

    private String token;

    private int read_amount;
}
