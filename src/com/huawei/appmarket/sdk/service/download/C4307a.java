package com.huawei.appmarket.sdk.service.download;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.service.p372b.C4292a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C4307a {
    private static final String f16028c = C4307a.class.getSimpleName();
    private static C4307a f16029d = new C4307a();
    private static SparseIntArray f16030e = new SparseIntArray();
    public List<String> f16031a = new ArrayList();
    public Map<String, SparseIntArray> f16032b = new HashMap();

    static {
        f16030e.put(1, 3000);
        f16030e.put(2, 6000);
    }

    public static C4307a m20759a() {
        return f16029d;
    }

    public static String m20760a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str2 + new URL(str).getFile();
        } catch (MalformedURLException e) {
            C4241a.m20532b(f16028c, "updataIP exception:" + e.getMessage());
            return str;
        }
    }

    public static String m20761c(String str) {
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            return protocol + "://" + host + (port == -1 ? "" : ":" + port);
        } catch (MalformedURLException e) {
            C4241a.m20532b(f16028c, "getIP exception:" + e.getMessage());
            return null;
        }
    }

    private void m20762d(String str) {
        this.f16031a.add(str);
        this.f16032b.put(str, f16030e);
    }

    public synchronized SparseIntArray m20763a(String str) {
        SparseIntArray sparseIntArray;
        if (str == null) {
            sparseIntArray = f16030e;
        } else {
            if (this.f16032b.size() <= 0) {
                m20764a(C4292a.m20708a().m20709b());
            }
            sparseIntArray = (SparseIntArray) this.f16032b.get(str);
            if (sparseIntArray == null) {
                sparseIntArray = f16030e;
            }
        }
        return sparseIntArray;
    }

    public void m20764a(Context context) {
        String string = context.getSharedPreferences("ConnectionParam", 4).getString("appstore.client.connectionparam.ip", null);
        if (string != null) {
            ArrayList arrayList = new ArrayList();
            List<String> asList = Arrays.asList(TextUtils.split(string, ","));
            if (asList != null && asList.size() > 0) {
                m20766b();
                for (String string2 : asList) {
                    m20762d(string2);
                }
            }
        }
    }

    public synchronized String m20765b(String str) {
        int i;
        if (this.f16031a.size() <= 0) {
            m20764a(C4292a.m20708a().m20709b());
        }
        for (int i2 = 0; i2 < this.f16031a.size(); i2++) {
            if (((String) this.f16031a.get(i2)).equals(str)) {
                i = i2 + 1;
                break;
            }
        }
        i = 0;
        return i < this.f16031a.size() ? (String) this.f16031a.get(i) : null;
    }

    public synchronized void m20766b() {
        this.f16031a.clear();
        this.f16032b.clear();
    }

    public synchronized String m20767c() {
        String str;
        for (String str2 : this.f16031a) {
            if (str2.startsWith("https")) {
                break;
            }
        }
        str2 = null;
        return str2;
    }
}
