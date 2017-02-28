package com.aws.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rabbitmq")
@RestController
public class RabbitMqController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
    private LogEventsReceiver receiver;
	
	@Autowired
    private ConfigurableApplicationContext context;
	
	@GetMapping("send")
	public void sendMessage() throws Exception {
        rabbitTemplate.convertAndSend(LogEventsProducer.queueName, "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
	}

}
