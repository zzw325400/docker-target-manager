package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.IndiDataMapper;
import com.ecreditpal.targetmanager.mapper.entity.IndiData;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhenwen
 * @data 2018/11/13 10:14
 * @description
 **/
@Service
public class IndiDataServiceImp implements IndiDataService {
    @Autowired
    private IndiDataMapper indiDataMapper;
    static final Logger logger = LoggerFactory.getLogger(IndiDataServiceImp.class);

    @Override
    public ResponseMes selectByExample(IndiData example, Integer pageSize, Integer pageNum) {

        int count = indiDataMapper.selectCountByExample(example);
        if (pageNum != null && pageSize != null)
            PageHelper.startPage(pageNum, pageSize);
        List<IndiData> list = indiDataMapper.selectJoinByExample(example);
       // logger.info(list.toString());
        Map map = new HashMap<String, Object>();
        map.put("count",count);
        map.put("list", list);
        ResponseMes responseMes = new ResponseMes();
        responseMes.setData(map);
        return responseMes;
    }

    @Override
    public ResponseMes addByExample(IndiData example) {
        indiDataMapper.insertSelective(example);
        ResponseMes responseMes = new ResponseMes();
        return responseMes;
    }

    @Override
    public ResponseMes updateByExample(IndiData example) {
        indiDataMapper.updateByPrimaryKeySelective(example);
        return null;
    }

}
