package com.example.crylog.minesweeper;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv custom_v = (cv)findViewById(R.id.cv);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        Log.d("MainActivity","poney"+ width);
        custom_v.setLayoutParams(new LinearLayout.LayoutParams(width, width));
    }
}
