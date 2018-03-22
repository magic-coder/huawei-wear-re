package com.huawei.hwid.core.p435d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.internal.http.multipart.FilePart;
import com.android.internal.http.multipart.MultipartEntity;
import com.android.internal.http.multipart.Part;
import com.android.internal.http.multipart.StringPart;
import com.huawei.hwid.core.constants.C5149a.C5148a;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5200d;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5114a;
import com.huawei.hwid.p428c.C5115a;
import com.huawei.hwid.vermanager.C5313c;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FileUtil */
public class C5176g {
    private static FileOutputStream f18644a = null;
    private static FileInputStream f18645b = null;
    private static Properties f18646c = null;

    public static synchronized void m25009a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x005c in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = com.huawei.hwid.core.p435d.C5176g.class;
        monitor-enter(r1);
        if (r4 == 0) goto L_0x0009;
    L_0x0005:
        if (r6 == 0) goto L_0x0009;
    L_0x0007:
        if (r5 != 0) goto L_0x0012;
    L_0x0009:
        r0 = "FileUtil";	 Catch:{ IOException -> 0x0035 }
        r2 = "at least 1 param is null";	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24906b(r0, r2);	 Catch:{ IOException -> 0x0035 }
    L_0x0010:
        monitor-exit(r1);
        return;
    L_0x0012:
        r0 = 0;
        f18644a = r0;	 Catch:{ IOException -> 0x0035 }
        r0 = 0;	 Catch:{ IOException -> 0x0035 }
        f18645b = r0;	 Catch:{ IOException -> 0x0035 }
        r0 = new java.util.Properties;	 Catch:{ IOException -> 0x0035 }
        r0.<init>();	 Catch:{ IOException -> 0x0035 }
        f18646c = r0;	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.C5176g.m25018b(r4, r5, r6);	 Catch:{ Exception -> 0x004b, all -> 0x0079 }
        r0 = f18644a;	 Catch:{ IOException -> 0x0041 }
        if (r0 == 0) goto L_0x002b;	 Catch:{ IOException -> 0x0041 }
    L_0x0026:
        r0 = f18644a;	 Catch:{ IOException -> 0x0041 }
        r0.close();	 Catch:{ IOException -> 0x0041 }
    L_0x002b:
        r0 = f18645b;	 Catch:{ IOException -> 0x0035 }
        if (r0 == 0) goto L_0x0010;	 Catch:{ IOException -> 0x0035 }
    L_0x002f:
        r0 = f18645b;	 Catch:{ IOException -> 0x0035 }
        r0.close();	 Catch:{ IOException -> 0x0035 }
        goto L_0x0010;
    L_0x0035:
        r0 = move-exception;
        r0 = "FileUtil";	 Catch:{ IOException -> 0x0035 }
        r2 = "IOException";	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r2);	 Catch:{ IOException -> 0x0035 }
        goto L_0x0010;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0041:
        r0 = move-exception;
        r0 = "FileUtil";	 Catch:{ IOException -> 0x0035 }
        r2 = "setProperties IOException";	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r2);	 Catch:{ IOException -> 0x0035 }
        goto L_0x002b;
    L_0x004b:
        r0 = move-exception;
        r0 = "FileUtil";	 Catch:{ Exception -> 0x004b, all -> 0x0079 }
        r2 = "IOException";	 Catch:{ Exception -> 0x004b, all -> 0x0079 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r2);	 Catch:{ Exception -> 0x004b, all -> 0x0079 }
        r0 = f18644a;
        if (r0 == 0) goto L_0x005c;
    L_0x0057:
        r0 = f18644a;
        r0.close();
    L_0x005c:
        r0 = f18645b;	 Catch:{ IOException -> 0x0066 }
        if (r0 == 0) goto L_0x0010;	 Catch:{ IOException -> 0x0066 }
    L_0x0060:
        r0 = f18645b;	 Catch:{ IOException -> 0x0066 }
        r0.close();	 Catch:{ IOException -> 0x0066 }
        goto L_0x0010;
    L_0x0066:
        r0 = move-exception;
        r0 = "FileUtil";	 Catch:{ IOException -> 0x0035 }
        r2 = "IOException";	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r2);	 Catch:{ IOException -> 0x0035 }
        goto L_0x0010;	 Catch:{ IOException -> 0x0035 }
    L_0x006f:
        r0 = move-exception;
        r0 = "FileUtil";
        r2 = "setProperties IOException";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r2);
        goto L_0x005c;
    L_0x0079:
        r0 = move-exception;
        r2 = f18644a;	 Catch:{ IOException -> 0x008d }
        if (r2 == 0) goto L_0x0083;	 Catch:{ IOException -> 0x008d }
    L_0x007e:
        r2 = f18644a;	 Catch:{ IOException -> 0x008d }
        r2.close();	 Catch:{ IOException -> 0x008d }
    L_0x0083:
        r2 = f18645b;	 Catch:{ IOException -> 0x0097 }
        if (r2 == 0) goto L_0x008c;	 Catch:{ IOException -> 0x0097 }
    L_0x0087:
        r2 = f18645b;	 Catch:{ IOException -> 0x0097 }
        r2.close();	 Catch:{ IOException -> 0x0097 }
    L_0x008c:
        throw r0;	 Catch:{ IOException -> 0x0035 }
    L_0x008d:
        r2 = move-exception;	 Catch:{ IOException -> 0x0035 }
        r2 = "FileUtil";	 Catch:{ IOException -> 0x0035 }
        r3 = "setProperties IOException";	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r2, r3);	 Catch:{ IOException -> 0x0035 }
        goto L_0x0083;	 Catch:{ IOException -> 0x0035 }
    L_0x0097:
        r2 = move-exception;	 Catch:{ IOException -> 0x0035 }
        r2 = "FileUtil";	 Catch:{ IOException -> 0x0035 }
        r3 = "IOException";	 Catch:{ IOException -> 0x0035 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r2, r3);	 Catch:{ IOException -> 0x0035 }
        goto L_0x008c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.core.d.g.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static synchronized void m25011a(android.content.Context r6, java.lang.String[] r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x008c in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = com.huawei.hwid.core.p435d.C5176g.class;
        monitor-enter(r2);
        r0 = 0;
        f18644a = r0;	 Catch:{ IOException -> 0x0027 }
        r0 = 0;	 Catch:{ IOException -> 0x0027 }
        f18645b = r0;	 Catch:{ IOException -> 0x0027 }
        r0 = new java.util.Properties;	 Catch:{ IOException -> 0x0027 }
        r0.<init>();	 Catch:{ IOException -> 0x0027 }
        f18646c = r0;	 Catch:{ IOException -> 0x0027 }
        com.huawei.hwid.core.p435d.C5176g.m25019b(r6, r7);	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r0 = f18644a;	 Catch:{ IOException -> 0x0027 }
        if (r0 == 0) goto L_0x001c;	 Catch:{ IOException -> 0x0027 }
    L_0x0017:
        r0 = f18644a;	 Catch:{ IOException -> 0x0027 }
        r0.close();	 Catch:{ IOException -> 0x0027 }
    L_0x001c:
        r0 = f18645b;	 Catch:{ IOException -> 0x0048 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ IOException -> 0x0048 }
    L_0x0020:
        r0 = f18645b;	 Catch:{ IOException -> 0x0048 }
        r0.close();	 Catch:{ IOException -> 0x0048 }
    L_0x0025:
        monitor-exit(r2);
        return;
    L_0x0027:
        r0 = move-exception;
        r1 = "FileUtil";	 Catch:{ IOException -> 0x0027 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0027 }
        r3.<init>();	 Catch:{ IOException -> 0x0027 }
        r4 = "removeProperties IOException:";	 Catch:{ IOException -> 0x0027 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0027 }
        r4 = r0.getMessage();	 Catch:{ IOException -> 0x0027 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0027 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0027 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r1, r3, r0);	 Catch:{ IOException -> 0x0027 }
        goto L_0x001c;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0048:
        r0 = move-exception;
        r1 = "FileUtil";	 Catch:{ IOException -> 0x0027 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0027 }
        r3.<init>();	 Catch:{ IOException -> 0x0027 }
        r4 = "IOException / ";	 Catch:{ IOException -> 0x0027 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0027 }
        r4 = r0.getMessage();	 Catch:{ IOException -> 0x0027 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0027 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0027 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r1, r3, r0);	 Catch:{ IOException -> 0x0027 }
        goto L_0x0025;
    L_0x0066:
        r0 = move-exception;
        r1 = "FileUtil";	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r3.<init>();	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r4 = "Exception / ";	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r1, r0);	 Catch:{ Exception -> 0x0066, all -> 0x00d3 }
        r0 = f18644a;
        if (r0 == 0) goto L_0x008c;
    L_0x0087:
        r0 = f18644a;
        r0.close();
    L_0x008c:
        r0 = f18645b;	 Catch:{ IOException -> 0x0096 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ IOException -> 0x0096 }
    L_0x0090:
        r0 = f18645b;	 Catch:{ IOException -> 0x0096 }
        r0.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x0025;
    L_0x0096:
        r0 = move-exception;
        r1 = "FileUtil";	 Catch:{ IOException -> 0x0027 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0027 }
        r3.<init>();	 Catch:{ IOException -> 0x0027 }
        r4 = "IOException / ";	 Catch:{ IOException -> 0x0027 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0027 }
        r4 = r0.getMessage();	 Catch:{ IOException -> 0x0027 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0027 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0027 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r1, r3, r0);	 Catch:{ IOException -> 0x0027 }
        goto L_0x0025;	 Catch:{ IOException -> 0x0027 }
    L_0x00b5:
        r0 = move-exception;
        r1 = "FileUtil";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "removeProperties IOException:";
        r3 = r3.append(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r1, r3, r0);
        goto L_0x008c;
    L_0x00d3:
        r0 = move-exception;
        r1 = f18644a;	 Catch:{ IOException -> 0x00e7 }
        if (r1 == 0) goto L_0x00dd;	 Catch:{ IOException -> 0x00e7 }
    L_0x00d8:
        r1 = f18644a;	 Catch:{ IOException -> 0x00e7 }
        r1.close();	 Catch:{ IOException -> 0x00e7 }
    L_0x00dd:
        r1 = f18645b;	 Catch:{ IOException -> 0x0105 }
        if (r1 == 0) goto L_0x00e6;	 Catch:{ IOException -> 0x0105 }
    L_0x00e1:
        r1 = f18645b;	 Catch:{ IOException -> 0x0105 }
        r1.close();	 Catch:{ IOException -> 0x0105 }
    L_0x00e6:
        throw r0;	 Catch:{ IOException -> 0x0027 }
    L_0x00e7:
        r1 = move-exception;	 Catch:{ IOException -> 0x0027 }
        r3 = "FileUtil";	 Catch:{ IOException -> 0x0027 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0027 }
        r4.<init>();	 Catch:{ IOException -> 0x0027 }
        r5 = "removeProperties IOException:";	 Catch:{ IOException -> 0x0027 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0027 }
        r5 = r1.getMessage();	 Catch:{ IOException -> 0x0027 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0027 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0027 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r3, r4, r1);	 Catch:{ IOException -> 0x0027 }
        goto L_0x00dd;	 Catch:{ IOException -> 0x0027 }
    L_0x0105:
        r1 = move-exception;	 Catch:{ IOException -> 0x0027 }
        r3 = "FileUtil";	 Catch:{ IOException -> 0x0027 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0027 }
        r4.<init>();	 Catch:{ IOException -> 0x0027 }
        r5 = "IOException / ";	 Catch:{ IOException -> 0x0027 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0027 }
        r5 = r1.getMessage();	 Catch:{ IOException -> 0x0027 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0027 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0027 }
        com.huawei.hwid.core.p435d.p437b.C5165e.m24911d(r3, r4, r1);	 Catch:{ IOException -> 0x0027 }
        goto L_0x00e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.core.d.g.a(android.content.Context, java.lang.String[]):void");
    }

    public static boolean m25014a(File file) {
        C5165e.m24906b("FileUtil", "deleteFile : file.getName=" + file.getName());
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    C5176g.m25014a(a);
                }
            }
        }
        return file.delete();
    }

    public static boolean m25013a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return C5176g.m25014a(new File(context.getFilesDir(), str));
    }

    public static boolean m25015a(String str, String str2, byte[] bArr) {
        Throwable e;
        Throwable e2;
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str + str2));
                try {
                    fileOutputStream2.write(bArr);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable e3) {
                            C5165e.m24911d("FileUtil", "IOException / " + e3.getMessage(), e3);
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e2 = e4;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C5165e.m24911d("FileUtil", "writeAgreement FileNotFoundException:" + e2.getMessage(), e2);
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e22) {
                            C5165e.m24911d("FileUtil", "IOException / " + e22.getMessage(), e22);
                            return false;
                        }
                    } catch (Throwable th) {
                        e3 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e222) {
                                C5165e.m24911d("FileUtil", "IOException / " + e222.getMessage(), e222);
                            }
                        }
                        throw e3;
                    }
                } catch (IOException e5) {
                    e222 = e5;
                    fileOutputStream = fileOutputStream2;
                    C5165e.m24911d("FileUtil", "writeAgreement IOException:" + e222.getMessage(), e222);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e2222) {
                        C5165e.m24911d("FileUtil", "IOException / " + e2222.getMessage(), e2222);
                        return false;
                    }
                } catch (Exception e6) {
                    e3 = e6;
                    fileOutputStream = fileOutputStream2;
                    C5165e.m24911d("FileUtil", "Exception / " + e3.getMessage(), e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e32) {
                            C5165e.m24911d("FileUtil", "IOException / " + e32.getMessage(), e32);
                        }
                    }
                    return true;
                } catch (Throwable th2) {
                    e32 = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e32;
                }
                return true;
            } else if (fileOutputStream == null) {
                return false;
            } else {
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Throwable e22222) {
                    C5165e.m24911d("FileUtil", "IOException / " + e22222.getMessage(), e22222);
                    return false;
                }
            }
        } catch (FileNotFoundException e7) {
            e22222 = e7;
            C5165e.m24911d("FileUtil", "writeAgreement FileNotFoundException:" + e22222.getMessage(), e22222);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (IOException e8) {
            e22222 = e8;
            C5165e.m24911d("FileUtil", "writeAgreement IOException:" + e22222.getMessage(), e22222);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Exception e9) {
            e32 = e9;
            C5165e.m24911d("FileUtil", "Exception / " + e32.getMessage(), e32);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return true;
        }
    }

    public static synchronized String m25017b(Context context, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        String str2;
        InputStream inputStream;
        Object obj;
        FileOutputStream fileOutputStream3 = null;
        synchronized (C5176g.class) {
            try {
                Properties properties = new Properties();
                if (new File(context.getFilesDir().getPath() + "/" + "settings.properties").exists()) {
                    fileOutputStream = fileOutputStream3;
                } else {
                    fileOutputStream = context.openFileOutput("settings.properties", 0);
                }
                try {
                    InputStream openFileInput = context.openFileInput("settings.properties");
                    if (openFileInput != null) {
                        try {
                            properties.load(openFileInput);
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            fileInputStream = openFileInput;
                            fileOutputStream3 = fileOutputStream2;
                            try {
                                C5165e.m24911d("FileUtil", "Can not find the file settings.properties", e);
                                if (fileOutputStream3 != null) {
                                    try {
                                        fileOutputStream3.close();
                                    } catch (Throwable e3) {
                                        C5165e.m24911d("FileUtil", "IOException / " + e3.getMessage(), e3);
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e32) {
                                        C5165e.m24911d("FileUtil", "IOException / " + e32.getMessage(), e32);
                                    }
                                }
                                str2 = "";
                                return str2;
                            } catch (Throwable th) {
                                e32 = th;
                                if (fileOutputStream3 != null) {
                                    try {
                                        fileOutputStream3.close();
                                    } catch (Throwable e4) {
                                        C5165e.m24911d("FileUtil", "IOException / " + e4.getMessage(), e4);
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e42) {
                                        C5165e.m24911d("FileUtil", "IOException / " + e42.getMessage(), e42);
                                    }
                                }
                                throw e32;
                            }
                        } catch (Throwable th2) {
                            e32 = th2;
                            fileOutputStream2 = fileOutputStream;
                            inputStream = openFileInput;
                            fileOutputStream3 = fileOutputStream2;
                            if (fileOutputStream3 != null) {
                                fileOutputStream3.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e32;
                        }
                    }
                    C5165e.m24906b("FileUtil", "inStream is null");
                    str2 = properties.getProperty(str);
                    if (TextUtils.isEmpty(str2)) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                C5165e.m24911d("FileUtil", "IOException / " + e5.getMessage(), e5);
                            }
                        }
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (Throwable e422) {
                                C5165e.m24911d("FileUtil", "IOException / " + e422.getMessage(), e422);
                            }
                        }
                    } else {
                        for (Object equals : C5148a.m24833a()) {
                            if (str.equals(equals)) {
                                str2 = C5201e.m25308c(context, str2);
                                break;
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e52) {
                                C5165e.m24911d("FileUtil", "IOException / " + e52.getMessage(), e52);
                            }
                        }
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (Throwable e4222) {
                                C5165e.m24911d("FileUtil", "IOException / " + e4222.getMessage(), e4222);
                            }
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e32 = e6;
                    fileOutputStream2 = fileOutputStream;
                    obj = fileOutputStream3;
                    fileOutputStream3 = fileOutputStream2;
                    C5165e.m24911d("FileUtil", "Can not find the file settings.properties", e32);
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    str2 = "";
                    return str2;
                } catch (Throwable th3) {
                    e32 = th3;
                    fileOutputStream2 = fileOutputStream;
                    obj = fileOutputStream3;
                    fileOutputStream3 = fileOutputStream2;
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e32;
                }
            } catch (FileNotFoundException e7) {
                e32 = e7;
                obj = fileOutputStream3;
                C5165e.m24911d("FileUtil", "Can not find the file settings.properties", e32);
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                str2 = "";
                return str2;
            } catch (Throwable th4) {
                e32 = th4;
                fileInputStream = fileOutputStream3;
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e32;
            }
        }
        return str2;
    }

    private static void m25018b(Context context, String str, String str2) throws Exception {
        int i = 0;
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.getPath() != null) {
            if (new File(filesDir.getPath() + "/" + "settings.properties").exists()) {
                f18645b = context.openFileInput("settings.properties");
                if (f18645b != null) {
                    f18646c.load(f18645b);
                } else {
                    C5165e.m24906b("FileUtil", "inStream is null");
                }
            }
            f18644a = context.openFileOutput("settings.properties", 0);
            String[] a = C5148a.m24833a();
            int length = a.length;
            while (i < length) {
                if (str.equals(a[i])) {
                    str2 = C5201e.m25307b(context, str2);
                    break;
                }
                i++;
            }
            f18646c.setProperty(str, str2);
            if (f18644a != null) {
                f18646c.store(f18644a, "accountagent");
            } else {
                C5165e.m24906b("FileUtil", "outStream is null");
            }
        }
    }

    private static void m25019b(Context context, String[] strArr) throws Exception {
        int i = 0;
        if (new File(context.getFilesDir().getPath() + "/" + "settings.properties").exists()) {
            f18645b = context.openFileInput("settings.properties");
            if (f18645b != null) {
                f18646c.load(f18645b);
            } else {
                C5165e.m24906b("FileUtil", "inStream is null");
            }
        }
        f18644a = context.openFileOutput("settings.properties", 0);
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            while (i < length) {
                Object obj = strArr[i];
                if (obj != null) {
                    f18646c.remove(obj);
                }
                i++;
            }
        }
        if (f18644a != null) {
            f18646c.store(f18644a, "accountagent");
        } else {
            C5165e.m24906b("FileUtil", "outStream is null");
        }
    }

    public static void m25012a(XmlSerializer xmlSerializer, String str, String str2) {
        try {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        } catch (Throwable e) {
            C5165e.m24911d("FileUtil", "IllegalArgumentException / " + e.getMessage(), e);
        } catch (Throwable e2) {
            C5165e.m24911d("FileUtil", "IllegalStateException / " + e2.getMessage(), e2);
        } catch (Throwable e22) {
            C5165e.m24911d("FileUtil", "IOException / " + e22.getMessage(), e22);
        } catch (Throwable e222) {
            C5165e.m24911d("FileUtil", "Exception / " + e222.getMessage(), e222);
        }
    }

    @SuppressLint({"TrulyRandom"})
    public static void m25010a(Context context, String str, HttpPost httpPost) {
        HwAccount b = C5114a.m24640a(context).mo4623b(context, str, null);
        if (b != null) {
            Object g = b.m25130g();
            String d = b.m25124d();
            Object a = C5115a.m24641a(context).m24642a(d);
            if (TextUtils.isEmpty(d) || TextUtils.isEmpty(g)) {
                C5165e.m24906b("FileUtil", "token or userId is null");
                return;
            }
            String str2 = System.currentTimeMillis() + ":" + new SecureRandom().nextInt(1000);
            String str3 = "";
            if (!TextUtils.isEmpty(C5125a.m24676c())) {
                str3 = C5125a.m24676c().substring(C5125a.m24676c().lastIndexOf("/") + 1).replace("?Version=12000", "");
            }
            httpPost.addHeader(AUTH.WWW_AUTH_RESP, "Digest user=" + d + "," + "nonce" + "=" + str2 + "," + "response" + "=" + C5200d.m25303a(str2 + ":" + str3, g));
            if (!TextUtils.isEmpty(a)) {
                httpPost.addHeader("Cookie", a);
                return;
            }
            return;
        }
        C5165e.m24906b("FileUtil", "account is null");
    }

    public static String m25008a(Context context, File file, String str, HashMap<String, String> hashMap, String str2) {
        C5165e.m24906b("FileUtil", "begin to upLoad photo");
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Part[] a = C5176g.m25016a(file, (HashMap) hashMap);
            if (a.length < 5) {
                C5165e.m24908c("FileUtil", "param is null or not enough");
                return stringBuffer.toString();
            }
            HttpClient a2 = C5313c.m25694a().mo4682a(context, 18080, 18443);
            HttpPost httpPost = new HttpPost(str);
            C5176g.m25010a(context, str2, httpPost);
            a2.getParams().setParameter("http.protocol.content-charset", GameManager.DEFAULT_CHARSET);
            httpPost.getParams().setIntParameter("http.socket.timeout", 20000);
            httpPost.getParams().setIntParameter("http.connection.timeout", 20000);
            httpPost.setEntity(new MultipartEntity(a, httpPost.getParams()));
            HttpResponse execute = a2.execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (200 == statusCode) {
                C5165e.m24904a("FileUtil", "resultCode is ok");
                String entityUtils = EntityUtils.toString(execute.getEntity(), GameManager.DEFAULT_CHARSET);
                C5165e.m24906b("FileUtil", "response responseXMLContent = ");
                stringBuffer.append(entityUtils);
            } else {
                C5165e.m24908c("FileUtil", "resultCode is " + statusCode);
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            C5165e.m24911d("FileUtil", "upload photo failed, IOException : " + e.getMessage(), e);
        } catch (Throwable e2) {
            C5165e.m24911d("FileUtil", "upload photo failed Exception : " + e2.getMessage(), e2);
        }
    }

    public static Intent m25007a(String str, Intent intent) {
        C5165e.m24904a("FileUtil", "begin to put  result string To intent");
        try {
            if (TextUtils.isEmpty(str)) {
                C5165e.m24908c("FileUtil", "string is empty");
                return null;
            }
            for (String split : str.split(SNBConstant.FILTER)) {
                String[] split2 = split.split("=");
                if (split2.length > 1) {
                    intent.putExtra(split2[0], split2[1]);
                }
            }
            return intent;
        } catch (Throwable e) {
            C5165e.m24911d("FileUtil", "put  result string To intent occur : " + e.getMessage(), e);
            return intent;
        }
    }

    public static Part[] m25016a(File file, HashMap<String, String> hashMap) throws FileNotFoundException {
        if (file == null || !file.isFile() || hashMap == null || hashMap.isEmpty()) {
            C5165e.m24908c("FileUtil", "init body failed");
            return new Part[0];
        }
        Set<Entry> entrySet = hashMap.entrySet();
        int size = entrySet.size();
        Part[] partArr = new Part[(size + 1)];
        C5165e.m24904a("FileUtil", "begin to init body");
        int i = 0;
        for (Entry entry : entrySet) {
            partArr[i] = new StringPart((String) entry.getKey(), (String) entry.getValue());
            i++;
        }
        partArr[size] = new FilePart("BigImage", file);
        return partArr;
    }
}
