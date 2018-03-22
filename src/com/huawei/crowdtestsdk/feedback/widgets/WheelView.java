package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.utils.DisplayUtils;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.List;

public class WheelView extends ScrollView {
    public static final int OFF_SET_DEFAULT = 2;
    public static final int SCROLL_DIRECTION_DOWN = 1;
    public static final int SCROLL_DIRECTION_UP = 0;
    public static final String TAG = "BETACLUB_SDK";
    private View contentView;
    private Context context;
    int displayItemCount;
    private int footItemCount = 0;
    Paint grayPaint;
    private int headItemCount = 0;
    int initialY;
    int itemHeight = 0;
    private List<String> items;
    int newCheck = 50;
    int offset = 2;
    private OnBorderListener onBorderListener;
    private OnWheelViewListener onWheelViewListener;
    Paint paint;
    private int scrollDirection = -1;
    Runnable scrollerTask;
    int[] selectedAreaBorder;
    int selectedIndex = 1;
    int viewWidth;
    private LinearLayout views;

    public class OnWheelViewListener {
        public void onSelected(int i, String str) {
        }
    }

    class C07281 extends Drawable {
        C07281() {
        }

        public void draw(Canvas canvas) {
            int i = 0;
            while (i < (WheelView.this.offset * 2) + 1) {
                if (i == WheelView.this.offset - 1 || i == WheelView.this.offset) {
                    canvas.drawLine(0.0f, (float) WheelView.this.obtainSelectedAreaBorder()[i], (float) WheelView.this.viewWidth, (float) WheelView.this.obtainSelectedAreaBorder()[i], WheelView.this.paint);
                } else {
                    canvas.drawLine(0.0f, (float) WheelView.this.obtainSelectedAreaBorder()[i], (float) WheelView.this.viewWidth, (float) WheelView.this.obtainSelectedAreaBorder()[i], WheelView.this.grayPaint);
                }
                i++;
            }
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public int getOpacity() {
            return 0;
        }
    }

    public interface OnBorderListener {
        void onBottom();

        void onTop();
    }

    class ScrollTask implements Runnable {
        private ScrollTask() {
        }

        public void run() {
            if (WheelView.this.initialY - WheelView.this.getScrollY() == 0) {
                final int i = WheelView.this.initialY % WheelView.this.itemHeight;
                final int i2 = WheelView.this.initialY / WheelView.this.itemHeight;
                if (i == 0) {
                    WheelView.this.selectedIndex = i2 + WheelView.this.offset;
                    WheelView.this.onSeletedCallBack();
                    return;
                } else if (i > WheelView.this.itemHeight / 2) {
                    WheelView.this.post(new Runnable() {
                        public void run() {
                            WheelView.this.smoothScrollTo(0, (WheelView.this.initialY - i) + WheelView.this.itemHeight);
                            WheelView.this.selectedIndex = (i2 + WheelView.this.offset) + 1;
                            WheelView.this.onSeletedCallBack();
                        }
                    });
                    return;
                } else {
                    WheelView.this.post(new Runnable() {
                        public void run() {
                            WheelView.this.smoothScrollTo(0, WheelView.this.initialY - i);
                            WheelView.this.selectedIndex = i2 + WheelView.this.offset;
                            WheelView.this.onSeletedCallBack();
                        }
                    });
                    return;
                }
            }
            WheelView.this.initialY = WheelView.this.getScrollY();
            WheelView.this.postDelayed(WheelView.this.scrollerTask, (long) WheelView.this.newCheck);
        }
    }

    public WheelView(Context context) {
        super(context);
        init(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private List<String> getItems() {
        return this.items;
    }

    public void setItems(List<String> list) {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        this.items.clear();
        this.items.addAll(list);
        for (int i = 0; i < this.offset; i++) {
            this.items.add(0, "");
            this.items.add("");
        }
        initData();
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    private void init(Context context) {
        this.context = context;
        setVerticalScrollBarEnabled(false);
        this.views = new LinearLayout(context);
        this.views.setLayoutParams(new LayoutParams(-1, -1));
        this.views.setOrientation(1);
        addView(this.views);
    }

    public void startScrollerTask() {
        if (this.scrollerTask == null) {
            this.scrollerTask = new ScrollTask();
        }
        this.initialY = getScrollY();
        postDelayed(this.scrollerTask, (long) this.newCheck);
    }

    private void initData() {
        this.displayItemCount = (this.offset * 2) + 1;
        for (String createView : this.items) {
            this.views.addView(createView(createView));
        }
        refreshItemView(0);
    }

    private TextView createView(String str) {
        View textView = new TextView(this.context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setGravity(17);
        int dip2px = DisplayUtils.dip2px(this.context, 8.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        if (this.itemHeight == 0) {
            this.itemHeight = DisplayUtils.getViewMeasuredHeight(textView);
            C2511g.m12481b("BETACLUB_SDK", "[createView.itemHeight]itemHeight: " + this.itemHeight);
            this.views.setLayoutParams(new FrameLayout.LayoutParams(-1, this.itemHeight * this.displayItemCount));
            setLayoutParams(new LayoutParams(((LayoutParams) getLayoutParams()).width, this.itemHeight * this.displayItemCount));
        }
        return textView;
    }

    public int getItemHeight() {
        return this.itemHeight;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        refreshItemView(i2);
        doOnBorderListener();
        if (i2 > i4) {
            this.scrollDirection = 1;
        } else if (i2 < i4) {
            this.scrollDirection = 0;
        }
    }

    public int getScrollDirection() {
        return this.scrollDirection;
    }

    public void setOnBorderListener(OnBorderListener onBorderListener) {
        this.onBorderListener = onBorderListener;
        if (onBorderListener != null && this.contentView == null) {
            this.contentView = getChildAt(0);
        }
    }

    public void setHeadItemCount(int i) {
        this.headItemCount = i;
    }

    public void setFootItemCount(int i) {
        this.footItemCount = i;
    }

    public void setScrollDirction(int i) {
        this.scrollDirection = i;
    }

    private void doOnBorderListener() {
        if (this.contentView == null || this.contentView.getMeasuredHeight() > (getScrollY() + getHeight()) + (getItemHeight() * (this.footItemCount - 2))) {
            if (getScrollY() <= getItemHeight() * this.headItemCount && this.onBorderListener != null) {
                this.onBorderListener.onTop();
            }
        } else if (this.onBorderListener != null) {
            this.onBorderListener.onBottom();
        }
    }

    private void refreshItemView(int i) {
        int i2 = (i / this.itemHeight) + this.offset;
        int i3 = i % this.itemHeight;
        int i4 = i / this.itemHeight;
        if (i3 == 0) {
            i3 = this.offset + i4;
        } else if (i3 > this.itemHeight / 2) {
            i3 = (this.offset + i4) + 1;
        } else {
            i3 = i2;
        }
        int childCount = this.views.getChildCount();
        i4 = 0;
        while (i4 < childCount) {
            TextView textView = (TextView) this.views.getChildAt(i4);
            if (textView != null) {
                if (i3 == i4) {
                    textView.setTextColor(Color.parseColor("#27AAE1"));
                } else {
                    textView.setTextColor(Color.parseColor("#8F8F8F"));
                }
                i4++;
            } else {
                return;
            }
        }
    }

    private int[] obtainSelectedAreaBorder() {
        if (this.selectedAreaBorder == null) {
            this.selectedAreaBorder = new int[((this.offset * 2) + 1)];
            for (int i = 0; i < (this.offset * 2) + 1; i++) {
                this.selectedAreaBorder[i] = this.itemHeight * (i + 1);
            }
        }
        return this.selectedAreaBorder;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.viewWidth == 0) {
            this.viewWidth = ((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth();
        }
        if (this.paint == null) {
            this.paint = new Paint();
            this.paint.setColor(Color.parseColor("#27AAE1"));
            this.paint.setStrokeWidth((float) DisplayUtils.dip2px(this.context, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        }
        if (this.grayPaint == null) {
            this.grayPaint = new Paint();
            this.grayPaint.setColor(Color.parseColor("#828282"));
            this.grayPaint.setStrokeWidth(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        super.setBackgroundDrawable(new C07281());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        setBackgroundDrawable(null);
    }

    private void onSeletedCallBack() {
        if (this.onWheelViewListener == null) {
            return;
        }
        if (this.selectedIndex <= this.items.size() - 1) {
            this.onWheelViewListener.onSelected(this.selectedIndex, (String) this.items.get(this.selectedIndex));
        } else {
            this.onWheelViewListener.onSelected(this.selectedIndex, "");
        }
    }

    public void setSeletion(final int i) {
        this.selectedIndex = this.offset + i;
        post(new Runnable() {
            public void run() {
                WheelView.this.smoothScrollTo(0, i * WheelView.this.itemHeight);
            }
        });
    }

    public String getSeletedItem() {
        return (String) this.items.get(this.selectedIndex);
    }

    public int getSeletedIndex() {
        return this.selectedIndex - this.offset;
    }

    public void fling(int i) {
        super.fling(i / 90);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    public OnWheelViewListener getOnWheelViewListener() {
        return this.onWheelViewListener;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.onWheelViewListener = onWheelViewListener;
    }
}
