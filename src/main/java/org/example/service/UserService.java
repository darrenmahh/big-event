package org.example.service;

import org.example.pojo.User;

public interface UserService {
    // 根据用户名寻找是否该用户被占用
    User findByUserName(String username);

    // 用户注册
    void register(String username, String password);

    // 更新用户信息
    void update(User user);
}
