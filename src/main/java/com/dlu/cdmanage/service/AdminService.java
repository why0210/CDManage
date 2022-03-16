package com.dlu.cdmanage.service;

import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
public interface AdminService extends IService<Admin> {
    ResultVO checkLogin(String username, String pwd);
    ResultVO modifyPassword(String username, String oldPass, String newPass);
}
