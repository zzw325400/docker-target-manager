package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.DeriveBasicMapper;
import com.ecreditpal.targetmanager.mapper.IndiItemMapper;
import com.ecreditpal.targetmanager.mapper.entity.DeriveBasic;
import com.ecreditpal.targetmanager.mapper.entity.IndiItem;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhenwen
 * @data 2018/11/10 11:55
 * @description
 **/
@Service
public class IndiItemServiceImp implements IndiItemService {
    @Autowired
    private IndiItemMapper indiItemMapper;
    @Autowired
    private DeriveBasicMapper deriveBasicMapper;

    static final Logger logger = LoggerFactory.getLogger(IndiItemServiceImp.class);

    @Override
    public ResponseMes selectByExample(IndiItem example, Integer pageNum, Integer pageSize) {
        //logger.info(example.toString());
        int count = indiItemMapper.selectCountByExample(example);
        if (pageNum != null && pageSize != null)
            PageHelper.startPage(pageNum, pageSize);
        List<IndiItem> list = indiItemMapper.selectJoinByExample(example);
        //logger.info(list.toString());

        DeriveBasic record = new DeriveBasic();
        for (IndiItem indiItem : list) {
            record.setDeriveId(indiItem.getId());
            record.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
            indiItem.setBaseList(deriveBasicMapper.selectJoinByExample(record));
        }
        ResponseMes res = new ResponseMes();
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("list", list);
        res.setData(map);
        return res;
    }

    @Override
    public ResponseMes addByExample(IndiItem example, Integer[] baseList) {
       // logger.info(example.toString());
        example.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        indiItemMapper.insertSelective(example);
        if (baseList != null && baseList.length > 0) {
            for (Integer baseId : baseList) {
                DeriveBasic record = new DeriveBasic();
                record.setBasicId(baseId);
                record.setDeriveId(example.getId());
                deriveBasicMapper.insertSelective(record);
            }
        }

        ResponseMes res = new ResponseMes();
        return res;
    }

    @Override
    public ResponseMes updateByExample(IndiItem example, Integer[] baseList) {
        indiItemMapper.updateByPrimaryKeySelective(example);
        if (baseList != null && baseList.length > 0) {
            for (Integer i : baseList) {
                DeriveBasic record = new DeriveBasic();
                record.setDeriveId(example.getId());
                record.setBasicId(i);
                deriveBasicMapper.insertSelective(record);
            }
            example.setBaseIds(Arrays.asList(baseList));
            logger.info(example.toString());
            deriveBasicMapper.deleteByItem(example);
        }
        ResponseMes res= new ResponseMes();
        return res;
    }

    @Override
    public ResponseMes deleteByExample(IndiItem example) {
        deriveBasicMapper.deleteByItem(example);
        example.setStatus((Integer) ConstValue.STATUS_DELETED.getValue());
        indiItemMapper.updateByPrimaryKeySelective(example);
        ResponseMes res = new ResponseMes();
        return res;
    }

}
