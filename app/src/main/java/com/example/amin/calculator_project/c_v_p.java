package com.example.amin.calculator_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class c_v_p extends PagerAdapter {
    Context contex;
    LayoutInflater layoutInflater;

    int  [] layids={R.layout.layout1,R.layout.layout2};

    public c_v_p(Context context)
    {
        this.contex=context;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View   v=   layoutInflater.inflate(contex.getResources().getLayout(layids[position]),container,false);
        container.addView(v);
        return  v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View)object);
    }


    @Override
    public int getCount() {
        return layids.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
