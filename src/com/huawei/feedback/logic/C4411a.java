package com.huawei.feedback.logic;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.phoneserviceuni.common.d.a.a.a;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CaptureThirdAPPThread */
public class C4411a implements Runnable {
    private String f16383a = "";
    private String f16384b = "";
    private String f16385c = "";
    private String f16386d = "";
    private String f16387e = "";
    private String f16388f = "";
    private Bundle f16389g = null;
    private BufferedWriter f16390h;
    private Handler f16391i = null;
    private Context f16392j;
    private boolean f16393k = false;
    private ArrayList<String> f16394l;

    public C4411a(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<String> arrayList, boolean z, Context context) {
        this.f16383a = str;
        this.f16384b = str2;
        this.f16385c = str3;
        this.f16386d = str4;
        this.f16387e = str5;
        this.f16388f = str6;
        this.f16394l = arrayList;
        this.f16393k = z;
        this.f16392j = context;
    }

    public C4411a(String str, String str2, String str3, String str4, Bundle bundle, ArrayList<String> arrayList, Handler handler, Context context, boolean z) {
        this.f16383a = str;
        this.f16384b = str2;
        this.f16385c = str3;
        this.f16386d = str4;
        this.f16389g = bundle;
        this.f16391i = handler;
        this.f16392j = context;
        this.f16394l = arrayList;
        this.f16393k = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r0 = 0;
        r1 = r8.f16387e;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0047;
    L_0x0009:
        r1 = r8.f16388f;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0047;
    L_0x0011:
        r1 = com.huawei.feedback.b.c;
        r2 = r8.f16387e;
        com.huawei.feedback.c.a(r1, r2);
        r1 = r8.f16388f;
        r2 = r8.f16387e;
        com.huawei.feedback.c.a(r1, r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r8.f16392j;
        r2 = r2.getFilesDir();
        r2 = r2.getPath();
        r1 = r1.append(r2);
        r2 = java.io.File.separator;
        r1 = r1.append(r2);
        r2 = "feedbackuploadlogs";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = r8.f16387e;
        com.huawei.feedback.c.a(r1, r2);
    L_0x0047:
        r1 = r8.f16389g;
        if (r1 == 0) goto L_0x0070;
    L_0x004b:
        r1 = new com.huawei.feedback.a.a.a;
        r2 = r8.f16392j;
        r1.<init>(r2);
        r2 = com.huawei.feedback.b.b;
        monitor-enter(r2);
        r1 = com.huawei.feedback.a.a.b.a(r1);	 Catch:{ all -> 0x00bb }
        r1 = r1.size();	 Catch:{ all -> 0x00bb }
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r1 < r3) goto L_0x006a;
    L_0x0061:
        r0 = "AppLogApi/CaptureThirdAPPThread";
        r1 = "logList size over max length!";
        com.huawei.phoneserviceuni.common.d.c.d(r0, r1);	 Catch:{ all -> 0x00bb }
        monitor-exit(r2);	 Catch:{ all -> 0x00bb }
    L_0x0069:
        return;
    L_0x006a:
        monitor-exit(r2);	 Catch:{ all -> 0x00bb }
        r1 = r8.f16389g;
        r8.m21236a(r1);
    L_0x0070:
        r1 = 0;
        r2 = r8.f16394l;
        if (r2 == 0) goto L_0x00be;
    L_0x0075:
        r2 = r8.f16394l;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x00be;
    L_0x007d:
        r1 = "AppLogApi/CaptureThirdAPPThread";
        r2 = "logwritePathList";
        com.huawei.phoneserviceuni.common.d.c.b(r1, r2);
        r1 = r8.f16394l;
        r1 = com.huawei.feedback.c.a(r1);
        r2 = r1;
    L_0x008b:
        if (r2 == 0) goto L_0x0069;
    L_0x008d:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x0069;
    L_0x0090:
        r4 = new java.io.File[r3];
        r1 = r0;
    L_0x0093:
        if (r1 >= r3) goto L_0x00e8;
    L_0x0095:
        r5 = "AppLogApi/CaptureThirdAPPThread";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "fileName";
        r6 = r6.append(r7);
        r7 = r2[r1];
        r6 = r6.append(r7);
        r6 = r6.toString();
        com.huawei.phoneserviceuni.common.d.c.b(r5, r6);
        r5 = new java.io.File;
        r6 = r2[r1];
        r5.<init>(r6);
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0093;
    L_0x00bb:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00bb }
        throw r0;
    L_0x00be:
        r2 = r8.f16385c;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0138;
    L_0x00c6:
        r1 = "AppLogApi/CaptureThirdAPPThread";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "logwritePath";
        r2 = r2.append(r3);
        r3 = r8.f16385c;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.huawei.phoneserviceuni.common.d.c.b(r1, r2);
        r1 = r8.f16385c;
        r1 = com.huawei.feedback.c.a(r1);
        r2 = r1;
        goto L_0x008b;
    L_0x00e8:
        r1 = new java.io.File;
        r2 = r8.f16384b;
        r1.<init>(r2);
        r2 = "AppLogApi/CaptureThirdAPPThread";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "waitUploadZipfile";
        r3 = r3.append(r5);
        r5 = r1.getPath();
        r3 = r3.append(r5);
        r3 = r3.toString();
        com.huawei.phoneserviceuni.common.d.c.b(r2, r3);
    L_0x010c:
        r2 = 2;
        if (r0 >= r2) goto L_0x0069;
    L_0x010f:
        r2 = r8.f16392j;
        r2 = com.huawei.feedback.c.a(r4, r1, r2);
        if (r2 == 0) goto L_0x012a;
    L_0x0117:
        r0 = "AppLogApi/CaptureThirdAPPThread";
        r2 = "waitUploadZipfile zipflag good";
        com.huawei.phoneserviceuni.common.d.c.b(r0, r2);
        r0 = r8.f16386d;
        r2 = r8.f16383a;
        r3 = r8.f16391i;
        r8.m21237a(r0, r2, r1, r3);
        goto L_0x0069;
    L_0x012a:
        r2 = 1;
        if (r0 != r2) goto L_0x0135;
    L_0x012d:
        r2 = "AppLogApi/CaptureThirdAPPThread";
        r3 = "zipflag fail!";
        com.huawei.phoneserviceuni.common.d.c.c(r2, r3);
    L_0x0135:
        r0 = r0 + 1;
        goto L_0x010c;
    L_0x0138:
        r2 = r1;
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.logic.a.run():void");
    }

    private boolean m21238a(File file, File file2) {
        return file.renameTo(file2);
    }

    private void m21237a(String str, String str2, File file, Handler handler) {
        if (!TextUtils.isEmpty(str)) {
            Object a = a.a(str);
            if (TextUtils.isEmpty(a)) {
                c.d("AppLogApi/CaptureThirdAPPThread", "encryptKey null,encryptFile failed!");
            } else {
                File a2 = com.huawei.phoneserviceuni.common.d.a.b.a.a.a(file, a, this.f16393k, this.f16392j);
                if (a2 != null && a2.exists()) {
                    m21238a(a2, new File(str2));
                    if (handler != null) {
                        handler.sendEmptyMessage(1);
                    }
                }
            }
        }
        if (file.exists()) {
            int i = 0;
            while (i < 2) {
                boolean delete = file.delete();
                c.b("AppLogApi/CaptureThirdAPPThread", "resultZipFile delete success ? " + delete);
                if (!delete) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void m21236a(Bundle bundle) {
        FileOutputStream fileOutputStream;
        FileNotFoundException e;
        Throwable th;
        UnsupportedEncodingException e2;
        IOException e3;
        String string = bundle.getString("LogVersion");
        String string2 = bundle.getString("LogSubversion");
        String string3 = bundle.getString("ProductName");
        String string4 = bundle.getString("ProductVersion");
        String string5 = bundle.getString("SN");
        String string6 = bundle.getString("IMEI");
        CharSequence string7 = bundle.getString("MetaData");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("LogVersion", string);
            jSONObject.putOpt("LogSubversion", string2);
            jSONObject.putOpt("ProductName", string3);
            jSONObject.putOpt("ProductVersion", string4);
            jSONObject.putOpt("SN", string5);
            jSONObject.putOpt("IMEI", string6);
        } catch (JSONException e4) {
            c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog JSONException!" + e4.getMessage());
        }
        string4 = jSONObject.toString();
        string = this.f16385c;
        if (this.f16394l != null && this.f16394l.size() > 0) {
            string = (String) this.f16394l.get(0);
        }
        try {
            fileOutputStream = new FileOutputStream(new File(string + "/eventinfo.log"));
            try {
                this.f16390h = new BufferedWriter(new OutputStreamWriter(fileOutputStream, GameManager.DEFAULT_CHARSET));
                this.f16390h.append(string4 + '\n');
                this.f16390h.append(string7);
                this.f16390h.flush();
                C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
                if (this.f16390h != null) {
                    try {
                        this.f16390h.close();
                    } catch (IOException e5) {
                        c.d("AppLogApi/CaptureThirdAPPThread", "shutdown IOException");
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                try {
                    c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog FileNotFoundException!" + e.getMessage());
                    C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
                    if (this.f16390h != null) {
                        try {
                            this.f16390h.close();
                        } catch (IOException e7) {
                            c.d("AppLogApi/CaptureThirdAPPThread", "shutdown IOException");
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
                    if (this.f16390h != null) {
                        try {
                            this.f16390h.close();
                        } catch (IOException e8) {
                            c.d("AppLogApi/CaptureThirdAPPThread", "shutdown IOException");
                        }
                    }
                    throw th;
                }
            } catch (UnsupportedEncodingException e9) {
                e2 = e9;
                c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog UnsupportedEncodingException!" + e2.getMessage());
                C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
                if (this.f16390h != null) {
                    try {
                        this.f16390h.close();
                    } catch (IOException e10) {
                        c.d("AppLogApi/CaptureThirdAPPThread", "shutdown IOException");
                    }
                }
            } catch (IOException e11) {
                e3 = e11;
                c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog IOException!" + e3.getMessage());
                C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
                if (this.f16390h != null) {
                    try {
                        this.f16390h.close();
                    } catch (IOException e12) {
                        c.d("AppLogApi/CaptureThirdAPPThread", "shutdown IOException");
                    }
                }
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            fileOutputStream = null;
            c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog FileNotFoundException!" + e.getMessage());
            C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
            if (this.f16390h != null) {
                this.f16390h.close();
            }
        } catch (UnsupportedEncodingException e14) {
            e2 = e14;
            fileOutputStream = null;
            c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog UnsupportedEncodingException!" + e2.getMessage());
            C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
            if (this.f16390h != null) {
                this.f16390h.close();
            }
        } catch (IOException e15) {
            e3 = e15;
            fileOutputStream = null;
            c.d("AppLogApi/CaptureThirdAPPThread", "creatEventlog IOException!" + e3.getMessage());
            C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
            if (this.f16390h != null) {
                this.f16390h.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            C5767b.m26474a(fileOutputStream, "AppLogApi/CaptureThirdAPPThread");
            if (this.f16390h != null) {
                this.f16390h.close();
            }
            throw th;
        }
    }
}
