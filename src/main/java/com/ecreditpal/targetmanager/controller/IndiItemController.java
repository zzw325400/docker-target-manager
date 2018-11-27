package com.ecreditpal.targetmanager.controller;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;
import com.ecreditpal.targetmanager.mapper.entity.IndiItem;
import com.ecreditpal.targetmanager.service.IndiItemService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/item")
public class IndiItemController {
    @Autowired
    private IndiItemService indiItemService;

    @ApiOperation(value = "条件筛选list", notes = "指标项")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseMes list(@RequestParam("type") Integer type,
                            @RequestParam(value = "classify1", required = false) Integer classify1,
                            @RequestParam(value = "classify2", required = false) Integer classify2,
                            @RequestParam(value = "classify3", required = false) Integer classify3,
                            @RequestParam(value = "pageSize", required = false) Integer pageSize,
                            @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        IndiItem example = new IndiItem();
        example.setType(type);
        example.setClassify1(classify1);
        example.setClassify2(classify2);
        example.setClassify3(classify3);
        example.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        ResponseMes res = indiItemService.selectByExample(example, pageNum, pageSize);
        return res;
    }

    @ApiOperation(value = "添加", notes = "指标项")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseMes add(@RequestParam("type") Integer type,
                           @RequestParam("classify1") Integer classify1,
                           @RequestParam(value = "classify2") Integer classify2,
                           @RequestParam(value = "classify3") Integer classify3,
                           @RequestParam("indiModel") Integer indiModel,
                           @RequestParam("indiType") Integer indiType,
                           @RequestParam("indiName") String indiName,
                           @RequestParam(value = "rule",required = false) String rule,
                           @RequestParam(value = "orgId",required = false) Integer orgId,
                           @RequestParam(value = "version", required = false) String version,
                           @RequestParam(value = "comment", required = false) String comment,
                           @RequestParam(value = "baseList[]", required = false) Integer[] baseList) {
        IndiItem example = new IndiItem();
        example.setType(type);
        example.setClassify1(classify1);
        example.setClassify2(classify2);
        example.setClassify3(classify3);
        example.setIndiModel(indiModel);
        example.setIndiType(indiType);
        example.setIndiName(indiName);
        example.setRule(rule);
        example.setInstId(orgId);
        example.setVersion(version);
        example.setComment(comment);
        ResponseMes res = indiItemService.addByExample(example, baseList);
        return res;
    }

    @ApiOperation(value = "修改", notes = "指标项")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseMes update(@RequestParam("id") Integer id,
                              @RequestParam(value = "indiType", required = false) Integer indiType,
                              @RequestParam(value = "indiName", required = false) String indiName,
                              @RequestParam(value = "rule", required = false) String rule,
                              @RequestParam(value = "comment", required = false) String comment,
                              @RequestParam(value = "version", required = false) String version,
                              @RequestParam(value = "baseList[]", required = false) Integer[] baseList) {
        IndiItem example = new IndiItem();
        example.setId(id);
        example.setIndiName(indiName);
        example.setRule(rule);
        example.setComment(comment);
        example.setVersion(version);
        ResponseMes res = indiItemService.updateByExample(example, baseList);
        return res;
    }

    @ApiOperation(value = "删除", notes = "指标项")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseMes delete(@RequestParam("id") Integer id) {
        IndiItem example = new IndiItem();
        example.setId(id);
        ResponseMes res = indiItemService.deleteByExample(example);
        return res;
    }
}
