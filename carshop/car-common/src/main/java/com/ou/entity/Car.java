package com.ou.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Car)实体类
 *
 * @author makejava
 * @since 2020-06-10 12:25:28
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -26196673162510902L;
    /**
    * 唯一id
    */
    private Integer id;
    /**
    * 汽车名称
    */
    private String carName;
    /**
    * 汽车图片地址
    */
    private String carPicture;
    /**
    * 售价
    */
    private Integer price;
    /**
    * 年限
    */
    private Date age;
    /**
    * 品牌
    */
    private Integer brand;
    /**
    * 类型
    */
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(String carPicture) {
        this.carPicture = carPicture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}