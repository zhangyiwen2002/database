package com.example.bedemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
    private String phone;
    private String headPic;
    public User(String name, String password, String phone, String headPic) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.headPic = headPic;
    }

    public User(int id, String name, String password, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

}
