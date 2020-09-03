package com.ou.controller;

import com.ou.entity.Brand;
import com.ou.entity.ResultCommon;
import com.ou.service.BrandService;
import com.ou.utils.FileUtil;
import com.ou.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * (Brand)表控制层
 *
 * @author makejava
 * @since 2020-06-10 17:41:50
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    //nacos config上配置属性
    @Value("${redisPrefix.brand}")
    private String redisPrefix;
    private String path = "D:\\尝试代码\\shop\\usedcarshopvue\\src\\assets\\images\\brand";

    /**
     * 服务对象
     */
    @Resource
    private BrandService brandService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id{")
    public ResultCommon selectOne(@PathVariable("id") Integer id) {
        StringBuilder bs = new StringBuilder(redisPrefix);
        bs.append(id);
        Brand brandRedis = (Brand)redisTemplate.opsForValue().get(bs.toString());
        if (brandRedis != null){
            Brand brand = brandService.queryById(id);
            Assert.notNull(brand,"品牌不存在");
            redisTemplate.opsForValue().set(bs.toString(),brand);
            return ResultUtil.success(brand);
        }
        return ResultUtil.success(brandRedis);
    }

    /**
     * 查询全部数据
     *
     *
     * @return 全部数据
     */
    @GetMapping("selectAll")
    public ResultCommon selectAll() {
        Set keys = redisTemplate.keys(redisPrefix + ":*");
        if (keys.isEmpty()){
            List<Brand> brands = brandService.queryAll();
            Assert.notNull(brands,"品牌不存在");
            Iterator<Brand> iterator = brands.iterator();
            if (iterator.hasNext()){
                Brand next = iterator.next();
                redisTemplate.opsForValue().set(redisPrefix + ":" + next.getId(),next);
            }
            return ResultUtil.success(brands);
        }
        Iterator iterator = keys.iterator();
        List<Brand> brandList = new ArrayList<>();
        if(iterator.hasNext()) {
            Brand brand = (Brand)redisTemplate.opsForValue().get(iterator.next());
            brandList.add(brand);
        }
        return ResultUtil.success(brandList);
    }

    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    public ResultCommon insert(Brand brand) {
        Brand iBrand = brandService.insert(brand);
        redisTemplate.opsForValue().set(redisPrefix + ":" + iBrand.getId(), iBrand);
        return  ResultUtil.success(iBrand);
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

    @PostMapping("upload")
    public ResultCommon upload(@RequestParam("file") MultipartFile file) {
        return FileUtil.upload(file,path);
    }
}