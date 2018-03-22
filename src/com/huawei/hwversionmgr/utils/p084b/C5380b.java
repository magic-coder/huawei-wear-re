package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import com.huawei.hwversionmgr.a.g;
import com.huawei.hwversionmgr.utils.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppPullChangeLogThread */
public class C5380b implements Runnable {
    private static boolean f19143c = false;
    private Context f19144a;
    private Handler f19145b;
    private C5383e f19146d;
    private Boolean f19147e;

    public static void m25876a(boolean z) {
        f19143c = z;
    }

    public C5380b(Context context, Handler handler, Boolean bool) {
        this.f19144a = context;
        this.f19145b = handler;
        this.f19147e = bool;
    }

    public void run() {
        try {
            C5381c a;
            String str;
            if (this.f19147e.booleanValue()) {
                if (c.i().u != null) {
                    str = c.i().u.split("full/")[0] + "full/" + "changelog.xml";
                    C2538c.b("AppPullChangeLogThread", new Object[]{"APP: current system language=" + m25868a()});
                    a = C5380b.m25867a(this.f19144a, str, r2);
                } else {
                    C2538c.b("AppPullChangeLogThread", new Object[]{"DOWNLOADURL is null"});
                    a = null;
                }
            } else if (c.j().u != null) {
                str = c.j().u.split("full/")[0] + "full/" + "changelog.xml";
                C2538c.b("AppPullChangeLogThread", new Object[]{"Band: current system language=" + m25868a()});
                a = C5380b.m25867a(this.f19144a, str, r2);
            } else {
                C2538c.b("AppPullChangeLogThread", new Object[]{"DOWNLOADURL is null"});
                a = null;
            }
            if (a == null) {
                m25871a(0, null);
                return;
            }
            Object a2;
            this.f19146d = m25877a(a);
            if (this.f19146d != null) {
                a2 = m25870a(this.f19146d.f19156c);
            } else {
                a2 = null;
            }
            if (a2 == null) {
                C2538c.b("AppPullChangeLogThread", new Object[]{"changelog is null"});
                m25871a(0, null);
                return;
            }
            C2538c.b("AppPullChangeLogThread", new Object[]{"changelog is not null"});
            m25871a(1, a2);
        } catch (Exception e) {
            m25871a(0, null);
            C2538c.e("AppPullChangeLogThread", new Object[]{"PULL_CHANGE_LOG, Exception : " + e.getMessage()});
        }
    }

    private void m25871a(int i, Object obj) {
        if (this.f19145b != null) {
            Message obtainMessage = this.f19145b.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = obj;
            if (!f19143c) {
                this.f19145b.sendMessage(obtainMessage);
            }
        }
    }

    private String m25868a() {
        Configuration configuration = this.f19144a.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        return (language + '-' + configuration.locale.getCountry()).toLowerCase();
    }

    public static C5381c m25867a(Context context, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        Object obj;
        Throwable th;
        Throwable th2;
        Object obj2;
        C5381c c5381c = null;
        int i = -1;
        C2538c.b("AppPullChangeLogThread", new Object[]{"serverUri = " + str + ", languageName" + str2});
        Object toByteArray;
        int i2;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                i = C5380b.m25864a(context, str, (OutputStream) byteArrayOutputStream);
                C2538c.b("AppPullChangeLogThread", new Object[]{"statusCode = " + i});
                if (byteArrayOutputStream != null) {
                    if (i == 200) {
                        toByteArray = byteArrayOutputStream.toByteArray();
                        i2 = 0;
                        while (i2 < toByteArray.length && toByteArray[i2] != TagName.TagExpectationAndNext) {
                            i2++;
                        }
                        obj = new byte[(toByteArray.length - i2)];
                        System.arraycopy(toByteArray, i2, obj, 0, toByteArray.length - i2);
                        c5381c = C5380b.m25866a(context, new ByteArrayInputStream(obj), str2);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        C2538c.c("AppPullChangeLogThread", new Object[]{"getChangeLogFromServer IOException"});
                    }
                }
            } catch (IOException e2) {
                try {
                    C2538c.c("AppPullChangeLogThread", new Object[]{"IOException"});
                    if (byteArrayOutputStream != null) {
                        if (i == 200) {
                            toByteArray = byteArrayOutputStream.toByteArray();
                            i2 = 0;
                            while (i2 < toByteArray.length) {
                                i2++;
                            }
                            obj = new byte[(toByteArray.length - i2)];
                            System.arraycopy(toByteArray, i2, obj, 0, toByteArray.length - i2);
                            c5381c = C5380b.m25866a(context, new ByteArrayInputStream(obj), str2);
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            C2538c.c("AppPullChangeLogThread", new Object[]{"getChangeLogFromServer IOException"});
                        }
                    }
                    return c5381c;
                } catch (Throwable th3) {
                    th = th3;
                    i2 = i;
                    th2 = th;
                    if (byteArrayOutputStream != null) {
                        if (i2 == 200) {
                            obj = byteArrayOutputStream.toByteArray();
                            i2 = 0;
                            while (i2 < obj.length) {
                                i2++;
                            }
                            obj2 = new byte[(obj.length - i2)];
                            System.arraycopy(obj, i2, obj2, 0, obj.length - i2);
                            C5380b.m25866a(context, new ByteArrayInputStream(obj2), str2);
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            C2538c.c("AppPullChangeLogThread", new Object[]{"getChangeLogFromServer IOException"});
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e5) {
            byteArrayOutputStream = null;
            C2538c.c("AppPullChangeLogThread", new Object[]{"IOException"});
            if (byteArrayOutputStream != null) {
                if (i == 200) {
                    toByteArray = byteArrayOutputStream.toByteArray();
                    i2 = 0;
                    while (i2 < toByteArray.length && toByteArray[i2] != TagName.TagExpectationAndNext) {
                        i2++;
                    }
                    obj = new byte[(toByteArray.length - i2)];
                    System.arraycopy(toByteArray, i2, obj, 0, toByteArray.length - i2);
                    c5381c = C5380b.m25866a(context, new ByteArrayInputStream(obj), str2);
                }
                byteArrayOutputStream.close();
            }
            return c5381c;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            i2 = -1;
            th2 = th;
            if (byteArrayOutputStream != null) {
                if (i2 == 200) {
                    obj = byteArrayOutputStream.toByteArray();
                    i2 = 0;
                    while (i2 < obj.length && obj[i2] != TagName.TagExpectationAndNext) {
                        i2++;
                    }
                    obj2 = new byte[(obj.length - i2)];
                    System.arraycopy(obj, i2, obj2, 0, obj.length - i2);
                    C5380b.m25866a(context, new ByteArrayInputStream(obj2), str2);
                }
                byteArrayOutputStream.close();
            }
            throw th2;
        }
        return c5381c;
    }

    private static int m25864a(Context context, String str, OutputStream outputStream) throws RuntimeException, IOException {
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(str);
        c.a(httpGet, defaultHttpClient, context);
        HttpParams params = httpGet.getParams();
        params.setIntParameter("http.socket.timeout", 20000);
        params.setIntParameter("http.connection.timeout", 20000);
        HttpProtocolParams.setUserAgent(params, c.c());
        C2538c.b("AppPullChangeLogThread", new Object[]{"getXMLStreamFormServer statusCode = " + C5380b.m25865a(context, defaultHttpClient, httpGet, outputStream)});
        httpGet.abort();
        C2538c.b("AppPullChangeLogThread", new Object[]{"getXMLStreamFormServer abort"});
        return C5380b.m25865a(context, defaultHttpClient, httpGet, outputStream);
    }

    private static int m25865a(Context context, HttpClient httpClient, HttpGet httpGet, OutputStream outputStream) {
        int statusCode;
        IOException e;
        try {
            HttpResponse execute = httpClient.execute(httpGet);
            statusCode = execute.getStatusLine().getStatusCode();
            try {
                C2538c.b("AppPullChangeLogThread", new Object[]{"getXMLStreamFormServerExecute statusCode = " + statusCode});
                if (outputStream != null) {
                    execute.getEntity().writeTo(outputStream);
                }
            } catch (IOException e2) {
                e = e2;
                C2538c.e("AppPullChangeLogThread", new Object[]{e.getMessage()});
                return statusCode;
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            statusCode = -1;
            e = iOException;
            C2538c.e("AppPullChangeLogThread", new Object[]{e.getMessage()});
            return statusCode;
        }
        return statusCode;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hwversionmgr.utils.p084b.C5381c m25866a(android.content.Context r21, java.io.InputStream r22, java.lang.String r23) {
        /*
        r3 = 0;
        r2 = 0;
        r1 = "AppPullChangeLogThread";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "buildChangeLogXML begin";
        r4[r5] = r6;
        com.huawei.v.c.b(r1, r4);
        r1 = org.xmlpull.v1.XmlPullParserFactory.newInstance();	 Catch:{ Exception -> 0x0280 }
        r12 = r1.newPullParser();	 Catch:{ Exception -> 0x0280 }
        if (r12 != 0) goto L_0x0028;
    L_0x0019:
        r1 = "AppPullChangeLogThread";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0280 }
        r5 = 0;
        r6 = "parser exception,pullParser is null";
        r4[r5] = r6;	 Catch:{ Exception -> 0x0280 }
        com.huawei.v.c.b(r1, r4);	 Catch:{ Exception -> 0x0280 }
        r1 = 0;
    L_0x0027:
        return r1;
    L_0x0028:
        r1 = "UTF-8";
        r0 = r22;
        r12.setInput(r0, r1);	 Catch:{ Exception -> 0x0280 }
        r11 = r12.getEventType();	 Catch:{ Exception -> 0x0280 }
        r10 = 0;
        r9 = 0;
        r7 = -1;
        r6 = 0;
        r5 = 0;
        r8 = 0;
        r4 = 0;
        r1 = "";
        r19 = r1;
        r1 = r5;
        r5 = r6;
        r6 = r11;
        r11 = r9;
        r9 = r19;
        r20 = r4;
        r4 = r7;
        r7 = r3;
        r3 = r10;
        r10 = r20;
    L_0x004b:
        r13 = 1;
        if (r6 == r13) goto L_0x027a;
    L_0x004e:
        r13 = r12.getName();	 Catch:{ Exception -> 0x02a6 }
        r14 = "AppPullChangeLogThread";
        r15 = 1;
        r15 = new java.lang.Object[r15];	 Catch:{ Exception -> 0x02a6 }
        r16 = 0;
        r17 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02a6 }
        r17.<init>();	 Catch:{ Exception -> 0x02a6 }
        r18 = "eventType = ";
        r17 = r17.append(r18);	 Catch:{ Exception -> 0x02a6 }
        r0 = r17;
        r17 = r0.append(r6);	 Catch:{ Exception -> 0x02a6 }
        r18 = ", nodeName = ";
        r17 = r17.append(r18);	 Catch:{ Exception -> 0x02a6 }
        r0 = r17;
        r17 = r0.append(r13);	 Catch:{ Exception -> 0x02a6 }
        r17 = r17.toString();	 Catch:{ Exception -> 0x02a6 }
        r15[r16] = r17;	 Catch:{ Exception -> 0x02a6 }
        com.huawei.v.c.b(r14, r15);	 Catch:{ Exception -> 0x02a6 }
        switch(r6) {
            case 2: goto L_0x00a1;
            case 3: goto L_0x01e3;
            default: goto L_0x0082;
        };
    L_0x0082:
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
    L_0x008d:
        r11 = r12.next();	 Catch:{ Exception -> 0x0280 }
        r19 = r1;
        r1 = r5;
        r5 = r6;
        r6 = r11;
        r11 = r9;
        r9 = r19;
        r20 = r4;
        r4 = r7;
        r7 = r3;
        r3 = r10;
        r10 = r20;
        goto L_0x004b;
    L_0x00a1:
        r6 = "root";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x00ca;
    L_0x00aa:
        r6 = new com.huawei.hwversionmgr.utils.b.c;	 Catch:{ Exception -> 0x02a6 }
        r6.<init>();	 Catch:{ Exception -> 0x02a6 }
        r2 = "AppPullChangeLogThread";
        r13 = 1;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x02a9 }
        r14 = 0;
        r15 = "root";
        r13[r14] = r15;	 Catch:{ Exception -> 0x02a9 }
        com.huawei.v.c.b(r2, r13);	 Catch:{ Exception -> 0x02a9 }
        r2 = r6;
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x00ca:
        r6 = "cleardata-flag";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x010a;
    L_0x00d2:
        r12.next();	 Catch:{ Exception -> 0x02a6 }
        r6 = "true";
        r11 = r12.getText();	 Catch:{ Exception -> 0x02a6 }
        r11 = r6.equalsIgnoreCase(r11);	 Catch:{ Exception -> 0x02a6 }
        r6 = "AppPullChangeLogThread";
        r13 = 1;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x02a6 }
        r14 = 0;
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02a6 }
        r15.<init>();	 Catch:{ Exception -> 0x02a6 }
        r16 = "cleardata-flag start,cleardata-flag=";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x02a6 }
        r15 = r15.append(r11);	 Catch:{ Exception -> 0x02a6 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x02a6 }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02a6 }
        com.huawei.v.c.b(r6, r13);	 Catch:{ Exception -> 0x02a6 }
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x010a:
        r6 = "default-language";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x0156;
    L_0x0112:
        r3 = "AppPullChangeLogThread";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x02a6 }
        r6 = 0;
        r13 = "default-language";
        r4[r6] = r13;	 Catch:{ Exception -> 0x02a6 }
        com.huawei.v.c.b(r3, r4);	 Catch:{ Exception -> 0x02a6 }
        r3 = com.huawei.hwversionmgr.utils.p084b.C5380b.m25869a(r12);	 Catch:{ Exception -> 0x02a6 }
        r4 = r12.nextText();	 Catch:{ Exception -> 0x02a6 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x02a6 }
        r6 = "AppPullChangeLogThread";
        r13 = 1;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x02a6 }
        r14 = 0;
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02a6 }
        r15.<init>();	 Catch:{ Exception -> 0x02a6 }
        r16 = "default-language,defaultLanguageCode=";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x02a6 }
        r15 = r15.append(r4);	 Catch:{ Exception -> 0x02a6 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x02a6 }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02a6 }
        com.huawei.v.c.b(r6, r13);	 Catch:{ Exception -> 0x02a6 }
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x0156:
        r6 = "language";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x018a;
    L_0x015e:
        r6 = "AppPullChangeLogThread";
        r13 = 1;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x02a6 }
        r14 = 0;
        r15 = "language";
        r13[r14] = r15;	 Catch:{ Exception -> 0x02a6 }
        com.huawei.v.c.b(r6, r13);	 Catch:{ Exception -> 0x02a6 }
        if (r2 == 0) goto L_0x017a;
    L_0x016d:
        r5 = new com.huawei.hwversionmgr.utils.b.e;	 Catch:{ Exception -> 0x02a6 }
        r5.<init>();	 Catch:{ Exception -> 0x02a6 }
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x02a6 }
        r6.<init>();	 Catch:{ Exception -> 0x02a6 }
        r5.f19156c = r6;	 Catch:{ Exception -> 0x02a6 }
    L_0x017a:
        com.huawei.hwversionmgr.utils.p084b.C5380b.m25874a(r12, r5);	 Catch:{ Exception -> 0x02a6 }
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x018a:
        r6 = "features";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x01b1;
    L_0x0192:
        r10 = new java.util.ArrayList;	 Catch:{ Exception -> 0x02a6 }
        r10.<init>();	 Catch:{ Exception -> 0x02a6 }
        r9 = "";
        if (r2 == 0) goto L_0x02b0;
    L_0x019b:
        r6 = new com.huawei.hwversionmgr.utils.b.d;	 Catch:{ Exception -> 0x02a6 }
        r6.<init>();	 Catch:{ Exception -> 0x02a6 }
    L_0x01a0:
        com.huawei.hwversionmgr.utils.p084b.C5380b.m25875a(r12, r5, r6);	 Catch:{ Exception -> 0x02a6 }
        r8 = r6;
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x01b1:
        r6 = "feature";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x0082;
    L_0x01b9:
        if (r5 == 0) goto L_0x0082;
    L_0x01bb:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02a6 }
        r6.<init>();	 Catch:{ Exception -> 0x02a6 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x02a6 }
        r9 = r12.nextText();	 Catch:{ Exception -> 0x02a6 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x02a6 }
        r9 = "\n";
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x02a6 }
        r9 = r6.toString();	 Catch:{ Exception -> 0x02a6 }
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x01e3:
        r6 = "root";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x01ff;
    L_0x01ec:
        if (r2 == 0) goto L_0x01f1;
    L_0x01ee:
        r2.f19150c = r1;	 Catch:{ Exception -> 0x02a6 }
    L_0x01f1:
        r7 = 1;
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x01ff:
        r6 = "language";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x0226;
    L_0x0207:
        if (r1 != 0) goto L_0x02ad;
    L_0x0209:
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x02a6 }
        r6.<init>();	 Catch:{ Exception -> 0x02a6 }
    L_0x020e:
        r6.add(r5);	 Catch:{ Exception -> 0x02a6 }
        r1 = r23;
        com.huawei.hwversionmgr.utils.p084b.C5380b.m25873a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x02a6 }
        r1 = r9;
        r9 = r11;
        r19 = r6;
        r6 = r5;
        r5 = r19;
        r20 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r20;
        goto L_0x008d;
    L_0x0226:
        r6 = "cleardata-flag";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x0262;
    L_0x022e:
        if (r2 == 0) goto L_0x0082;
    L_0x0230:
        r2.f19151d = r11;	 Catch:{ Exception -> 0x02a6 }
        r6 = "AppPullChangeLogThread";
        r13 = 1;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x02a6 }
        r14 = 0;
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02a6 }
        r15.<init>();	 Catch:{ Exception -> 0x02a6 }
        r16 = "cleardata-flag end,changeLog.CLEAR_DATA_FLAG=";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x02a6 }
        r16 = r2.f19151d;	 Catch:{ Exception -> 0x02a6 }
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x02a6 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x02a6 }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02a6 }
        com.huawei.v.c.b(r6, r13);	 Catch:{ Exception -> 0x02a6 }
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x0262:
        r6 = "features";
        r6 = r6.equalsIgnoreCase(r13);	 Catch:{ Exception -> 0x02a6 }
        if (r6 == 0) goto L_0x0082;
    L_0x026a:
        com.huawei.hwversionmgr.utils.p084b.C5380b.m25872a(r5, r8, r10, r9);	 Catch:{ Exception -> 0x02a6 }
        r6 = r5;
        r5 = r1;
        r1 = r9;
        r9 = r11;
        r19 = r4;
        r4 = r10;
        r10 = r3;
        r3 = r7;
        r7 = r19;
        goto L_0x008d;
    L_0x027a:
        r1 = r2;
    L_0x027b:
        if (r7 != 0) goto L_0x0027;
    L_0x027d:
        r1 = 0;
        goto L_0x0027;
    L_0x0280:
        r1 = move-exception;
    L_0x0281:
        r4 = "AppPullChangeLogThread";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "buildChangeLogXML, Exception : ";
        r7 = r7.append(r8);
        r1 = r1.getMessage();
        r1 = r7.append(r1);
        r1 = r1.toString();
        r5[r6] = r1;
        com.huawei.v.c.e(r4, r5);
        r1 = r2;
        r7 = r3;
        goto L_0x027b;
    L_0x02a6:
        r1 = move-exception;
        r3 = r7;
        goto L_0x0281;
    L_0x02a9:
        r1 = move-exception;
        r2 = r6;
        r3 = r7;
        goto L_0x0281;
    L_0x02ad:
        r6 = r1;
        goto L_0x020e;
    L_0x02b0:
        r6 = r8;
        goto L_0x01a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwversionmgr.utils.b.b.a(android.content.Context, java.io.InputStream, java.lang.String):com.huawei.hwversionmgr.utils.b.c");
    }

    private static void m25872a(C5383e c5383e, C5382d c5382d, List<String> list, String str) {
        if (c5383e != null) {
            c5383e.f19156c.add(c5382d);
            if (list != null) {
                list.add(str);
            }
            if (c5382d != null) {
                c5382d.f19153b = list;
            }
        }
    }

    private static void m25875a(XmlPullParser xmlPullParser, C5383e c5383e, C5382d c5382d) {
        if (xmlPullParser.getAttributeCount() <= 0 || !JoinConstants.MODULE.equals(xmlPullParser.getAttributeName(0))) {
            if (c5382d != null) {
                c5382d.f19152a = "";
            }
        } else if (c5383e != null && c5382d != null) {
            c5382d.f19152a = xmlPullParser.getAttributeValue(0);
        }
    }

    private static void m25873a(String str, C5381c c5381c, String str2, int i, C5383e c5383e, List<C5383e> list) {
        if (c5383e != null && c5381c != null) {
            if (c5383e.f19154a.equalsIgnoreCase(str2) && c5383e.f19155b == i) {
                c5381c.f19149b = list.size() - 1;
            }
            if (c5383e.f19154a.equalsIgnoreCase(str)) {
                c5381c.f19148a = list.size() - 1;
            }
        }
    }

    private static void m25874a(XmlPullParser xmlPullParser, C5383e c5383e) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if ("name".equals(xmlPullParser.getAttributeName(i))) {
                if (c5383e != null) {
                    c5383e.f19154a = xmlPullParser.getAttributeValue(i);
                }
            } else if ("code".equals(xmlPullParser.getAttributeName(i)) && c5383e != null) {
                c5383e.f19155b = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            }
        }
    }

    private static String m25869a(XmlPullParser xmlPullParser) {
        String str = "";
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if ("name".equals(xmlPullParser.getAttributeName(i))) {
                str = xmlPullParser.getAttributeValue(i);
            }
        }
        return str;
    }

    public C5383e m25877a(C5381c c5381c) {
        if (c5381c == null) {
            C2538c.b("AppPullChangeLogThread", new Object[]{"getFeatureWhenPullChangeLogSuccess---msgObjOfCallBack==null"});
            return null;
        }
        C2538c.b("AppPullChangeLogThread", new Object[]{"pull change log success"});
        C2538c.b("AppPullChangeLogThread", new Object[]{"changeLogXml.CURRENT_LANGUAGE " + c5381c.f19148a});
        if (c5381c.f19148a != -1) {
            return (C5383e) c5381c.f19150c.get(c5381c.f19148a);
        }
        if (c5381c.f19149b != -1) {
            return (C5383e) c5381c.f19150c.get(c5381c.f19149b);
        }
        return null;
    }

    private List<g> m25870a(List<C5382d> list) {
        List<g> arrayList = new ArrayList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                C5382d c5382d = (C5382d) list.get(i);
                g gVar = new g();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("");
                if (c5382d != null) {
                    gVar.a(c5382d.f19152a);
                    for (int i2 = 0; i2 < c5382d.f19153b.size(); i2++) {
                        stringBuffer.append((String) c5382d.f19153b.get(i2));
                    }
                    gVar.b(stringBuffer.toString());
                    arrayList.add(gVar);
                } else {
                    gVar.a(null);
                }
            }
        }
        return arrayList;
    }
}
