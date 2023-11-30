package com.example.bedemo.service;

import com.example.bedemo.mapper.ClockInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;
@Service
public class ClockInService {
    @Autowired
    ClockInMapper clockInMapper;
    //根据userId查找用户的打卡记录
    public List<Date> getDatebyuser(int userId){
        List<Date> dates=clockInMapper.getDatebyuser(userId);
        return dates;
    }
    //用户打卡
    public boolean clockIn(int userId,Date date){
        clockInMapper.clockIn(userId,date);
        return true;
    }
}
