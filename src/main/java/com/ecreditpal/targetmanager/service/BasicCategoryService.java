package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;

public interface BasicCategoryService {
    ResponseMes selectByExample(BasicCategory example, Integer pageSize, Integer pageNum);

    ResponseMes addByExample(BasicCategory example);

    ResponseMes updateByExample(BasicCategory example);

    ResponseMes deleteByExample(BasicCategory example);
}
