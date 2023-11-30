package com.example.bedemo.controller;

import com.example.bedemo.bean.Article;
import com.example.bedemo.bean.User;
import com.example.bedemo.result.CommonRuntimeException;
import com.example.bedemo.result.ExceptionEnum;
import com.example.bedemo.result.ExceptionHandlerController;
import com.example.bedemo.service.ArticleService;
import com.example.bedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private static String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static/img/uploadpic/";
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    @GetMapping("/allArticles")
    public List<Article> getAllArticles(){
        List<Article> list=articleService.getAllArticles();
        for(Article o:list){
            Timestamp timestamp = new Timestamp(o.getDate().getTime());
            o.setDate(timestamp);
        }
        return list;
    }
    @GetMapping("/userArticles")
    public List<Article> getUserArticles(int userId,int tag){
        List<Article> list;
        if(userService.getUserById(userId)==null){
            throw new CommonRuntimeException(ExceptionEnum.USER_ERROR);
        }else{
            if(tag==0){
                list=articleService.getArticlesByUser(userId);
            }else{
                list=articleService.getPrivateArticlesByUser(userId);
            }
            return list;
        }


    }
    @GetMapping("/searchByName")
    public List<Article> getArticlesByName(String name){
        List<Article> list=articleService.getArticlesByName(name);
        for(Article o:list){
            String[] realPicPath=o.getPicturePath().split(";");
            String newPicPath="";
        }
        return list;
    }
    @GetMapping("/searchById")
    public Article getArticlesById(int id){
        Article article=articleService.getArticleById(id);

        return article;
    }
    @PostMapping("/add")
    public boolean addArticle(int userId,String title, @RequestParam(defaultValue = "") String content,@RequestParam(value = "file") MultipartFile[] multipartFile,int isprivate){
        if(userService.getUserById(userId)==null){
            throw new CommonRuntimeException(ExceptionEnum.USER_ERROR);
        }else{
            final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static/img/uploadpic/";
            String picturePath="";
            System.out.println(multipartFile.length);
            for(MultipartFile file:multipartFile){
                if ( !file.isEmpty() ) {
                    long size = file.getSize(); //获取文件大小(字节数)
                    if( size > 1024*1024*10 ) { //限制一下大小
                        try {
                            throw new Exception("文件不能大于10M");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    String fname = file.getOriginalFilename(); //获取原始的文件名
//用UUID生成一个随机文件名(扩展名不变) 避免文件同名
                    String newName = UUID.randomUUID().toString() + "." + fname.substring(fname.lastIndexOf(".")+1);

                        picturePath=picturePath+newName+";";


                    File dest_file = new File( UPLOADED_FOLDER + newName ); //Java File类操作
                    try {
                        file.transferTo(dest_file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            System.out.println(formatter.format(date));
            Article article=new Article(title,content,picturePath,userId,date,isprivate);
            articleService.addArticle(article);
            return true;
        }

    }
    @PostMapping("/delete")
    public boolean deleteArticle(int id){
        Article article=articleService.getArticleById(id);
        if(article==null){
            throw new CommonRuntimeException(ExceptionEnum.ARTICLE_ERROR);
        }else{
            articleService.deleteArticle(id);
            String[] realPicPath=article.getPicturePath().split(";");
            for(String path:realPicPath){
                if(!path.equals("")){
                    path=UPLOADED_FOLDER+path;
                    File file=new File(path);
                    file.delete();
                }

            }
            return true;
        }

    }
}
