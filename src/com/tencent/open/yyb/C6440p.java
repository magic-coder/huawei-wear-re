package com.tencent.open.yyb;

import android.os.AsyncTask;
import android.os.Bundle;

/* compiled from: ProGuard */
class C6440p extends AsyncTask<Bundle, Void, Void> {
    private C6440p() {
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m29357a((Bundle[]) objArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.Void m29357a(android.os.Bundle... r6) {
        /*
        r5 = this;
        r4 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r4;
    L_0x0004:
        r1 = "http://analy.qq.com/cgi-bin/mapp_apptrace";
        r0 = r6.length;
        r2 = 2;
        if (r0 != r2) goto L_0x006a;
    L_0x000a:
        r0 = 1;
        r0 = r6[r0];
        r2 = "uri";
        r0 = r0.getString(r2);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x006a;
    L_0x001a:
        r1 = 0;
        r2 = "GET";
        r3 = 0;
        r3 = r6[r3];	 Catch:{ Exception -> 0x0049 }
        r0 = com.tencent.open.p532d.C6396i.m29190a(r1, r0, r2, r3);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.f22213a;	 Catch:{ Exception -> 0x0049 }
        r0 = com.tencent.open.p532d.C6412y.m29260d(r0);	 Catch:{ Exception -> 0x0049 }
        r1 = "ret";
        r0 = r0.getInt(r1);	 Catch:{ Exception -> 0x0049 }
        r1 = "openSDK_LOG";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0049 }
        r2.<init>();	 Catch:{ Exception -> 0x0049 }
        r3 = "-->(ViaAsyncTask)doInBackground : ret = ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0049 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0049 }
        com.tencent.open.p541a.C6367n.m29107b(r1, r0);	 Catch:{ Exception -> 0x0049 }
        goto L_0x0003;
    L_0x0049:
        r0 = move-exception;
        r1 = "openSDK_LOG";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "-->(ViaAsyncTask)doInBackground : Exception = ";
        r2 = r2.append(r3);
        r3 = r0.toString();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.open.p541a.C6367n.m29107b(r1, r2);
        r0.printStackTrace();
        goto L_0x0003;
    L_0x006a:
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.yyb.p.a(android.os.Bundle[]):java.lang.Void");
    }
}
