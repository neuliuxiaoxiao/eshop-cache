package com.roncoo.eshop.cache.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Title KafkaReceiver
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/8/12 12:25
 **/
@Component
public class KafkaConsumer {

    static Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    @KafkaListener(topics = {"cache-message"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("----------------- record =" + record);
            logger.info("------------------ message =" + message);
        }
    }
}