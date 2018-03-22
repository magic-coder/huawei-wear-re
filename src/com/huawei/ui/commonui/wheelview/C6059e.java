package com.huawei.ui.commonui.wheelview;

import android.content.Context;
import com.huawei.ui.commonui.wheelview.p515a.C6054a;

/* compiled from: ThreeWheelPicker */
public class C6059e {
    private static int f20933a = 24;
    private static float f20934b = 3.0f;
    private WheelView f20935c = null;
    private WheelView f20936d = null;
    private WheelView f20937e = null;
    private C6054a f20938f;
    private C6054a f20939g;
    private C6054a f20940h;
    private String f20941i = "";
    private String f20942j = "";
    private String f20943k = "";
    private String[] f20944l = null;
    private String[] f20945m = null;
    private String[] f20946n = null;
    private C5691c f20947o = null;

    public C6059e(Context context, WheelView wheelView, WheelView wheelView2) {
        this.f20935c = wheelView;
        this.f20935c.f20889a = (float) f20933a;
        this.f20937e = wheelView2;
        this.f20937e.f20889a = (float) f20933a;
        this.f20941i = "";
        this.f20942j = "";
    }

    public C6059e(Context context, WheelView wheelView, WheelView wheelView2, WheelView wheelView3) {
        this.f20935c = wheelView;
        this.f20935c.f20889a = (float) f20933a;
        this.f20936d = wheelView2;
        this.f20936d.f20889a = (float) f20933a;
        this.f20937e = wheelView3;
        this.f20937e.f20889a = (float) f20933a;
        this.f20941i = "";
        this.f20942j = "";
        this.f20943k = "";
    }

    public void m27734a(String[] strArr, int i, boolean z) {
        if (strArr != null) {
            this.f20944l = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f20944l, 0, strArr.length);
            this.f20938f = new C6054a(strArr);
            this.f20935c.setAdapter(this.f20938f);
            this.f20935c.setCyclic(z);
            this.f20935c.setCurrentItem(i);
            this.f20935c.setOnTouchListener(new C6060f(this));
            return;
        }
        this.f20944l = null;
    }

    public void m27737b(String[] strArr, int i, boolean z) {
        int i2 = 0;
        if (strArr != null) {
            this.f20945m = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f20945m, 0, strArr.length);
            this.f20939g = new C6054a(strArr);
            this.f20936d.setAdapter(this.f20939g);
            this.f20936d.setCyclic(z);
            if (i >= strArr.length) {
                if (strArr.length - 1 >= 0) {
                    i2 = strArr.length - 1;
                }
            } else if (i >= 0) {
                i2 = i;
            }
            this.f20936d.setCurrentItem(i2);
            this.f20936d.setOnTouchListener(new C6061g(this));
            return;
        }
        this.f20945m = null;
    }

    public void m27739c(String[] strArr, int i, boolean z) {
        int i2 = 0;
        if (strArr != null) {
            this.f20946n = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f20946n, 0, strArr.length);
            this.f20940h = new C6054a(strArr);
            this.f20937e.setAdapter(this.f20940h);
            this.f20937e.setCyclic(z);
            if (i >= strArr.length) {
                if (strArr.length - 1 >= 0) {
                    i2 = strArr.length - 1;
                }
            } else if (i >= 0) {
                i2 = i;
            }
            this.f20937e.setCurrentItem(i2);
            this.f20937e.setOnTouchListener(new C6062h(this));
            if (this.f20947o != null) {
                this.f20937e.m27702a(this.f20947o);
                return;
            }
            return;
        }
        this.f20946n = null;
    }

    public void m27733a(C5691c c5691c) {
        this.f20947o = c5691c;
    }

    public void m27736b(C5691c c5691c) {
        if (this.f20935c != null && c5691c != null) {
            this.f20935c.m27702a(c5691c);
        }
    }

    public String m27732a() {
        String str = "";
        int currentItem = this.f20935c.getCurrentItem();
        if (this.f20944l == null || this.f20944l.length <= currentItem) {
            return str;
        }
        return this.f20944l[currentItem];
    }

    public String m27735b() {
        String str = "";
        int currentItem = this.f20936d.getCurrentItem();
        if (this.f20945m == null || this.f20945m.length <= currentItem) {
            return str;
        }
        return this.f20945m[currentItem];
    }

    public String m27738c() {
        String str = "";
        int currentItem = this.f20937e.getCurrentItem();
        if (this.f20946n == null || this.f20946n.length <= currentItem) {
            return str;
        }
        return this.f20946n[currentItem];
    }
}
