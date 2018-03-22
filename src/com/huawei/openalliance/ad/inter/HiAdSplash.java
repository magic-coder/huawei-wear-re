package com.huawei.openalliance.ad.inter;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.SplashParam;
import com.huawei.openalliance.ad.inter.listener.SplashListener;
import com.huawei.openalliance.ad.p112a.p121e.C1254f;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.p112a.p123f.C1261a;
import com.huawei.openalliance.ad.p112a.p123f.C1275m;
import com.huawei.openalliance.ad.p112a.p125g.C1282f;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.List;

public class HiAdSplash {
    private static final String TAG = "HiAdSplash";

    public HiAdSplash(Context context, SplashParam splashParam, SplashListener splashListener) {
        if (!C1287e.m5688c()) {
            C1336d.m5888c(TAG, "No support api level!");
            if (splashListener != null) {
                splashListener.onNoSupport();
            }
        } else if (checkInput(context, splashParam, splashListener)) {
            try {
                new C1275m(context.getApplicationContext(), splashParam, splashListener).m5631c();
            } catch (Exception e) {
                C1336d.m5888c(TAG, "fail to show splash ad");
                if (splashListener != null) {
                    splashListener.onAdFailed(499);
                }
            }
        }
    }

    private boolean checkInput(Context context, SplashParam splashParam, SplashListener splashListener) {
        boolean z = context == null ? false : (splashParam == null || !splashParam.checkParam()) ? false : splashListener != null;
        if (!z) {
            C1336d.m5888c(TAG, "check params failed!");
            if (splashListener != null) {
                splashListener.onAdFailed(1000);
            }
        }
        return z;
    }

    public static boolean isAvailable(Context context, String str, int i, int i2, boolean z) {
        if (context == null || C1365i.m6081a(str)) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        C1289h a = C1289h.m5695a(applicationContext);
        if (1 != a.m5705c() || a.m5711e() != 0) {
            return true;
        }
        C1336d.m5886b(TAG, "cache mode and slogan show time is 0");
        long d = C1287e.m5689d();
        if (!C1254f.m5556a(context) && a.m5735t() < d && C1255g.m5565a(applicationContext, str, i, 1)) {
            return true;
        }
        C1336d.m5886b(TAG, "no ad available to show, begin to req ad");
        List arrayList = new ArrayList();
        arrayList.add(str);
        C1261a.m5578a(context, 1, arrayList, null, new C1282f(), z, i, i2, null);
        return false;
    }
}
