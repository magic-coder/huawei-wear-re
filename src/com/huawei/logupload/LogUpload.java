package com.huawei.logupload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LogUpload implements Parcelable {
    public static final Creator<LogUpload> CREATOR = new C1106c();
    private boolean f2222A;
    private int f2223B;
    private int f2224C;
    private int f2225D;
    private String f2226E;
    private String f2227F;
    private String f2228G;
    private String f2229H;
    private String f2230I;
    private String f2231J;
    private boolean f2232a;
    private String f2233b;
    private String f2234c;
    private long f2235d;
    private long f2236e;
    private boolean f2237f;
    private boolean f2238g;
    private int f2239h;
    private int f2240i;
    private String f2241j;
    private String f2242k;
    private boolean f2243l;
    private String f2244m;
    private String f2245n;
    private String f2246o;
    private String f2247p;
    private String f2248q;
    private String f2249r;
    private String f2250s;
    private int f2251t;
    private int f2252u;
    private String f2253v;
    private int f2254w;
    private long f2255x;
    private boolean f2256y;
    private long f2257z;

    public LogUpload() {
        this.f2222A = false;
        this.f2224C = 0;
        this.f2225D = 0;
    }

    private LogUpload(Parcel parcel) {
        this.f2222A = false;
        this.f2224C = 0;
        this.f2225D = 0;
        m4769a(parcel);
    }

    public String m4766a() {
        return this.f2226E;
    }

    public void m4770a(String str) {
        this.f2226E = str;
    }

    public String m4772b() {
        return this.f2227F;
    }

    public void m4775b(String str) {
        this.f2227F = str;
    }

    public String m4777c() {
        return this.f2231J;
    }

    public void m4780c(String str) {
        this.f2231J = str;
    }

    public String m4782d() {
        return this.f2229H;
    }

    public void m4785d(String str) {
        this.f2229H = str;
    }

    public String m4787e() {
        return this.f2230I;
    }

    public void m4789e(String str) {
        this.f2230I = str;
    }

    public long m4791f() {
        return this.f2255x;
    }

    public void m4768a(long j) {
        this.f2255x = j;
    }

    public boolean m4797g() {
        return this.f2232a;
    }

    public void m4771a(boolean z) {
        this.f2232a = z;
    }

    public String m4798h() {
        return this.f2233b;
    }

    public void m4793f(String str) {
        this.f2233b = str;
    }

    public long m4800i() {
        return this.f2235d;
    }

    public void m4774b(long j) {
        this.f2235d = j;
    }

    public long m4802j() {
        return this.f2236e;
    }

    public void m4779c(long j) {
        this.f2236e = j;
    }

    public boolean m4805k() {
        return this.f2237f;
    }

    public void m4776b(boolean z) {
        this.f2237f = z;
    }

    public int m4806l() {
        return this.f2239h;
    }

    public void m4767a(int i) {
        this.f2239h = i;
    }

    public String m4808m() {
        return this.f2244m;
    }

    public void m4796g(String str) {
        this.f2244m = str;
    }

    public String m4810n() {
        return this.f2245n;
    }

    public void m4799h(String str) {
        this.f2245n = str;
    }

    public String m4812o() {
        return this.f2246o;
    }

    public void m4801i(String str) {
        this.f2246o = str;
    }

    public String m4814p() {
        return this.f2247p;
    }

    public void m4803j(String str) {
        this.f2247p = str;
    }

    public boolean m4817q() {
        return this.f2238g;
    }

    public void m4781c(boolean z) {
        this.f2238g = z;
    }

    public String m4818r() {
        return this.f2248q;
    }

    public void m4804k(String str) {
        this.f2248q = str;
    }

    public String m4819s() {
        return this.f2249r;
    }

    public void m4807l(String str) {
        this.f2249r = str;
    }

    public String m4820t() {
        return this.f2250s;
    }

    public void m4809m(String str) {
        this.f2250s = str;
    }

    public int m4821u() {
        return this.f2251t;
    }

    public void m4773b(int i) {
        this.f2251t = i;
    }

    public String m4822v() {
        return this.f2253v;
    }

    public void m4811n(String str) {
        this.f2253v = str;
    }

    public boolean m4823w() {
        return this.f2243l;
    }

    public void m4786d(boolean z) {
        this.f2243l = z;
    }

    public String m4824x() {
        return this.f2234c;
    }

    public void m4813o(String str) {
        this.f2234c = str;
    }

    public int m4825y() {
        return this.f2254w;
    }

    public void m4778c(int i) {
        this.f2254w = i;
    }

    public long m4826z() {
        return this.f2257z;
    }

    public void m4784d(long j) {
        this.f2257z = j;
    }

    public int m4758A() {
        return this.f2240i;
    }

    public void m4783d(int i) {
        this.f2240i = i;
    }

    public boolean m4759B() {
        return this.f2222A;
    }

    public void m4790e(boolean z) {
        this.f2222A = z;
    }

    public String m4760C() {
        return this.f2241j;
    }

    public void m4815p(String str) {
        this.f2241j = str;
    }

    public String m4761D() {
        return this.f2242k;
    }

    public void m4816q(String str) {
        this.f2242k = str;
    }

    public boolean m4762E() {
        return this.f2256y;
    }

    public void m4794f(boolean z) {
        this.f2256y = z;
    }

    public int m4763F() {
        return this.f2223B;
    }

    public void m4788e(int i) {
        this.f2223B = i;
    }

    public int m4764G() {
        return this.f2224C;
    }

    public void m4792f(int i) {
        this.f2224C = i;
    }

    public int m4765H() {
        return this.f2225D;
    }

    public void m4795g(int i) {
        this.f2225D = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (this.f2232a ? 1 : 0));
        parcel.writeString(this.f2233b);
        parcel.writeString(this.f2234c);
        parcel.writeLong(this.f2235d);
        parcel.writeLong(this.f2236e);
        if (this.f2237f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f2238g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.f2239h);
        parcel.writeInt(this.f2240i);
        parcel.writeString(this.f2241j);
        parcel.writeString(this.f2242k);
        if (this.f2243l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f2244m);
        parcel.writeString(this.f2245n);
        parcel.writeString(this.f2246o);
        parcel.writeString(this.f2247p);
        parcel.writeString(this.f2248q);
        parcel.writeString(this.f2249r);
        parcel.writeString(this.f2250s);
        parcel.writeInt(this.f2251t);
        parcel.writeInt(this.f2252u);
        parcel.writeString(this.f2253v);
        parcel.writeInt(this.f2254w);
        parcel.writeLong(this.f2255x);
        parcel.writeByte((byte) (this.f2256y ? 1 : 0));
        parcel.writeLong(this.f2257z);
        if (!this.f2222A) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.f2223B);
        parcel.writeInt(this.f2224C);
        parcel.writeInt(this.f2225D);
        parcel.writeString(this.f2226E);
        parcel.writeString(this.f2227F);
        parcel.writeString(this.f2228G);
        parcel.writeString(this.f2229H);
        parcel.writeString(this.f2230I);
        parcel.writeString(this.f2231J);
    }

    public void m4769a(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f2232a = parcel.readByte() != (byte) 0;
        this.f2233b = parcel.readString();
        this.f2234c = parcel.readString();
        this.f2235d = parcel.readLong();
        this.f2236e = parcel.readLong();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2237f = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2238g = z;
        this.f2239h = parcel.readInt();
        this.f2240i = parcel.readInt();
        this.f2241j = parcel.readString();
        this.f2242k = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2243l = z;
        this.f2244m = parcel.readString();
        this.f2245n = parcel.readString();
        this.f2246o = parcel.readString();
        this.f2247p = parcel.readString();
        this.f2248q = parcel.readString();
        this.f2249r = parcel.readString();
        this.f2250s = parcel.readString();
        this.f2251t = parcel.readInt();
        this.f2252u = parcel.readInt();
        this.f2253v = parcel.readString();
        this.f2254w = parcel.readInt();
        this.f2255x = parcel.readLong();
        this.f2256y = parcel.readByte() != (byte) 0;
        this.f2257z = parcel.readLong();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.f2222A = z2;
        this.f2223B = parcel.readInt();
        this.f2224C = parcel.readInt();
        this.f2225D = parcel.readInt();
        this.f2226E = parcel.readString();
        this.f2227F = parcel.readString();
        this.f2228G = parcel.readString();
        this.f2229H = parcel.readString();
        this.f2230I = parcel.readString();
        this.f2231J = parcel.readString();
    }
}
