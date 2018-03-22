package cmb.pb.cmbsafe;

import cmb.pb.ui.cmbwidget.CmbEditText;
import java.util.HashMap;

public final class C2862b {
    public static HashMap f9243a = new HashMap();
    public static HashMap f9244b = new HashMap();
    private static String f9245c;

    public static CmbEditText m12958a() {
        return (CmbEditText) f9243a.get(Long.valueOf(1));
    }

    public static void m12959a(CmbEditText cmbEditText) {
        f9243a.clear();
        f9243a.put(Long.valueOf(1), cmbEditText);
    }

    public static void m12960a(Object obj) {
        f9244b.clear();
        f9244b.put(Long.valueOf(1), obj);
    }

    public static void m12961a(String str) {
        f9245c = str;
    }

    public static String m12962b() {
        return f9245c;
    }
}
