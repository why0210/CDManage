package com.dlu.cdmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Cd对象", description="")
public class Cd implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型id")
    @TableField(value = "CateId")
    private Integer CateId;

    @ApiModelProperty(value = "单价")
    private Double price;

    @ApiModelProperty(value = "作者/导演")
    private String author;

    @ApiModelProperty(value = "发行公司")
    private String company;

    @ApiModelProperty(value = "发行地区")
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getCateId() {
        return CateId;
    }

    public void setCateId(Integer CateId) {
        this.CateId = CateId;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Cd{" +
            "id=" + id +
            ", name=" + name +
            ", CateId=" + CateId +
            ", price=" + price +
            ", author=" + author +
            ", company=" + company +
            ", region=" + region +
        "}";
    }

    /*
    * cd构造，id自增
    * */
    public Cd(String name, Integer cateId, Double price, String author, String company, String region) {
        this.name = name;
        CateId = cateId;
        this.price = price;
        this.author = author;
        this.company = company;
        this.region = region;
    }

    public Cd() {
    }
}
