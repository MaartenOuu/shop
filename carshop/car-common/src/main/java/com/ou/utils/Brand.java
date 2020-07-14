package com.ou.utils;

import java.io.Serializable;

/**
 * (Brand)实体类
 *
 * @author makejava
 * @since 2020-06-10 12:25:22
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = -59876580622830160L;
    /**
    * 唯一id
    */
    private Integer id;
    /**
    * 菜单id
    */
    private Integer bMId;
    /**
    * 品牌名称
    */
    private String brandName;
    /**
    * 品牌名称
    */
    private String brandPicture;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBMId() {
        return bMId;
    }

    public void setBMId(Integer bMId) {
        this.bMId = bMId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandPicture() {
        return brandPicture;
    }

    public void setBrandPicture(String brandPicture) {
        this.brandPicture = brandPicture;
    }

}