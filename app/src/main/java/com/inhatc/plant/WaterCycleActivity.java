package com.inhatc.plant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WaterCycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager LayoutManager;
    private java.util.ArrayList<String> arrayList;
    private RecyclerAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_cycle);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 활성화
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);

        // 물 준 날짜를 받을 WaterCycle형 arraylist
        arrayList = new ArrayList<>();
        // arraylist 초기화
        arrayList.clear();

        // 통신 후 날짜를 받아와 배열에 저장해야 함(샘플 코드)
        arrayList.add("2022-09-29");
        arrayList.add("2022-09-24");
        arrayList.add("2022-09-20");
        arrayList.add("2022-09-15");
        arrayList.add("2022-09-10");
        arrayList.add("2022-09-05");
        arrayList.add("2022-09-01");

        RecyclerAdapter adapter = new RecyclerAdapter(arrayList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}