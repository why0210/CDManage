package com.dlu.cdmanage.controller;


import com.dlu.cdmanage.common.ResStatus;
import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Orders;
import com.dlu.cdmanage.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
@Api(tags = "订单管理")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/all")
    @ApiOperation("获取所有订单")
    public ResultVO getAll(){
        List<Orders> list = ordersService.list();
        if(list!=null){
            return new ResultVO(ResStatus.OK,"订单获取成功",list);
        }else{
            return new ResultVO(ResStatus.NO,"订单获取失败",null);
        }
    }

    @GetMapping("/getOrdersByParam")
    @ApiOperation("分页+条件查询订单列表")
    public ResultVO getCategoryByCate(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize,
            @RequestParam(value = "QueryParam",required = false)String QueryParam){
        return ordersService.getOrdersByParam(pageNum,pageSize,QueryParam);
    }
}
