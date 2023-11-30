package com.example.bedemo.controller;

import com.example.bedemo.result.CommonRuntimeException;
import com.example.bedemo.result.ExceptionEnum;
import com.example.bedemo.service.ClockInService;
import com.example.bedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/clockin")
public class clockInController {
    @Autowired
    ClockInService clockInService;
    @Autowired
    UserService userService;
    @PostMapping("/")
    public boolean clockIn(int userId){
        if(userService.getUserById(userId)==null){
            throw new CommonRuntimeException(ExceptionEnum.USER_ERROR);
        }else{
            Date date=new Date(System.currentTimeMillis());
            List<Date> dates=clockInService.getDatebyuser(userId);
            for(Date d:dates){
                if(d.toString().equals(date.toString())){
                    throw new CommonRuntimeException(ExceptionEnum.CLOCKIN_ERROR);

                }
            }
            clockInService.clockIn(userId,date);
            return true;
        }

    }
    @GetMapping("/records")
    public List<Date> getAllClockIn(int userId){
        if(userService.getUserById(userId)==null){
            throw new CommonRuntimeException(ExceptionEnum.USER_ERROR);
        }else{
            return clockInService.getDatebyuser(userId);
        }
    }
}
