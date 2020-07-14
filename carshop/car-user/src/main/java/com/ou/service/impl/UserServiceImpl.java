package com.ou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ou.dao.UserMapper;
import com.ou.entity.User;
import com.ou.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ou.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Owq
 * @since 2020-06-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User selectOne(User user) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.eq("account",user.getAccount())
                .eq("password",user.getPassword());
        User user1 = mapper.selectOne(Wrapper);
        return user1;
    }
}
