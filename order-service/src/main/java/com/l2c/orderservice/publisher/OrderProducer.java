package com.l2c.orderservice.publisher;

import com.l2c.orderservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.order.routing.key}")
    private String orderRoutingKey;

    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String sendMessage(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event sent to RabbitMQ => %s", orderEvent.toString()));
        //send an order event to order queue
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, orderEvent);
        // send an order event to email queue
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, orderEvent);

        return "The message was sent to both queues";
    }
}
