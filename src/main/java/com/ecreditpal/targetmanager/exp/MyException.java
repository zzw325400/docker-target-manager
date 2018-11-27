package com.ecreditpal.targetmanager.exp;



import com.ecreditpal.targetmanager.common.ErrorCode;

import javax.servlet.ServletException;

/**
 * @author zhengzhenwen
 * @date 2018/9/13 下午7:07
 * @description
 **/
public class MyException extends ServletException {
    private ErrorCode errorCode;

    public MyException(String message, ErrorCode code){
        super(message);
        this.errorCode = code;
    }
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode code) {
        this.errorCode = code;
    }
}
