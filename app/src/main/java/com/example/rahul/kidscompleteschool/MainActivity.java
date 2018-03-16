package com.example.rahul.kidscompleteschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void ivAlphabets(View v){
        Intent intent = new Intent(this,Alphabets.class);
        startActivity(intent);
    }

    void ivAnimals(View v){
        Intent intent = new Intent(this,Animals.class);
        startActivity(intent);
    }

    void ivRhymes(View v){
        Intent intent = new Intent(this,Rhymes.class);
        startActivity(intent);
    }
    void ivBirds(View v){
        Intent intent = new Intent(this,Birds.class);
        startActivity(intent);
    }
    void ivFruits(View v){
        Intent intent = new Intent(this,Fruits.class);
        startActivity(intent);
    }
    void ivVegetables(View v){
        Intent intent = new Intent(this,Vegetables.class);
        startActivity(intent);
    }
    void ivShapes(View v){
        Intent intent = new Intent(this,Shapes.class);
        startActivity(intent);
    }
    void ivColors(View v){
        Intent intent = new Intent(this,ColorActivity.class);
        startActivity(intent);
    }
}
