package com.jeesite.modules.modules.kv.api;


import com.jeesite.common.web.BaseController;
import com.jeesite.modules.modules.kv.conf.ResultModel;
import com.jeesite.modules.modules.kv.entity.Message;
import com.jeesite.modules.modules.kv.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: MessageApi
 * @Description: TODO(消息接口)
 *
 * @author: arthas.zhou@xxxxtech.com
 * @date: 2017年2月4日 下午3:46:24
 * @version:
 */
@Controller
@RequestMapping("/api/message")
public class MessageApi extends BaseController {

	
	@Resource
	MessageService messageService;





	Jedis jedis;

	/**
	 * 
	 * @Title: noticeList
	 * @Description: TODO(获取用户所有消息)
	 * @param offset
	 * @param pageSize
	 * @param request
	 * @return
	 *
	 * @return ResponseEntity<ResultModel>
	 * @throws
	 *
	 * 			@author
	 *             sikefeng.xu@xxxxtech.com
	 * @date 2017年2月6日 下午10:14:47
	 */
	@RequestMapping(value = "/messagelist", method = RequestMethod.POST)
	public ResponseEntity<ResultModel> noticeList(@RequestParam int offset, @RequestParam int pageSize, HttpServletRequest request) {
		System.out.println("offset" + offset + "------pageSize" + pageSize);
//		List<Message> list = messageService.getMessageList("1224");
//		if (list == null) {
//			list = new ArrayList<Message>();
//		}
		List<Message> list =new ArrayList<>();
		Message message=new Message();
		message.setContent("KKKKKKKKKKKKKKKKKKKKKk");
		list.add(message);
		return new ResponseEntity<>(ResultModel.ok(list), HttpStatus.OK);
	}



}
