package com.eccentricyan.rxjava;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created  on 2016/09/13.
 */
public interface KanazawaApi {
    @GET("/{name}.json")// 「/」から開始しないとはじかれる
    public Observable<KanazawaEntity> getEvent(@Path("name")String url);
}
