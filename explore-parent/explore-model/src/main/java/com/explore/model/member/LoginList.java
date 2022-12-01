package com.explore.model.member;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 登录记录表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_login_list")
@ApiModel(value="LoginList对象", description="登录记录表")
public class LoginList implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号标识	主键,自动增长")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一号")
    @TableField("UID")
    private String uid;

    @ApiModelProperty(value = "登录账号")
    @TableField("OAUTH_ID")
    private String oauthId;

    @ApiModelProperty(value = "登录账号类型")
    @TableField("OAUTH_TYPE")
    private String oauthType;

    @ApiModelProperty(value = "用户类别(1:个人用户;2:企业用户)")
    @TableField("CATEGORY")
    private String category;

    @ApiModelProperty(value = "登录时间")
    @TableField("LOGIN_At")
    private Long loginAt;

    @ApiModelProperty(value = "登录IP")
    @TableField("LOGIN_IP")
    private String loginIp;

    @ApiModelProperty(value = "IP位置")
    private String addr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthType() {
        return oauthType;
    }

    public void setOauthType(String oauthType) {
        this.oauthType = oauthType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Long loginAt) {
        this.loginAt = loginAt;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "LoginList{" +
        "id=" + id +
        ", uid=" + uid +
        ", oauthId=" + oauthId +
        ", oauthType=" + oauthType +
        ", category=" + category +
        ", loginAt=" + loginAt +
        ", loginIp=" + loginIp +
        ", addr=" + addr +
        "}";
    }
}
