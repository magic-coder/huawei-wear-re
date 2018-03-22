package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.de.C3313b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LogUpDateProcessor */
abstract class cj {
    private de f11585a;

    protected abstract String mo4020a();

    protected abstract boolean mo4021a(Context context);

    protected abstract int mo4022b();

    public static cj m15838a(Context context, int i) {
        switch (i) {
            case 0:
                return new ce(context);
            case 1:
                return new cg(context);
            case 2:
                return new cb(context);
            default:
                return null;
        }
    }

    protected cj(Context context) {
        try {
            this.f11585a = m15839a(context, mo4020a());
        } catch (Throwable th) {
            ca.m15831a(th, "LogProcessor", "LogUpDateProcessor");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m15850b(android.content.Context r6) {
        /*
        r5 = this;
        r0 = r5.mo4021a(r6);	 Catch:{ Throwable -> 0x002e }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x002e }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x002e }
        r0 = new com.amap.api.mapcore.util.cv;	 Catch:{ all -> 0x002b }
        r0.<init>(r6);	 Catch:{ all -> 0x002b }
        r2 = r5.mo4022b();	 Catch:{ all -> 0x002b }
        r5.m15841a(r0, r2);	 Catch:{ all -> 0x002b }
        r2 = 0;
        r3 = r5.mo4022b();	 Catch:{ all -> 0x002b }
        r2 = r0.m15951a(r2, r3);	 Catch:{ all -> 0x002b }
        if (r2 == 0) goto L_0x0029;
    L_0x0023:
        r3 = r2.size();	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x003a;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r0;	 Catch:{ Throwable -> 0x002e }
    L_0x002e:
        r0 = move-exception;
        r1 = "LogProcessor";
        r2 = "processUpdateLog";
        com.amap.api.mapcore.util.ca.m15831a(r0, r1, r2);
        r0.printStackTrace();
        goto L_0x0006;
    L_0x003a:
        r3 = r5.m15840a(r2, r6);	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x0042;
    L_0x0040:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x0042:
        r3 = r5.m15844b(r3);	 Catch:{ all -> 0x002b }
        r4 = 1;
        if (r3 != r4) goto L_0x0050;
    L_0x0049:
        r3 = r5.mo4022b();	 Catch:{ all -> 0x002b }
        r5.m15842a(r2, r0, r3);	 Catch:{ all -> 0x002b }
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.cj.b(android.content.Context):void");
    }

    private boolean m15843a(String str) {
        boolean z = false;
        if (this.f11585a != null) {
            try {
                z = this.f11585a.m16052c(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    private void m15841a(cv cvVar, int i) {
        try {
            m15842a(cvVar.m15951a(2, i), cvVar, i);
        } catch (Throwable th) {
            ca.m15831a(th, "LogProcessor", "processDeleteFail");
            th.printStackTrace();
        }
    }

    private int m15844b(String str) {
        byte[] b;
        try {
            b = bw.m15806b(str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            b = bw.m15806b(str.getBytes());
        }
        try {
            byte[] b2 = C3318do.m16080a(false).mo4043b(new ck(b));
            if (b2 == null) {
                return 0;
            }
            String str2;
            int i;
            try {
                str2 = new String(b2, GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e2) {
                str2 = new String(b2);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                str2 = "code";
                if (jSONObject.has(str2)) {
                    i = jSONObject.getInt(str2);
                    return i;
                }
            } catch (Throwable e3) {
                ca.m15831a(e3, "LogProcessor", "processUpdate");
                e3.printStackTrace();
            }
            i = 0;
            return i;
        } catch (Throwable e32) {
            ca.m15831a(e32, "LogProcessor", "processUpdate");
            e32.printStackTrace();
        }
    }

    private void m15842a(List<cx> list, cv cvVar, int i) {
        if (list != null && list.size() > 0) {
            for (cx cxVar : list) {
                if (m15843a(cxVar.m15959b())) {
                    cvVar.m15953a(cxVar.m15959b(), i);
                } else {
                    cxVar.m15957a(2);
                    cvVar.m15952a(cxVar, cxVar.m15956a());
                }
            }
        }
    }

    private String m15845c(Context context) {
        String str = null;
        try {
            String a = by.m15817a(context);
            if (!"".equals(a)) {
                str = bo.m15706b(context, a.getBytes(GameManager.DEFAULT_CHARSET));
            }
        } catch (Throwable e) {
            ca.m15831a(e, "LogProcessor", "getPublicInfo");
            e.printStackTrace();
        } catch (Throwable e2) {
            ca.m15831a(e2, "LogProcessor", "getPublicInfo");
            e2.printStackTrace();
        }
        return str;
    }

    private String m15840a(List<cx> list, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"pinfo\":\"").append(m15845c(context)).append("\",\"els\":[");
        Object obj = 1;
        for (cx cxVar : list) {
            Object obj2;
            String c = m15846c(cxVar.m15959b());
            if (c != null) {
                if ("".equals(c)) {
                    obj2 = obj;
                    obj = obj2;
                } else {
                    String str = c + "||" + cxVar.m15963d();
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("{\"log\":\"").append(str).append("\"}");
                }
            }
            obj2 = obj;
            obj = obj2;
        }
        if (obj != null) {
            return null;
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    private String m15846c(String str) {
        Throwable e;
        InputStream a;
        Object obj;
        Throwable th;
        String str2 = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            if (this.f11585a == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        ca.m15831a(e2, "LogProcessor", "readLog1");
                        e2.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        ca.m15831a(e3, "LogProcessor", "readLog2");
                        e3.printStackTrace();
                    }
                }
            } else {
                C3313b a2 = this.f11585a.m16046a(str);
                if (a2 == null) {
                    if (str2 != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e22) {
                            ca.m15831a(e22, "LogProcessor", "readLog1");
                            e22.printStackTrace();
                        }
                    }
                    if (str2 != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32) {
                            ca.m15831a(e32, "LogProcessor", "readLog2");
                            e32.printStackTrace();
                        }
                    }
                } else {
                    a = a2.m16009a(0);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException e4) {
                        e32 = e4;
                        obj = str2;
                        try {
                            ca.m15831a(e32, "LogProcessor", "readLog");
                            e32.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e322) {
                                    ca.m15831a(e322, "LogProcessor", "readLog1");
                                    e322.printStackTrace();
                                }
                            }
                            if (a != null) {
                                try {
                                    a.close();
                                } catch (Throwable e3222) {
                                    ca.m15831a(e3222, "LogProcessor", "readLog2");
                                    e3222.printStackTrace();
                                }
                            }
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e32222) {
                                    ca.m15831a(e32222, "LogProcessor", "readLog1");
                                    e32222.printStackTrace();
                                }
                            }
                            if (a != null) {
                                try {
                                    a.close();
                                } catch (Throwable e322222) {
                                    ca.m15831a(e322222, "LogProcessor", "readLog2");
                                    e322222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable e3222222) {
                        obj = str2;
                        th = e3222222;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = a.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        str2 = byteArrayOutputStream.toString("utf-8");
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e32222222) {
                                ca.m15831a(e32222222, "LogProcessor", "readLog1");
                                e32222222.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable e322222222) {
                                ca.m15831a(e322222222, "LogProcessor", "readLog2");
                                e322222222.printStackTrace();
                            }
                        }
                    } catch (IOException e5) {
                        e322222222 = e5;
                        ca.m15831a(e322222222, "LogProcessor", "readLog");
                        e322222222.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (a != null) {
                            a.close();
                        }
                        return str2;
                    } catch (Throwable th3) {
                        e322222222 = th3;
                        ca.m15831a(e322222222, "LogProcessor", "readLog");
                        e322222222.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (a != null) {
                            a.close();
                        }
                        return str2;
                    }
                }
            }
        } catch (IOException e6) {
            e322222222 = e6;
            obj = str2;
            Object obj2 = str2;
            ca.m15831a(e322222222, "LogProcessor", "readLog");
            e322222222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            return str2;
        } catch (Throwable e3222222222) {
            byteArrayOutputStream = str2;
            a = str2;
            th = e3222222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return str2;
    }

    void m15851c() {
        if (this.f11585a != null && !this.f11585a.m16048a()) {
            try {
                this.f11585a.close();
            } catch (Throwable e) {
                ca.m15831a(e, "LogProcessor", "closeDiskLru");
                e.printStackTrace();
            } catch (Throwable e2) {
                ca.m15831a(e2, "LogProcessor", "closeDiskLru");
                e2.printStackTrace();
            }
        }
    }

    private de m15839a(Context context, String str) {
        de deVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(ci.f11609a);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                deVar = de.m16026a(file, 1, 1, 20480);
            }
        } catch (Throwable e) {
            ca.m15831a(e, "LogProcessor", "initDiskLru");
            e.printStackTrace();
        } catch (Throwable e2) {
            ca.m15831a(e2, "LogProcessor", "initDiskLru");
            e2.printStackTrace();
        }
        return deVar;
    }
}
