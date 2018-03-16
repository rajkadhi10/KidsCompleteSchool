package com.example.rahul.kidscompleteschool;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fruits extends AppCompatActivity {

    public ViewPager mslideViewPager;
    public LinearLayout mDotLayout;
    public SliderAdapter sliderAdapter;
    public TextView[] mDots;
    MediaPlayer mediaPlayer;
    int[] slide_images = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.grapes,
            R.drawable.guava,
            R.drawable.kiwi,
            R.drawable.mango,
            R.drawable.orange,
            R.drawable.pomegranate,
            R.drawable.strawberry,
            R.drawable.watermelon};
    String[] headings = {"APPLE","BANANA","GRAPES","GUAVA","KIWI",
            "MANGO","ORANGE","POMEGRANATE","STRAWBERRY","WATERMELON"};
    int[] back_color={
            Color.parseColor("#f00000"),
            Color.parseColor("#b4e095"),
            Color.parseColor("#f000f0"),
            Color.parseColor("#000fff"),
            Color.parseColor("#7cb342"),
            Color.parseColor("#f9a825"),
            Color.parseColor("#ff4081"),
            Color.parseColor("#cd4a4a"),
            Color.parseColor("#e53935"),
            Color.parseColor("#33691e")};
    public int[] music = {
            R.raw.apple,
            R.raw.banana,
            R.raw.grapes,
            R.raw.guava,
            R.raw.kiwi,
            R.raw.mango,
            R.raw.orange,
            R.raw.pomegranate,
            R.raw.strawberry,
            R.raw.watermelon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
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

