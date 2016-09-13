package com.eccentricyan.rxjava;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by rcube on 2016/09/13.
 */
public interface ArticleApi {
    @GET("/articles.json")
    public Observable<WeatherEntity> getAll();
}
