/**
 * Project Name:klup
 * File Name:MessageUtils.java
 * Package Name:com.xxxxtech.sssite.modules.auth.conf
 * Date:Jan 8, 20174:34:51 PM
 * Copyright (c) 2017, &lt;a href=&quot;http://www.xxxxtech.com&quot;&gt;广州双双信息科技有限公司&lt;/a&gt; All Rights Reserved.
 *
 */

package com.jeesite.common.utils;

import com.jeesite.common.base.ResultStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件名：MessageUtils <br>
 * 创建时间： 17/7/17 PM8:53 <br>
 * 文件描述：<br>
 * 国际化接口文字
 *
 * @author <a href="mailto:arthas.zhou@xxxxtech.com">Arthas</a> <br>
 * @version v0.1  <br>
 * @since JDK 1.8
 */
public class MessageUtils {
    /**
     * 参数不能为空
     */
    public static final int DATA_NULL = 0;
    /**
     * 数据不存在
     */
    public static final int DATA_NOT_FOUND = 1;
    /**
     * 参数有误
     */
    public static final int USER_NOT_PARAM_UPDATE = 2;
    /**
     * 用户不存在
     */
    public static final int USER_NOT_FOUND = 3;
    /**
     * EMAIL不能为空
     */
    public static final int USER_EMAIL_NULL = 4;

    /**
     * 发送失败
     */
    public static final int SEND_FAILED = 5;

    /**
     * 密码不能为空
     */
    public static final int USER_PASSWORD_NULL = 6;

    /**
     * 用户名或密码错误
     */
    public static final int USERNAME_OR_PASSWORD_ERROR = 7;

    /**
     * 数据出错
     */
    public static final int USER_DATA_ERR = 8;
    /**
     * 用户已经存在
     */
    public static final int USER_EXISTED = 9;
    /**
     * 参数不能解析
     */
    public static final int DATA_NULL_OR_ERR = 10;
    /**
     * 电话不能为空
     */
    public static final int USER_NOT_NULL_PHONE = 11;
    /**
     * 电话格式不正确
     */
    public static final int USER_PHONE_NOT_RIGHT = 12;
    /**
     * 更新失败
     */
    public static final int UPDATE_ERROR = 13;
    /**
     * 非法操作
     */
    public static final int USER_TOKEN_ILLEGAL = 14;

    /**
     * 验证码不能为空
     */
    public static final int USER_VERCODE_NULL = 15;
    /**
     * 姓名不能为空
     */
    public static final int USER_NAME_NULL = 17;
    /**
     * 服务点不存在
     */
    public static final int SERVICE_AREA_NULL = 16;

    /**
     * 验证码失效
     */
    public static final int USER_CODE_INVALID = 18;
    /**
     * 验证码不正确
     */
    public static final int USER_VERCODE_NOT = 19;

    /**
     * 旧密码不能为空
     */
    public static final int PASSWORD_OLD_NULL = 20;
    /**
     * 新密码不能为空
     */
    public static final int PASSWORD_NEW_NULL = 21;

    /**
     * 确认密码不能为空
     */
    public static final int PASSWORD_CONFIRM_NULL = 22;
    /**
     * 新密码输入不一致
     */
    public static final int PASSWORD_OLD_NEW = 23;
    /**
     * 旧密码不正确
     */
    public static final int PASSWORD_OLD_NOT = 24;
    /**
     * 服务点已删除
     */
    public static final int SERVICE_AREA_DELETE = 25;
    /**
     * 门店被禁用
     */
    public static final int SHOP_DISABLED = 26;
    /**
     * 商家被禁用
     */
    public static final int MERCHANT_DISABLED = 27;

    /**
     * 客户端请求对象
     */
    private static HttpServletRequest request = null;
    /**
     * 实例对象
     */
    private static MessageUtils instance;

    /**
     * 单例
     * @return 实例
     */
    public static MessageUtils getInstance() {
        if (instance == null) {
            instance = new MessageUtils();

        }

        return instance;
    }

    /**
     * 
     * getMessage:获取国际化文本. <br>
     * 
     * @author &lt;a
     *         href=&quot;mailto:dawson@xxxxtech.com&quot;&gt;dawson&lt;/a&gt;
     * @param key 键值
     * @return 国际化文本
     * @since JDK 1.6
     */
    public static String getMessage(String key) {
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ApplicationContext ctx = RequestContextUtils.findWebApplicationContext(request);
        Object[] arg = null; // 替换变量参数
        return ctx.getMessage(key, arg, RequestContextUtils.getLocale(request));
    }



    /**功能描述：获取国际化消息
     * <br>创建时间： 2017-07-17 21:09:03

     * @author <a href="mailto:arthas.zhou@xxxxtech.com">Arthas</a>
     *
     * @param messageType 类型
     * @return 自定义国际化文本
     */
    public static ResultStatus getResultStatus(int messageType){
        ResultStatus resultStatus = null;
        switch (messageType) {
        case DATA_NULL:
            resultStatus = ResultStatus.DATA_NULL;
            break;
            case DATA_NOT_FOUND:
                resultStatus = ResultStatus.DATA_NOT_FOUND;
                break;
            case USER_NOT_PARAM_UPDATE:
                resultStatus = ResultStatus.USER_NOT_PARAM_UPDATE;
                break;
            case USER_NOT_FOUND:
                resultStatus = ResultStatus.USER_NOT_FOUND;
                break;
            case USER_EMAIL_NULL:
                resultStatus = ResultStatus.USER_EMAIL_NULL;
                break;
            case SEND_FAILED:
                resultStatus = ResultStatus.SEND_FAILED;
                break;
            case USER_PASSWORD_NULL:
                resultStatus = ResultStatus.USER_PASSWORD_NULL;
                break;
            case USERNAME_OR_PASSWORD_ERROR:
                resultStatus = ResultStatus.USERNAME_OR_PASSWORD_ERROR;
                break;
            case USER_DATA_ERR:
                resultStatus = ResultStatus.USER_DATA_ERR;
                break;
            case USER_EXISTED:
                resultStatus = ResultStatus.USER_EXISTED;
                break;
            case DATA_NULL_OR_ERR:
                resultStatus = ResultStatus.DATA_NULL_OR_ERR;
                break;
            case USER_NOT_NULL_PHONE:
                resultStatus = ResultStatus.USER_NOT_NULL_PHONE;
                break;
            case USER_PHONE_NOT_RIGHT:
                resultStatus = ResultStatus.USER_PHONE_NOT_RIGHT;
                break;
            case UPDATE_ERROR:
                resultStatus = ResultStatus.UPDATE_ERROR;
                break;
            case USER_TOKEN_ILLEGAL:
                resultStatus = ResultStatus.USER_TOKEN_ILLEGAL;
                break;
            case USER_VERCODE_NULL:
                resultStatus = ResultStatus.USER_VERCODE_NULL;
                break;
            case USER_NAME_NULL:
                resultStatus = ResultStatus.USER_NAME_NULL;
                break;
            case SERVICE_AREA_NULL:
                resultStatus = ResultStatus.USER_VERCODE_NULL;
                break;
            case USER_CODE_INVALID:
                resultStatus = ResultStatus.USER_CODE_INVALID;
                break;
            case USER_VERCODE_NOT:
                resultStatus = ResultStatus.USER_VERCODE_NOT;
                break;
            case PASSWORD_OLD_NULL:
                resultStatus = ResultStatus.PASSWORD_OLD_NULL;
                break;
            case PASSWORD_NEW_NULL:
                resultStatus = ResultStatus.PASSWORD_NEW_NULL;
                break;
            case PASSWORD_CONFIRM_NULL:
                resultStatus = ResultStatus.PASSWORD_CONFIRM_NULL;
                break;
            case PASSWORD_OLD_NEW:
                resultStatus = ResultStatus.PASSWORD_OLD_NEW;
                break;
            case PASSWORD_OLD_NOT:
                resultStatus = ResultStatus.PASSWORD_OLD_NOT;
                break;
            case SERVICE_AREA_DELETE:
                resultStatus = ResultStatus.SERVICE_AREA_DELETE;
                break;
            case SHOP_DISABLED:
                resultStatus = ResultStatus.SHOP_DISABLED;
                break;
            case MERCHANT_DISABLED:
                resultStatus = ResultStatus.MERCHANT_DISABLED;
                break;
        default:
            break;
        }
        
        return resultStatus;
    }

}


