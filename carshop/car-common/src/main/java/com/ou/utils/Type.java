package com.ou.utils;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author makejava
 * @since 2020-06-10 12:25:36
 */
public class Type implements Serializable {
    private static final long serialVersionUID = -32979239724320651L;
    /**
    * 唯一id
    */
    private Integer id;
    /**
    * 菜单id
    */
    private Integer tMId;
    /**
    * 类型名称
    */
    private String typeName;
    /**
    * 类型图片地址
    */
    private String typePicture;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTMId() {
        return tMId;
    }

    public void setTMId(Integer tMId) {
        this.tMId = tMId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypePicture() {
        return typePicture;
    }

    public void setTypePicture(String typePicture) {
        this.typePicture = typePicture;
    }

}