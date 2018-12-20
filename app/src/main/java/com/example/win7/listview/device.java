package com.example.win7.listview;

import java.util.ArrayList;

/**
 * Created by WIN7 on 13/03/2018.
 */

public class device {
    String mssv;
    float temperature;
    float humid;
    long time;

    public device(String mssv, float temperature, float humid, long time) {
        this.mssv = mssv;
        this.temperature = temperature;
        this.humid = humid;
        this.time = time;
    }

    public String getMssv() {
        return mssv;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumid() {
        return humid;
    }

    public long getTime() {
        return time;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumid(float humid) {
        this.humid = humid;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

