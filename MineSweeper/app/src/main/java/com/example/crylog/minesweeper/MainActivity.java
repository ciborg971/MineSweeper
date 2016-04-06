package com.example.crylog.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button rst;
   static cv custom_v;
    static TextView tv1;
    static TextView tv2;
    Button cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_v = (cv)findViewById(R.id.cv);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        cover = (Button)findViewById(R.id.cover);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        custom_v.setLayoutParams(new LinearLayout.LayoutParams(width, width));
        rst =(Button)findViewById(R.id.RST);
        rst.setOnClickListener(Reset);
        cover.setOnClickListener(Mode);
        tv1.setText(String.valueOf(custom_v.mine_uncovered));
    }

    View.OnClickListener Reset = new View.OnClickListener(){
        public void onClick(View v){
            custom_v.reset();
        }
    };

    View.OnClickListener Mode = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            custom_v.mode = !custom_v.mode;
            if(custom_v.mode)
            {
                cover.setText("Uncover mode");
            }else{
                cover.setText("Marking mode");
            }
        }
    };

    static void update_textview()
    {
        tv1.setText(""+custom_v.mine_uncovered);
        tv2.setText(""+custom_v.nb_mine);
    }

}
