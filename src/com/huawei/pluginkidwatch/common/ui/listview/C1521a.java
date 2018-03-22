package com.huawei.pluginkidwatch.common.ui.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: DragListViewAdapter */
public abstract class C1521a extends BaseAdapter {
    public abstract int mo2611a();

    public abstract View mo2612a(int i, View view, ViewGroup viewGroup);

    public abstract Object mo2613a(int i);

    public abstract long mo2614b(int i);

    public int getCount() {
        return mo2611a();
    }

    public Object getItem(int i) {
        return mo2613a(i);
    }

    public long getItemId(int i) {
        return mo2614b(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return mo2612a(i, view, viewGroup);
    }
}
