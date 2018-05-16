package com.jeesite.modules.modules.kv.entity;


import com.jeesite.common.entity.DataEntity;

/**
 * ClassName: Message Function: 消息表. <br>
 * 
 * @author Arthas
 *
 */
public class Message extends DataEntity<Message> {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String title;// 消息主题
	private String content;// 消息内容
	private String memberId;// 会员，如果是系统创建，可以为空
	private String sender;// 发送者
	private String recipient;// 接收者
	private String photo;// 头像
	private int type;// 消息类型，暂未定类型，默认为0
	private int isagree;// 头像

	public int getIsagree() {
		return isagree;
	}

	public void setIsagree(int isagree) {
		this.isagree = isagree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
