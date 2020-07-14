package com.ou.controller;

import com.ou.entity.Car;
import com.ou.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Car)表控制层
 *
 * @author makejava
 * @since 2020-06-10 16:40:26
 */
@RestController
@RequestMapping("car")
public class CarController {
    /**
     * 服务对象
     */
    @Resource
    private CarService carService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Car selectOne(Integer id) {
        return this.carService.queryById(id);
    }

}