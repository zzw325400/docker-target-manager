package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ErrorCode;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.DeployCfgMapper;
import com.ecreditpal.targetmanager.mapper.entity.DeployCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhenwen
 * @data 2018/11/12 17:42
 * @description
 **/
@Service
public class DeployCfgServiceImp implements DeployCfgService {
    @Autowired
    private DeployCfgMapper deployCfgMapper;
    static final Logger logger = LoggerFactory.getLogger(DeployCfgServiceImp.class);

    @Override
    public ResponseMes selectByExample(DeployCfg example) {
        List<DeployCfg> list = deployCfgMapper.selectJoinByExample(example);
        //logger.info(example.toString());
        Map map = new HashMap<String, Object>();
        map.put("list", list);
        ResponseMes responseMes = new ResponseMes();
        responseMes.setData(map);
        return responseMes;
    }

    @Override
    public ResponseMes addByExample(DeployCfg example) {
        ResponseMes responseMes = new ResponseMes();
        DeployCfg deployCfg = new DeployCfg();
        deployCfg.setIndiId(example.getIndiId());
        deployCfg.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        List<DeployCfg> dbList= deployCfgMapper.selectJoinByExample(deployCfg);
        if(dbList.size()>0){
            responseMes.setCode(ErrorCode.CANT_ADD_CFG.getCode());
            responseMes.setMessage(ErrorCode.CANT_ADD_CFG.getMessage());
            return responseMes;
        }
        deployCfgMapper.insertSelective(example);

        return responseMes;
    }

    @Override
    public ResponseMes updateByExample(DeployCfg example) {
        //logger.info(example.toString());
        deployCfgMapper.updateByPrimaryKeySelective(example);
        ResponseMes responseMes = new ResponseMes();
        return responseMes;
    }

    @Override
    public ResponseMes deleteByExample(DeployCfg example) {
        example.setStatus((Integer) ConstValue.STATUS_DELETED.getValue());
        deployCfgMapper.updateByPrimaryKeySelective(example);
        ResponseMes responseMes = new ResponseMes();
        return responseMes;
    }

    @Override
    public ResponseMes selectManageByExample(DeployCfg example) {
        List<DeployCfg> list = deployCfgMapper.selectManageJoinByExample(example);
        //logger.info(example.toString());
        Map map = new HashMap<String, Object>();
        map.put("list", list);
        ResponseMes responseMes = new ResponseMes();
        responseMes.setData(map);
        return responseMes;
    }
}
