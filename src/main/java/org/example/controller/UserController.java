package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){

            User u = userService.findByUserName(username);

            if (u == null) {
                userService.register(username, password);
                return Result.success();
            } else {
                return Result.error("用户名已被占用");
            }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){
    //     根据用户名查询用户
        User u = userService.findByUserName(username);

        //     判断用户是否存在
        if(u.getId() != null){
            if(Objects.equals(u.getPassword(), Md5Util.getMD5String(password))){
                return Result.success("jwt 令牌");
            } else {
                return Result.error("密码错误");
            }
        } else {
            return Result.error("用户不存在");
        }
    //     判断密码是否正确

    }
}
