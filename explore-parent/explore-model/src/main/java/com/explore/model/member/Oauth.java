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
 * 会员认证表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-11-30
 */
@TableName("t_m_oauth")
@ApiModel(value="Oauth对象", description="会员认证表")
public class Oauth implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String OAUTH_OAUTHTYPE_EMAIL = "email";
    public static final String OAUTH_OAUTHTYPE_UNAME = "uanme";
    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一号")
    @TableField("UID")
    private String uid;

    @ApiModelProperty(value = "第三方登录唯一ID	(站内保存手机号码,用户名，邮箱)")
    @TableField("OAUTH_ID")
    private String oauthId;

    @ApiModelProperty(value = "第三方登录平台标识(手机：phone;邮箱：email;QQ:qq;微信：wechat;用户名：uname;微博:weibo)")
    @TableField("OAUTH_TYPE")
    private String oauthType;

    @ApiModelProperty(value = "密码凭证(站内的保存密码，站外的不保存或保存token)")
    @TableField("CREDENTIAL")
    private String credential;

    @ApiModelProperty(value = "昵称")
    @TableField("NICKNAME")
    private String nickname;

    @ApiModelProperty(value = "图像")
    @TableField("AVATAR")
    private String avatar;

    @ApiModelProperty(value = "盐值")
    @TableField("PASSWD")
    private String passwd;


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

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Oauth{" +
        "id=" + id +
        ", uid=" + uid +
        ", oauthId=" + oauthId +
        ", oauthType=" + oauthType +
        ", credential=" + credential +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", passwd=" + passwd +
        "}";
    }
}
