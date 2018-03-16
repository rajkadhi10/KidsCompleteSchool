package com.example.rahul.kidscompleteschool;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by rahul on 3/13/18.
 */

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

     SliderAdapter(Context context, int[] slide_images,String[] headings , int[] back_color){
        this.context = context;
        this.slide_images = slide_images;
        this.headings = headings;
        this.back_color = back_color;
    }
     int[] slide_images;
     String[] headings;
     int[] back_color;
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==  object;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int postion){

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView heading = view.findViewById(R.id.textView);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_view);
        relativeLayout.setBackgroundColor(back_color[postion]);
        slideImageView.setImageResource(slide_images[postion]);
        heading.setText(headings[postion]);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){

        container.removeView((RelativeLayout)object);
    }
}
