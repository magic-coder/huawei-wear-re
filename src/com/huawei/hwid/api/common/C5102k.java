package com.huawei.hwid.api.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.cloudservice.C4339c;
import com.huawei.cloudservice.C4339c.C4341a;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p429a.C5117b;
import com.huawei.hwid.core.p429a.C5118c;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p428c.C5115a;

/* compiled from: LoginTask */
public class C5102k extends C5081b {
    private String f18396d;
    private Bundle f18397e;
    private LoginHandler f18398f;
    private Context f18399g;

    public C5102k(Context context, String str, Bundle bundle, LoginHandler loginHandler) {
        super(context);
        this.f18399g = context;
        this.f18396d = str;
        this.f18397e = bundle;
        this.f18398f = loginHandler;
    }

    void mo4614b() {
        C5073a a = C5073a.m24398a(this.f18399g);
        if (a != null) {
            try {
                a.m24414a().mo4416a(this.f18396d, this.f18397e, m24567a(this.f18398f));
            } catch (RemoteException e) {
                C5165e.m24906b("LoginTask", "login remote exception");
            }
        }
    }

    void mo4613a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "login timeout. retry again");
        }
        this.f18398f.onError(errorStatus);
    }

    private C4339c m24567a(final LoginHandler loginHandler) {
        return new C4341a(this) {
            final /* synthetic */ C5102k f18395b;

            public void mo4422a(int i, Bundle bundle) throws RemoteException {
                if (this.f18395b.c.get()) {
                    C5165e.m24906b("LoginTask", "has cancelled by timeout, return directly");
                    return;
                }
                C5165e.m24906b("LoginTask", "loginResult:retCode=" + i);
                this.f18395b.m24457a();
                if (i == -1) {
                    String b;
                    HwAccount a = new HwAccount().m25116a(bundle);
                    Object i2 = a.m25134i();
                    if (TextUtils.isEmpty(i2) || "null".equalsIgnoreCase(i2)) {
                        b = C5182m.m25054b(this.f18395b.f18399g);
                        if (b == null) {
                            b = "";
                        }
                        a.m25133h(b);
                    }
                    this.f18395b.m24569a(a);
                    i2 = a.m25138k();
                    if (TextUtils.isEmpty(i2) || "null".equalsIgnoreCase(i2)) {
                        a.m25137j(C5182m.m25049a(this.f18395b.f18399g, C5182m.m25054b(this.f18395b.f18399g)));
                    }
                    C5115a.m24641a(this.f18395b.f18399g).m24644a(a);
                    CloudAccount[] a2 = C5088d.m24489a(this.f18395b.f18399g);
                    b = "";
                    if (!TextUtils.isEmpty(a.m25120b())) {
                        b = a.m25120b();
                    }
                    C5165e.m24906b("LoginTask", "loginResult");
                    C5106n.m24585a(this.f18395b.f18399g, b);
                    loginHandler.onLogin(a2, C5088d.m24463a(a2, b));
                    C5117b b2 = C5106n.m24592b();
                    if (b2 != null) {
                        b2.m24661a(C5166b.m24915a());
                        C5118c.m24666a(b2, this.f18395b.f18399g);
                        C5106n.m24587a(null);
                        return;
                    }
                    C5165e.m24906b("LoginTask", "aidl mOpLogItem is null");
                } else if (i == 0) {
                    loginHandler.onError(new ErrorStatus(31, "Account hasnot login"));
                } else if (i == 1) {
                    loginHandler.onError(new ErrorStatus(29, "Signature invalid"));
                } else if (i == 2) {
                    loginHandler.onError(new ErrorStatus(30, "serviceToken invalid"));
                } else {
                    C5165e.m24906b("LoginTask", "DONT KNOW RET_CODE:" + i);
                }
            }

            public void mo4421a(int i, Intent intent) throws RemoteException {
            }

            public void mo4420a(int i) throws RemoteException {
            }

            public void mo4423b(int i, Bundle bundle) throws RemoteException {
            }
        };
    }

    private void m24569a(HwAccount hwAccount) {
        Object j = hwAccount.m25136j();
        if (TextUtils.isEmpty(j) || "null".equalsIgnoreCase(j)) {
            String e = C5182m.m25061e(this.f18399g);
            if (e == null) {
                e = "";
            }
            hwAccount.m25135i(e);
        }
    }

    public String toString() {
        return "LoginTask{mServiceType='" + this.f18396d + '\'' + '}';
    }
}
