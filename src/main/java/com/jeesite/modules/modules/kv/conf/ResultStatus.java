package com.jeesite.modules.modules.kv.conf;

/**
 * 自定义请求状态码
 * @author Dawson
 * @date 2016/8/3.
 */
public enum ResultStatus {

    SUCCESS(0, "success");

    //TODO:增加一个项目，需要到MessageUtils增加相应的动态赋值修改

    /**
     * 返回码
     */
    private int status;

    /**
     * 返回结果描述
     */
    private String msg;

    ResultStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
