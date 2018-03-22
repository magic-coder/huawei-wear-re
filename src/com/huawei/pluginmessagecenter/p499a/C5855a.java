package com.huawei.pluginmessagecenter.p499a;

import java.util.HashMap;

/* compiled from: CommonUtil */
public class C5855a {
    private static HashMap<String, String> f20115a = new HashMap();

    public static void m27002a() {
        f20115a = new HashMap();
        f20115a.clear();
        f20115a.put(String.valueOf(5), "HW_B0");
        f20115a.put(String.valueOf(0), "HW_B1");
        f20115a.put(String.valueOf(1), "HW_B2");
        f20115a.put(String.valueOf(7), "HW_B3");
        f20115a.put(String.valueOf(2), "HW_K1");
        f20115a.put(String.valueOf(3), "HW_W1");
        f20115a.put(String.valueOf(10), "HW_WATCH2");
        f20115a.put(String.valueOf(8), "HW_S1");
        f20115a.put(String.valueOf(13), "HW_NYX");
        f20115a.put(String.valueOf(12), "HW_A1_PLUS");
        f20115a.put(String.valueOf(11), "HW_R1");
        f20115a.put(String.valueOf(14), "HW_GRUS");
        f20115a.put(String.valueOf(15), "HW_ERIS");
    }

    public static String m27001a(String str) {
        String str2 = "";
        if (f20115a == null || !f20115a.containsKey(str)) {
            return str2;
        }
        return (String) f20115a.get(str);
    }
}
