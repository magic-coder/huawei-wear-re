package com.fenda.hwbracelet.p262e;

import java.nio.ByteBuffer;

/* compiled from: XbResponse */
public class C3603f {
    private final ByteBuffer f13824a;
    private final byte f13825b;

    public C3603f(byte b, ByteBuffer byteBuffer) {
        this.f13825b = b;
        this.f13824a = byteBuffer;
    }

    public ByteBuffer m18083a() {
        return this.f13824a;
    }

    public C3602e m18084b() {
        return C3602e.m18081a(this.f13825b);
    }

    public int m18085c() {
        return this.f13824a.capacity();
    }
}
