package com.google.tagmanager;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Runtime */
class ax implements az {
    final /* synthetic */ Map f14284a;
    final /* synthetic */ Map f14285b;
    final /* synthetic */ Map f14286c;
    final /* synthetic */ Map f14287d;
    final /* synthetic */ aw f14288e;

    ax(aw awVar, Map map, Map map2, Map map3, Map map4) {
        this.f14288e = awVar;
        this.f14284a = map;
        this.f14285b = map2;
        this.f14286c = map3;
        this.f14287d = map4;
    }

    public void mo4291a(au auVar, Set<at> set, Set<at> set2, ar arVar) {
        List list = (List) this.f14284a.get(auVar);
        List list2 = (List) this.f14285b.get(auVar);
        if (list != null) {
            set.addAll(list);
            arVar.mo4279c().mo4283a(list, list2);
        }
        list = (List) this.f14286c.get(auVar);
        list2 = (List) this.f14287d.get(auVar);
        if (list != null) {
            set2.addAll(list);
            arVar.mo4280d().mo4283a(list, list2);
        }
    }
}
