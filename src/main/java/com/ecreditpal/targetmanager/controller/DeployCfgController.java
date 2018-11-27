package com.ecreditpal.targetmanager.controller;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ResponseMes;

import com.ecreditpal.targetmanager.mapper.entity.DeployCfg;
import com.ecreditpal.targetmanager.service.DeployCfgService;
import com.ecreditpal.targetmanager.util.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

/**
 * @author zhengzhenwen
 * @data 2018/11/8 16:04
 * @description
 **/
@RestController
@RequestMapping("deployCfg")
public class DeployCfgController {
    @Autowired
    private DeployCfgService deployCfgService;

    @ApiOperation(value = "根据指标id获取", notes = "指标调度配置")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseMes list(@RequestParam(value = "indiId", required = false) Integer indiId) {
        DeployCfg example = new DeployCfg();
        example.setIndiId(indiId);
        example.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        ResponseMes res = deployCfgService.selectByExample(example);
        return res;
    }

    @ApiOperation(value = "根据指标id获取", notes = "指标配置管理")
    @RequestMapping(value = "/manage_list", method = RequestMethod.POST)
    public ResponseMes mangeList(@RequestParam(value = "indiId", required = false) Integer indiId,
                                 @RequestParam(value = "dataDt", required = false) String dataDt) throws ParseException {
        DeployCfg example = new DeployCfg();
        Date date;
        if(dataDt!=null &&!StringUtils.isBlank(dataDt)){
            date = DateUtil.getDate(dataDt);
            example.setStartDataDt(date);
            example.setEndDataDt(DateUtil.getDiffDay(date,1));
        }
        example.setIndiId(indiId);
        example.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        ResponseMes res = deployCfgService.selectManageByExample(example);
        return res;
    }

    @ApiOperation(value = "添加", notes = "指标调度配置")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseMes add(@RequestParam(value = "indiId") Integer indiId,
                           @RequestParam("processInst") String processInst,
                           @RequestParam("instType") Integer instType,
                           @RequestParam("isValid") Integer isValid) {
        DeployCfg example = new DeployCfg();
        example.setProcessInst(processInst);
        example.setIndiId(indiId);
        example.setInstType(instType);
        example.setIsValid(isValid);
        ResponseMes res = deployCfgService.addByExample(example);
        return res;
    }

    @ApiOperation(value = "修改", notes = "指标调度配置")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id,
                              @RequestParam("processInst") String processInst,
                              @RequestParam("instType") Integer instType,
                              @RequestParam("isValid") Integer isValid) {
        DeployCfg example = new DeployCfg();
        example.setId(id);
        example.setProcessInst(processInst);
        example.setInstType(instType);
        example.setIsValid(isValid);
        ResponseMes res = deployCfgService.updateByExample(example);
        return res;
    }

    @ApiOperation(value = "根据id删除", notes = "指标调度配置")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id) {
        DeployCfg example = new DeployCfg();
        example.setId(id);
        ResponseMes res = deployCfgService.deleteByExample(example);
        return res;
    }

}
