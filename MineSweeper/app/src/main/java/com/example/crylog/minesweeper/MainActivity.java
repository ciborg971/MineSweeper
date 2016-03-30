package com.example.crylog.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv custom_v = (cv)findViewById(R.id.cv);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        custom_v.setLayoutParams(new LinearLayout.LayoutParams(width, width));
    }
}
