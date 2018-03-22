package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.model.AbilityIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1386b;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AbilitySet */
public class C1621a {
    private Context f4194a = null;
    private C1413d f4195b = null;
    private Gson f4196c = new Gson();

    public C1621a(Context context) {
        this.f4195b = C1417a.m6594a(context);
        this.f4194a = context;
    }

    public void m7672a(String str) {
        m7673b(str);
        if (this.f4195b != null) {
            C2538c.m12674b("AbilitySet", "=====Enter getAbilitySet devcieCode = " + str);
            AbilityIOModel abilityIOModel = new AbilityIOModel();
            abilityIOModel.deviceCode = str;
            this.f4195b.mo2467a(abilityIOModel, new C1622b(this, str));
        }
    }

    public void m7673b(String str) {
        C2538c.m12674b("AbilitySet", "=====Enter updateAbilitySet");
        C1490j.m6892b();
        if (!"".equals(str)) {
            Map map;
            HashMap hashMap = new HashMap();
            C1386b b = C1392h.m6290b(this.f4194a, C1492l.m6920d(str));
            if (b != null) {
                C2538c.m12674b("AbilitySet", "=====Enter updateAbilitySet table.ability:  " + b.f3030c);
                try {
                    map = (Map) this.f4196c.fromJson(b.f3030c, new C1623c(this).getType());
                } catch (JsonSyntaxException e) {
                    C2538c.m12674b("AbilitySet", e.getMessage());
                }
                C1490j.m6889a(map);
            }
            Object obj = hashMap;
            C1490j.m6889a(map);
        }
    }
}
