package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

/* compiled from: EventBus */
class C2688d extends ThreadLocal<List<Object>> {
    final /* synthetic */ C2687c f9131a;

    C2688d(C2687c c2687c) {
        this.f9131a = c2687c;
    }

    protected /* synthetic */ Object initialValue() {
        return m12844a();
    }

    protected List<Object> m12844a() {
        return new ArrayList();
    }
}
