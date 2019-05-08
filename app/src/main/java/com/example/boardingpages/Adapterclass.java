package com.example.boardingpages;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Adapterclass extends PagerAdapter {
    public LayoutInflater inflater;
    int[] boardingpages;
    Context context;
    public Adapterclass(Context context,int[] boardingpages){
        this.context=context;
        this.boardingpages=boardingpages;
        inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return boardingpages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=inflater.inflate(boardingpages[position],container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view=(View)  object;
        super.destroyItem(container, position, object);
        container.removeView(view);
    }
}
