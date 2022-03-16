package com.dlu.cdmanage.service;

import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
public interface OrdersService extends IService<Orders> {
    ResultVO getOrdersByParam(int pageNum, int pageSize, String queryParam);
}
