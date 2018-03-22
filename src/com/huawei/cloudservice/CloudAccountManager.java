package com.huawei.cloudservice;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.opensdk.ResReqHandler;
import com.huawei.hwid.api.common.C5088d;
import com.huawei.hwid.api.common.C5106n;
import com.huawei.hwid.api.common.apkimpl.C5079a;
import com.huawei.hwid.api.common.p424a.C5069a;
import com.huawei.hwid.api.common.p424a.C5072d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.p434c.C5147a;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.openapi.out.OutReturn.ParamStr;
import com.huawei.hwid.p426b.p427a.C5113b;
import java.util.ArrayList;
import java.util.List;

public class CloudAccountManager {
    public static void storeHwAccount(Context context, String str, String str2, HwAccount hwAccount, Bundle bundle) {
        if (context == null) {
            C5165e.m24906b("CloudAccountManager", "context is null");
        } else if (hwAccount == null || TextUtils.isEmpty(str)) {
            C5165e.m24906b("CloudAccountManager", "hwAccount or appId is null");
        } else {
            hwAccount.m25123c(str);
            List arrayList = new ArrayList();
            arrayList.add(hwAccount);
            String a = m20860a(str2);
            C5176g.m25013a(context, a);
            try {
                C5113b.m24638a(context, a, arrayList, true);
            } catch (Exception e) {
                C5165e.m24908c("CloudAccountManager", e.getMessage());
            }
        }
    }

    public static Bundle getHwAccount(Context context, String str, String str2) {
        if (context == null) {
            C5165e.m24906b("CloudAccountManager", "context is null");
            return null;
        }
        List<HwAccount> a = C5113b.m24634a(m20860a(str2), context, true);
        if (a.isEmpty()) {
            C5165e.m24906b("CloudAccountManager", "there is no account, get account failed");
        } else if (TextUtils.isEmpty(str)) {
            return ((HwAccount) a.get(0)).m25146p();
        } else {
            List arrayList = new ArrayList();
            for (HwAccount hwAccount : a) {
                if (hwAccount != null && hwAccount.m25122c().equals(str)) {
                    arrayList.add(hwAccount);
                }
            }
            if (!arrayList.isEmpty()) {
                return ((HwAccount) arrayList.get(0)).m25146p();
            }
        }
        return null;
    }

    public static void storeAccessToken(Context context, String str) {
        if (context == null) {
            C5165e.m24906b("CloudAccountManager", "context is null");
        } else if (TextUtils.isEmpty(str)) {
            C5165e.m24906b("CloudAccountManager", "accessToken is null, store accessToken failed");
        } else {
            C5147a.m24824a(context).m24831b("accessToken", C5201e.m25307b(context, str));
        }
    }

    public static String getAccessToken(Context context) {
        if (context == null) {
            C5165e.m24906b("CloudAccountManager", "context is null");
            return "";
        }
        String a = C5147a.m24824a(context).m24827a("accessToken", "");
        if (TextUtils.isEmpty(a)) {
            C5165e.m24906b("CloudAccountManager", "accessToken is null, get accessToken failed");
            return a;
        }
        String c = C5201e.m25308c(context, a);
        if (TextUtils.isEmpty(c)) {
            return C5201e.m25304a(context, a);
        }
        return c;
    }

    public static void deleteAccessToken(Context context) {
        if (context == null) {
            C5165e.m24906b("CloudAccountManager", "context is null");
        } else {
            C5147a.m24824a(context).m24828a("accessToken");
        }
    }

    public static void changeSTToAT(Context context, String str, String str2, String str3, String str4, Bundle bundle, ResReqHandler resReqHandler) {
        if (context == null) {
            C5165e.m24906b("CloudAccountManager", "context is null");
        } else if (C5106n.m24593b(context)) {
            C5072d.m24397a(context, new C5069a(context, str, str2, str3, str4, bundle), resReqHandler);
        } else if (bundle == null) {
            C5165e.m24906b("CloudAccountManager", "bundle is null");
        } else {
            C5165e.m24906b("CloudAccountManager", "hwid is not exit");
            bundle.putInt(ParamStr.RET_CODE, 34);
            bundle.putString(ParamStr.RET_RES_CONTENT, "hwid is not exit");
            resReqHandler.onComplete(bundle);
        }
    }

    private static String m20860a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new StringBuffer("app_account").append(".xml").toString();
        }
        return new StringBuffer("app_account").append(HwAccountConstants.SPLIIT_UNDERLINE).append(str).append(".xml").toString();
    }

    public static boolean isSupportFingerprint(Context context, Bundle bundle) {
        return C5079a.m24450a(context, bundle);
    }

    public static void checkHwIDPassword(Context context, String str, boolean z, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        C5088d.m24481a(context, str, z, cloudRequestHandler, bundle);
    }

    public static void checkPasswordByUserId(Context context, String str, String str2, String str3, String str4, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        C5088d.m24497b(context, str, str2, str3, str4, cloudRequestHandler, bundle);
    }
}
