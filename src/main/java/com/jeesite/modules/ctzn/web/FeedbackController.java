package com.jeesite.modules.ctzn.web;


import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ctzn.entity.Feedback;
import com.jeesite.modules.ctzn.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "${adminPath}/ctzn/feedback")
public class FeedbackController extends BaseController {

    @Autowired
    private FeedbackService feedbackService;


    /**
     * 获取数据
     */
    @ModelAttribute
    public Feedback get(String id, boolean isNewRecord) {
        return feedbackService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "list")
    public String list(Feedback feedback, Model model,String proId) {
        feedback.setProId(proId);
        model.addAttribute("feedback", feedback);
        return "modules/ctzn/feedbackList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<Feedback> listData(Feedback feedback, HttpServletRequest request, HttpServletResponse response) {
        Page<Feedback> page = feedbackService.findPage(new Page<Feedback>(request, response), feedback);
        return page;
    }


}
