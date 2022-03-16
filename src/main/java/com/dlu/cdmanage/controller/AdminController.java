package com.dlu.cdmanage.controller;


import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
@Api(tags = "管理员模块")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation("管理员登录")
    public ResultVO login(@RequestBody Map<String, String> param){
        return adminService.checkLogin(param.get("username"),param.get("password"));
    }

    @PostMapping("/updatePassword")
    @ApiOperation("修改密码")
    public ResultVO updatePassword(@RequestBody Map<String, String> param){
        return adminService.modifyPassword(param.get("username"),param.get("oldPass"),param.get("newPass"));
    }
}
