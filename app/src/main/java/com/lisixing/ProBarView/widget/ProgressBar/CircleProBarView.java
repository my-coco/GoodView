package com.lisixing.ProBarView.widget.ProgressBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleProBarView extends View {
    private Paint proPaint,fillPaint,strokePaint;
    private int mWidth,mHeight,mStrokeWidth;
    private float maxProgress,progress;
    private Boolean reverse;
    private RectF fillRect,proRect,strokeRect;

    public CircleProBarView(Context context) {
        this(context,null);
    }

    public CircleProBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleProBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        proPaint=new Paint();
        fillPaint=new Paint();
        strokePaint=new Paint();
        proPaint.setAntiAlias(true);
        fillPaint.setAntiAlias(true);
        strokePaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
