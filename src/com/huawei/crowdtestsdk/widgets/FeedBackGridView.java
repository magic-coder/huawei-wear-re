package com.huawei.crowdtestsdk.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.huawei.crowdtestsdk.R;

public class FeedBackGridView extends GridView {
    public FeedBackGridView(Context context) {
        super(context);
    }

    public FeedBackGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedBackGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected void dispatchDraw(Canvas canvas) {
        int i = 0;
        super.dispatchDraw(canvas);
        int numColumns = getNumColumns();
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setColor(getContext().getResources().getColor(R.color.sdk_crowdtest_color_text_second_text));
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((i2 + 1) % numColumns == 0) {
                canvas.drawLine((float) childAt.getLeft(), (float) childAt.getBottom(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
            } else if (i2 + 1 > childCount - (childCount % numColumns)) {
                canvas.drawLine((float) childAt.getRight(), (float) childAt.getTop(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
            } else {
                canvas.drawLine((float) childAt.getRight(), (float) childAt.getTop(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
                canvas.drawLine((float) childAt.getLeft(), (float) childAt.getBottom(), (float) childAt.getRight(), (float) childAt.getBottom(), paint);
            }
        }
        if (childCount % numColumns != 0) {
            while (i < numColumns - (childCount % numColumns)) {
                View childAt2 = getChildAt(childCount - 1);
                canvas.drawLine((float) (childAt2.getRight() + (childAt2.getWidth() * i)), (float) childAt2.getTop(), (float) (childAt2.getRight() + (childAt2.getWidth() * i)), (float) childAt2.getBottom(), paint);
                i++;
            }
        }
    }
}
