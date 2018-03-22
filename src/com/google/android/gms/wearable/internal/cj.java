package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.internal.C0502h;

class cj implements Runnable {
    final /* synthetic */ Uri f991a;
    final /* synthetic */ C0502h f992b;
    final /* synthetic */ boolean f993c;
    final /* synthetic */ String f994d;
    final /* synthetic */ ch f995e;

    cj(ch chVar, Uri uri, C0502h c0502h, boolean z, String str) {
        this.f995e = chVar;
        this.f991a = uri;
        this.f992b = c0502h;
        this.f993c = z;
        this.f994d = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = "WearableClient";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = "WearableClient";
        r1 = "Executing receiveFileFromChannelTask";
        android.util.Log.v(r0, r1);
    L_0x0010:
        r0 = "file";
        r1 = r4.f991a;
        r1 = r1.getScheme();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0034;
    L_0x001e:
        r0 = "WearableClient";
        r1 = "Channel.receiveFile used with non-file URI";
        android.util.Log.w(r0, r1);
        r0 = r4.f992b;
        r1 = new com.google.android.gms.common.api.Status;
        r2 = 10;
        r3 = "Channel.receiveFile used with non-file URI";
        r1.<init>(r2, r3);
        r0.mo1880a(r1);
    L_0x0033:
        return;
    L_0x0034:
        r1 = new java.io.File;
        r0 = r4.f991a;
        r0 = r0.getPath();
        r1.<init>(r0);
        r2 = 671088640; // 0x28000000 float:7.1054274E-15 double:3.315618423E-315;
        r0 = r4.f993c;
        if (r0 == 0) goto L_0x006d;
    L_0x0045:
        r0 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
    L_0x0047:
        r0 = r0 | r2;
        r1 = android.os.ParcelFileDescriptor.open(r1, r0);	 Catch:{ FileNotFoundException -> 0x006f }
        r0 = r4.f995e;	 Catch:{ RemoteException -> 0x00a3 }
        r0 = r0.m567u();	 Catch:{ RemoteException -> 0x00a3 }
        r0 = (com.google.android.gms.wearable.internal.as) r0;	 Catch:{ RemoteException -> 0x00a3 }
        r2 = new com.google.android.gms.wearable.internal.cg;	 Catch:{ RemoteException -> 0x00a3 }
        r3 = r4.f992b;	 Catch:{ RemoteException -> 0x00a3 }
        r2.<init>(r3);	 Catch:{ RemoteException -> 0x00a3 }
        r3 = r4.f994d;	 Catch:{ RemoteException -> 0x00a3 }
        r0.mo1967a(r2, r3, r1);	 Catch:{ RemoteException -> 0x00a3 }
        r1.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0033;
    L_0x0064:
        r0 = move-exception;
        r1 = "WearableClient";
        r2 = "Failed to close targetFd";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0033;
    L_0x006d:
        r0 = 0;
        goto L_0x0047;
    L_0x006f:
        r0 = move-exception;
        r0 = "WearableClient";
        r1 = java.lang.String.valueOf(r1);
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 49;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "File couldn't be opened for Channel.receiveFile: ";
        r2 = r3.append(r2);
        r1 = r2.append(r1);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r0 = r4.f992b;
        r1 = new com.google.android.gms.common.api.Status;
        r2 = 13;
        r1.<init>(r2);
        r0.mo1880a(r1);
        goto L_0x0033;
    L_0x00a3:
        r0 = move-exception;
        r2 = "WearableClient";
        r3 = "Channel.receiveFile failed.";
        android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x00c6 }
        r0 = r4.f992b;	 Catch:{ all -> 0x00c6 }
        r2 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x00c6 }
        r3 = 8;
        r2.<init>(r3);	 Catch:{ all -> 0x00c6 }
        r0.mo1880a(r2);	 Catch:{ all -> 0x00c6 }
        r1.close();	 Catch:{ IOException -> 0x00bc }
        goto L_0x0033;
    L_0x00bc:
        r0 = move-exception;
        r1 = "WearableClient";
        r2 = "Failed to close targetFd";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0033;
    L_0x00c6:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00cb }
    L_0x00ca:
        throw r0;
    L_0x00cb:
        r1 = move-exception;
        r2 = "WearableClient";
        r3 = "Failed to close targetFd";
        android.util.Log.w(r2, r3, r1);
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.cj.run():void");
    }
}
