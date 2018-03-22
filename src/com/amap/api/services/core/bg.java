package com.amap.api.services.core;

import android.content.Context;
import android.util.Log;
import com.amap.api.services.core.bk.C3403b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LogUpDateProcessor */
abstract class bg {
    private bk f12388a;

    protected abstract String mo4111a();

    protected abstract boolean mo4112a(Context context);

    protected abstract int mo4113b();

    public static bg m16713a(Context context, int i) {
        switch (i) {
            case 0:
                return new bb(context);
            case 1:
                return new bd(context);
            case 2:
                return new az(context);
            default:
                return null;
        }
    }

    protected bg(Context context) {
        try {
            this.f12388a = m16714a(context, mo4111a());
        } catch (Throwable th) {
            ay.m16709a(th, "LogProcessor", "LogUpDateProcessor");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m16725b(android.content.Context r6) {
        /*
        r5 = this;
        r0 = r5.mo4112a(r6);	 Catch:{ Throwable -> 0x002e }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x002e }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x002e }
        r0 = new com.amap.api.services.core.ak;	 Catch:{ all -> 0x002b }
        r0.<init>(r6);	 Catch:{ all -> 0x002b }
        r2 = r5.mo4113b();	 Catch:{ all -> 0x002b }
        r5.m16716a(r0, r2);	 Catch:{ all -> 0x002b }
        r2 = 0;
        r3 = r5.mo4113b();	 Catch:{ all -> 0x002b }
        r2 = r0.m16651a(r2, r3);	 Catch:{ all -> 0x002b }
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
        com.amap.api.services.core.ay.m16709a(r0, r1, r2);
        r0.printStackTrace();
        goto L_0x0006;
    L_0x003a:
        r3 = r5.m16715a(r2, r6);	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x0042;
    L_0x0040:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x0042:
        r3 = r5.m16719b(r3);	 Catch:{ all -> 0x002b }
        r4 = 1;
        if (r3 != r4) goto L_0x0050;
    L_0x0049:
        r3 = r5.mo4113b();	 Catch:{ all -> 0x002b }
        r5.m16717a(r2, r0, r3);	 Catch:{ all -> 0x002b }
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.bg.b(android.content.Context):void");
    }

    private boolean m16718a(String str) {
        boolean z = false;
        if (this.f12388a != null) {
            try {
                z = this.f12388a.m16840c(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    private void m16716a(ak akVar, int i) {
        try {
            m16717a(akVar.m16651a(2, i), akVar, i);
        } catch (Throwable th) {
            ay.m16709a(th, "LogProcessor", "processDeleteFail");
            th.printStackTrace();
        }
    }

    private int m16719b(String str) {
        int i = 0;
        Log.i("yiyi.qi", str);
        try {
            byte[] a = bs.m16858a(false).m16868a(new bh(ae.m16622b(str.getBytes())));
            if (a != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(a));
                    String str2 = "code";
                    if (jSONObject.has(str2)) {
                        i = jSONObject.getInt(str2);
                    }
                } catch (Throwable e) {
                    ay.m16709a(e, "LogProcessor", "processUpdate");
                    e.printStackTrace();
                }
            }
        } catch (Throwable e2) {
            ay.m16709a(e2, "LogProcessor", "processUpdate");
            e2.printStackTrace();
        }
        return i;
    }

    private void m16717a(List<am> list, ak akVar, int i) {
        if (list != null && list.size() > 0) {
            for (am amVar : list) {
                if (m16718a(amVar.m16659b())) {
                    akVar.m16653a(amVar.m16659b(), i);
                } else {
                    amVar.m16657a(2);
                    akVar.m16652a(amVar, amVar.m16656a());
                }
            }
        }
    }

    private String m16720c(Context context) {
        String str = null;
        try {
            String a = C3436y.m16997a(context);
            if (!"".equals(a)) {
                str = C3436y.m17003b(context, a.getBytes(GameManager.DEFAULT_CHARSET));
            }
        } catch (Throwable e) {
            ay.m16709a(e, "LogProcessor", "getPublicInfo");
            e.printStackTrace();
        } catch (Throwable e2) {
            ay.m16709a(e2, "LogProcessor", "getPublicInfo");
            e2.printStackTrace();
        }
        return str;
    }

    private String m16715a(List<am> list, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"pinfo\":\"").append(m16720c(context)).append("\",\"els\":[");
        Object obj = 1;
        for (am amVar : list) {
            Object obj2;
            String c = m16721c(amVar.m16659b());
            if (c != null) {
                if ("".equals(c)) {
                    obj2 = obj;
                    obj = obj2;
                } else {
                    String str = c + "||" + amVar.m16663d();
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

    private String m16721c(String str) {
        Throwable e;
        IOException iOException;
        Throwable th;
        Object obj;
        String str2 = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream a;
        try {
            if (this.f12388a == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        ay.m16709a(e2, "LogProcessor", "readLog1");
                        e2.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        ay.m16709a(e, "LogProcessor", "readLog2");
                        iOException.printStackTrace();
                        return str2;
                    }
                }
                return str2;
            }
            C3403b a2 = this.f12388a.m16834a(str);
            if (a2 == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e22) {
                        ay.m16709a(e22, "LogProcessor", "readLog1");
                        e22.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        iOException = e4;
                        ay.m16709a((Throwable) iOException, "LogProcessor", "readLog2");
                        iOException.printStackTrace();
                        return str2;
                    }
                }
                return str2;
            }
            a = a2.m16797a(0);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
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
                        } catch (Throwable e5) {
                            ay.m16709a(e5, "LogProcessor", "readLog1");
                            e5.printStackTrace();
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e6) {
                            e5 = e6;
                            ay.m16709a(e5, "LogProcessor", "readLog2");
                            iOException.printStackTrace();
                            return str2;
                        }
                    }
                } catch (IOException e7) {
                    e5 = e7;
                    try {
                        ay.m16709a(e5, "LogProcessor", "readLog");
                        e5.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e52) {
                                ay.m16709a(e52, "LogProcessor", "readLog1");
                                e52.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (IOException e8) {
                                e52 = e8;
                                ay.m16709a(e52, "LogProcessor", "readLog2");
                                iOException.printStackTrace();
                                return str2;
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e522) {
                                ay.m16709a(e522, "LogProcessor", "readLog1");
                                e522.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable e5222) {
                                ay.m16709a(e5222, "LogProcessor", "readLog2");
                                e5222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    e5222 = th3;
                    ay.m16709a(e5222, "LogProcessor", "readLog");
                    e5222.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e52222) {
                            ay.m16709a(e52222, "LogProcessor", "readLog1");
                            e52222.printStackTrace();
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e9) {
                            e52222 = e9;
                            ay.m16709a(e52222, "LogProcessor", "readLog2");
                            iOException.printStackTrace();
                            return str2;
                        }
                    }
                    return str2;
                }
            } catch (IOException e10) {
                e52222 = e10;
                obj = str2;
                ay.m16709a(e52222, "LogProcessor", "readLog");
                e52222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (a != null) {
                    a.close();
                }
                return str2;
            } catch (Throwable e522222) {
                obj = str2;
                th = e522222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            return str2;
        } catch (IOException e11) {
            e522222 = e11;
            obj = str2;
            Object obj2 = str2;
            ay.m16709a(e522222, "LogProcessor", "readLog");
            e522222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            return str2;
        } catch (Throwable e5222222) {
            byteArrayOutputStream = str2;
            a = str2;
            th = e5222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    void m16726c() {
        if (this.f12388a != null && !this.f12388a.m16836a()) {
            try {
                this.f12388a.close();
            } catch (Throwable e) {
                ay.m16709a(e, "LogProcessor", "closeDiskLru");
                e.printStackTrace();
            } catch (Throwable e2) {
                ay.m16709a(e2, "LogProcessor", "closeDiskLru");
                e2.printStackTrace();
            }
        }
    }

    private bk m16714a(Context context, String str) {
        bk bkVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(bf.f12415a);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                bkVar = bk.m16814a(file, 1, 1, 20480);
            }
        } catch (Throwable e) {
            ay.m16709a(e, "LogProcessor", "initDiskLru");
            e.printStackTrace();
        } catch (Throwable e2) {
            ay.m16709a(e2, "LogProcessor", "initDiskLru");
            e2.printStackTrace();
        }
        return bkVar;
    }
}
