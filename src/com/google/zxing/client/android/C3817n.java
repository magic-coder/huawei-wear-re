package com.google.zxing.client.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.crowdtestsdk.utils.ResUtil;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MResource */
public class C3817n {
    private static final ConcurrentHashMap<String, SoftReference<Drawable>> f14825b = new ConcurrentHashMap();
    private Context f14826a;

    public C3817n(Context context) {
        this.f14826a = context;
    }

    public int m19057a(String str) {
        return m19058a(ResUtil.TYPE_STRING, str);
    }

    public int m19059b(String str) {
        return m19058a(ResUtil.TYPE_DRAWABLE, str);
    }

    public int m19061c(String str) {
        return m19058a("id", str);
    }

    public int m19062d(String str) {
        return m19058a("raw", str);
    }

    public int m19063e(String str) {
        return m19058a(ResUtil.TYPE_DIMEN, str);
    }

    public int m19064f(String str) {
        return m19058a(ResUtil.TYPE_LAYOUT, str);
    }

    public int m19065g(String str) {
        return m19058a("color", str);
    }

    public int m19058a(String str, String str2) {
        return m19060b(str, str2);
    }

    public String m19066h(String str) {
        return this.f14826a.getResources().getString(m19060b(ResUtil.TYPE_STRING, str));
    }

    public int m19060b(String str, String str2) {
        return this.f14826a.getResources().getIdentifier(str2, str, this.f14826a.getPackageName());
    }

    public int m19067i(String str) {
        return this.f14826a.getResources().getColor(m19065g(str));
    }
}
