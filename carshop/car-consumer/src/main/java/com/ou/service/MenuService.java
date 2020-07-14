package com.ou.service;

import com.ou.entity.ResultCommon;
import com.ou.utils.Article;
import com.ou.utils.Menu;
import com.ou.utils.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "menu-service")
public interface MenuService {

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/menu/selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id);

    /**
     * 增加菜单数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @PostMapping("/menu/insert")
    public ResultCommon insert(Menu menu);

    /**
     * 更新菜单数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @PutMapping("/menu/update")
    public ResultCommon update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/menu/delete/{id}")
    public ResultCommon deleteById(@PathVariable("id") Integer id);



    @GetMapping("/article/selectOne/{id}")
    public ResultCommon selectArticle(@PathVariable("id") Integer id);

    @GetMapping("/article/selectAll")
    public ResultCommon selectAllArticle();

    @DeleteMapping("/article/{id}")
    public ResultCommon deleteArticle(@PathVariable("id")Integer id);

    @PutMapping("/article/update")
    public ResultCommon updateArticle(@RequestBody Article article);

    @PostMapping("/article/insert")
    public ResultCommon insertArticle(@RequestBody Article article);
}
