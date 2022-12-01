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
 * 会员组表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_group")
@ApiModel(value="Group对象", description="会员组表")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "组编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "组代码")
    @TableField("GROUD_CODE")
    private String groudCode;

    @ApiModelProperty(value = "组名称")
    @TableField("GROUP_NAME")
    private String groupName;

    @ApiModelProperty(value = "所属组编号(-1:超级组)")
    @TableField("GROUP_PARENT")
    private Integer groupParent;

    @ApiModelProperty(value = "组描述")
    @TableField("GROUP_NOTE")
    private String groupNote;

    @ApiModelProperty(value = "创建日期")
    @TableField("CREATE_AT")
    private Long createAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroudCode() {
        return groudCode;
    }

    public void setGroudCode(String groudCode) {
        this.groudCode = groudCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupParent() {
        return groupParent;
    }

    public void setGroupParent(Integer groupParent) {
        this.groupParent = groupParent;
    }

    public String getGroupNote() {
        return groupNote;
    }

    public void setGroupNote(String groupNote) {
        this.groupNote = groupNote;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Group{" +
        "id=" + id +
        ", groudCode=" + groudCode +
        ", groupName=" + groupName +
        ", groupParent=" + groupParent +
        ", groupNote=" + groupNote +
        ", createAt=" + createAt +
        "}";
    }
}
