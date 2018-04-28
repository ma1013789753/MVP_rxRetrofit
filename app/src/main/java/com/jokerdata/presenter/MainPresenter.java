package com.jokerdata.presenter;

import com.jokerdata.http.HttpCallBack;
import com.jokerdata.model.MainModel;
import com.jokerdata.view.MainViewInterface;

/**
 * Created by oldma on 2018/2/23.
 */

public class MainPresenter {

    private MainViewInterface viewInterface;
    private MainModel mModel;
    public MainPresenter(MainViewInterface view) {
        this.viewInterface = view;
        mModel = new MainModel();
    }


    public void sendData(HttpCallBack callBack){
        mModel.sendData(viewInterface.getData(),callBack);
    }
}
