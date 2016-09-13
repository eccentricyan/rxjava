package com.eccentricyan.rxjava;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rcube on 2016/09/13.
 */
public class KanazawaEntity {
    @SerializedName("items")
    private List<KanazawaItems> kanazawaItemses;

    @SerializedName("base_url")
    private String base_url;


    public List<KanazawaItems> getKanazawaItemses() {
        return kanazawaItemses;
    }

    public String getBase_url() {
        return base_url;
    }
}
