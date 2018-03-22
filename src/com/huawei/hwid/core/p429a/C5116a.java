package com.huawei.hwid.core.p429a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.C5154a;
import com.huawei.hwid.core.p435d.C5173d;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: OpLogInfo */
public final class C5116a {
    private static volatile C5116a f18430a;
    private static final String f18431c = C5182m.m25057c();
    private String f18432b;
    private String f18433d;
    private Queue<C5117b> f18434e = new LinkedList();
    private Queue<C5117b> f18435f = new LinkedList();

    public static C5116a m24648a(Context context) {
        if (f18430a == null) {
            synchronized (C5116a.class) {
                if (f18430a == null) {
                    f18430a = new C5116a(context);
                }
            }
        }
        return f18430a;
    }

    private C5116a(Context context) {
        this.f18432b = m24649b(context);
        if (TextUtils.isEmpty(this.f18433d)) {
            this.f18433d = m24650c(context);
        }
    }

    public void m24653a(String str) {
        this.f18433d = str;
    }

    public synchronized void m24652a(C5117b c5117b) {
        if (this.f18434e.offer(c5117b) && this.f18434e.size() > 10) {
            this.f18434e.remove();
        }
    }

    public synchronized void m24655b(C5117b c5117b) {
        if (this.f18435f.offer(c5117b) && this.f18435f.size() > 10) {
            this.f18435f.remove();
        }
    }

    public synchronized void m24651a() {
        this.f18434e.clear();
    }

    public synchronized Queue<C5117b> m24654b() {
        return this.f18434e;
    }

    public synchronized Queue<C5117b> m24656c() {
        return this.f18435f;
    }

    public synchronized void m24657d() {
        for (C5117b a : this.f18435f) {
            m24652a(a);
        }
        this.f18435f.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        r6 = this;
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r2 = com.huawei.hwid.core.p435d.C5184o.m25071a(r1);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = "UTF-8";
        r3 = 1;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r2.startDocument(r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = 0;
        r3 = "OpLogReq";
        r2.startTag(r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = "clientVer";
        r3 = r6.f18432b;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        com.huawei.hwid.core.p435d.C5184o.m25072a(r2, r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = "osVersion";
        r3 = f18431c;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        com.huawei.hwid.core.p435d.C5184o.m25072a(r2, r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = "channel";
        r3 = r6.f18433d;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        com.huawei.hwid.core.p435d.C5184o.m25072a(r2, r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = r6.f18434e;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        if (r0 == 0) goto L_0x007b;
    L_0x0032:
        r0 = r6.f18434e;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = r0.size();	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r3 = 0;
        r4 = "logList";
        r3 = r2.startTag(r3, r4);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r4 = 0;
        r5 = "size";
        r0 = java.lang.String.valueOf(r0);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r3.attribute(r4, r5, r0);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = r6.f18434e;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r3 = r0.iterator();	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
    L_0x0050:
        r0 = r3.hasNext();	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        if (r0 == 0) goto L_0x0075;
    L_0x0056:
        r0 = r3.next();	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = (com.huawei.hwid.core.p429a.C5117b) r0;	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r4 = "Log";
        r0 = r0.toString();	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        com.huawei.hwid.core.p435d.C5184o.m25072a(r2, r4, r0);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        goto L_0x0050;
    L_0x0066:
        r0 = move-exception;
        r2 = "OpLogInfo";
        r3 = "toString";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r0);	 Catch:{ all -> 0x00fa }
        r0 = "";
        r1.close();	 Catch:{ IOException -> 0x00a0 }
    L_0x0074:
        return r0;
    L_0x0075:
        r0 = 0;
        r3 = "logList";
        r2.endTag(r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
    L_0x007b:
        r0 = 0;
        r3 = "OpLogReq";
        r2.endTag(r0, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r2.endDocument();	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r0 = "UTF-8";
        r0 = r1.toString(r0);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r2 = "OpLogInfo";
        r3 = "packedString";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r2, r3);	 Catch:{ IllegalArgumentException -> 0x0066, IllegalStateException -> 0x00ab, IOException -> 0x00c5, Exception -> 0x00df }
        r1.close();	 Catch:{ IOException -> 0x0095 }
        goto L_0x0074;
    L_0x0095:
        r1 = move-exception;
        r2 = "OpLogInfo";
        r3 = r1.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r1);
        goto L_0x0074;
    L_0x00a0:
        r1 = move-exception;
        r2 = "OpLogInfo";
        r3 = r1.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r1);
        goto L_0x0074;
    L_0x00ab:
        r0 = move-exception;
        r2 = "OpLogInfo";
        r3 = "toString";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r0);	 Catch:{ all -> 0x00fa }
        r0 = "";
        r1.close();	 Catch:{ IOException -> 0x00ba }
        goto L_0x0074;
    L_0x00ba:
        r1 = move-exception;
        r2 = "OpLogInfo";
        r3 = r1.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r1);
        goto L_0x0074;
    L_0x00c5:
        r0 = move-exception;
        r2 = "OpLogInfo";
        r3 = "toString";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r0);	 Catch:{ all -> 0x00fa }
        r0 = "";
        r1.close();	 Catch:{ IOException -> 0x00d4 }
        goto L_0x0074;
    L_0x00d4:
        r1 = move-exception;
        r2 = "OpLogInfo";
        r3 = r1.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r1);
        goto L_0x0074;
    L_0x00df:
        r0 = move-exception;
        r2 = "OpLogInfo";
        r3 = "toString";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r0);	 Catch:{ all -> 0x00fa }
        r0 = "";
        r1.close();	 Catch:{ IOException -> 0x00ee }
        goto L_0x0074;
    L_0x00ee:
        r1 = move-exception;
        r2 = "OpLogInfo";
        r3 = r1.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r1);
        goto L_0x0074;
    L_0x00fa:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00ff }
    L_0x00fe:
        throw r0;
    L_0x00ff:
        r1 = move-exception;
        r2 = "OpLogInfo";
        r3 = r1.getMessage();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r2, r3, r1);
        goto L_0x00fe;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.core.a.a.toString():java.lang.String");
    }

    private String m24649b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String str = "";
        if ("com.huawei.hwid".equals(context.getPackageName())) {
            try {
                str = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable e) {
                C5165e.m24911d("OpLogInfo", e.getMessage(), e);
            }
            return "HwID " + str;
        }
        return "SDK " + HwAccountConstants.SDK_VERSION;
    }

    private String m24650c(Context context) {
        String str = "";
        if (C5173d.m24993b()) {
            return HwAccountConstants.OOBE_CHANNEL;
        }
        return C5154a.m24846a(context, C5173d.m24994c());
    }
}
