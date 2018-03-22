package com.huawei.uploadlog;

import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.uploadlog.p188c.C2511g;
import java.io.DataOutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: UploadFile */
public class C2527j {
    public static int m12601a(java.io.DataOutputStream r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:31:? in {16, 23, 25, 26, 27, 28, 29, 30, 32, 33} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = "BETACLUB_SDK";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "[UploadFile.addLogServiceField] filePath: ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r1, r2);
        r2 = com.huawei.uploadlog.p188c.C2517m.m12563a(r7);
        if (r2 != 0) goto L_0x0027;
    L_0x001f:
        r1 = "BETACLUB_SDK";
        r2 = "[UploadFile.addLogServiceField] fis==null";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r1, r2);
    L_0x0026:
        return r0;
    L_0x0027:
        r1 = r2.available();	 Catch:{ IOException -> 0x003a }
        if (r1 > 0) goto L_0x004d;	 Catch:{ IOException -> 0x003a }
    L_0x002d:
        r1 = "BETACLUB_SDK";	 Catch:{ IOException -> 0x003a }
        r3 = "[UploadFile.addLogServiceField] fis.available() <= 0";	 Catch:{ IOException -> 0x003a }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r1, r3);	 Catch:{ IOException -> 0x003a }
        r1 = "BETACLUB_SDK";	 Catch:{ IOException -> 0x003a }
        com.huawei.uploadlog.p188c.C2517m.m12571a(r2, r1);	 Catch:{ IOException -> 0x003a }
        goto L_0x0026;
    L_0x003a:
        r1 = move-exception;
        r3 = "BetaClub Upload";
        r4 = "addLogServiceField error:";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r3, r4, r1);
        r3 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r2, r3);
        r2 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12572a(r1, r2);
        goto L_0x0026;
    L_0x004d:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "-----------------------------40612316912668\r\n";
        r1.append(r3);
        r3 = "Content-Disposition: form-data; name=\"";
        r1.append(r3);
        r3 = "sysData";
        r1.append(r3);
        r3 = "\"; filename=\"";
        r1.append(r3);
        r1.append(r7);
        r3 = "\"";
        r1.append(r3);
        r3 = "\r\n";
        r1.append(r3);
        r3 = "Content-Type: application/zip";
        r1.append(r3);
        r3 = "\r\n";
        r1.append(r3);
        r3 = "\r\n";
        r1.append(r3);
        r3 = "BETACLUB_SDK";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "[UploadFile.addLogServiceField] sb: ";
        r4 = r4.append(r5);
        r5 = r1.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r3, r4);
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r3];
        r1 = r1.toString();	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r4 = "utf-8";	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r1 = r1.getBytes(r4);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r6.write(r1);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
    L_0x00b0:
        r1 = r2.read(r3);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r4 = -1;	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        if (r1 == r4) goto L_0x00cd;	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
    L_0x00b7:
        r4 = 0;	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r6.write(r3, r4, r1);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        goto L_0x00b0;
    L_0x00bc:
        r0 = move-exception;
        r1 = "BetaClub Upload";	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r3 = "addLogServiceField error:";	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        com.huawei.uploadlog.p188c.C2511g.m12482b(r1, r3, r0);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r0 = 1010; // 0x3f2 float:1.415E-42 double:4.99E-321;
        r1 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r2, r1);
        goto L_0x0026;
    L_0x00cd:
        r1 = "\r\n";	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r3 = "utf-8";	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r1 = r1.getBytes(r3);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r6.write(r1);	 Catch:{ IOException -> 0x00bc, all -> 0x00e0 }
        r1 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r2, r1);
        goto L_0x0026;
    L_0x00e0:
        r0 = move-exception;
        r1 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r2, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.j.a(java.io.DataOutputStream, java.lang.String):int");
    }

    public static int m12603a(String str, String str2, GZIPOutputStream gZIPOutputStream) {
        if (StringUtils.isNullOrEmpty(str2) || StringUtils.isNullOrEmpty(str)) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------40612316912668\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        stringBuilder.append("\r\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(str2);
        stringBuilder.append("\r\n");
        try {
            gZIPOutputStream.write(stringBuilder.toString().getBytes("utf-8"));
            return 0;
        } catch (Throwable e) {
            C2511g.m12482b("BetaClub Upload", "addFormField error:", e);
            return 1010;
        }
    }

    public static <T> int m12602a(T t) {
        try {
            if (t instanceof DataOutputStream) {
                ((DataOutputStream) t).write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            } else if (t instanceof GZIPOutputStream) {
                ((GZIPOutputStream) t).write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            }
            return 0;
        } catch (Throwable e) {
            C2511g.m12482b("BetaClub Upload", "addEndField error:", e);
            return 1010;
        }
    }
}
