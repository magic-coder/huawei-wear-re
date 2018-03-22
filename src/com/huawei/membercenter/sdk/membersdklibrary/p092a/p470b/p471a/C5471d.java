package com.huawei.membercenter.sdk.membersdklibrary.p092a.p470b.p471a;

import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5482d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5486h;

/* compiled from: NormalMutilSim */
public class C5471d implements C5468a {
    private Object f19326a;

    public C5471d() {
        this.f19326a = null;
        this.f19326a = m26154b();
    }

    public C5470c mo4697a() {
        return C5470c.MutiCardHw;
    }

    private Object m26154b() {
        return C5486h.m26194a("android.telephony.MSimTelephonyManager", "getDefault", new Class[0], new Object[0]);
    }

    public String mo4698a(int i) {
        String str;
        String str2 = "";
        try {
            str = (String) C5486h.m26193a(Class.forName("android.telephony.MSimTelephonyManager"), this.f19326a, "getDeviceId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
            C5482d.m26186d("NormalMutilSim", "imei ClassNotFoundException exception:");
            str = str2;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
