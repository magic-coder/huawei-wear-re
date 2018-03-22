package com.huawei.pluginaf500.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.view.WindowManager;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.p190v.C2538c;

/* compiled from: GlobuleSportView */
public class C5828b {
    private int f20027a;
    private int f20028b;
    private Handler f20029c;
    private Bitmap f20030d;
    private float f20031e = 0.0f;
    private boolean f20032f = false;
    private Canvas f20033g;
    private Paint f20034h;
    private Path f20035i;
    private boolean f20036j = false;

    public C5828b(Context context, int i, int i2, int i3, Handler handler) {
        this.f20027a = i;
        this.f20028b = i2;
        this.f20029c = handler;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        C2538c.b("GlobuleSportView", new Object[]{"w: " + width + ", h: " + windowManager.getDefaultDisplay().getHeight()});
        int i4 /= 100;
        this.f20030d = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        this.f20033g = new Canvas(this.f20030d);
        this.f20034h = new Paint();
        this.f20034h.setAntiAlias(true);
        this.f20034h.setColor(Color.parseColor("#3fc0c5"));
        this.f20034h.setStrokeWidth(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f20035i = new Path();
        this.f20035i.addCircle(((float) i) / 2.0f, (float) i4, (float) i4, Direction.CW);
    }

    public Bitmap m26929a() {
        return this.f20030d;
    }

    public void m26931b() {
        this.f20033g.drawColor(0, Mode.CLEAR);
        this.f20033g.save();
        this.f20033g.rotate(this.f20031e, ((float) this.f20027a) / 2.0f, ((float) this.f20028b) / 2.0f);
        this.f20033g.drawPath(this.f20035i, this.f20034h);
        this.f20033g.restore();
    }

    public void m26930a(boolean z) {
        this.f20032f = z;
    }

    public void m26932c() {
        if (!this.f20036j) {
            new Thread(new C5829c(this)).start();
        }
    }
}
