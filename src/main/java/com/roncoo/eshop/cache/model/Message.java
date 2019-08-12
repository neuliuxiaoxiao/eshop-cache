package com.roncoo.eshop.cache.model;

import java.util.Date;

/**
 * @Title Message
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/8/12 12:19
 **/
public class Message {
    private Long id;    //id
    private String msg; //消息
    private Date sendTime;  //时间戳

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
