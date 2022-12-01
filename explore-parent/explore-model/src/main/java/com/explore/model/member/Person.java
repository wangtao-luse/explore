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
 * 个人信息表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_person")
@ApiModel(value="Person对象", description="个人信息表")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "性别 (0:女;1:男)")
    private String gender;

    @ApiModelProperty(value = "年龄(baby:0-6;junior:7-12;teenager:13-17;young:18-45;mid:46-69;old:69岁及以上)")
    private String age;

    @ApiModelProperty(value = "Email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "1:待审核;2:审核通过;3:审核不通过")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "审核不通过备注")
    @TableField("REMARK")
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Person{" +
        "id=" + id +
        ", gender=" + gender +
        ", age=" + age +
        ", email=" + email +
        ", phone=" + phone +
        ", status=" + status +
        ", remark=" + remark +
        "}";
    }
}
