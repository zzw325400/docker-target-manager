package com.ecreditpal.targetmanager.common;

public enum ErrorCode {
    COURT_SCRIPT_RUNNING(900, "正在采集"),

    CANT_ADD_CFG(901, "该指标项已经存在调度配置，无法新增"),

    CANT_ADD_TAR(901, "存在同名指标，无法新增"),

    CODE_LENGTH_LIMIT(854, "code长度超过限制"),

    NODE_CANT_OWN_SON(853, "此节点下不能创建子节点"),

    NODE_CODE_EXISTS(852, "此节点下已经有相同代码的节点"),

    NODE_NOT_EXISTS(851, "节点不存在"),

    NODE_NAME_EXISTS(850, "此节点下已经存在同名节点"),

    PARAM_INVALID(750, "无效参数"),

    NO_COURT_DATA(710, "没有相关的法院的数据"),

    KEYWORD_CANT_BE_NULL(700, "关键词不能为空"),

    TOKEN_EXPIRED(650, "无效token"),

    WRONG_PW(620, "账号或密码错误"),

    USER_NOT_EXISTS(615, "没有这个用户"),

    USER_BAN(610, "用户已经被禁用"),

    USER_EXISTS(602, "用户已存在"),

    OPERATE_SUCCESS(200, "操作成功"),

    OPERATE_FAILED(100, "操作失败"),

    NO_AUTHORITY(601, "没有这个权限");


    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
