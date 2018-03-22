package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: UpdateLogDBOperation */
public class da {
    private co f11669a = m15986a(this.f11670b);
    private Context f11670b;

    public da(Context context) {
        this.f11670b = context;
    }

    private co m15986a(Context context) {
        try {
            return new co(context, cu.m15942a());
        } catch (Throwable th) {
            ca.m15831a(th, "UpdateLogDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public dc m15987a() {
        try {
            if (this.f11669a == null) {
                this.f11669a = m15986a(this.f11670b);
            }
            List c = this.f11669a.m15927c("1=1", new db());
            if (c.size() > 0) {
                return (dc) c.get(0);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "UpdateLogDB", "getUpdateLog");
            th.printStackTrace();
        }
        return null;
    }

    public void m15988a(dc dcVar) {
        if (dcVar != null) {
            try {
                if (this.f11669a == null) {
                    this.f11669a = m15986a(this.f11670b);
                }
                cp dbVar = new db();
                dbVar.mo4031a(dcVar);
                String str = "1=1";
                List c = this.f11669a.m15927c(str, new db());
                if (c == null || c.size() == 0) {
                    this.f11669a.m15919a(dbVar);
                } else {
                    this.f11669a.m15926b(str, dbVar);
                }
            } catch (Throwable th) {
                ca.m15831a(th, "UpdateLogDB", "updateLog");
                th.printStackTrace();
            }
        }
    }
}
