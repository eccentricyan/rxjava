package com.eccentricyan.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//    private static final String END_POINT = "http://weather.livedoor.com";
//    private static final String END_POINT = "https://hana-collection.com/api/v2";
//    private static final String TAG = MainActivity.class.getSimpleName();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, KanazawaActivity.class);
        startActivity(intent);

//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .registerTypeAdapter(Date.class, new DateTypeAdapter())
//                .create();

        // RestAdapterを作成する
//        RestAdapter adapter = new RestAdapter.Builder()
//                .setEndpoint(END_POINT)
//                .setConverter(new GsonConverter(gson))
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setLog(new AndroidLog("=NETWORK="))
//                .build();

        // 天気予報情報を取得する
        //http://weather.livedoor.com/area/forecast/200010
//        WeatherApi api =  adapter.create(WeatherApi.class);
//        ArticleApi api = adapter.create(ArticleApi.class);

//        Observer observer = new Observer<WeatherEntity>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted()");
//                //必要な情報を取り出して画面に表示してください。
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "Error : " + e.toString());
//            }
//
//            @Override
//            public void onNext(WeatherEntity weather) {
//                Log.d(TAG, "onNext()");
//            }
//        };

//        api.getWeather("200010")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//        api.getAll().subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
    }
}
