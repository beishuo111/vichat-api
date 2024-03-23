package com.beishuo.demo.controller;

import com.beishuo.demo.common.Result;
import com.beishuo.demo.entity.User;
import com.beishuo.demo.mapper.UserMapper;
import com.beishuo.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginContorller {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<?> Login(@RequestBody User user) {
        Object o = userService.Login(user.getUsername(), user.getPassword());
        if (o != null) {
            System.out.println(o);
            //存入session
//            session.setAttribute("Identity", "admin");
//            session.setAttribute("User", o);
            return Result.success(o);
        } else {
            return Result.error("-1", "用户名或密码错误");
        }
    }
    @PostMapping("/register")
    public Result<?> Register(@RequestBody User user) {
        Object o = userService.Register(user);
        if (o != null) {
            System.out.println("新增用户"+user);
            return Result.success(o);
        } else {
            return Result.error("-1", "新增失败");
        }
    }
    }


