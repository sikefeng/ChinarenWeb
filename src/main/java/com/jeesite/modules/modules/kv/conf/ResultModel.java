package com.jeesite.modules.modules.kv.conf;



public class ResultModel {

    /**
     * 返回码
     */
    private int status;

    /**
     * 返回结果描述
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public ResultModel(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = "";
    }

    public ResultModel(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultModel(ResultStatus status) {
        this.status = status.getStatus();
        this.msg = status.getMsg();
        this.data = "";
    }

    public ResultModel(ResultStatus status, Object data) {
        this.status = status.getStatus();
        this.msg = status.getMsg();
        this.data = data;
    }
    public ResultModel(String status, String msg) {
        this.status = Integer.valueOf(status);
        this.msg = msg;
        this.data = "";
    }
    public static ResultModel ok(Object data) {
        return new ResultModel(ResultStatus.SUCCESS, data);
    }

    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }        
    public static ResultModel error(String status, String msg) {
        return new ResultModel(status,msg);
    }  
}
