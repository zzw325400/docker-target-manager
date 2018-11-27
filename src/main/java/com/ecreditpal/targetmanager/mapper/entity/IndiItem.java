package com.ecreditpal.targetmanager.mapper.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(value={"orderByClause","first","count","startCreateTime","endCreateTime"})
public class IndiItem extends BaseEntity {
    private Integer id;

    private Integer classify1;

    private String classify1Name;

    private Integer classify2;

    private String classify2Name;

    private Integer classify3;

    private String classify3Name;

    private Integer indiModel;

    private String indiModelName;

    private String indiCode;

    private String indiName;

    private Integer indiType;

    private String rule;

    private Integer createdBy;

    private Date createDt;

    private Integer lastEditBy;

    private Date lastEditDt;

    private Integer instId;

    private String instName;

    private Integer status;

    private Integer type;

    private String version;

    private String comment;

    private List<Integer> BaseIds;

    private List<DeriveBasic> baseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassify1() {
        return classify1;
    }

    public void setClassify1(Integer classify1) {
        this.classify1 = classify1 ;
    }

    public Integer getClassify2() {
        return classify2;
    }

    public void setClassify2(Integer classify2) {
        this.classify2 = classify2;
    }

    public Integer getClassify3() {
        return classify3;
    }

    public void setClassify3(Integer classify3) {
        this.classify3 = classify3 ;
    }

    public Integer getIndiModel() {
        return indiModel;
    }

    public void setIndiModel(Integer indiModel) {
        this.indiModel = indiModel ;
    }

    public String getIndiCode() {
        return indiCode;
    }

    public void setIndiCode(String indiCode) {
        this.indiCode = indiCode;
    }

    public String getIndiName() {
        return indiName;
    }

    public void setIndiName(String indiName) {
        this.indiName = indiName == null ? null : indiName.trim();
    }

    public Integer getIndiType() {
        return indiType;
    }

    public void setIndiType(Integer indiType) {
        this.indiType = indiType;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getLastEditBy() {
        return lastEditBy;
    }

    public void setLastEditBy(Integer lastEditBy) {
        this.lastEditBy = lastEditBy;
    }

    public Date getLastEditDt() {
        return lastEditDt;
    }

    public void setLastEditDt(Date lastEditDt) {
        this.lastEditDt = lastEditDt;
    }

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public List<Integer> getBaseIds() {
        return BaseIds;
    }

    public void setBaseIds(List<Integer> baseIds) {
        BaseIds = baseIds;
    }

    public String getClassify1Name() {
        return classify1Name;
    }

    public void setClassify1Name(String classify1Name) {
        this.classify1Name = classify1Name;
    }

    public String getClassify2Name() {
        return classify2Name;
    }

    public void setClassify2Name(String classify2Name) {
        this.classify2Name = classify2Name;
    }

    public String getClassify3Name() {
        return classify3Name;
    }

    public void setClassify3Name(String classify3Name) {
        this.classify3Name = classify3Name;
    }

    public String getIndiModelName() {
        return indiModelName;
    }

    public void setIndiModelName(String indiModelName) {
        this.indiModelName = indiModelName;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public List<DeriveBasic> getBaseList() {
        return baseList;
    }

    public void setBaseList(List<DeriveBasic> baseList) {
        this.baseList = baseList;
    }
}