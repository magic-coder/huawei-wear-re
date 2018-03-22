package com.tencent.map.p535b;

import android.net.wifi.ScanResult;
import com.amap.api.location.LocationManagerProxy;
import java.util.List;
import org.json.JSONObject;

public final class C6309d {
    private long f21952a;
    private List<C6310e> f21953b;
    private List<C6316h> f21954c;
    private String f21955d;

    private static boolean m28927a(StringBuffer stringBuffer) {
        try {
            return new JSONObject(stringBuffer.toString()).getJSONObject(LocationManagerProxy.KEY_LOCATION_CHANGED).getDouble("accuracy") < 5000.0d;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean m28928a(List<ScanResult> list) {
        if (list == null) {
            return false;
        }
        int i;
        if (this.f21954c != null) {
            i = 0;
            for (int i2 = 0; i2 < this.f21954c.size(); i2++) {
                String str = ((C6316h) this.f21954c.get(i2)).f22009a;
                int i3 = 0;
                while (str != null && i3 < list.size()) {
                    if (str.equals(((ScanResult) list.get(i3)).BSSID)) {
                        i++;
                        break;
                    }
                    i3++;
                }
            }
        } else {
            i = 0;
        }
        int size = list.size();
        return (size < 6 || i < (size / 2) + 1) ? (size >= 6 || i < 2) ? this.f21954c.size() <= 2 && list.size() <= 2 && Math.abs(System.currentTimeMillis() - this.f21952a) <= StatisticConfig.MIN_UPLOAD_INTERVAL : true : true;
    }

    public final void m28929a(int i, int i2, int i3, int i4, List<ScanResult> list) {
        this.f21952a = System.currentTimeMillis();
        this.f21955d = null;
        this.f21953b.clear();
        C6310e c6310e = new C6310e();
        c6310e.f21956a = i;
        c6310e.f21957b = i2;
        c6310e.f21958c = i3;
        c6310e.f21959d = i4;
        this.f21953b.add(c6310e);
        if (list != null) {
            this.f21954c.clear();
            for (int i5 = 0; i5 < list.size(); i5++) {
                C6316h c6316h = new C6316h();
                c6316h.f22009a = ((ScanResult) list.get(i5)).BSSID;
                int i6 = ((ScanResult) list.get(i5)).level;
                this.f21954c.add(c6316h);
            }
        }
    }

    public final void m28930a(String str) {
        this.f21955d = str;
    }

    public final String m28931b(int i, int i2, int i3, int i4, List<ScanResult> list) {
        if (this.f21955d == null || this.f21955d.length() < 10) {
            return null;
        }
        String str = this.f21955d;
        if (str == null || list == null) {
            str = null;
        } else {
            long abs = Math.abs(System.currentTimeMillis() - this.f21952a);
            if ((abs > StatisticConfig.MIN_UPLOAD_INTERVAL && list.size() > 2) || ((abs > 45000 && list.size() <= 2) || !C6309d.m28927a(new StringBuffer(str)))) {
                str = null;
            }
        }
        this.f21955d = str;
        if (this.f21955d == null) {
            return null;
        }
        if (this.f21953b != null && this.f21953b.size() > 0) {
            C6310e c6310e = (C6310e) this.f21953b.get(0);
            if (c6310e.f21956a != i || c6310e.f21957b != i2 || c6310e.f21958c != i3 || c6310e.f21959d != i4) {
                return null;
            }
            if ((this.f21954c == null || this.f21954c.size() == 0) && (list == null || list.size() == 0)) {
                return this.f21955d;
            }
            if (m28928a((List) list)) {
                return this.f21955d;
            }
        }
        return m28928a((List) list) ? this.f21955d : null;
    }
}
