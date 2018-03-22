package com.huawei.hwid;

import com.huawei.hwid.core.datatype.HwAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ApplicationContext */
public final class C5062a {
    private static C5062a f18273a;
    private Map<String, List<String>> f18274b = new HashMap();
    private Map<String, ArrayList<HwAccount>> f18275c = new HashMap();
    private Map<String, Long> f18276d = new HashMap();
    private Map<String, Boolean> f18277e = new HashMap();
    private Map<String, Integer> f18278f = new HashMap();

    private C5062a() {
    }

    public static synchronized C5062a m24355a() {
        C5062a c5062a;
        synchronized (C5062a.class) {
            if (f18273a == null) {
                f18273a = new C5062a();
            }
            c5062a = f18273a;
        }
        return c5062a;
    }

    public List<String> m24362b() {
        return (List) this.f18274b.get("packageNamesNotUseApk");
    }

    public void m24361a(List<String> list) {
        this.f18274b.put("packageNamesNotUseApk", list);
    }

    public ArrayList<HwAccount> m24365c() {
        return (ArrayList) this.f18275c.get("accountMap");
    }

    public void m24360a(ArrayList<HwAccount> arrayList) {
        this.f18275c.put("accountMap", arrayList);
    }

    public long m24356a(String str) {
        if (this.f18276d.containsKey(str)) {
            return ((Long) this.f18276d.get(str)).longValue();
        }
        return 0;
    }

    public void m24358a(String str, long j) {
        this.f18276d.put(str, Long.valueOf(j));
    }

    public boolean m24363b(String str) {
        if (this.f18277e.containsKey(str)) {
            return ((Boolean) this.f18277e.get(str)).booleanValue();
        }
        return true;
    }

    public void m24359a(String str, boolean z) {
        this.f18277e.put(str, Boolean.valueOf(z));
    }

    public int m24364c(String str) {
        if (this.f18278f.containsKey(str)) {
            return ((Integer) this.f18278f.get(str)).intValue();
        }
        return 0;
    }

    public void m24357a(String str, int i) {
        this.f18278f.put(str, Integer.valueOf(i));
    }
}
