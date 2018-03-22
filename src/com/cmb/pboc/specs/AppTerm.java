package com.cmb.pboc.specs;

import com.cmb.pboc.global.PbocSW;
import com.cmb.pboc.global.PbocValue;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.scard.Scard;
import com.cmb.pboc.utils.ParseUtils;

public class AppTerm {
    private static volatile AppTerm f13508a;
    private static String f13509b = AppTerm.class.getSimpleName();
    private CardTerm f13510c = null;
    private Scard f13511d = null;

    private AppTerm(Scard scard) {
        this.f13511d = scard;
        this.f13510c = CardTerm.m17788a(this.f13511d);
        PbocLog.m17738a(f13509b, "Build AppTerm object.");
    }

    public static AppTerm m17784a(Scard scard) {
        if (f13508a == null) {
            synchronized (AppTerm.class) {
                if (f13508a == null) {
                    f13508a = new AppTerm(scard);
                }
            }
        }
        return f13508a;
    }

    private String[] m17785b() {
        String[] strArr = new String[5];
        byte[] a = this.f13510c.m17792a(2, 1);
        if (a == null) {
            PbocLog.m17741d(f13509b, "0201 record is null.");
            return null;
        }
        TLV tlv = new TLV(a, 0);
        a = tlv.m17794a(90).m17795a();
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "Main Pan is null.");
            return null;
        }
        String a2 = ParseUtils.m17796a(a);
        int lastIndexOf = a2.lastIndexOf(70);
        if (lastIndexOf != -1) {
            strArr[0] = a2.substring(0, lastIndexOf);
        } else {
            strArr[0] = a2;
        }
        a = tlv.m17794a(24372).m17795a();
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "Main Pan sn is null.");
            return null;
        }
        strArr[1] = ParseUtils.m17796a(a);
        a = this.f13510c.m17791a(40823);
        if (a == null) {
            PbocLog.m17741d(f13509b, "Top Amount is null.");
            return null;
        }
        a = new TLV(a, 0).m17795a();
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "topamount data is null.");
            return null;
        }
        strArr[2] = String.valueOf(Integer.valueOf(ParseUtils.m17796a(a)).intValue());
        a = this.f13510c.m17791a(40825);
        if (a == null) {
            PbocLog.m17741d(f13509b, "amount is null.");
            return null;
        }
        a = new TLV(a, 0).m17795a();
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "amount data is null.");
            return null;
        }
        strArr[3] = ParseUtils.m17796a(a);
        a = tlv.m17794a(24356).m17795a();
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "expdate is null.");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(ParseUtils.m17796a(a));
        stringBuilder.insert(stringBuilder.length() - 4, "年");
        stringBuilder.insert(stringBuilder.length() - 2, "月");
        stringBuilder.append("日");
        strArr[4] = stringBuilder.toString();
        return strArr;
    }

    public final String[] m17786a() {
        byte[] a = new TLV(this.f13510c.m17793a("325041592E5359532E4444463031"), 0).m17794a(79).m17795a();
        String a2 = ParseUtils.m17796a(a);
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "AID is null");
            return null;
        }
        PbocValue.f13422a = a2;
        PbocLog.m17739b(f13509b, "AID is: " + a2);
        byte[] a3 = this.f13510c.m17793a(a2);
        String a4 = ParseUtils.m17796a(a3);
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "PDOL is null.");
            return null;
        }
        PbocLog.m17739b(f13509b, "PDOL is: " + a4);
        a = new TLV(a3, 0).m17794a(80).m17795a();
        if (a == null || a.length <= 0) {
            PbocLog.m17741d(f13509b, "Bank type is null.");
            return null;
        }
        PbocLog.m17739b(f13509b, "bankType is: " + new String(a));
        return m17785b();
    }

    public final String[] m17787a(String str) {
        if (str == null) {
            return null;
        }
        byte[] a = this.f13510c.m17793a(str);
        if (a == null || 1 >= a.length) {
            PbocLog.m17741d(f13509b, "Select AID Resp null");
            return null;
        } else if (a[a.length - 2] == PbocSW.f13419a[0] && a[a.length - 1] == PbocSW.f13419a[1]) {
            return m17785b();
        } else {
            PbocLog.m17741d(f13509b, "Select AID error");
            return null;
        }
    }
}
