package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.C0424f;

public abstract class C0402j {
    protected final DataHolder f327a;
    protected int f328b;
    private int f329c;

    public C0402j(DataHolder dataHolder, int i) {
        this.f327a = (DataHolder) C0424f.m649a((Object) dataHolder);
        m473a(i);
    }

    protected int m472a(String str) {
        return this.f327a.zzc(str, this.f328b, this.f329c);
    }

    protected void m473a(int i) {
        boolean z = i >= 0 && i < this.f327a.getCount();
        C0424f.m654a(z);
        this.f328b = i;
        this.f329c = this.f327a.zzcI(this.f328b);
    }

    protected String m474b(String str) {
        return this.f327a.zzd(str, this.f328b, this.f329c);
    }

    protected byte[] m475c(String str) {
        return this.f327a.zzg(str, this.f328b, this.f329c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0402j)) {
            return false;
        }
        C0402j c0402j = (C0402j) obj;
        return C0421c.m647a(Integer.valueOf(c0402j.f328b), Integer.valueOf(this.f328b)) && C0421c.m647a(Integer.valueOf(c0402j.f329c), Integer.valueOf(this.f329c)) && c0402j.f327a == this.f327a;
    }

    public int hashCode() {
        return C0421c.m645a(Integer.valueOf(this.f328b), Integer.valueOf(this.f329c), this.f327a);
    }
}
