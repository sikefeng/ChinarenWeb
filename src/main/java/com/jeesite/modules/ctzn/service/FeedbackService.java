package com.jeesite.modules.ctzn.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ctzn.dao.FeedbackDao;
import com.jeesite.modules.ctzn.entity.Feedback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FeedbackService extends CrudService<FeedbackDao, Feedback> {


}
