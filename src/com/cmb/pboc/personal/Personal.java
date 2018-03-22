package com.cmb.pboc.personal;

import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.scard.Scard;
import com.snowballtech.apdu.smartdevice_oma.constant.SmartDeviceCode;

public class Personal {
    public static boolean f13481a;
    public static boolean f13482b;
    public static boolean f13483c;
    private static String f13484d = Personal.class.getSimpleName();

    public static int m17775a(Scard scard, int i, String str) {
        boolean z = false;
        if (str == null || 1 > str.length()) {
            return 1;
        }
        if (scard == null) {
            return 8;
        }
        PbocLog.m17738a(f13484d, "Execute perso init script");
        f13481a = false;
        f13483c = false;
        try {
            PersonalPkg personalPkg = new PersonalPkg(scard, 1, str);
            try {
                personalPkg.m17780c();
                if (personalPkg.m17778a()) {
                    f13481a = true;
                    PbocLog.m17739b(f13484d, "Personal initial success.");
                } else {
                    f13481a = false;
                    PbocLog.m17741d(f13484d, "Personal initial failed.");
                    String b = personalPkg.m17779b();
                    if (b == null || b.length() < 4) {
                        f13483c = true;
                        z = true;
                    } else {
                        b = b.substring(b.length() - 4);
                        z = (b == null || b.length() <= 0) ? true : b.equalsIgnoreCase("A286") ? true : b.equalsIgnoreCase("A628") ? true : b.equalsIgnoreCase(SmartDeviceCode.AID_NOT_EXIST) ? true : b.equalsIgnoreCase("6985") ? true : b.equalsIgnoreCase("A862") ? true : b.equalsIgnoreCase("0000") ? true : true;
                    }
                }
                return z;
            } catch (Exception e) {
                PbocLog.m17741d(f13484d, e.getMessage());
                return 3;
            }
        } catch (Exception e2) {
            PbocLog.m17741d(f13484d, e2.getMessage());
            return 2;
        }
    }

    public static int m17776b(Scard scard, int i, String str) {
        if (str == null || 1 > str.length()) {
            return 1;
        }
        if (scard == null) {
            return 8;
        }
        PbocLog.m17738a(f13484d, "Execute perso script");
        f13482b = false;
        f13483c = false;
        try {
            PersonalPkg personalPkg = new PersonalPkg(scard, i, str);
            try {
                personalPkg.m17780c();
                if (personalPkg.m17778a()) {
                    f13482b = true;
                    PbocLog.m17739b(f13484d, "Package num: " + i + " execute successful.");
                    return 0;
                }
                f13482b = false;
                PbocLog.m17741d(f13484d, "Package num: " + i + " execute failed.");
                return 11;
            } catch (Exception e) {
                PbocLog.m17741d(f13484d, e.getMessage());
                return 3;
            }
        } catch (Exception e2) {
            PbocLog.m17741d(f13484d, e2.getMessage());
            return 2;
        }
    }
}
