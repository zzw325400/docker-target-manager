package com.ecreditpal.targetmanager.mapper;

import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicCategory record);

    int insertSelective(BasicCategory record);

    BasicCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasicCategory record);

    int updateByPrimaryKey(BasicCategory record);

    List<BasicCategory> selectByExample(BasicCategory example);

    int selectCountByExample(BasicCategory example);
}