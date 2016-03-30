package com.example.crylog.minesweeper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by crylog on 30/03/16.
 */
public class cv extends View {
    int time;
    int number_of_mine;
    public cv(Context context, Attributes as)
    {
        super(context, (AttributeSet) as);
        init();
    }
    private void init()
    {
        time = 99;
        number_of_mine = 20;

    }
}
