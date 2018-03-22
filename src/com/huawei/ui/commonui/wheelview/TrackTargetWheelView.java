package com.huawei.ui.commonui.wheelview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.ui.commonui.C6001d;
import com.huawei.ui.commonui.C6034k;
import java.util.List;

public class TrackTargetWheelView extends ScrollView {
    public static final String f20852a = TrackTargetWheelView.class.getSimpleName();
    int f20853b = 1;
    List<String> f20854c;
    int f20855d = 1;
    int f20856e;
    Runnable f20857f;
    int f20858g = 50;
    int f20859h = 0;
    int f20860i = 8;
    float f20861j = 0.0f;
    int f20862k = 24;
    int[] f20863l;
    Paint f20864m;
    int f20865n;
    private final String f20866o = getResources().getString(C6034k.IDS_start_track_show_distance_half_marathon);
    private final String f20867p = getResources().getString(C6034k.IDS_start_track_show_distance_marathon);
    private Context f20868q;
    private LinearLayout f20869r;
    private int f20870s = -1;
    private C6068n f20871t;
    private List<String> f20872u = null;

    public TrackTargetWheelView(Context context) {
        super(context);
        m27661a(context);
    }

    public TrackTargetWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27661a(context);
    }

    public TrackTargetWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27661a(context);
    }

    private List<String> getItems() {
        return this.f20854c;
    }

    public void setOffset(int i) {
        this.f20853b = i;
    }

    private void m27661a(Context context) {
        this.f20868q = context;
        Log.d(f20852a, "init: " + getParent());
        setVerticalScrollBarEnabled(false);
        setFadingEdgeLength(0);
        this.f20869r = new LinearLayout(context);
        this.f20869r.setOrientation(1);
        addView(this.f20869r);
        this.f20857f = new C6063i(this);
    }

    public void m27667a() {
        this.f20856e = getScrollY();
        postDelayed(this.f20857f, (long) this.f20858g);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        Log.i(f20852a, "onScrollChanged");
        super.onScrollChanged(i, i2, i3, i4);
        m27660a(i2);
        if (i2 > i4) {
            this.f20870s = 1;
        } else {
            this.f20870s = 0;
        }
    }

    private void m27660a(int i) {
        int i2 = (i / this.f20859h) + this.f20853b;
        int i3 = i % this.f20859h;
        int i4 = i / this.f20859h;
        if (i3 == 0) {
            i3 = this.f20853b + i4;
        } else if (i3 > this.f20859h / 2) {
            i3 = (this.f20853b + i4) + 1;
        } else {
            i3 = i2;
        }
        int childCount = this.f20869r.getChildCount();
        i4 = 0;
        while (i4 < childCount) {
            LinearLayout linearLayout = (LinearLayout) this.f20869r.getChildAt(i4);
            if (linearLayout != null) {
                if (i3 == i4) {
                    m27662a(linearLayout.getChildAt(0), 2);
                } else {
                    if (i4 == i3 - 1) {
                        m27662a(linearLayout.getChildAt(0), 1);
                    }
                    if (i4 == i3 + 1) {
                        m27662a(linearLayout.getChildAt(0), 1);
                    }
                    if (i4 == i3 - 2) {
                        m27662a(linearLayout.getChildAt(0), 0);
                    }
                    if (i4 == i3 + 2) {
                        m27662a(linearLayout.getChildAt(0), 0);
                    }
                }
                i4++;
            } else {
                return;
            }
        }
    }

    private int[] m27664b() {
        if (this.f20863l == null) {
            this.f20863l = new int[2];
            this.f20863l[0] = this.f20859h * this.f20853b;
            this.f20863l[1] = (int) (((float) (this.f20859h * (this.f20853b + 1))) + (((float) this.f20860i) * this.f20861j));
        }
        return this.f20863l;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f20865n == 0) {
            this.f20865n = ((Activity) this.f20868q).getWindowManager().getDefaultDisplay().getWidth();
            Log.d(f20852a, "viewWidth: " + this.f20865n);
        }
        if (this.f20864m == null) {
            this.f20864m = new Paint();
            this.f20864m.setColor(Color.parseColor("#000000"));
            this.f20864m.setAlpha(25);
            this.f20864m.setStrokeWidth(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        super.setBackgroundDrawable(new C6066l(this));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        Log.i(f20852a, "onSizeChanged");
        super.onSizeChanged(i, i2, i3, i4);
        Log.d(f20852a, "w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4);
        this.f20865n = i;
        setBackgroundDrawable(null);
    }

    private void m27666c() {
        if (this.f20871t != null) {
            this.f20871t.m27740a(this.f20855d, (String) this.f20854c.get(this.f20855d));
        }
    }

    public void setSeletion(int i) {
        this.f20855d = i - this.f20853b;
        post(new C6067m(this));
    }

    public int getSeletedItem() {
        return Integer.parseInt((String) this.f20872u.get(this.f20855d));
    }

    public int getSeletedIndex() {
        return this.f20855d - this.f20853b;
    }

    public void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.i(f20852a, "onTouchEvent");
        if (motionEvent.getAction() == 1) {
            m27667a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public C6068n getOnWheelViewListener() {
        return this.f20871t;
    }

    public void setOnWheelViewListener(C6068n c6068n) {
        this.f20871t = c6068n;
    }

    private void m27662a(View view, int i) {
        TextView textView = (TextView) view;
        TextPaint paint = textView.getPaint();
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        switch (i) {
            case 0:
                textView.setTextSize(1, 15.0f);
                textView.setTextColor(getResources().getColor(C6001d.home_track_starget_value_color_twe_alpha));
                layoutParams.height = (int) (((float) this.f20862k) * this.f20861j);
                textView.setLayoutParams(layoutParams);
                paint.setFakeBoldText(false);
                return;
            case 1:
                textView.setTextSize(1, 15.0f);
                textView.setTextColor(getResources().getColor(C6001d.home_track_starget_value_color_fift_alpha));
                layoutParams.height = (int) (((float) this.f20862k) * this.f20861j);
                textView.setLayoutParams(layoutParams);
                paint.setFakeBoldText(false);
                return;
            case 2:
                textView.setTextSize(1, 18.0f);
                textView.setTextColor(getResources().getColor(C6001d.home_track_starget_value_color_whole_alpha));
                layoutParams.height = (int) (((float) (this.f20862k + this.f20860i)) * this.f20861j);
                textView.setLayoutParams(layoutParams);
                paint.setFakeBoldText(true);
                return;
            default:
                return;
        }
    }
}
