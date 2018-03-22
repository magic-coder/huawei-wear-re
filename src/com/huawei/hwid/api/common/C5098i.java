package com.huawei.hwid.api.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.cloudservice.C4339c;
import com.huawei.cloudservice.C4339c.C4341a;
import com.huawei.cloudservice.IntentResultHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: GetIntentTask */
public class C5098i extends C5081b {
    private IntentResultHandler f18385d;
    private String f18386e;
    private String f18387f;
    private String f18388g;

    public C5098i(Context context, String str, String str2, IntentResultHandler intentResultHandler) {
        super(context);
        this.f18385d = intentResultHandler;
        this.f18386e = str;
        this.f18387f = context.getPackageName();
        this.f18388g = str2;
    }

    void mo4614b() {
        C5073a a = C5073a.m24398a(this.a);
        if (a != null) {
            try {
                a.m24414a().mo4418a(this.f18386e, this.f18387f, this.f18388g, m24552a(this.f18385d));
            } catch (RemoteException e) {
                C5165e.m24906b("RemoteAccessAuthorizeIntentTask", "remote exception");
            }
        }
    }

    void mo4613a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "timeout. retry again");
        }
        this.f18385d.onError(errorStatus);
    }

    private C4339c m24552a(final IntentResultHandler intentResultHandler) {
        return new C4341a(this) {
            final /* synthetic */ C5098i f18384b;

            public void mo4422a(int i, Bundle bundle) throws RemoteException {
            }

            public void mo4421a(int i, Intent intent) throws RemoteException {
                if (this.f18384b.c.get()) {
                    C5165e.m24906b("RemoteAccessAuthorizeIntentTask", "has cancelled by timeout, return directly");
                    return;
                }
                C5165e.m24906b("RemoteAccessAuthorizeIntentTask", "retCode=" + i);
                if (i == 3) {
                    intentResultHandler.onFinish(intent);
                } else if (i == 0) {
                    intentResultHandler.onError(new ErrorStatus(31, "Account hasnot login"));
                } else if (i == 1) {
                    intentResultHandler.onError(new ErrorStatus(29, "Signature invalid"));
                } else if (i == 5) {
                    intentResultHandler.onError(new ErrorStatus(12, "userId invalid"));
                } else {
                    intentResultHandler.onError(new ErrorStatus(12, "params error"));
                    C5165e.m24906b("RemoteAccessAuthorizeIntentTask", "DONT KNOW RET_CODE:" + i);
                }
                this.f18384b.m24457a();
            }

            public void mo4420a(int i) throws RemoteException {
            }

            public void mo4423b(int i, Bundle bundle) throws RemoteException {
            }
        };
    }
}
