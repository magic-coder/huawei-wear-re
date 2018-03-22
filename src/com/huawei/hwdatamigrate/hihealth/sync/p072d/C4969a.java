package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import com.huawei.hihealth.p394c.C4543e;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HiCloudValue */
public class C4969a {
    private Map<String, Double> f18061a;

    public C4969a() {
        this.f18061a = new HashMap();
    }

    public void m23883a(String str, double d) {
        if (this.f18061a != null) {
            this.f18061a.put(str, Double.valueOf(d));
        }
    }

    public String m23882a() {
        if (this.f18061a == null) {
            return null;
        }
        return C4543e.m21780a(this.f18061a, (Type) Map.class);
    }

    public C4969a(String str) {
        this.f18061a = (Map) C4543e.m21781b(str, Map.class);
    }

    public double m23881a(String str) {
        if (this.f18061a == null) {
            return 0.0d;
        }
        Double d = (Double) this.f18061a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public Map<String, Double> m23884b() {
        return this.f18061a;
    }
}
