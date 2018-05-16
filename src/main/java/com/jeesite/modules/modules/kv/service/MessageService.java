package com.jeesite.modules.modules.kv.service;


import com.jeesite.common.service.CrudService;
import com.jeesite.modules.modules.kv.dao.MessageDao;
import com.jeesite.modules.modules.kv.entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:MessageService Function: 消息Service. <br>
 * 
 * @author Arthas
 *
 */
@Service
@Transactional(readOnly = false)
public class MessageService extends CrudService<MessageDao, Message> {


	/**
	 * 查询字段类型列表
	 * 
	 * @return
	 */
	public List<Message> getMessageList(String memberId) {
		return dao.getMessageList(memberId);
	}


}
