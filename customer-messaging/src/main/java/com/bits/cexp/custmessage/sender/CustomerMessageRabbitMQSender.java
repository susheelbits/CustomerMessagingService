package com.bits.cexp.custmessage.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bits.cexp.custmessage.dto.CustomerDTO;


/**
 * Sending message to Command DB for acknowldeging the success of adding, updating, deleting the Customer 
 * 
 *
 */
@Service
public class CustomerMessageRabbitMQSender {

	private RabbitTemplate rabbitTemplate;

    @Autowired
    public CustomerMessageRabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
	@Value("${spring.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(CustomerDTO custDTO) {
		System.out.println("CustomerCommandRabbitMQSender Send msg = " + custDTO);
		rabbitTemplate.convertAndSend(exchange, routingkey, custDTO);
	}	
	
}
