package com.huawei.hwid.api.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.cloudservice.C4339c;
import com.huawei.cloudservice.C4339c.C4341a;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: GetRealNameInfoTask */
public class C5100j extends C5081b {
    private CloudRequestHandler f18391d;
    private String f18392e;
    private String f18393f;

    public C5100j(Context context, String str, CloudRequestHandler cloudRequestHandler) {
        super(context);
        this.f18391d = cloudRequestHandler;
        this.f18392e = context.getPackageName();
        this.f18393f = str;
    }

    void mo4614b() {
        C5073a a = C5073a.m24398a(this.a);
        if (a != null) {
            try {
                a.m24414a().mo4419b(this.f18392e, this.f18393f, new Bundle(), m24559a(this.f18391d));
            } catch (RemoteException e) {
                C5165e.m24906b("GetRealNameInfoTask", "remote exception");
            }
        }
    }

    void mo4613a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "timeout. retry again");
        }
        this.f18391d.onError(errorStatus);
    }

    private C4339c m24559a(final CloudRequestHandler cloudRequestHandler) {
        return new C4341a(this) {
            final /* synthetic */ C5100j f18390b;

            public void mo4422a(int i, Bundle bundle) throws RemoteException {
            }

            public void mo4421a(int i, Intent intent) throws RemoteException {
            }

            public void mo4420a(int i) throws RemoteException {
            }

            public void mo4423b(int i, Bundle bundle) throws RemoteException {
                if (this.f18390b.c.get()) {
                    C5165e.m24906b("GetRealNameInfoTask", "has cancelled by timeout, return directly");
                    return;
                }
                C5165e.m24906b("GetRealNameInfoTask", "retCode=" + i);
                if (i == -1) {
                    cloudRequestHandler.onFinish(bundle);
                } else if (i == 0) {
                    cloudRequestHandler.onError(new ErrorStatus(31, "Account hasnot login"));
                } else if (i == 1) {
                    cloudRequestHandler.onError(new ErrorStatus(29, "Signature invalid"));
                } else if (i == 5) {
                    cloudRequestHandler.onError(new ErrorStatus(12, "userId invalid"));
                } else if (i == 2) {
                    cloudRequestHandler.onError(new ErrorStatus(30, "st invalid"));
                } else {
                    cloudRequestHandler.onError(new ErrorStatus(12, "params error"));
                    C5165e.m24906b("GetRealNameInfoTask", "DONT KNOW RET_CODE:" + i);
                }
                this.f18390b.m24457a();
            }
        };
    }
}
