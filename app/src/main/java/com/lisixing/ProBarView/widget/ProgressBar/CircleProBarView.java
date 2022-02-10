package com.lisixing.ProBarView.widget.ProgressBar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.lisixing.ProBarView.R;

public class CircleProBarView extends View {
    private Paint proPaint,fillPaint,strokePaint,textPaint;
    private int mWidth,mHeight;
    private float maxProgress,progress,mCircleWidth,mTextSize,mStrokeWidth;
    private Boolean reverse;
    private RectF fillRect,proRect,strokeRect1,strokeRect2;

    public CircleProBarView(Context context) {
        this(context,null);
    }

    public CircleProBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleProBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        proPaint=new Paint();
        fillPaint=new Paint();
        strokePaint=new Paint();
        textPaint=new Paint();
        textPaint.setAntiAlias(true);
        proPaint.setAntiAlias(true);
        fillPaint.setAntiAlias(true);
        strokePaint.setAntiAlias(true);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.ProBarView);
        TypedArray typedArrayCircle=context.obtainStyledAttributes(attrs,R.styleable.CircleProBarView);
        int proColor=typedArray.getColor(R.styleable.ProBarView_ProBarColor, Color.BLACK);
        int fillColor=typedArray.getColor(R.styleable.ProBarView_FillBarColor,Color.WHITE);
        int strokeColor=typedArray.getColor(R.styleable.ProBarView_StrokeColor,Color.GRAY);
        int textColor=typedArrayCircle.getColor(R.styleable.CircleProBarView_TextColor,Color.BLACK);
        mStrokeWidth= typedArray.getDimension(R.styleable.ProBarView_StrokeWidth,0);
        maxProgress=typedArray.getFloat(R.styleable.ProBarView_MaxProgress,100);
        progress=typedArray.getFloat(R.styleable.ProBarView_DefaultProgress,0);
        reverse=typedArray.getBoolean(R.styleable.ProBarView_Reverse,false);
        mCircleWidth= (int) typedArrayCircle.getDimension(R.styleable.CircleProBarView_CircleWidth,0);
        mTextSize= (int) typedArrayCircle.getDimension(R.styleable.CircleProBarView_TextSize,14);
        proPaint.setColor(proColor);
        fillPaint.setColor(fillColor);
        strokePaint.setColor(strokeColor);
        strokePaint.setStrokeWidth(mStrokeWidth);
        proPaint.setStrokeWidth(mCircleWidth);
        fillPaint.setStrokeWidth(mCircleWidth);
        textPaint.setColor(textColor);
        proPaint.setStyle(Paint.Style.STROKE);
        fillPaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(mTextSize);
        typedArray.recycle();
        typedArrayCircle.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=MeasureSpec.getSize(widthMeasureSpec);
        mHeight=MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mWidth,mHeight);
        strokeRect1=new RectF(mStrokeWidth/2,mStrokeWidth/2,mWidth-mStrokeWidth/2,mHeight-mStrokeWidth/2);
        proRect=new RectF(mCircleWidth/2+mStrokeWidth,mCircleWidth/2+mStrokeWidth,mWidth-mCircleWidth/2-mStrokeWidth,mHeight-mCircleWidth/2-mStrokeWidth);
        strokeRect2=new RectF(mStrokeWidth+mCircleWidth,mStrokeWidth+mCircleWidth,mWidth-mStrokeWidth-mCircleWidth,mHeight-mStrokeWidth-mCircleWidth);
        fillRect=new RectF(mCircleWidth/2+mStrokeWidth,mCircleWidth/2+mStrokeWidth,mWidth-mCircleWidth/2-mStrokeWidth,mHeight-mCircleWidth/2-mStrokeWidth);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(strokeRect1,-90,360,false,strokePaint);
        if (reverse){
            float angle=progress/maxProgress*360;
            canvas.drawArc(proRect,-90,-angle,false,proPaint);
            canvas.drawArc(fillRect,-angle-90,-360+angle,false,fillPaint);
        }else{
            float angle=progress/maxProgress*360;
            canvas.drawArc(proRect,-90,angle,false,proPaint);
            canvas.drawArc(fillRect,angle-90,360-angle,false,fillPaint);
        }
        String text=String.valueOf(progress)+"%";
        float textWidth=textPaint.measureText(text);
        float textX=mWidth/2-textWidth/2;
        Paint.FontMetrics fontMetrics=textPaint.getFontMetrics();
        float dy=(fontMetrics.descent-fontMetrics.ascent)/2-fontMetrics.descent;
        float textY=mHeight/2+dy;
        canvas.drawText(text,textX,textY,textPaint);
        canvas.drawArc(strokeRect2,-90,360,false,strokePaint);
    }

    public void setProgress(float progress){
        if(progress<0){
            this.progress=0;
        }
        if (progress>maxProgress){
            this.progress=maxProgress;
        }else{
            this.progress=progress;
        }
        postInvalidate();
    }


}
