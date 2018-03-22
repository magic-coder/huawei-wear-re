package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class FolderListAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public abstract void convert(ViewHolder viewHolder, T t);

    public FolderListAdapter(Context context, List<T> list, int i) {
        this.mContext = context;
        this.mDatas = list;
        this.mItemLayoutId = i;
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public T getItem(int i) {
        return this.mDatas.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = getViewHolder(i, view, viewGroup);
        convert(viewHolder, getItem(i));
        return viewHolder.getConvertView();
    }

    private ViewHolder getViewHolder(int i, View view, ViewGroup viewGroup) {
        return ViewHolder.get(this.mContext, view, viewGroup, this.mItemLayoutId, i);
    }
}
