package com.fenda.hwbracelet.p258b.p259a;

import java.util.HashMap;
import java.util.UUID;

/* compiled from: GattCharacteristic */
public class C3578a {
    public static final UUID f13696a = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");
    public static final UUID f13697b = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
    private static HashMap<UUID, String> f13698c = new HashMap();

    static {
        f13698c.put(f13696a, "Nordic Tx Data");
        f13698c.put(f13697b, "Nordic Rx Data");
    }

    public static String m17948a(UUID uuid, String str) {
        String str2 = (String) f13698c.get(uuid);
        return str2 == null ? str : str2;
    }
}
