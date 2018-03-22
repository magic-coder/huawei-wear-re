package com.huawei.openalliance.ad.p112a.p118d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.HiAdMagLock;
import com.huawei.openalliance.ad.inter.constant.EventType;
import com.huawei.openalliance.ad.inter.data.CubeParameters;
import com.huawei.openalliance.ad.inter.data.MagLockAdInfo;
import com.huawei.openalliance.ad.inter.listener.MagLockConfigListener;
import com.huawei.openalliance.ad.inter.listener.MagLockListener;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p122h.C1283a;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.p112a.p123f.C1266f;
import com.huawei.openalliance.ad.p112a.p123f.C1269i;
import com.huawei.openalliance.ad.p112a.p123f.C1272l;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.Arrays;
import java.util.List;

public class C1246a implements HiAdMagLock {
    private static boolean m5525a(Context context, MagLockListener magLockListener, String[] strArr) {
        if (C1287e.m5688c()) {
            return C1246a.m5526b(context, magLockListener, strArr);
        } else {
            C1336d.m5888c("HiAdMagLockImpl", "No support api level!");
            if (magLockListener == null) {
                return false;
            }
            magLockListener.onNoSupport();
            return false;
        }
    }

    private static boolean m5526b(Context context, MagLockListener magLockListener, String[] strArr) {
        boolean z;
        if (context == null) {
            z = false;
        } else if (strArr == null || strArr.length == 0) {
            z = false;
        } else {
            for (CharSequence isEmpty : strArr) {
                if (TextUtils.isEmpty(isEmpty)) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (!z) {
            C1336d.m5888c("HiAdMagLockImpl", "check params failed!");
            if (magLockListener != null) {
                magLockListener.onAdFailed(1000, null);
            }
        }
        return z;
    }

    public void onNetworkConnected(Context context) {
        if (context != null) {
            C1249b.m5532a(context);
        }
    }

    public void reportEvent(Context context, String str, EventType eventType) {
        if (context != null && !TextUtils.isEmpty(str) && eventType != null) {
            C1221g a = C1255g.m5561a(context, str.trim());
            if (a != null) {
                C1289h a2 = C1289h.m5695a(context);
                if (EventType.IMPRESSION.value().equals(eventType.value())) {
                    a2.m5708c("" + C1287e.m5689d());
                }
                a.setShowid__(a2.m5732q());
                C1249b.m5537a(context, 2, eventType, a);
            }
        }
    }

    public void requestAds(Context context, String[] strArr, String[] strArr2, String[] strArr3, CubeParameters cubeParameters, MagLockListener magLockListener, boolean z) {
        if (!C1246a.m5525a(context, magLockListener, strArr)) {
            return;
        }
        if (C1287e.m5683a(context) || magLockListener == null) {
            List asList = strArr2 != null ? Arrays.asList(strArr2) : null;
            List asList2 = strArr3 != null ? Arrays.asList(strArr3) : null;
            Context applicationContext = context.getApplicationContext();
            C1255g.m5563a(applicationContext);
            C1269i c1269i = new C1269i(applicationContext, Arrays.asList(strArr), C1283a.m5645a(applicationContext).m5650a(), C1283a.m5645a(applicationContext).m5652b(), magLockListener, z);
            c1269i.m5604a(asList, asList2, cubeParameters);
            c1269i.m5603a();
            return;
        }
        magLockListener.onAdFailed(499, null);
    }

    public void requestAds(Context context, String[] strArr, String[] strArr2, String[] strArr3, MagLockListener magLockListener, boolean z) {
        if (!C1246a.m5525a(context, magLockListener, strArr)) {
            return;
        }
        if (C1287e.m5683a(context) || magLockListener == null) {
            List asList = strArr2 != null ? Arrays.asList(strArr2) : null;
            List asList2 = strArr3 != null ? Arrays.asList(strArr3) : null;
            Context applicationContext = context.getApplicationContext();
            C1255g.m5563a(applicationContext);
            C1269i c1269i = new C1269i(applicationContext, Arrays.asList(strArr), C1283a.m5645a(applicationContext).m5650a(), C1283a.m5645a(applicationContext).m5652b(), magLockListener, z);
            c1269i.m5604a(asList, asList2, null);
            c1269i.m5603a();
            return;
        }
        magLockListener.onAdFailed(499, null);
    }

    public void requestConfig(Context context, String str, MagLockConfigListener magLockConfigListener) {
        if (!C1287e.m5688c()) {
            C1336d.m5888c("HiAdMagLockImpl", "No support api level!");
            if (magLockConfigListener != null) {
                magLockConfigListener.onConfig(1001, null);
            }
        } else if (!C1287e.m5683a(context) && magLockConfigListener != null) {
            magLockConfigListener.onConfig(499, null);
        } else if (context != null && !C1365i.m6081a(str)) {
            C1266f.m5592a(context, str, magLockConfigListener);
        }
    }

    public void updateMagLockInfo(Context context, MagLockAdInfo magLockAdInfo) {
        C1272l.m5611a(context, magLockAdInfo);
    }
}
