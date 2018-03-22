package com.huawei.wallet.logic.down;

import java.io.Serializable;

public class DownloadEntity implements Serializable {
    private String f21224a;
    private String f21225b;
    private String f21226c;
    private String f21227d;
    private long f21228e;
    private long f21229f = 0;
    private long f21230g = 0;

    public String m28014a() {
        return this.f21226c;
    }

    public DownloadEntity(String str, String str2, long j, long j2) {
        this.f21227d = str;
        this.f21224a = str2;
        this.f21229f = j;
        this.f21230g = j2;
    }

    public String m28017b() {
        return this.f21227d;
    }

    public long m28018c() {
        return this.f21228e;
    }

    public void m28015a(long j) {
        this.f21228e = j;
    }

    public String m28019d() {
        return this.f21225b;
    }

    public void m28016a(String str) {
        this.f21225b = str;
    }

    public long m28020e() {
        return this.f21229f;
    }

    public long m28021f() {
        return this.f21230g;
    }
}
