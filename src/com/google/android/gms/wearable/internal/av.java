package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class av<T> {
    private final Map<T, cl<T>> f956a = new HashMap();

    av() {
    }

    public void m1940a(IBinder iBinder) {
        synchronized (this.f956a) {
            as a = at.m1891a(iBinder);
            am ccVar = new cc();
            for (Entry entry : this.f956a.entrySet()) {
                cl clVar = (cl) entry.getValue();
                try {
                    a.mo1962a(ccVar, new zzc(clVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        String valueOf = String.valueOf(entry.getKey());
                        String valueOf2 = String.valueOf(clVar);
                        Log.d("WearableClient", new StringBuilder((String.valueOf(valueOf).length() + 27) + String.valueOf(valueOf2).length()).append("onPostInitHandler: added: ").append(valueOf).append("/").append(valueOf2).toString());
                    }
                } catch (RemoteException e) {
                    String valueOf3 = String.valueOf(entry.getKey());
                    String valueOf4 = String.valueOf(clVar);
                    Log.d("WearableClient", new StringBuilder((String.valueOf(valueOf3).length() + 32) + String.valueOf(valueOf4).length()).append("onPostInitHandler: Didn't add: ").append(valueOf3).append("/").append(valueOf4).toString());
                }
            }
        }
    }

    public void m1941a(ch chVar, C0502h<Status> c0502h, T t) throws RemoteException {
        synchronized (this.f956a) {
            cl clVar = (cl) this.f956a.remove(t);
            if (clVar == null) {
                c0502h.mo1881a(new Status(4002));
                return;
            }
            clVar.m2060a();
            ((as) chVar.m567u()).mo1963a(new ax(this.f956a, t, c0502h), new zzck(clVar));
        }
    }

    public void m1942a(ch chVar, C0502h<Status> c0502h, T t, cl<T> clVar) throws RemoteException {
        synchronized (this.f956a) {
            if (this.f956a.get(t) != null) {
                c0502h.mo1881a(new Status(4001));
                return;
            }
            this.f956a.put(t, clVar);
            try {
                ((as) chVar.m567u()).mo1962a(new aw(this.f956a, t, c0502h), new zzc(clVar));
            } catch (RemoteException e) {
                this.f956a.remove(t);
                throw e;
            }
        }
    }
}
