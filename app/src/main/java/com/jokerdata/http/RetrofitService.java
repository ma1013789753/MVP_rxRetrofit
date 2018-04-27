package com.jokerdata.http;

import com.jokerdata.bean.Book;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by oldma on 2018/2/23.
 */

public interface RetrofitService {

    //获取搜索的书籍信息
    @GET("book/search")
    Observable<Book> getBook1(@Query("q") String name, @Query("tag") String tag, @Query("start") int start, @Query("count") int count);

    @GET("book/search")
    Observable<Book> getBook2(@QueryMap Map<String, String> options);
}
