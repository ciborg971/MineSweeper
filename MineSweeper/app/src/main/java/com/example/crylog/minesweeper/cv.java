package com.example.crylog.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


/**
 * Created by crylog on 30/03/16.
 */
public class cv extends View {
    private boolean init = false;
    private Mine [] [] MineArr = new Mine [10] [10];
    private int width;
    private float offset;
    public int nb_mine = 20;
    public int mine_uncovered;
    public boolean mode = true;
    public cv (Context cont, AttributeSet att)
    {
        super(cont, att);
        init();
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pt = new Paint();
        pt.setStyle(Paint.Style.FILL);
        pt.setColor(Color.BLACK);
        canvas.drawPaint(pt);
        pt.setColor(Color.WHITE);
        pt.setStyle(Paint.Style.STROKE);
        if (!init) {
            offset = width / 10;
            Mine mn;
            pt.setColor(Color.WHITE);
            pt.setStyle(Paint.Style.STROKE);
            for (int x = 0; x < 10; x++)
                for (int y = 0; y < 10; y++) {
                    mn = new Mine();
                    mn.Rect(x * offset, y * offset, x * offset + offset, y * offset + offset);
                    MineArr[x][y] = mn;
                    canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                }
            Put_Mine(nb_mine);
            Set_number();
            init = true;
        }
        for (int x = 0; x < 10; x++)
            for (int y = 0; y < 10; y++) {
                if (MineArr[x][y].cover&&!MineArr[x][y].spotted) {
                    pt.setColor(Color.WHITE);
                    pt.setStyle(Paint.Style.STROKE);
                    canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                }
                if (MineArr[x][y].spotted&&!MineArr[x][y].cover) {
                        MineArr[x][y].cover = false;
                        pt.setColor(Color.YELLOW);
                        pt.setStyle(Paint.Style.FILL);
                        canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                    }

                if (MineArr[x][y].mined && !MineArr[x][y].spotted&& !MineArr[x][y].cover) {
                            pt.setColor(Color.RED);
                            pt.setStyle(Paint.Style.FILL);
                            canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                            pt.setColor(Color.BLACK);
                            canvas.drawText("M", 0, 1, MineArr[x][y].left + offset / 2, MineArr[x][y].top + offset / 2, pt);
                            loose();
                        }
                if(!MineArr[x][y].mined && !MineArr[x][y].spotted&&!MineArr[x][y].cover){

                                pt.setColor(Color.GRAY);
                                pt.setStyle(Paint.Style.FILL);
                                canvas.drawRect(MineArr[x][y].left, MineArr[x][y].top, MineArr[x][y].right, MineArr[x][y].bottom, pt);
                                if (MineArr[x][y].number == 1)
                                    pt.setColor(Color.BLUE);

                                if (MineArr[x][y].number == 2)
                                    pt.setColor(Color.GREEN);

                                if (MineArr[x][y].number == 3)
                                    pt.setColor(Color.YELLOW);

                                if (MineArr[x][y].number >= 4)
                                    pt.setColor(Color.RED);

                                canvas.drawText(String.valueOf(MineArr[x][y].number), 0, 1, MineArr[x][y].left + offset / 2, MineArr[x][y].top + offset / 2, pt);

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

                        if (((MineArr[x][y].left < touchx)&&(touchx < MineArr[x][y].right))&& ((MineArr[x][y].top < touchy)&&(touchy < MineArr[x][y].bottom))){
                            if(mode&&MineArr[x][y].cover){
                                MineArr[x][y].cover = false;
                            }else{
                                if(MineArr[x][y].spotted&&!MineArr[x][y].cover)
                                {
                                    mine_uncovered--;
                                    MineArr[x][y].spotted = false;
                                    MineArr[x][y].cover = true;
                                }
                                else if(!MineArr[x][y].spotted&&MineArr[x][y].cover)
                                {
                                    mine_uncovered++;
                                    MineArr[x][y].spotted = true;
                                    MineArr[x][y].cover = false;
                                }
                                MainActivity.update_textview();
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
        mine_uncovered = 0;
        MainActivity.update_textview();
        Random rnd = new Random();
        while(nmb != 0) {
            int x = rnd.nextInt(10);
            int y = rnd.nextInt(10);
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
    private void loose()
    {
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 10; y++)
                MineArr[x][y].cover = false;

        invalidate();
    }
    public void reset()
    {
        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 10; y++)
                MineArr[x][y].cover = true;

        init = false;
        invalidate();
    }
}
