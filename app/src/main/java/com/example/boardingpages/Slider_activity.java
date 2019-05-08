package com.example.boardingpages;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Slider_activity extends AppCompatActivity {
ViewPager viewPager;
Adapterclass adapterclass;
LinearLayout dotslayout;
ImageView[] dots;
Button nextbtn,skipbtn;


public int[] boardingpages={R.layout.firstboardingpage,R.layout.second,R.layout.third};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_activity);
        if(new Prefmanage(this).chkpref()){
            gotomain();
        }
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        adapterclass=new Adapterclass(this,boardingpages);
        viewPager.setAdapter(adapterclass);
        dotslayout=(LinearLayout) findViewById(R.id.dotslayout);
        createdots(0);
        nextbtn=(Button) findViewById(R.id.btnnext);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
loadnext();
            }
        });
        skipbtn =(Button) findViewById(R.id.btnskip);
        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotomain();
                new Prefmanage(getApplicationContext()).wriesharedpref();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
createdots(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
    private void createdots(int currentpos){
        if(dotslayout!=null){
            dotslayout.removeAllViews();
            dots=new ImageView[boardingpages.length];
            for(int i=0;i<boardingpages.length;i++){

                dots[i]=new ImageView(this);
                if(i==currentpos){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.selected_dots));
                }
                else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.defaultdots));

                }
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
           layoutParams.setMargins(4,0,4,0);
           dotslayout.addView(dots[i],layoutParams);
            }
        }
    }
    public void gotomain(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void loadnext(){
        int next=viewPager.getCurrentItem()+1;
        if(next<boardingpages.length){
            viewPager.setCurrentItem(next);
        }
        else {
            gotomain();
            new Prefmanage(this).wriesharedpref();
        }
    }
}
