package com.ibm.rewrite.vcsr.Service;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import com.ibm.rewrite.vcsr.pojo.Message;

@Service
public class Consumer {

private final Logger logger = LoggerFactory.getLogger(Consumer.class);

@KafkaListener(topics = "VCSR-topic", groupId = "group_id")
public void consume(String message){
//System.out.println("ClientName"+message);
logger.info(String.format(" Consumed Message on cousmer %s",message));
 


//String activemgresponse=Activemqcomponent.Activemqservice(message);
//System.out.println("activemgresponse"+activemgresponse);


}

}