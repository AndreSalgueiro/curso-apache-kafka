package com.salgueiro.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("EXCEPTION_HANDLER ::: Capturei um erro");
        log.info("Payload ::: {}", message.getPayload());
        log.info("Headers ::: {}", message.getHeaders());
        log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
        log.info("Message exception ::: {}", e.getMessage());
        log.info("Stack Trace ::: {}", e.getStackTrace());

        //message.getHeaders().get("kafka_offset");

        return null;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        log.info("EXCEPTION_HANDLER_2 ::: message {} | exception {} | consumer {}", message, exception, consumer);
        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
    }
}
