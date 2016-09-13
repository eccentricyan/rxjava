package com.eccentricyan.rxjava;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by rcube on 2016/09/13.
 */
public interface WeatherApi {
    @GET("/forecast/webservice/json/v1")
    public Observable<WeatherEntity> getWeather(@Query("city") final String city);
}
