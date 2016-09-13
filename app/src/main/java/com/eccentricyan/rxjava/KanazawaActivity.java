package com.eccentricyan.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class KanazawaActivity extends AppCompatActivity {

    private static final String END_POINT = "http://www.kanazawa-arts.or.jp";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanazawa);
        startApi();
    }

    private void startApi (){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        RestAdapter adapter =  new RestAdapter.Builder()
                .setEndpoint(END_POINT)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("=NETWORK"))
                .build();

        KanazawaApi api = adapter.create(KanazawaApi.class);

        Observer observer = getEventObserver();

        api.getEvent("event-all")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private Observer<KanazawaEntity> getEventObserver(){
        Observer observer = new Observer<KanazawaEntity>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error:"+e.toString());
            }

            @Override
            public void onNext(KanazawaEntity kanazawaEntity) {
                query(kanazawaEntity.getKanazawaItemses());
            }
        };
        return observer;
    }

    private void query(List<KanazawaItems> list){
        Observable.from(list)
                .filter(groupFilter("金沢市アートホール"))
                .map(listToStringMap())
                .toList()
                .subscribe(listSubscriber());
    }
    private Func1<KanazawaItems,Boolean> groupFilter(final String group){
        Func1<KanazawaItems,Boolean> func1 = new Func1<KanazawaItems, Boolean>() {
            @Override
            public Boolean call(KanazawaItems items) {
                if(items.getGroup().equals(group)){
                    return true;
                }
                return false;
            }
        };
        return func1;
    }

    private Func1<KanazawaItems,String> listToStringMap(){
        Func1<KanazawaItems,String> func1 = new Func1<KanazawaItems, String>() {
            @Override
            public String call(KanazawaItems items) {
                return items.getTitile();
            }
        };
        return func1;
    }

    private Subscriber<List<String>> listSubscriber(){
        Subscriber<List<String>> subscriber = new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> strings) {
                setSimpleListView(strings);
            }
        };
        return subscriber;
    }

    private void setSimpleListView(List<String> list){
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));
    }

}
