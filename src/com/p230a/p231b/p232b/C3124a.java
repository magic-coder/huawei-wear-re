package com.p230a.p231b.p232b;

import com.p230a.p231b.p232b.p233a.C3065r;
import com.p230a.p231b.p232b.p233a.C3070q;
import com.p230a.p231b.p232b.p233a.C3112j;
import com.p230a.p231b.p232b.p233a.C3115m;
import com.p230a.p231b.p232b.p233a.C3118p;
import java.util.HashMap;
import java.util.Map;

public abstract class C3124a extends C3115m {
    private final C3065r f10474a;
    private HashMap f10475b;
    private Map f10476c;
    private String f10477d;

    public C3124a(int i, String str, C3065r c3065r, C3070q c3070q) {
        super(i, str, c3070q);
        this.f10476c = new HashMap();
        this.f10477d = str;
        this.f10476c = C3126c.m13916a().m13925a(this.f10477d);
        this.f10474a = c3065r;
        m13874a(false);
    }

    public C3124a(String str, HashMap hashMap, C3065r c3065r, C3070q c3070q) {
        this(1, str, c3065r, c3070q);
        this.f10475b = hashMap;
    }

    protected abstract C3118p mo3662a(C3112j c3112j);

    public Map mo3663a() {
        return this.f10476c;
    }

    protected void mo3664a(Object obj) {
        this.f10474a.mo3637a(obj);
    }

    public String mo3665b() {
        return "text/xml";
    }

    public byte[] mo3666c() {
        if (this.f10475b == null || this.f10475b.size() <= 0) {
            return super.mo3666c();
        }
        return C3126c.m13916a().m13927a(this.f10476c, C3126c.m13916a().m13926a(this.f10475b));
    }
}
