package com.jokerdata.model;

import android.util.Log;

import com.jokerdata.base.MyApplication;
import com.jokerdata.bean.Book;
import com.jokerdata.http.HttpCallBack;
import com.jokerdata.http.RetrofitUtil;
import com.jokerdata.util.NetworkUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


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
        RetrofitUtil.getInstance()
                .getBook1(str,null,0,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {


                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.w("xxx","onSubscribe");

                    }

                    @Override
                    public void onNext(Book book) {
                        Log.w("xxx","onNext");
                        callBack.onSuccess(book);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.w("xxx",e.toString());
                        callBack.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        Log.w("xxx","onComplete");
                    }
                });


    }


}
