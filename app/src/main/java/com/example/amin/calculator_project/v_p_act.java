package com.example.amin.calculator_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class v_p_act extends AppCompatActivity {

    ViewPager viewPager;
    Button btn_go;
    int k=1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_p_act);
        viewPager=findViewById(R.id.viewpager);
        btn_go=findViewById(R.id.btn_go);

        c_v_p custom_view_pager=new c_v_p(v_p_act.this);
        viewPager.setAdapter(custom_view_pager);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor pref2=getSharedPreferences("key",MODE_PRIVATE).edit();
                pref2.putInt("i",1);
                pref2.apply();
                Intent intent=new Intent(v_p_act.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position)
            {
                if(position==viewPager.getAdapter().getCount()-1)
                    btn_go.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
