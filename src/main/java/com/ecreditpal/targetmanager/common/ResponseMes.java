package com.ecreditpal.targetmanager.common;

import java.util.Map;

/**
 * @author zhengzhenwen
 * @data 2018/11/9 11:15
 * @description
 **/
public class ResponseMes {
    private Integer code;
    private String message;
    private Map data;

    public ResponseMes() {
        this.code = ErrorCode.OPERATE_SUCCESS.getCode();
        this.message = ErrorCode.OPERATE_SUCCESS.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
