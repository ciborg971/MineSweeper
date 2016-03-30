package com.example.crylog.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by crylog on 30/03/16.
 */
public class cv extends View {
    private Rect square;
    private boolean touches[];
    private float touchx[];
    private float touchy[];
    private boolean touch;
    private Paint black, grey, white;
    public cv (Context cont, AttributeSet att)
    {
        super(cont,att);
        init();
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint pt = new Paint();
        pt.setStyle(Paint.Style.FILL);
        pt.setColor(Color.BLACK);
        canvas.drawPaint(pt);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }
    private void init()
    {
        black = new Paint(Paint.ANTI_ALIAS_FLAG);
        grey = new Paint(Paint.ANTI_ALIAS_FLAG);
        white = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setColor(0xff000000);
        grey.setColor(0xff888888);
        white.setColor(0xffffffff);


    }
}
