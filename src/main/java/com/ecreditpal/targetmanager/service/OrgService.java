package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.Organization;

/**
 * @author zhengzhenwen
 * @data 2018/11/14 17:43
 * @description
 **/
public interface OrgService {
    ResponseMes selectByExample(Organization example);

    ResponseMes addByExample(Organization example);

    ResponseMes updateByExample(Organization example);

    ResponseMes deleteByExample(Organization example);
}
