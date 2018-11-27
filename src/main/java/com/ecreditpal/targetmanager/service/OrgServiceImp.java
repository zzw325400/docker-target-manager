package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.OrganizationMapper;
import com.ecreditpal.targetmanager.mapper.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhenwen
 * @data 2018/11/14 17:43
 * @description
 **/
@Service
public class OrgServiceImp implements OrgService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public ResponseMes selectByExample(Organization example) {
        ResponseMes res = new ResponseMes();
        List<Organization> list = organizationMapper.selectByExample(example);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        res.setData(map);
        return res;
    }

    @Override
    public ResponseMes addByExample(Organization example) {
        organizationMapper.insertSelective(example);
        ResponseMes res = new ResponseMes();
        return res;
    }

    @Override
    public ResponseMes updateByExample(Organization example) {
        organizationMapper.updateByPrimaryKeySelective(example);
        ResponseMes res = new ResponseMes();
        return res;
    }

    @Override
    public ResponseMes deleteByExample(Organization example) {
        example.setStatus((Integer) ConstValue.STATUS_DELETED.getValue());
        organizationMapper.insertSelective(example);
        ResponseMes res = new ResponseMes();
        return res;
    }
}
