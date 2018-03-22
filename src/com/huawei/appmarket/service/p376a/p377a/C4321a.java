package com.huawei.appmarket.service.p376a.p377a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.service.p374d.p375a.C4306a;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class C4321a extends C4306a implements Serializable, Comparator<C4321a> {
    private static SimpleDateFormat f16069C = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    public int f16070A = 0;
    public int f16071B = 0;
    private Date f16072D = null;
    public String f16073a;
    public String f16074b;
    public String f16075c;
    public String f16076d;
    public String f16077e;
    public int f16078f;
    public String f16079g;
    public String f16080h;
    public String f16081i;
    public String f16082j;
    public int f16083k = 0;
    public int f16084l;
    public String f16085m;
    public String f16086n;
    public int f16087o;
    public int f16088p;
    public String f16089q;
    public String f16090r;
    public int f16091s;
    public String f16092t;
    public int f16093u = 2;
    public int f16094v = 0;
    public boolean f16095w = false;
    public String f16096x;
    public String f16097y;
    public String f16098z;

    private static Date m20824a(String str) {
        Date parse;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Date date = null;
        try {
            synchronized (f16069C) {
                try {
                    parse = f16069C.parse(str);
                    try {
                    } catch (Throwable th22) {
                        th = th22;
                        date = parse;
                        th3 = th;
                        try {
                            throw th3;
                        } catch (Throwable th32) {
                            th = th32;
                            parse = date;
                            th22 = th;
                        }
                    }
                } catch (Throwable th4) {
                    th32 = th4;
                    throw th32;
                }
            }
        } catch (Throwable th322) {
            th = th322;
            parse = null;
            th22 = th;
            C4241a.m20530a("ApkUpgradeInfo", "format Date failed:" + str, th22);
            return parse;
        }
    }

    public int m20825a(C4321a c4321a, C4321a c4321a2) {
        if (!(c4321a == null || c4321a2 == null)) {
            if (c4321a.f16072D == null) {
                c4321a.f16072D = C4321a.m20824a(c4321a.f16085m);
            }
            if (c4321a2.f16072D == null) {
                c4321a2.f16072D = C4321a.m20824a(c4321a2.f16085m);
            }
            if (c4321a.f16072D == null || c4321a2.f16072D == null) {
                C4241a.m20532b("ApkUpgradeInfo", "formatDate Result is Null");
                return 0;
            } else if (c4321a.f16072D.getTime() > c4321a2.f16072D.getTime()) {
                return -1;
            } else {
                if (c4321a.f16072D.getTime() == c4321a2.f16072D.getTime()) {
                    if (c4321a.f16094v > c4321a2.f16094v) {
                        return -1;
                    }
                    if (c4321a.f16094v < c4321a2.f16094v) {
                        return 1;
                    }
                    if (c4321a.f16078f > c4321a2.f16078f) {
                        return 1;
                    }
                    if (c4321a.f16078f == c4321a2.f16078f) {
                        return 0;
                    }
                    if (c4321a.f16078f < c4321a2.f16078f) {
                        return -1;
                    }
                }
                if (c4321a.f16072D.getTime() < c4321a2.f16072D.getTime()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m20825a((C4321a) obj, (C4321a) obj2);
    }

    public String toString() {
        return getClass().getName() + " {\n\tid_: " + this.f16073a + "\n\tname_: " + this.f16074b + "\n\tpackage_: " + this.f16075c + "\n\toldVersionName_: " + this.f16076d + "\n\tversion_: " + this.f16077e + "\n\tdiffSize_: " + this.f16078f + "\n\tdiffHash_: " + this.f16079g + "\n\toldHashCode: " + this.f16080h + "\n\toldMD5Code: " + this.f16081i + "\n\thash_: " + this.f16082j + "\n\tsameS_: " + this.f16083k + "\n\tsize_: " + this.f16084l + "\n\treleaseDate_: " + this.f16085m + "\n\ticon_: " + this.f16086n + "\n\toldVersionCode_: " + this.f16087o + "\n\tversionCode_: " + this.f16088p + "\n\tdownurl_: " + this.f16089q + "\n\tnewFeatures_: " + this.f16090r + "\n\tkindId_: " + this.f16091s + "\n\treleaseDateDesc_: " + this.f16092t + "\n\tstate_: " + this.f16093u + "\n\tapkReadySouce: " + this.f16094v + "\n\tisIgnore: " + this.f16095w + "\n\tdetailId_: " + this.f16096x + "\n\tprice_: " + this.f16097y + "\n\tproductId_: " + this.f16098z + "\n\tisAutoUpdate_: " + this.f16070A + "\n\tisCompulsoryUpdate_: " + this.f16071B + "\n}";
    }
}
