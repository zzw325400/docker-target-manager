package com.ecreditpal.targetmanager.controller;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;
import com.ecreditpal.targetmanager.mapper.entity.IndiData;
import com.ecreditpal.targetmanager.service.IndiDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzhenwen
 * @data 2018/11/12 19:01
 * @description
 **/
@RestController
@RequestMapping("indiData")
public class IndiDataController {
    @Autowired
    private IndiDataService indiDataService;
    @ApiOperation(value = "根据指标Id获取所有数据", notes = "指标结果视图")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseMes list(@RequestParam(value = "indiId",required = false) Integer indiId,
                            @RequestParam(value = "pageSize",required = false) Integer pageSize,
                            @RequestParam(value = "pageNum",required = false) Integer pageNum){
        IndiData example = new IndiData();
        example.setIndiId(indiId);
        ResponseMes res = indiDataService.selectByExample(example,pageSize,pageNum);
        return res;
    }
    @ApiOperation(value = "添加", notes = "指标结果视图")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseMes add(){
        IndiData example = new IndiData();
        ResponseMes res = indiDataService.addByExample(example);
        return res;
    }
    @ApiOperation(value = "修改", notes = "指标结果视图")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseMes update(){
        IndiData example = new IndiData();
        ResponseMes res = indiDataService.updateByExample(example);
        return res;
    }

}
