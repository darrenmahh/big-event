package org.example.controller;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list(){
        // try {
        //     Map<String, Object> claims = JwtUtil.parseToken(token);
        //     return Result.success("文章列表.....");
        // } catch (Exception e) {
        //     response.setStatus(401);
        //     Result.error("未登录");
        //     throw new RuntimeException(e);
        // }
        return Result.success("文章列表.....");
    }
}
