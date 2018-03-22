package com.tencent.map.p533a.p534a;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.map.p535b.C6324q;
import java.util.ArrayList;
import java.util.Iterator;

public class C6305c {
    private long f21912A;
    public int f21913a;
    public double f21914b;
    public double f21915c;
    public double f21916d;
    public double f21917e;
    public double f21918f;
    public double f21919g;
    public int f21920h;
    public String f21921i;
    public String f21922j;
    public String f21923k;
    public String f21924l;
    public String f21925m;
    public String f21926n;
    public String f21927o;
    public String f21928p;
    public String f21929q;
    public String f21930r;
    public String f21931s;
    public String f21932t;
    public String f21933u;
    public String f21934v;
    public ArrayList<C6304b> f21935w;
    public boolean f21936x;
    public int f21937y;
    public int f21938z;

    public C6305c() {
        this.f21913a = 1;
        this.f21914b = 0.0d;
        this.f21915c = 0.0d;
        this.f21916d = -1.0d;
        this.f21917e = 0.0d;
        this.f21918f = 0.0d;
        this.f21919g = 0.0d;
        this.f21920h = 0;
        this.f21921i = null;
        this.f21922j = null;
        this.f21923k = null;
        this.f21924l = null;
        this.f21925m = null;
        this.f21926n = null;
        this.f21927o = null;
        this.f21928p = null;
        this.f21929q = null;
        this.f21930r = null;
        this.f21931s = null;
        this.f21932t = null;
        this.f21933u = null;
        this.f21934v = null;
        this.f21935w = null;
        this.f21936x = false;
        this.f21937y = 0;
        this.f21938z = -1;
        this.f21912A = -1;
        this.f21917e = 0.0d;
        this.f21916d = 0.0d;
        this.f21915c = 0.0d;
        this.f21914b = 0.0d;
        this.f21928p = null;
        this.f21927o = null;
        this.f21926n = null;
        this.f21925m = null;
        this.f21936x = false;
        this.f21912A = System.currentTimeMillis();
        this.f21937y = 0;
        this.f21938z = -1;
        this.f21935w = null;
    }

    public C6305c(C6305c c6305c) {
        this.f21913a = 1;
        this.f21914b = 0.0d;
        this.f21915c = 0.0d;
        this.f21916d = -1.0d;
        this.f21917e = 0.0d;
        this.f21918f = 0.0d;
        this.f21919g = 0.0d;
        this.f21920h = 0;
        this.f21921i = null;
        this.f21922j = null;
        this.f21923k = null;
        this.f21924l = null;
        this.f21925m = null;
        this.f21926n = null;
        this.f21927o = null;
        this.f21928p = null;
        this.f21929q = null;
        this.f21930r = null;
        this.f21931s = null;
        this.f21932t = null;
        this.f21933u = null;
        this.f21934v = null;
        this.f21935w = null;
        this.f21936x = false;
        this.f21937y = 0;
        this.f21938z = -1;
        this.f21912A = -1;
        this.f21913a = c6305c.f21913a;
        this.f21914b = c6305c.f21914b;
        this.f21915c = c6305c.f21915c;
        this.f21916d = c6305c.f21916d;
        this.f21917e = c6305c.f21917e;
        this.f21936x = c6305c.f21936x;
        this.f21921i = c6305c.f21921i;
        this.f21920h = 0;
        this.f21922j = c6305c.f21922j;
        this.f21923k = c6305c.f21923k;
        this.f21924l = c6305c.f21924l;
        this.f21925m = c6305c.f21925m;
        this.f21926n = c6305c.f21926n;
        this.f21927o = c6305c.f21927o;
        this.f21928p = c6305c.f21928p;
        this.f21929q = c6305c.f21929q;
        this.f21930r = c6305c.f21930r;
        this.f21931s = c6305c.f21931s;
        this.f21932t = c6305c.f21932t;
        this.f21933u = c6305c.f21933u;
        this.f21934v = c6305c.f21934v;
        this.f21912A = c6305c.m28912a();
        this.f21937y = c6305c.f21937y;
        this.f21938z = c6305c.f21938z;
        this.f21935w = null;
        if (c6305c.f21935w != null) {
            this.f21935w = new ArrayList();
            Iterator it = c6305c.f21935w.iterator();
            while (it.hasNext()) {
                this.f21935w.add((C6304b) it.next());
            }
        }
    }

    public long m28912a() {
        return this.f21912A;
    }

    public void m28913a(String str) {
        String str2 = "Unknown";
        this.f21924l = str2;
        this.f21923k = str2;
        this.f21922j = str2;
        this.f21921i = str2;
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                int length = split.length;
                if (length > 0) {
                    this.f21921i = split[0];
                }
                if (length > 1) {
                    this.f21922j = split[1];
                }
                if (length == 3) {
                    this.f21923k = split[1];
                } else if (length > 3) {
                    this.f21923k = split[2];
                }
                if (length == 3) {
                    this.f21924l = split[2];
                } else if (length > 3) {
                    this.f21924l = split[3];
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f21938z).append(HwAccountConstants.BLANK).append(this.f21937y).append(HwAccountConstants.BLANK).append(this.f21936x ? "Mars" : "WGS84").append(HwAccountConstants.BLANK).append(this.f21913a == 0 ? "GPS" : "Network").append("\n");
        stringBuilder.append(this.f21914b).append(HwAccountConstants.BLANK).append(this.f21915c).append("\n");
        stringBuilder.append(this.f21916d).append(HwAccountConstants.BLANK).append(this.f21917e).append("\n");
        stringBuilder.append(this.f21918f).append(HwAccountConstants.BLANK).append(this.f21919g).append("\n");
        if (this.f21938z == 3 || this.f21938z == 4) {
            stringBuilder.append(this.f21921i).append(HwAccountConstants.BLANK).append(this.f21922j).append(HwAccountConstants.BLANK).append(this.f21923k).append(HwAccountConstants.BLANK).append(this.f21924l).append(HwAccountConstants.BLANK).append(this.f21925m).append(HwAccountConstants.BLANK).append(this.f21926n).append(HwAccountConstants.BLANK).append(this.f21927o).append(HwAccountConstants.BLANK).append(this.f21928p).append("\n");
        }
        if (this.f21938z == 4 && this.f21935w != null) {
            stringBuilder.append(this.f21935w.size()).append("\n");
            Iterator it = this.f21935w.iterator();
            while (it.hasNext()) {
                C6304b c6304b = (C6304b) it.next();
                stringBuilder.append(c6304b.f21906a).append(",").append(c6304b.f21907b).append(",").append(c6304b.f21908c).append(",").append(c6304b.f21909d).append(",").append(c6304b.f21910e).append(",").append(c6304b.f21911f).append("\n");
            }
        }
        if (this.f21938z == 7) {
            if (this.f21920h == 0) {
                stringBuilder.append(this.f21921i).append(HwAccountConstants.BLANK).append(this.f21922j).append(HwAccountConstants.BLANK).append(this.f21923k).append(HwAccountConstants.BLANK).append(this.f21924l).append(HwAccountConstants.BLANK).append(this.f21925m).append(HwAccountConstants.BLANK).append(this.f21926n).append(HwAccountConstants.BLANK).append(this.f21927o).append(HwAccountConstants.BLANK).append(this.f21928p).append("\n");
            } else if (this.f21920h == 1) {
                stringBuilder.append(this.f21921i).append(HwAccountConstants.BLANK).append(this.f21929q).append(HwAccountConstants.BLANK).append(this.f21930r).append(HwAccountConstants.BLANK).append(this.f21931s).append(HwAccountConstants.BLANK).append(this.f21932t).append(HwAccountConstants.BLANK).append(this.f21933u).append(HwAccountConstants.BLANK).append(this.f21934v).append("\n");
            }
        }
        C6324q.m28992a(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
