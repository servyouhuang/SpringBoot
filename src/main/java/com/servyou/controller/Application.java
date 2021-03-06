package com.servyou.controller;

import javax.ejb.TransactionManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servyou.service.lmpl.CreateExcelService;
import com.servyou.service.lmpl.SendEmailsService;

@RestController
@EnableAutoConfiguration
@MapperScan("com.servyou.mapper")
@TransactionManagement
@ComponentScan("com.servyou.*")
public class Application {
	@Autowired
	private CreateExcelService createExcel;
	@Autowired
	private SendEmailsService sendEmailsService;
	@RequestMapping("/")
	public String home() {
	    return "Hello World!I am SpringBoot.";
	}
	@RequestMapping("/sendMessage")
	public String sendMessage() {
		sendEmailsService.sendEmails();
	    return "sendMessage Success.";
	}
	@RequestMapping("/createcxcel")
	public String createExcel() {
		createExcel.downloadExcel();
	    return "createcxcel Success.";
	}
	public static void main(String[] args) throws Exception {
	     SpringApplication.run(Application.class, args);
	}
}
