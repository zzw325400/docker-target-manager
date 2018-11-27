package com.ecreditpal.targetmanager.common;

/**
 * @author zhengzhenwen
 * @data 2018/11/8 15:51
 * @description
 **/
public enum ConstValue {
    STATUS_NORMAL(0, "正常"),
    STATUS_DELETED(1, "已删除"),
    ROOT(0,"根节点"),
    DEPTH_FIRST(1,"一级节点深度"),
    NODE_DEPTH(4,"节点最大深度"),
    CLASSIFY_NULL("00","默认指标类别代码"),
    TYPE_BASIC(0, "基本指标类别"),
    TYPE_DERIVE(1, "衍生指标类别"),
    INST_TYPE_PROCESS(1,"存储过程"),
    INST_TYPE_SQL(0,"Sql语句");


    private Object value;

    private String des;

    ConstValue(Object value, String des) {
        this.value = value;
        this.des = des;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
