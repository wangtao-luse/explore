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
 * 会员-会员组表(中间表)
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_member_group")
@ApiModel(value="MemberGroup对象", description="会员-会员组表(中间表)")
public class MemberGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String MEMBER_GROUPCODE_ADMIN="1";
    public static final String MEMBER_GROUPCODE_PERSON="2";
    public static final String MEMBER_GROUPCODE_BUSINESS="3";
    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一号")
    @TableField("UID")
    private String uid;

    @ApiModelProperty(value = "组代码")
    @TableField("GROUP_CODE")
    private String groupCode;


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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Override
    public String toString() {
        return "MemberGroup{" +
        "id=" + id +
        ", uid=" + uid +
        ", groupCode=" + groupCode +
        "}";
    }
}
