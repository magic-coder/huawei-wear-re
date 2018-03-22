package com.huawei.sim.esim.p505b;

import java.util.Arrays;

/* compiled from: CommonDataType */
public class C5900a {
    private String f20195a;
    private int f20196b;
    private String f20197c;
    private byte[] f20198d;
    private String f20199e;

    public String m27108a() {
        return this.f20195a;
    }

    public void m27110a(String str) {
        this.f20195a = str;
    }

    public int m27112b() {
        return this.f20196b;
    }

    public void m27109a(int i) {
        this.f20196b = i;
    }

    public String m27114c() {
        return this.f20197c;
    }

    public void m27113b(String str) {
        this.f20197c = str;
    }

    public byte[] m27115d() {
        if (this.f20198d != null) {
            return (byte[]) this.f20198d.clone();
        }
        return null;
    }

    public void m27111a(byte[] bArr) {
        if (bArr != null) {
            this.f20198d = (byte[]) bArr.clone();
        } else {
            this.f20198d = null;
        }
    }

    public String toString() {
        return "CommonDataType{key='" + this.f20195a + '\'' + ", type=" + this.f20196b + ", value='" + this.f20197c + '\'' + ", icon=" + Arrays.toString(this.f20198d) + ", iconType='" + this.f20199e + '\'' + '}';
    }
}
