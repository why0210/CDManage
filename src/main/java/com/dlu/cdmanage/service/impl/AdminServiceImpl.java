package com.dlu.cdmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dlu.cdmanage.common.ResStatus;
import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Admin;
import com.dlu.cdmanage.mapper.AdminMapper;
import com.dlu.cdmanage.service.AdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultVO checkLogin(String username, String pwd) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Admin admin = adminMapper.selectOne(queryWrapper);
        if(admin==null){
            return new ResultVO(ResStatus.NO,"用户名不存在",false);
        }
        if(pwd.equals(admin.getPassword())){
            return new ResultVO(ResStatus.OK,"登陆成功",true);
        }else {
            return new ResultVO(ResStatus.NO,"用户名或密码错误",false);
        }
    }

    @Override
    public ResultVO modifyPassword(String username, String oldPass, String newPass) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Admin admin = adminMapper.selectOne(queryWrapper);
        if(admin==null){
            return new ResultVO(ResStatus.NO,"用户名不存在",false);
        }
        if(!oldPass.equals(admin.getPassword())){
            return new ResultVO(ResStatus.NO,"原始密码有误，修改密码失败",false);
        }
        admin.setPassword(newPass);
        int update = adminMapper.updateById(admin);
        if(update>0){
            return new ResultVO(ResStatus.OK,"密码修改成功",admin.getUsername());
        }else {
            return new ResultVO(ResStatus.NO,"密码修改失败",admin.getUsername());
        }
    }
}
