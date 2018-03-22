package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* compiled from: OfflineMapRemoveTask */
public class C3334n {
    private Context f11823a;

    public C3334n(Context context) {
        this.f11823a = context;
    }

    public void m16219a(C3323g c3323g) {
        m16218b(c3323g);
    }

    private boolean m16218b(C3323g c3323g) {
        if (c3323g == null) {
            return false;
        }
        boolean a = m16217a(c3323g.getAdcode(), this.f11823a);
        if (a) {
            c3323g.m16130h();
            return a;
        }
        c3323g.m16129g();
        return false;
    }

    private boolean m16217a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> b = C3345z.m16317a(context).m16328b(str);
        String a = bk.m15654a(context);
        for (String str2 : b) {
            try {
                File file = new File(a + "vmap/" + str2);
                if (file.exists() && !ag.m15457b(file)) {
                    ag.m15453a("deleteDownload delete some thing wrong!");
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        try {
            ag.m15461d(a + "vmap/");
            ag.m15454a(str, context);
            return true;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e22) {
            e22.printStackTrace();
            return false;
        }
    }
}
