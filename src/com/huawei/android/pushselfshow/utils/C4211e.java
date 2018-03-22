package com.huawei.android.pushselfshow.utils;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.crowdtestsdk.utils.ResUtil;
import java.lang.reflect.Field;

public class C4211e {
    public static int m20460a(Context context, String str) {
        return C4211e.m20461a(context, ResUtil.TYPE_STRING, str);
    }

    public static int m20461a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
            identifier = Integer.parseInt(field.get(field.getName()).toString());
            if (identifier != 0) {
                return identifier;
            }
            e.b("ResourceLoader", "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
            return identifier;
        } catch (Throwable e) {
            e.c("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e);
            return 0;
        } catch (Throwable e2) {
            e.c("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (Throwable e22) {
            e.c("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e22);
            return 0;
        } catch (Throwable e222) {
            e.c("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e222);
            return 0;
        } catch (Throwable e2222) {
            e.c("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e2222);
            return 0;
        }
    }

    public static int m20462b(Context context, String str) {
        return C4211e.m20461a(context, ResUtil.TYPE_LAYOUT, str);
    }

    public static int m20463c(Context context, String str) {
        return C4211e.m20461a(context, "id", str);
    }

    public static int m20464d(Context context, String str) {
        return C4211e.m20461a(context, "color", str);
    }

    public static int m20465e(Context context, String str) {
        return C4211e.m20461a(context, ResUtil.TYPE_DRAWABLE, str);
    }
}
