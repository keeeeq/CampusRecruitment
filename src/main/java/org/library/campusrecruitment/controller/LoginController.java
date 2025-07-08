package org.library.campusrecruitment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.library.campusrecruitment.pojo.Login;
import org.library.campusrecruitment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/doLogin")
    public Login doLogin(@RequestParam String username, @RequestParam String password) {
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", password);
        return loginService.getOne(queryWrapper);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Login login) {
        return loginService.save(login);
    }
}