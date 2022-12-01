package com.explore.model.member.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_member_oauth_view")
@ApiModel(value="MemberOauthView对象", description="VIEW")
public class MemberOauthView implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableField("ID")
    private Integer id;

    @ApiModelProperty(value = "用户唯一号")
    @TableField("UID")
    private String uid;

    @ApiModelProperty(value = "注册时间")
    @TableField("CREATE_AT")
    private Long createAt;

    @ApiModelProperty(value = "注册IP地址")
    @TableField("CREATE_IP")
    private String createIp;

    @ApiModelProperty(value = "上次登录时间")
    @TableField("LAST_TIME")
    private Long lastTime;

    @ApiModelProperty(value = "状态(0：禁用；1:正常;2:锁定状态)")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "用户类别(1:个人用户;2:企业用户)")
    @TableField("CATEGORY")
    private String category;

    @ApiModelProperty(value = "第三方登录唯一ID	(站内保存手机号码,用户名，邮箱)")
    @TableField("OAUTH_ID")
    private String oauthId;

    @ApiModelProperty(value = "第三方登录平台标识(手机：phone;邮箱：email;QQ:qq;微信：wechat;用户名：uid;微博:weibo)")
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

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return "MemberOauthView{" +
        "id=" + id +
        ", uid=" + uid +
        ", createAt=" + createAt +
        ", createIp=" + createIp +
        ", lastTime=" + lastTime +
        ", status=" + status +
        ", category=" + category +
        ", oauthId=" + oauthId +
        ", oauthType=" + oauthType +
        ", credential=" + credential +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", passwd=" + passwd +
        "}";
    }
}
