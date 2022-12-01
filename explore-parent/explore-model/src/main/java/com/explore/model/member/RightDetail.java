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
 * 权限主表
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@TableName("t_m_right_detail")
@ApiModel(value="RightDetail对象", description="权限主表")
public class RightDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "权限唯一标识")
    @TableField("RIGHT_CODE")
    private String rightCode;

    @ApiModelProperty(value = "资源")
    @TableField("URL")
    private String url;

    @ApiModelProperty(value = "是否登录(anon 不需要登录 authc 需要登录)")
    @TableField("ISLOGIN")
    private String islogin;

    @ApiModelProperty(value = "是否记日志(0:不需要;1:需要)")
    @TableField("ISLOG")
    private String islog;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIslogin() {
        return islogin;
    }

    public void setIslogin(String islogin) {
        this.islogin = islogin;
    }

    public String getIslog() {
        return islog;
    }

    public void setIslog(String islog) {
        this.islog = islog;
    }

    @Override
    public String toString() {
        return "RightDetail{" +
        "id=" + id +
        ", rightCode=" + rightCode +
        ", url=" + url +
        ", islogin=" + islogin +
        ", islog=" + islog +
        "}";
    }
}
