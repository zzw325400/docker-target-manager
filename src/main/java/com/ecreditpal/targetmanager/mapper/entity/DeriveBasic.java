package com.ecreditpal.targetmanager.mapper.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(value={"orderByClause","first","count","startCreateTime","endCreateTime"})
public class DeriveBasic extends BaseEntity {
    private Integer id;

    private Integer deriveId;

    private Integer basicId;

    private String basicName;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeriveId() {
        return deriveId;
    }

    public void setDeriveId(Integer deriveId) {
        this.deriveId = deriveId;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public boolean equal(DeriveBasic deriveBasic) {
        return this.basicId == deriveBasic.getBasicId() && this.deriveId == deriveBasic.getDeriveId();
    }
}