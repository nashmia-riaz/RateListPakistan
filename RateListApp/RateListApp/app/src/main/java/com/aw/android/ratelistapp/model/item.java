package com.aw.android.ratelistapp.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by AWShades on 5/28/2017.
 */
@IgnoreExtraProperties
public class item {
    public String id;
    public String name;
    public String rate;
    public item(){

    }
    public item(String a,String b,String c){
        id = a;
        name = b;
        rate = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
