package com.ou.controller;

import com.ou.entity.Car;
import com.ou.entity.ResultCommon;
import com.ou.service.CarService;
import com.ou.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Car)表控制层
 *
 * @author makejava
 * @since 2020-06-10 16:40:26
 */
@RestController
@RequestMapping("car")
public class CarController {

    //nacos config上配置属性
    @Value("${redisPrefix.brand}")
    private String redisPrefix;
    private String path = "D:\\尝试代码\\shop\\usedcarshopvue\\src\\assets\\images\\car";

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
        return carService.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @GetMapping("selectLimit")
    public List<Car> queryAllByLimit(int offset, int limit) {
        return carService.queryAllByLimit(offset, limit);
    }

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @GetMapping("selectLimit")
    public List<Car> queryAll() {
        return carService.queryAll();
    }

    /**
     * 新增数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    public Car insert(Car car) {
        carService.insert(car);
        return car;
    }

    /**
     * 修改数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    @PutMapping("update")
    public Car update(Car car) {

        return carService.update(car);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("selectLimit")
    public boolean deleteById(Integer id) {
        return carService.deleteById(id);
    }

    @PostMapping("upload")
    public ResultCommon upload(@RequestParam("file") MultipartFile file) {
        return FileUtil.upload(file, path);
    }
}