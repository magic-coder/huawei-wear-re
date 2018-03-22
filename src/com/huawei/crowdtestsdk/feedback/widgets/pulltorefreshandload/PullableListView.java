package com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class PullableListView extends ListView implements Pullable {
    private Mode mode = Mode.BOTH;

    public PullableListView(Context context) {
        super(context);
    }

    public PullableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean canPullDown() {
        if (this.mode == Mode.DISABLED || this.mode == Mode.LOAD_ONLY) {
            return false;
        }
        if (getCount() == 0) {
            return true;
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getTop() >= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canPullUp() {
        if (this.mode == Mode.DISABLED || this.mode == Mode.REFRESH_ONLY) {
            return false;
        }
        if (getCount() == 0) {
            return true;
        }
        if (getLastVisiblePosition() != getCount() - 1 || getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) == null || getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getBottom() > getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void onFilterComplete(int i) {
    }

    public void onGlobalLayout() {
    }

    public void onTouchModeChanged(boolean z) {
    }

    public boolean onRemoteAdapterConnected() {
        return false;
    }

    public void onRemoteAdapterDisconnected() {
    }

    public void deferNotifyDataSetChanged() {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
