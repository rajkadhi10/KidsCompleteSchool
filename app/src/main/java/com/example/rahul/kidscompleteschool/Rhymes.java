package com.example.rahul.kidscompleteschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Rhymes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhymes);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list);
        if (null != recyclerView) {
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerAdapter adapter=new RecyclerAdapter(Rhymes.this);
            recyclerView.setAdapter(adapter);
        }
    }
}
