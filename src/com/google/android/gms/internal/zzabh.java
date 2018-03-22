package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.C0424f;

public final class zzabh<L> {
    private final zza f892a;
    private volatile L f893b;
    private final bq<L> f894c;

    final class zza extends Handler {
        final /* synthetic */ zzabh f891a;

        public zza(zzabh com_google_android_gms_internal_zzabh, Looper looper) {
            this.f891a = com_google_android_gms_internal_zzabh;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            C0424f.m657b(z);
            this.f891a.m1638b((br) message.obj);
        }
    }

    zzabh(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.f892a = new zza(this, looper);
        this.f893b = C0424f.m650a((Object) l, (Object) "Listener must not be null");
        this.f894c = new bq(l, C0424f.m651a(str));
    }

    public void m1636a() {
        this.f893b = null;
    }

    public void m1637a(br<? super L> brVar) {
        C0424f.m650a((Object) brVar, (Object) "Notifier must not be null");
        this.f892a.sendMessage(this.f892a.obtainMessage(1, brVar));
    }

    void m1638b(br<? super L> brVar) {
        Object obj = this.f893b;
        if (obj == null) {
            brVar.mo2013a();
            return;
        }
        try {
            brVar.mo2014a(obj);
        } catch (RuntimeException e) {
            brVar.mo2013a();
            throw e;
        }
    }
}
