package com.fenda.hwbracelet.p258b.p259a;

import java.util.HashMap;
import java.util.UUID;

/* compiled from: GattService */
public class C3580c {
    public static final UUID f13701a = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
    private static HashMap<UUID, String> f13702b = new HashMap();

    static {
        f13702b.put(f13701a, "Nordic Rx Service");
    }

    public static String m17949a(UUID uuid, String str) {
        String str2 = (String) f13702b.get(uuid);
        return str2 == null ? str : str2;
    }
}
