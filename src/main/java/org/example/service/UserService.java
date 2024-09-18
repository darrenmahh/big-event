package org.example.service;

import org.example.pojo.User;

public interface UserService {
    // 根据用户名寻找是否该用户被占用
    User findByUserName(String username);

    // 注册
    void register(String username, String password);
}
