package com.huawei.hwid.core.p435d;

import android.content.Context;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.Field;

/* compiled from: ResourceLoader */
public class C5180k {
    public static int m25028a(Context context, String str, String str2) {
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
            C5165e.m24906b("ResourceLoader", "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
            return identifier;
        } catch (Throwable e) {
            C5165e.m24911d("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2, e);
            return 0;
        } catch (Throwable e2) {
            C5165e.m24911d("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (Throwable e22) {
            C5165e.m24911d("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2, e22);
            return 0;
        } catch (Throwable e222) {
            C5165e.m24911d("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2, e222);
            return 0;
        } catch (Throwable e2222) {
            C5165e.m24911d("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2, e2222);
            return 0;
        } catch (Throwable e22222) {
            C5165e.m24911d("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2, e22222);
            return 0;
        }
    }

    public static int m25027a(Context context, String str) {
        return C5180k.m25028a(context, ResUtil.TYPE_STRING, str);
    }

    public static int m25029b(Context context, String str) {
        return C5180k.m25028a(context, "xml", str);
    }

    public static int m25030c(Context context, String str) {
        return C5180k.m25028a(context, ResUtil.TYPE_ARRAY, str);
    }

    public static int m25031d(Context context, String str) {
        return C5180k.m25028a(context, ResUtil.TYPE_LAYOUT, str);
    }

    public static int m25032e(Context context, String str) {
        return C5180k.m25028a(context, "id", str);
    }

    public static int m25033f(Context context, String str) {
        return C5180k.m25028a(context, "menu", str);
    }
}
