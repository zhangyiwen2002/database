package com.example.bedemo.service;

import com.example.bedemo.bean.Article;

import java.util.List;

public interface IArticleService {
    public List<Article> getAllArticles();
    public Article getArticleById(int id);
    public List<Article> getArticlesByUser(int userId);
    public List<Article> getPrivateArticlesByUser(int userId);
    public List<Article> getArticlesByName(String title);
    public void addArticle(Article article);
    public void deleteArticle(int id);
}
