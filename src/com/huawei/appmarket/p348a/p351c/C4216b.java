package com.huawei.appmarket.p348a.p351c;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import java.io.IOException;

public class C4216b {
    public static C4217c m20481a(String str, boolean z, boolean z2) {
        return C4216b.m20483a(new String[]{str}, z, z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.appmarket.p348a.p351c.C4217c m20482a(java.lang.String[] r13, java.lang.String r14, boolean r15) {
        /*
        r0 = 0;
        r3 = 0;
        r2 = -1;
        if (r13 == 0) goto L_0x0008;
    L_0x0005:
        r1 = r13.length;
        if (r1 != 0) goto L_0x0015;
    L_0x0008:
        r0 = "ShellUtils";
        r1 = "commands is null or length is 0";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r0, r1);
        r0 = new com.huawei.appmarket.a.c.c;
        r0.<init>(r2, r3, r3);
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = "ShellUtils";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = " beging to execCommand :";
        r4 = r4.append(r5);
        r5 = r13[r0];
        r4 = r4.append(r5);
        r5 = "::cmd:";
        r4 = r4.append(r5);
        r4 = r4.append(r14);
        r5 = ":isNeed:";
        r4 = r4.append(r5);
        r4 = r4.append(r15);
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r1, r4);
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x0285, Exception -> 0x019e, all -> 0x01f9 }
        r8 = r1.exec(r14);	 Catch:{ IOException -> 0x0285, Exception -> 0x019e, all -> 0x01f9 }
        r4 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x028f, Exception -> 0x024f, all -> 0x023f }
        r1 = r8.getOutputStream();	 Catch:{ IOException -> 0x028f, Exception -> 0x024f, all -> 0x023f }
        r4.<init>(r1);	 Catch:{ IOException -> 0x028f, Exception -> 0x024f, all -> 0x023f }
        r1 = r13.length;	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
    L_0x0055:
        if (r0 >= r1) goto L_0x00b5;
    L_0x0057:
        r5 = r13[r0];	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        if (r5 != 0) goto L_0x005e;
    L_0x005b:
        r0 = r0 + 1;
        goto L_0x0055;
    L_0x005e:
        r6 = "UTF-8";
        r5 = r5.getBytes(r6);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r4.write(r5);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r5 = "\n";
        r4.writeBytes(r5);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r4.flush();	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        goto L_0x005b;
    L_0x0070:
        r0 = move-exception;
        r5 = r4;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        r4 = r0;
        r0 = r3;
    L_0x0077:
        r9 = "execCommand error";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x024b }
        r10.<init>();	 Catch:{ all -> 0x024b }
        r11 = " beging to silent process IOException :";
        r10 = r10.append(r11);	 Catch:{ all -> 0x024b }
        r4 = r4.toString();	 Catch:{ all -> 0x024b }
        r4 = r10.append(r4);	 Catch:{ all -> 0x024b }
        r4 = r4.toString();	 Catch:{ all -> 0x024b }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r9, r4);	 Catch:{ all -> 0x024b }
        if (r5 == 0) goto L_0x0098;
    L_0x0095:
        r5.close();	 Catch:{ IOException -> 0x017a }
    L_0x0098:
        if (r7 == 0) goto L_0x009d;
    L_0x009a:
        r7.close();	 Catch:{ IOException -> 0x0186 }
    L_0x009d:
        if (r6 == 0) goto L_0x00a2;
    L_0x009f:
        r6.close();	 Catch:{ IOException -> 0x0192 }
    L_0x00a2:
        if (r8 == 0) goto L_0x00a7;
    L_0x00a4:
        r8.destroy();
    L_0x00a7:
        r4 = new com.huawei.appmarket.a.c.c;
        if (r1 != 0) goto L_0x0233;
    L_0x00ab:
        r1 = r3;
    L_0x00ac:
        if (r0 != 0) goto L_0x0239;
    L_0x00ae:
        r0 = r3;
    L_0x00af:
        r4.<init>(r2, r1, r0);
        r0 = r4;
        goto L_0x0014;
    L_0x00b5:
        r0 = "exit\n";
        r4.writeBytes(r0);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r4.flush();	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r2 = r8.waitFor();	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r0 = "TAG";
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r1.<init>();	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r5 = " beging to silent process resultcode :";
        r1 = r1.append(r5);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r0, r1);	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        if (r15 == 0) goto L_0x02bc;
    L_0x00db:
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r5.<init>();	 Catch:{ IOException -> 0x0070, Exception -> 0x0258, all -> 0x0243 }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0298, Exception -> 0x0261, all -> 0x0243 }
        r1.<init>();	 Catch:{ IOException -> 0x0298, Exception -> 0x0261, all -> 0x0243 }
        r7 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x02a1, Exception -> 0x026a, all -> 0x0243 }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x02a1, Exception -> 0x026a, all -> 0x0243 }
        r6 = r8.getInputStream();	 Catch:{ IOException -> 0x02a1, Exception -> 0x026a, all -> 0x0243 }
        r9 = "UTF-8";
        r0.<init>(r6, r9);	 Catch:{ IOException -> 0x02a1, Exception -> 0x026a, all -> 0x0243 }
        r7.<init>(r0);	 Catch:{ IOException -> 0x02a1, Exception -> 0x026a, all -> 0x0243 }
        r6 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x02ab, Exception -> 0x0274, all -> 0x0246 }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x02ab, Exception -> 0x0274, all -> 0x0246 }
        r9 = r8.getErrorStream();	 Catch:{ IOException -> 0x02ab, Exception -> 0x0274, all -> 0x0246 }
        r10 = "UTF-8";
        r0.<init>(r9, r10);	 Catch:{ IOException -> 0x02ab, Exception -> 0x0274, all -> 0x0246 }
        r6.<init>(r0);	 Catch:{ IOException -> 0x02ab, Exception -> 0x0274, all -> 0x0246 }
        r0 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r0 = com.huawei.appmarket.p348a.p350b.C4214b.m20475a(r7, r0);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r5.append(r0);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r0 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r0 = com.huawei.appmarket.p348a.p350b.C4214b.m20475a(r6, r0);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r1.append(r0);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r0 = "TAG";
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r9.<init>();	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r10 = " beging to silent process result :";
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r10 = r5.toString();	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r10 = "::error:";
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r10 = r1.toString();	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r9 = r9.toString();	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r0, r9);	 Catch:{ IOException -> 0x02b4, Exception -> 0x027d, all -> 0x0248 }
        r0 = r1;
        r1 = r5;
    L_0x0143:
        if (r4 == 0) goto L_0x0148;
    L_0x0145:
        r4.close();	 Catch:{ IOException -> 0x0159 }
    L_0x0148:
        if (r7 == 0) goto L_0x014d;
    L_0x014a:
        r7.close();	 Catch:{ IOException -> 0x0164 }
    L_0x014d:
        if (r6 == 0) goto L_0x0152;
    L_0x014f:
        r6.close();	 Catch:{ IOException -> 0x016f }
    L_0x0152:
        if (r8 == 0) goto L_0x00a7;
    L_0x0154:
        r8.destroy();
        goto L_0x00a7;
    L_0x0159:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x0148;
    L_0x0164:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x014d;
    L_0x016f:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x0152;
    L_0x017a:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x0098;
    L_0x0186:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x009d;
    L_0x0192:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x00a2;
    L_0x019e:
        r0 = move-exception;
        r4 = r0;
        r5 = r3;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        r8 = r3;
        r0 = r3;
    L_0x01a6:
        r9 = "execCommand error";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x024b }
        r10.<init>();	 Catch:{ all -> 0x024b }
        r11 = " beging to silent process Exception :";
        r10 = r10.append(r11);	 Catch:{ all -> 0x024b }
        r4 = r4.toString();	 Catch:{ all -> 0x024b }
        r4 = r10.append(r4);	 Catch:{ all -> 0x024b }
        r4 = r4.toString();	 Catch:{ all -> 0x024b }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r9, r4);	 Catch:{ all -> 0x024b }
        if (r5 == 0) goto L_0x01c7;
    L_0x01c4:
        r5.close();	 Catch:{ IOException -> 0x01d8 }
    L_0x01c7:
        if (r7 == 0) goto L_0x01cc;
    L_0x01c9:
        r7.close();	 Catch:{ IOException -> 0x01e3 }
    L_0x01cc:
        if (r6 == 0) goto L_0x01d1;
    L_0x01ce:
        r6.close();	 Catch:{ IOException -> 0x01ee }
    L_0x01d1:
        if (r8 == 0) goto L_0x00a7;
    L_0x01d3:
        r8.destroy();
        goto L_0x00a7;
    L_0x01d8:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x01c7;
    L_0x01e3:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x01cc;
    L_0x01ee:
        r4 = move-exception;
        r5 = "execCommand error";
        r4 = r4.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r5, r4);
        goto L_0x01d1;
    L_0x01f9:
        r0 = move-exception;
        r4 = r3;
        r7 = r3;
        r8 = r3;
    L_0x01fd:
        if (r4 == 0) goto L_0x0202;
    L_0x01ff:
        r4.close();	 Catch:{ IOException -> 0x0212 }
    L_0x0202:
        if (r7 == 0) goto L_0x0207;
    L_0x0204:
        r7.close();	 Catch:{ IOException -> 0x021d }
    L_0x0207:
        if (r3 == 0) goto L_0x020c;
    L_0x0209:
        r3.close();	 Catch:{ IOException -> 0x0228 }
    L_0x020c:
        if (r8 == 0) goto L_0x0211;
    L_0x020e:
        r8.destroy();
    L_0x0211:
        throw r0;
    L_0x0212:
        r1 = move-exception;
        r2 = "execCommand error";
        r1 = r1.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r2, r1);
        goto L_0x0202;
    L_0x021d:
        r1 = move-exception;
        r2 = "execCommand error";
        r1 = r1.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r2, r1);
        goto L_0x0207;
    L_0x0228:
        r1 = move-exception;
        r2 = "execCommand error";
        r1 = r1.toString();
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r2, r1);
        goto L_0x020c;
    L_0x0233:
        r1 = r1.toString();
        goto L_0x00ac;
    L_0x0239:
        r0 = r0.toString();
        goto L_0x00af;
    L_0x023f:
        r0 = move-exception;
        r4 = r3;
        r7 = r3;
        goto L_0x01fd;
    L_0x0243:
        r0 = move-exception;
        r7 = r3;
        goto L_0x01fd;
    L_0x0246:
        r0 = move-exception;
        goto L_0x01fd;
    L_0x0248:
        r0 = move-exception;
        r3 = r6;
        goto L_0x01fd;
    L_0x024b:
        r0 = move-exception;
        r4 = r5;
        r3 = r6;
        goto L_0x01fd;
    L_0x024f:
        r0 = move-exception;
        r4 = r0;
        r5 = r3;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        r0 = r3;
        goto L_0x01a6;
    L_0x0258:
        r0 = move-exception;
        r5 = r4;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        r4 = r0;
        r0 = r3;
        goto L_0x01a6;
    L_0x0261:
        r0 = move-exception;
        r1 = r5;
        r6 = r3;
        r7 = r3;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        goto L_0x01a6;
    L_0x026a:
        r0 = move-exception;
        r6 = r3;
        r7 = r3;
        r12 = r1;
        r1 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r12;
        goto L_0x01a6;
    L_0x0274:
        r0 = move-exception;
        r6 = r3;
        r12 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r12;
        goto L_0x01a6;
    L_0x027d:
        r0 = move-exception;
        r12 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r4;
        r4 = r12;
        goto L_0x01a6;
    L_0x0285:
        r0 = move-exception;
        r4 = r0;
        r5 = r3;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        r8 = r3;
        r0 = r3;
        goto L_0x0077;
    L_0x028f:
        r0 = move-exception;
        r4 = r0;
        r5 = r3;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        r0 = r3;
        goto L_0x0077;
    L_0x0298:
        r0 = move-exception;
        r1 = r5;
        r6 = r3;
        r7 = r3;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        goto L_0x0077;
    L_0x02a1:
        r0 = move-exception;
        r6 = r3;
        r7 = r3;
        r12 = r1;
        r1 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r12;
        goto L_0x0077;
    L_0x02ab:
        r0 = move-exception;
        r6 = r3;
        r12 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r12;
        goto L_0x0077;
    L_0x02b4:
        r0 = move-exception;
        r12 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r4;
        r4 = r12;
        goto L_0x0077;
    L_0x02bc:
        r0 = r3;
        r1 = r3;
        r6 = r3;
        r7 = r3;
        goto L_0x0143;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appmarket.a.c.b.a(java.lang.String[], java.lang.String, boolean):com.huawei.appmarket.a.c.c");
    }

    public static C4217c m20483a(String[] strArr, boolean z, boolean z2) {
        return C4216b.m20482a(strArr, z ? "su" : "sh", z2);
    }

    public static boolean m20484a(String str) {
        int waitFor;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(str);
            waitFor = process.waitFor();
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e) {
                    C4241a.m20532b("ShellUtils execChmod proc.destroy()", e.toString());
                }
            }
        } catch (IOException e2) {
            C4241a.m20532b("ShellUtils execChmod IOException ", e2.toString());
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e3) {
                    C4241a.m20532b("ShellUtils execChmod proc.destroy()", e3.toString());
                    waitFor = -1;
                }
            }
            waitFor = -1;
        } catch (InterruptedException e4) {
            C4241a.m20532b("ShellUtils execChmod InterruptedException ", e4.toString());
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e32) {
                    C4241a.m20532b("ShellUtils execChmod proc.destroy()", e32.toString());
                    waitFor = -1;
                }
            }
            waitFor = -1;
        } catch (Throwable th) {
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e5) {
                    C4241a.m20532b("ShellUtils execChmod proc.destroy()", e5.toString());
                }
            }
        }
        return waitFor == 0;
    }
}
