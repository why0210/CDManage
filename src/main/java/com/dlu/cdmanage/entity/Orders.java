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
@ApiModel(value="Order对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号(同一个订单同一个编号)")
    private Integer refs;

    @ApiModelProperty(value = "cd数量")
    @TableField(value = "cdNum")
    private Integer cdNum;

    @ApiModelProperty(value = "cd的id")
    @TableField(value = "cdId")
    private Integer cdId;

    @ApiModelProperty(value = "部分/整体价格")
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getRefs() {
        return refs;
    }

    public void setRefs(Integer refs) {
        this.refs = refs;
    }
    public Integer getCdNum() {
        return cdNum;
    }

    public void setCdNum(Integer cdNum) {
        this.cdNum = cdNum;
    }
    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
            "id=" + id +
            ", refs=" + refs +
            ", cdNum=" + cdNum +
            ", cdId=" + cdId +
            ", price=" + price +
        "}";
    }
}
