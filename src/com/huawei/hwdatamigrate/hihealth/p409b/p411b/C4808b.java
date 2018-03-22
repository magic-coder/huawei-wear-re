package com.huawei.hwdatamigrate.hihealth.p409b.p411b;

/* compiled from: SyncAnchorTable */
public class C4808b {
    private int f17773a;
    private int f17774b;
    private long f17775c;
    private long f17776d;
    private int f17777e;

    public int m23046a() {
        return this.f17773a;
    }

    public void m23047a(int i) {
        this.f17773a = i;
    }

    public long m23049b() {
        return this.f17775c;
    }

    public void m23048a(long j) {
        this.f17775c = j;
    }

    public long m23052c() {
        return this.f17776d;
    }

    public void m23051b(long j) {
        this.f17776d = j;
    }

    public int m23054d() {
        return this.f17777e;
    }

    public void m23050b(int i) {
        this.f17777e = i;
    }

    public int m23055e() {
        return this.f17774b;
    }

    public void m23053c(int i) {
        this.f17774b = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SyncAnchorTable{");
        stringBuffer.append("syncType=").append(this.f17773a);
        stringBuffer.append(", cloudCode=").append(this.f17775c);
        stringBuffer.append(", syncTypeVersion=").append(this.f17776d);
        stringBuffer.append(", syncTime=").append(this.f17777e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
