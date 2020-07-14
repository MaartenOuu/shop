package com.ou.controller;

import com.ou.entity.ResultCommon;
import com.ou.service.MenuService;
import com.ou.utils.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/article")
public class OrderArticleController {

    @Autowired
    private MenuService menuService;

    @GetMapping("selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id){
        return menuService.selectArticle(id);
    }

    @GetMapping("selectAll")
    public ResultCommon selectAll(){
        return menuService.selectAllArticle();
    }

    @DeleteMapping("{id}")
    public ResultCommon deleteOne(@PathVariable("id")Integer id){
        return menuService.deleteArticle(id);
    }

    @PutMapping("update")
    public ResultCommon update(@RequestBody Article article){
        return menuService.updateArticle(article);
    }

    @PostMapping("insert")
    public ResultCommon insert(@RequestBody Article article){
        return menuService.insertArticle(article);
    }
}
