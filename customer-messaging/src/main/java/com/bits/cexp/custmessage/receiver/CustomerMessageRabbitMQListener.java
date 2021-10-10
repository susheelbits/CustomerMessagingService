package com.bits.cexp.custmessage.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.bits.cexp.custmessage.dto.CustomerDTO;

@Service
public class CustomerMessageRabbitMQListener {
	
	
    @RabbitListener(queues = "customer-command.queue")
    public void processOrder(CustomerDTO customer) {
    	System.out.println("Order Received: "+customer);
    	
    	//If Id does not exists then, Add the Customer 
    	//If Id exists, then either update or delete the customer
    	//Send Acknowledgement of the operation 
    	
    }	
    
}
