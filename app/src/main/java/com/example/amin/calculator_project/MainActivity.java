package com.example.amin.calculator_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView txtv;
    RadioGroup radioGroup;
    RadioButton r0;
    RadioButton r1;
    RadioButton r2;


    AlertDialog alg;
    int s_seekbar=0;
    int res = 0;
    int s_font_number=-1;
    set_setting save=new set_setting(MainActivity.this);

    int t=0;
    int t1=0;

    String result="";
    String tmp="";
    String operator="";
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button btn_cls,btn_plus,btn_mine,btn_Multiplication,btn_division,btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Typeface typeface=Typeface.createFromAsset(getAssets(),"font/Pacifico.ttf");
        init();

        save.get();
        if(save.getI()!=-1)
        {
            seekBar.setProgress(save.getI());
        }
        if(save.getFont()!=-1)
        {
            switch (save.getFont())
            {
                case 0:
                    r0.setChecked(true);
                    break;
                case 1:
                    r1.setChecked(true);
                    break;
                case 2:
                    r2.setChecked(true);
                    break;
            }
        }


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                txtv.setTextSize(i);
                s_seekbar=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i)
                {
                    case R.id.bold_rb:
                        txtv.setTypeface(null, Typeface.BOLD);
                        s_font_number=0;
                        break;

                    case R.id.t_rb:
                        s_font_number=1;
                        txtv.setTypeface(null, Typeface.ITALIC);
                        break;
                    case R.id.pacifico_rb:
                        s_font_number=2;
                        txtv.setTypeface(typeface);
                        break;

                }
            }
        });

    b0.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("0");
        }
    });
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("1");
        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("2");
        }
    });
    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("3");
        }
    });
    b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("4");
        }
    });
    b5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("5");
        }
    });
    b6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("6");
        }
    });
    b7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("7");
        }
    });
    b8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("8");
        }
    });
    b9.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumberButtonClicked("9");
        }
    });
    btn_cls.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            t=0;
            t1=0;
            clear();
        }
    });
    btn_plus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           onOperatorButtonClicked("+");
        }
    });
    btn_mine.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           onOperatorButtonClicked("-");
        }
    });
    btn_Multiplication.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           onOperatorButtonClicked("X");
        }
    });
    btn_division.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           onOperatorButtonClicked("/");
        }
    });
    btn_equal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onEqualButtonClicked();
        }
    });

    }


    public void init()
    {
        txtv=findViewById(R.id.txtv_get);
        seekBar=findViewById(R.id.seekbar);
        radioGroup=findViewById(R.id.radiogp);
        r0=findViewById(R.id.bold_rb);
        r1=findViewById(R.id.t_rb);
        r2=findViewById(R.id.pacifico_rb);
        b0=findViewById(R.id.btn_num_0);
        b1=findViewById(R.id.btn_num_one);
        b2=findViewById(R.id.btn_num_two);
        b3=findViewById(R.id.btn_num_tree);
        b4=findViewById(R.id.btn_num_four);
        b5=findViewById(R.id.btn_num_five);
        b6=findViewById(R.id.btn_num_six);
        b7=findViewById(R.id.btn_num_seven);
        b8=findViewById(R.id.btn_num_eight);
        b9=findViewById(R.id.btn_num_nine);
        btn_cls=findViewById(R.id.btn_Clear);
        btn_plus=findViewById(R.id.btn_operator_pelus);
        btn_mine=findViewById(R.id.btn_operator_mines);
        btn_Multiplication=findViewById(R.id.btn_operator_Multiplication);
        btn_division=findViewById(R.id.btn_operator_Division);
        btn_equal=findViewById(R.id.btn_operator_equal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int item_id=item.getItemId();
        switch (item_id)
        {
            case R.id.op_call:
                Intent intent_call=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+989017655255"));
                startActivity(intent_call);
                break;

            case R.id.op_comunication:
                Intent intent_web=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent_web);
                break;

            case R.id.op_exit:
                AlertDialog.Builder s=new AlertDialog.Builder(MainActivity.this);
                View v=getLayoutInflater().inflate(R.layout.alert_layout,null);
                s.setView(v);
                alg=s.create();
                alg.show();

                Button btn_yes=v.findViewById(R.id.btn_yes);
                Button btn_no=v.findViewById(R.id.btn_no);

                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        save.set(s_font_number,s_seekbar);
                        finish();
                    }
                });

                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //save.set(-1,-1);
                        finish();
                    }
                });

                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void onNumberButtonClicked(String pos)
    {
        result = txtv.getText().toString();
        result = result + pos;
        txtv.setText(result);
    }

    public void clear()
    {
        txtv.setText("");
        result="";
    }


    private void onOperatorButtonClicked(String operator)
    {
        this.operator = operator;
        t1=Integer.parseInt(txtv.getText().toString());
        switch (this.operator)
        {
            case "+":
                t  = t+ t1;
                break;
            case "/":
                if(t!=0)
                    t = t/ t1;
                else
                    t=t1;
                break;
            case "-":
                if(t!=0)
                    t = t-t1;
                else
                    t=t1;
                break;
            case "X":
                if (t!=0)
                    t=t*t1;
                else
                    t=t1;
                break;
        }
        tmp=String.valueOf(t);
        clear();
    }


    private void onEqualButtonClicked() {
        try {
            int number = Integer.valueOf(tmp);
            int number2 = Integer.valueOf(txtv.getText().toString());
            switch (operator) {
                case "+":
                    res = number + number2;
                    break;
                case "/":
                    res = number / number2;
                    break;
                case "-":
                    res = number - number2;
                    break;
                case "X":
                    res = number * number2;
                    break;
            }
            t=0;
            result = String.valueOf(res);
            txtv.setText(result);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

