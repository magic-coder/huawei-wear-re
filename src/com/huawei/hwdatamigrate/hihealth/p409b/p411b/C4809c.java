package com.huawei.hwdatamigrate.hihealth.p409b.p411b;

/* compiled from: SyncCacheTable */
public class C4809c {
    private int f17778a;
    private int f17779b;
    private int f17780c;
    private String f17781d;
    private long f17782e;
    private int f17783f;
    private long f17784g;

    public int m23056a() {
        return this.f17779b;
    }

    public void m23057a(int i) {
        this.f17779b = i;
    }

    public int m23060b() {
        return this.f17780c;
    }

    public void m23061b(int i) {
        this.f17780c = i;
    }

    public String m23062c() {
        return this.f17781d;
    }

    public void m23059a(String str) {
        this.f17781d = str;
    }

    public long m23063d() {
        return this.f17782e;
    }

    public void m23058a(long j) {
        this.f17782e = j;
    }

    public int m23064e() {
        return this.f17783f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SyncCacheTable{");
        stringBuffer.append("id=").append(this.f17778a);
        stringBuffer.append(", dataType=").append(this.f17780c);
        stringBuffer.append(", data='").append(this.f17781d).append('\'');
        stringBuffer.append(", dataTime='").append(this.f17782e);
        stringBuffer.append(", isDone=").append(this.f17783f);
        stringBuffer.append(", modifiedTime=").append(this.f17784g);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
