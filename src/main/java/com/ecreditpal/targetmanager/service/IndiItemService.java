package com.ecreditpal.targetmanager.service;


import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.entity.IndiItem;

public interface IndiItemService {
    ResponseMes selectByExample(IndiItem example, Integer pageNum, Integer pageSize);

    ResponseMes addByExample(IndiItem example,Integer[] baseList);

    ResponseMes updateByExample(IndiItem example, Integer[] baseList);

    ResponseMes deleteByExample(IndiItem example);
}
