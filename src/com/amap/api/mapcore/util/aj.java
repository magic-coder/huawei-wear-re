package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.C3264r;
import com.amap.api.maps.AMapException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: ProtocalHandler */
public abstract class aj<T, V> extends dp {
    protected T f11415a;
    protected int f11416b = 1;
    protected String f11417c = "";
    protected Context f11418d;
    protected final int f11419e = 5000;
    protected final int f11420f = 50000;
    private int f11421j = 1;

    protected abstract V mo4064b(String str) throws AMapException;

    public aj(Context context, T t) {
        m15479a(context, t);
    }

    private void m15479a(Context context, T t) {
        this.f11418d = context;
        this.f11415a = t;
    }

    public V m15484d() throws AMapException {
        if (this.f11415a != null) {
            return m15480h();
        }
        return null;
    }

    private V m15480h() throws AMapException {
        int i = 0;
        V v = null;
        while (i < this.f11416b) {
            try {
                C3318do a = C3318do.m16080a(false);
                m15469a(bt.m15765a(this.f11418d));
                v = mo4066a(a.m16088d(this));
                i = this.f11416b;
            } catch (Throwable e) {
                ca.m15831a(e, "ProtocalHandler", "getDataMayThrow AMapException");
                e.printStackTrace();
                i++;
                if (i >= this.f11416b) {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (Throwable e2) {
                ca.m15831a(e2, "ProtocalHandler", "getDataMayThrow AMapCoreException");
                e2.printStackTrace();
                i++;
                if (i < this.f11416b) {
                    try {
                        Thread.sleep((long) (this.f11421j * 1000));
                    } catch (InterruptedException e3) {
                        ca.m15831a(e2, "ProtocalHandler", "getDataMayThrow InterruptedException");
                        e2.printStackTrace();
                        throw new AMapException(e2.getMessage());
                    }
                }
                m15485e();
                throw new AMapException(e2.m15683a());
            }
        }
        return v;
    }

    protected V mo4067b(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Throwable e) {
            ca.m15831a(e, "ProtocalHandler", "loadData Exception");
            e.printStackTrace();
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        bk.m15663a(str);
        return mo4064b(str);
    }

    public Map<String, String> mo4004c() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", C3264r.f11368d);
        hashMap.put("X-INFO", bo.m15701a(this.f11418d, bk.m15681e(), null, false));
        return hashMap;
    }

    private V mo4066a(byte[] bArr) throws AMapException {
        return mo4067b(bArr);
    }

    protected V m15485e() {
        return null;
    }
}
