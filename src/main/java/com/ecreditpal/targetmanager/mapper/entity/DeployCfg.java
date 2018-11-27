package com.ecreditpal.targetmanager.mapper.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(value = {"orderByClause", "first", "count", "startCreateTime", "endCreateTime"})
public class DeployCfg extends BaseEntity {
    private Integer id;

    private Integer indiId;

    private String indiName;

    private String indiCode;

    private Integer isValid;

    private Date dataDt;

    private Date startDataDt;

    private Date endDataDt;

    private String processInst;

    private Integer instType;

    private Integer createdBy;

    private Date createDt;

    private Integer lastEditBy;

    private Date lastEditDt;

    private Integer status;

    private Date latestDataDate;

    private Integer editTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndiId() {
        return indiId;
    }

    public void setIndiId(Integer indiId) {
        this.indiId = indiId;
    }

    public String getProcessInst() {
        return processInst;
    }

    public void setProcessInst(String processInst) {
        this.processInst = processInst == null ? null : processInst.trim();
    }

    public Integer getInstType() {
        return instType;
    }

    public void setInstType(Integer instType) {
        this.instType = instType;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIndiName() {
        return indiName;
    }

    public void setIndiName(String indiName) {
        this.indiName = indiName;
    }

    public Date getLatestDataDate() {
        return latestDataDate;
    }

    public void setLatestDataDate(Date latestDataDate) {
        this.latestDataDate = latestDataDate;
    }

    public String getIndiCode() {
        return indiCode;
    }

    public void setIndiCode(String indiCode) {
        this.indiCode = indiCode;
    }

    public Integer getEditTimes() {
        return editTimes;
    }

    public void setEditTimes(Integer editTimes) {
        this.editTimes = editTimes;
    }

    public Date getDataDt() {
        return dataDt;
    }

    public void setDataDt(Date dataDt) {
        this.dataDt = dataDt;
    }

    public Date getStartDataDt() {
        return startDataDt;
    }

    public void setStartDataDt(Date startDataDt) {
        this.startDataDt = startDataDt;
    }

    public Date getEndDataDt() {
        return endDataDt;
    }

    public void setEndDataDt(Date endDataDt) {
        this.endDataDt = endDataDt;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}