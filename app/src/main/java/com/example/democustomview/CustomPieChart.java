package com.example.democustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;


public class CustomPieChart extends View {

    private Paint mCircle;
    private float mCenterX;
    private float mCenterY;
    private float mRadius;
    private RectF mArcBounds = new RectF();

    private boolean mShowText;
    private int mNumberOfDots;
    private String TAG = "hieuvh";

    public boolean ismShowText() {
        return mShowText;
    }

    public void setmShowText(boolean mShowText) {
        this.mShowText = mShowText;
        invalidate();
        requestLayout();
    }

    public int getmNumberOfDots() {
        return mNumberOfDots;
    }

    public void setmNumberOfDots(int mNumberOfDots) {
        this.mNumberOfDots = mNumberOfDots;
        invalidate();
        requestLayout();
    }

    public CustomPieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomPieChart,
                0, 0);
        try {
            mShowText = typedArray.getBoolean(R.styleable.CustomPieChart_isShowText, true);
            mNumberOfDots = typedArray.getInt(R.styleable.CustomPieChart_numberOfDots, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d(TAG, "CustomPieChart: ");
        } finally {
            typedArray.recycle();
        }
        initPaints();
    }

    private void initPaints() {
        mCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircle.setStyle(Paint.Style.FILL);
        mCircle.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int size = Math.min(width, height);
        setMeasuredDimension(size, size);
    }
}
