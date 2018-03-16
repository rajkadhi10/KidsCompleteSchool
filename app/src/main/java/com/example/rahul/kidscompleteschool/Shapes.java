package com.example.rahul.kidscompleteschool;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Shapes extends AppCompatActivity {

    public ViewPager mslideViewPager;
    public LinearLayout mDotLayout;
    public SliderAdapter sliderAdapter;
    public TextView[] mDots;
    MediaPlayer mediaPlayer;
    int[] slide_images = {
            R.drawable.circle,
            R.drawable.cube,
            R.drawable.cylinder,
            R.drawable.hexagon,
            R.drawable.oval,
            R.drawable.pentagon,
            R.drawable.rectangle,
            R.drawable.square,
            R.drawable.star,
            R.drawable.triangle};
    String[] headings = {"CIRCLE","CUBE","CYLINDER",
            "HEXAGON","OVAL", "PENTAGON",
            "RECTANGLE","SQUARE","STAR","TRIANGLE"};
    int[] back_color={
            Color.parseColor("#e53935"),
            Color.parseColor("#000000"),
            Color.parseColor("#c2185b"),
            Color.parseColor("#ff6f00"),
            Color.parseColor("#00acc1"),
            Color.parseColor("#e040fb"),
            Color.parseColor("#d50000"),
            Color.parseColor("#00796b"),
            Color.parseColor("#ff8f00"),
            Color.parseColor("#9e9e9e")};
    public int[] music = {
            R.raw.circle,
            R.raw.cube,
            R.raw.cylinder,
            R.raw.hexagon,
            R.raw.oval,
            R.raw.pentagon,
            R.raw.rectangle,
            R.raw.square,
            R.raw.star,
            R.raw.triangle};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
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

