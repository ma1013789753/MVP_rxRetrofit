package com.jokerdata.dagger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jokerdata.base.BaseActivity;
import com.jokerdata.bean.Book;
import com.jokerdata.http.HttpCallBack;
import com.jokerdata.presenter.MainPresenter;
import com.jokerdata.rxbus.RxBus;
import com.jokerdata.view.MainViewInterface;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.jokerdata.dagger.R.id.get;
import static com.jokerdata.dagger.R.id.send;

public class MainActivity extends BaseActivity implements MainViewInterface {


    @BindView(R.id.text)
    EditText mText;
    @BindView(get)
    Button mGet;
    @BindView(R.id.send)
    Button mSend;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        initRegist();
    }

    private void initRegist() {

        mDisposable = RxBus.getDefault()
                .toObservable(136,String.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(s->{

                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public String getData() {
        return mText.getText().toString();
    }

    @OnClick({get, R.id.send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case get:
                SecondActivity.startAct(this);
                break;
            case R.id.send:
                presenter.sendData(new HttpCallBack() {
                    @Override
                    public void onSuccess(Object o) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

                break;
        }
    }

public interface fhsdf{
    void haha();
}

}
