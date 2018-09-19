package com.example.amin.calculator_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;

public class splash extends AppCompatActivity {

    Animation animation;
    ImageView iv_splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv_splash=findViewById(R.id.iv_splash);
        animation= AnimationUtils.loadAnimation(splash.this,R.anim.anim_iv_sp);
        iv_splash.setAnimation(animation);

        fullscreen();

        Thread t=new Thread(new Runnable() {
            @Override
            public void run()
            {

                try
                {
                    Thread.sleep(1000);

                    SharedPreferences pref1=getSharedPreferences("key",MODE_PRIVATE);
                    int i=pref1.getInt("i",0);
                    if (i!=1)
                    {
                        Intent intent=new Intent(splash.this,v_p_act.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent=new Intent(splash.this,MainActivity.class);
                        startActivity(intent);
                    }

                    finish();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }
    public void fullscreen()
    {
        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

    }

}
