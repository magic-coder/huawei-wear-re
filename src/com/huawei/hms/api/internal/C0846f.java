package com.huawei.hms.api.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.C0832d.C0833a;
import com.huawei.hms.core.aidl.C0861a;
import com.huawei.hms.core.aidl.C0862b;
import com.huawei.hms.core.aidl.C0868f;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport.C0875a;
import com.huawei.hms.support.log.C0887a;

/* compiled from: IPCCallback */
public class C0846f extends C0833a {
    private final Class<? extends IMessageEntity> f1342a;
    private final C0875a f1343b;

    public C0846f(Class<? extends IMessageEntity> cls, C0875a c0875a) {
        this.f1342a = cls;
        this.f1343b = c0875a;
    }

    public void mo2230a(C0862b c0862b) throws RemoteException {
        if (c0862b == null || TextUtils.isEmpty(c0862b.f1357a)) {
            C0887a.m3098d("IPCCallback", "In call, URI cannot be empty.");
            throw new RemoteException();
        }
        C0868f a = C0861a.m3030a(c0862b.m3036c());
        IMessageEntity responseHeader = new ResponseHeader();
        a.m3051a(c0862b.f1358b, responseHeader);
        IMessageEntity iMessageEntity = null;
        if (c0862b.m3035b() > 0) {
            iMessageEntity = m2996a();
            if (iMessageEntity != null) {
                a.m3051a(c0862b.m3033a(), iMessageEntity);
            }
        }
        this.f1343b.mo2254a(responseHeader.getStatusCode(), iMessageEntity);
    }

    protected IMessageEntity m2996a() {
        ReflectiveOperationException e;
        if (this.f1342a != null) {
            try {
                return (IMessageEntity) this.f1342a.newInstance();
            } catch (IllegalAccessException e2) {
                e = e2;
            } catch (InstantiationException e3) {
                e = e3;
            }
        }
        return null;
        C0887a.m3098d("IPCCallback", "In newResponseInstance, instancing exception." + e.getMessage());
        return null;
    }
}
