package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.C0454a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.HashMap;

final class al extends aj implements Callback {
    private final HashMap<ak, am> f407a = new HashMap();
    private final Context f408b;
    private final Handler f409c;
    private final C0454a f410d;
    private final long f411e;
    private final long f412f;

    al(Context context) {
        this.f408b = context.getApplicationContext();
        this.f409c = new Handler(context.getMainLooper(), this);
        this.f410d = C0454a.m793a();
        this.f411e = 5000;
        this.f412f = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
    }

    protected boolean mo1765a(ak akVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        C0424f.m650a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f407a) {
            am amVar = (am) this.f407a.get(akVar);
            if (amVar != null) {
                this.f409c.removeMessages(0, akVar);
                if (!amVar.m611a(serviceConnection)) {
                    amVar.m608a(serviceConnection, str);
                    switch (amVar.m612b()) {
                        case 1:
                            serviceConnection.onServiceConnected(amVar.m617e(), amVar.m616d());
                            break;
                        case 2:
                            amVar.m609a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(akVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            amVar = new am(this, akVar);
            amVar.m608a(serviceConnection, str);
            amVar.m609a(str);
            this.f407a.put(akVar, amVar);
            a = amVar.m610a();
        }
        return a;
    }

    protected void mo1766b(ak akVar, ServiceConnection serviceConnection, String str) {
        C0424f.m650a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f407a) {
            am amVar = (am) this.f407a.get(akVar);
            String valueOf;
            if (amVar == null) {
                valueOf = String.valueOf(akVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (amVar.m611a(serviceConnection)) {
                amVar.m613b(serviceConnection, str);
                if (amVar.m615c()) {
                    this.f409c.sendMessageDelayed(this.f409c.obtainMessage(0, akVar), this.f411e);
                }
            } else {
                valueOf = String.valueOf(akVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        ak akVar;
        am amVar;
        switch (message.what) {
            case 0:
                synchronized (this.f407a) {
                    akVar = (ak) message.obj;
                    amVar = (am) this.f407a.get(akVar);
                    if (amVar != null && amVar.m615c()) {
                        if (amVar.m610a()) {
                            amVar.m614b("GmsClientSupervisor");
                        }
                        this.f407a.remove(akVar);
                    }
                }
                return true;
            case 1:
                synchronized (this.f407a) {
                    akVar = (ak) message.obj;
                    amVar = (am) this.f407a.get(akVar);
                    if (amVar != null && amVar.m612b() == 3) {
                        String valueOf = String.valueOf(akVar);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName e = amVar.m617e();
                        if (e == null) {
                            e = akVar.m599b();
                        }
                        amVar.onServiceDisconnected(e == null ? new ComponentName(akVar.m598a(), "unknown") : e);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
