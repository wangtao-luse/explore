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
 * 企业信息表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-03
 */
@TableName("t_m_business")
@ApiModel(value="Business对象", description="企业信息表")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一号")
    @TableField("UID")
    private String uid;

    @ApiModelProperty(value = "企业名称")
    @TableField("BUSINESSNAME")
    private String businessname;

    @ApiModelProperty(value = "统一社会信用代码")
    @TableField("TAXPAYERID")
    private String taxpayerid;

    @ApiModelProperty(value = "企业省份")
    @TableField("PROVINCE")
    private String province;

    @ApiModelProperty(value = "企业城市")
    @TableField("CITY")
    private String city;

    @ApiModelProperty(value = "企业所属区")
    @TableField("AREA")
    private String area;

    @ApiModelProperty(value = "企业地址")
    @TableField("ENTERPRISE_ADDR")
    private String enterpriseAddr;

    @ApiModelProperty(value = "联系人姓名")
    @TableField("EMERGENCY_CONTACT")
    private String emergencyContact;

    @ApiModelProperty(value = "所属行业")
    @TableField("INDUSTRY")
    private String industry;

    @ApiModelProperty(value = "工商营业执照")
    @TableField("CERT_IMAGE_URL")
    private String certImageUrl;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getTaxpayerid() {
        return taxpayerid;
    }

    public void setTaxpayerid(String taxpayerid) {
        this.taxpayerid = taxpayerid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEnterpriseAddr() {
        return enterpriseAddr;
    }

    public void setEnterpriseAddr(String enterpriseAddr) {
        this.enterpriseAddr = enterpriseAddr;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCertImageUrl() {
        return certImageUrl;
    }

    public void setCertImageUrl(String certImageUrl) {
        this.certImageUrl = certImageUrl;
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
        return "Business{" +
        "id=" + id +
        ", uid=" + uid +
        ", businessname=" + businessname +
        ", taxpayerid=" + taxpayerid +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", enterpriseAddr=" + enterpriseAddr +
        ", emergencyContact=" + emergencyContact +
        ", industry=" + industry +
        ", certImageUrl=" + certImageUrl +
        ", status=" + status +
        ", remark=" + remark +
        "}";
    }
}
