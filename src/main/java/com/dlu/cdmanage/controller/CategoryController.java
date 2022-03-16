package com.dlu.cdmanage.controller;


import com.dlu.cdmanage.common.ResStatus;
import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Category;
import com.dlu.cdmanage.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/category")
@CrossOrigin
@Api(tags = "CD类别管理")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/AllCate")
    @ApiOperation("获取CD的类别列表")
    public ResultVO getAllCate(){
        List<Category> list = categoryService.list();
        if(list!=null){
            return new ResultVO(ResStatus.OK,"CD类别列表获取成功",list);
        }else {
            return new ResultVO(ResStatus.NO,"CD类别列表获取失败",null);
        }
    }

    @GetMapping("/getCateById")
    @ApiOperation("根据指定的CateId获取对应类别名称")
    public ResultVO getCateById(@RequestParam("CateId")int CateId){
        Category category = categoryService.getById(CateId);
        if(category!=null){
            return new ResultVO(ResStatus.OK,"类别名称获取成功",category.getName());
        }else {
            return new ResultVO(ResStatus.NO,"不存在CateId为"+CateId+"的类型",CateId);
        }
    }
}
