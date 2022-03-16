package com.dlu.cdmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
@ApiModel(value="Category对象", description="")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型id")
    @TableId(value = "CateId", type = IdType.AUTO)
    private Integer CateId;

    @ApiModelProperty(value = "类型名")
    private String name;

    public Integer getCateId() {
        return CateId;
    }

    public void setCateId(Integer CateId) {
        this.CateId = CateId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
            "CateId=" + CateId +
            ", name=" + name +
        "}";
    }
}
