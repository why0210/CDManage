package com.dlu.cdmanage.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ResultVO对象",description = "封装了返回给前端的信息")
public class ResultVO {
    //状态码
    @ApiModelProperty(name = "code",value = "状态码",dataType = "int")
    private int code;

    //提示信息
    private String msg;

    //数据
    private Object data;


}
