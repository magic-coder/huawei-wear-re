package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.C0356c;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0440u;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.internal.zzad;

public class dy extends ae<du> implements dk {
    private final boolean f704e;
    private final C0443x f705f;
    private final Bundle f706g;
    private Integer f707h;

    public dy(Context context, Looper looper, boolean z, C0443x c0443x, Bundle bundle, C0380r c0380r, C0381s c0381s) {
        super(context, looper, 44, c0443x, c0380r, c0381s);
        this.f704e = z;
        this.f705f = c0443x;
        this.f706g = bundle;
        this.f707h = c0443x.m765i();
    }

    public dy(Context context, Looper looper, boolean z, C0443x c0443x, dl dlVar, C0380r c0380r, C0381s c0381s) {
        this(context, looper, z, c0443x, m1252a(c0443x), c0380r, c0381s);
    }

    public static Bundle m1252a(C0443x c0443x) {
        dl h = c0443x.m764h();
        Integer i = c0443x.m765i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c0443x.m756a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.m1206a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.m1207b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.m1208c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.m1209d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.m1210e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.m1211f());
            if (h.m1212g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.m1212g().longValue());
            }
            if (h.m1213h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.m1213h().longValue());
            }
        }
        return bundle;
    }

    private zzad m1253x() {
        Account b = this.f705f.m758b();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(b.name)) {
            googleSignInAccount = C0356c.m297a(m560n()).m299a();
        }
        return new zzad(b, this.f707h.intValue(), googleSignInAccount);
    }

    protected /* synthetic */ IInterface mo1772a(IBinder iBinder) {
        return m1257b(iBinder);
    }

    public void mo1866a(ao aoVar, boolean z) {
        try {
            ((du) m567u()).mo1857a(aoVar, this.f707h.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void mo1867a(dr drVar) {
        C0424f.m650a((Object) drVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((du) m567u()).mo1863a(new zzbau(m1253x()), drVar);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                drVar.mo1826a(new zzbaw(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected du m1257b(IBinder iBinder) {
        return dv.m1237a(iBinder);
    }

    public boolean mo1868d() {
        return this.f704e;
    }

    protected String mo1773i() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String mo1774j() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void mo1775k() {
        try {
            ((du) m567u()).mo1855a(this.f707h.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void mo1869l() {
        mo2010a(new C0440u(this));
    }

    protected Bundle mo1870r() {
        if (!m560n().getPackageName().equals(this.f705f.m762f())) {
            this.f706g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f705f.m762f());
        }
        return this.f706g;
    }
}
