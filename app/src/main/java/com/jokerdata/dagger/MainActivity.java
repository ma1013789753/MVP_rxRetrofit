package com.jokerdata.dagger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jokerdata.bean.Book;
import com.jokerdata.http.HttpCallBack;
import com.jokerdata.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jokerdata.dagger.R.id.get;

public class MainActivity extends Activity  {


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
        presenter = new MainPresenter();
    }


    public String getData() {
        return mText.getText().toString();
    }

    @OnClick({get, R.id.send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case get:
                Toast.makeText(this, getData(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.send:
                //("q") String name, @Query("tag") String tag, @Query("start") int start, @Query("count") int count);
                presenter.sendData(getData(), new HttpCallBack<Book>() {
                    @Override
                    public void onSuccess(Book book) {
                        Toast.makeText(MainActivity.this, book.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(MainActivity.this,"错误", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
