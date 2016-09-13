package com.eccentricyan.rxjava;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rcube on 2016/09/13.
 */
public class KanazawaItems {
    @SerializedName("group")
    private String group;


    @SerializedName("date_from")
    private String data_from;


    @SerializedName("date_to")
    private String data_to;


    @SerializedName("dates")
    private List<String> dates;


    @SerializedName("title")
    private String titile;


    @SerializedName("link")
    private String link;


    @SerializedName("description")
    private String description;


    @SerializedName("images")
    private List<String> images;


    public String getGroup() {
        return group;
    }

    public String getTitile() {
        return titile;
    }
}
