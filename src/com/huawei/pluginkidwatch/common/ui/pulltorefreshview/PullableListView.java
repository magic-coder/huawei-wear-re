package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.huawei.p190v.C2538c;

public class PullableListView extends ListView implements C1530h {
    public PullableListView(Context context) {
        super(context);
    }

    public PullableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean mo2527a() {
        if (getCount() == 0) {
            return true;
        }
        if (getFirstVisiblePosition() != 0 || getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getTop() < 0) {
            return false;
        }
        C2538c.m12674b("PullableListView...", "v = " + childAt);
        return true;
    }

    public boolean mo2528b() {
        if (getCount() == 0) {
            return true;
        }
        if (getLastVisiblePosition() != getCount() - 1 || getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) == null || getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getBottom() > getMeasuredHeight()) {
            return false;
        }
        return true;
    }
}
