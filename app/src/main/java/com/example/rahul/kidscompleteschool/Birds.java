package com.example.rahul.kidscompleteschool;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Birds extends AppCompatActivity {

    public ViewPager mslideViewPager;
    public LinearLayout mDotLayout;
    public SliderAdapter sliderAdapter;
    public TextView[] mDots;
    MediaPlayer mediaPlayer;
    int[] slide_images = {
            R.drawable.crow,
            R.drawable.duck,
            R.drawable.eagle,
            R.drawable.hen,
            R.drawable.ostrich,
            R.drawable.parrot,
            R.drawable.peacock,
            R.drawable.pegion,
            R.drawable.sparrow,
            R.drawable.swan};
    String[] headings = {"CROW","DUCK","EAGLE","HEN","OSTRICH","PARROT","PEACOCK","PEGION","SPARROW","SWAN"};
    int[] back_color={
            Color.parseColor("#87bdd8"),
            Color.parseColor("#c4b7a6"),
            Color.parseColor("#4267b2"),
            Color.parseColor("#9a4d00"),
            Color.parseColor("#FF4081"),
            Color.parseColor("#00bd4f"),
            Color.parseColor("#3751cd"),
            Color.parseColor("#cc0000"),
            Color.parseColor("#a38746"),
            Color.parseColor("#000000")};
    public int[] music = {
            R.raw.crow,
            R.raw.duck,
            R.raw.eagle,
            R.raw.hen,
            R.raw.ostrich,
            R.raw.parrot,
            R.raw.peacock,
            R.raw.pegion,
            R.raw.sparrow,
            R.raw.swan};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);
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

