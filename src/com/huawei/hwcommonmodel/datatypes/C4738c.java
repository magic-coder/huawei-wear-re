package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;
import java.util.List;

/* compiled from: DataOtaStatus */
public class C4738c {
    private long f17293a;
    private String f17294b;
    private int f17295c;
    private List<Integer> f17296d;
    private C4745l f17297e;
    private List<C4745l> f17298f;

    public long m22659a() {
        return ((Long) C0978h.a(Long.valueOf(this.f17293a))).longValue();
    }

    public void m22661a(long j) {
        this.f17293a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String m22665b() {
        return (String) C0978h.a(this.f17294b);
    }

    public void m22663a(String str) {
        this.f17294b = (String) C0978h.a(str);
    }

    public int m22667c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17295c))).intValue();
    }

    public void m22660a(int i) {
        this.f17295c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<Integer> m22668d() {
        return (List) C0978h.a(this.f17296d);
    }

    public void m22664a(List<Integer> list) {
        this.f17296d = (List) C0978h.a(list);
    }

    public void m22662a(C4745l c4745l) {
        this.f17297e = (C4745l) C0978h.a(c4745l);
    }

    public void m22666b(List<C4745l> list) {
        this.f17298f = (List) C0978h.a(list);
    }
}
