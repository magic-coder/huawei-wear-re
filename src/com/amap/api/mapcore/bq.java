package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.amap.api.mapcore.C3264r.C3263a;
import com.amap.api.mapcore.util.bi;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import java.io.InputStream;

/* compiled from: WaterMarkerView */
class bq extends View {
    int f11194a = 10;
    private Bitmap f11195b;
    private Bitmap f11196c;
    private Bitmap f11197d;
    private Bitmap f11198e;
    private Paint f11199f = new Paint();
    private boolean f11200g = false;
    private int f11201h = 0;
    private AMapDelegateImp f11202i;
    private int f11203j = 0;

    public void m15251a() {
        try {
            if (this.f11195b != null) {
                this.f11195b.recycle();
            }
            if (this.f11196c != null) {
                this.f11196c.recycle();
            }
            this.f11195b = null;
            this.f11196c = null;
            if (this.f11197d != null) {
                this.f11197d.recycle();
                this.f11197d = null;
            }
            if (this.f11198e != null) {
                this.f11198e.recycle();
                this.f11198e = null;
            }
            this.f11199f = null;
        } catch (Throwable th) {
            ca.m15831a(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public bq(Context context) {
        super(context);
    }

    public bq(Context context, AMapDelegateImp aMapDelegateImp) {
        super(context);
        this.f11202i = aMapDelegateImp;
        try {
            InputStream open;
            if (C3264r.f11369e == C3263a.ALIBABA) {
                open = bi.m15630a(context).open("apl.data");
            } else {
                open = bi.m15630a(context).open("ap.data");
            }
            this.f11197d = BitmapFactory.decodeStream(open);
            this.f11195b = bk.m15649a(this.f11197d, C3264r.f11365a);
            open.close();
            if (C3264r.f11369e == C3263a.ALIBABA) {
                open = bi.m15630a(context).open("apl1.data");
            } else {
                open = bi.m15630a(context).open("ap1.data");
            }
            this.f11198e = BitmapFactory.decodeStream(open);
            this.f11196c = bk.m15649a(this.f11198e, C3264r.f11365a);
            open.close();
            this.f11201h = this.f11196c.getHeight();
        } catch (Throwable th) {
            ca.m15831a(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
        this.f11199f.setAntiAlias(true);
        this.f11199f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f11199f.setStyle(Style.STROKE);
    }

    public Bitmap m15254b() {
        if (this.f11200g) {
            return this.f11196c;
        }
        return this.f11195b;
    }

    public void m15253a(boolean z) {
        this.f11200g = z;
        if (z) {
            this.f11199f.setColor(-1);
        } else {
            this.f11199f.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        invalidate();
    }

    public Point m15255c() {
        return new Point(this.f11194a, (getHeight() - this.f11201h) - 10);
    }

    public void m15252a(int i) {
        this.f11203j = i;
    }

    public void onDraw(Canvas canvas) {
        try {
            if (this.f11196c != null) {
                int width = this.f11196c.getWidth();
                if (this.f11203j == 1) {
                    this.f11194a = (this.f11202i.m14625m() - width) / 2;
                } else if (this.f11203j == 2) {
                    this.f11194a = (this.f11202i.m14625m() - width) - 10;
                } else {
                    this.f11194a = 10;
                }
                if (C3264r.f11369e == C3263a.ALIBABA) {
                    canvas.drawBitmap(m15254b(), (float) (this.f11194a + 15), (float) ((getHeight() - this.f11201h) - 8), this.f11199f);
                } else {
                    canvas.drawBitmap(m15254b(), (float) this.f11194a, (float) ((getHeight() - this.f11201h) - 8), this.f11199f);
                }
            }
        } catch (Throwable th) {
            ca.m15831a(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
