package com.ou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Owq
 * @since 2020-06-17
 */
@ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "名称")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像地址")
    private String userPicture;

    @ApiModelProperty(value = "性别（0代表女，1代表男）")
    private Integer sex;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private Integer phone;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreat;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModifle;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public LocalDateTime getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(LocalDateTime gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public LocalDateTime getGmtModifle() {
        return gmtModifle;
    }

    public void setGmtModifle(LocalDateTime gmtModifle) {
        this.gmtModifle = gmtModifle;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", account=" + account +
        ", userName=" + userName +
        ", password=" + password +
        ", userPicture=" + userPicture +
        ", sex=" + sex +
        ", signature=" + signature +
        ", email=" + email +
        ", phone=" + phone +
        ", gmtCreat=" + gmtCreat +
        ", gmtModifle=" + gmtModifle +
        "}";
    }
}
