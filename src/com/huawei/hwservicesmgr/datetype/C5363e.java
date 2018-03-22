package com.huawei.hwservicesmgr.datetype;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: GPSFileTransferActiveReport */
public class C5363e {
    private int f19112a = 0;
    private byte[] f19113b = null;

    public int m25832a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f19112a))).intValue();
    }

    public void m25833a(int i) {
        this.f19112a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public byte[] m25835b() {
        return (byte[]) C0978h.a(this.f19113b.clone());
    }

    public void m25834a(byte[] bArr) {
        this.f19113b = (byte[]) C0978h.a(bArr.clone());
    }
}
