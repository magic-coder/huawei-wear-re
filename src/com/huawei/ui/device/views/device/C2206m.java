package com.huawei.ui.device.views.device;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.huawei.ui.device.b;
import com.huawei.ui.device.c;

/* compiled from: SimpleDividerRecyclerDecoration */
public class C2206m extends ItemDecoration {
    private int f7908a;
    private Paint f7909b = new Paint();

    public C2206m(Context context) {
        this.f7909b.setColor(context.getResources().getColor(b.user_profile_mycal_total_cal_color));
        this.f7908a = context.getResources().getDimensionPixelSize(c.device_list_item_decoration);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) == ((LinearLayoutManager) recyclerView.getLayoutManager()).getItemCount() - 1) {
            rect.bottom = this.f7908a;
        } else {
            rect.bottom = 0;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i = 0; i < childCount; i++) {
            float bottom;
            View childAt = recyclerView.getChildAt(i);
            float bottom2 = (float) childAt.getBottom();
            if (i == childCount - 1) {
                bottom = (float) (childAt.getBottom() + this.f7908a);
            } else {
                bottom = (float) childAt.getBottom();
            }
            canvas.drawRect((float) paddingLeft, bottom2, (float) width, bottom, this.f7909b);
        }
    }
}
