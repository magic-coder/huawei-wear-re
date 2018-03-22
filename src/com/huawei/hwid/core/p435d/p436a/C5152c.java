package com.huawei.hwid.core.p435d.p436a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VersionUpdateHelper */
public class C5152c {
    private static List<C5150a> f18585a = new ArrayList();

    static {
        f18585a.add(new C5153d());
        f18585a.add(new C5151b());
    }

    public static synchronized void m24838a(Context context) {
        synchronized (C5152c.class) {
            int parseInt;
            String b = C5176g.m25017b(context, "encryptversion");
            int i = -1;
            if (!TextUtils.isEmpty(b)) {
                try {
                    parseInt = Integer.parseInt(b);
                } catch (Exception e) {
                    C5165e.m24910d("VersionUpdateHelper", "parse encryptversion error:" + b);
                }
                C5165e.m24906b("VersionUpdateHelper", "old version is " + parseInt + ", current version is " + 3);
                if (parseInt < 3) {
                    for (C5150a a : f18585a) {
                        a.mo4635a(context, parseInt, 3);
                    }
                }
                C5176g.m25009a(context, "encryptversion", String.valueOf(3));
            }
            parseInt = i;
            C5165e.m24906b("VersionUpdateHelper", "old version is " + parseInt + ", current version is " + 3);
            if (parseInt < 3) {
                while (r3.hasNext()) {
                    a.mo4635a(context, parseInt, 3);
                }
            }
            C5176g.m25009a(context, "encryptversion", String.valueOf(3));
        }
    }
}
