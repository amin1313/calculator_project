package com.example.amin.calculator_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class set_setting
{
    Activity activity;
    int font;
    int i;


    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }




    public set_setting(Activity activity)
    {
        this.activity=activity;
    }
    public void set(int font,int i)
    {
        SharedPreferences.Editor pref=activity.getPreferences(MODE_PRIVATE).edit();
        pref.putInt("i",i);
        pref.putInt("font",font);
        pref.apply();
    }

    public void get()
    {
        SharedPreferences pref1=activity.getPreferences(MODE_PRIVATE);
        i=pref1.getInt("i",0);
        font=pref1.getInt("font",0);
    }


}
