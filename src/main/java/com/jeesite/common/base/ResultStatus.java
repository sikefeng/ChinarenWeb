/**
 * Copyright (C) 2014-2017 <a href = "http://www.xxxxtech.com>">XXXXTech</a> All Rights Reserved.
 */
package com.jeesite.common.base;


/**
 * 文件名：ResultStatus <br>
 * 创建时间： 18/7/17 AM9:31 <br>
 * 文件描述：<br>
 * 自定义请求状态码
 *
 * @author <a href="mailto:arthas.zhou@xxxxtech.com">Arthas</a> <br>
 * @version v0.1  <br>
 * @since JDK 1.8
 */
public enum ResultStatus {
    SUCCESS(0, "success"),
    USERNAME_OR_PASSWORD_ERROR(1001, "用户名或密码错误"),
    USER_NOT_FOUND(1002, "用户不存在"),
    USER_NOT_LOGIN(1003, "用户未登录"),
    USER_NOT_PARAM_UPDATE(1004, "参数有误"),
    USER_NOT_NOTICE(1005, "消息不存在"),
    USER_EXISTED(1006, "用户已经存在"),
    USER_DATA_ERR(1007, "数据出错"),
    USER_EMAIL_NULL(1008, "EMAIL不能为空"),
    USER_PASSWORD_NULL(1009, "密码不能为空"),
    USER_REGISTER_Y(1010, "该邮箱已被注册"),
    USER_CODE_INVALID(1011,"无效验证码"),
    USER_NOT_NULL_PHONE(1012, "电话号码不能为空"),
    USER_PHONE_NOT_RIGHT(1013, "电话号码格式不正确"),
    UPDATE_ERROR(1014,"更新失败"),
    USER_TOKEN_ILLEGAL(1015,"非法操作"),
    USER_VERCODE_NULL(1016,"验证码不能为空"),
    USER_NAME_NULL(1018,"姓名不能为空"),
    SERVICE_AREA_NULL(1017,"服务点不存在"),
    USER_VERCODE_NOT(1019,"验证码不能为空"),
    SERVICE_AREA_DELETE(1020,"服务点已删除"),
    SHOP_DISABLED(1021,"门店被禁用"),
    MERCHANT_DISABLED(1022,"商家被禁用"),
    DATA_NULL_OR_ERR(2000,"参数不能解析"),
    DATA_NULL(2001,"参数不能为空"),
    SEND_FAILED(2002,"发送失败"),
    REQUEST_SEND_FAILED(2003,"发送失败"),
    PASSWORD_OLD_NULL(2004,"旧密码不能为空"),
    PASSWORD_NEW_NULL(2005,"新密码不能为空"),
    PASSWORD_CONFIRM_NULL(2006,"确认密码不能为空"),
    PASSWORD_OLD_NEW(2007,"新密码输入不一致"),
    PASSWORD_OLD_NOT(2008,"旧密码不正确"),
    DATA_NOT_FOUND(4000,"数据不存在");

    //增加一个项目，需要到MessageUtils增加相应的动态赋值修改

    /**
     * 返回码
     */
    private int status;

    /**
     * 返回结果描述
     */
    private String msg;

    /**构造器
     *
     * @param status 状态码
     * @param msg 文本
     */
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
