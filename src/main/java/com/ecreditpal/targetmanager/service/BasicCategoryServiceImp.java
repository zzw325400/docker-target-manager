package com.ecreditpal.targetmanager.service;

import com.ecreditpal.targetmanager.common.ConstValue;
import com.ecreditpal.targetmanager.common.ErrorCode;
import com.ecreditpal.targetmanager.common.ResponseMes;
import com.ecreditpal.targetmanager.mapper.BasicCategoryMapper;
import com.ecreditpal.targetmanager.mapper.entity.BasicCategory;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhenwen
 * @data 2018/11/9 11:19
 * @description
 **/
@Service
@Transactional
public class BasicCategoryServiceImp implements BasicCategoryService {
    @Autowired
    BasicCategoryMapper basicCategoryMapper;
    static final Logger logger = LoggerFactory.getLogger(BasicCategoryServiceImp.class);

    @Override
    public ResponseMes selectByExample(BasicCategory example, Integer pageSize, Integer pageNum) {
        if (example.getPid() == null) {
            example.setClassify((Integer) ConstValue.DEPTH_FIRST.getValue());
        }
        //logger.info(example.toString());
        int count = basicCategoryMapper.selectCountByExample(example);
        if (pageNum != null && pageSize != null)
            PageHelper.startPage(pageNum, pageSize);
        List<BasicCategory> list = basicCategoryMapper.selectByExample(example);

        Map map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("count", count);
        ResponseMes responseMes = new ResponseMes();
        responseMes.setData(map);
        return responseMes;
    }

    @Override
    public ResponseMes addByExample(BasicCategory example) {
        ResponseMes res = new ResponseMes();
        BasicCategory parent = null;
        if (example.getPid() != null) {
            parent = basicCategoryMapper.selectByPrimaryKey(example.getPid());
            if (parent == null) {
                res.setCode(ErrorCode.NODE_NOT_EXISTS.getCode());
                res.setMessage(ErrorCode.NODE_NOT_EXISTS.getMessage());
                return res;
            }

            if (parent.getClassify() == ConstValue.NODE_DEPTH.getValue()) {
                res.setCode(ErrorCode.NODE_CANT_OWN_SON.getCode());
                res.setMessage(ErrorCode.NODE_CANT_OWN_SON.getMessage());
                return res;
            }
        }

        if(example.getCode().length()>2){
            res.setMessage(ErrorCode.CODE_LENGTH_LIMIT.getMessage());
            res.setCode(ErrorCode.CODE_LENGTH_LIMIT.getCode());
            return res;
        }
        BasicCategory record = new BasicCategory();
        record.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        record.setCode(example.getCode());
        if(example.getPid()!=null) {
            record.setPid(example.getPid());
        }else{
            record.setPid(0);
        }
        List<BasicCategory> listByCode = basicCategoryMapper.selectByExample(record);
        if (listByCode.size() > 0) {
            res.setCode(ErrorCode.NODE_CODE_EXISTS.getCode());
            res.setMessage(ErrorCode.NODE_CODE_EXISTS.getMessage());
            return res;
        }

        record.setCode(null);
        record.setName(example.getName());
        List<BasicCategory> listByName = basicCategoryMapper.selectByExample(record);
        if (listByName.size() > 0) {
            res.setCode(ErrorCode.NODE_NAME_EXISTS.getCode());
            res.setMessage(ErrorCode.NODE_NAME_EXISTS.getMessage());
            return res;
        }

        record.setCode(example.getCode());
        if (parent !=null) {
            record.setClassify(parent.getClassify() + 1);
        }else{
            record.setClassify((Integer) ConstValue.DEPTH_FIRST.getValue());
        }
        basicCategoryMapper.insertSelective(record);
        return res;
    }

    @Override
    public ResponseMes updateByExample(BasicCategory example) {
        ResponseMes res = new ResponseMes();
        BasicCategory dbBasicCategory = basicCategoryMapper.selectByPrimaryKey(example.getId());
        if (dbBasicCategory == null) {
            res.setCode(ErrorCode.NODE_NOT_EXISTS.getCode());
            res.setMessage(ErrorCode.NODE_NOT_EXISTS.getMessage());
            return res;
        }

        BasicCategory record = new BasicCategory();
        record.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        record.setCode(example.getCode());
        record.setPid(dbBasicCategory.getPid());
        logger.info(record.toString());
        logger.info(example.toString());
        List<BasicCategory> listByCode = basicCategoryMapper.selectByExample(record);
        if (listByCode.size() > 0) {
            for (BasicCategory bc : listByCode) {
                if (bc.getId() != example.getId()) {
                    res.setCode(ErrorCode.NODE_CODE_EXISTS.getCode());
                    res.setMessage(ErrorCode.NODE_CODE_EXISTS.getMessage());
                    return res;
                }
            }

        }

        record.setCode(null);
        record.setName(example.getName());
        List<BasicCategory> listByName = basicCategoryMapper.selectByExample(record);
        if (listByName.size() > 0) {
            for (BasicCategory bc : listByCode) {
                if (bc.getId() != example.getId())
                    res.setCode(ErrorCode.NODE_NAME_EXISTS.getCode());
                res.setMessage(ErrorCode.NODE_NAME_EXISTS.getMessage());
                return res;
            }
        }
        dbBasicCategory.setName(example.getName());
        dbBasicCategory.setCode(example.getCode());
        basicCategoryMapper.updateByPrimaryKey(dbBasicCategory);
        return res;
    }

    @Override
    public ResponseMes deleteByExample(BasicCategory example) {
        ResponseMes res = new ResponseMes();
        BasicCategory dbBasicCategory = basicCategoryMapper.selectByPrimaryKey(example.getId());
        if (dbBasicCategory == null) {
            res.setCode(ErrorCode.NODE_NOT_EXISTS.getCode());
            res.setMessage(ErrorCode.NODE_NOT_EXISTS.getMessage());
            return res;
        }
        Map<Integer, BasicCategory> allNode = getAllNode();
        List<BasicCategory> list = new ArrayList<>();
        getNodeTreeByRoot(list, example.getId(), allNode);
        if (list.size() > 0) {
            for (BasicCategory bc : list) {
                bc.setStatus((Integer) ConstValue.STATUS_DELETED.getValue());
                basicCategoryMapper.updateByPrimaryKeySelective(bc);
            }
        }
        dbBasicCategory.setStatus((Integer) ConstValue.STATUS_DELETED.getValue());
        basicCategoryMapper.updateByPrimaryKeySelective(dbBasicCategory);
        return res;
    }

    public void getNodeTreeByRoot(List<BasicCategory> list, Integer id, Map<Integer, BasicCategory> map) {
        List<BasicCategory> sonList = getSonNode(id, map);
        list.addAll(sonList);
        if (sonList.size() > 0) {
            for (BasicCategory bc : sonList) {
                getNodeTreeByRoot(list, bc.getId(), map);
            }
        }

    }

    public Map<Integer, BasicCategory> getAllNode() {
        Map<Integer, BasicCategory> map = new HashMap<>();
        BasicCategory basicCategory = new BasicCategory();
        basicCategory.setStatus((Integer) ConstValue.STATUS_NORMAL.getValue());
        List<BasicCategory> list = basicCategoryMapper.selectByExample(basicCategory);
        for (BasicCategory bc : list) {
            map.put(bc.getId(), bc);
        }
        return map;
    }

    private List<BasicCategory> getSonNode(Integer id, Map<Integer, BasicCategory> map) {

        List<BasicCategory> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (id.equals(map.get(key).getPid())) {
                list.add(map.get(key));
            }
        }
        return list;
    }
}
