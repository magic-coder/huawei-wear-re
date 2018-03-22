package com.amap.api.mapcore;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amap.api.mapcore.util.bi;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndoorFloorSwitchView */
public class aq extends ScrollView {
    public static final String f10897a = aq.class.getSimpleName();
    int f10898b = 1;
    private Context f10899c;
    private LinearLayout f10900d;
    private int f10901e = 0;
    private List<String> f10902f;
    private int f10903g = -1;
    private int f10904h;
    private Bitmap f10905i = null;
    private int f10906j = Color.parseColor("#eeffffff");
    private int f10907k = Color.parseColor("#44383838");
    private int f10908l = 4;
    private int f10909m = 1;
    private int f10910n;
    private int f10911o;
    private Runnable f10912p;
    private int f10913q = 50;
    private C3221a f10914r;

    /* compiled from: IndoorFloorSwitchView */
    public interface C3221a {
        void mo3733a(int i);
    }

    /* compiled from: IndoorFloorSwitchView */
    class C32321 implements Runnable {
        final /* synthetic */ aq f10893a;

        C32321(aq aqVar) {
            this.f10893a = aqVar;
        }

        public void run() {
            if (this.f10893a.f10911o - this.f10893a.getScrollY() == 0) {
                final int a = this.f10893a.f10911o % this.f10893a.f10901e;
                final int a2 = this.f10893a.f10911o / this.f10893a.f10901e;
                if (a == 0) {
                    this.f10893a.f10898b = a2 + this.f10893a.f10909m;
                    this.f10893a.m14814f();
                    return;
                } else if (a > this.f10893a.f10901e / 2) {
                    this.f10893a.post(new Runnable(this) {
                        final /* synthetic */ C32321 f10889c;

                        public void run() {
                            this.f10889c.f10893a.smoothScrollTo(0, (this.f10889c.f10893a.f10911o - a) + this.f10889c.f10893a.f10901e);
                            this.f10889c.f10893a.f10898b = (a2 + this.f10889c.f10893a.f10909m) + 1;
                            this.f10889c.f10893a.m14814f();
                        }
                    });
                    return;
                } else {
                    this.f10893a.post(new Runnable(this) {
                        final /* synthetic */ C32321 f10892c;

                        public void run() {
                            this.f10892c.f10893a.smoothScrollTo(0, this.f10892c.f10893a.f10911o - a);
                            this.f10892c.f10893a.f10898b = a2 + this.f10892c.f10893a.f10909m;
                            this.f10892c.f10893a.m14814f();
                        }
                    });
                    return;
                }
            }
            this.f10893a.f10911o = this.f10893a.getScrollY();
            this.f10893a.postDelayed(this.f10893a.f10912p, (long) this.f10893a.f10913q);
        }
    }

    /* compiled from: IndoorFloorSwitchView */
    class C32332 extends Drawable {
        final /* synthetic */ aq f10894a;

        C32332(aq aqVar) {
            this.f10894a = aqVar;
        }

        public void draw(Canvas canvas) {
            try {
                m14796a(canvas);
                m14797b(canvas);
                m14798c(canvas);
            } catch (Throwable th) {
            }
        }

        private void m14796a(Canvas canvas) {
            canvas.drawColor(this.f10894a.f10906j);
        }

        private void m14797b(Canvas canvas) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = this.f10894a.f10905i.getWidth() + 0;
            rect.bottom = this.f10894a.f10905i.getHeight() + 0;
            rect2.left = 0;
            rect2.top = this.f10894a.m14812e()[0];
            rect2.right = this.f10894a.f10904h + 0;
            rect2.bottom = this.f10894a.m14812e()[1];
            canvas.drawBitmap(this.f10894a.f10905i, rect, rect2, paint);
        }

        private void m14798c(Canvas canvas) {
            Paint paint = new Paint();
            Rect clipBounds = canvas.getClipBounds();
            paint.setColor(this.f10894a.f10907k);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) this.f10894a.f10908l);
            canvas.drawRect(clipBounds, paint);
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public int getOpacity() {
            return 0;
        }
    }

    public aq(Context context) {
        super(context);
        m14804a(context);
    }

    public aq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14804a(context);
    }

    public aq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14804a(context);
    }

    private void m14804a(Context context) {
        this.f10899c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f10905i == null) {
                InputStream open = bi.m15630a(context).open("map_indoor_select.png");
                this.f10905i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable th) {
        }
        this.f10900d = new LinearLayout(context);
        this.f10900d.setOrientation(1);
        addView(this.f10900d);
        this.f10912p = new C32321(this);
    }

    public void m14821a() {
        this.f10911o = getScrollY();
        postDelayed(this.f10912p, (long) this.f10913q);
    }

    private void m14809d() {
        if (this.f10902f != null && this.f10902f.size() != 0) {
            this.f10900d.removeAllViews();
            this.f10910n = (this.f10909m * 2) + 1;
            for (int size = this.f10902f.size() - 1; size >= 0; size--) {
                this.f10900d.addView(m14806b((String) this.f10902f.get(size)));
            }
            m14803a(0);
        }
    }

    private TextView m14806b(String str) {
        View textView = new TextView(this.f10899c);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a = m14799a(this.f10899c, 8.0f);
        int a2 = m14799a(this.f10899c, 6.0f);
        textView.setPadding(a, a2, a, a2);
        if (this.f10901e == 0) {
            this.f10901e = m14800a(textView);
            this.f10900d.setLayoutParams(new LayoutParams(-2, this.f10901e * this.f10910n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f10901e * this.f10910n));
        }
        return textView;
    }

    private void m14803a(int i) {
        int i2 = (i / this.f10901e) + this.f10909m;
        int i3 = i % this.f10901e;
        int i4 = i / this.f10901e;
        if (i3 == 0) {
            i3 = this.f10909m + i4;
        } else if (i3 > this.f10901e / 2) {
            i3 = (this.f10909m + i4) + 1;
        } else {
            i3 = i2;
        }
        int childCount = this.f10900d.getChildCount();
        i4 = 0;
        while (i4 < childCount) {
            TextView textView = (TextView) this.f10900d.getChildAt(i4);
            if (textView != null) {
                if (i3 == i4) {
                    textView.setTextColor(Color.parseColor("#0288ce"));
                } else {
                    textView.setTextColor(Color.parseColor("#bbbbbb"));
                }
                i4++;
            } else {
                return;
            }
        }
    }

    public void m14824a(String[] strArr) {
        int i;
        if (this.f10902f == null) {
            this.f10902f = new ArrayList();
        }
        this.f10902f.clear();
        for (Object add : strArr) {
            this.f10902f.add(add);
        }
        for (i = 0; i < this.f10909m; i++) {
            this.f10902f.add(0, "");
            this.f10902f.add("");
        }
        m14809d();
    }

    public void setBackgroundColor(int i) {
        this.f10906j = i;
    }

    public void m14825b() {
        if (this.f10905i != null && !this.f10905i.isRecycled()) {
            this.f10905i.recycle();
            this.f10905i = null;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f10904h == 0) {
            this.f10904h = ((Activity) this.f10899c).getWindowManager().getDefaultDisplay().getWidth();
        }
        super.setBackgroundDrawable(new C32332(this));
    }

    private int[] m14812e() {
        if (null != null) {
            return null;
        }
        return new int[]{this.f10901e * this.f10909m, this.f10901e * (this.f10909m + 1)};
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10904h = i;
        setBackgroundDrawable(null);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m14803a(i2);
        if (i2 > i4) {
            this.f10903g = 1;
        } else {
            this.f10903g = 0;
        }
    }

    private void m14814f() {
        if (this.f10914r != null) {
            try {
                this.f10914r.mo3733a(m14826c());
            } catch (Throwable th) {
            }
        }
    }

    public void m14823a(String str) {
        if (this.f10902f != null && this.f10902f.size() != 0) {
            final int size = ((this.f10902f.size() - this.f10909m) - 1) - this.f10902f.indexOf(str);
            this.f10898b = this.f10909m + size;
            post(new Runnable(this) {
                final /* synthetic */ aq f10896b;

                public void run() {
                    this.f10896b.smoothScrollTo(0, size * this.f10896b.f10901e);
                }
            });
        }
    }

    public int m14826c() {
        if (this.f10902f == null || this.f10902f.size() == 0) {
            return 0;
        }
        return Math.min(this.f10902f.size() - (this.f10909m * 2), Math.max(0, ((this.f10902f.size() - 1) - this.f10898b) - this.f10909m));
    }

    public void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m14821a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void m14822a(C3221a c3221a) {
        this.f10914r = c3221a;
    }

    public static int m14799a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int m14800a(View view) {
        m14807b(view);
        return view.getMeasuredHeight();
    }

    public static void m14807b(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
