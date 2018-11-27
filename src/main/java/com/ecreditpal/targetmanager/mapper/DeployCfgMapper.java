package com.ecreditpal.targetmanager.mapper;

import com.ecreditpal.targetmanager.mapper.entity.DeployCfg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeployCfgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeployCfg record);

    int insertSelective(DeployCfg record);

    DeployCfg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeployCfg record);

    int updateByPrimaryKey(DeployCfg record);

    List<DeployCfg> selectJoinByExample(DeployCfg record);

    List<DeployCfg> selectManageJoinByExample(DeployCfg record);
}