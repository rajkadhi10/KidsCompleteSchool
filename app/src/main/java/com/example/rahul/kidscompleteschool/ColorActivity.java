package com.example.rahul.kidscompleteschool;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {

    public ViewPager mslideViewPager;
    public LinearLayout mDotLayout;
    public SliderAdapterColor sliderAdapter;
    public TextView[] mDots;
    MediaPlayer mediaPlayer;
    String[] headings = {"BLACK","GREEN","BLUE","ORANGE","RED",
            "BROWN","CYAN","PINK","GRAY","YELLOW"};
    int[] back_color={
            Color.parseColor("#000000"),
            Color.parseColor("#43a047"),
            Color.parseColor("#1976d2"),
            Color.parseColor("#ff5722"),
            Color.parseColor("#ff1744"),
            Color.parseColor("#795548"),
            Color.parseColor("#00bcd4"),
            Color.parseColor("#ff4081"),
            Color.parseColor("#757575"),
            Color.parseColor("#f9a825")};
    public int[] music = {
            R.raw.black,
            R.raw.green,
            R.raw.blue,
            R.raw.orange,
            R.raw.red,
            R.raw.brown,
            R.raw.cyan,
            R.raw.pink,
            R.raw.gray,
            R.raw.yellow};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        mslideViewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        sliderAdapter = new SliderAdapterColor(this,headings,back_color);
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

