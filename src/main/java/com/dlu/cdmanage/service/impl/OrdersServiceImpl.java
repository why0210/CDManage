package com.dlu.cdmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dlu.cdmanage.common.ResStatus;
import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Cd;
import com.dlu.cdmanage.entity.Orders;
import com.dlu.cdmanage.mapper.CdMapper;
import com.dlu.cdmanage.mapper.OrderMapper;
import com.dlu.cdmanage.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrdersService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResultVO getOrdersByParam(int pageNum, int pageSize, String queryParam) {
        Page<Orders> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        if(!queryParam.isEmpty()){
            queryWrapper.like("id",queryParam).orderByDesc("refs");
        }
        Page<Orders> categoriesPage = orderMapper.selectPage(page, queryWrapper);
        String total = String.valueOf(categoriesPage.getTotal());
        List<Orders> list = categoriesPage.getRecords();
        if(list!=null){
            return new ResultVO(ResStatus.OK,total,list);
        }else {
            return new ResultVO(ResStatus.NO,null,null);
        }
    }

}
