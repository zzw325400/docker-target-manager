package com.ecreditpal.targetmanager.mapper;

import com.ecreditpal.targetmanager.mapper.entity.IndiData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndiDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiData record);

    int insertSelective(IndiData record);

    IndiData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiData record);

    int updateByPrimaryKey(IndiData record);

    List<IndiData> selectJoinByExample(IndiData example);

    int selectCountByExample(IndiData example);
}