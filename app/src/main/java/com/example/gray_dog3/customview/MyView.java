package com.example.gray_dog3.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by gray_dog3 on 16/2/25.
 */
public class MyView extends View implements Runnable {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private Paint mPaint;
    private int mRadiu=200;

    public void initPaint() {
        if (mPaint == null) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.LTGRAY);
            mPaint.setStrokeWidth(10);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2,mRadiu, mPaint);

    }

    public void setReduis(){
        if (mRadiu < 200) {
            mRadiu+=10;
        }else {
            mRadiu=0;
        }
        postInvalidate();
    }

    @Override
    public void run() {
        while(true){
            setReduis();
            try {
                Thread.sleep(40);
            }catch (Exception e){
                Log.e(this.toString(),e.toString());
            }
        }
    }
}
