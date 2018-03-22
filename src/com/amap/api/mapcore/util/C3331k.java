package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapDataVerify */
public class C3331k extends Thread {
    private Context f11810a;
    private C3345z f11811b;

    public C3331k(Context context) {
        this.f11810a = context;
        this.f11811b = C3345z.m16317a(context);
    }

    public void run() {
        m16186a();
    }

    private void m16186a() {
        ArrayList arrayList = new ArrayList();
        ArrayList a = this.f11811b.m16322a();
        if (a.size() < 1) {
            a = m16185a(this.f11810a);
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            C3337r c3337r = (C3337r) it.next();
            if (!(c3337r == null || c3337r.m16244c() == null || c3337r.m16251f().length() < 1)) {
                if (Thread.interrupted()) {
                    break;
                } else if (c3337r.f11829a == 4 && !m16187a(c3337r.m16251f())) {
                    c3337r.m16240b();
                    try {
                        ag.m15454a(c3337r.m16251f(), this.f11810a);
                    } catch (Exception e) {
                        ag.m15456b("verify: " + c3337r.m16244c() + "delete failed");
                    }
                    ag.m15456b("verify: " + c3337r.m16244c() + "sdCard don't have");
                    arrayList.add(c3337r);
                }
            }
        }
        C3328h.m16149a(this.f11810a).m16165a(arrayList);
    }

    private ArrayList<C3337r> m16185a(Context context) {
        ArrayList<C3337r> arrayList = new ArrayList();
        File file = new File(bk.m15673b(context));
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().endsWith(".zip.tmp.dt")) {
                        C3337r a = m16184a(file2);
                        if (!(a == null || a.m16244c() == null)) {
                            arrayList.add(a);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private C3337r m16184a(File file) {
        String a = bk.m15655a(file);
        C3337r c3337r = new C3337r();
        c3337r.m16258i(a);
        return c3337r;
    }

    private boolean m16187a(String str) {
        List<String> a = this.f11811b.m16323a(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bk.m15654a(this.f11810a));
        stringBuilder.append("vmap/");
        int length = stringBuilder.length();
        for (String replace : a) {
            stringBuilder.replace(length, stringBuilder.length(), replace);
            if (!new File(stringBuilder.toString()).exists()) {
                return false;
            }
        }
        return true;
    }

    public void destroy() {
        this.f11810a = null;
        this.f11811b = null;
    }
}
