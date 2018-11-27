package com.ecreditpal.targetmanager.mapper;

import com.ecreditpal.targetmanager.mapper.entity.IndiType;
import org.springframework.stereotype.Repository;

@Repository
public interface IndiTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiType record);

    int insertSelective(IndiType record);

    IndiType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiType record);

    int updateByPrimaryKey(IndiType record);
}