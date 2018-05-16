package com.jeesite.modules.modules.kv.dao;


import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.modules.kv.entity.Message;

import java.util.List;

/**
 * ClassName:MessageDao
 * Function: 消息Dao. <br>
 * @author Arthas
 *
 */
@MyBatisDao
public interface MessageDao extends CrudDao<Message> {
	public List<Message> getMessageList(String memberId);
}
