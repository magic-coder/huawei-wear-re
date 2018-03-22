package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.p363a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p359a.C4239a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.C4262a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.C4263b;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.C4264c;

public class C4258k {
    public static final C4258k f15928a = new C4258k();
    private String f15929b;
    private String f15930c;
    private C4259l f15931d;

    public C4258k(String str) {
        this(str, null);
    }

    public C4258k(String str, String str2) {
        this(str, str2, (C4259l) null);
    }

    public C4258k(String str, String str2, C4259l c4259l) {
        this.f15929b = str;
        this.f15930c = str2;
        this.f15931d = c4259l;
    }

    public C4258k m20590a(C4239a c4239a) {
        return m20608c(C4250c.m20581a(c4239a));
    }

    public C4258k m20591a(C4258k c4258k) {
        if (this.f15931d == null) {
            this.f15931d = new C4260m();
        }
        if (this.f15931d.mo4394a()) {
            C4259l c4260m = new C4260m();
            if (!m20611d()) {
                c4260m.m20619a(new C4258k(null, null, this.f15931d));
            }
            this.f15931d = c4260m;
        }
        ((C4260m) this.f15931d).m20619a(c4258k);
        return this;
    }

    public C4258k m20592a(Boolean bool) {
        return m20608c(C4248a.m20579a(bool));
    }

    public C4258k m20593a(Byte b) {
        return m20608c(C4249b.m20580a(b));
    }

    public C4258k m20594a(Character ch) {
        return m20608c(C4251d.m20583a(ch));
    }

    public C4258k m20595a(Double d) {
        return m20608c(C4252e.m20584a(d));
    }

    public C4258k m20596a(Float f) {
        return m20608c(C4253f.m20585a(f));
    }

    public C4258k m20597a(Integer num) {
        return m20608c(C4254g.m20586a(num));
    }

    public C4258k m20598a(Long l) {
        return m20608c(C4255h.m20587a(l));
    }

    public C4258k m20599a(Short sh) {
        return m20608c(C4256i.m20588a(sh));
    }

    public C4258k m20600a(String str) {
        return C4257j.m20589a(str, this);
    }

    public C4258k m20601a(byte[] bArr) {
        return m20608c(C4250c.m20582a(bArr));
    }

    public String m20602a() {
        return this.f15929b;
    }

    public void m20603a(C4263b c4263b) {
        if (c4263b != null) {
            c4263b.m20631a(new C4264c(this));
        }
    }

    public <T> void m20604a(T t) {
        if (t == null) {
            return;
        }
        if (t instanceof C4263b) {
            m20603a((C4263b) t);
        } else if (t instanceof Boolean) {
            m20592a((Boolean) t);
        } else if (t instanceof Character) {
            m20594a((Character) t);
        } else if (t instanceof Byte) {
            m20593a((Byte) t);
        } else if (t instanceof Short) {
            m20599a((Short) t);
        } else if (t instanceof Integer) {
            m20597a((Integer) t);
        } else if (t instanceof Long) {
            m20598a((Long) t);
        } else if (t instanceof Float) {
            m20596a((Float) t);
        } else if (t instanceof Double) {
            m20595a((Double) t);
        } else if (t instanceof String) {
            m20600a((String) t);
        } else if (t instanceof C4239a) {
            m20590a((C4239a) t);
        } else if (t instanceof byte[]) {
            m20601a((byte[]) t);
        } else {
            m20600a(t.toString());
        }
    }

    public void m20605a(StringBuilder stringBuilder, boolean z, String str) {
        if (!m20607b()) {
            stringBuilder.append(this.f15929b);
        }
        if (!m20609c()) {
            stringBuilder.append(':');
            stringBuilder.append(this.f15930c);
        }
        stringBuilder.append('(');
        if (this.f15931d != null) {
            if (this.f15931d.mo4394a()) {
                C4261n c4261n = (C4261n) this.f15931d;
                if (!c4261n.mo4395b()) {
                    stringBuilder.append(C4262a.m20626a(c4261n.m20625c()));
                }
            } else {
                String str2 = z ? str + "    " : str;
                for (C4258k c4258k : ((C4260m) this.f15931d).m20622c()) {
                    stringBuilder.append(str2);
                    c4258k.m20605a(stringBuilder, z, str2);
                }
            }
            if (!(this.f15931d.mo4395b() || this.f15931d.mo4394a())) {
                stringBuilder.append(str);
            }
        }
        stringBuilder.append(')');
    }

    public C4258k m20606b(String str) {
        this.f15930c = str;
        return this;
    }

    public boolean m20607b() {
        return this.f15929b == null || this.f15929b.length() == 0;
    }

    public C4258k m20608c(String str) {
        this.f15931d = new C4261n(str);
        return this;
    }

    public boolean m20609c() {
        return this.f15930c == null || this.f15930c.length() == 0;
    }

    public C4258k m20610d(String str) {
        C4258k e = m20612e(str);
        if (e != null && e != f15928a) {
            return e;
        }
        e = new C4258k(str);
        m20591a(e);
        return e;
    }

    public boolean m20611d() {
        return this.f15931d == null || this.f15931d.mo4395b();
    }

    public C4258k m20612e(String str) {
        if (m20613e() || this.f15931d == null || this.f15931d.mo4394a()) {
            return f15928a;
        }
        C4258k a = ((C4260m) this.f15931d).m20618a(str);
        return a == null ? f15928a : a;
    }

    public boolean m20613e() {
        return this == f15928a;
    }

    public String m20614f() {
        StringBuilder stringBuilder = new StringBuilder(64);
        m20605a(stringBuilder, false, "");
        return stringBuilder.toString();
    }

    public String m20615g() {
        StringBuilder stringBuilder = new StringBuilder(64);
        m20605a(stringBuilder, true, "\n    ");
        return stringBuilder.toString();
    }

    public String toString() {
        return m20615g();
    }
}
