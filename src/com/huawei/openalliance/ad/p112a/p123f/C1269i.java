package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.CubeParameters;
import com.huawei.openalliance.ad.inter.listener.MagLockListener;
import com.huawei.openalliance.ad.p112a.p113a.C1214a;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1218d;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1222h;
import com.huawei.openalliance.ad.p112a.p116b.C1243a;
import com.huawei.openalliance.ad.p112a.p122h.C1286d;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.p112a.p125g.C1278b;
import com.huawei.openalliance.ad.p112a.p125g.C1280d;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.List;

public class C1269i extends C1265e {
    private Context f2695b;
    private List<String> f2696c;
    private int f2697d;
    private int f2698e;
    private MagLockListener f2699f;
    private C1278b f2700g;
    private boolean f2701h;
    private List<String> f2702i;
    private List<String> f2703j;
    private CubeParameters f2704k;

    public C1269i() {
        this.f2696c = new ArrayList(4);
        this.a = 2;
    }

    public C1269i(Context context, List<String> list, int i, int i2, MagLockListener magLockListener, boolean z) {
        this.f2696c = new ArrayList(4);
        this.f2695b = context;
        this.f2696c = list;
        this.f2697d = i;
        this.f2698e = i2;
        this.f2699f = magLockListener;
        this.f2700g = new C1280d();
        this.f2701h = z;
        this.a = 2;
    }

    public void m5603a() {
        if (this.f2695b != null && C1287e.m5683a(this.f2695b)) {
            List arrayList = new ArrayList(4);
            for (String c1218d : this.f2696c) {
                arrayList.add(new C1218d(c1218d, this.f2697d, this.f2698e, 2, this.f2701h));
            }
            C1212b c1214a = new C1214a(this.f2695b, arrayList, this.f2702i, null, this.f2697d, this.f2698e, 4);
            c1214a.setRemovedContentId__(this.f2703j);
            if (this.f2704k != null) {
                C1222h device__ = c1214a.getDevice__();
                device__.setBuildVersion__(this.f2704k.getmVersion());
                device__.setModel__(this.f2704k.getmModel());
                device__.setTvModel__(this.f2704k.getmTVModel());
                device__.setHeight__(this.f2704k.getmTVHeight());
                device__.setWidth__(this.f2704k.getmTVWidth());
                if (C1289h.m5695a(this.f2695b).m5731p()) {
                    device__.setUserAccount__(this.f2704k.getmAccoutInfo());
                }
                device__.setType__(7);
            }
            try {
                new C1286d(this.f2695b, C1243a.f2655c, c1214a, new C1270j(this)).executeOnExecutor(C1366j.f2949a, new Void[0]);
            } catch (Exception e) {
                C1336d.m5888c("MagLockAdSource", "request maglock ad fail");
            }
        }
    }

    public void m5604a(List<String> list, List<String> list2, CubeParameters cubeParameters) {
        this.f2702i = list;
        this.f2703j = list2;
        this.f2704k = cubeParameters;
    }

    public void m5605b(Context context, C1235b c1235b) {
        C1366j.f2951c.execute(new C1271k(this, c1235b, context));
    }
}
