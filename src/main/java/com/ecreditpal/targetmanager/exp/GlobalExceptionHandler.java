package com.ecreditpal.targetmanager.exp;


import com.ecreditpal.targetmanager.common.ErrorCode;
import com.ecreditpal.targetmanager.common.ResponseMes;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhengzhenwen
 * @Description //TODO
 * @Date 上午10:11 2018/9/17
**/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseMes handleException(Exception e) {
        ResponseMes res = new ResponseMes();

        if(e instanceof MyException){
            res.setCode(((MyException) e).getErrorCode().getCode());
            res.setMessage(e.getMessage());
        }else{
            res.setCode(ErrorCode.PARAM_INVALID.getCode());
            res.setMessage(ErrorCode.PARAM_INVALID.getMessage());
        }

        System.out.println(e.getMessage());
        return res;
    }
}
