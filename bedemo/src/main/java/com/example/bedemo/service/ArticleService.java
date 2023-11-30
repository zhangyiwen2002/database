package com.example.bedemo.service;

import com.example.bedemo.bean.Article;
import com.example.bedemo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService{
    @Autowired
    ArticleMapper articleMapper;
    @Override
    //查找所有的帖子信息
    public List<Article> getAllArticles(){
        return articleMapper.getAllArticles();
    }
    @Override
    //根据id查找帖子信息
    public Article getArticleById(int id){
        return articleMapper.getArticleById(id);
    }
    @Override
    //根据用户id查找给用户发表的所有帖子信息
    public List<Article> getArticlesByUser(int userId){
        return articleMapper.getArticleByUserId(userId);
    }
    @Override
    //根据帖子名称搜索帖子
    public List<Article> getArticlesByName(String title){
        title="%"+title+"%";
        return articleMapper.getArticleByName(title);
    }
    @Override
    //根据用户id查找给用户发表的私密帖子信息
    public List<Article> getPrivateArticlesByUser(int userId) {
        return articleMapper.getPrivateArticleByUserId(userId);
    }
    @Override
    //添加一条信息的帖子记录
    public void addArticle(Article article){
        articleMapper.addArticle(article);
    }
    @Override
    //根据帖子id删除帖子
    public void deleteArticle(int id){
        articleMapper.deleteArticleById(id);
    }
}
