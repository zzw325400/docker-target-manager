package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.IndiData;

public interface IndiDataService {
    ResponseMes selectByExample(IndiData example, Integer pageSize, Integer pageNum);

    ResponseMes addByExample(IndiData example);

    ResponseMes updateByExample(IndiData example);
}
