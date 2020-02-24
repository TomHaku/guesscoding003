package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int r=0;
    int r1=0;
    String strnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.correct);
        //setContentView(R.layout.small);
        /*TextView txtNormal = (TextView) findViewById(R.id.editText_number_consola);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.consola);
        txtNormal.setTypeface(typeface);*/
        Button btnone= (Button) findViewById(R.id.button_check);
        Random random=new Random();
        r=random.nextInt(9999);
        r=r%10000;
    }

    public void onclick_buttoncorrect(View view)
    {
        setContentView(R.layout.activity_main);
        Button btnone= (Button) findViewById(R.id.button_check);
    }

    public void onclick_buttonfalse(View view)
    {
        setContentView(R.layout.activity_main);
        Button btnone= (Button) findViewById(R.id.button_check);
    }

    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    public void onclick_buttoncheck(View view)
    {
        EditText editText1 =(EditText)findViewById(R.id.editText_number_consola);
        strnum=editText1.getText().toString();
        Button btnone= (Button) findViewById(R.id.button_check);

        if(!isNumeric(strnum))
        {
            setContentView(R.layout.activity_main);
        }
        if(isNumeric(strnum))
        {
            r1=Integer.parseInt(strnum);
            if(r1==r)
            {
                setContentView(R.layout.correct);
                Random random=new Random();
                r=random.nextInt(9999);
                r=r%10000;
                TextView tc=(TextView)findViewById(R.id.textView_correct2);
                tc.setText(strnum);
            }
            else if(r<r1)
            {
                setContentView(R.layout.big);
                TextView tb=(TextView)findViewById(R.id.textView_big2);
                tb.setText(strnum);
            }
            else
            {
                setContentView(R.layout.small);
                TextView ts=(TextView)findViewById(R.id.textView_small2);
                ts.setText(strnum);
            }
        }
    }
}
