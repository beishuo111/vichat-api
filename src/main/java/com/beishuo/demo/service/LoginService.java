package com.beishuo.demo.service;

import com.beishuo.demo.entity.User;
import com.beishuo.demo.mapper.UserMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;


@Service
public class LoginService extends ServiceImpl<UserMapper,User> {
     @Resource
     private UserMapper userMapper;

     public User Login(String username, String password){
          String encryptedPassword = DigestUtils.md5Hex(password);
          QueryWrapper qw = new QueryWrapper();
          qw.eq("username", username);
          qw.eq("password", encryptedPassword);
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
               //使用MD5加密，防破译可使用加盐方式这里为了简单就单独使用了普通MD5加密的方式
               String encryptedPassword = DigestUtils.md5Hex(user.getPassword());
               user.setPassword(encryptedPassword);
               int user1 = userMapper.insert(user);
               return  user1;
          } else {
               return null;
          }

     }
}
