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
    private boolean init = false;
    private Mine [] [] MineArr = new Mine [10] [10];
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
        if(!init) {
            int offset = width / 10;
            for (int x = 0; x < 10; x++)
                for (int y = 0; y < 10; y++) {
                    Mine mn = new Mine();
                    mn.Rect(x * offset, y * offset, x * offset + offset, y * offset + offset);
                    MineArr[x][y] = mn;
                }
            init = true;
        }
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 10; y++) {
                if(MineArr[x][y].cover){
                    pt.setColor(Color.WHITE);
                    pt.setStyle(Paint.Style.STROKE);
                }else{
                    pt.setColor(Color.GRAY);
                    pt.setStyle(Paint.Style.FILL);
                }

                canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
            }

    }
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
            float touchx = event.getX();
            float touchy = event.getY();
            for (int x = 0; x < 10; x++)
                for(int y = 0; y < 10; y++)
                {
                    if(MineArr[x][y].cover){
                        if (((MineArr[x][y].left < touchx)&&(touchx < MineArr[x][y].right))&& ((MineArr[x][y].top < touchy)&&(touchy < MineArr[x][y].bottom))){
                            MineArr[x][y].cover = false;
                        }
                    }
                }
            invalidate();
            return true;
        }
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
    }
}
