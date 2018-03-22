package com.huawei.android.pushagent.p018c.p019a;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class C0643c {
    public String f1156b = "";
    public HashMap f1157c = new HashMap();
    protected Context f1158d = null;

    public C0643c(Context context, String str) {
        this.f1156b = str;
        this.f1158d = context;
    }

    public static HashMap m2365e(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                hashMap.put(valueOf, jSONObject.get(valueOf));
            }
        } catch (Throwable e) {
            C0657e.m2521c("PushLogSC2712", e.toString(), e);
        }
        return hashMap;
    }

    public int m2366a(String str, int i) {
        Object b = m2370b(str, Integer.valueOf(i));
        return b instanceof Integer ? ((Integer) b).intValue() : b instanceof Long ? (int) ((Long) b).longValue() : i;
    }

    public String m2367a(String str, String str2) {
        return String.valueOf(m2370b(str, (Object) str2));
    }

    public boolean m2368a(String str, Object obj) {
        this.f1157c.put(str, obj);
        new C0659h(this.f1158d, this.f1156b).m2538a(str, obj);
        return true;
    }

    public HashMap af() {
        HashMap hashMap = new HashMap();
        Map b = new C0659h(this.f1158d, this.f1156b).m2541b();
        if (b != null) {
            for (Entry entry : b.entrySet()) {
                if (entry != null) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (hashMap.size() != 0) {
            this.f1157c = hashMap;
        }
        return hashMap;
    }

    public boolean ag() {
        new C0659h(this.f1158d, this.f1156b).m2535a(this.f1157c);
        return true;
    }

    public long m2369b(String str, long j) {
        Object b = m2370b(str, Long.valueOf(j));
        return b instanceof Integer ? (long) ((Integer) b).intValue() : b instanceof Long ? ((Long) b).longValue() : j;
    }

    public Object m2370b(String str, Object obj) {
        Object d = m2371d(str);
        return d == null ? obj : d;
    }

    public Object m2371d(String str) {
        return this.f1157c.get(str);
    }

    public String toString() {
        String str = HwAccountConstants.BLANK;
        String str2 = ":";
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : this.f1157c.entrySet()) {
            stringBuffer.append((String) entry.getKey()).append(str2).append(entry.getValue()).append(str);
        }
        return stringBuffer.toString();
    }
}
