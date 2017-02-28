package com.aws.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rabbitmq")
@RestController
public class RabbitMqController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogEventsProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
    private LogEventsReceiver receiver;
	
	@Autowired
    private ConfigurableApplicationContext context;
	
	@GetMapping("send")
	public ResponseEntity<String> sendMessage() throws Exception {
		LOGGER.info("*****Sending message******");
        rabbitTemplate.convertAndSend(LogEventsProducer.queueName, "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        //Spring context gets closed and stops application
//        context.close();
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

}
