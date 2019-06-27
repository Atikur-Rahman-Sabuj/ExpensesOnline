package com.tiringbring.expensesonline.Test;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tiringbring.expensesonline.R;

public class DynamicViewCreationActivity extends AppCompatActivity {

    private LinearLayout llParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view_creation);
        llParent = (LinearLayout) findViewById(R.id.llParent);

        for(int i=0;i<50;i++){
            //parent horizontal layout
            LinearLayout ly = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams lyparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lyparams.setMargins(5,5,5,5);
            ly.setOrientation(LinearLayout.HORIZONTAL);
            ly.setLayoutParams(lyparams);
            //layout child vertical
            LinearLayout llNew = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((i*4)+100,
                    40);
            params.setMargins(30, 5, 5,5);
            llNew.setLayoutParams(params);
            llNew.setBackgroundColor(Color.parseColor("#00ff00"));

            //child text view
            TextView tv = new TextView(getApplicationContext());
            tv.setText(String.valueOf((i*4)+100));
            LinearLayout.LayoutParams tvparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(tvparams);
            ly.addView(llNew);
            ly.addView(tv);
            llParent.addView(ly);

            //llNew.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
//            llParent.addView(llNew);
//
//            LinearLayout llNew2 = new LinearLayout(getApplicationContext());
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams((i*5)+120,
//                    50);
//            params2.setMargins(30, 5, 5,5);
//            llNew2.setLayoutParams(params2);
//            llNew2.setBackgroundColor(Color.parseColor("#0000ff"));
//            //llNew2.getBackground().setColorFilter(Color.parseColor("#0000ff"), PorterDuff.Mode.DARKEN);
//            llParent.addView(llNew2);
//
//            LinearLayout llNew3 = new LinearLayout(getApplicationContext());
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams((i*6)+140,
//                    50);
//            params3.setMargins(30, 5, 5,5);
//            llNew3.setLayoutParams(params3);
//            llNew3.setBackgroundColor(Color.parseColor("#ff0000"));
//            //llNew2.getBackground().setColorFilter(Color.parseColor("#0000ff"), PorterDuff.Mode.DARKEN);
//            llParent.addView(llNew3);
        }


    }
}
