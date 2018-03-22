package com.huawei.hwdatamigrate.hihealth.p414f;

import android.content.Context;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcommonmodel.application.BaseApplication;

/* compiled from: MigrateWearFactory */
public class C4905o {
    public static C4891a m23724a(Context context, String str) {
        if (str == null) {
            return C4896f.m23673a(context);
        }
        if ("".equals(str)) {
            return null;
        }
        if (i.a(57)) {
            return C4901k.m23704a(BaseApplication.b(), str, Boolean.valueOf(true));
        }
        return C4901k.m23704a(BaseApplication.b(), str, Boolean.valueOf(false));
    }
}
