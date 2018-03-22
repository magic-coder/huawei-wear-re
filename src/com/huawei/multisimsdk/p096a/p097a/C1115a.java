package com.huawei.multisimsdk.p096a.p097a;

import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* compiled from: AttachedDeviceMgrCommonCommand */
public class C1115a {
    private C1117c f2355a;
    private String f2356b;
    private String f2357c;
    private String f2358d;
    private List<SimInfo> f2359e;
    private int f2360f;

    public C1117c m4980a() {
        return this.f2355a;
    }

    public int m4981b() {
        return this.f2360f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1115a c1115a = (C1115a) obj;
        if (this.f2360f != c1115a.f2360f) {
            return false;
        }
        if (this.f2355a != null) {
            if (!this.f2355a.equals(c1115a.f2355a)) {
                return false;
            }
        } else if (c1115a.f2355a != null) {
            return false;
        }
        if (this.f2356b != null) {
            if (!this.f2356b.equals(c1115a.f2356b)) {
                return false;
            }
        } else if (c1115a.f2356b != null) {
            return false;
        }
        if (this.f2357c != null) {
            if (!this.f2357c.equals(c1115a.f2357c)) {
                return false;
            }
        } else if (c1115a.f2357c != null) {
            return false;
        }
        if (this.f2358d != null) {
            if (!this.f2358d.equals(c1115a.f2358d)) {
                return false;
            }
        } else if (c1115a.f2358d != null) {
            return false;
        }
        if (this.f2359e != null) {
            z = this.f2359e.equals(c1115a.f2359e);
        } else if (c1115a.f2359e != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.f2360f;
        if (this.f2355a != null) {
            i = (i * 31) + this.f2355a.hashCode();
        }
        if (this.f2356b != null) {
            i = (i * 31) + this.f2356b.hashCode();
        }
        if (this.f2357c != null) {
            i = (i * 31) + this.f2357c.hashCode();
        }
        if (this.f2358d != null) {
            i = (i * 31) + this.f2358d.hashCode();
        }
        if (this.f2359e != null) {
            return (i * 31) + this.f2359e.hashCode();
        }
        return i;
    }
}
