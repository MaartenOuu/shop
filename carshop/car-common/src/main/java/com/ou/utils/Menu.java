package com.ou.utils;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2020-06-10 12:25:32
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -78392705005208792L;
    /**
    * 唯一id
    */
    private Integer id;
    /**
    * 菜单名称
    */
    private String menu;
    /**
    * 父级菜单
    */
    private Integer gid;
    /**
    * 子级菜单
    */
    private Integer sid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

}