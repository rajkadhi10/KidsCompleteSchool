package com.example.rahul.kidscompleteschool;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Vegetables extends AppCompatActivity {

    public ViewPager mslideViewPager;
    public LinearLayout mDotLayout;
    public SliderAdapter sliderAdapter;
    public TextView[] mDots;
    MediaPlayer mediaPlayer;
    int[] slide_images = {
            R.drawable.brinjal,
            R.drawable.cabbage,
            R.drawable.carrot,
            R.drawable.cauliflower,
            R.drawable.chilli,
            R.drawable.ladyfinger,
            R.drawable.onion,
            R.drawable.peas,
            R.drawable.potato,
            R.drawable.tomato};
    String[] headings = {"BRINJAL","CABBAGE","CARROT","CAULIFLOWER","CHILLI",
            "LADYFINGER","ONION","PEAS","POTATO","TOMATO"};
    int[] back_color={
            Color.parseColor("#00c853"),
            Color.parseColor("#009688"),
            Color.parseColor("#ff3d00"),
            Color.parseColor("#1e88e5"),
            Color.parseColor("#d50000"),
            Color.parseColor("#388e3c"),
            Color.parseColor("#c51162"),
            Color.parseColor("#4caf50"),
            Color.parseColor("#e1b582"),
            Color.parseColor("#ff0000")};
    public int[] music = {
            R.raw.brinjal,
            R.raw.cabbage,
            R.raw.carrot,
            R.raw.cauliflower,
            R.raw.chilli,
            R.raw.ladyfinger,
            R.raw.onion,
            R.raw.peas,
            R.raw.potato,
            R.raw.tomato};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);
        mslideViewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        sliderAdapter = new SliderAdapter(this,slide_images,headings,back_color);
        mslideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListener);

    }
    public void addDotsIndicator(int position){
        mDots = new TextView[10];
        mDotLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.blue));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
            if(mediaPlayer!=null){
                mediaPlayer.release();
                mediaPlayer=null;
            }
            mediaPlayer = MediaPlayer.create(this,music[position]);
            mediaPlayer.start();
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
}

