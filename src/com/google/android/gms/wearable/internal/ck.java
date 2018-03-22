package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.internal.C0502h;

class ck implements Runnable {
    final /* synthetic */ Uri f996a;
    final /* synthetic */ C0502h f997b;
    final /* synthetic */ String f998c;
    final /* synthetic */ long f999d;
    final /* synthetic */ long f1000e;
    final /* synthetic */ ch f1001f;

    ck(ch chVar, Uri uri, C0502h c0502h, String str, long j, long j2) {
        this.f1001f = chVar;
        this.f996a = uri;
        this.f997b = c0502h;
        this.f998c = str;
        this.f999d = j;
        this.f1000e = j2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r0 = "WearableClient";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = "WearableClient";
        r1 = "Executing sendFileToChannelTask";
        android.util.Log.v(r0, r1);
    L_0x0010:
        r0 = "file";
        r1 = r8.f996a;
        r1 = r1.getScheme();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0034;
    L_0x001e:
        r0 = "WearableClient";
        r1 = "Channel.sendFile used with non-file URI";
        android.util.Log.w(r0, r1);
        r0 = r8.f997b;
        r1 = new com.google.android.gms.common.api.Status;
        r2 = 10;
        r3 = "Channel.sendFile used with non-file URI";
        r1.<init>(r2, r3);
        r0.mo1880a(r1);
    L_0x0033:
        return;
    L_0x0034:
        r0 = new java.io.File;
        r1 = r8.f996a;
        r1 = r1.getPath();
        r0.<init>(r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r3 = android.os.ParcelFileDescriptor.open(r0, r1);	 Catch:{ FileNotFoundException -> 0x006a }
        r0 = r8.f1001f;	 Catch:{ RemoteException -> 0x009e }
        r0 = r0.m567u();	 Catch:{ RemoteException -> 0x009e }
        r0 = (com.google.android.gms.wearable.internal.as) r0;	 Catch:{ RemoteException -> 0x009e }
        r1 = new com.google.android.gms.wearable.internal.ce;	 Catch:{ RemoteException -> 0x009e }
        r2 = r8.f997b;	 Catch:{ RemoteException -> 0x009e }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x009e }
        r2 = r8.f998c;	 Catch:{ RemoteException -> 0x009e }
        r4 = r8.f999d;	 Catch:{ RemoteException -> 0x009e }
        r6 = r8.f1000e;	 Catch:{ RemoteException -> 0x009e }
        r0.mo1968a(r1, r2, r3, r4, r6);	 Catch:{ RemoteException -> 0x009e }
        r3.close();	 Catch:{ IOException -> 0x0061 }
        goto L_0x0033;
    L_0x0061:
        r0 = move-exception;
        r1 = "WearableClient";
        r2 = "Failed to close sourceFd";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0033;
    L_0x006a:
        r1 = move-exception;
        r1 = "WearableClient";
        r0 = java.lang.String.valueOf(r0);
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 46;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "File couldn't be opened for Channel.sendFile: ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r0 = r0.toString();
        android.util.Log.w(r1, r0);
        r0 = r8.f997b;
        r1 = new com.google.android.gms.common.api.Status;
        r2 = 13;
        r1.<init>(r2);
        r0.mo1880a(r1);
        goto L_0x0033;
    L_0x009e:
        r0 = move-exception;
        r1 = "WearableClient";
        r2 = "Channel.sendFile failed.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x00c1 }
        r0 = r8.f997b;	 Catch:{ all -> 0x00c1 }
        r1 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x00c1 }
        r2 = 8;
        r1.<init>(r2);	 Catch:{ all -> 0x00c1 }
        r0.mo1880a(r1);	 Catch:{ all -> 0x00c1 }
        r3.close();	 Catch:{ IOException -> 0x00b7 }
        goto L_0x0033;
    L_0x00b7:
        r0 = move-exception;
        r1 = "WearableClient";
        r2 = "Failed to close sourceFd";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0033;
    L_0x00c1:
        r0 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x00c6 }
    L_0x00c5:
        throw r0;
    L_0x00c6:
        r1 = move-exception;
        r2 = "WearableClient";
        r3 = "Failed to close sourceFd";
        android.util.Log.w(r2, r3, r1);
        goto L_0x00c5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ck.run():void");
    }
}
