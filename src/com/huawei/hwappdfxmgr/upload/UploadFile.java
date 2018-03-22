package com.huawei.hwappdfxmgr.upload;

import com.huawei.p190v.C2538c;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class UploadFile {
    public static final String BOUNDARY = "---------------------------40612316912668";
    public static final String DEVICE_ID_LABEL = "deviceID";
    public static final String DEVICE_IMSI_LABEL = "imsi";
    public static final String DEVICE_TYPE_LABEL = "deviceType";
    public static final String ENCRTPT_TYPE = "encryptType";
    public static final String ENCRYTKEY = "encryptKey";
    public static final String FILE_NAME = "fileName";
    private static final String LINE_SEPARATOR = "\r\n";
    public static final String LOG_DETAIL_INFO = "logDetailInfo";
    private static final String LOG_TAG = "UploadFile";
    public static final String OS_VERSION_LABEL = "os";
    public static final String REFRESH_LABEL = "refresh";
    public static final String SENSITIVE_CONTAIN = "sensitiveContain";
    public static final String SIGN = "sign";
    public static final String SIZE_LABEL = "size";
    public static final String SYSDATA_LABEL = "sysData";
    public static final String SYS_ID_CHANNEL = "channelId";
    public static final String SYS_VERSION_LABEL = "sysVersion";
    private static final String TWO_HYPHENS = "--";
    public static final String USER_TYPE = "logType";
    public static final String VERSION_LABEL = "version";
    public static final String ZIP_TIME = "zipTime";

    public static <T> int addEndField(T t) {
        try {
            if (t instanceof DataOutputStream) {
                ((DataOutputStream) t).write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            } else if (t instanceof GZIPOutputStream) {
                ((GZIPOutputStream) t).write("-----------------------------40612316912668--\r\n".getBytes("utf-8"));
            }
            return 0;
        } catch (IOException e) {
            return 1010;
        }
    }

    public static int addJsonField(String str, DataOutputStream dataOutputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------40612316912668\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"body\"");
        stringBuilder.append(LINE_SEPARATOR);
        stringBuilder.append("Content-Type: application/json");
        stringBuilder.append(LINE_SEPARATOR);
        stringBuilder.append(LINE_SEPARATOR);
        stringBuilder.append(str);
        stringBuilder.append(LINE_SEPARATOR);
        C2538c.e(LOG_TAG, new Object[]{"the json " + stringBuilder.toString()});
        try {
            dataOutputStream.write(stringBuilder.toString().getBytes("utf-8"));
            return 0;
        } catch (IOException e) {
            return 1010;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int addOctetServiceField(java.io.DataOutputStream r11, java.lang.String r12) {
        /*
        r1 = 1010; // 0x3f2 float:1.415E-42 double:4.99E-321;
        r10 = 1;
        r0 = 0;
        r2 = "UploadFile";
        r3 = new java.lang.Object[r10];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "filePath: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r4 = r4.toString();
        r3[r0] = r4;
        com.huawei.v.c.e(r2, r3);
        r3 = com.huawei.hwappdfxmgr.p056f.C4593d.m21881a(r12);
        if (r3 != 0) goto L_0x0032;
    L_0x0026:
        r1 = "UploadFile";
        r2 = new java.lang.Object[r10];
        r3 = "fis==null";
        r2[r0] = r3;
        com.huawei.v.c.b(r1, r2);
    L_0x0031:
        return r0;
    L_0x0032:
        r2 = r3.available();	 Catch:{ IOException -> 0x004b }
        if (r2 > 0) goto L_0x0057;
    L_0x0038:
        r1 = "UploadFile";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x004b }
        r4 = 0;
        r5 = "fis.available() <= 0";
        r2[r4] = r5;	 Catch:{ IOException -> 0x004b }
        com.huawei.v.c.b(r1, r2);	 Catch:{ IOException -> 0x004b }
        r1 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r1);	 Catch:{ IOException -> 0x004b }
        goto L_0x0031;
    L_0x004b:
        r1 = move-exception;
        r2 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r2);
        r2 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21884a(r1, r2);
        goto L_0x0031;
    L_0x0057:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "-----------------------------40612316912668\r\n";
        r2.append(r4);
        r4 = "Content-Disposition: form-data; name=\"";
        r2.append(r4);
        r4 = "file";
        r2.append(r4);
        r4 = "\"; filename=\"";
        r2.append(r4);
        r4 = "/";
        r4 = r12.contains(r4);
        if (r4 == 0) goto L_0x014f;
    L_0x0078:
        r4 = "/";
        r4 = r12.lastIndexOf(r4);	 Catch:{ Exception -> 0x0149 }
        r4 = r4 + 1;
        r4 = r12.substring(r4);	 Catch:{ Exception -> 0x0149 }
        r5 = "UploadFile";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0149 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0149 }
        r8.<init>();	 Catch:{ Exception -> 0x0149 }
        r9 = "fileName";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0149 }
        r8 = r8.append(r4);	 Catch:{ Exception -> 0x0149 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0149 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0149 }
        com.huawei.v.c.c(r5, r6);	 Catch:{ Exception -> 0x0149 }
        r2.append(r4);	 Catch:{ Exception -> 0x0149 }
    L_0x00a5:
        r4 = "\"";
        r2.append(r4);
        r4 = "\r\n";
        r2.append(r4);
        r4 = "Content-Type: application/octet-stream";
        r2.append(r4);
        r4 = "\r\n";
        r2.append(r4);
        r4 = "\r\n";
        r2.append(r4);
        r4 = "UploadFile";
        r5 = new java.lang.Object[r10];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "sb: ";
        r6 = r6.append(r7);
        r7 = r2.toString();
        r6 = r6.append(r7);
        r6 = r6.toString();
        r5[r0] = r6;
        com.huawei.v.c.e(r4, r5);
        r2 = r2.toString();	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r4 = "utf-8";
        r2 = r2.getBytes(r4);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r11.write(r2);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r2 = r3.available();	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r4 = r3.read(r2);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r5 = -1;
        if (r5 == r4) goto L_0x0136;
    L_0x00fa:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r5 = "utf-8";
        r4.<init>(r2, r5);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r2 = com.huawei.hwcommonmodel.application.BaseApplication.b();	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r2 = com.huawei.p111o.C5704b.m26317a(r2);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r5 = 2;
        r2 = r2.m26329c(r5, r4);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r4 = byteArray2Int(r2);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r5 = "UploadFile";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r8.<init>();	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r9 = "the filesize ";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r8 = r8.append(r4);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        com.huawei.v.c.c(r5, r6);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
        r5 = 4;
        r11.write(r2, r5, r4);	 Catch:{ Exception -> 0x0154, OutOfMemoryError -> 0x01a5 }
    L_0x0136:
        r2 = "\r\n";
        r4 = "utf-8";
        r2 = r2.getBytes(r4);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r11.write(r2);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r1 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r1);
        goto L_0x0031;
    L_0x0149:
        r4 = move-exception;
        r2.append(r12);
        goto L_0x00a5;
    L_0x014f:
        r2.append(r12);
        goto L_0x00a5;
    L_0x0154:
        r2 = move-exception;
        r4 = "UploadFile";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r7.<init>();	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r8 = "the error is ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r2 = r2.getMessage();	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r2 = r7.append(r2);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        r5[r6] = r2;	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ Exception -> 0x0179, OutOfMemoryError -> 0x01a5 }
        goto L_0x0136;
    L_0x0179:
        r0 = move-exception;
        r2 = "UploadFile";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01bb }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01bb }
        r6.<init>();	 Catch:{ all -> 0x01bb }
        r7 = "the error is ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x01bb }
        r0 = r0.getMessage();	 Catch:{ all -> 0x01bb }
        r0 = r6.append(r0);	 Catch:{ all -> 0x01bb }
        r0 = r0.toString();	 Catch:{ all -> 0x01bb }
        r4[r5] = r0;	 Catch:{ all -> 0x01bb }
        com.huawei.v.c.e(r2, r4);	 Catch:{ all -> 0x01bb }
        r0 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r0);
        r0 = r1;
        goto L_0x0031;
    L_0x01a5:
        r0 = move-exception;
        r0 = "UploadFile";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x01bb }
        r4 = 0;
        r5 = "addOctetServiceField OutOfMemoryError";
        r2[r4] = r5;	 Catch:{ all -> 0x01bb }
        com.huawei.v.c.b(r0, r2);	 Catch:{ all -> 0x01bb }
        r0 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r0);
        r0 = r1;
        goto L_0x0031;
    L_0x01bb:
        r0 = move-exception;
        r1 = "UploadFile";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwappdfxmgr.upload.UploadFile.addOctetServiceField(java.io.DataOutputStream, java.lang.String):int");
    }

    public static int byteArray2Int(byte[] bArr) {
        int i = ((((bArr[0] & 255) << 24) + ((bArr[1] & 255) << 16)) + ((bArr[2] & 255) << 8)) + (bArr[3] & 255);
        if (i < 0) {
            return i + 256;
        }
        return i;
    }
}
