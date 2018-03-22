package com.p230a.p231b.p232b.p233a.p236a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class C3087b {
    protected static final Comparator f10373a = new C3098l();
    private List f10374b = new LinkedList();
    private List f10375c = new ArrayList(64);
    private int f10376d = 0;
    private final int f10377e;

    public C3087b(int i) {
        this.f10377e = i;
    }

    private synchronized void m13800a() {
        while (this.f10376d > this.f10377e) {
            byte[] bArr = (byte[]) this.f10374b.remove(0);
            this.f10375c.remove(bArr);
            this.f10376d -= bArr.length;
        }
    }

    public synchronized void m13801a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f10377e) {
                this.f10374b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f10375c, bArr, f10373a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f10375c.add(binarySearch, bArr);
                this.f10376d += bArr.length;
                m13800a();
            }
        }
    }

    public synchronized byte[] m13802a(int i) {
        byte[] bArr;
        for (int i2 = 0; i2 < this.f10375c.size(); i2++) {
            bArr = (byte[]) this.f10375c.get(i2);
            if (bArr.length >= i) {
                this.f10376d -= bArr.length;
                this.f10375c.remove(i2);
                this.f10374b.remove(bArr);
                break;
            }
        }
        bArr = new byte[i];
        return bArr;
    }
}
