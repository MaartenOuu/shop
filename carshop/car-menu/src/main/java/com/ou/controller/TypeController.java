package com.ou.controller;

import com.ou.entity.Type;
import com.ou.service.TypeService;
import com.ou.entity.ResultCommon;
import com.ou.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2020-06-10 17:42:22
 */
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id) {
        return ResultUtil.success(typeService.queryById(id));
    }


    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    public ResultCommon insert(Type type) {
        return  ResultUtil.success(typeService.insert(type));
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @PutMapping("update")
    public ResultCommon update(Type type) {
        return ResultUtil.success(typeService.update(type));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("delete")
    public ResultCommon deleteById(Integer id) {
        boolean b = typeService.deleteById(id);
        if(b == true){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }
}