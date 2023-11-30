package com.example.bedemo.controller;

import com.example.bedemo.bean.User;
import com.example.bedemo.result.CommonRuntimeException;
import com.example.bedemo.result.ExceptionEnum;
import com.example.bedemo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public int register(String name,String password,String phone,@RequestParam("file") MultipartFile file) throws Exception{
        User user=new User();
        if(phone!=null){
            if(userService.getUserByPhone(phone)!=null){
                throw new CommonRuntimeException(ExceptionEnum.PHONE_DUPLICATED);
            }else{
                user.setPhone(phone);
            }
        }
        if ( !file.isEmpty() ) {
            final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static/img/headpic/";
            long size = file.getSize(); //获取文件大小(字节数)
            if( size > 1024*1024*10 ) { //限制一下大小
                throw new Exception("文件不能大于10M");
            }
            String fname = file.getOriginalFilename(); //获取原始的文件名
//用UUID生成一个随机文件名(扩展名不变) 避免文件同名
            String newName = UUID.randomUUID().toString() + "." + fname.substring(fname.lastIndexOf(".")+1);
            if(newName==null||newName.equals("")){
                user.setHeadPic("2b1bbaac380942d0d1ed33087e84093a.jpeg");
            }else{
                user.setHeadPic(newName);
            }

            File dest_file = new File( UPLOADED_FOLDER + newName ); //Java File类操作
            file.transferTo(dest_file);
        }

            user.setName(name);


            user.setPassword(password);

        userService.addUser(user);
        return userService.getUserByPhone(phone).getId();
    }
    @PostMapping("/login")
    public int login(String phone,String password){
        User user=userService.getUserByPhone(phone);
        if(user==null){
            throw new CommonRuntimeException(ExceptionEnum.PHONE_NOT_FOUND);
        }else if(password.equals(user.getPassword())==false){
            throw new CommonRuntimeException(ExceptionEnum.PASSWORD_ERROR);
        }else{
            return userService.getUserByPhone(phone).getId();
        }
    }
    @PostMapping("/update")
    public boolean updateMessage(int id,@RequestParam(required = false) String name,@RequestParam(required = false) String password,@RequestParam(required = false) String phone,@RequestParam("file") MultipartFile file) throws Exception{
        User user=userService.getUserById(id);
        if(user==null){
            throw new CommonRuntimeException(ExceptionEnum.USER_ERROR);
        }else{
            if(phone!=null){
                if(userService.getUserByPhone(phone)!=null){
                    throw new CommonRuntimeException(ExceptionEnum.PHONE_DUPLICATED);
                }else{
                    user.setPhone(phone);
                }
            }
            if ( !file.isEmpty() ) {
                final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static/img/headpic/";
                if(!user.getHeadPic().equals("2b1bbaac380942d0d1ed33087e84093a.jpeg")){
                    File f =new File(UPLOADED_FOLDER+user.getHeadPic());
                    f.delete();
                }
                long size = file.getSize(); //获取文件大小(字节数)
                if( size > 1024*1024*10 ) { //限制一下大小
                    throw new Exception("文件不能大于10M");
                }
                String fname = file.getOriginalFilename(); //获取原始的文件名
//用UUID生成一个随机文件名(扩展名不变) 避免文件同名
                String newName = UUID.randomUUID().toString() + "." + fname.substring(fname.lastIndexOf(".")+1);
                if(newName!=null&&!newName.equals("")){
                    user.setHeadPic(newName);
                }

                File dest_file = new File( UPLOADED_FOLDER + newName ); //Java File类操作
                file.transferTo(dest_file);
            }
            if(name!=null){
                user.setName(name);
            }
            if(password!=null){
                user.setPassword(password);
            }
            userService.updateUser(user);
            return true;
        }
    }
    @GetMapping("/message")
    public User getMessage(int id){
        User user=userService.getUserById(id);

        return user;
    }
}
