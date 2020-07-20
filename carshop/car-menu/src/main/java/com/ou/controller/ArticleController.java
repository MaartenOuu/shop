package com.ou.controller;

import com.ou.entity.Article;
import com.ou.service.ArticleService;
import com.ou.entity.ResultCommon;
import com.ou.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2020-06-10 16:32:20
 */
@RestController
@RequestMapping("article")
@RefreshScope
public class ArticleController {

    //nacos config上配置属性
    @Value("${redisPrefix.article}")
    private String redisPrefix;
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public ResultCommon selectOne(@PathVariable("id") Integer id) {
        StringBuilder stringBuilder = new StringBuilder(redisPrefix);
        String ArtId = stringBuilder.append(id).toString();
        Article art = (Article)redisTemplate.opsForValue().get(ArtId);
        if (art != null){
            return ResultUtil.success(art);
        }else {
            Article article = articleService.queryById(id);
            redisTemplate.opsForValue().set(ArtId,article);
            return ResultUtil.success(article);
        }

    }


    @GetMapping("selectAll")
    public ResultCommon selectAll() {
        Set<String> keys = redisTemplate.keys(redisPrefix+"*");
        ArrayList<Article> arrayList = new ArrayList<>();
        for(String key:keys){
                Article art = (Article) redisTemplate.opsForValue().get(key);
                arrayList.add(art);
        }
        if (arrayList.isEmpty()){
            List<Article> articles = articleService.queryAllByLimit(0, 10);
            return ResultUtil.success(articles);
        }else {
            return ResultUtil.success(arrayList);
        }

    }

    @DeleteMapping("{id}")
    public ResultCommon deleteOne(@PathVariable("id")Integer id) {
        boolean b = articleService.deleteById(id);
        if(b == true){
            StringBuilder stringBuilder = new StringBuilder(redisPrefix);
            String ArtId = stringBuilder.append(id).toString();
            redisTemplate.delete(ArtId);
            return ResultUtil.success();
        }else{
            return ResultUtil.error();
        }
    }

    @PutMapping("update")
    public ResultCommon update(@RequestBody Article article) {
        Article update = articleService.update(article);
        StringBuilder stringBuilder = new StringBuilder(redisPrefix);
        String ArtId = stringBuilder.append(update.getId()).toString();
        redisTemplate.delete(ArtId);
        return ResultUtil.success(update);
    }

    @PostMapping("insert")
    public ResultCommon insert(@RequestBody Article article){
        Article insert = articleService.insert(article);
        StringBuilder stringBuilder = new StringBuilder(redisPrefix);
        String ArtId = stringBuilder.append(insert.getId()).toString();
        redisTemplate.opsForValue().set(ArtId,insert);
        return ResultUtil.success(insert);
    }

    @GetMapping("test")
    public String a(){
        return redisPrefix;
    }
}