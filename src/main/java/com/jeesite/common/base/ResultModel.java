/**
 * Copyright (C) 2014-2017 <a href = "http://www.xxxxtech.com>">XXXXTech</a> All Rights Reserved.
 */
package com.jeesite.common.base;


/**
 * 文件名：ResultModel <br>
 * 创建时间： 2017/6/18 下午下午9:51 <br>
 * 文件描述：<br>
 * 自定义返回结果
 *
 * @author <a href="mailto:dawson@xxxxtech.com">Dawson</a> <br>
 * @version v0.1  <br>
 * @since JDK 1.8
 */
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

    /**
     * 带状态和消息的构造函数
     * @param status 状态
     * @param msg 消息
     */
    public ResultModel(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = "";
    }

    /**
     * 带状态，消息和对象的构造函数
     * @param status 状态
     * @param msg 消息
     * @param data 对象数据
     */
    public ResultModel(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     * @param status ResultStatus
     */
    public ResultModel(ResultStatus status) {
        this.status = status.getStatus();
        this.msg = status.getMsg();
        this.data = "";
    }

    /**
     * 构造函数
     * @param status 状态
     * @param data 数据
     */
    public ResultModel(ResultStatus status, Object data) {
        this.status = status.getStatus();
        this.msg = status.getMsg();
        this.data = data;
    }

    /**
     * 构造函数
     * @param status 状态
     * @param msg 消息
     */
    public ResultModel(String status, String msg) {
        this.status = Integer.parseInt(status);
        this.msg = msg;
        this.data = "";
    }

    /**
     * 构造函数，返回oK
     * @param data 数据
     * @return ResultModel
     */
    public static ResultModel ok(Object data) {
        return new ResultModel(ResultStatus.SUCCESS, data);
    }

    /**
     * 构造函数，返回oK
     * @return ResultModel
     */
    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    /**
     * 构造函数，返回ERROR
     * @param error ResultStatus
     * @return ResultModel
     */
    public static ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }

    /**
     * 获取ResultModel
     * @param status 状态
     * @param msg 消息
     * @return ResultModel
     */
    public static ResultModel error(String status, String msg) {
        return new ResultModel(status,msg);
    }
}
