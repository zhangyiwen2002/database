package com.example.bedemo.service;

import com.example.bedemo.bean.User;
import com.example.bedemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    //添加用户记录
    public void addUser(User user) {
        userMapper.insert(user);
    }
    @Override
    //根据id查找用户信息
    public User getUserById(int id) {
        return userMapper.getOne(id);
    }
    @Override
    //根据手机号查找用户信息
    public User getUserByPhone(String phone){
        return userMapper.getOneByPhone(phone);
    }
    @Override
    //更新用户信息
    public void updateUser(User user){
        userMapper.update(user);
    }
    @Override
    //根据手机号删除用户信息
    public void deleteUserByPhone(String phone){
        User user=userMapper.getOneByPhone(phone);
        userMapper.delete(user.getId());
    }
}
