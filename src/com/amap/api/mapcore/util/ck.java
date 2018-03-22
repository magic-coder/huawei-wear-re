package com.amap.api.mapcore.util;

import com.sina.weibo.sdk.component.GameManager;
import com.snowballtech.business.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public class ck extends dp {
    private byte[] f11613a;

    public ck(byte[] bArr) {
        this.f11613a = (byte[]) bArr.clone();
    }

    private String m15905e() {
        Object bytes;
        try {
            bytes = bz.f11566a.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            bytes = bz.f11566a.getBytes();
        }
        byte[] bArr = new byte[(bytes.length + 50)];
        System.arraycopy(this.f11613a, 0, bArr, 0, 50);
        System.arraycopy(bytes, 0, bArr, 50, bytes.length);
        return bs.m15756a(bArr);
    }

    public Map<String, String> mo4004c() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f11613a.length));
        return hashMap;
    }

    public Map<String, String> mo4003b() {
        return null;
    }

    public String mo4002a() {
        return String.format(bz.f11567b, new Object[]{"1", "1", "1", BuildConfig.sdk_log_switch, m15905e()});
    }

    public byte[] a_() {
        return this.f11613a;
    }
}
