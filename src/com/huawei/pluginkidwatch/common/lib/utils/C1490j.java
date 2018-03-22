package com.huawei.pluginkidwatch.common.lib.utils;

import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: K1AbilitySetUtil */
public class C1490j {
    private static String f3461a = "";
    private static Map<String, Object> f3462b = new HashMap();

    public static Map<String, Object> m6888a() {
        return f3462b;
    }

    public static void m6889a(Map<String, Object> map) {
        f3462b = map;
    }

    public static void m6892b() {
        if (f3462b != null) {
            f3462b.clear();
        }
    }

    public static boolean m6890a(String str) {
        String str2 = "";
        if (f3462b == null || f3462b.isEmpty() || !f3462b.containsKey("abilityRet")) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility abilitySetMap is null");
            return false;
        }
        C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility abilitySetMap = " + f3462b.toString());
        Map map = f3462b.get("abilityRet") instanceof Map ? (Map) f3462b.get("abilityRet") : null;
        if (map != null) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility abilityOne = " + map.toString());
        }
        if (map == null || map.isEmpty() || !map.containsKey("ability")) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility abilityOne is null");
            return false;
        }
        Map map2;
        if (map.get("ability") instanceof Map) {
            map2 = (Map) map.get("ability");
        } else {
            map2 = null;
        }
        if (map2 != null) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility abilityTwo = " + map2.toString());
        }
        if (map2 == null || map2.isEmpty() || !map2.containsKey("data") || !map2.containsKey("type")) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility abilityTwo is null");
            return false;
        }
        Object obj;
        if (map2.get("type") instanceof String) {
            obj = (String) map2.get("type");
        } else {
            obj = null;
        }
        if (obj == null || !"1".equals(obj)) {
            map = null;
        } else {
            if (map2.get("data") instanceof Map) {
                map = (Map) map2.get("data");
            } else {
                map = null;
            }
            if (map != null) {
                C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility data = " + map.toString());
            }
        }
        if (map == null || map.isEmpty() || !map.containsKey(str)) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility data is null");
            return false;
        }
        boolean z;
        obj = map.get(str);
        if (obj != null) {
            str2 = obj.toString();
            C2538c.m12674b("K1AbilitySetUtil", "===== haveSpecifyAbility support Ability : " + str);
            if ("1".equals(str2)) {
                z = true;
                return z;
            }
        }
        z = false;
        return z;
    }

    public static int m6891b(String str) {
        if (f3462b == null || f3462b.isEmpty() || !f3462b.containsKey("abilityRet")) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility abilitySetMap is null");
            return -1;
        }
        C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility abilitySetMap = " + f3462b.toString());
        Map map = f3462b.get("abilityRet") instanceof Map ? (Map) f3462b.get("abilityRet") : null;
        if (map != null) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility abilityOne = " + map.toString());
        }
        if (map == null || map.isEmpty() || !map.containsKey("ability")) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility abilityOne is null");
            return -1;
        }
        Map map2;
        if (map.get("ability") instanceof Map) {
            map2 = (Map) map.get("ability");
        } else {
            map2 = null;
        }
        if (map2 != null) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility abilityTwo = " + map2.toString());
        }
        if (map2 == null || map2.isEmpty() || !map2.containsKey("data") || !map2.containsKey("type")) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility abilityTwo is null");
            return -1;
        }
        Object obj;
        if (map2.get("type") instanceof String) {
            obj = (String) map2.get("type");
        } else {
            obj = null;
        }
        if (obj == null || !"1".equals(obj)) {
            map = null;
        } else {
            if (map2.get("data") instanceof Map) {
                map = (Map) map2.get("data");
            } else {
                map = null;
            }
            if (map != null) {
                C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility data = " + map.toString());
            }
        }
        if (map == null || map.isEmpty() || !map.containsKey(str)) {
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility data is null");
            return -1;
        }
        int d;
        obj = map.get(str);
        if (obj != null) {
            d = C1492l.m6920d(obj.toString());
            C2538c.m12674b("K1AbilitySetUtil", "===== haveNumSpecifyAbility support Ability : " + str);
        } else {
            d = -1;
        }
        return d;
    }
}
