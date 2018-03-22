package com.huawei.hwcloudmodel.p402a;

import javax.net.ssl.HostnameVerifier;

/* compiled from: ImageTransferAdapter */
public class C4672b {
    public static final HostnameVerifier f17086a = new C4673c();

    public static void m22421a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m22420a(java.lang.String r10, android.content.Context r11) {
        /*
        r1 = 0;
        r9 = 1;
        r3 = 0;
        r0 = "ImageTransferAdapter";
        r2 = new java.lang.Object[r9];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "imgUrl=";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r2[r3] = r4;
        com.huawei.v.c.b(r0, r2);
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00af }
        r0.<init>(r10);	 Catch:{ MalformedURLException -> 0x00af }
    L_0x0024:
        if (r0 == 0) goto L_0x0172;
    L_0x0026:
        r2 = "ImageTransferAdapter";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6.<init>();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r7 = "fileURL!=null,fileURL=";
        r6 = r6.append(r7);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6 = r6.append(r0);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6 = r6.toString();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r4[r5] = r6;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        com.huawei.v.c.b(r2, r4);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = "https";
        r2 = r10.contains(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        if (r2 == 0) goto L_0x0130;
    L_0x004c:
        r2 = "ImageTransferAdapter";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r5 = 0;
        r6 = "imgUrl.contains(https)";
        r4[r5] = r6;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        com.huawei.v.c.b(r2, r4);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = r0.openConnection();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = com.huawei.hwcommonmodel.d.d.b();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        if (r2 == 0) goto L_0x00d3;
    L_0x0065:
        com.huawei.hwcloudmodel.p402a.C4672b.m22421a();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
    L_0x0068:
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = 1;
        r0.setDoInput(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
    L_0x0070:
        r2 = 1;
        r0.setDoInput(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0.connect();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = r0.getInputStream();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = "ImageTransferAdapter";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6.<init>();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r7 = "conn.getInputStream()=";
        r6 = r6.append(r7);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6 = r6.append(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6 = r6.toString();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r4[r5] = r6;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        com.huawei.v.c.b(r0, r4);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r4.<init>();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r5 = new byte[r0];	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = r3;
    L_0x00a3:
        r6 = r2.read(r5);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        if (r6 <= 0) goto L_0x0145;
    L_0x00a9:
        r7 = 0;
        r4.write(r5, r7, r6);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = r0 + r6;
        goto L_0x00a3;
    L_0x00af:
        r0 = move-exception;
        r2 = "ImageTransferAdapter";
        r4 = new java.lang.Object[r9];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Exception err = ";
        r5 = r5.append(r6);
        r0 = r0.getMessage();
        r0 = r5.append(r0);
        r0 = r0.toString();
        r4[r3] = r0;
        com.huawei.v.c.e(r2, r4);
        r0 = r1;
        goto L_0x0024;
    L_0x00d3:
        r2 = new com.huawei.hwcommonmodel.d.i;	 Catch:{ Exception -> 0x010b, RuntimeException -> 0x00de }
        r2.<init>();	 Catch:{ Exception -> 0x010b, RuntimeException -> 0x00de }
    L_0x00d8:
        if (r2 == 0) goto L_0x0068;
    L_0x00da:
        r0.setSSLSocketFactory(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        goto L_0x0068;
    L_0x00de:
        r0 = move-exception;
        r2 = "ImageTransferAdapter";
        r4 = new java.lang.Object[r9];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "RuntimeException,e=";
        r5 = r5.append(r6);
        r0 = r0.getMessage();
        r0 = r5.append(r0);
        r0 = r0.toString();
        r4[r3] = r0;
        com.huawei.v.c.b(r2, r4);
    L_0x00ff:
        r0 = "ImageTransferAdapter";
        r2 = new java.lang.Object[r9];
        r4 = "loadRmoteImage finish";
        r2[r3] = r4;
        com.huawei.v.c.b(r0, r2);
        return r1;
    L_0x010b:
        r2 = move-exception;
        r4 = "ImageTransferAdapter";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r7.<init>();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r8 = "Exception e = ";
        r7 = r7.append(r8);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = r2.getMessage();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = r7.append(r2);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = r2.toString();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r5[r6] = r2;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r2 = r1;
        goto L_0x00d8;
    L_0x0130:
        r2 = "ImageTransferAdapter";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r5 = 0;
        r6 = "imgUrl not  contains(https)";
        r4[r5] = r6;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        com.huawei.v.c.b(r2, r4);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = r0.openConnection();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        goto L_0x0070;
    L_0x0145:
        r2 = r4.toByteArray();	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
        r4 = 0;
        r0 = android.graphics.BitmapFactory.decodeByteArray(r2, r4, r0);	 Catch:{ RuntimeException -> 0x00de, Exception -> 0x0150 }
    L_0x014e:
        r1 = r0;
        goto L_0x00ff;
    L_0x0150:
        r0 = move-exception;
        r2 = "ImageTransferAdapter";
        r4 = new java.lang.Object[r9];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Exception,e=";
        r5 = r5.append(r6);
        r0 = r0.getMessage();
        r0 = r5.append(r0);
        r0 = r0.toString();
        r4[r3] = r0;
        com.huawei.v.c.b(r2, r4);
        goto L_0x00ff;
    L_0x0172:
        r0 = r1;
        goto L_0x014e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwcloudmodel.a.b.a(java.lang.String, android.content.Context):android.graphics.Bitmap");
    }
}
