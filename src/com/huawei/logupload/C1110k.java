package com.huawei.logupload;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.logupload.a.b;
import com.huawei.logupload.c.a.a;
import com.huawei.logupload.p088a.C1097a;
import com.huawei.logupload.p088a.C1098c;
import com.huawei.logupload.p090c.C1101b;
import com.huawei.logupload.p090c.C1102c;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.logupload.p090c.C1105h;
import com.huawei.logupload.p090c.C1105h.C1104a;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

/* compiled from: UploadRequest */
public final class C1110k {
    private static List<LogUpload> f2291a = new ArrayList(100);
    private static final C1098c f2292b = new C1098c(C1101b.m4858a().m4860b().getBaseContext());

    public static void m4922a(LogUpload logUpload) {
        InputStream inputStream;
        int read;
        String stringBuffer;
        RuntimeException e;
        ConnectTimeoutException e2;
        Exception e3;
        o oVar;
        C1104a c1104a;
        Message obtainMessage;
        Bundle bundle;
        Timer timer;
        Intent intent;
        Throwable th;
        InputStream inputStream2 = null;
        logUpload.m4778c(0);
        logUpload.m4790e(false);
        C1103f.m4878b("LogUpload Service", "logUploadRequest start =================-!!-");
        GZIPOutputStream gZIPOutputStream;
        try {
            System.setProperty("http.keepAlive", "false");
            URL url = new URL("https://logservice.vmall.com:443/osg/logServerAction!addLogServer.htm");
            C1105h.m4905c();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty("Connection", "close");
            httpsURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpsURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------40612316912668");
            httpsURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
            httpsURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
            httpsURLConnection.connect();
            gZIPOutputStream = new GZIPOutputStream(httpsURLConnection.getOutputStream());
            try {
                if (TextUtils.isEmpty(logUpload.m4766a())) {
                    i.a("deviceType", Build.MODEL, gZIPOutputStream);
                    C1103f.m4878b("LogUpload Service", "设备型号" + Build.MODEL);
                } else {
                    i.a("deviceType", logUpload.m4766a(), gZIPOutputStream);
                    C1103f.m4878b("LogUpload Service", "设备型号" + logUpload.m4766a());
                }
                if (TextUtils.isEmpty(logUpload.m4772b())) {
                    i.a("sysVersion", Build.DISPLAY, gZIPOutputStream);
                    C1103f.m4878b("LogUpload Service", "系统版本号" + Build.DISPLAY);
                } else {
                    i.a("sysVersion", logUpload.m4772b(), gZIPOutputStream);
                    C1103f.m4878b("LogUpload Service", "系统版本号" + logUpload.m4772b());
                }
                String a = C1105h.m4886a(C1101b.m4858a().m4860b().getBaseContext());
                if (TextUtils.isEmpty(a)) {
                    a = "000000000000000";
                }
                i.a("deviceID", a, gZIPOutputStream);
                i.a(UploadFile.SYS_ID_CHANNEL, String.valueOf(logUpload.m4758A()), gZIPOutputStream);
                C1103f.m4878b("LogUpload Service", String.valueOf(logUpload.m4758A()));
                i.a("os", VERSION.RELEASE, gZIPOutputStream);
                C1103f.m4878b("LogUpload Service", "操作版本" + VERSION.RELEASE);
                a = C1105h.m4900b(C1101b.m4858a().m4860b().getBaseContext());
                if (a != null && a.equals("")) {
                    C1103f.m4878b("LogUpload Service", "imsi为空");
                }
                if (!(a == null || a.equals("") || a.length() <= 4)) {
                    i.a(UploadFile.DEVICE_IMSI_LABEL, a.substring(0, 5), gZIPOutputStream);
                }
                if (logUpload.m4805k()) {
                    i.a(UploadFile.ENCRTPT_TYPE, "1", gZIPOutputStream);
                } else {
                    i.a(UploadFile.ENCRTPT_TYPE, "0", gZIPOutputStream);
                }
                i.a(UploadFile.SENSITIVE_CONTAIN, Boolean.toString(logUpload.m4817q()), gZIPOutputStream);
                a = logUpload.m4798h();
                if (!(a == null || a.equals(""))) {
                    i.a(UploadFile.FILE_NAME, a.substring(a.lastIndexOf("/") + 1), gZIPOutputStream);
                    C1103f.m4878b("LogUpload Service", new StringBuilder(UploadFile.FILE_NAME).append(a.substring(a.lastIndexOf("/") + 1)).toString());
                }
                i.a(UploadFile.SIZE_LABEL, Long.toString(logUpload.m4802j()), gZIPOutputStream);
                i.a("version", "4", gZIPOutputStream);
                C1103f.m4880d("LogUpload Service", "mLogUploadInfo.getUserType():" + logUpload.m4763F());
                if (logUpload.m4763F() == 4) {
                    i.a(UploadFile.USER_TYPE, Integer.toString(1), gZIPOutputStream);
                } else {
                    i.a(UploadFile.USER_TYPE, Integer.toString(logUpload.m4763F()), gZIPOutputStream);
                }
                i.a(UploadFile.ZIP_TIME, logUpload.m4782d(), gZIPOutputStream);
                C1103f.m4880d("LogUpload Service", "mLogUploadInfo.getZipTime():" + logUpload.m4782d());
                i.a(UploadFile.LOG_DETAIL_INFO, logUpload.m4787e(), gZIPOutputStream);
                C1103f.m4880d("LogUpload Service", "mLogUploadInfo.getLogDetailInfo():" + logUpload.m4787e());
                if (logUpload.m4821u() == 1 || logUpload.m4821u() == 2) {
                    if (logUpload.m4823w()) {
                        i.a(UploadFile.REFRESH_LABEL, Boolean.toString(true), gZIPOutputStream);
                        logUpload.m4786d(false);
                    }
                    C1103f.m4878b("LogUpload Service", "带有refresh");
                }
                if (C1105h.m4915h() != null) {
                    i.a("sign", C1105h.m4915h(), gZIPOutputStream);
                }
                if (!TextUtils.isEmpty(logUpload.m4812o())) {
                    i.a(UploadFile.ENCRYTKEY, a.b(logUpload.m4812o()), gZIPOutputStream);
                }
                C1103f.m4878b("LogUpload Service", "UploadFile.addEndField(dos)");
                i.a(gZIPOutputStream);
                C1103f.m4878b("LogUpload Service", "dos.flush()");
                gZIPOutputStream.flush();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e4) {
                        C1103f.m4880d("LogUpload Service", "dos close is failed ");
                    }
                }
                C1103f.m4878b("LogUpload Service", "urlConnection.getInputStream()");
                inputStream = httpsURLConnection.getInputStream();
                try {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        read = inputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        stringBuffer2.append(new String(bArr, 0, read, "utf-8"));
                    }
                    C1103f.m4878b("LogUpload Service", "读取完毕");
                    stringBuffer = stringBuffer2.toString();
                    C1105h.m4891a(inputStream, "LogUpload Service");
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e5) {
                            C1103f.m4880d("LogUpload Service", "dos close is failed ");
                        }
                    }
                } catch (RuntimeException e6) {
                    e = e6;
                } catch (ConnectTimeoutException e7) {
                    e2 = e7;
                } catch (Exception e8) {
                    e3 = e8;
                }
            } catch (RuntimeException e9) {
                e = e9;
                inputStream = null;
                try {
                    C1103f.m4878b("LogUpload Service", "logUploadRequest RuntimeException");
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    e.printStackTrace();
                    C1105h.m4891a(inputStream, "LogUpload Service");
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                            stringBuffer = null;
                        } catch (IOException e10) {
                            C1103f.m4880d("LogUpload Service", "dos close is failed ");
                            stringBuffer = null;
                        }
                        C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                        oVar = new o();
                        if (oVar.a(stringBuffer) != 0) {
                        }
                        if (1 == oVar.a()) {
                            C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                            C1110k.m4923a(logUpload, false);
                            if (logUpload.m4759B()) {
                                if (logUpload.m4763F() == 1) {
                                    C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                                } else if (logUpload.m4763F() == 2) {
                                    C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                                } else if (logUpload.m4763F() == 3) {
                                    C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                                } else if (logUpload.m4763F() == 4) {
                                    C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                                }
                                if (!C1110k.m4924a()) {
                                    c1104a = new C1104a(Looper.getMainLooper());
                                    obtainMessage = c1104a.obtainMessage(0);
                                    bundle = new Bundle();
                                    bundle.putString("packagename", logUpload.m4760C());
                                    obtainMessage.setData(bundle);
                                    c1104a.sendMessage(obtainMessage);
                                }
                            }
                        } else if (2 == oVar.a()) {
                            C1103f.m4878b("LogUpload Service", "返回值结果为2");
                            timer = new Timer();
                            logUpload.m4790e(true);
                            timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                        } else if (1002 == oVar.a()) {
                            C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                            intent = new Intent();
                            intent.setAction("com.example.logupload.progress");
                            intent.setPackage(logUpload.m4760C());
                            logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                            if (C1102c.m4875i() != 1) {
                                intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                                intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                                intent.putExtra("isuploadsuccess", false);
                                C1101b.m4858a().m4860b().startService(intent);
                            } else {
                                intent.putExtra("mLogUploadInfo", logUpload);
                                C1101b.m4858a().m4860b().sendBroadcast(intent);
                            }
                            C1110k.m4923a(logUpload, true);
                            if (!C1110k.m4924a()) {
                                c1104a = new C1104a(Looper.getMainLooper());
                                obtainMessage = c1104a.obtainMessage(0);
                                bundle = new Bundle();
                                bundle.putString("packagename", logUpload.m4760C());
                                obtainMessage.setData(bundle);
                                c1104a.sendMessage(obtainMessage);
                            }
                        } else if (302004 == oVar.a()) {
                            C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                            if (C1102c.m4875i() != 1) {
                                intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                                intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                                intent.putExtra("isuploadsuccess", false);
                                C1101b.m4858a().m4860b().startService(intent);
                            } else {
                                intent = new Intent();
                                intent.setAction("com.example.logupload.progress");
                                intent.setPackage(logUpload.m4760C());
                                intent.putExtra(JoinConstants.EXCEPTION, "2");
                                C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                                intent.putExtra("mLogUploadInfo", logUpload);
                                C1101b.m4858a().m4860b().sendBroadcast(intent);
                            }
                            if (logUpload.m4759B()) {
                            }
                            return;
                        } else {
                            C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                            stringBuffer = oVar.b();
                            logUpload.m4796g(stringBuffer);
                            C1110k.m4923a(logUpload, true);
                            if (logUpload.m4759B()) {
                            }
                            return;
                        }
                    }
                    stringBuffer = null;
                    C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                    oVar = new o();
                    if (oVar.a(stringBuffer) != 0) {
                    }
                    if (1 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                        C1110k.m4923a(logUpload, false);
                        if (logUpload.m4759B()) {
                            if (logUpload.m4763F() == 1) {
                                C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                            } else if (logUpload.m4763F() == 2) {
                                C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                            } else if (logUpload.m4763F() == 3) {
                                C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                            } else if (logUpload.m4763F() == 4) {
                                C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                            }
                            if (!C1110k.m4924a()) {
                                c1104a = new C1104a(Looper.getMainLooper());
                                obtainMessage = c1104a.obtainMessage(0);
                                bundle = new Bundle();
                                bundle.putString("packagename", logUpload.m4760C());
                                obtainMessage.setData(bundle);
                                c1104a.sendMessage(obtainMessage);
                            }
                        }
                    } else if (2 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "返回值结果为2");
                        timer = new Timer();
                        logUpload.m4790e(true);
                        timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                    } else if (1002 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                        if (C1102c.m4875i() != 1) {
                            intent.putExtra("mLogUploadInfo", logUpload);
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        } else {
                            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                            intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                            intent.putExtra("isuploadsuccess", false);
                            C1101b.m4858a().m4860b().startService(intent);
                        }
                        C1110k.m4923a(logUpload, true);
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    } else if (302004 == oVar.a()) {
                        C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                        stringBuffer = oVar.b();
                        logUpload.m4796g(stringBuffer);
                        C1110k.m4923a(logUpload, true);
                        if (logUpload.m4759B()) {
                            return;
                        }
                    } else {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        if (C1102c.m4875i() != 1) {
                            intent = new Intent();
                            intent.setAction("com.example.logupload.progress");
                            intent.setPackage(logUpload.m4760C());
                            intent.putExtra(JoinConstants.EXCEPTION, "2");
                            C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                            intent.putExtra("mLogUploadInfo", logUpload);
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        } else {
                            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                            intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                            intent.putExtra("isuploadsuccess", false);
                            C1101b.m4858a().m4860b().startService(intent);
                        }
                        if (logUpload.m4759B()) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    C1105h.m4891a(inputStream2, "LogUpload Service");
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e11) {
                            C1103f.m4880d("LogUpload Service", "dos close is failed ");
                        }
                    }
                    throw th;
                }
            } catch (ConnectTimeoutException e12) {
                e2 = e12;
                inputStream = null;
                C1103f.m4878b("LogUpload Service", "logUploadRequest 日志分发服务器请求超时" + e2.getMessage());
                if (logUpload.m4825y() < 8) {
                    C1110k.m4927c(logUpload);
                }
                C1105h.m4891a(inputStream, "LogUpload Service");
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                        stringBuffer = null;
                    } catch (IOException e13) {
                        C1103f.m4880d("LogUpload Service", "dos close is failed ");
                        stringBuffer = null;
                    }
                    C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                    oVar = new o();
                    if (oVar.a(stringBuffer) != 0) {
                    }
                    if (1 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                        C1110k.m4923a(logUpload, false);
                        if (logUpload.m4759B()) {
                            if (logUpload.m4763F() == 1) {
                                C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                            } else if (logUpload.m4763F() == 2) {
                                C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                            } else if (logUpload.m4763F() == 3) {
                                C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                            } else if (logUpload.m4763F() == 4) {
                                C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                            }
                            if (!C1110k.m4924a()) {
                                c1104a = new C1104a(Looper.getMainLooper());
                                obtainMessage = c1104a.obtainMessage(0);
                                bundle = new Bundle();
                                bundle.putString("packagename", logUpload.m4760C());
                                obtainMessage.setData(bundle);
                                c1104a.sendMessage(obtainMessage);
                            }
                        }
                    } else if (2 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "返回值结果为2");
                        timer = new Timer();
                        logUpload.m4790e(true);
                        timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                    } else if (1002 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                        if (C1102c.m4875i() != 1) {
                            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                            intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                            intent.putExtra("isuploadsuccess", false);
                            C1101b.m4858a().m4860b().startService(intent);
                        } else {
                            intent.putExtra("mLogUploadInfo", logUpload);
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        }
                        C1110k.m4923a(logUpload, true);
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    } else if (302004 == oVar.a()) {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        if (C1102c.m4875i() != 1) {
                            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                            intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                            intent.putExtra("isuploadsuccess", false);
                            C1101b.m4858a().m4860b().startService(intent);
                        } else {
                            intent = new Intent();
                            intent.setAction("com.example.logupload.progress");
                            intent.setPackage(logUpload.m4760C());
                            intent.putExtra(JoinConstants.EXCEPTION, "2");
                            C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                            intent.putExtra("mLogUploadInfo", logUpload);
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        }
                        if (logUpload.m4759B()) {
                        }
                        return;
                    } else {
                        C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                        stringBuffer = oVar.b();
                        logUpload.m4796g(stringBuffer);
                        C1110k.m4923a(logUpload, true);
                        if (logUpload.m4759B()) {
                        }
                        return;
                    }
                }
                stringBuffer = null;
                C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                oVar = new o();
                if (oVar.a(stringBuffer) != 0) {
                }
                if (1 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                    C1110k.m4923a(logUpload, false);
                    if (logUpload.m4759B()) {
                        if (logUpload.m4763F() == 1) {
                            C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                        } else if (logUpload.m4763F() == 2) {
                            C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                        } else if (logUpload.m4763F() == 3) {
                            C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                        } else if (logUpload.m4763F() == 4) {
                            C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                        }
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    }
                } else if (2 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为2");
                    timer = new Timer();
                    logUpload.m4790e(true);
                    timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                    if (C1102c.m4875i() != 1) {
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    } else {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    }
                    C1110k.m4923a(logUpload, true);
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                } else if (302004 == oVar.a()) {
                    C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                    stringBuffer = oVar.b();
                    logUpload.m4796g(stringBuffer);
                    C1110k.m4923a(logUpload, true);
                    if (logUpload.m4759B()) {
                        return;
                    }
                } else {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        intent.putExtra(JoinConstants.EXCEPTION, "2");
                        C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    } else {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    }
                    if (logUpload.m4759B()) {
                        return;
                    }
                }
            } catch (Exception e14) {
                e3 = e14;
                inputStream = null;
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                C1103f.m4878b("LogUpload Service", "logUploadRequest Exception" + e3.getMessage());
                C1105h.m4891a(inputStream, "LogUpload Service");
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                        stringBuffer = null;
                    } catch (IOException e15) {
                        C1103f.m4880d("LogUpload Service", "dos close is failed ");
                        stringBuffer = null;
                    }
                    C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                    oVar = new o();
                    if (oVar.a(stringBuffer) != 0) {
                    }
                    if (1 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                        C1110k.m4923a(logUpload, false);
                        if (logUpload.m4759B()) {
                            if (logUpload.m4763F() == 1) {
                                C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                            } else if (logUpload.m4763F() == 2) {
                                C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                            } else if (logUpload.m4763F() == 3) {
                                C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                            } else if (logUpload.m4763F() == 4) {
                                C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                            }
                            if (!C1110k.m4924a()) {
                                c1104a = new C1104a(Looper.getMainLooper());
                                obtainMessage = c1104a.obtainMessage(0);
                                bundle = new Bundle();
                                bundle.putString("packagename", logUpload.m4760C());
                                obtainMessage.setData(bundle);
                                c1104a.sendMessage(obtainMessage);
                            }
                        }
                    } else if (2 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "返回值结果为2");
                        timer = new Timer();
                        logUpload.m4790e(true);
                        timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                    } else if (1002 == oVar.a()) {
                        C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                        if (C1102c.m4875i() != 1) {
                            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                            intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                            intent.putExtra("isuploadsuccess", false);
                            C1101b.m4858a().m4860b().startService(intent);
                        } else {
                            intent.putExtra("mLogUploadInfo", logUpload);
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        }
                        C1110k.m4923a(logUpload, true);
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    } else if (302004 == oVar.a()) {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        if (C1102c.m4875i() != 1) {
                            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                            intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                            intent.putExtra("isuploadsuccess", false);
                            C1101b.m4858a().m4860b().startService(intent);
                        } else {
                            intent = new Intent();
                            intent.setAction("com.example.logupload.progress");
                            intent.setPackage(logUpload.m4760C());
                            intent.putExtra(JoinConstants.EXCEPTION, "2");
                            C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                            intent.putExtra("mLogUploadInfo", logUpload);
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        }
                        if (logUpload.m4759B()) {
                        }
                        return;
                    } else {
                        C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                        stringBuffer = oVar.b();
                        logUpload.m4796g(stringBuffer);
                        C1110k.m4923a(logUpload, true);
                        if (logUpload.m4759B()) {
                        }
                        return;
                    }
                }
                stringBuffer = null;
                C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                oVar = new o();
                if (oVar.a(stringBuffer) != 0) {
                }
                if (1 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                    C1110k.m4923a(logUpload, false);
                    if (logUpload.m4759B()) {
                        if (logUpload.m4763F() == 1) {
                            C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                        } else if (logUpload.m4763F() == 2) {
                            C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                        } else if (logUpload.m4763F() == 3) {
                            C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                        } else if (logUpload.m4763F() == 4) {
                            C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                        }
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    }
                } else if (2 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为2");
                    timer = new Timer();
                    logUpload.m4790e(true);
                    timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                    if (C1102c.m4875i() != 1) {
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    } else {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    }
                    C1110k.m4923a(logUpload, true);
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                } else if (302004 == oVar.a()) {
                    C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                    stringBuffer = oVar.b();
                    logUpload.m4796g(stringBuffer);
                    C1110k.m4923a(logUpload, true);
                    if (logUpload.m4759B()) {
                        return;
                    }
                } else {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        intent.putExtra(JoinConstants.EXCEPTION, "2");
                        C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    } else {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    }
                    if (logUpload.m4759B()) {
                        return;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                C1105h.m4891a(inputStream2, "LogUpload Service");
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                throw th;
            }
        } catch (RuntimeException e16) {
            e = e16;
            inputStream = null;
            gZIPOutputStream = null;
            C1103f.m4878b("LogUpload Service", "logUploadRequest RuntimeException");
            C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
            e.printStackTrace();
            C1105h.m4891a(inputStream, "LogUpload Service");
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
                stringBuffer = null;
                C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                oVar = new o();
                if (oVar.a(stringBuffer) != 0) {
                }
                if (1 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                    C1110k.m4923a(logUpload, false);
                    if (logUpload.m4759B()) {
                        if (logUpload.m4763F() == 1) {
                            C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                        } else if (logUpload.m4763F() == 2) {
                            C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                        } else if (logUpload.m4763F() == 3) {
                            C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                        } else if (logUpload.m4763F() == 4) {
                            C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                        }
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    }
                } else if (2 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为2");
                    timer = new Timer();
                    logUpload.m4790e(true);
                    timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    } else {
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    }
                    C1110k.m4923a(logUpload, true);
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                } else if (302004 == oVar.a()) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    } else {
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        intent.putExtra(JoinConstants.EXCEPTION, "2");
                        C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    }
                    if (logUpload.m4759B()) {
                    }
                    return;
                } else {
                    C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                    stringBuffer = oVar.b();
                    logUpload.m4796g(stringBuffer);
                    C1110k.m4923a(logUpload, true);
                    if (logUpload.m4759B()) {
                    }
                    return;
                }
            }
            stringBuffer = null;
            C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
            oVar = new o();
            if (oVar.a(stringBuffer) != 0) {
            }
            if (1 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                C1110k.m4923a(logUpload, false);
                if (logUpload.m4759B()) {
                    if (logUpload.m4763F() == 1) {
                        C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                    } else if (logUpload.m4763F() == 2) {
                        C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                    } else if (logUpload.m4763F() == 3) {
                        C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                    } else if (logUpload.m4763F() == 4) {
                        C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                    }
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                }
            } else if (2 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "返回值结果为2");
                timer = new Timer();
                logUpload.m4790e(true);
                timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            } else if (1002 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                intent = new Intent();
                intent.setAction("com.example.logupload.progress");
                intent.setPackage(logUpload.m4760C());
                logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                if (C1102c.m4875i() != 1) {
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    C1101b.m4858a().m4860b().startService(intent);
                }
                C1110k.m4923a(logUpload, true);
                if (!C1110k.m4924a()) {
                    c1104a = new C1104a(Looper.getMainLooper());
                    obtainMessage = c1104a.obtainMessage(0);
                    bundle = new Bundle();
                    bundle.putString("packagename", logUpload.m4760C());
                    obtainMessage.setData(bundle);
                    c1104a.sendMessage(obtainMessage);
                }
            } else if (302004 == oVar.a()) {
                C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                stringBuffer = oVar.b();
                logUpload.m4796g(stringBuffer);
                C1110k.m4923a(logUpload, true);
                if (logUpload.m4759B()) {
                    return;
                }
            } else {
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                if (C1102c.m4875i() != 1) {
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    C1101b.m4858a().m4860b().startService(intent);
                }
                if (logUpload.m4759B()) {
                    return;
                }
            }
        } catch (ConnectTimeoutException e17) {
            e2 = e17;
            inputStream = null;
            gZIPOutputStream = null;
            C1103f.m4878b("LogUpload Service", "logUploadRequest 日志分发服务器请求超时" + e2.getMessage());
            if (logUpload.m4825y() < 8) {
                C1110k.m4927c(logUpload);
            }
            C1105h.m4891a(inputStream, "LogUpload Service");
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
                stringBuffer = null;
                C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                oVar = new o();
                if (oVar.a(stringBuffer) != 0) {
                }
                if (1 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                    C1110k.m4923a(logUpload, false);
                    if (logUpload.m4759B()) {
                        if (logUpload.m4763F() == 1) {
                            C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                        } else if (logUpload.m4763F() == 2) {
                            C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                        } else if (logUpload.m4763F() == 3) {
                            C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                        } else if (logUpload.m4763F() == 4) {
                            C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                        }
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    }
                } else if (2 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为2");
                    timer = new Timer();
                    logUpload.m4790e(true);
                    timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    } else {
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    }
                    C1110k.m4923a(logUpload, true);
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                } else if (302004 == oVar.a()) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    } else {
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        intent.putExtra(JoinConstants.EXCEPTION, "2");
                        C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    }
                    if (logUpload.m4759B()) {
                    }
                    return;
                } else {
                    C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                    stringBuffer = oVar.b();
                    logUpload.m4796g(stringBuffer);
                    C1110k.m4923a(logUpload, true);
                    if (logUpload.m4759B()) {
                    }
                    return;
                }
            }
            stringBuffer = null;
            C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
            oVar = new o();
            if (oVar.a(stringBuffer) != 0) {
            }
            if (1 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                C1110k.m4923a(logUpload, false);
                if (logUpload.m4759B()) {
                    if (logUpload.m4763F() == 1) {
                        C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                    } else if (logUpload.m4763F() == 2) {
                        C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                    } else if (logUpload.m4763F() == 3) {
                        C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                    } else if (logUpload.m4763F() == 4) {
                        C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                    }
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                }
            } else if (2 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "返回值结果为2");
                timer = new Timer();
                logUpload.m4790e(true);
                timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            } else if (1002 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                intent = new Intent();
                intent.setAction("com.example.logupload.progress");
                intent.setPackage(logUpload.m4760C());
                logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                if (C1102c.m4875i() != 1) {
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    C1101b.m4858a().m4860b().startService(intent);
                }
                C1110k.m4923a(logUpload, true);
                if (!C1110k.m4924a()) {
                    c1104a = new C1104a(Looper.getMainLooper());
                    obtainMessage = c1104a.obtainMessage(0);
                    bundle = new Bundle();
                    bundle.putString("packagename", logUpload.m4760C());
                    obtainMessage.setData(bundle);
                    c1104a.sendMessage(obtainMessage);
                }
            } else if (302004 == oVar.a()) {
                C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                stringBuffer = oVar.b();
                logUpload.m4796g(stringBuffer);
                C1110k.m4923a(logUpload, true);
                if (logUpload.m4759B()) {
                    return;
                }
            } else {
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                if (C1102c.m4875i() != 1) {
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    C1101b.m4858a().m4860b().startService(intent);
                }
                if (logUpload.m4759B()) {
                    return;
                }
            }
        } catch (Exception e18) {
            e3 = e18;
            inputStream = null;
            gZIPOutputStream = null;
            C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
            C1103f.m4878b("LogUpload Service", "logUploadRequest Exception" + e3.getMessage());
            C1105h.m4891a(inputStream, "LogUpload Service");
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
                stringBuffer = null;
                C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
                oVar = new o();
                if (oVar.a(stringBuffer) != 0) {
                }
                if (1 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                    C1110k.m4923a(logUpload, false);
                    if (logUpload.m4759B()) {
                        if (logUpload.m4763F() == 1) {
                            C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                        } else if (logUpload.m4763F() == 2) {
                            C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                        } else if (logUpload.m4763F() == 3) {
                            C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                        } else if (logUpload.m4763F() == 4) {
                            C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                        }
                        if (!C1110k.m4924a()) {
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", logUpload.m4760C());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    }
                } else if (2 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为2");
                    timer = new Timer();
                    logUpload.m4790e(true);
                    timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 == oVar.a()) {
                    C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    } else {
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    }
                    C1110k.m4923a(logUpload, true);
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                } else if (302004 == oVar.a()) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    if (C1102c.m4875i() != 1) {
                        intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                        intent.putExtra("isuploadsuccess", false);
                        C1101b.m4858a().m4860b().startService(intent);
                    } else {
                        intent = new Intent();
                        intent.setAction("com.example.logupload.progress");
                        intent.setPackage(logUpload.m4760C());
                        intent.putExtra(JoinConstants.EXCEPTION, "2");
                        C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        C1101b.m4858a().m4860b().sendBroadcast(intent);
                    }
                    if (logUpload.m4759B()) {
                    }
                    return;
                } else {
                    C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                    stringBuffer = oVar.b();
                    logUpload.m4796g(stringBuffer);
                    C1110k.m4923a(logUpload, true);
                    if (logUpload.m4759B()) {
                    }
                    return;
                }
            }
            stringBuffer = null;
            C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
            oVar = new o();
            if (oVar.a(stringBuffer) != 0) {
            }
            if (1 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
                C1110k.m4923a(logUpload, false);
                if (logUpload.m4759B()) {
                    if (logUpload.m4763F() == 1) {
                        C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                    } else if (logUpload.m4763F() == 2) {
                        C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                    } else if (logUpload.m4763F() == 3) {
                        C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                    } else if (logUpload.m4763F() == 4) {
                        C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                    }
                    if (!C1110k.m4924a()) {
                        c1104a = new C1104a(Looper.getMainLooper());
                        obtainMessage = c1104a.obtainMessage(0);
                        bundle = new Bundle();
                        bundle.putString("packagename", logUpload.m4760C());
                        obtainMessage.setData(bundle);
                        c1104a.sendMessage(obtainMessage);
                    }
                }
            } else if (2 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "返回值结果为2");
                timer = new Timer();
                logUpload.m4790e(true);
                timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            } else if (1002 == oVar.a()) {
                C1103f.m4878b("LogUpload Service", "返回值结果为1002");
                intent = new Intent();
                intent.setAction("com.example.logupload.progress");
                intent.setPackage(logUpload.m4760C());
                logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                if (C1102c.m4875i() != 1) {
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    C1101b.m4858a().m4860b().startService(intent);
                }
                C1110k.m4923a(logUpload, true);
                if (!C1110k.m4924a()) {
                    c1104a = new C1104a(Looper.getMainLooper());
                    obtainMessage = c1104a.obtainMessage(0);
                    bundle = new Bundle();
                    bundle.putString("packagename", logUpload.m4760C());
                    obtainMessage.setData(bundle);
                    c1104a.sendMessage(obtainMessage);
                }
            } else if (302004 == oVar.a()) {
                C1103f.m4880d("LogUpload Service", "Model is not supported upload");
                stringBuffer = oVar.b();
                logUpload.m4796g(stringBuffer);
                C1110k.m4923a(logUpload, true);
                if (logUpload.m4759B()) {
                    return;
                }
            } else {
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                if (C1102c.m4875i() != 1) {
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(logUpload.m4760C());
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    C1101b.m4858a().m4860b().startService(intent);
                }
                if (logUpload.m4759B()) {
                    return;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            C1105h.m4891a(inputStream2, "LogUpload Service");
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            throw th;
        }
        if (C1103f.m4877a(1) && stringBuffer != null) {
            C1103f.m4878b("LogUpload Service", "response: " + stringBuffer);
        }
        oVar = new o();
        if (oVar.a(stringBuffer) != 0 && oVar.a() == 0) {
            C1103f.m4878b("LogUpload Service", "日志分发服务器结果解析正确");
            if (C1102c.m4875i() == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                C1103f.m4879c("AppLogApi", "日志分setAutoCheckTime" + currentTimeMillis);
                b.a().a(currentTimeMillis);
            } else {
                C1103f.m4879c("AppLogApi", "setAutoCheckTime CommonConstants.getAutoUploadType()!=1");
            }
            String b = oVar.b();
            if (!(b == null || b.equals(""))) {
                if (b.contains("uploadperiod")) {
                    stringBuffer = "";
                    for (String str : b.split("\\|")) {
                        if (str.contains("uploadperiod")) {
                            String[] split = str.split("=");
                            if (split.length > 1) {
                                stringBuffer = split[split.length - 1];
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(stringBuffer)) {
                        C1103f.m4879c("AppLogApi", "period" + stringBuffer + "Integer" + Integer.parseInt(stringBuffer));
                        b.a().a(Integer.parseInt(stringBuffer));
                    }
                }
                if (b.contains("autoUploadInternalSwitch=false")) {
                    logUpload.m4796g(b);
                    C1103f.m4878b("LogUpload Service", "policy存在，将policy信息发送给服务器 =" + b);
                    C1110k.m4923a(logUpload, false);
                    return;
                }
            }
            stringBuffer = oVar.c();
            if (!(stringBuffer == null || stringBuffer.equals(""))) {
                logUpload.m4799h(stringBuffer);
            }
            File a2;
            if (TextUtils.isEmpty(logUpload.m4812o())) {
                stringBuffer = oVar.d();
                if (TextUtils.isEmpty(stringBuffer)) {
                    logUpload.m4801i(stringBuffer);
                } else {
                    Object a3 = a.a(stringBuffer);
                    if (TextUtils.isEmpty(a3)) {
                        logUpload.m4801i(stringBuffer);
                    } else {
                        logUpload.m4801i(a3);
                    }
                }
                if (!(stringBuffer == null || stringBuffer.equals("") || logUpload.m4824x() != null)) {
                    C1103f.m4878b("LogUpload Service", "对文件进行加密处理");
                    a2 = com.huawei.logupload.c.a.a(new File(logUpload.m4798h()), stringBuffer);
                    if (a2 != null) {
                        logUpload.m4813o(a2.toString());
                    }
                }
            } else {
                C1103f.m4878b("LogUpload Service", "--文件不加密-->>");
                a2 = new File(logUpload.m4798h());
                if (a2 != null) {
                    logUpload.m4813o(a2.toString());
                }
            }
            synchronized (C1102c.f2274a) {
                C1097a.m4847a(f2292b, logUpload, false);
            }
            stringBuffer = oVar.e();
            if (stringBuffer != null) {
                logUpload.m4803j(stringBuffer);
            }
            stringBuffer = oVar.g();
            if (stringBuffer != null) {
                logUpload.m4807l(stringBuffer);
            }
            stringBuffer = oVar.f();
            if (stringBuffer != null) {
                logUpload.m4804k(stringBuffer);
            }
            stringBuffer = oVar.h();
            if (stringBuffer != null) {
                logUpload.m4809m(stringBuffer);
            }
            synchronized (C1102c.f2274a) {
                C1097a.m4847a(f2292b, logUpload, false);
            }
            C1110k.m4926b(logUpload);
        } else if (1 == oVar.a()) {
            C1103f.m4878b("LogUpload Service", "日志分发服务器鉴权失败");
            C1110k.m4923a(logUpload, false);
            if (logUpload.m4759B()) {
                if (logUpload.m4763F() == 1) {
                    C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
                } else if (logUpload.m4763F() == 2) {
                    C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
                } else if (logUpload.m4763F() == 3) {
                    C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
                } else if (logUpload.m4763F() == 4) {
                    C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
                }
                if (!C1110k.m4924a()) {
                    c1104a = new C1104a(Looper.getMainLooper());
                    obtainMessage = c1104a.obtainMessage(0);
                    bundle = new Bundle();
                    bundle.putString("packagename", logUpload.m4760C());
                    obtainMessage.setData(bundle);
                    c1104a.sendMessage(obtainMessage);
                }
            }
        } else if (2 == oVar.a()) {
            C1103f.m4878b("LogUpload Service", "返回值结果为2");
            timer = new Timer();
            logUpload.m4790e(true);
            timer.schedule(new l(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        } else if (1002 == oVar.a()) {
            C1103f.m4878b("LogUpload Service", "返回值结果为1002");
            intent = new Intent();
            intent.setAction("com.example.logupload.progress");
            intent.setPackage(logUpload.m4760C());
            logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
            if (C1102c.m4875i() != 1) {
                intent.putExtra("mLogUploadInfo", logUpload);
                C1101b.m4858a().m4860b().sendBroadcast(intent);
            } else {
                intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                intent.putExtra("isuploadsuccess", false);
                C1101b.m4858a().m4860b().startService(intent);
            }
            C1110k.m4923a(logUpload, true);
            if (!C1110k.m4924a()) {
                c1104a = new C1104a(Looper.getMainLooper());
                obtainMessage = c1104a.obtainMessage(0);
                bundle = new Bundle();
                bundle.putString("packagename", logUpload.m4760C());
                obtainMessage.setData(bundle);
                c1104a.sendMessage(obtainMessage);
            }
        } else if (302004 == oVar.a()) {
            C1103f.m4880d("LogUpload Service", "Model is not supported upload");
            stringBuffer = oVar.b();
            if (!(stringBuffer == null || stringBuffer.equals(""))) {
                logUpload.m4796g(stringBuffer);
            }
            C1110k.m4923a(logUpload, true);
            if (logUpload.m4759B() && !C1110k.m4924a()) {
                c1104a = new C1104a(Looper.getMainLooper());
                obtainMessage = c1104a.obtainMessage(0);
                bundle = new Bundle();
                bundle.putString("packagename", logUpload.m4760C());
                obtainMessage.setData(bundle);
                c1104a.sendMessage(obtainMessage);
            }
        } else {
            C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
            if (C1102c.m4875i() != 1) {
                intent = new Intent();
                intent.setAction("com.example.logupload.progress");
                intent.setPackage(logUpload.m4760C());
                intent.putExtra(JoinConstants.EXCEPTION, "2");
                C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                intent.putExtra("mLogUploadInfo", logUpload);
                C1101b.m4858a().m4860b().sendBroadcast(intent);
            } else {
                intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                intent.putExtra("isuploadsuccess", false);
                C1101b.m4858a().m4860b().startService(intent);
            }
            if (logUpload.m4759B() && !C1110k.m4924a()) {
                c1104a = new C1104a(Looper.getMainLooper());
                obtainMessage = c1104a.obtainMessage(0);
                bundle = new Bundle();
                bundle.putString("packagename", logUpload.m4760C());
                obtainMessage.setData(bundle);
                c1104a.sendMessage(obtainMessage);
            }
        }
    }

    private static void m4927c(LogUpload logUpload) {
        C1103f.m4878b("LogUpload Service", "https 请求超时处理");
        logUpload.m4778c(logUpload.m4825y() + 1);
        C1110k.m4922a(logUpload);
    }

    public static void m4926b(LogUpload logUpload) {
        C1103f.m4880d("LogUpload Service", "mLogUploadInfo.getTimeReconnect()" + logUpload.m4764G());
        C1103f.m4880d("LogUpload Service", "mLogUploadInfo.getTimeReconnect()" + logUpload.m4765H());
        logUpload.m4778c(0);
        logUpload.m4790e(false);
        C1103f.m4878b("LogUpload Service", "prepareUpload");
        if (logUpload.m4802j() < 1024000) {
            logUpload.m4773b(0);
            C1103f.m4878b("LogUpload Service", "prepareUpload 小文件上传");
            synchronized (C1102c.f2274a) {
                C1097a.m4847a(f2292b, logUpload, false);
            }
            C1110k.m4925b(C1110k.m4928d(logUpload), logUpload);
        } else {
            C1103f.m4878b("LogUpload Service", "prepareUpload 大文件上传");
            C1103f.m4878b("LogUpload Service", "此时type值为" + logUpload.m4821u());
            logUpload.m4773b(2);
            C1103f.m4878b("LogUpload Service", "mLogUploadInfo.setType(2)");
            synchronized (C1102c.f2274a) {
                C1097a.m4847a(f2292b, logUpload, false);
            }
            int d = C1110k.m4928d(logUpload);
            C1103f.m4878b("LogUpload Service", "result = " + d);
            C1110k.m4921a(d, logUpload);
        }
        Object v = logUpload.m4822v();
        long j = logUpload.m4802j();
        boolean z;
        if (TextUtils.isEmpty(v)) {
            z = false;
        } else {
            String[] split = v.split(",");
            if (!TextUtils.isEmpty(split[1])) {
                v = split[1].substring(0, split[1].length() - 1);
            }
            if (TextUtils.isEmpty(v)) {
                z = false;
            } else if (v.equals(String.valueOf(j))) {
                d = 1;
            } else {
                z = false;
            }
        }
        if (!"1".equals(logUpload.m4777c()) && r0 == 0) {
            C1103f.m4876a("LogUpload Service", "任务上传失败");
            Intent intent;
            if (C1102c.m4875i() != 1) {
                intent = new Intent();
                intent.setAction("com.example.logupload.progress");
                intent.setPackage(logUpload.m4760C());
                intent.putExtra(JoinConstants.EXCEPTION, "2");
                C1103f.m4876a(JoinConstants.EXCEPTION, "2");
                intent.putExtra("mLogUploadInfo", logUpload);
                C1101b.m4858a().m4860b().sendBroadcast(intent);
            } else {
                intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                intent.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
                intent.putExtra("isuploadsuccess", false);
                C1101b.m4858a().m4860b().startService(intent);
            }
        }
        if (logUpload.m4762E()) {
            if (logUpload.m4763F() == 1) {
                C1103f.m4878b("LogUpload Service", "*****Beta Log End Upload******");
            } else if (logUpload.m4763F() == 2) {
                C1103f.m4878b("LogUpload Service", "*****Fans Log End Upload******");
            } else if (logUpload.m4763F() == 3) {
                C1103f.m4878b("LogUpload Service", "*****Dev Log End Upload******");
            } else if (logUpload.m4763F() == 4) {
                C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log End Upload******");
            }
            logUpload.m4794f(false);
            if (!logUpload.m4759B() && !C1110k.m4924a()) {
                C1104a c1104a = new C1104a(Looper.getMainLooper());
                Message obtainMessage = c1104a.obtainMessage(0);
                Bundle bundle = new Bundle();
                bundle.putString("packagename", logUpload.m4760C());
                obtainMessage.setData(bundle);
                c1104a.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4921a(int r13, com.huawei.logupload.LogUpload r14) {
        /*
        r12 = 0;
        r10 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r9 = 15;
        r8 = 1;
        r0 = "LogUpload Service";
        r1 = new java.lang.StringBuilder;
        r2 = "dealwithResultForresuming";
        r1.<init>(r2);
        r1 = r1.append(r13);
        r1 = r1.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = r14.m4760C();
        r0.setPackage(r1);
        r1 = "com.example.logupload.progress";
        r0.setAction(r1);
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r13 == r1) goto L_0x00cc;
    L_0x002f:
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r13 == r1) goto L_0x00cc;
    L_0x0033:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r13 == r1) goto L_0x00cc;
    L_0x0037:
        r1 = 507; // 0x1fb float:7.1E-43 double:2.505E-321;
        if (r13 == r1) goto L_0x00cc;
    L_0x003b:
        r1 = com.huawei.logupload.p090c.C1101b.m4858a();
        r1 = r1.m4860b();
        r1 = r1.getApplicationContext();
        r1 = com.huawei.logupload.p090c.C1105h.m4907d(r1);
        r1 = com.huawei.logupload.p090c.C1105h.m4883a(r1);
        com.huawei.logupload.p090c.C1102c.m4866b(r1);
        r2 = r14.m4806l();
        r2 = r2 & 1;
        r3 = r14.m4806l();
        r3 = r3 & 2;
        r4 = r14.m4806l();
        r4 = r4 & 4;
        r5 = "LogUpload Service";
        r6 = new java.lang.StringBuilder;
        r7 = "networkType ";
        r6.<init>(r7);
        r6 = r6.append(r1);
        r7 = "flagWifi ";
        r6 = r6.append(r7);
        r6 = r6.append(r2);
        r7 = "flag3g ";
        r6 = r6.append(r7);
        r6 = r6.append(r3);
        r7 = "flag2g ";
        r6 = r6.append(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r5, r6);
        if (r1 != r8) goto L_0x00af;
    L_0x0098:
        if (r2 == r8) goto L_0x00cc;
    L_0x009a:
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
    L_0x00ae:
        return;
    L_0x00af:
        if (r1 == 0) goto L_0x00b7;
    L_0x00b1:
        r1 = 2;
        if (r3 == r1) goto L_0x00cc;
    L_0x00b4:
        r1 = 4;
        if (r4 == r1) goto L_0x00cc;
    L_0x00b7:
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
    L_0x00cc:
        switch(r13) {
            case -3: goto L_0x00d0;
            case 200: goto L_0x011a;
            case 201: goto L_0x0179;
            case 400: goto L_0x029c;
            case 401: goto L_0x02d6;
            case 403: goto L_0x029c;
            case 408: goto L_0x032d;
            case 500: goto L_0x0365;
            case 502: goto L_0x0365;
            case 507: goto L_0x029c;
            default: goto L_0x00cf;
        };
    L_0x00cf:
        goto L_0x00ae;
    L_0x00d0:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 22;
        if (r0 <= r1) goto L_0x026b;
    L_0x00d6:
        r0 = com.huawei.logupload.p090c.C1101b.m4858a();
        r0 = r0.m4860b();
        r0 = r0.getBaseContext();
        r0 = r0.getPackageManager();
        r1 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r2 = com.huawei.logupload.p090c.C1101b.m4858a();
        r2 = r2.m4860b();
        r2 = r2.getBaseContext();
        r2 = r2.getPackageName();
        r0 = com.huawei.logupload.p090c.C1105h.m4897a(r0, r1, r2);
        if (r0 != 0) goto L_0x026b;
    L_0x00fe:
        r0 = "LogUpload Service";
        r1 = "No permission!";
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
    L_0x011a:
        r1 = "LogUpload Service";
        r2 = new java.lang.StringBuilder;
        r3 = "发送成功";
        r2.<init>(r3);
        r2 = r2.append(r13);
        r3 = "type = ";
        r2 = r2.append(r3);
        r3 = r14.m4821u();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r1, r2);
        r2 = r14.m4802j();
        r1 = new java.lang.StringBuilder;
        r4 = "[0,";
        r1.<init>(r4);
        r2 = java.lang.String.valueOf(r2);
        r1 = r1.append(r2);
        r2 = "]";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r14.m4811n(r1);
        r1 = com.huawei.logupload.p090c.C1102c.m4875i();
        if (r1 == r8) goto L_0x0174;
    L_0x0164:
        r1 = "mLogUploadInfo";
        r0.putExtra(r1, r14);
        r1 = com.huawei.logupload.p090c.C1101b.m4858a();
        r1 = r1.m4860b();
        r1.sendBroadcast(r0);
    L_0x0174:
        com.huawei.logupload.C1110k.m4923a(r14, r8);
        goto L_0x00ae;
    L_0x0179:
        r1 = "LogUpload Service";
        r2 = "处理断点续传 返回值为201";
        com.huawei.logupload.p090c.C1103f.m4878b(r1, r2);
        r1 = r14.m4822v();
        if (r1 != 0) goto L_0x0193;
    L_0x0187:
        r14.m4773b(r12);
        r0 = com.huawei.logupload.C1110k.m4928d(r14);
        com.huawei.logupload.C1110k.m4921a(r0, r14);
        goto L_0x00ae;
    L_0x0193:
        r1 = "";
        r1 = com.huawei.logupload.p090c.C1102c.f2274a;
        monitor-enter(r1);
        r2 = f2292b;	 Catch:{ all -> 0x01c0 }
        r4 = r14.m4800i();	 Catch:{ all -> 0x01c0 }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x01c0 }
        r2 = com.huawei.logupload.p088a.C1097a.m4843a(r2, r3);	 Catch:{ all -> 0x01c0 }
        monitor-exit(r1);	 Catch:{ all -> 0x01c0 }
        r1 = com.huawei.logupload.p090c.C1102c.f2274a;
        monitor-enter(r1);
        r3 = f2292b;	 Catch:{ all -> 0x01bd }
        r4 = r14.m4800i();	 Catch:{ all -> 0x01bd }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x01bd }
        r3 = com.huawei.logupload.p088a.C1097a.m4848b(r3, r4);	 Catch:{ all -> 0x01bd }
        if (r3 != 0) goto L_0x01c3;
    L_0x01ba:
        monitor-exit(r1);	 Catch:{ all -> 0x01bd }
        goto L_0x00ae;
    L_0x01bd:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01bd }
        throw r0;
    L_0x01c0:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01c0 }
        throw r0;
    L_0x01c3:
        monitor-exit(r1);	 Catch:{ all -> 0x01bd }
        r1 = "1";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0232;
    L_0x01cc:
        r1 = "LogUpload Service";
        r2 = new java.lang.StringBuilder;
        r3 = "ID 为";
        r2.<init>(r3);
        r4 = r14.m4800i();
        r2 = r2.append(r4);
        r3 = " 没有暂停";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r1, r2);
        r1 = com.huawei.logupload.p090c.C1102c.m4875i();
        if (r1 == r8) goto L_0x0200;
    L_0x01f0:
        r1 = "mLogUploadInfo";
        r0.putExtra(r1, r14);
        r1 = com.huawei.logupload.p090c.C1101b.m4858a();
        r1 = r1.m4860b();
        r1.sendBroadcast(r0);
    L_0x0200:
        r0 = "LogUpload Service";
        r1 = new java.lang.StringBuilder;
        r2 = "处理断点续传 返回值为201 range:";
        r1.<init>(r2);
        r2 = r14.m4822v();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r14.m4773b(r8);
        r1 = com.huawei.logupload.p090c.C1102c.f2274a;
        monitor-enter(r1);
        r0 = f2292b;	 Catch:{ all -> 0x022f }
        r2 = 0;
        com.huawei.logupload.p088a.C1097a.m4847a(r0, r14, r2);	 Catch:{ all -> 0x022f }
        monitor-exit(r1);	 Catch:{ all -> 0x022f }
        r0 = com.huawei.logupload.C1110k.m4928d(r14);
        com.huawei.logupload.C1110k.m4921a(r0, r14);
        goto L_0x00ae;
    L_0x022f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x022f }
        throw r0;
    L_0x0232:
        r0 = "LogUpload Service";
        r1 = new java.lang.StringBuilder;
        r2 = "ID 为";
        r1.<init>(r2);
        r2 = r14.m4800i();
        r1 = r1.append(r2);
        r2 = " 已暂停";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        r0 = "1";
        r14.m4780c(r0);
        goto L_0x00ae;
    L_0x026b:
        r0 = r14.m4764G();
        r0 = r0 + 1;
        r14.m4792f(r0);
        r1 = 3;
        if (r0 > r1) goto L_0x027f;
    L_0x0277:
        android.os.SystemClock.sleep(r10);
        com.huawei.logupload.C1110k.m4926b(r14);
        goto L_0x00ae;
    L_0x027f:
        r0 = "LogUpload Service";
        r1 = "dealwithResultForresuming 重试的次数超过3次";
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
    L_0x029c:
        r0 = "LogUpload Service";
        r1 = new java.lang.StringBuilder;
        r2 = "返回值为result ==";
        r1.<init>(r2);
        r1 = r1.append(r13);
        r2 = "type = ";
        r1 = r1.append(r2);
        r2 = r14.m4821u();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
    L_0x02d6:
        r0 = "LogUpload Service";
        r1 = new java.lang.StringBuilder;
        r2 = "鉴权失败，需要重新获取鉴权";
        r1.<init>(r2);
        r1 = r1.append(r13);
        r2 = "type = ";
        r1 = r1.append(r2);
        r2 = r14.m4821u();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r14.m4786d(r8);
        r0 = r14.m4765H();
        r0 = r0 + 1;
        r14.m4795g(r0);
        if (r0 > r9) goto L_0x0310;
    L_0x0308:
        android.os.SystemClock.sleep(r10);
        com.huawei.logupload.C1110k.m4922a(r14);
        goto L_0x00ae;
    L_0x0310:
        r0 = "LogUpload Service";
        r1 = "dealwithResultForresuming 401";
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
    L_0x032d:
        r0 = "LogUpload Service";
        r1 = "服务器超时，重连";
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = r14.m4765H();
        r0 = r0 + 1;
        r14.m4795g(r0);
        if (r0 > r9) goto L_0x0348;
    L_0x0340:
        android.os.SystemClock.sleep(r10);
        com.huawei.logupload.C1110k.m4926b(r14);
        goto L_0x00ae;
    L_0x0348:
        r0 = "LogUpload Service";
        r1 = "dealwithResultForresuming 408";
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
    L_0x0365:
        r0 = "LogUpload Service";
        r1 = new java.lang.StringBuilder;
        r2 = "服务器错误，5分钟重试";
        r1.<init>(r2);
        r1 = r1.append(r13);
        r2 = "type = ";
        r1 = r1.append(r2);
        r2 = r14.m4821u();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = r14.m4765H();
        r0 = r0 + 1;
        r14.m4795g(r0);
        if (r0 > r9) goto L_0x03a9;
    L_0x0394:
        r14.m4790e(r8);
        r0 = new java.util.Timer;
        r0.<init>();
        r1 = new com.huawei.logupload.m;
        r1.<init>(r0, r14);
        r2 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r0.schedule(r1, r2);
        goto L_0x00ae;
    L_0x03a9:
        r0 = "LogUpload Service";
        r1 = "dealwithResultForresuming 500,502";
        com.huawei.logupload.p090c.C1103f.m4878b(r0, r1);
        r0 = new java.lang.StringBuilder;
        r2 = r14.m4791f();
        r1 = java.lang.String.valueOf(r2);
        r0.<init>(r1);
        r0 = r0.toString();
        com.huawei.logupload.p090c.C1105h.m4903b(r0);
        goto L_0x00ae;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.k.a(int, com.huawei.logupload.LogUpload):void");
    }

    private static void m4925b(int i, LogUpload logUpload) {
        C1103f.m4878b("LogUpload Service", "dealwithResult" + i);
        int a = C1105h.m4883a(C1105h.m4907d(C1101b.m4858a().m4860b().getApplicationContext()));
        C1102c.m4866b(a);
        int l = logUpload.m4806l() & 1;
        int l2 = logUpload.m4806l() & 2;
        int l3 = logUpload.m4806l() & 4;
        C1103f.m4878b("LogUpload Service", "networkType " + a + "flagWifi " + l + "flag3g " + l2 + "flag2g " + l3);
        Intent intent = new Intent();
        intent.setAction("com.example.logupload.progress");
        intent.setPackage(logUpload.m4760C());
        switch (i) {
            case -3:
                if (a == 1) {
                    if (l != 1) {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        return;
                    }
                } else if (a == 0 || !(l2 == 2 || l3 == 4)) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    return;
                }
                if (VERSION.SDK_INT <= 22 || C1105h.m4897a(C1101b.m4858a().m4860b().getBaseContext().getPackageManager(), "android.permission.WRITE_EXTERNAL_STORAGE", C1101b.m4858a().m4860b().getBaseContext().getPackageName())) {
                    a = logUpload.m4764G();
                    C1103f.m4880d("LogUpload Service", "timeReconect:" + a);
                    a++;
                    logUpload.m4792f(a);
                    C1103f.m4880d("LogUpload Service", "timeReconect " + a + "mLogUploadInfo.getTimeReconnect() " + logUpload.m4764G());
                    if (a <= 3) {
                        SystemClock.sleep(2000);
                        C1110k.m4926b(logUpload);
                        return;
                    }
                    C1103f.m4878b("LogUpload Service", "dealwithResult 重试的次数超过3次");
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    return;
                }
                C1103f.m4878b("LogUpload Service", "No permission!");
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                return;
            case -1:
                if (logUpload.m4802j() < 1024000) {
                    C1110k.m4923a(logUpload, false);
                    return;
                }
                return;
            case 200:
                C1103f.m4878b("LogUpload Service", "发送成功" + i + "type = " + logUpload.m4821u());
                logUpload.m4811n("[0," + String.valueOf(logUpload.m4802j()) + "]");
                if (C1102c.m4875i() != 1) {
                    intent.putExtra("mLogUploadInfo", logUpload);
                    C1101b.m4858a().m4860b().sendBroadcast(intent);
                }
                C1110k.m4923a(logUpload, true);
                return;
            case HttpStatus.SC_BAD_REQUEST /*400*/:
            case HttpStatus.SC_INSUFFICIENT_STORAGE /*507*/:
                C1103f.m4878b("LogUpload Service", "返回值为result ==" + i + "type = " + logUpload.m4821u());
                C1110k.m4923a(logUpload, false);
                return;
            case HttpStatus.SC_UNAUTHORIZED /*401*/:
            case HttpStatus.SC_FORBIDDEN /*403*/:
                C1103f.m4878b("LogUpload Service", "networkType:" + a);
                if (a == 1) {
                    if (l != 1) {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        return;
                    }
                } else if (a == 0 || !(l2 == 2 || l3 == 4)) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    return;
                }
                a = logUpload.m4765H() + 1;
                logUpload.m4795g(a);
                C1103f.m4878b("LogUpload Service", "鉴权失败，需要重新获取鉴权" + i + "type = " + logUpload.m4821u());
                if (a <= 15) {
                    logUpload.m4786d(true);
                    C1110k.m4922a(logUpload);
                    return;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                return;
            case 408:
                C1103f.m4878b("LogUpload Service", "networkType:" + a);
                if (a == 1) {
                    if (l != 1) {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        return;
                    }
                } else if (a == 0 || !(l2 == 2 || l3 == 4)) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    return;
                }
                C1103f.m4878b("LogUpload Service", "服务器超时，重连");
                a = logUpload.m4765H() + 1;
                logUpload.m4795g(a);
                if (a <= 15) {
                    C1105h.m4894a(new StringBuilder(String.valueOf(logUpload.m4791f())).toString(), 1);
                    C1110k.m4926b(logUpload);
                    return;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                return;
            case 500:
            case HttpStatus.SC_BAD_GATEWAY /*502*/:
                if (a == 1) {
                    if (l != 1) {
                        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                        return;
                    }
                } else if (a == 0 || !(l2 == 2 || l3 == 4)) {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    return;
                }
                C1103f.m4878b("LogUpload Service", "服务器错误，5分钟重试" + i + "type = " + logUpload.m4821u());
                a = logUpload.m4765H() + 1;
                logUpload.m4795g(a);
                if (a <= 15) {
                    logUpload.m4790e(true);
                    Timer timer = new Timer();
                    timer.schedule(new n(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                    return;
                }
                C1103f.m4878b("LogUpload Service", "dealwithResultForresuming 500,502");
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                return;
            default:
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                return;
        }
    }

    private static int m4928d(LogUpload logUpload) {
        C1103f.m4878b("LogUpload Service", "Uploader");
        p pVar = new p();
        if (logUpload == null) {
            return -1;
        }
        File file;
        if (logUpload.m4812o() == null || !logUpload.m4812o().equals("")) {
            if (logUpload.m4824x() == null || logUpload.m4824x().equals("")) {
                return -1;
            }
            C1103f.m4878b("LogUpload Service", "Uploader mLogUploadInfo.getEncryptFile()" + logUpload.m4824x());
            file = new File(logUpload.m4824x());
        } else if (logUpload.m4798h() == null || logUpload.m4798h().equals("")) {
            return -1;
        } else {
            C1103f.m4878b("LogUpload Service", "Uploader mLogUploadInfo.getFilepath()" + logUpload.m4798h());
            file = new File(logUpload.m4798h());
        }
        if (file.exists()) {
            int a;
            C1103f.m4878b("LogUpload Service", file.getAbsolutePath());
            try {
                a = pVar.a(file, logUpload);
            } catch (SocketTimeoutException e) {
                C1103f.m4878b("LogUpload Service", "Uploader SocketTimeoutException");
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                if (logUpload.m4825y() < 8) {
                    C1110k.m4929e(logUpload);
                    a = -1;
                } else {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    a = -1;
                }
            } catch (HttpHostConnectException e2) {
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                C1103f.m4878b("LogUpload Service", "Uploader HttpHostConnectException");
                a = -1;
            } catch (ConnectTimeoutException e3) {
                C1103f.m4878b("LogUpload Service", "Uploader ConnectTimeoutException");
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                if (logUpload.m4825y() < 8) {
                    C1110k.m4929e(logUpload);
                    a = -1;
                } else {
                    C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                    a = -1;
                }
            } catch (UnsupportedEncodingException e4) {
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                C1103f.m4878b("LogUpload Service", "Uploader UnsupportedEncodingException");
                a = -1;
            } catch (ClientProtocolException e5) {
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                C1103f.m4878b("LogUpload Service", "ClientProtocolException");
                a = -1;
            } catch (IOException e6) {
                C1103f.m4878b("LogUpload Service", "Uploader IOException");
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                a = -1;
            } catch (Exception e7) {
                if (logUpload.m4763F() != 0 && logUpload.m4763F() != 4) {
                    return -3;
                }
                C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
                C1103f.m4878b("LogUpload Service", "Uploader Exception");
                a = -1;
            }
            return a;
        }
        C1103f.m4878b("LogUpload Service", "Uploader 需要发送的文件不存在，退出");
        C1110k.m4923a(logUpload, false);
        return -2;
    }

    static void m4923a(LogUpload logUpload, boolean z) {
        C1103f.m4878b("LogUpload Service", "deleteTaskAndReport" + z + "mLogUploadInfo.getTaskId()" + logUpload.m4791f());
        Context applicationContext = C1101b.m4858a().m4860b().getApplicationContext();
        C1105h.m4889a(logUpload);
        String C = logUpload.m4760C();
        if ("com.huawei.lcagent".equals(C) || "com.huawei.hidp".equals(C) || "com.huawei.imonitor".equals(C)) {
            C1105h.m4888a(applicationContext, logUpload, z);
        } else if (C1102c.m4875i() != 1) {
            r0 = new Intent();
            r0.setPackage(C);
            r0.setAction("com.example.logupload.progressSmall");
            r0.setPackage(logUpload.m4760C());
            r0.putExtra("mLogUploadInfo", logUpload);
            C1101b.m4858a().m4860b().sendBroadcast(r0);
        } else {
            r0 = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
            r0.setClassName(C1101b.m4858a().m4860b(), "com.huawei.feedback.component.AutoUploadService");
            r0.putExtra("isuploadsuccess", z);
            C1101b.m4858a().m4860b().startService(r0);
        }
        C1105h.m4903b(new StringBuilder(String.valueOf(logUpload.m4791f())).toString());
        synchronized (C1102c.f2274a) {
            C1097a.m4850b(f2292b, logUpload);
        }
        synchronized (C1102c.f2274a) {
            f2291a = C1097a.m4844a(f2292b);
        }
        if (f2291a != null) {
            C1103f.m4878b("LogUpload Service", "lstUploadInfo.size()" + f2291a.size());
        }
    }

    private static void m4929e(LogUpload logUpload) {
        C1103f.m4878b("LogUpload Service", "The times of timeount is " + logUpload.m4825y());
        logUpload.m4778c(logUpload.m4825y() + 1);
        C1110k.m4928d(logUpload);
    }

    public static boolean m4924a() {
        synchronized (C1102c.f2274a) {
            f2291a = C1097a.m4844a(f2292b);
        }
        if (f2291a != null) {
            C1103f.m4878b("LogUpload Service", "lstUploadInfo.size()" + f2291a.size());
        }
        if (f2291a == null || f2291a.size() <= 0) {
            return false;
        }
        for (int i = 0; i < f2291a.size(); i++) {
            long f = ((LogUpload) f2291a.get(i)).m4791f();
            C1103f.m4878b("LogUpload Service", "taskId" + f + "CommonConstants.getTaskList().get(taskId+\"\"):" + C1102c.m4867c().get(new StringBuilder(String.valueOf(f)).toString()));
            if (C1105h.m4884a(new StringBuilder(String.valueOf(f)).toString()) == 1) {
                return true;
            }
        }
        return false;
    }
}
