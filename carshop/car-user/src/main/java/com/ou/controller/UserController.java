package com.ou.controller;


import com.ou.dao.UserMapper;
import com.ou.entity.ResultCommon;
import com.ou.entity.User;
import com.ou.service.UserService;
import com.ou.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
    private com.ou.dao.UserMapper UserMapper;

    @GetMapping("/select")
    public ResultCommon selectAll(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        List<User> users = UserMapper.selectByMap(map);
        return ResultUtils.success(users);
    }

}

