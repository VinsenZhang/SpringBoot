package com.vinsen.dao;

import com.vinsen.model.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface ArticleDao {

    Article getArticle(String aid);


    ArrayList<Article> getAll();

}
