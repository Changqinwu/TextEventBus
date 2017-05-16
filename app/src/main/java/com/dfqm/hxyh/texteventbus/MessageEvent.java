package com.dfqm.hxyh.texteventbus;

/**
 * Created by Administrator on 2017/5/15.
 */

public class MessageEvent {
    public  MessageEvent(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
