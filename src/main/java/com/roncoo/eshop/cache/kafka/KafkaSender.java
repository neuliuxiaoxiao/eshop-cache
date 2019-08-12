package com.roncoo.eshop.cache.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.eshop.cache.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Title KafkaSender
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/8/12 12:20
 **/
@Component
public class KafkaSender {
    static Logger logger = LoggerFactory.getLogger(KafkaSender.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    JSONObject jsonObject = new JSONObject();
    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        JSONObject jsonObj = (JSONObject) JSON.toJSON(message);
        logger.info("+++++++++++++++++++++  message = {}", jsonObj.toString());
        kafkaTemplate.send("zhisheng", jsonObj.toString());
    }
}
