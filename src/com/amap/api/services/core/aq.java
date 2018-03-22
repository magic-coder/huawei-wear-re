package com.amap.api.services.core;

import android.content.Context;
import java.util.List;

/* compiled from: UpdateLogDBOperation */
public class aq {
    private ai f12361a = m16677a(this.f12362b);
    private Context f12362b;

    public aq(Context context) {
        this.f12362b = context;
    }

    private ai m16677a(Context context) {
        try {
            return new ai(context);
        } catch (Throwable th) {
            ay.m16709a(th, "UpdateLogDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public as m16678a() {
        try {
            if (this.f12361a == null) {
                this.f12361a = m16677a(this.f12362b);
            }
            List c = this.f12361a.m16645c("1=1", new ar());
            if (c.size() > 0) {
                return (as) c.get(0);
            }
        } catch (Throwable th) {
            ay.m16709a(th, "UpdateLogDB", "getUpdateLog");
            th.printStackTrace();
        }
        return null;
    }

    public void m16679a(as asVar) {
        if (asVar != null) {
            try {
                if (this.f12361a == null) {
                    this.f12361a = m16677a(this.f12362b);
                }
                ap arVar = new ar();
                arVar.mo4104a(asVar);
                String str = "1=1";
                List c = this.f12361a.m16645c(str, new ar());
                if (c == null || c.size() == 0) {
                    this.f12361a.m16642a(arVar);
                } else {
                    this.f12361a.m16644b(str, arVar);
                }
            } catch (Throwable th) {
                ay.m16709a(th, "UpdateLogDB", "updateLog");
                th.printStackTrace();
            }
        }
    }
}
