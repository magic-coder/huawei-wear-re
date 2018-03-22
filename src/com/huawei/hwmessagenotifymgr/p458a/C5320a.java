package com.huawei.hwmessagenotifymgr.p458a;

import android.graphics.drawable.Drawable;
import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: NotificationAppListInfo */
public class C5320a {
    private Drawable f19048a = null;
    private String f19049b = null;
    private String f19050c = null;
    private Integer f19051d = Integer.valueOf(0);

    public void m25735a(Drawable drawable) {
        this.f19048a = (Drawable) C0978h.a(drawable);
    }

    public Drawable m25733a() {
        return (Drawable) C0978h.a(this.f19048a);
    }

    public void m25736a(String str) {
        this.f19049b = (String) C0978h.a(str);
    }

    public String m25737b() {
        return (String) C0978h.a(this.f19049b);
    }

    public void m25738b(String str) {
        this.f19050c = (String) C0978h.a(str);
    }

    public String m25739c() {
        return (String) C0978h.a(this.f19050c);
    }

    public void m25734a(int i) {
        this.f19051d = (Integer) C0978h.a(Integer.valueOf(i));
    }

    public int m25740d() {
        return ((Integer) C0978h.a(this.f19051d)).intValue();
    }
}
