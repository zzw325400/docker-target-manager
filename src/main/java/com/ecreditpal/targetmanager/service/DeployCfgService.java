package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;
import com.ecreditpal.targetmanager.mapper.entity.DeployCfg;

public interface DeployCfgService {
    ResponseMes selectByExample(DeployCfg example);

    ResponseMes addByExample(DeployCfg example);

    ResponseMes updateByExample(DeployCfg example);

    ResponseMes deleteByExample(DeployCfg example);

    ResponseMes selectManageByExample(DeployCfg example);
}
