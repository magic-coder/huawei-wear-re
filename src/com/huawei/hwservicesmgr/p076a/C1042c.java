package com.huawei.hwservicesmgr.p076a;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ITelephony;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.p190v.C2538c;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: HWHFCallManager */
public class C1042c {
    private static C1042c f2032b = null;
    private static final Object f2033d = new Object();
    private Context f2034a;
    private C1023c f2035c = C1023c.m3920a(this.f2034a);

    public C1042c(Context context) {
        this.f2034a = context;
        if (this.f2035c == null) {
            C2538c.m12680e("HWHFCallManager", "---mDeviceMgr is null---");
        }
    }

    public static C1042c m4354a(Context context) {
        C1042c c1042c;
        synchronized (f2033d) {
            if (f2032b == null) {
                f2032b = new C1042c(context);
            }
            c1042c = f2032b;
        }
        return c1042c;
    }

    public void m4356a(byte[] bArr) {
        if (bArr.length < 5) {
            C2538c.m12679d("HWHFCallManager", "handleCallingOperationReport ,length < 5, return");
        } else if ((byte) 1 == bArr[1] && (byte) 1 == bArr[4]) {
            C2538c.m12677c("HWHFCallManager", "operation = " + bArr[4] + "——————拒接");
            m4355a();
        }
    }

    private void m4355a() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f2034a.getSystemService("phone");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getITelephony", (Class[]) null);
            declaredMethod.setAccessible(true);
            ITelephony iTelephony = (ITelephony) declaredMethod.invoke(telephonyManager, (Object[]) null);
            if (iTelephony == null) {
                C2538c.m12680e("HWHFCallManager", "iTelephony is null!");
                return;
            }
            C2538c.m12677c("HWHFCallManager", "SDK_LEVEL:" + VERSION.SDK_INT);
            if (iTelephony.endCall()) {
                C2538c.m12677c("HWHFCallManager", "ITelephony.endCall()--Succeed");
            } else if (VERSION.SDK_INT >= 22) {
                List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) this.f2034a.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null) {
                    for (SubscriptionInfo subscriptionId : activeSubscriptionInfoList) {
                        boolean endCallForSubscriber = iTelephony.endCallForSubscriber(subscriptionId.getSubscriptionId());
                        C2538c.m12677c("HWHFCallManager", "endCallForSubscriber--Result:" + endCallForSubscriber + "--SubId:" + r1);
                    }
                    return;
                }
                C2538c.m12677c("HWHFCallManager", "endCallForSubscriber--Get Active Subscription Info List Failed");
            } else {
                C2538c.m12677c("HWHFCallManager", "ITelephony.endCall()--Fail");
            }
        } catch (RuntimeException e) {
            C2538c.m12680e("HWHFCallManager", "endCall RuntimeException: ", e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("HWHFCallManager", "endCall Exception: ", e2.getMessage());
        }
    }
}
