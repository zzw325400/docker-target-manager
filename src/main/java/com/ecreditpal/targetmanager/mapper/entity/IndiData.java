package com.ecreditpal.targetmanager.mapper.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
@JsonIgnoreProperties(value={"orderByClause","first","count","startCreateTime","endCreateTime"})
public class IndiData extends BaseEntity {
    private Integer id;

    private Date dataDt;

    private Integer indiId;

    private String indiName;

    private Integer orgId;

    private String currCd;

    private String orgName;

    private String orgCode;

    private BigDecimal dataValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataDt() {
        return dataDt;
    }

    public void setDataDt(Date dataDt) {
        this.dataDt = dataDt;
    }

    public Integer getIndiId() {
        return indiId;
    }

    public void setIndiId(Integer indiId) {
        this.indiId = indiId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getCurrCd() {
        return currCd;
    }

    public void setCurrCd(String currCd) {
        this.currCd = currCd == null ? null : currCd.trim();
    }

    public BigDecimal getDataValue() {
        return dataValue;
    }

    public void setDataValue(BigDecimal dataValue) {
        this.dataValue = dataValue;
    }

    public String getIndiName() {
        return indiName;
    }

    public void setIndiName(String indiName) {
        this.indiName = indiName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}