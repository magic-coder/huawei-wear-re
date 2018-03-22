package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.as;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.util.C0464i;
import com.google.android.gms.p014a.C0340a;
import com.google.android.gms.p014a.C0343d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class C0446j extends at {
    private int f461a;

    protected C0446j(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 25) {
            int length = bArr.length;
            String valueOf = String.valueOf(C0464i.m822a(bArr, 0, bArr.length, false));
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(valueOf).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(valueOf).toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            if (bArr.length == 25) {
                z = true;
            }
            C0424f.m658b(z, "cert hash data has incorrect length. length=" + bArr.length);
        }
        this.f461a = Arrays.hashCode(bArr);
    }

    protected static byte[] m776a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public C0340a mo1780a() {
        return C0343d.m276a(mo1782c());
    }

    public int mo1781b() {
        return hashCode();
    }

    abstract byte[] mo1782c();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof as)) {
            return false;
        }
        try {
            as asVar = (as) obj;
            if (asVar.mo1781b() != hashCode()) {
                return false;
            }
            C0340a a = asVar.mo1780a();
            if (a == null) {
                return false;
            }
            return Arrays.equals(mo1782c(), (byte[]) C0343d.m277a(a));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    public int hashCode() {
        return this.f461a;
    }
}
