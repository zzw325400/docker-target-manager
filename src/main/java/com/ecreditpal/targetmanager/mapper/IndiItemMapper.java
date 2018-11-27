package com.ecreditpal.targetmanager.mapper;

import com.ecreditpal.targetmanager.mapper.entity.IndiItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndiItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiItem record);

    int insertSelective(IndiItem record);

    IndiItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiItem record);

    int updateByPrimaryKey(IndiItem record);

    List<IndiItem> selectByExample(IndiItem example);

    List<IndiItem> selectJoinByExample(IndiItem example);

    int selectCountByExample(IndiItem example);
}