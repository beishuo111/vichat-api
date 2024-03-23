package com.beishuo.demo.service;

import com.beishuo.demo.entity.User;
import com.beishuo.demo.mapper.UserMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
     @Resource
     private UserMapper userMapper;

     public User Login(String username, String password){
          QueryWrapper qw = new QueryWrapper();
          qw.eq("username", username);
          qw.eq("password", password);
          User user = userMapper.selectOneByQuery(qw);
          if (user != null) {
               return user;
          } else {
               return null;
          }
     }

     public Number Register(User user){
          QueryWrapper qw=new QueryWrapper();
          qw.eq("username",user.getUsername());
          Object obj= userMapper.selectOneByQuery(qw);
          if (obj==null){
               int user1 = userMapper.insert(user);
               return  user1;
          } else {
               return null;
          }

     }
}
