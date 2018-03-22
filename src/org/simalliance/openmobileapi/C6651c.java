package org.simalliance.openmobileapi;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.snowballtech.apdu.constant.Constant;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import org.simalliance.openmobileapi.service.C6652e;
import org.simalliance.openmobileapi.service.C6657a;
import org.simalliance.openmobileapi.service.C6658b;
import org.simalliance.openmobileapi.service.C6665k;
import org.simalliance.openmobileapi.service.SmartcardError;

/* compiled from: SEService */
public class C6651c {
    private final Object f22890a = new Object();
    private final Context f22891b;
    private volatile C6658b f22892c;
    private ServiceConnection f22893d;
    private final HashMap<String, C6650b> f22894e = new HashMap();
    private final C6652e f22895f = new C6654d(this);
    private C3076f f22896g;

    public C6651c(Context context, C3076f c3076f) {
        if (context == null) {
            throw new NullPointerException("context must not be null");
        }
        this.f22891b = context;
        this.f22896g = c3076f;
        this.f22893d = new C6655e(this);
        if (this.f22891b.bindService(new Intent(C6658b.class.getName()), this.f22893d, 1)) {
            Log.v("SEService", "bindService successful");
        }
    }

    public boolean m29952a() {
        if (this.f22892c == null) {
            return false;
        }
        return true;
    }

    public C6650b[] m29953b() {
        if (this.f22892c == null) {
            throw new IllegalStateException("service not connected to system");
        }
        try {
            String[] a = this.f22892c.mo5535a(new SmartcardError());
            this.f22894e.clear();
            for (String str : a) {
                this.f22894e.put(str, new C6650b(this, str));
            }
            return m29950e();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m29954c() {
        synchronized (this.f22890a) {
            if (this.f22892c != null) {
                for (C6650b d : this.f22894e.values()) {
                    try {
                        d.m29946d();
                    } catch (Exception e) {
                    }
                }
            }
            try {
                this.f22891b.unbindService(this.f22893d);
            } catch (IllegalArgumentException e2) {
            }
            this.f22892c = null;
        }
    }

    C6665k m29951a(String str) {
        SmartcardError smartcardError = new SmartcardError();
        try {
            C6665k a = this.f22892c.mo5534a(str, smartcardError);
            C6651c.m29949a(smartcardError);
            return a;
        } catch (RemoteException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    static void m29949a(SmartcardError smartcardError) {
        try {
            smartcardError.throwException();
        } catch (C6657a e) {
            throw new IllegalStateException(e.getMessage());
        } catch (AccessControlException e2) {
            throw new SecurityException(e2.getMessage());
        }
    }

    C6652e m29955d() {
        return this.f22895f;
    }

    private C6650b[] m29950e() {
        int i = 1;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (true) {
            C6650b c6650b = (C6650b) this.f22894e.get(Constant._UICC_TERMINAL + i2);
            if (c6650b == null) {
                break;
            }
            arrayList.add(c6650b);
            i2++;
        }
        i2 = 1;
        while (true) {
            c6650b = (C6650b) this.f22894e.get(Constant._ESE_TERMINAL + i2);
            if (c6650b == null) {
                break;
            }
            arrayList.add(c6650b);
            i2++;
        }
        while (true) {
            c6650b = (C6650b) this.f22894e.get(Constant._SD_TERMINAL + i);
            if (c6650b == null) {
                break;
            }
            arrayList.add(c6650b);
            i++;
        }
        for (C6650b c6650b2 : this.f22894e.values()) {
            if (!arrayList.contains(c6650b2)) {
                arrayList.add(c6650b2);
            }
        }
        return (C6650b[]) arrayList.toArray(new C6650b[arrayList.size()]);
    }
}
