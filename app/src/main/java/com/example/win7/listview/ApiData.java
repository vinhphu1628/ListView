package com.example.win7.listview;

import android.bluetooth.BluetoothClass;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by WIN7 on 27/03/2018.
 */

public class ApiData {
    @SerializedName("data")
    ArrayList<BluetoothClass.Device> data;

    @SerializedName("errorMessage")
    String errorMessage;
}
