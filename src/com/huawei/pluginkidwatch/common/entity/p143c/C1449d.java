package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.AppProfileModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.p138a.C1402r;
import com.huawei.pluginkidwatch.common.p138a.C1403s;

/* compiled from: PushAbilityUtil */
class C1449d implements C1378e {
    final /* synthetic */ C1448c f3331a;

    C1449d(C1448c c1448c) {
        this.f3331a = c1448c;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        AppProfileModel appProfileModel = (AppProfileModel) baseEntityModel;
        if (appProfileModel == null || appProfileModel.appAbilityMap == null || !appProfileModel.appAbilityMap.containsKey("1") || !appProfileModel.appAbilityMap.containsKey("2") || appProfileModel.appAbilityMap.get("1") == null || appProfileModel.appAbilityMap.get("2") == null) {
            C2538c.m12680e("PushAbilityUtil", "param is null");
            return;
        }
        int intValue = ((Integer) appProfileModel.appAbilityMap.get("1")).intValue();
        int intValue2 = ((Integer) appProfileModel.appAbilityMap.get("2")).intValue();
        C2538c.m12674b("PushAbilityUtil", "kitPush = " + intValue);
        C2538c.m12674b("PushAbilityUtil", "messagePush = " + intValue2);
        C1402r c1402r = new C1402r(this.f3331a.f3330a);
        C1403s c = c1402r.m6399c();
        if (intValue != c.m6400a() || intValue2 != c.m6402b()) {
            c = new C1403s();
            c.m6401a(intValue);
            c.m6403b(intValue2);
            c1402r.m6396a(c);
            Intent intent = new Intent();
            intent.setAction("com.huawei.bone.action.pushabilty");
            this.f3331a.f3330a.sendBroadcast(intent, "com.huawei.bone.permission.LOCAL_BROADCAST");
        }
    }
}
