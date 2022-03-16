package com.dlu.cdmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dlu.cdmanage.common.ResStatus;
import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Cd;
import com.dlu.cdmanage.mapper.CdMapper;
import com.dlu.cdmanage.service.CdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
public class CdServiceImpl extends ServiceImpl<CdMapper, Cd> implements CdService {
    @Autowired
    private CdMapper cdMapper;

    @Override
    public ResultVO getCdByCateId(int id) {
        QueryWrapper<Cd> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("CateId",id);
        List<Cd> list = cdMapper.selectList(queryWrapper);
        if(list!=null){
            return new ResultVO(ResStatus.OK,"类别查询成功",list);
        }else {
            return new ResultVO(ResStatus.NO,"类别查询结果为空",null);
        }
    }

    @Override
    public ResultVO getCategoryByCate(int pageNum, int pageSize, String queryParam) {
        Page<Cd> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Cd> queryWrapper = new QueryWrapper<>();
        if(!queryParam.isEmpty()){
            queryWrapper.like("name",queryParam).or().like("author",queryParam);
        }
        Page<Cd> categoriesPage = cdMapper.selectPage(page, queryWrapper);
        String total = String.valueOf(categoriesPage.getTotal());
        List<Cd> list = categoriesPage.getRecords();
        if(list!=null){
            return new ResultVO(ResStatus.OK,total,list);
        }else {
            return new ResultVO(ResStatus.NO,null,null);
        }
    }

}
