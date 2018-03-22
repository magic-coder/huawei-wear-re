package com.huawei.openalliance.ad.p112a.p124i.p126a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import java.lang.Thread.State;

public final class C1297d extends ImageView implements C1296h {
    private C1300g f2746a = null;
    private Bitmap f2747b = null;
    private C1293a f2748c = null;
    private int f2749d = 0;
    private C1299f f2750e = null;
    private boolean f2751f = false;
    private long f2752g = -1;
    private int f2753h = 10;

    public C1297d(Context context, int i, C1299f c1299f) {
        super(context);
        setScaleType(ScaleType.CENTER_CROP);
        this.f2748c = new C1293a(this);
        this.f2750e = c1299f;
        this.f2746a = new C1300g(this, C1289h.m5695a(context).m5727m());
        this.f2746a.m5786a(getResources(), i);
        this.f2746a.start();
    }

    public C1297d(Context context, String str, C1299f c1299f) {
        super(context);
        setScaleType(ScaleType.CENTER_CROP);
        this.f2748c = new C1293a(this);
        this.f2750e = c1299f;
        this.f2746a = new C1300g(this, C1289h.m5695a(context).m5727m());
        this.f2746a.m5787a(str);
        this.f2746a.start();
    }

    private void m5750f() {
        if (this.f2746a != null && State.TERMINATED != this.f2746a.getState()) {
            try {
                this.f2746a.destroy();
                this.f2746a.interrupt();
                this.f2746a = null;
            } catch (Exception e) {
                C1336d.m5888c("GifImage", "destory parser fail");
            }
        }
    }

    private void m5751g() {
        if (this.f2748c != null) {
            this.f2748c.m5743d();
            this.f2748c = null;
        }
    }

    private boolean m5752h() {
        return (getVisibility() == 8 || getVisibility() == 4) ? false : true;
    }

    private int m5753i() {
        if (this.f2746a != null) {
            C1295c b = this.f2746a.m5789b();
            if (this.f2747b != null) {
                this.f2747b.recycle();
                this.f2747b = null;
            }
            if (b == null) {
                return -1;
            }
            if (b.f2744a != null) {
                this.f2747b = b.f2744a;
            }
            C1336d.m5884a("GifImage", "getCurFrame:", String.valueOf(this.f2749d + 1));
            C1336d.m5884a("GifImage", "getCurFrame show time:", String.valueOf(b.f2745b));
            return b.f2745b;
        }
        mo2445d();
        return -1;
    }

    private void m5754j() {
        if (this.f2747b != null && !this.f2747b.isRecycled() && this.f2748c != null && !this.f2748c.m5740a()) {
            setImageBitmap(this.f2747b);
            this.f2749d++;
            if (this.f2750e != null) {
                this.f2750e.mo2449a(this.f2749d);
            }
            if (1 == this.f2749d) {
                this.f2751f = true;
                this.f2752g = System.currentTimeMillis();
            }
        }
    }

    public void m5755a() {
        C1336d.m5886b("GifImage", "startAnim");
        if (this.f2748c != null) {
            m5757b();
            this.f2748c.m5742c();
        }
    }

    @SuppressWarnings(justification = "h00193325/对于FINISH和CACHE_FINISH状态，使用同样的处理方式，所以在FINISH状态后没有添加break", value = {"SF_SWITCH_FALLTHROUGH"})
    public void mo2444a(int i) {
        switch (i) {
            case 2:
            case 3:
                String str = "GifImage";
                String[] strArr = new String[1];
                strArr[0] = "notifyResult:" + (2 == i ? "CACHE_FINISH" : "FINISH");
                C1336d.m5886b(str, strArr);
                post(new C1298e(this));
                return;
            case 4:
                C1336d.m5888c("GifImage", "notifyResult:ERROR");
                mo2445d();
                return;
            default:
                return;
        }
    }

    public void m5757b() {
        C1336d.m5886b("GifImage", "stopAnim");
        if (this.f2748c != null) {
            this.f2748c.m5741b();
        }
    }

    public void m5758c() {
        m5751g();
        m5750f();
    }

    public void mo2445d() {
        m5751g();
        m5750f();
        if (this.f2750e != null) {
            this.f2750e.mo2450b();
        }
    }

    public int mo2446e() {
        if (this.f2751f) {
            int i;
            i = this.f2753h;
            this.f2753h = i - 1;
            if (i > 0) {
                return 30;
            }
        }
        if (1 != this.f2749d || this.f2752g <= 30 || this.f2752g >= 300) {
            i = m5753i();
            m5754j();
            return i;
        }
        i = (int) this.f2752g;
        this.f2752g = -1;
        return i;
    }

    protected void onDetachedFromWindow() {
        C1336d.m5886b("GifImage", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        m5758c();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2751f) {
            this.f2752g = System.currentTimeMillis() - this.f2752g;
        }
        this.f2751f = false;
        C1336d.m5886b("GifImage", "onDraw");
    }

    public void onWindowVisibilityChanged(int i) {
        C1336d.m5886b("GifImage", "onWindowVisibilityChanged");
        if (8 == i || 4 == i) {
            m5757b();
        } else if (i == 0 && this.f2746a != null && this.f2746a.m5788a()) {
            if (this.f2750e != null) {
                this.f2750e.mo2448a();
            }
            m5755a();
        }
        super.onWindowVisibilityChanged(i);
    }
}
