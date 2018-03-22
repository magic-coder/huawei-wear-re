package com.huawei.pluginkidwatch.home.p156b;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AbilityIOModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1386b;
import com.huawei.pluginkidwatch.common.p138a.C1392h;

/* compiled from: AbilitySet */
class C1622b implements C1378e {
    final /* synthetic */ String f4197a;
    final /* synthetic */ C1621a f4198b;

    C1622b(C1621a c1621a, String str) {
        this.f4198b = c1621a;
        this.f4197a = str;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (!this.f4197a.equals(C1462f.m6746j())) {
            C2538c.m12674b("AbilitySet", "===== getAbilitySet warning: request deviceCode: " + this.f4197a + "  changed current devcieCode: " + C1462f.m6746j());
        } else if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("AbilitySet", "=====getAbilitySet  Error!!!");
        } else {
            AbilityIOModel abilityIOModel = (AbilityIOModel) baseEntityModel;
            C1386b c1386b;
            if (abilityIOModel.data != null) {
                C2538c.m12674b("AbilitySet", "===== getAbilitySet model.data.toString():" + abilityIOModel.data.toString());
                c1386b = new C1386b();
                c1386b.f3029b = C1492l.m6920d(this.f4197a);
                c1386b.f3028a = C1462f.m6750l();
                c1386b.f3030c = this.f4198b.f4196c.toJson(abilityIOModel.data);
                C1490j.m6889a(abilityIOModel.data);
                C1392h.m6278a(this.f4198b.f4194a, c1386b);
                return;
            }
            C2538c.m12674b("AbilitySet", "===== getAbilitySet model.data is null clearAbilitySetMap !");
            C1490j.m6892b();
            c1386b = new C1386b();
            c1386b.f3029b = C1492l.m6920d(C1462f.m6746j());
            c1386b.f3028a = C1462f.m6750l();
            c1386b.f3030c = "";
            C1392h.m6278a(this.f4198b.f4194a, c1386b);
        }
    }
}
