package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.g;

public class DragListViewMenu extends ListView {
    private ImageView f6193a;
    private int f6194b;
    private int f6195c;
    private int f6196d;
    private int f6197e;
    private int f6198f;
    private int f6199g;
    private WindowManager f6200h;
    private LayoutParams f6201i;
    private int f6202j;
    private int f6203k;
    private int f6204l;
    private C1865h f6205m = null;
    private Context f6206n;

    public DragListViewMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6206n = context;
        this.f6202j = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || this.f6205m == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int pointToPosition = pointToPosition(x, y);
        this.f6195c = pointToPosition;
        this.f6194b = pointToPosition;
        if (this.f6195c == -1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        ViewGroup viewGroup = (ViewGroup) getChildAt(this.f6195c - getFirstVisiblePosition());
        this.f6196d = x - viewGroup.getLeft();
        this.f6197e = y - viewGroup.getTop();
        this.f6198f = (int) (motionEvent.getRawX() - ((float) x));
        this.f6199g = (int) (motionEvent.getRawY() - ((float) y));
        View findViewById = viewGroup.findViewById(g.menu_iv_arrow);
        if (findViewById != null && x > findViewById.getLeft() - 20) {
            this.f6203k = Math.min(y - this.f6202j, getHeight() / 3);
            this.f6204l = Math.max(this.f6202j + y, (getHeight() * 2) / 3);
            viewGroup.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
            Bitmap decodeResource = BitmapFactory.decodeResource(this.f6206n.getResources(), C1617f.shadow3);
            Bitmap b = m9644b(decodeResource, 5000, 8);
            if (b != null) {
                Bitmap a = m9639a(createBitmap, b);
                if (a != null) {
                    m9643a(a, x, y);
                    decodeResource.recycle();
                    b.recycle();
                } else {
                    m9643a(createBitmap, x, y);
                }
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6193a == null || this.f6195c == -1 || this.f6205m == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 1:
                int y = (int) motionEvent.getY();
                m9640a();
                m9641a(y);
                break;
            case 2:
                m9642a((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return true;
    }

    public void m9643a(Bitmap bitmap, int i, int i2) {
        m9640a();
        this.f6201i = new LayoutParams();
        this.f6201i.gravity = 48;
        this.f6201i.x = (i - this.f6196d) + this.f6198f;
        this.f6201i.y = (i2 - this.f6197e) + this.f6199g;
        this.f6201i.width = -2;
        this.f6201i.height = -2;
        this.f6201i.flags = 408;
        this.f6201i.format = -3;
        this.f6201i.windowAnimations = 0;
        View imageView = new ImageView(getContext());
        imageView.setImageBitmap(bitmap);
        this.f6200h = (WindowManager) getContext().getSystemService("window");
        this.f6200h.addView(imageView, this.f6201i);
        this.f6193a = imageView;
    }

    public void m9640a() {
        if (this.f6193a != null) {
            this.f6200h.removeView(this.f6193a);
            this.f6193a = null;
        }
    }

    public void m9642a(int i, int i2) {
        int i3 = 0;
        if (this.f6193a != null) {
            this.f6201i.alpha = 0.8f;
            this.f6201i.x = (i - this.f6196d) + this.f6198f;
            this.f6201i.y = (i2 - this.f6197e) + this.f6199g;
            this.f6200h.updateViewLayout(this.f6193a, this.f6201i);
        }
        int pointToPosition = pointToPosition(0, i2);
        if (pointToPosition != -1) {
            this.f6195c = pointToPosition;
        }
        if (i2 < this.f6203k) {
            i3 = 8;
        } else if (i2 > this.f6204l) {
            i3 = -8;
        }
        if (i3 != 0) {
            setSelectionFromTop(this.f6195c, i3 + getChildAt(this.f6195c - getFirstVisiblePosition()).getTop());
        }
    }

    public void m9641a(int i) {
        int pointToPosition = pointToPosition(0, i);
        if (pointToPosition != -1) {
            this.f6195c = pointToPosition;
        }
        if (i < getChildAt(0).getTop()) {
            this.f6195c = 0;
        } else if (i > getChildAt(getChildCount() - 1).getBottom()) {
            this.f6195c = getAdapter().getCount() - 1;
        }
        if (this.f6195c >= 0 && this.f6195c < getAdapter().getCount() && this.f6205m != null) {
            this.f6205m.mo2623a(this.f6194b, this.f6195c);
        }
    }

    public void setExchangeDataListener(C1865h c1865h) {
        this.f6205m = c1865h;
    }

    public Bitmap m9644b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private Bitmap m9639a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), Math.max(bitmap.getHeight(), 8) + bitmap2.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        canvas.drawBitmap(bitmap2, (float) bitmap.getWidth(), 0.0f, null);
        canvas.drawBitmap(bitmap2, 0.0f, (float) bitmap.getHeight(), null);
        return createBitmap;
    }
}
