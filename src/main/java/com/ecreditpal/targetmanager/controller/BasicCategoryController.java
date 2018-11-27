package com.ecreditpal.targetmanager.controller;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;
import com.ecreditpal.targetmanager.service.BasicCategoryService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzhenwen
 * @data 2018/11/8 16:04
 * @description
 **/
@RestController
@RequestMapping("/category")
public class BasicCategoryController {

    @Autowired
    private BasicCategoryService basicCategoryService;

    @ApiOperation(value = "根据父节点id获取", notes = "指标分类项")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseMes list(@RequestParam(value = "pid",required = false) Integer pid,
                            @RequestParam(value = "pageSize",required = false) Integer pageSize,
                            @RequestParam(value = "pageNum",required = false) Integer pageNum){
        BasicCategory example = new BasicCategory();
        example.setPid(pid);
        example.setStatus((Integer)ConstValue.STATUS_NORMAL.getValue());
        ResponseMes res = basicCategoryService.selectByExample(example,pageSize,pageNum);
        return res;
    }

    @ApiOperation(value = "添加", notes = "指标分类项")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseMes add(@RequestParam(value = "pid",required = false) Integer pid,
                           @RequestParam("name")String name,
                           @RequestParam("code")String code){
        BasicCategory example = new BasicCategory();
        example.setPid(pid);
        example.setName(name);
        example.setCode(code);
        ResponseMes res = basicCategoryService.addByExample(example);
        return res;
    }

    @ApiOperation(value = "修改", notes = "指标分类项")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id,
                              @RequestParam(value = "name",required = false)String name,
                              @RequestParam(value = "code",required = false)String code){
        BasicCategory example = new BasicCategory();
        example.setId(id);
        example.setName(name);
        example.setCode(StringUtils.leftPad(code,2,"0"));
        ResponseMes res = basicCategoryService.updateByExample(example);
        return res;
    }

    @ApiOperation(value = "删除", notes = "指标分类项")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id){
        BasicCategory example = new BasicCategory();
        example.setId(id);
        ResponseMes res = basicCategoryService.deleteByExample(example);
        return res;
    }

}
