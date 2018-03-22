package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.crowdtestsdk.feedback.widgets.photoSelector.ImageLoader.Type;

public class ViewHolder {
    private View mConvertView;
    private int mPosition;
    private final SparseArray<View> mViews = new SparseArray();

    private ViewHolder(Context context, ViewGroup viewGroup, int i, int i2) {
        this.mPosition = i2;
        this.mConvertView = LayoutInflater.from(context).inflate(i, viewGroup, false);
        this.mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View view, ViewGroup viewGroup, int i, int i2) {
        if (view == null) {
            return new ViewHolder(context, viewGroup, i, i2);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.mPosition = i2;
        return viewHolder;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public <T extends View> T getView(int i) {
        View view = (View) this.mViews.get(i);
        if (view != null) {
            return view;
        }
        T findViewById = this.mConvertView.findViewById(i);
        this.mViews.put(i, findViewById);
        return findViewById;
    }

    public ViewHolder setText(int i, String str) {
        ((TextView) getView(i)).setText(str);
        return this;
    }

    public ViewHolder setImageResource(int i, int i2) {
        ((ImageView) getView(i)).setImageResource(i2);
        return this;
    }

    public ViewHolder setImageBitmap(int i, Bitmap bitmap) {
        ((ImageView) getView(i)).setImageBitmap(bitmap);
        return this;
    }

    public ViewHolder setImageByUrl(int i, String str) {
        ImageLoader.getInstance(3, Type.LIFO).loadImage(str, (ImageView) getView(i));
        return this;
    }

    public ViewHolder setImageIcon(int i, int i2) {
        ((ImageView) getView(i)).setImageResource(i2);
        return this;
    }

    public int getPosition() {
        return this.mPosition;
    }
}
