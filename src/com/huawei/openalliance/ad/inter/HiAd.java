package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.p112a.p116b.C1243a;
import com.huawei.openalliance.ad.p112a.p116b.C1243a.C1242a;
import com.huawei.openalliance.ad.p112a.p121e.C1256h;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.p112a.p123f.C1266f;
import com.huawei.openalliance.ad.utils.C1345b;
import com.huawei.openalliance.ad.utils.C1364h;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.AdEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.MaterialRecord;
import com.huawei.openalliance.ad.utils.db.bean.SloganRecord;
import com.huawei.openalliance.ad.utils.db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.UserCloseRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import com.huawei.openalliance.ad.utils.p129b.C1339f;
import java.io.File;

public class HiAd {
    private static final String TAG = "HiAd";

    final class C13201 implements Runnable {
        final /* synthetic */ Context val$appCtx;

        C13201(Context context) {
            this.val$appCtx = context;
        }

        public void run() {
            C1357a a = C1357a.m5982a(this.val$appCtx);
            try {
                a.m5987a(MaterialRecord.class.getSimpleName(), null, null);
                a.m5987a(AdEventRecord.class.getSimpleName(), null, null);
                a.m5987a(ThirdPartyEventRecord.class.getSimpleName(), null, null);
                a.m5987a(SloganRecord.class.getSimpleName(), null, null);
                a.m5987a(UserCloseRecord.class.getSimpleName(), null, null);
                String str = C1364h.m6075b(this.val$appCtx) + File.separator + "hiad" + File.separator;
                String str2 = str + "slogan" + File.separator;
                String str3 = C1364h.m6077c(this.val$appCtx) + File.separator + "hiad" + File.separator;
                String str4 = str3 + "slogan" + File.separator;
                C1345b.m5936a(str, null);
                C1345b.m5936a(str3, null);
                C1345b.m5936a(str2, null);
                C1345b.m5936a(str4, null);
            } finally {
                if (a != null) {
                    a.close();
                }
            }
        }
    }

    public static void enableLog(String str, int i) {
        if (C1242a.FORMAL == C1243a.f2653a && i < C1339f.INFO.m5911a()) {
            i = C1339f.INFO.m5911a();
        }
        C1336d.m5882a(str, C1339f.m5910a(i), "HiAdSDK");
    }

    @Deprecated
    public static void enableLog(boolean z) {
    }

    public static void enableUserInfo(Context context, boolean z) {
        if (context != null) {
            if (C1287e.m5688c()) {
                Context applicationContext = context.getApplicationContext();
                C1289h.m5695a(applicationContext).m5700a(z);
                if (!z) {
                    try {
                        C1366j.f2951c.execute(new C13201(applicationContext));
                        return;
                    } catch (Exception e) {
                        C1336d.m5888c(TAG, "execute thread fail");
                        return;
                    }
                }
                return;
            }
            C1336d.m5888c(TAG, "enableUserInfo No support api level!");
        }
    }

    public static void forceCube() {
        C1243a.m5517a();
    }

    public static void init(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (C1287e.m5688c()) {
                Context applicationContext = context.getApplicationContext();
                C1256h.m5566a(applicationContext);
                if (C1287e.m5683a(applicationContext)) {
                    C1266f.m5592a(applicationContext, str, null);
                    return;
                }
                return;
            }
            C1336d.m5888c(TAG, "init No support api level!");
        }
    }

    public static boolean isEnableUserInfo(Context context) {
        if (context == null) {
            return true;
        }
        if (C1287e.m5688c()) {
            return C1289h.m5695a(context.getApplicationContext()).m5731p();
        }
        C1336d.m5888c(TAG, "isEnableUserInfo No support api level!");
        return true;
    }
}
