package com.ou.controller;

import com.ou.entity.Menu;
import com.ou.entity.ResultCommon;
import com.ou.service.MenuService;
import com.ou.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2020-06-10 15:33:08
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    @Qualifier("menuService")
    private MenuService menuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id) {
        Menu menu = menuService.queryById(id);
        return ResultUtil.success(menu);
    }

    /**
     * 增加菜单数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    public ResultCommon insert(Menu menu) {
        menuService.insert(menu);
        return ResultUtil.success(menu);
    }

    /**
     * 更新菜单数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @PutMapping("update")
    public ResultCommon update(Menu menu) {
        Menu update = menuService.update(menu);
        return ResultUtil.success(menu);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("delete/{id}")
    public ResultCommon deleteById(@PathVariable("id") Integer id) {
        boolean b = menuService.deleteById(id);
        if(b == true){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }
}