package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p208d.p211c.ah;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2990h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

final class ag implements C2904g {
    private final /* synthetic */ List f10263a;
    private final /* synthetic */ int f10264b;
    private final /* synthetic */ boolean f10265c;

    ag(List list, int i, boolean z) {
        this.f10263a = list;
        this.f10264b = i;
        this.f10265c = z;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length == 2 && "0".equals(String.valueOf(objArr[0]))) {
                    Set a = C3048m.m13630a(this.f10263a);
                    if (!(a == null || a.isEmpty())) {
                        int i = this.f10264b;
                        if (!(a == null || a.isEmpty())) {
                            int size = a.size();
                            String str = "scene_id IN(" + ah.m13243a(size) + ") AND sceneType" + "=?";
                            String[] strArr = (String[]) a.toArray(new String[(size + 1)]);
                            strArr[size] = String.valueOf(i);
                            C2922b.m13133a("tb_scene_config", C2921a.m13130a(null, "isCheck", "1"), str, strArr);
                        }
                        if (this.f10265c) {
                            cn.com.xy.sms.sdk.p208d.p211c.ag.m13241a(a);
                        }
                        C3048m.m13636b(this.f10263a);
                    }
                    HashMap e = C2990h.m13441e(objArr[1].toString());
                    if (e != null) {
                        ArrayList arrayList = (ArrayList) e.get("sceneconfigList");
                        new StringBuilder("处理回来的 sceneconfigList=").append(arrayList);
                        C3048m.m13632a(arrayList, this.f10264b);
                        arrayList = (ArrayList) e.get("sceneUrllist");
                        new StringBuilder("处理回来的 sceneUrllist=").append(arrayList);
                        C3048m.m13634a(this.f10263a, arrayList, this.f10264b);
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "SceneconfigUtil doRequestScenceConfig callback handle error:" + th.getMessage(), th);
            }
        }
    }
}
