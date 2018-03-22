package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import android.content.Context;
import java.lang.reflect.Field;

/* compiled from: ResIDUtil */
public class C5483e {
    public static int m26187a(Context context, String str, String str2) {
        int i = 0;
        int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        try {
            Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
            return Integer.parseInt(field.get(field.getName()).toString());
        } catch (ClassNotFoundException e) {
            C5482d.m26186d("ResIDUtil", "ClassNotFoundException");
            return i;
        } catch (Exception e2) {
            C5482d.m26186d("ResIDUtil", e2.getMessage());
            return i;
        }
    }
}
