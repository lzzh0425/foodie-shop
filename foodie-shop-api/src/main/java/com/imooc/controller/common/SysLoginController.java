package com.imooc.controller.common;

import com.imooc.entitys.security.LoginBody;
import com.imooc.service.UsersService;
import com.imooc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 登录验证
 * @author TryAgain404
 */
@RestController
public class SysLoginController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public R login(@RequestBody LoginBody loginBody) {
        // 生成令牌
        String token = usersService.login(loginBody);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", token);
        return R.success(map);
    }

    @GetMapping("/mobile/login")
    public R mobile(@RequestParam String mobile, @RequestParam String code) {
        // 生成令牌
        String token = usersService.mobileLogin(mobile, code);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", token);
        return R.success(map);
    }
}
