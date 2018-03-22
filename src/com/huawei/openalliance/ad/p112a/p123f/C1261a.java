package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.listener.AdListener;
import com.huawei.openalliance.ad.p112a.p113a.C1214a;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1218d;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1230p;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1233s;
import com.huawei.openalliance.ad.p112a.p116b.C1243a;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p121e.C1256h;
import com.huawei.openalliance.ad.p112a.p121e.C1258j;
import com.huawei.openalliance.ad.p112a.p122h.C1283a;
import com.huawei.openalliance.ad.p112a.p122h.C1286d;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p125g.C1278b;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.List;

public class C1261a {

    class C1260a implements Runnable {
        private Context f2675a;
        private C1235b f2676b;
        private int f2677c;
        private C1216b f2678d;
        private C1216b f2679e;

        public C1260a(Context context, C1235b c1235b, int i, C1216b c1216b, C1216b c1216b2) {
            this.f2675a = context;
            this.f2676b = c1235b;
            this.f2677c = i;
            this.f2678d = c1216b;
            this.f2679e = c1216b2;
        }

        public void run() {
            if (C1261a.m5584b(this.f2676b)) {
                for (C1215a c1215a : this.f2676b.getMultiad__()) {
                    if (200 == c1215a.getRetcode30__() && C1261a.m5583b(c1215a)) {
                        for (C1221g a : c1215a.getContent__()) {
                            C1249b.m5536a(this.f2675a, this.f2677c, a, this.f2678d, this.f2679e);
                        }
                    }
                }
            }
            C1255g.m5564a(this.f2675a, this.f2676b.getInvalidcontentid__());
            C1258j.m5575a(this.f2675a, this.f2676b.getInvalidSloganId__());
            C1256h.m5569a(this.f2675a, this.f2676b.getTodayNoShowContentid__());
        }
    }

    public static void m5577a(Context context, int i, List<C1233s> list) {
        if (list != null && !list.isEmpty()) {
            if (200 == i || 206 == i || 204 == i) {
                for (C1233s c1233s : list) {
                    if (!(c1233s == null || TextUtils.isEmpty(c1233s.getSha256__()))) {
                        if (2 == c1233s.getCreativetype__() || 4 == c1233s.getCreativetype__()) {
                            C1258j.m5574a(context, c1233s);
                        }
                    }
                }
            }
        }
    }

    public static void m5578a(Context context, int i, List<String> list, AdListener adListener, C1278b c1278b, boolean z, int i2, int i3, Handler handler) {
        if (C1287e.m5683a(context)) {
            int a = C1283a.m5645a(context).m5651a(i2);
            int b = C1283a.m5645a(context).m5653b(i2);
            List arrayList = new ArrayList(4);
            for (String c1218d : list) {
                arrayList.add(new C1218d(c1218d, a, b, i, z));
            }
            C1212b c1214a = new C1214a(context, arrayList, C1256h.m5571b(context), C1258j.m5573a(context), a, b, i3);
            C1216b c1216b = new C1216b();
            c1216b.setType__("request");
            C1216b c1216b2 = new C1216b();
            c1216b2.setType__("response");
            try {
                new C1286d(context, C1243a.f2655c, c1214a, new C1262b(c1278b, handler, adListener, i, c1216b, c1216b2)).executeOnExecutor(C1366j.f2949a, new Void[0]);
            } catch (Exception e) {
                C1336d.m5888c("AdContent", "request ad fail");
            }
        }
    }

    public static boolean m5579a(Context context, C1235b c1235b, int i, Handler handler) {
        if (context == null || c1235b == null || handler == null || !C1261a.m5584b(c1235b)) {
            return false;
        }
        C1215a c1215a = (C1215a) c1235b.getMultiad__().get(0);
        if (c1215a == null || !C1261a.m5583b(c1215a)) {
            return false;
        }
        C1221g c1221g = (C1221g) c1215a.getContent__().get(0);
        if (c1221g == null) {
            return false;
        }
        if (2 != c1221g.getCreativetype__() && 4 != c1221g.getCreativetype__()) {
            return false;
        }
        C1256h.m5568a(context, c1215a.getSlotid__(), i, c1221g, handler, false);
        return true;
    }

    public static void m5582b(Context context, int i, List<C1230p> list) {
        if (context != null && 2 == C1283a.m5645a(context).m5658g()) {
            for (C1230p c1230p : list) {
                if (c1230p != null && (2 == c1230p.getCreativetype__() || 4 == c1230p.getCreativetype__())) {
                    C1221g c1221g = new C1221g(c1230p);
                    C1256h.m5568a(context, c1230p.getSlotid__(), i, c1221g, null, true);
                }
            }
        }
    }

    private static boolean m5583b(C1215a c1215a) {
        return (c1215a.getContent__() == null || c1215a.getContent__().isEmpty()) ? false : true;
    }

    private static boolean m5584b(C1235b c1235b) {
        return (c1235b.getMultiad__() == null || c1235b.getMultiad__().isEmpty()) ? false : true;
    }
}
