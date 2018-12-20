package com.example.win7.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Integer> list;
    customAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        list = new ArrayList();
        adapter = new customAdapter(this, R.layout.item_list_view, list);
        listView.setAdapter(adapter);

        ApiController controller = new ApiController();
        controller.getData().addListener(new ApiController.ApiListener() {
            @Override
            public void onGetData(ApiData data) {
                if (data != null){
                    list.clear();
                    list.addAll(data.data);
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }
}

