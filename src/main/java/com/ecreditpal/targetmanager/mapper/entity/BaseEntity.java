package com.ecreditpal.targetmanager.mapper.entity;



import com.ecreditpal.targetmanager.util.EntityToStringUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhengzhenwen
 * @date 2018/9/25 上午10:10
 * @description
 **/
public class BaseEntity {

    private String orderByClause;//排序方式，如：createTime desc, id asc

    private Integer first;//第一条数据位置

    private Integer count;//条数

    private Date startCreateTime;

    private Date endCreateTime;

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    @Override
    public String toString(){
        return EntityToStringUtil.getString(this,this.getClass( ));
    }
    public static  void main(String args[]){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        System.out.println(uuidStr);
    }
}



