package com.jeesite.test;

import com.jeesite.modules.config.Application;
import com.jeesite.modules.ctzn.entity.Feedback;
import com.jeesite.modules.ctzn.service.FeedbackService;
import com.jeesite.modules.ctzn.service.ProductService;
import com.jeesite.modules.test.service.BannerService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@Rollback(false)
public class DebugTest extends com.jeesite.modules.gen.db.InitGenData {

    @Resource
    BannerService bannerService;

    @Resource
    FeedbackService feedbackService;

    @Resource
    ProductService productService;

    @Test
    public void myTestData() throws Exception {
//        Banner banner = bannerService.get("2");
//        System.out.println("kkkkkkkkkkkkkkkkkk=" + banner.getUsername());
//        Product product2 = new Product();
//        product2.setProName("联想电脑");
//        product2.setProPicture("http:www.baidu.com");
//        product2.setProModel("CT-A002");
//        productService.insert(product2);
//        Product product = productService.get("1002378649380016128");
//        System.out.println("kkkkkkkkkkkkkkkkkk=" + product.getProName());
        Feedback feedback = new Feedback();
        feedback.setProId("1002535318247071744");
        feedback.setConent("无法用微信登录小程序");
        feedback.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528464614&di=2d066b1e8dada805def5df61bd436792&imgtype=jpg&er=1&src=http%3A%2F%2Fimgs.soufun.com%2Fnews%2F2015_04%2F15%2Fzhishi%2F1429068861628_000.jpg");
        feedbackService.save(feedback);
    }


}
