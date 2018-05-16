package com.jeesite.modules.modules;

import org.springframework.beans.factory.annotation.Value;

public class Constants {

//    static public final String ACCOUNTAVATAR_FOLDER = "/File/File/apache-tomcat-8.0.32/webapps/image/"; //头像图片文件保存目录
    static public final String ACCOUNTAVATAR_FOLDER = "C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/images/"; //头像图片文件保存目录
//    static public final String ROOT_FILE_PATH = new PropertiesLoader("beetl.properties").getProperty("file.upload.path");//图片根目录

    @Value("file.upload.path")
    static public  String ROOT_FILE_PATH="";

    /** 图片类型 **/
    public static final int P_TX = 1; //头像

}
