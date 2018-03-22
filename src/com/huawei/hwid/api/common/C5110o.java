package com.huawei.hwid.api.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.api.common.apkimpl.C5079a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.p432a.C5129c;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5114a;

/* compiled from: TmpCloudRequestHandler */
class C5110o implements CloudRequestHandler {
    Activity f18421a;
    CloudRequestHandler f18422b;
    HwAccount f18423c;

    /* compiled from: TmpCloudRequestHandler */
    final class C51091 implements Runnable {
        final /* synthetic */ String f18417a;
        final /* synthetic */ String f18418b;
        final /* synthetic */ Context f18419c;
        final /* synthetic */ String f18420d;

        C51091(String str, String str2, Context context, String str3) {
            this.f18417a = str;
            this.f18418b = str2;
            this.f18419c = context;
            this.f18420d = str3;
        }

        public void run() {
            C5125a c5129c = new C5129c(this.f18417a, "com.huawei.hwid", this.f18418b);
            c5129c.m24743a(this.f18419c, c5129c, this.f18420d, new C5107a(this, this.f18419c) {
                final /* synthetic */ C51091 f18416a;

                public void mo4615a(Bundle bundle) {
                    C5165e.m24906b("TmpCloudRequestHandler", "onSuccess " + C5203g.m25314a(bundle));
                }

                public void mo4616b(Bundle bundle) {
                    C5165e.m24906b("TmpCloudRequestHandler", "onFail " + C5203g.m25314a(bundle));
                }
            });
        }
    }

    C5110o(Activity activity, CloudRequestHandler cloudRequestHandler, HwAccount hwAccount) {
        this.f18421a = activity;
        this.f18422b = cloudRequestHandler;
        this.f18423c = hwAccount;
    }

    public void onFinish(Bundle bundle) {
        if (bundle != null && 1 == bundle.getInt("result_code")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("accountName", this.f18423c.m25120b());
            bundle2.putString(HwAccountConstants.PARA_ACCOUNT_SERVICETOKEN, this.f18423c.m25130g());
            m24605a(this.f18421a, this.f18423c.m25124d(), this.f18422b, bundle2);
        }
    }

    public void onError(ErrorStatus errorStatus) {
    }

    private void m24605a(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        C5165e.m24906b("TmpCloudRequestHandler", "logoutHwIDByUserID");
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("TmpCloudRequestHandler", "logoutHwIDByUserID: context or cloudRequestHandler is null");
        } else if (TextUtils.isEmpty(str)) {
            if (cloudRequestHandler != null) {
                cloudRequestHandler.onError(new ErrorStatus(12, "userId is empty"));
            }
            C5165e.m24906b("TmpCloudRequestHandler", "userId is empty");
        } else if (C5106n.m24593b(context)) {
            String g;
            C5165e.m24906b("TmpCloudRequestHandler", "getHwAccount");
            HwAccount hwAccount = null;
            CloudAccount b = C5088d.m24491b(context, str);
            if (b != null) {
                hwAccount = b.getAccountData();
            }
            String str2 = "";
            String str3 = "";
            if (hwAccount != null) {
                str3 = hwAccount.m25120b();
                g = hwAccount.m25130g();
            } else {
                g = str3;
                str3 = str2;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = bundle.getString("accountName");
            }
            if (TextUtils.isEmpty(g)) {
                g = bundle.getString(HwAccountConstants.PARA_ACCOUNT_SERVICETOKEN);
            }
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(g)) {
                if (cloudRequestHandler != null) {
                    cloudRequestHandler.onError(new ErrorStatus(12, "accountName or serviceToken is empty"));
                    C5165e.m24906b("TmpCloudRequestHandler", "accountName or serviceToken is empty");
                }
            } else if (C5166b.m24924a(context)) {
                m24607a(this.f18421a);
                C5088d.m24493b(context);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("result_code", 1);
                cloudRequestHandler.onFinish(bundle2);
                if (!C5088d.m24488a(context, str3)) {
                    C5110o.m24606a(context, str, str3, g);
                }
            } else if (cloudRequestHandler != null) {
                cloudRequestHandler.onError(new ErrorStatus(5, context.getString(C5180k.m25027a(context, "CS_no_network_content"))));
                C5165e.m24906b("TmpCloudRequestHandler", "network is not avaible");
            }
        } else if (cloudRequestHandler != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("result_code", 1);
            cloudRequestHandler.onFinish(bundle3);
        }
    }

    private static void m24606a(Context context, String str, String str2, String str3) {
        new Thread(new C51091(str, str3, context, str2)).start();
    }

    public void m24607a(Context context) {
        if (context == null) {
            C5165e.m24906b("TmpCloudRequestHandler", "context is null");
            return;
        }
        if (C5166b.m24955h(context) && C5106n.m24593b(context)) {
            C5079a.m24443a(context, this.f18423c);
        }
        C5114a.m24640a(context).mo4618a(context, this.f18423c.m25120b(), C5166b.m24960l(context));
        String a = C5106n.m24583a(context);
        if (this.f18423c.m25120b().equalsIgnoreCase(a)) {
            a = "";
            C5106n.m24585a(context, a);
        }
        LoginHandler a2 = C5106n.m24581a();
        if (a2 != null) {
            CloudAccount[] a3 = C5088d.m24489a(context);
            a2.onLogout(a3, C5088d.m24463a(a3, a));
        }
    }
}
