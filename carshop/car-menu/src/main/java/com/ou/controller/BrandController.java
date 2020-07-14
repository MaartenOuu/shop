package com.ou.controller;

import com.ou.entity.Brand;
import com.ou.service.BrandService;
import com.ou.entity.ResultCommon;
import com.ou.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Brand)表控制层
 *
 * @author makejava
 * @since 2020-06-10 17:41:50
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    /**
     * 服务对象
     */
    @Resource
    private BrandService brandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id{")
    public ResultCommon selectOne(@PathVariable("id") Integer id) {
        return ResultUtil.success(brandService.queryById(id));
    }

    /**
     * 查询全部数据
     *
     *
     * @return 全部数据
     */
    @GetMapping("selectAll")
    public ResultCommon selectAll() {
        return ResultUtil.success(brandService.queryAllByLimit(0,10));
    }

    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    public ResultCommon insert(Brand brand) {
        return  ResultUtil.success(brandService.insert(brand));
    }

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @PutMapping("update")
    public ResultCommon update(Brand brand) {
        return ResultUtil.success(brandService.update(brand));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("delete/{id}")
    public ResultCommon deleteById(@PathVariable("id") Integer id) {
        boolean b = brandService.deleteById(id);
        if(b == true){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }
}