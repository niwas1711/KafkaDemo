package com.ibm.rewrite.vcsr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.rewrite.vcsr.Service.Producer;
import com.ibm.rewrite.vcsr.pojo.Message;


@RestController
@RequestMapping(value = "/kafka")
public class VcsrController {

	private final Producer producer;

	@Autowired
	public VcsrController(Producer producer) {

	this.producer = producer;

	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestBody Message message){
	System.out.println("I am send msg"+message.getClientName()+"jjj"+message.getMessage());
		this.producer.sendMessage(message);
	//	System.out.println("I am after send msg");
	}
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
		
		return "welcome";
	}
	
	
}
