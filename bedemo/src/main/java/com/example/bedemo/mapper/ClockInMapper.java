package com.example.bedemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.sql.Date;
import java.util.List;

@Mapper
public interface ClockInMapper {
    //根据id查找某用户的所有打卡日期
    @Select("select date from clockin where userId=#{userId}")
    public List<Date> getDatebyuser(@Param("userId") int userId);
    //插入一条用户打卡记录
    @Insert("insert into clockin(userId,date) values (#{userId},#{date})")
    public void clockIn(@Param("userId") int userId,@Param("date") Date date);
}
