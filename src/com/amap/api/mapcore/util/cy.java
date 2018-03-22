package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class cy {
    private co f11649a;
    private Context f11650b;

    public cy(Context context, boolean z) {
        this.f11650b = context;
        this.f11649a = m15964a(this.f11650b, z);
    }

    private co m15964a(Context context, boolean z) {
        try {
            return new co(context, cu.m15942a());
        } catch (Throwable th) {
            if (z) {
                th.printStackTrace();
                return null;
            }
            ca.m15831a(th, "SDKDB", "getDB");
            return null;
        }
    }

    public void m15966a(bv bvVar) {
        if (bvVar != null) {
            try {
                if (this.f11649a == null) {
                    this.f11649a = m15964a(this.f11650b, false);
                }
                cp czVar = new cz();
                czVar.mo4031a(bvVar);
                String a = cz.m15967a(bvVar.m15791a());
                List c = this.f11649a.m15927c(a, new cz());
                if (c == null || c.size() == 0) {
                    this.f11649a.m15919a(czVar);
                } else {
                    this.f11649a.m15926b(a, czVar);
                }
            } catch (Throwable th) {
                ca.m15831a(th, "SDKDB", "insert");
                th.printStackTrace();
            }
        }
    }

    public List<bv> m15965a() {
        List<bv> list = null;
        try {
            cp czVar = new cz();
            list = this.f11649a.m15925b(cz.m15970c(), czVar, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }
}
