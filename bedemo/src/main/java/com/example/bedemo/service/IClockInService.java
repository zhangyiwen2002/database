package com.example.bedemo.service;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface IClockInService {
    public List<Date> getDatebyuser(int userId);
    public void clockIn(int userId,Date date);
}
