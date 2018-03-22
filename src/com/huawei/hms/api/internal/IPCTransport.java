package com.huawei.hms.api.internal;

import android.os.Bundle;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.core.aidl.C0832d;
import com.huawei.hms.core.aidl.C0861a;
import com.huawei.hms.core.aidl.C0862b;
import com.huawei.hms.core.aidl.C0868f;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.api.transport.DatagramTransport.C0875a;

public class IPCTransport implements DatagramTransport {
    private final String f1328a;
    private final IMessageEntity f1329b;
    private final Class<? extends IMessageEntity> f1330c;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        this.f1328a = str;
        this.f1329b = iMessageEntity;
        this.f1330c = cls;
    }

    public final void mo2231a(ApiClient apiClient, C0875a c0875a) {
        int a = m2950a(apiClient, new C0846f(this.f1330c, c0875a));
        if (a != 0) {
            c0875a.mo2254a(a, null);
        }
    }

    public final void mo2232b(ApiClient apiClient, C0875a c0875a) {
        mo2231a(apiClient, c0875a);
    }

    private int m2950a(ApiClient apiClient, C0832d c0832d) {
        C0862b c0862b = new C0862b(this.f1328a, C0847g.m2998a().m3000b());
        C0868f a = C0861a.m3030a(c0862b.m3036c());
        c0862b.m3034a(a.m3050a(this.f1329b, new Bundle()));
        IMessageEntity requestHeader = new RequestHeader();
        requestHeader.setAppID(apiClient.getAppID());
        requestHeader.setPackageName(apiClient.getPackageName());
        requestHeader.setSdkVersion(20502300);
        if (apiClient instanceof HuaweiApiClientImpl) {
            requestHeader.setSessionId(apiClient.getSessionId());
        }
        c0862b.f1358b = a.m3050a(requestHeader, new Bundle());
        try {
            ((HuaweiApiClientImpl) apiClient).getService().mo2245a(c0862b, c0832d);
            return 0;
        } catch (Exception e) {
            return ErrorCode.INTERNAL_ERROR;
        }
    }
}
