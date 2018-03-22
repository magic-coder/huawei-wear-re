package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

public final class ak {
    private final String f404a;
    private final String f405b;
    private final ComponentName f406c = null;

    public ak(String str, String str2) {
        this.f404a = C0424f.m651a(str);
        this.f405b = C0424f.m651a(str2);
    }

    public String m598a() {
        return this.f405b;
    }

    public ComponentName m599b() {
        return this.f406c;
    }

    public Intent m600c() {
        return this.f404a != null ? new Intent(this.f404a).setPackage(this.f405b) : new Intent().setComponent(this.f406c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        return C0421c.m647a(this.f404a, akVar.f404a) && C0421c.m647a(this.f406c, akVar.f406c);
    }

    public int hashCode() {
        return C0421c.m645a(this.f404a, this.f406c);
    }

    public String toString() {
        return this.f404a == null ? this.f406c.flattenToString() : this.f404a;
    }
}
