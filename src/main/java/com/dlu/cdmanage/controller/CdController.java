package com.dlu.cdmanage.controller;


import com.dlu.cdmanage.common.ResStatus;
import com.dlu.cdmanage.common.ResultVO;
import com.dlu.cdmanage.entity.Cd;
import com.dlu.cdmanage.service.CdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@RequestMapping("/cd")
@CrossOrigin
@Api(tags = "CD管理")
public class CdController {
    @Autowired
    private CdService cdService;

    @GetMapping("/all")
    @ApiOperation("获取所有CD")
    public ResultVO getAll(){
        List<Cd> list = cdService.list();
        if(list!=null){
            return new ResultVO(ResStatus.OK,"成功",list);
        }else{
            return new ResultVO(ResStatus.NO,"失败",null);
        }
    }

    @GetMapping("/CateId")
    @ApiOperation("根据CateId获取CD列表")
    public ResultVO getCdByCateId(@RequestParam("id")int id){
        return cdService.getCdByCateId(id);
    }

    @GetMapping("/getCdByParam")
    @ApiOperation("分页+条件查询CD列表")
    public ResultVO getCategoryByCate(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize,
            @RequestParam(value = "QueryParam",required = false)String QueryParam){
        return cdService.getCategoryByCate(pageNum,pageSize,QueryParam);
    }


    @PostMapping("/add")
    @ApiOperation("新增CD")
    public ResultVO addCd(@RequestBody Map<String,String> param){
        Cd cd = new Cd();
        cd.setName(param.get("name"));
        cd.setCateId(Integer.valueOf(param.get("cateId")));
        cd.setPrice(Double.valueOf(param.get("price")));
        cd.setAuthor(param.get("author"));
        cd.setCompany(param.get("company"));
        cd.setRegion(param.get("region"));
        boolean save = cdService.save(cd);
        if(save){
            return new ResultVO(ResStatus.OK,"CD添加成功",cd);
        }else {
            return new ResultVO(ResStatus.NO,"CD添加失败",cd);
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除CD")
    public ResultVO deleteCd(@RequestParam("id")int id){
        Cd cd = cdService.getById(id);
        if(cd==null){
            return new ResultVO(ResStatus.NO,"CD不存在，删除失败",id);
        }
        boolean remove = cdService.removeById(id);
        if(remove){
            return new ResultVO(ResStatus.OK,"CD删除成功",id);
        }else {
            return new ResultVO(ResStatus.NO,"CD删除失败",id);
        }
    }

    @PostMapping("/updata")
    @ApiOperation("修改CD信息")
    public ResultVO updateCd(@RequestBody Map<String,String> param){
        Cd cd = new Cd();
        cd.setId(Integer.valueOf(param.get("id")));
        cd.setName(param.get("name"));
        cd.setCateId(Integer.valueOf(param.get("cateId")));
        cd.setPrice(Double.valueOf(param.get("price")));
        cd.setAuthor(param.get("author"));
        cd.setCompany(param.get("company"));
        cd.setRegion(param.get("region"));
        boolean update = cdService.updateById(cd);
        if(update){
            return new ResultVO(ResStatus.OK,"更新成功",cd);
        }else {
            return new ResultVO(ResStatus.NO,"更新失败",cd);
        }
    }

}
