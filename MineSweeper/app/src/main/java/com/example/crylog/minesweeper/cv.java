package com.example.crylog.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
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
    private int width;
    public cv (Context cont, AttributeSet att)
    {
        super(cont, att);
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
        pt.setColor(Color.WHITE);
        pt.setStyle(Paint.Style.STROKE);
        int offset = width/10;
        Log.d("CV","" + width);
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 10; y++)
                canvas.drawRect(x*offset,y*offset,x*offset+offset,y*offset+offset,pt);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        width = w;
        super.onSizeChanged(w,h,oldw,oldh);
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
