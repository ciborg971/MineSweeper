package com.example.crylog.minesweeper;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        int width = custom_v.getWidth();
        custom_v.setLayoutParams(new LinearLayout.LayoutParams(width,width));
    }
}
