package com.salgueiro.jsonconsumer.listener;

import com.salgueiro.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory" )
    public void antiFraud(@Payload Payment payment){
        log.info("Recebi o pagamento {}", payment.toString());

        Thread.sleep(2000);
        log.info("Validando fraude...");

        Thread.sleep(2000);
        log.info("Compra aprovada...");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory" )
    public void pdfGenerator(@Payload Payment payment){
        Thread.sleep(6000);
        log.info("Gerando pdf do produto de id {}...", payment.getId());
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory" )
    public void sendEmail(){
        Thread.sleep(8000);
        log.info("enviando email de confirmacao...");
    }
}
