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
 * 会员信息表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-11-30
 */
@TableName("t_m_member")
@ApiModel(value="Member对象", description="会员信息表")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;
    public static final String MEMBER_STATUS_DISABLE = "0";    
    public static final String MEMBER_STATUS_AVAILABLE = "1";
    public static final String MEMBER_STATUS_LOCKOUT = "2";
    public static final String MEMBER_CATEGORY_PERSON = "1";
    public static final String MEMBER_CATEGORY_BUSINESS = "2";


    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
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

    @Override
    public String toString() {
        return "Member{" +
        "id=" + id +
        ", uid=" + uid +
        ", createAt=" + createAt +
        ", createIp=" + createIp +
        ", lastTime=" + lastTime +
        ", status=" + status +
        ", category=" + category +
        "}";
    }
}
