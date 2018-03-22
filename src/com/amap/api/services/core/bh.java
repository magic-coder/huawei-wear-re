package com.amap.api.services.core;

import com.snowballtech.business.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

/* compiled from: LogUpdateRequest */
public class bh extends bt {
    private byte[] f12419a;

    public bh(byte[] bArr) {
        this.f12419a = (byte[]) bArr.clone();
    }

    private String m16786f() {
        Object bytes = au.f12370a.getBytes();
        byte[] bArr = new byte[(bytes.length + 50)];
        System.arraycopy(this.f12419a, 0, bArr, 0, 50);
        System.arraycopy(bytes, 0, bArr, 50, bytes.length);
        return ab.m16591a(bArr);
    }

    public Map<String, String> d_() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f12419a.length));
        return hashMap;
    }

    public Map<String, String> c_() {
        return null;
    }

    public String mo4103b() {
        return String.format(au.f12371b, new Object[]{"1", "1", "1", BuildConfig.sdk_log_switch, m16786f()});
    }

    public byte[] e_() {
        return this.f12419a;
    }

    public HttpEntity mo4099e() {
        return null;
    }
}
