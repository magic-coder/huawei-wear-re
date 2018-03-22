package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.sina.weibo.sdk.component.GameManager;
import java.net.Proxy;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: Request */
public abstract class dp {
    int f11411g = 20000;
    int f11412h = 20000;
    Proxy f11413i = null;

    public abstract String mo4002a();

    public abstract Map<String, String> mo4003b();

    public abstract Map<String, String> mo4004c();

    String m15473f() {
        byte[] a_ = a_();
        if (a_ == null || a_.length == 0) {
            return mo4002a();
        }
        Map b = mo4003b();
        if (b == null) {
            return mo4002a();
        }
        String a = dm.m16067a(b);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo4002a()).append(LocationInfo.NA).append(a);
        return stringBuffer.toString();
    }

    byte[] m15474g() {
        byte[] a_ = a_();
        if (a_ != null && a_.length != 0) {
            return a_;
        }
        String a = dm.m16067a(mo4003b());
        try {
            if (TextUtils.isEmpty(a)) {
                return a_;
            }
            return a.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            Throwable th = e;
            a_ = a.getBytes();
            cd.m15825a(th, "Request", "getConnectionDatas");
            return a_;
        }
    }

    public final void m15468a(int i) {
        this.f11411g = i;
    }

    public final void m15471b(int i) {
        this.f11412h = i;
    }

    public byte[] a_() {
        return null;
    }

    public final void m15469a(Proxy proxy) {
        this.f11413i = proxy;
    }
}
