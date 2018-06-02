package com.jeesite.modules.ctzn.api;


import com.jeesite.common.base.ResultModel;
import com.jeesite.common.utils.MessageUtils;
import com.jeesite.modules.ctzn.entity.Feedback;
import com.jeesite.modules.ctzn.entity.Product;
import com.jeesite.modules.ctzn.service.FeedbackService;
import com.jeesite.modules.ctzn.service.ProductService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.jeesite.common.utils.MessageUtils.DATA_NOT_FOUND;
import static com.jeesite.common.utils.MessageUtils.DATA_NULL;

@Controller
@RequestMapping(value = "/api/feedback")
public class FeedBackApi {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ProductService productService;


    @ResponseBody
    @RequestMapping(value = "user_feedback", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> feedback(@RequestParam String proId, @RequestParam String content) {
        if (TextUtils.isEmpty(proId) || TextUtils.isEmpty(content)) {
            return new ResponseEntity<>(ResultModel.error(MessageUtils.getResultStatus(DATA_NULL)), HttpStatus.OK);
        }
        Product product = productService.get(proId);
        if (product != null) {
            Feedback feedback = new Feedback();
            feedback.setProId(proId);
            feedback.setProName(product.getProName());
            feedback.setConent(content);
            feedbackService.save(feedback);
        } else {
            return new ResponseEntity<>(ResultModel.error(MessageUtils.getResultStatus(DATA_NOT_FOUND)), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultModel.ok(""), HttpStatus.OK);
    }


}
