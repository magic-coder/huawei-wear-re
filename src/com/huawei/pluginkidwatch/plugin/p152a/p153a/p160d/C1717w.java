package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: Command */
public class C1717w {
    private int f4589a = 0;
    private ArrayList<byte[]> f4590b;
    private ByteBuffer f4591c = null;
    private int f4592d;
    private boolean f4593e;

    public C1717w(ArrayList<byte[]> arrayList, boolean z) {
        this.f4590b = arrayList;
        this.f4593e = z;
    }

    public int m8154a() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f4589a))).intValue();
    }

    public void m8155a(int i) {
        this.f4589a = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public ArrayList<byte[]> m8157b() {
        return (ArrayList) C1489i.m6887a(this.f4590b);
    }

    public ByteBuffer m8159c() {
        return (ByteBuffer) C1489i.m6887a(this.f4591c);
    }

    public void m8156a(ByteBuffer byteBuffer) {
        this.f4591c = (ByteBuffer) C1489i.m6887a(byteBuffer);
    }

    public int m8160d() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f4592d))).intValue();
    }

    public void m8158b(int i) {
        this.f4592d = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public boolean m8161e() {
        return ((Boolean) C1489i.m6887a(Boolean.valueOf(this.f4593e))).booleanValue();
    }
}
