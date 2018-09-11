package com.vinsen.model;

import lombok.Data;

/**
 * 文章
 */
@Data
public class Article {

    private int id;

    private int admin_id;

    private int g_id;

    private String top;

    private String set_top;

    private String title;

    private String content;

    private String pic;

    private String type;

    private String is_hot;

    private String show_pv;

    private String primary_url;

}
