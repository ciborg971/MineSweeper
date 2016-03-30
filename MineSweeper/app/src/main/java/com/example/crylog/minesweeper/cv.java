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

import java.util.Random;


/**
 * Created by crylog on 30/03/16.
 */
public class cv extends View {
    private boolean init = false;
    private Mine [] [] MineArr = new Mine [10] [10];
    private int width;
    private float offset;
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
            offset = width / 10;
            for (int x = 0; x < 10; x++)
                for (int y = 0; y < 10; y++) {
                    Mine mn = new Mine();
                    mn.Rect(x * offset, y * offset, x * offset + offset, y * offset + offset);
                    MineArr[x][y] = mn;
                }
            Put_Mine(20);
            Set_number();
            init = true;
        }
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 10; y++) {
                if(MineArr[x][y].cover){
                    pt.setColor(Color.WHITE);
                    pt.setStyle(Paint.Style.STROKE);
                    canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                }else{
                    if(MineArr[x][y].mined){
                        pt.setColor(Color.RED);
                        pt.setStyle(Paint.Style.FILL);
                        canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                        pt.setColor(Color.BLACK);
                        canvas.drawText("M",0,1,MineArr[x][y].left+offset/2,MineArr[x][y].top+offset/2,pt);
                    } else {
                        pt.setColor(Color.GRAY);
                        pt.setStyle(Paint.Style.FILL);
                        canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                        if(MineArr[x][y].number == 1)
                            pt.setColor(Color.BLUE);

                        if(MineArr[x][y].number == 2)
                            pt.setColor(Color.GREEN);

                        if(MineArr[x][y].number == 3)
                            pt.setColor(Color.YELLOW);

                        if(MineArr[x][y].number >= 4)
                            pt.setColor(Color.RED);

                        canvas.drawText(String.valueOf(MineArr[x][y].number), 0, 1, MineArr[x][y].left + offset / 2, MineArr[x][y].top + offset / 2, pt);
                    }
                }
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

    private void Put_Mine(int nmb)
    {
        Random rnd = new Random();
        while(nmb != 0) {
            int x = rnd.nextInt(9);
            int y = rnd.nextInt(9);
            if(!MineArr[x][y].mined)
            {
                MineArr[x][y].mined = true;

                nmb--;
            }
        }
    }
    private void Set_number()
    {
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 10; y++)
                MineArr[x][y].number = xy_to_int(x-1,y-1) + xy_to_int(x+1,y-1) + xy_to_int(x,y-1)+ xy_to_int(x-1,y) + xy_to_int(x+1,y) + xy_to_int(x-1,y+1) + xy_to_int(x,y+1) + xy_to_int(x+1,y+1);
    }
    private int xy_to_int(int x, int y)
    {
        if((x < 0)||(y < 0))
            return 0;

        if((x >= 10)||(y >= 10))
            return 0;

        if(!MineArr[x][y].mined)
            return 0;

        return 1;
    }
}
