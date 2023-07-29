package com.salgueiro.strconsumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//para a classe estar dusponível em tempo de execução
@Target(ElementType.METHOD)//notação para definir anotações customizadas
@KafkaListener
public @interface StrConsumerCustomListener {

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "str-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "groupId-1";

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler" )
     String errorHandler() default "errorCustomHandler"; /*nome da classe que criei para customização de Exception com a primeira letra minuscula
     (o Spring cria um bean dessa classe pois está anotada como @componet esse bean tem a primeira letra minuscula)*/
}
