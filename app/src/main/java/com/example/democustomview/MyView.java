package com.example.democustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.lang.reflect.Type;
import java.security.MessageDigest;


public class MyView extends View {
    private Paint mCircle;
    private Paint mEyeAndMouth;

    private float mCenterX;
    private float mCenterY;
    private float mRadius;
    private RectF mArcBounds = new RectF();

    private int mNumberOfDots;


    private String TAG = "hieuvh";
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView, 0,0);

        mNumberOfDots = typedArray.getInt(R.styleable.MyView_numberOfDots, 0);
        initPaints();
    }

    public int getmNumberOfDots() {
        return mNumberOfDots;
    }

    public void setmNumberOfDots(int mNumberOfDots) {
        this.mNumberOfDots = mNumberOfDots;
        invalidate();
        requestLayout();
    }

    private void initPaints() {
        mCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircle.setStyle(Paint.Style.FILL);
        mCircle.setColor(Color.YELLOW);
        mEyeAndMouth = new Paint(Paint.ANTI_ALIAS_FLAG);
        mEyeAndMouth.setStyle(Paint.Style.STROKE);
        mEyeAndMouth.setStrokeWidth(16 * getResources().getDisplayMetrics().density);
        mEyeAndMouth.setStrokeCap(Paint.Cap.ROUND);
        mEyeAndMouth.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<getmNumberOfDots();i++){
            canvas.drawCircle(mCenterX, mCenterY, mRadius, mCircle);
            mCenterX++;
            mCenterY++;
        }

//        // draw eyes
//        float eyeRadius = mRadius / 5f;
//        float eyeOffsetX = mRadius / 3f;
//        float eyeOffsetY = mRadius / 3f;
//        canvas.drawCircle(mCenterX - eyeOffsetX, mCenterY - eyeOffsetY, eyeRadius, mEyeAndMouth);
//        canvas.drawCircle(mCenterX + eyeOffsetX, mCenterY - eyeOffsetY, eyeRadius, mEyeAndMouth);
//        // draw mouth
//        float mouthInset = mRadius /3f;
//        mArcBounds.set(mouthInset, mouthInset, mRadius * 2 - mouthInset, mRadius * 2 - mouthInset);
//        canvas.drawArc(mArcBounds, 45f, 90f, false, mEyeAndMouth);
        Log.d(TAG, "onDraw");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

//        int size = Math.min(w, h);
        setMeasuredDimension(w, h);
        Log.d(TAG, "onMeasure");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "constructor");
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2f;
        mCenterY = h / 2f;
        mRadius = Math.min(w, h) / 2f;
        Log.d(TAG, "onSizeChanged");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout");
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        Log.d(TAG, "layout");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.d(TAG, "dispatchDraw");
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Log.d(TAG, "draw");
    }

    @Override
    public void invalidate() {
        super.invalidate();
        Log.d(TAG, "invalidate");
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        Log.d(TAG, "requestLayout");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        float x = event.getX();
//        float y = event.getY();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                System.out.println(x + ' ' + y);
//                Log.d(TAG, "down");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                System.out.println(x + ' ' + y);
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                Log.d(TAG, "x"+x);
//                System.out.println(x + ' ' + y);
//                break;
//        }
        return true;

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);

    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {

        super.setOnTouchListener(l);
    }
}
