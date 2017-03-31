package com.servyou.service;
/**
 * <p>发送邮件的服务接口</p>
 * <p>创建时间：2017-3-6</p>
 * <p>@author huangg</p>
 */
public interface ISendEmailsService {
	//发送邮件
	public void sendEmails();
	//根据地区设置邮件内容
	public String emailContent(String text);
	  
}
