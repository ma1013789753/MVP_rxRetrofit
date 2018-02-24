package com.jokerdata.http;

/**
 * Created by oldma on 2018/2/24.
 */

public interface HttpCallBack<T> {

    void onSuccess(T t);
    void onError();
}
