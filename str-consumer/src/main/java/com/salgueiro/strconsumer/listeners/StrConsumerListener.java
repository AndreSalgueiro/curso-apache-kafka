package com.salgueiro.strconsumer.listeners;

import com.salgueiro.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows//substitui a anotação que indica que esse método lança uma exceção (anotação Lombock)
    //@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory") //forma de setar os parametros do listener de forma manual
    @StrConsumerCustomListener()//setando parametros do listener de forma customizada
    public void listener(String message){
        log.info("LISTENER Receive message {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

    //@KafkaListener(groupId = "group-1", topicPartitions = {@TopicPartition( topic = "str-topic", partitions = {"1"})}, containerFactory = "strContainerFactory")//forma de setar os parametros do listener de forma manual
    @StrConsumerCustomListener()//setando parametros do listener de forma customizada
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")//forma de setar os parametros do listener de forma manual
    @StrConsumerCustomListener(groupId = "group-2")
    public void test(String message){
        log.info("TESTE ::: Receive message {}", message);
    }
}