package com.jokerdata.rxbus;


/**
 * @Created: Oldma
 * @Date: 2018/1/23
 * @Description:
 */

public class RxBusBaseMessage {
    private int code;
    private Object object;

    public RxBusBaseMessage(int code, Object object){
        this.code=code;
        this.object=object;
    }

    public RxBusBaseMessage(){}

    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }
}
