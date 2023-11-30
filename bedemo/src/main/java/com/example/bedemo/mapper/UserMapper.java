package com.example.bedemo.mapper;

import com.example.bedemo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据id查找用户所有信息
    @Select("select * from user where id = #{id}")
    User getOne(@Param("id") int id);
    //根据手机号查找用户所有信息
    @Select("select * from user where phone = #{phone}")
    User getOneByPhone(@Param("phone") String phone);
    //插入一条新的用户信息
    @Insert("insert into user(name,password,phone,headPic) values( #{name},#{password},#{phone},#{headPic} )")
    void insert(User user);
    //获取所有用户信息
    @Select("select * from user")
    public List<User> getAll();
    //根据id更新该条用户信息
    @Update("update user set password=#{password},name=#{name},phone=#{phone},headPic=#{headPic} where id =#{id}")
    void update(User user);
    //根据id删除该条用户信息
    @Delete("delete from user where id =#{id}")
    void delete(@Param("id") int id);
}

