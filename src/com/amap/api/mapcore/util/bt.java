package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: ProxyUtil */
public class bt {
    public static Proxy m15765a(Context context) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return m15766a(context, new URI("http://restapi.amap.com"));
            }
            return m15769b(context);
        } catch (Throwable e) {
            cd.m15825a(e, "ProxyUtil", "getProxy");
            return null;
        } catch (Throwable e2) {
            cd.m15825a(e2, "ProxyUtil", "getProxy");
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy m15769b(android.content.Context r12) {
        /*
        r10 = 0;
        r6 = 80;
        r9 = 1;
        r8 = -1;
        r7 = 0;
        r0 = com.amap.api.mapcore.util.bq.m15735m(r12);
        if (r0 != 0) goto L_0x013a;
    L_0x000c:
        r0 = "content://telephony/carriers/preferapn";
        r1 = android.net.Uri.parse(r0);
        r0 = r12.getContentResolver();
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ SecurityException -> 0x00a4, Throwable -> 0x0106, all -> 0x0127 }
        if (r2 == 0) goto L_0x01ad;
    L_0x0020:
        r0 = r2.moveToFirst();	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x01ad;
    L_0x0026:
        r0 = "apn";
        r0 = r2.getColumnIndex(r0);	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        r0 = r2.getString(r0);	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x0038;
    L_0x0032:
        r1 = java.util.Locale.US;	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        r0 = r0.toLowerCase(r1);	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
    L_0x0038:
        if (r0 == 0) goto L_0x007a;
    L_0x003a:
        r1 = "ctwap";
        r1 = r0.contains(r1);	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        if (r1 == 0) goto L_0x007a;
    L_0x0042:
        r3 = m15764a();	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        r0 = m15768b();	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SecurityException -> 0x0180, Throwable -> 0x016a }
        if (r1 != 0) goto L_0x01b3;
    L_0x0050:
        r1 = "null";
        r1 = r3.equals(r1);	 Catch:{ SecurityException -> 0x0180, Throwable -> 0x016a }
        if (r1 != 0) goto L_0x01b3;
    L_0x0058:
        r1 = r9;
    L_0x0059:
        if (r1 != 0) goto L_0x01b0;
    L_0x005b:
        r1 = "10.0.0.200";
    L_0x005d:
        if (r0 != r8) goto L_0x0060;
    L_0x005f:
        r0 = r6;
    L_0x0060:
        r8 = r0;
        r0 = r1;
    L_0x0062:
        if (r2 == 0) goto L_0x0067;
    L_0x0064:
        r2.close();	 Catch:{ Throwable -> 0x0155 }
    L_0x0067:
        r3 = r0;
    L_0x0068:
        r0 = m15767a(r3, r8);	 Catch:{ Throwable -> 0x012f }
        if (r0 == 0) goto L_0x013a;
    L_0x006e:
        r0 = new java.net.Proxy;	 Catch:{ Throwable -> 0x012f }
        r1 = java.net.Proxy.Type.HTTP;	 Catch:{ Throwable -> 0x012f }
        r2 = java.net.InetSocketAddress.createUnresolved(r3, r8);	 Catch:{ Throwable -> 0x012f }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x012f }
    L_0x0079:
        return r0;
    L_0x007a:
        if (r0 == 0) goto L_0x01ad;
    L_0x007c:
        r1 = "wap";
        r0 = r0.contains(r1);	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x01ad;
    L_0x0085:
        r3 = m15764a();	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        r1 = m15768b();	 Catch:{ SecurityException -> 0x017a, Throwable -> 0x0167 }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SecurityException -> 0x018f, Throwable -> 0x0173 }
        if (r0 != 0) goto L_0x01a9;
    L_0x0093:
        r0 = "null";
        r0 = r3.equals(r0);	 Catch:{ SecurityException -> 0x018f, Throwable -> 0x0173 }
        if (r0 != 0) goto L_0x01a9;
    L_0x009b:
        r0 = r9;
    L_0x009c:
        if (r0 != 0) goto L_0x01a6;
    L_0x009e:
        r0 = "10.0.0.172";
    L_0x00a0:
        if (r1 != r8) goto L_0x01a3;
    L_0x00a2:
        r8 = r6;
        goto L_0x0062;
    L_0x00a4:
        r0 = move-exception;
        r1 = r7;
        r2 = r8;
        r3 = r7;
    L_0x00a8:
        r4 = "ProxyUtil";
        r5 = "getHostProxy";
        com.amap.api.mapcore.util.cd.m15825a(r0, r4, r5);	 Catch:{ all -> 0x0164 }
        r0 = com.amap.api.mapcore.util.bq.m15737o(r12);	 Catch:{ all -> 0x0164 }
        if (r0 == 0) goto L_0x01a0;
    L_0x00b5:
        r2 = java.util.Locale.US;	 Catch:{ all -> 0x0164 }
        r4 = r0.toLowerCase(r2);	 Catch:{ all -> 0x0164 }
        r0 = m15764a();	 Catch:{ all -> 0x0164 }
        r2 = m15768b();	 Catch:{ all -> 0x0164 }
        r5 = "ctwap";
        r5 = r4.indexOf(r5);	 Catch:{ all -> 0x0164 }
        if (r5 == r8) goto L_0x00e8;
    L_0x00cb:
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0164 }
        if (r4 != 0) goto L_0x00db;
    L_0x00d1:
        r4 = "null";
        r4 = r0.equals(r4);	 Catch:{ all -> 0x0164 }
        if (r4 != 0) goto L_0x00db;
    L_0x00d9:
        r10 = r9;
        r3 = r0;
    L_0x00db:
        if (r10 != 0) goto L_0x00df;
    L_0x00dd:
        r3 = "10.0.0.200";
    L_0x00df:
        if (r2 != r8) goto L_0x01a0;
    L_0x00e1:
        if (r1 == 0) goto L_0x00e6;
    L_0x00e3:
        r1.close();	 Catch:{ Throwable -> 0x0149 }
    L_0x00e6:
        r8 = r6;
        goto L_0x0068;
    L_0x00e8:
        r5 = "wap";
        r4 = r4.indexOf(r5);	 Catch:{ all -> 0x0164 }
        if (r4 == r8) goto L_0x01a0;
    L_0x00f1:
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0164 }
        if (r2 != 0) goto L_0x019c;
    L_0x00f7:
        r2 = "null";
        r2 = r0.equals(r2);	 Catch:{ all -> 0x0164 }
        if (r2 != 0) goto L_0x019c;
    L_0x00ff:
        r2 = r9;
    L_0x0100:
        if (r2 != 0) goto L_0x0104;
    L_0x0102:
        r0 = "10.0.0.200";
    L_0x0104:
        r3 = r0;
        goto L_0x00e1;
    L_0x0106:
        r0 = move-exception;
        r2 = r7;
        r3 = r7;
    L_0x0109:
        r1 = "ProxyUtil";
        r4 = "getHostProxy1";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r4);	 Catch:{ all -> 0x0162 }
        r0.printStackTrace();	 Catch:{ all -> 0x0162 }
        if (r2 == 0) goto L_0x0068;
    L_0x0115:
        r2.close();	 Catch:{ Throwable -> 0x011a }
        goto L_0x0068;
    L_0x011a:
        r0 = move-exception;
        r1 = "ProxyUtil";
        r2 = "getHostProxy2";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);
        r0.printStackTrace();
        goto L_0x0068;
    L_0x0127:
        r0 = move-exception;
        r2 = r7;
    L_0x0129:
        if (r2 == 0) goto L_0x012e;
    L_0x012b:
        r2.close();	 Catch:{ Throwable -> 0x013d }
    L_0x012e:
        throw r0;
    L_0x012f:
        r0 = move-exception;
        r1 = "ProxyUtil";
        r2 = "getHostProxy2";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);
        r0.printStackTrace();
    L_0x013a:
        r0 = r7;
        goto L_0x0079;
    L_0x013d:
        r1 = move-exception;
        r2 = "ProxyUtil";
        r3 = "getHostProxy2";
        com.amap.api.mapcore.util.cd.m15825a(r1, r2, r3);
        r1.printStackTrace();
        goto L_0x012e;
    L_0x0149:
        r0 = move-exception;
        r1 = "ProxyUtil";
        r2 = "getHostProxy2";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);
        r0.printStackTrace();
        goto L_0x00e6;
    L_0x0155:
        r1 = move-exception;
        r2 = "ProxyUtil";
        r3 = "getHostProxy2";
        com.amap.api.mapcore.util.cd.m15825a(r1, r2, r3);
        r1.printStackTrace();
        goto L_0x0067;
    L_0x0162:
        r0 = move-exception;
        goto L_0x0129;
    L_0x0164:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0129;
    L_0x0167:
        r0 = move-exception;
        r3 = r7;
        goto L_0x0109;
    L_0x016a:
        r1 = move-exception;
        r8 = r0;
        r3 = r7;
        r0 = r1;
        goto L_0x0109;
    L_0x016f:
        r1 = move-exception;
        r8 = r0;
        r0 = r1;
        goto L_0x0109;
    L_0x0173:
        r0 = move-exception;
        r8 = r1;
        r3 = r7;
        goto L_0x0109;
    L_0x0177:
        r0 = move-exception;
        r8 = r1;
        goto L_0x0109;
    L_0x017a:
        r0 = move-exception;
        r1 = r2;
        r3 = r7;
        r2 = r8;
        goto L_0x00a8;
    L_0x0180:
        r1 = move-exception;
        r3 = r7;
        r11 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x00a8;
    L_0x0188:
        r1 = move-exception;
        r11 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r11;
        goto L_0x00a8;
    L_0x018f:
        r0 = move-exception;
        r3 = r7;
        r11 = r1;
        r1 = r2;
        r2 = r11;
        goto L_0x00a8;
    L_0x0196:
        r0 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
        goto L_0x00a8;
    L_0x019c:
        r2 = r10;
        r0 = r3;
        goto L_0x0100;
    L_0x01a0:
        r6 = r2;
        goto L_0x00e1;
    L_0x01a3:
        r8 = r1;
        goto L_0x0062;
    L_0x01a6:
        r0 = r3;
        goto L_0x00a0;
    L_0x01a9:
        r0 = r10;
        r3 = r7;
        goto L_0x009c;
    L_0x01ad:
        r0 = r7;
        goto L_0x0062;
    L_0x01b0:
        r1 = r3;
        goto L_0x005d;
    L_0x01b3:
        r1 = r10;
        r3 = r7;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bt.b(android.content.Context):java.net.Proxy");
    }

    private static boolean m15767a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    private static String m15764a() {
        String defaultHost;
        try {
            defaultHost = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            cd.m15825a(th, "ProxyUtil", "getDefHost");
            defaultHost = null;
        }
        if (defaultHost == null) {
            return "null";
        }
        return defaultHost;
    }

    private static Proxy m15766a(Context context, URI uri) {
        if (bq.m15735m(context) == 0) {
            try {
                List select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty()) {
                    return null;
                }
                Proxy proxy = (Proxy) select.get(0);
                return (proxy == null || proxy.type() == Type.DIRECT) ? null : proxy;
            } catch (Throwable th) {
                cd.m15825a(th, "ProxyUtil", "getProxySelectorCfg");
            }
        }
        return null;
    }

    private static int m15768b() {
        int i = -1;
        try {
            i = android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            cd.m15825a(th, "ProxyUtil", "getDefPort");
        }
        return i;
    }
}
