package com.ou.service;

import com.ou.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "user-service")
public interface UserService {

    @GetMapping("/user/{id}")
    public User selectId(@PathVariable("id")Integer id);
}
