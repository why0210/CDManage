package com.dlu.cdmanage.service.impl;

import com.dlu.cdmanage.entity.Category;
import com.dlu.cdmanage.mapper.CategoryMapper;
import com.dlu.cdmanage.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuhaoyuan
 * @since 2021-11-15
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
