package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.wearable.C0521h;
import com.google.android.gms.wearable.Channel;

final class bo implements C0521h {
    private final String f971a;
    private final C0521h f972b;

    bo(String str, C0521h c0521h) {
        this.f971a = (String) C0424f.m649a((Object) str);
        this.f972b = (C0521h) C0424f.m649a((Object) c0521h);
    }

    public void mo1905a(Channel channel) {
        this.f972b.mo1905a(channel);
    }

    public void mo1906a(Channel channel, int i, int i2) {
        this.f972b.mo1906a(channel, i, i2);
    }

    public void mo1911b(Channel channel, int i, int i2) {
        this.f972b.mo1911b(channel, i, i2);
    }

    public void mo1913c(Channel channel, int i, int i2) {
        this.f972b.mo1913c(channel, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bo)) {
            return false;
        }
        bo boVar = (bo) obj;
        return this.f972b.equals(boVar.f972b) && this.f971a.equals(boVar.f971a);
    }

    public int hashCode() {
        return (this.f971a.hashCode() * 31) + this.f972b.hashCode();
    }
}
