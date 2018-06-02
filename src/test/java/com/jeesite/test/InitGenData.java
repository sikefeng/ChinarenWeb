/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.test;

import com.jeesite.modules.config.Application;
import com.jeesite.modules.test.entity.Banner;
import com.jeesite.modules.test.service.BannerService;
import com.jeesite.modules.test.service.TestDataService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * 初始化代码生成表测试数据
 *
 * @author ThinkGem
 * @version 2017-10-22
 */
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@Rollback(false)
public class InitGenData extends com.jeesite.modules.gen.db.InitGenData {

    @Resource
    TestDataService testDataService;

    @Resource
    BannerService bannerService;

    @Test
    public void initGenData() throws Exception {
        createGenTable();
        initGenTestData();
        initGenTreeData();
    }

    @Test
    public void myTestData() throws Exception {
//		TestData testData=testDataService.get("1");
//		System.out.println("================"+testData.getTestTextarea());;
        Banner banner = bannerService.get("2");
        System.out.println("kkkkkkkkkkkkkkkkkk=" + banner.getUsername());


    }


}
