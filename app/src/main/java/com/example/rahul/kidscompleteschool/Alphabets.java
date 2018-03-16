package com.example.rahul.kidscompleteschool;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Alphabets extends AppCompatActivity {

    ImageView img;
    Character value;
    private int count;
    ImageButton sound_demo;
    MediaPlayer ring;
    int[] musicID,imgId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        value = 'a';
        count=0;
        sound_demo = findViewById(R.id.sound_demo);
        img = findViewById(R.id.imageView);
        imgId = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};
        musicID = new int[]{R.raw.a, R.raw.b,R.raw.c, R.raw.d,R.raw.e, R.raw.f,R.raw.g, R.raw.h,R.raw.i, R.raw.j,R.raw.k, R.raw.l, R.raw.m, R.raw.n,R.raw.o, R.raw.p,R.raw.q, R.raw.r,R.raw.s, R.raw.t,R.raw.u, R.raw.v,R.raw.w, R.raw.x,R.raw.y, R.raw.z};
        ring= MediaPlayer.create(this,musicID[count]);
        ring.start();
    }
    public void Next(View v){
        if(count<25){
            try {
                count++;
                //image
                /*int resId = getResources().getIdentifier(final_value, "drawable", getPackageName());*/

                soundDemo(v);
                img.setImageResource(imgId[count]);
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage() + "Error : ",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else {
            return;
        }
    }

    public void Previous(View v){
        if(count>0) {
            try {
                count--;
                soundDemo(v);
                img.setImageResource(imgId[count]);
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage() + "Error : ",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else {
            return;
        }

    }
    public void soundDemo(View v){
        try {
            if(ring!=null){
                ring.release();
                ring=null;
            }
            ring = MediaPlayer.create(this, musicID[count]);
            ring.start();
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Error : ",
                    Toast.LENGTH_SHORT).show();
        }
    }
}