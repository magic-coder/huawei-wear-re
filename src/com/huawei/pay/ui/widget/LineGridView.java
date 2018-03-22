package com.huawei.pay.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.ag.c;

public class LineGridView extends GridView {
    public LineGridView(Context context) {
        super(context);
    }

    public LineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void dispatchDraw(Canvas canvas) {
        int i = 0;
        super.dispatchDraw(canvas);
        int width = getWidth() / getChildAt(0).getWidth();
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        paint.setColor(getContext().getResources().getColor(c.line_bottom_color));
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((i2 + 1) % width == 0) {
                canvas.drawLine((float) childAt.getLeft(), (float) childAt.getBottom(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
            } else if (i2 + 1 > childCount - (childCount % width)) {
                canvas.drawLine((float) childAt.getRight(), (float) childAt.getTop(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
            } else {
                canvas.drawLine((float) childAt.getRight(), (float) childAt.getTop(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
                canvas.drawLine((float) childAt.getLeft(), (float) childAt.getBottom(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
            }
        }
        if (childCount % width != 0) {
            while (i < width - (childCount % width)) {
                View childAt2 = getChildAt(childCount - 1);
                canvas.drawLine((float) (childAt2.getRight() + (childAt2.getWidth() * i)), (float) childAt2.getTop(), (float) (childAt2.getRight() + (childAt2.getWidth() * i)), (float) childAt2.getBottom(), paint);
                i++;
            }
        }
    }
}
