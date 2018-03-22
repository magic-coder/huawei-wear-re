package com.p230a.p231b.p232b;

import com.google.gson.Gson;
import com.p230a.p231b.p232b.p233a.C3065r;
import com.p230a.p231b.p232b.p233a.C3070q;
import com.p230a.p231b.p232b.p233a.C3112j;
import com.p230a.p231b.p232b.p233a.C3114l;
import com.p230a.p231b.p232b.p233a.C3118p;
import com.p230a.p231b.p232b.p233a.p236a.C3093f;
import com.p230a.p231b.p237c.C3129b;
import java.util.HashMap;

public class C3125b extends C3124a {
    public C3125b(String str, HashMap hashMap, C3065r c3065r, C3070q c3070q) {
        super(str, hashMap, c3065r, c3070q);
        Gson gson = new Gson();
    }

    protected C3118p mo3662a(C3112j c3112j) {
        try {
            return C3118p.m13903a(C3129b.m13935b(C3126c.m13916a().m13924a(c3112j, m13881f())), C3093f.m13830a(c3112j));
        } catch (Throwable e) {
            return C3118p.m13902a(new C3114l(e));
        }
    }
}
