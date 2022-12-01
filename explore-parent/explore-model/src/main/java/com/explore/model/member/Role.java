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
 * 角色表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_role")
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "	编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "角色代码")
    @TableField("ROLE_CODE")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    @TableField("ROLE_NAME")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    @TableField("ROLE_NOTE")
    private String roleNote;

    @ApiModelProperty(value = "所属角色编号(-1:超级角色)")
    @TableField("ROLE_PARENT")
    private Integer roleParent;

    @ApiModelProperty(value = "创建日期")
    @TableField("CREATE_AT")
    private Long createAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNote() {
        return roleNote;
    }

    public void setRoleNote(String roleNote) {
        this.roleNote = roleNote;
    }

    public Integer getRoleParent() {
        return roleParent;
    }

    public void setRoleParent(Integer roleParent) {
        this.roleParent = roleParent;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", roleCode=" + roleCode +
        ", roleName=" + roleName +
        ", roleNote=" + roleNote +
        ", roleParent=" + roleParent +
        ", createAt=" + createAt +
        "}";
    }
}
