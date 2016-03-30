package com.example.crylog.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
Button rst;
    cv custom_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_v = (cv)findViewById(R.id.cv);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        custom_v.setLayoutParams(new LinearLayout.LayoutParams(width, width));
        rst =(Button)findViewById(R.id.RST);
        rst.setOnClickListener(Reset);
    }

    View.OnClickListener Reset = new View.OnClickListener(){
        public void onClick(View v){
            custom_v.reset();
        }
    };


}
