package com.ecreditpal.targetmanager.mapper;

import com.ecreditpal.targetmanager.mapper.entity.DeriveBasic;
import com.ecreditpal.targetmanager.mapper.entity.IndiItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeriveBasicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeriveBasic record);

    int insertSelective(DeriveBasic record);

    DeriveBasic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeriveBasic record);

    int updateByPrimaryKey(DeriveBasic record);

    List<DeriveBasic> selectByExample(DeriveBasic deriveBasic);

    int deleteByItem(IndiItem item);

    List<DeriveBasic> selectJoinByExample(DeriveBasic record);
}