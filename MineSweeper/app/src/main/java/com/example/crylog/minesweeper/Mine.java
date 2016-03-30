package com.example.crylog.minesweeper;

/**
 * Created by crylog on 30/03/16.
 */
public class Mine {
    int number = 0;
    boolean cover = true;
    float left;
    float right;
    float top;
    float bottom;
    boolean mined;

    public void Rect(float left,float top,float right,float bottom)
    {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }
}
