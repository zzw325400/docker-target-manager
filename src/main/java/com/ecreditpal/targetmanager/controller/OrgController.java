package com.ecreditpal.targetmanager.controller;

import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.Organization;
import com.ecreditpal.targetmanager.service.OrgService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzhenwen
 * @data 2018/11/14 17:40
 * @description
 **/
@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @ApiOperation(value = "根据父节点id获取", notes = "指标分类项")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseMes list(@RequestParam(value = "id",required = false) Integer pid,
                            @RequestParam(value = "pageSize",required = false) Integer pageSize,
                            @RequestParam(value = "pageNum",required = false) Integer pageNum){
        Organization example = new Organization();
        ResponseMes res = orgService.selectByExample(example);
        return res;
    }

    @ApiOperation(value = "添加", notes = "指标分类项")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseMes add(@RequestParam(value = "pid",required = false) Integer pid,
                           @RequestParam("name")String name,
                           @RequestParam("code")String code){
        Organization example = new Organization();
        ResponseMes res = orgService.addByExample(example);
        return res;
    }

    @ApiOperation(value = "修改", notes = "指标分类项")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id,
                              @RequestParam(value = "name",required = false)String name,
                              @RequestParam(value = "code",required = false)String code){
        Organization example = new Organization();
        ResponseMes res = orgService.updateByExample(example);
        return res;
    }

    @ApiOperation(value = "删除", notes = "指标分类项")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id){
        Organization example = new Organization();
        ResponseMes res = orgService.deleteByExample(example);
        return res;
    }
}
