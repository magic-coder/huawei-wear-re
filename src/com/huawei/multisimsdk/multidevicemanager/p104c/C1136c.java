package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: CarrierSupportManager */
public class C1136c {
    private static HashMap<String, String> f2403a = new HashMap();
    private static ArrayList<String> f2404b = new ArrayList();

    public static C1136c m5058a() {
        return C1138e.f2405a;
    }

    private C1136c() {
    }

    public void m5060a(Context context) {
        if (context != null) {
            String[] stringArray = context.getResources().getStringArray(c.MMS_AUTH_SUPPORT_OPERATOR);
            String[] stringArray2 = context.getResources().getStringArray(c.MMS_AUTH_SUPPORT_NUMBER);
            if (stringArray2 != null && stringArray != null && stringArray2.length == stringArray.length) {
                int length = stringArray2.length;
                for (int i = 0; i < length; i++) {
                    Object obj = stringArray2[i];
                    if (!f2404b.contains(obj)) {
                        f2404b.add(obj);
                    }
                    if (!f2403a.containsKey(obj)) {
                        f2403a.put(obj, stringArray[i]);
                    }
                }
            }
        }
    }

    public boolean m5061a(Context context, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(m5059c(context, str))) {
            return false;
        }
        return true;
    }

    public String m5062b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c = m5059c(context, str);
        if (TextUtils.isEmpty(str)) {
            return c;
        }
        return (String) f2403a.get(c);
    }

    private String m5059c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        if (f2404b.isEmpty()) {
            m5060a(context);
        }
        Iterator it = f2404b.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (str.matches(str2)) {
                break;
            }
        }
        str2 = null;
        return str2;
    }
}
