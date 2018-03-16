package com.example.rahul.kidscompleteschool;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Animals extends AppCompatActivity {

    public ViewPager mslideViewPager;
    public LinearLayout mDotLayout;
    public SliderAdapter sliderAdapter;
    public TextView[] mDots;
    MediaPlayer mediaPlayer;
    int[] slide_images = {R.drawable.bear,R.drawable.cat,R.drawable.cow,R.drawable.deer,R.drawable.dog,R.drawable.elephant,R.drawable.fox,R.drawable.horse,R.drawable.lion,R.drawable.tiger};
    String[] headings = {"BEAR","CAT","COW","DEER","DOG","ELEPHANT","FOX","HORSE","LION","TIGER"};
    int[] back_color={
            Color.parseColor("#ff5500"),
            Color.parseColor("#141f1f"),
            Color.parseColor("#4e342e"),
            Color.parseColor("#ff6e40"),
            Color.parseColor("#ff9800"),
            Color.parseColor("#424242"),
            Color.parseColor("#33cc33"),
            Color.parseColor("#141f1f"),
            Color.parseColor("#6666ff"),
            Color.parseColor("#e10000")};
    public int[] music = {R.raw.bear,R.raw.cat,R.raw.cow,R.raw.deer,R.raw.dog,R.raw.elephant,R.raw.fox,R.raw.horse,R.raw.lion,R.raw.tiger};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
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

