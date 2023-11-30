package com.example.bedemo.mapper;

import com.example.bedemo.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    //查找所有非私密的帖子信息
    @Select("select * from article where isprivate=0")
    public List<Article> getAllArticles();
    //根据id查找帖子信息
    @Select("select * from article where id=#{id}")
    public Article getArticleById(@Param("id") int id);
    //根据用户id查找该用户发表的所有帖子
    @Select("select * from article where userId=#{userId}")
    public List<Article> getArticleByUserId(@Param("userId") int UserId);
    //根据用户id查找该用户发表的非私密帖子
    @Select("select * from article where title like #{title} and isprivate=0")
    public List<Article> getArticleByName(@Param("title") String title);
    //根据用户id查找该用户发表的私密帖子
    @Select("select * from article where userId=#{userId} and isprivate=1")
    public List<Article> getPrivateArticleByUserId(@Param("userId") int UserId);
    //插入一条帖子信息
    @Insert("insert into article(title,content,picturePath,userId,date,isprivate) values (#{title},#{content},#{picturePath},#{userId},#{date},#{isprivate})")
    public void addArticle(Article article);
    //根据id删除一条帖子信息
    @Delete("delete from article where id=#{id}")
    public void deleteArticleById(@Param("id") int id);
}
