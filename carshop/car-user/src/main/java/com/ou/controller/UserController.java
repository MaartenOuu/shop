package com.ou.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ou.dao.UserMapper;
import com.ou.entity.ResultCommon;
import com.ou.entity.User;
import com.ou.service.UserService;
import com.ou.utils.JWTUtil;
import com.ou.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Owq
 * @since 2020-06-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/token")
    @SentinelResource(value = "token")
    public ResultCommon getToken(@RequestBody User user){
        User user1 = userService.selectOne(user);
        HashMap<String, String> map = new HashMap<>();
        if(user1 == null) {
            map.put("errmessage","用戶或密码错误");
            return ResultUtil.error(map);
        }else{
            String token = JWTUtil.createToken(user1.getId());
            map.put("token",token);
            return ResultUtil.success(map);
        }
    }

    @GetMapping("/user/{id}")
    public User selectId(@PathVariable("id") int id){
        return userService.selectId(id);
    }

}

