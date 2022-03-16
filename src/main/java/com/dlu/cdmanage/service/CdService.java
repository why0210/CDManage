package com.dlu.cdmanage.service;

import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Cd;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
public interface CdService extends IService<Cd> {
    ResultVO getCdByCateId(int id);
    ResultVO getCategoryByCate(int pageNum, int pageSize, String queryParam);
}
