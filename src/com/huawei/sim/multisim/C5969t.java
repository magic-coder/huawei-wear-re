package com.huawei.sim.multisim;

import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

import java.util.regex.Pattern;

/* compiled from: MultiSimUtils */
public class C5969t {
    public static String m27378a(String str) {
        if (str == null) {
            C2538c.d("number is null...", new Object[0]);
            return null;
        }
        if (str.matches("^((\\+86)|(86)|(0086))?[1][1-9]\\d{9}$")) {
            str = Pattern.compile("^((\\+86)|(86)|(0086))").matcher(str).replaceAll("").trim();
        }
        C2538c.b("MultiSimUtils", new Object[]{"getPhoneNumber:" + str});
        return str;
    }

    public static boolean m27380b(String str) {
        if (str.length() != 11) {
            return false;
        }
        return true;
    }

    public static boolean m27381c(String str) {
        String substring = str.substring(0, 3);
        if (substring.equals("130") || substring.equals("131") || substring.equals("132") || substring.equals("145") || substring.equals("155") || substring.equals("156") || substring.equals("186") || substring.equals("185") || substring.equals("176") || substring.equals("175") || substring.equals("171") || substring.equals("170")) {
            return true;
        }
        return false;
    }

    public static void m27379a(Context context) {
        context.startActivity(new Intent("android.settings.SETTINGS"));
    }
}
