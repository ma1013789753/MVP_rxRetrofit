package com.jokerdata.presenter;

import com.jokerdata.http.HttpCallBack;
import com.jokerdata.model.MainModel;

/**
 * Created by oldma on 2018/2/23.
 */

public class MainPresenter {

    private MainModel mModel;
    public MainPresenter() {
        mModel = new MainModel();
    }


    public void sendData(String str, HttpCallBack callBack){
        mModel.sendData(str,callBack);
    }
}
