package com.huawei.pluginkidwatch.p137a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.p139a.C1414c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: KidWatchUtil */
final class C1380c implements C1378e {
    final /* synthetic */ C1414c f2972a;
    final /* synthetic */ Context f2973b;

    C1380c(C1414c c1414c, Context context) {
        this.f2972a = c1414c;
        this.f2973b = context;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        CommonRetOModel commonRetOModel = (CommonRetOModel) baseEntityModel;
        if (commonRetOModel.retCode != 0 || commonRetOModel.data == null || "".equals(commonRetOModel.data)) {
            C2538c.m12674b("KidWatchUtil", "============requestPhoneNumber_failed");
            C1497q.m6942a(this.f2973b, "sharedpreferences_exist_phone_number", Boolean.valueOf(false));
            return;
        }
        C2538c.m12674b("KidWatchUtil", "============requestPhoneNumber_exist");
        C1377a.m6172b(this.f2972a, this.f2973b);
    }
}
