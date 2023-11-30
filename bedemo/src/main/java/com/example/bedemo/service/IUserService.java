package com.example.bedemo.service;

import com.example.bedemo.bean.User;

import java.util.List;

public interface IUserService {
    public User getUserById(int id);
    public User getUserByPhone(String phone);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUserByPhone(String phone);
}
