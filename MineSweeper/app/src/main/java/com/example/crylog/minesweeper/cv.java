package com.example.crylog.minesweeper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by crylog on 30/03/16.
 */
public class cv extends View {
    int time;
    int number_of_mine;
    public cv (Context cont, AttributeSet att)
    {
        super(cont,att);
        init();
    }
    private void init()
    {
        time = 99;
        number_of_mine = 20;
    }
}
