package com.huawei.pay.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.ag.e;
import com.huawei.ag.f;
import com.huawei.ag.g;
import com.huawei.pay.ui.util.ToastManager;

public class PullExpandableListView extends ExpandableListView implements OnScrollListener, OnChildClickListener, OnGroupClickListener {
    private View bottom;
    private OnListener callBack;
    private ProgressBar pg_bottom;
    private TextView tv_LoadMore;

    public interface OnListener {
        void onChildItemClick(int i, int i2);

        void onPositionChanaged(int i);

        void pullToLoadMore();
    }

    public PullExpandableListView(Context context) {
        super(context);
        init(context);
    }

    public PullExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PullExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.bottom = LayoutInflater.from(context).inflate(f.mybill_list_footer, null);
        this.tv_LoadMore = (TextView) this.bottom.findViewById(e.listview_foot_more);
        this.pg_bottom = (ProgressBar) this.bottom.findViewById(e.listview_foot_progress);
        hideBottomText();
        hideBottomProgress();
        addFooterView(this.bottom, null, false);
        setOnGroupClickListener(this);
        setOnChildClickListener(this);
        setOnScrollListener(this);
    }

    public void setListener(OnListener onListener) {
        this.callBack = onListener;
    }

    public void showBottom() {
        this.bottom.setVisibility(0);
    }

    public void hideBottom() {
        this.bottom.setVisibility(8);
    }

    public void setBottomText(int i) {
        this.tv_LoadMore.setText(i);
    }

    public void showBottomText() {
        this.tv_LoadMore.setVisibility(0);
    }

    public void showNetErrorTips() {
        ToastManager.show(getContext(), g.huaweipay_network_error, 0);
    }

    public void showloadMoreErrorTips() {
        ToastManager.show(getContext(), g.hwpay_loadmore_error, 0);
    }

    public void hideBottomText() {
        this.tv_LoadMore.setVisibility(8);
    }

    public void showBottomProgress() {
        showBottomText();
        this.pg_bottom.setVisibility(0);
    }

    public void hideBottomProgress() {
        this.pg_bottom.setVisibility(8);
    }

    public void expandAllGroup() {
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        if (expandableListAdapter != null) {
            int groupCount = expandableListAdapter.getGroupCount();
            for (int i = 0; i < groupCount; i++) {
                expandGroup(i);
            }
        }
    }

    public int getChildCounts() {
        int i = 0;
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        if (expandableListAdapter != null) {
            int i2 = 0;
            while (i2 < expandableListAdapter.getGroupCount()) {
                int childrenCount = expandableListAdapter.getChildrenCount(i2) + i;
                i2++;
                i = childrenCount;
            }
        }
        return i;
    }

    public void reStorePosAfterRestart(int i) {
        if (getChildCounts() > 0 && i <= getChildCounts() && i >= 0) {
            setSelection(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.callBack != null) {
            if (getCount() - 1 == getLastVisiblePosition() && getChildCounts() > 0) {
                this.callBack.pullToLoadMore();
            }
            this.callBack.onPositionChanaged(getFirstVisiblePosition());
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (this.callBack != null) {
            this.callBack.onChildItemClick(i, i2);
        }
        return false;
    }
}
