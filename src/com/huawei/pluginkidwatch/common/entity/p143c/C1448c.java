package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Context;
import android.os.Build;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.model.AppProfileModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: PushAbilityUtil */
public class C1448c {
    private Context f3330a;

    public C1448c(Context context) {
        this.f3330a = context.getApplicationContext();
    }

    public void m6682a(Context context) {
        AppProfileModel appProfileModel = new AppProfileModel();
        appProfileModel.appVersion = C1483c.m6823a(this.f3330a);
        appProfileModel.phoneManufacturer = Build.BRAND;
        appProfileModel.phoneModel = Build.MODEL;
        C2538c.m12674b("PushAbilityUtil", "model = " + appProfileModel.toString());
        C1417a.m6594a(context).mo2470a(appProfileModel, new C1449d(this));
    }
}
