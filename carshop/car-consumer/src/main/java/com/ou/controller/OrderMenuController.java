package com.ou.controller;

import com.ou.entity.ResultCommon;
import com.ou.service.MenuService;
import com.ou.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/menu")
public class OrderMenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id){
        return menuService.selectOne(id);
    }

    /**
     * 增加菜单数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    public ResultCommon insert(Menu menu) {
        return menuService.insert(menu);
    }

    /**
     * 更新菜单数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @PutMapping("update")
    public ResultCommon update(Menu menu) {
        return menuService.update(menu);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("delete/{id}")
    public ResultCommon deleteById(@PathVariable("id") Integer id) {
        return menuService.deleteById(id);
    }
}
