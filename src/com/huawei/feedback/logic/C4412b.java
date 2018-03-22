package com.huawei.feedback.logic;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.a.b.a;
import com.huawei.feedback.b;
import com.huawei.feedback.bean.C4409c;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.c;
import com.huawei.feedback.d;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.lcagent.client.LogMetricInfo;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import com.huawei.phoneserviceuni.common.p493b.C5759a;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;
import p000a.p001a.p002a.p202b.C2852a;

/* compiled from: Feedback */
public final class C4412b {
    private static LogMetricInfo f16395a = null;

    public static boolean m21244a(C4409c c4409c, int i, String str, String str2, String str3, LogMetricInfo logMetricInfo, LogCollectManager logCollectManager, boolean z, Handler handler, String str4, String str5, String str6, C4410d c4410d, int i2) {
        DataOutputStream dataOutputStream;
        String str7;
        InputStream inputStream;
        Throwable th;
        if (z) {
            f16395a = logMetricInfo;
        }
        Context applicationcontext = FeedbackApi.getApplicationcontext();
        InputStream inputStream2 = null;
        String str8 = "";
        C5759a.m26446a();
        DataOutputStream dataOutputStream2;
        try {
            System.setProperty("http.keepAlive", "false");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://iservice.vmall.com:443/osg/feedbackAction!addQuestion.htm").openConnection();
            httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty("Connection", "keep-alive");
            httpsURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------40612316912668");
            httpsURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
            httpsURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
            httpsURLConnection.setChunkedStreamingMode(0);
            httpsURLConnection.connect();
            dataOutputStream2 = new DataOutputStream(httpsURLConnection.getOutputStream());
            try {
                C4426q.m21279b("deviceType", Build.MODEL, dataOutputStream2);
                C4426q.m21279b("sysVersion", Build.DISPLAY, dataOutputStream2);
                if (TextUtils.isEmpty(a.a().f())) {
                    a.a().e();
                }
                String f = a.a().f();
                if (TextUtils.isEmpty(f)) {
                    f = "000000000000000";
                }
                C4426q.m21279b("deviceID", f, dataOutputStream2);
                C4426q.m21279b("deviceToken", a.a().c(), dataOutputStream2);
                C4426q.m21279b("contactAddress", c4409c.m21181j(), dataOutputStream2);
                C4426q.m21279b("question", c4409c.m21175g(), dataOutputStream2);
                if (TextUtils.isEmpty(c4409c.m21184l())) {
                    C4426q.m21279b("questionType", applicationcontext.getResources().getString(d.b(FeedbackApi.getApplicationcontext(), "feedback_cloud_service")), dataOutputStream2);
                } else {
                    C4426q.m21279b("questionType", c4409c.m21184l(), dataOutputStream2);
                }
                String[] split = str2.split("\\|");
                if (split.length == 1) {
                    C4426q.m21275a(split[0], "", dataOutputStream2);
                } else {
                    str8 = C4426q.m21278a(split);
                    C4426q.m21276a(true, dataOutputStream2, str8);
                }
                C4426q.m21279b("versionID", "3.0", dataOutputStream2);
                C4426q.m21279b(AppOpenOrDownHelper.APP_ID_PARAM, c4409c.m21183k() + "", dataOutputStream2);
                C4426q.m21279b("isUploadLog", str5, dataOutputStream2);
                C4426q.m21279b("frequency", str4, dataOutputStream2);
                if ("0".equals(str5)) {
                    C4426q.m21279b("uploadFileName", "", dataOutputStream2);
                } else {
                    C4426q.m21279b("uploadFileName", str6, dataOutputStream2);
                }
                if (c4409c.m21178h() && z && f16395a != null && !TextUtils.isEmpty(f16395a.path)) {
                    C4426q.m21276a(false, dataOutputStream2, f16395a.path);
                }
                C4426q.m21279b("apkType", String.valueOf(i2), dataOutputStream2);
                if (c.j(applicationcontext)) {
                    C4426q.m21279b("isPush", "1", dataOutputStream2);
                } else {
                    C4426q.m21279b("isPush", "0", dataOutputStream2);
                }
                if (!TextUtils.isEmpty(c4409c.m21168d())) {
                    C4426q.m21279b("appPackageName", c4409c.m21168d(), dataOutputStream2);
                }
                if (!TextUtils.isEmpty(c4409c.m21171e())) {
                    C4426q.m21279b(Constant.KEY_APP_VERSION, c4409c.m21171e(), dataOutputStream2);
                }
                C4426q.m21274a(dataOutputStream2);
                dataOutputStream2.flush();
                if (httpsURLConnection.getResponseCode() == 503) {
                    C4412b.m21239a(applicationcontext, c4409c, c4410d, handler);
                    C5767b.m26475a(null, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                    C5767b.m26478a(str8);
                    return false;
                }
                InputStream inputStream3 = httpsURLConnection.getInputStream();
                try {
                    boolean z2;
                    String a = C5767b.m26471a(inputStream3);
                    com.huawei.phoneserviceuni.common.d.c.b("Feedback", "response = " + a);
                    C5767b.m26475a(inputStream3, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                    C5767b.m26478a(str8);
                    C4425p c4425p = new C4425p();
                    if (c4425p.m21272a(a) == 0 && c4425p.m21271a() == 0) {
                        C4412b.m21243a(c4425p, c4409c, c4410d, str, str3, applicationcontext, str5, handler);
                        z2 = true;
                    } else {
                        com.huawei.phoneserviceuni.common.d.c.d("Feedback", "response = " + a);
                        C4412b.m21239a(applicationcontext, c4409c, c4410d, handler);
                        z2 = false;
                    }
                    return z2;
                } catch (IOException e) {
                    dataOutputStream = dataOutputStream2;
                    InputStream inputStream4 = inputStream3;
                    str7 = str8;
                    inputStream = inputStream4;
                    try {
                        com.huawei.phoneserviceuni.common.d.c.d("Feedback", "IOException ...");
                        C4412b.m21239a(applicationcontext, c4409c, c4410d, handler);
                        C5767b.m26475a(inputStream, "Feedback");
                        C5767b.m26472a(dataOutputStream, "Feedback");
                        C5767b.m26478a(str7);
                        return false;
                    } catch (Throwable th2) {
                        dataOutputStream2 = dataOutputStream;
                        inputStream2 = inputStream;
                        str8 = str7;
                        th = th2;
                        C5767b.m26475a(inputStream2, "Feedback");
                        C5767b.m26472a(dataOutputStream2, "Feedback");
                        C5767b.m26478a(str8);
                        throw th;
                    }
                } catch (Throwable th22) {
                    inputStream2 = inputStream3;
                    th = th22;
                    C5767b.m26475a(inputStream2, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                    C5767b.m26478a(str8);
                    throw th;
                }
            } catch (IOException e2) {
                str7 = str8;
                inputStream = null;
                dataOutputStream = dataOutputStream2;
                com.huawei.phoneserviceuni.common.d.c.d("Feedback", "IOException ...");
                C4412b.m21239a(applicationcontext, c4409c, c4410d, handler);
                C5767b.m26475a(inputStream, "Feedback");
                C5767b.m26472a(dataOutputStream, "Feedback");
                C5767b.m26478a(str7);
                return false;
            } catch (Throwable th3) {
                th = th3;
                C5767b.m26475a(inputStream2, "Feedback");
                C5767b.m26472a(dataOutputStream2, "Feedback");
                C5767b.m26478a(str8);
                throw th;
            }
        } catch (IOException e3) {
            str7 = str8;
            inputStream = null;
            dataOutputStream = null;
            com.huawei.phoneserviceuni.common.d.c.d("Feedback", "IOException ...");
            C4412b.m21239a(applicationcontext, c4409c, c4410d, handler);
            C5767b.m26475a(inputStream, "Feedback");
            C5767b.m26472a(dataOutputStream, "Feedback");
            C5767b.m26478a(str7);
            return false;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream2 = null;
            C5767b.m26475a(inputStream2, "Feedback");
            C5767b.m26472a(dataOutputStream2, "Feedback");
            C5767b.m26478a(str8);
            throw th;
        }
    }

    private static void m21243a(C4425p c4425p, C4409c c4409c, C4410d c4410d, String str, String str2, Context context, String str3, Handler handler) {
        if (f.a() != null && f.a().size() < 500) {
            if (!(c4425p.m21273b() == null || c4409c.m21175g() == null)) {
                c4410d.m21211h(c4425p.m21273b());
                c4410d.m21217k(c4409c.m21175g());
                c4410d.m21215j(new SimpleDateFormat("yyyy/M/d HH:mm", Locale.US).format(new Date()));
                c4410d.m21221m(c4410d.m21218l());
                c4410d.m21196c(1);
                c4410d.m21219l(str);
                c4410d.m21223n(str2);
                c4410d.m21225o(String.valueOf(c4409c.m21183k()));
                c4410d.m21209g(c4409c.m21185m());
                if (!TextUtils.isEmpty(c4409c.m21184l())) {
                    c4410d.m21213i(c4409c.m21184l());
                }
                if ("1".equals(str3)) {
                    c4410d.m21193b(5);
                } else {
                    c4410d.m21193b(3);
                }
                f.c(c4410d);
                C2852a.m12942a(context).m12947a(new Intent("UpdateRecordListBroadcast"));
            }
            if (b.a()) {
                C4412b.m21240a(handler, 1);
            } else if (c4410d.m21214j() == 5) {
                C4416g.m21257a(context, 1, null);
            } else {
                C4416g.m21257a(context, 6, null);
            }
        }
    }

    private static void m21239a(Context context, C4409c c4409c, C4410d c4410d, Handler handler) {
        C4412b.m21240a(handler, 2);
    }

    public static void m21242a(C4410d c4410d, String str) {
        DataOutputStream dataOutputStream;
        Throwable th;
        Throwable th2;
        InputStream inputStream = null;
        Context applicationContext = FeedbackApi.getApplicationcontext().getApplicationContext();
        C5759a.m26446a();
        DataOutputStream dataOutputStream2;
        InputStream inputStream2;
        try {
            System.setProperty("http.keepAlive", "false");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://iservice.vmall.com:443/osg/feedbackAction!addQuestion.htm").openConnection();
            httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty("Connection", "keep-alive");
            httpsURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------40612316912668");
            httpsURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
            httpsURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
            httpsURLConnection.connect();
            dataOutputStream2 = new DataOutputStream(httpsURLConnection.getOutputStream());
            try {
                C4426q.m21279b("deviceType", Build.MODEL, dataOutputStream2);
                C4426q.m21279b("sysVersion", Build.DISPLAY, dataOutputStream2);
                if (TextUtils.isEmpty(a.a().f())) {
                    a.a().e();
                }
                String f = a.a().f();
                if (TextUtils.isEmpty(f)) {
                    f = "000000000000000";
                }
                C4426q.m21279b("deviceID", f, dataOutputStream2);
                C4426q.m21279b("deviceToken", a.a().c(), dataOutputStream2);
                C4426q.m21279b("question", c4410d.m21226p(), dataOutputStream2);
                if (TextUtils.isEmpty(c4410d.m21234w())) {
                    C4426q.m21279b("questionType", applicationContext.getResources().getString(d.b(FeedbackApi.getApplicationcontext(), "feedback_cloud_service")), dataOutputStream2);
                } else {
                    C4426q.m21279b("questionType", c4410d.m21234w(), dataOutputStream2);
                }
                C4426q.m21275a(str, c4410d.m21232u(), dataOutputStream2);
                C4426q.m21279b("versionID", "2.0", dataOutputStream2);
                C4426q.m21279b("pQuestionId", c4410d.m21229r(), dataOutputStream2);
                C4426q.m21279b(AppOpenOrDownHelper.APP_ID_PARAM, TextUtils.isEmpty(c4410d.m21233v()) ? "1" : c4410d.m21233v(), dataOutputStream2);
                C4426q.m21274a(dataOutputStream2);
                dataOutputStream2.flush();
                inputStream2 = httpsURLConnection.getInputStream();
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        stringBuffer.append(new String(bArr, 0, read, "utf-8"));
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    C5767b.m26475a(inputStream2, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                    C4425p c4425p = new C4425p();
                    ContentValues contentValues;
                    if (c4425p.m21272a(stringBuffer2) == 0 && c4425p.m21271a() == 0) {
                        if (!(c4425p.m21273b() == null || c4410d.m21226p() == null)) {
                            c4410d.m21211h(c4425p.m21273b());
                            c4410d.m21196c(1);
                            f.a(c4410d);
                        }
                        C2852a.m12942a(applicationContext).m12947a(new Intent("UpdateRecordListBroadcast"));
                        contentValues = new ContentValues();
                        contentValues.put("pQuestionId", c4410d.m21229r());
                        C4416g.m21257a(applicationContext, 5, contentValues);
                        return;
                    }
                    c4410d.m21196c(3);
                    f.a(c4410d);
                    contentValues = new ContentValues();
                    contentValues.put("pQuestionId", c4410d.m21229r());
                    C4416g.m21257a(applicationContext, 4, contentValues);
                    C2852a.m12942a(applicationContext).m12947a(new Intent("UpdateRecordListBroadcast"));
                } catch (IOException e) {
                    dataOutputStream = dataOutputStream2;
                } catch (Exception e2) {
                    inputStream = inputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    th2 = th;
                }
            } catch (IOException e3) {
                inputStream2 = null;
                dataOutputStream = dataOutputStream2;
                try {
                    com.huawei.phoneserviceuni.common.d.c.d("Feedback", "appendFeedback io error");
                    C4412b.m21241a(c4410d, applicationContext);
                    C5767b.m26475a(inputStream2, "Feedback");
                    C5767b.m26472a(dataOutputStream, "Feedback");
                } catch (Throwable th4) {
                    th = th4;
                    dataOutputStream2 = dataOutputStream;
                    inputStream = inputStream2;
                    th2 = th;
                    C5767b.m26475a(inputStream, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                    throw th2;
                }
            } catch (Exception e4) {
                try {
                    com.huawei.phoneserviceuni.common.d.c.d("Feedback", "appendFeedback Exception");
                    C4412b.m21241a(c4410d, applicationContext);
                    C5767b.m26475a(inputStream, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                } catch (Throwable th5) {
                    th2 = th5;
                    C5767b.m26475a(inputStream, "Feedback");
                    C5767b.m26472a(dataOutputStream2, "Feedback");
                    throw th2;
                }
            }
        } catch (IOException e5) {
            inputStream2 = null;
            com.huawei.phoneserviceuni.common.d.c.d("Feedback", "appendFeedback io error");
            C4412b.m21241a(c4410d, applicationContext);
            C5767b.m26475a(inputStream2, "Feedback");
            C5767b.m26472a(dataOutputStream, "Feedback");
        } catch (Exception e6) {
            dataOutputStream2 = null;
            com.huawei.phoneserviceuni.common.d.c.d("Feedback", "appendFeedback Exception");
            C4412b.m21241a(c4410d, applicationContext);
            C5767b.m26475a(inputStream, "Feedback");
            C5767b.m26472a(dataOutputStream2, "Feedback");
        } catch (Throwable th6) {
            th2 = th6;
            dataOutputStream2 = null;
            C5767b.m26475a(inputStream, "Feedback");
            C5767b.m26472a(dataOutputStream2, "Feedback");
            throw th2;
        }
    }

    public static void m21240a(Handler handler, int i) {
        Message message = new Message();
        message.what = i;
        handler.sendMessage(message);
    }

    private static void m21241a(C4410d c4410d, Context context) {
        c4410d.m21196c(3);
        f.a(c4410d);
        ContentValues contentValues = new ContentValues();
        contentValues.put("pQuestionId", c4410d.m21229r());
        C4416g.m21257a(context, 4, contentValues);
        C2852a.m12942a(context).m12947a(new Intent("UpdateRecordListBroadcast"));
    }
}
