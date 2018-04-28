package com.jokerdata.base;

import android.app.Activity;

import com.trello.rxlifecycle2.components.RxActivity;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class BaseActivity extends RxActivity {
    //解除订阅事件
    protected Disposable mDisposable;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable!=null&&!mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }
}
