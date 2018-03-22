package com.huawei.hwid.api.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.cloudservice.C4339c;
import com.huawei.cloudservice.C4339c.C4341a;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LogoutHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: LogoutTask */
public class C5104l extends C5081b {
    private String f18402d;
    private Bundle f18403e;
    private String f18404f;
    private LogoutHandler f18405g;
    private Context f18406h;

    public C5104l(Context context, String str, String str2, Bundle bundle, LogoutHandler logoutHandler) {
        super(context);
        this.f18406h = context;
        this.f18402d = str;
        this.f18404f = str2;
        this.f18403e = bundle;
        this.f18405g = logoutHandler;
    }

    void mo4614b() {
        C5073a a = C5073a.m24398a(this.f18406h);
        if (a == null) {
            C5165e.m24910d("LogoutTask", "cloudAccount logout  null == aidlClientManager");
            return;
        }
        try {
            a.m24414a().mo4417a(this.f18402d, this.f18404f, this.f18403e, m24577a(this.f18405g));
        } catch (RemoteException e) {
            C5165e.m24910d("LogoutTask", "login remote exception");
        }
    }

    void mo4613a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "login timeout. retry again");
        }
        this.f18405g.onFail(errorStatus);
    }

    private C4339c m24577a(final LogoutHandler logoutHandler) {
        return new C4341a(this) {
            final /* synthetic */ C5104l f18401b;

            public void mo4422a(int i, Bundle bundle) throws RemoteException {
            }

            public void mo4421a(int i, Intent intent) throws RemoteException {
            }

            public void mo4420a(int i) throws RemoteException {
                C5165e.m24906b("LogoutTask", "logoutResult");
                if (this.f18401b.c.get()) {
                    C5165e.m24906b("LogoutTask", "has cancelled by timeout, return directly");
                    return;
                }
                if (i == 6) {
                    CloudAccount.clearAccountData(this.f18401b.f18406h);
                    logoutHandler.onSuccess();
                } else if (i == 0) {
                    logoutHandler.onFail(new ErrorStatus(31, "Account has not login"));
                } else if (i == 7) {
                    logoutHandler.onFail(new ErrorStatus(42, "userid not system account"));
                } else if (i == 8) {
                    logoutHandler.onFail(new ErrorStatus(44, "packagename was not matched"));
                } else if (i == 9) {
                    logoutHandler.onFail(new ErrorStatus(43, "packagename not in hwid list"));
                } else if (i == 1) {
                    logoutHandler.onFail(new ErrorStatus(29, "Signature invalid"));
                } else {
                    logoutHandler.onFail(new ErrorStatus(44, "other error"));
                    C5165e.m24906b("LogoutTask", "DONT KNOW RET_CODE:" + i);
                }
                this.f18401b.m24457a();
            }

            public void mo4423b(int i, Bundle bundle) throws RemoteException {
            }
        };
    }

    public String toString() {
        return "LogoutTask{  mServiceType='" + this.f18402d + '\'' + '}';
    }
}
