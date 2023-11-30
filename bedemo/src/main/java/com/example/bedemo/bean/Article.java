package com.example.bedemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String title;
    private String content;
    private String picturePath;
    private int userId;
    private Date date;
    private int isprivate;

    public Article(String title, String content, String picturePath, int userId, Date date, int isprivate) {
        this.title = title;
        this.content = content;
        this.picturePath = picturePath;
        this.userId = userId;
        this.date = date;
        this.isprivate = isprivate;
    }
}
