package com.ou.controller;

import com.ou.entity.Article;
import com.ou.service.ArticleService;
import com.ou.entity.ResultCommon;
import com.ou.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2020-06-10 16:32:20
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id) {
        Article article = articleService.queryById(id);
        return ResultUtil.success(article);
    }


    @GetMapping("selectAll")
    public ResultCommon selectAll() {
        List<Article> articles = articleService.queryAllByLimit(0, 10);
        return ResultUtil.success(articles);
    }

    @DeleteMapping("{id}")
    public ResultCommon deleteOne(@PathVariable("id")Integer id) {
        boolean b = articleService.deleteById(id);
        if(b == true){
            return ResultUtil.success();
        }else{
            return ResultUtil.error();
        }
    }

    @PutMapping("update")
    public ResultCommon update(@RequestBody Article article) {
        Article update = articleService.update(article);
        return ResultUtil.success(update);
    }

    @PostMapping("insert")
    public ResultCommon insert(@RequestBody Article article){
        Article insert = articleService.insert(article);
        return ResultUtil.success(insert);
    }
}