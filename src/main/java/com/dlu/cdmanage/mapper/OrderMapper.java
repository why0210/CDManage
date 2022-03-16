package com.dlu.cdmanage.mapper;

import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}
