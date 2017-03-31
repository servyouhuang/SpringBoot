package com.servyou.service.lmpl;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.servyou.mapper.DjSysqxxMapper;
import com.servyou.model.DjSysqxx;
import com.servyou.service.ISendEmailsService;
import com.sun.mail.util.MailSSLSocketFactory;
/**
 * /**
 * <pre>类名: SendEmailsService</pre>
 * <pre>描述: 发送邮件的服务</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2017-3-7</pre>
 * <pre>修改历史记录：</pre>
 */
@Service
public class SendEmailsService implements ISendEmailsService{

	@Value("${email.senderadress}")
    private String senderAdress;
	@Value("${email.password}")
    private String passWord;
	@Value("${email.toadress}")
    private String[] toAdress;
	@Value("${email.subject}")
    private String subject;                                 
	@Value("${email.form}")
    private String form;
	@Value("${email.text}")
    private String text;
	@Resource
	private DjSysqxxMapper djSysqxxMapper;
	@Resource
	private CreateExcelService createExcel;
	private final static Logger LOG = LoggerFactory.getLogger(SendEmailsService.class);
	//标志                                              
	boolean flag = false;
	//短信内容
	String content;
	//邮件发送
    public void sendEmails() {  
        //邮件服务器的配置信息  
        JavaMailSenderImpl mailSend = new JavaMailSenderImpl();  
        mailSend.setHost("smtp.qq.com");//发件服务器HOST
        mailSend.setUsername(senderAdress);//发件人邮箱地址
        mailSend.setPassword(passWord);//发件邮箱密码 ：wgbpvugywcyjdfba
          
        Properties props = new Properties();  
        //启用ssl加密，普通邮件传输格式： props.put("mail.smtp.starttls.enable", true);
		try {
			 MailSSLSocketFactory sslFactory = new MailSSLSocketFactory();
			 sslFactory.setTrustAllHosts(true);
		     props.put("mail.smtp.ssl.enable", "true");
		     props.put("mail.smtp.ssl.socketFactory", sslFactory);
		} catch (GeneralSecurityException e) {
			LOG.info("启用SSL加密失败");
		}
		LOG.info("ssl加密传输成功");
		props.put("mail.smtp.auth", true);//是否校验（或者授权）：true
		mailSend.setJavaMailProperties(props);  
		
        try{
        	 MimeMessage mimeMsg = mailSend.createMimeMessage();  
             MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
             helper.setTo(toAdress);//邮件接收地址  
             for(int i=0;i<toAdress.length;i++){
            	 LOG.info(toAdress[i]);
             }
             helper.setSubject(subject);//邮件主题 
			 helper.setFrom(senderAdress,form);//邮件发送人-别名      
             LOG.info("邮件接收地址："+toAdress+",邮件主题："+subject+",邮件发件人(别名)："+form+",邮件内容："+text);
             content = emailContent(text);
             if(!flag){
            	 content="最近7天内没有适合推荐的申请适用的企业";
        		 LOG.info("最近7天内没有适合推荐的申请适用的企业");
        	 }
        	 helper.setText(content, true);//邮件内容  
        	 String fileName = createExcel.downloadExcel();
        	 FileSystemResource Resource = new FileSystemResource(fileName); 
        	 LOG.info(Resource.toString());
        	//取得根目录路径  
    	     String rootPath=SendEmailsService.class.getResource("/").getFile().toString();
    	     LOG.info("===================================>"+rootPath);
        	 helper.addAttachment(fileName,Resource);
             try{
            	 mailSend.send(mimeMsg);//发送邮件
            	 content = text;
             }catch(MailException e){
            	 LOG.info("邮件发送失败。");
             }
        }catch(javax.mail.MessagingException e){
        	LOG.info("请检查您所发送的邮件接收地址、邮件主题、邮件发送人、邮件内容是否为空");
        }catch(Exception e){
        	LOG.info("邮箱服务器问题，请检查发送邮件服务器的信息");
        }
    }
    //根据地区设置邮件内容
    public String emailContent(String text){
    	content = "<body>"+text+"</br><table border=\"1\" cellpadding=\"20\"><tr><th>企业名称</th><th>纳税人识别号</th>" +
    			"<th>申请人姓名</th><th>联系方式</th></tr>";
    	Date fssj = new Date();
    	List<DjSysqxx> djSysqxxs = djSysqxxMapper.selectByDays(fssj);
    	if(null!=djSysqxxs){
    		for(DjSysqxx djSysqxx:djSysqxxs){
    			if(djSysqxx.getSewbz().trim().toUpperCase().equals("N")){
    				if(djSysqxx.getDqdm().trim().startsWith("31")){
    					content=content+"<tr><td>"+djSysqxx.getQymc()+"</td><td>"+djSysqxx.getNsrsbh()
        					+"</td><td>"+djSysqxx.getXm()+"</td><td>"+djSysqxx.getLxdh()+"</td></tr>";
        				flag = true;
        			}else{
        				LOG.info("该企业["+djSysqxx.getQymc()+"]不是上海的企业");
        			}
    			}else{
    				LOG.info("该企业["+djSysqxx.getQymc()+"]已经开通了12万申报");
    			}
    		}
    	}else{
    		LOG.info("最近没有公司申请适用");
    	}
    	return content+"</table></body>";
    }
}
