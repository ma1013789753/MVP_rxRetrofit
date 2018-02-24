package com.jokerdata.model;

import com.jokerdata.bean.Book;
import com.jokerdata.http.HttpCallBack;
import com.jokerdata.http.RetrofitService;
import com.jokerdata.http.RetrofitUtil;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by oldma on 2018/2/23.
 * 模型层用来处理数据，比如发送请求获取数据
 */

public class MainModel {
    /**
     * 需要一个参数发送数据
     *
     */
    public void sendData(String str, final HttpCallBack callBack){

        RetrofitService service = RetrofitUtil.getInstance();
        Observable<Book> observable = service.getBook1(str,null,0,1);
//        Observable<Book> observable = service.getBook2(map);
        observable.subscribeOn(Schedulers.io())//请求数据的事件发生在io线程
                     .observeOn(AndroidSchedulers.mainThread())//请求完成后在主线程更显UI
                     .subscribe(new Observer<Book>() {
                         @Override
                         public void onCompleted() {

                         }

                         @Override
                         public void onError(Throwable e) {
                            callBack.onError();
                         }
                         @Override
                         public void onNext(Book t) {
                             callBack.onSuccess(t);
                         }
                     });


    }


}
