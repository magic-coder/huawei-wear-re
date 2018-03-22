package com.huawei.uploadlog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.utils.PhoneInfo;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p186a.C2497b;
import com.huawei.uploadlog.p187b.C2499a;
import com.huawei.uploadlog.p188c.C2505a;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2517m;
import com.huawei.uploadlog.p188c.C2519o;
import com.huawei.uploadlog.p188c.p189a.C2501a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Timer;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: UploadRequest */
public final class C2529l {
    private static LongSparseArray<LogUpload> f9013a = new LongSparseArray(100);
    private static final C2497b f9014b = new C2497b(AppContext.getInstance().getApplication().getBaseContext());

    public static void m12605a(LogUpload logUpload) {
        if (logUpload != null) {
            f9013a.put(logUpload.getId(), logUpload);
        }
    }

    public static void m12609b(LogUpload logUpload) {
        if (logUpload != null) {
            f9013a.remove(logUpload.getId());
        }
    }

    public static void m12610c(LogUpload logUpload) {
        if (logUpload != null) {
            LogUpload logUpload2 = (LogUpload) f9013a.get(logUpload.getId());
            if (logUpload2 != null) {
                logUpload2.setPaused(true);
            }
        }
    }

    public static void m12611d(LogUpload logUpload) {
        if (logUpload != null) {
            LogUpload logUpload2 = (LogUpload) f9013a.get(logUpload.getId());
            if (logUpload2 != null) {
                logUpload2.setPaused(false);
            } else {
                f9013a.put(logUpload.getId(), logUpload);
            }
            C2499a.m12430a().m12431a(new C2524g(logUpload, 2));
        }
    }

    public static void m12612e(LogUpload logUpload) {
        Closeable inputStream;
        Throwable e;
        C2533p c2533p;
        C2519o c2519o;
        Timer timer;
        Intent intent;
        Closeable closeable;
        Exception e2;
        String str = null;
        logUpload.setTimeout(0);
        logUpload.setSetTime(false);
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest start");
        Closeable gZIPOutputStream;
        try {
            System.setProperty("http.keepAlive", "false");
            URL url = new URL("https://logservice.vmall.com:443/osg/logServerAction!addLogServer.htm");
            C2517m.m12580c();
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
                if (StringUtils.isNullOrEmpty(logUpload.getProductName())) {
                    C2527j.m12603a("deviceType", Build.MODEL, gZIPOutputStream);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 设备型号" + Build.MODEL);
                } else {
                    C2527j.m12603a("deviceType", logUpload.getProductName(), gZIPOutputStream);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 设备型号" + logUpload.getProductName());
                }
                if (StringUtils.isNullOrEmpty(logUpload.getRomVersion())) {
                    C2527j.m12603a("sysVersion", Build.DISPLAY, gZIPOutputStream);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 系统版本号" + Build.DISPLAY);
                } else {
                    C2527j.m12603a("sysVersion", logUpload.getRomVersion(), gZIPOutputStream);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 系统版本号" + logUpload.getRomVersion());
                }
                String serialNumber = PhoneInfo.getSerialNumber();
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 手机SN" + serialNumber);
                C2527j.m12603a("deviceID", serialNumber, gZIPOutputStream);
                C2527j.m12603a(UploadFile.SYS_ID_CHANNEL, String.valueOf(logUpload.getChannelId()), gZIPOutputStream);
                C2511g.m12481b("BETACLUB_SDK", String.valueOf(logUpload.getChannelId()));
                C2527j.m12603a("os", VERSION.RELEASE, gZIPOutputStream);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 操作版本" + VERSION.RELEASE);
                serialNumber = C2517m.m12577b();
                if (StringUtils.isNullOrEmpty(serialNumber)) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] imsi为空");
                } else if (serialNumber.length() > 4) {
                    C2527j.m12603a(UploadFile.DEVICE_IMSI_LABEL, serialNumber.substring(0, 5), gZIPOutputStream);
                }
                if (logUpload.isEncrypt()) {
                    C2527j.m12603a(UploadFile.ENCRTPT_TYPE, "1", gZIPOutputStream);
                } else {
                    C2527j.m12603a(UploadFile.ENCRTPT_TYPE, "0", gZIPOutputStream);
                }
                C2527j.m12603a(UploadFile.SENSITIVE_CONTAIN, Boolean.toString(logUpload.isPrivacy()), gZIPOutputStream);
                serialNumber = logUpload.getFilePath();
                if (!StringUtils.isNullOrEmpty(serialNumber)) {
                    C2527j.m12603a(UploadFile.FILE_NAME, serialNumber.substring(serialNumber.lastIndexOf("/") + 1), gZIPOutputStream);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] fileName=" + serialNumber.substring(serialNumber.lastIndexOf("/") + 1));
                }
                C2527j.m12603a(UploadFile.SIZE_LABEL, Long.toString(logUpload.getSize()), gZIPOutputStream);
                C2527j.m12603a("version", "3", gZIPOutputStream);
                C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUpload.getUserType():" + logUpload.getUserType());
                C2527j.m12603a(UploadFile.USER_TYPE, Integer.toString(logUpload.getUserType()), gZIPOutputStream);
                C2527j.m12603a(UploadFile.ZIP_TIME, logUpload.getZipTime(), gZIPOutputStream);
                C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUpload.getZipTime():" + logUpload.getZipTime());
                C2527j.m12603a(UploadFile.LOG_DETAIL_INFO, logUpload.getLogDetailInfo(), gZIPOutputStream);
                C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUpload.getLogDetailInfo():" + logUpload.getLogDetailInfo());
                if (logUpload.getType() == 1 || logUpload.getType() == 2) {
                    if (logUpload.isRefresh()) {
                        C2527j.m12603a(UploadFile.REFRESH_LABEL, Boolean.toString(true), gZIPOutputStream);
                        logUpload.setRefresh(false);
                    }
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 带有refresh");
                }
                if (C2517m.m12588h() != null) {
                    serialNumber = C2517m.m12588h();
                    C2527j.m12603a("sign", serialNumber, gZIPOutputStream);
                    C2511g.m12481b("BETACLUB_SDK", "UploadFile.addFormField(UploadFile.SIGN)" + serialNumber);
                }
                if (!StringUtils.isNullOrEmpty(logUpload.getSecret())) {
                    C2527j.m12603a(UploadFile.ENCRYTKEY, C2501a.m12435b(logUpload.getSecret()), gZIPOutputStream);
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] UploadFile.addEndField(dos)");
                C2527j.m12602a(gZIPOutputStream);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] dos.flush()");
                gZIPOutputStream.flush();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable e3) {
                        C2511g.m12482b("BETACLUB_SDK", "dos close is failed ", e3);
                    }
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] urlConnection.getInputStream()");
                inputStream = httpsURLConnection.getInputStream();
            } catch (RuntimeException e4) {
                e = e4;
                inputStream = null;
                try {
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] RuntimeException", e);
                    C2517m.m12582c(logUpload);
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest]RuntimeException", e);
                    C2517m.m12571a(inputStream, "BETACLUB_SDK");
                    C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                    if (str != null) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
                    }
                    c2533p = new C2533p();
                    if (c2533p.m12619a(str) != 0) {
                    }
                    if (1 == c2533p.m12618a()) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                        C2529l.m12606a(logUpload, false);
                        if (logUpload.isSetTime()) {
                            if (logUpload.getUserType() == 1) {
                                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                            } else if (logUpload.getUserType() == 2) {
                                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                            } else if (logUpload.getUserType() == 3) {
                                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                            }
                            if (!C2529l.m12607a()) {
                                c2519o = new C2519o(Looper.getMainLooper());
                                c2519o.sendMessage(c2519o.obtainMessage(0));
                            }
                        }
                    } else if (2 == c2533p.m12618a()) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                        timer = new Timer();
                        logUpload.setSetTime(true);
                        timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                    } else if (1002 != c2533p.m12618a()) {
                        C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                        intent = new Intent();
                        intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                        logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        AppContext.getInstance().getApplication().sendBroadcast(intent);
                        C2529l.m12606a(logUpload, true);
                        if (!C2529l.m12607a()) {
                            c2519o = new C2519o(Looper.getMainLooper());
                            c2519o.sendMessage(c2519o.obtainMessage(0));
                        }
                    } else {
                        C2517m.m12582c(logUpload);
                        intent = new Intent();
                        intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                        intent.putExtra(JoinConstants.EXCEPTION, "2");
                        C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                        intent.putExtra("mLogUploadInfo", logUpload);
                        AppContext.getInstance().getApplication().sendBroadcast(intent);
                        if (logUpload.isSetTime()) {
                        }
                        return;
                    }
                } catch (Throwable th) {
                    e = th;
                    closeable = inputStream;
                    C2517m.m12571a(closeable, "BETACLUB_SDK");
                    C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                    throw e;
                }
            } catch (ConnectTimeoutException e5) {
                e = e5;
                inputStream = null;
                C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest 日志分发服务器请求超时" + e.getMessage(), e);
                if (logUpload.getTimeout() < 8) {
                    C2529l.m12615h(logUpload);
                }
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                if (str != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
                }
                c2533p = new C2533p();
                if (c2533p.m12619a(str) != 0) {
                }
                if (1 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                    C2529l.m12606a(logUpload, false);
                    if (logUpload.isSetTime()) {
                        if (logUpload.getUserType() == 1) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                        } else if (logUpload.getUserType() == 2) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                        } else if (logUpload.getUserType() == 3) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                        }
                        if (!C2529l.m12607a()) {
                            c2519o = new C2519o(Looper.getMainLooper());
                            c2519o.sendMessage(c2519o.obtainMessage(0));
                        }
                    }
                } else if (2 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                    timer = new Timer();
                    logUpload.setSetTime(true);
                    timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 != c2533p.m12618a()) {
                    C2517m.m12582c(logUpload);
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    if (logUpload.isSetTime()) {
                        return;
                    }
                } else {
                    C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    C2529l.m12606a(logUpload, true);
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                }
            } catch (Exception e6) {
                e2 = e6;
                inputStream = null;
                C2517m.m12582c(logUpload);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest Exception" + e2.getMessage());
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                if (str != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
                }
                c2533p = new C2533p();
                if (c2533p.m12619a(str) != 0) {
                }
                if (1 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                    C2529l.m12606a(logUpload, false);
                    if (logUpload.isSetTime()) {
                        if (logUpload.getUserType() == 1) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                        } else if (logUpload.getUserType() == 2) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                        } else if (logUpload.getUserType() == 3) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                        }
                        if (!C2529l.m12607a()) {
                            c2519o = new C2519o(Looper.getMainLooper());
                            c2519o.sendMessage(c2519o.obtainMessage(0));
                        }
                    }
                } else if (2 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                    timer = new Timer();
                    logUpload.setSetTime(true);
                    timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 != c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    C2529l.m12606a(logUpload, true);
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                } else {
                    C2517m.m12582c(logUpload);
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    if (logUpload.isSetTime()) {
                    }
                    return;
                }
            } catch (Throwable th2) {
                e = th2;
                C2517m.m12571a(closeable, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                throw e;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer.append(new String(bArr, 0, read, "utf-8"));
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 读取" + new String(bArr, 0, read, "utf-8"));
                }
                str = stringBuffer.toString();
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 读取完成 " + str);
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
            } catch (RuntimeException e7) {
                e = e7;
                C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] RuntimeException", e);
                C2517m.m12582c(logUpload);
                C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest]RuntimeException", e);
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                if (str != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
                }
                c2533p = new C2533p();
                if (c2533p.m12619a(str) != 0) {
                }
                if (1 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                    C2529l.m12606a(logUpload, false);
                    if (logUpload.isSetTime()) {
                        if (logUpload.getUserType() == 1) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                        } else if (logUpload.getUserType() == 2) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                        } else if (logUpload.getUserType() == 3) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                        }
                        if (!C2529l.m12607a()) {
                            c2519o = new C2519o(Looper.getMainLooper());
                            c2519o.sendMessage(c2519o.obtainMessage(0));
                        }
                    }
                } else if (2 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                    timer = new Timer();
                    logUpload.setSetTime(true);
                    timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 != c2533p.m12618a()) {
                    C2517m.m12582c(logUpload);
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    if (logUpload.isSetTime()) {
                        return;
                    }
                } else {
                    C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    C2529l.m12606a(logUpload, true);
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                }
            } catch (ConnectTimeoutException e8) {
                e = e8;
                C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest 日志分发服务器请求超时" + e.getMessage(), e);
                if (logUpload.getTimeout() < 8) {
                    C2529l.m12615h(logUpload);
                }
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                if (str != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
                }
                c2533p = new C2533p();
                if (c2533p.m12619a(str) != 0) {
                }
                if (1 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                    C2529l.m12606a(logUpload, false);
                    if (logUpload.isSetTime()) {
                        if (logUpload.getUserType() == 1) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                        } else if (logUpload.getUserType() == 2) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                        } else if (logUpload.getUserType() == 3) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                        }
                        if (!C2529l.m12607a()) {
                            c2519o = new C2519o(Looper.getMainLooper());
                            c2519o.sendMessage(c2519o.obtainMessage(0));
                        }
                    }
                } else if (2 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                    timer = new Timer();
                    logUpload.setSetTime(true);
                    timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 != c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    C2529l.m12606a(logUpload, true);
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                } else {
                    C2517m.m12582c(logUpload);
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    if (logUpload.isSetTime()) {
                    }
                    return;
                }
            } catch (Exception e9) {
                e2 = e9;
                C2517m.m12582c(logUpload);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest Exception" + e2.getMessage());
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
                if (str != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
                }
                c2533p = new C2533p();
                if (c2533p.m12619a(str) != 0) {
                }
                if (1 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                    C2529l.m12606a(logUpload, false);
                    if (logUpload.isSetTime()) {
                        if (logUpload.getUserType() == 1) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                        } else if (logUpload.getUserType() == 2) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                        } else if (logUpload.getUserType() == 3) {
                            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                        }
                        if (!C2529l.m12607a()) {
                            c2519o = new C2519o(Looper.getMainLooper());
                            c2519o.sendMessage(c2519o.obtainMessage(0));
                        }
                    }
                } else if (2 == c2533p.m12618a()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                    timer = new Timer();
                    logUpload.setSetTime(true);
                    timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                } else if (1002 != c2533p.m12618a()) {
                    C2517m.m12582c(logUpload);
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    intent.putExtra(JoinConstants.EXCEPTION, "2");
                    C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    if (logUpload.isSetTime()) {
                        return;
                    }
                } else {
                    C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                    intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    C2529l.m12606a(logUpload, true);
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                }
            }
        } catch (RuntimeException e10) {
            e = e10;
            inputStream = null;
            gZIPOutputStream = null;
            C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] RuntimeException", e);
            C2517m.m12582c(logUpload);
            C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest]RuntimeException", e);
            C2517m.m12571a(inputStream, "BETACLUB_SDK");
            C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
            if (str != null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
            }
            c2533p = new C2533p();
            if (c2533p.m12619a(str) != 0) {
            }
            if (1 == c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                C2529l.m12606a(logUpload, false);
                if (logUpload.isSetTime()) {
                    if (logUpload.getUserType() == 1) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                    } else if (logUpload.getUserType() == 2) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                    } else if (logUpload.getUserType() == 3) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                    }
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                }
            } else if (2 == c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                timer = new Timer();
                logUpload.setSetTime(true);
                timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            } else if (1002 != c2533p.m12618a()) {
                C2517m.m12582c(logUpload);
                intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                intent.putExtra(JoinConstants.EXCEPTION, "2");
                C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                if (logUpload.isSetTime()) {
                    return;
                }
            } else {
                C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                C2529l.m12606a(logUpload, true);
                if (!C2529l.m12607a()) {
                    c2519o = new C2519o(Looper.getMainLooper());
                    c2519o.sendMessage(c2519o.obtainMessage(0));
                }
            }
        } catch (ConnectTimeoutException e11) {
            e = e11;
            inputStream = null;
            gZIPOutputStream = null;
            C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest 日志分发服务器请求超时" + e.getMessage(), e);
            if (logUpload.getTimeout() < 8) {
                C2529l.m12615h(logUpload);
            }
            C2517m.m12571a(inputStream, "BETACLUB_SDK");
            C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
            if (str != null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
            }
            c2533p = new C2533p();
            if (c2533p.m12619a(str) != 0) {
            }
            if (1 == c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                C2529l.m12606a(logUpload, false);
                if (logUpload.isSetTime()) {
                    if (logUpload.getUserType() == 1) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                    } else if (logUpload.getUserType() == 2) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                    } else if (logUpload.getUserType() == 3) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                    }
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                }
            } else if (2 == c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                timer = new Timer();
                logUpload.setSetTime(true);
                timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            } else if (1002 != c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                C2529l.m12606a(logUpload, true);
                if (!C2529l.m12607a()) {
                    c2519o = new C2519o(Looper.getMainLooper());
                    c2519o.sendMessage(c2519o.obtainMessage(0));
                }
            } else {
                C2517m.m12582c(logUpload);
                intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                intent.putExtra(JoinConstants.EXCEPTION, "2");
                C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                if (logUpload.isSetTime()) {
                }
                return;
            }
        } catch (Exception e12) {
            e2 = e12;
            inputStream = null;
            gZIPOutputStream = null;
            C2517m.m12582c(logUpload);
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] logUploadRequest Exception" + e2.getMessage());
            C2517m.m12571a(inputStream, "BETACLUB_SDK");
            C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
            if (str != null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
            }
            c2533p = new C2533p();
            if (c2533p.m12619a(str) != 0) {
            }
            if (1 == c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
                C2529l.m12606a(logUpload, false);
                if (logUpload.isSetTime()) {
                    if (logUpload.getUserType() == 1) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                    } else if (logUpload.getUserType() == 2) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                    } else if (logUpload.getUserType() == 3) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                    }
                    if (!C2529l.m12607a()) {
                        c2519o = new C2519o(Looper.getMainLooper());
                        c2519o.sendMessage(c2519o.obtainMessage(0));
                    }
                }
            } else if (2 == c2533p.m12618a()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
                timer = new Timer();
                logUpload.setSetTime(true);
                timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            } else if (1002 != c2533p.m12618a()) {
                C2517m.m12582c(logUpload);
                intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                intent.putExtra(JoinConstants.EXCEPTION, "2");
                C2511g.m12477a(JoinConstants.EXCEPTION, "2");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                if (logUpload.isSetTime()) {
                    return;
                }
            } else {
                C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
                intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                C2529l.m12606a(logUpload, true);
                if (!C2529l.m12607a()) {
                    c2519o = new C2519o(Looper.getMainLooper());
                    c2519o.sendMessage(c2519o.obtainMessage(0));
                }
            }
        } catch (Throwable th3) {
            e = th3;
            gZIPOutputStream = null;
            C2517m.m12571a(closeable, "BETACLUB_SDK");
            C2517m.m12571a(gZIPOutputStream, "BETACLUB_SDK");
            throw e;
        }
        if (str != null) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] response: " + str);
        }
        c2533p = new C2533p();
        if (c2533p.m12619a(str) != 0 && c2533p.m12618a() == 0) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器结果解析正确");
            str = c2533p.m12622b();
            if (StringUtils.isNullOrEmpty(str)) {
                str = c2533p.m12624c();
                if (!(str == null || str.equals(""))) {
                    logUpload.setAccessToken(str);
                }
                File a;
                if (TextUtils.isEmpty(logUpload.getSecret()) || !logUpload.getSecret().equals(c2533p.m12626d())) {
                    str = c2533p.m12626d();
                    if (TextUtils.isEmpty(str)) {
                        logUpload.setSecret(str);
                    } else {
                        Object a2 = C2501a.m12433a(str);
                        if (TextUtils.isEmpty(a2)) {
                            logUpload.setSecret(str);
                        } else {
                            logUpload.setSecret(a2);
                        }
                    }
                    if (!(str == null || str.equals("") || logUpload.getEncryptedFile() != null)) {
                        C2511g.m12481b("BETACLUB_SDK", "对文件进行加密处理");
                        a = C2505a.m12446a(new File(logUpload.getFilePath()), str);
                        if (a != null) {
                            logUpload.setEncryptedFile(a.toString());
                        }
                    }
                } else {
                    C2511g.m12481b("BETACLUB_SDK", "--文件不加密-->>");
                    a = new File(logUpload.getEncryptedFile());
                    if (a != null && a.exists()) {
                        logUpload.setEncryptedFile(a.toString());
                    }
                }
                synchronized (C2507c.f8987a) {
                    C2496a.m12418a(f9014b, logUpload, false);
                }
                str = c2533p.m12628e();
                if (str != null) {
                    logUpload.setUploadPath(str);
                }
                str = c2533p.m12632g();
                if (str != null) {
                    logUpload.setCallbackAddress(str);
                }
                str = c2533p.m12630f();
                if (str != null) {
                    logUpload.setTimeStamp(str);
                }
                String h = c2533p.m12634h();
                if (h != null) {
                    logUpload.setUploadAddress(h);
                }
                synchronized (C2507c.f8987a) {
                    C2496a.m12418a(f9014b, logUpload, false);
                }
                C2529l.m12613f(logUpload);
            } else if (str.equals("autoUploadInternalSwitch=false")) {
                logUpload.setPolicy(str);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] policy存在，将policy信息发送给服务器 =" + str);
                C2529l.m12606a(logUpload, false);
            }
        } else if (1 == c2533p.m12618a()) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 日志分发服务器鉴权失败");
            C2529l.m12606a(logUpload, false);
            if (logUpload.isSetTime()) {
                if (logUpload.getUserType() == 1) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Beta Log End Upload******");
                } else if (logUpload.getUserType() == 2) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Fans Log End Upload******");
                } else if (logUpload.getUserType() == 3) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] *****Dev Log End Upload******");
                }
                if (!C2529l.m12607a()) {
                    c2519o = new C2519o(Looper.getMainLooper());
                    c2519o.sendMessage(c2519o.obtainMessage(0));
                }
            }
        } else if (2 == c2533p.m12618a()) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 返回值结果为2");
            timer = new Timer();
            logUpload.setSetTime(true);
            timer.schedule(new C2530m(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        } else if (1002 != c2533p.m12618a()) {
            C2511g.m12481b("BETACLUB_SDK", "返回值结果为1002");
            intent = new Intent();
            intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
            logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
            intent.putExtra("mLogUploadInfo", logUpload);
            AppContext.getInstance().getApplication().sendBroadcast(intent);
            C2529l.m12606a(logUpload, true);
            if (!C2529l.m12607a()) {
                c2519o = new C2519o(Looper.getMainLooper());
                c2519o.sendMessage(c2519o.obtainMessage(0));
            }
        } else {
            C2517m.m12582c(logUpload);
            intent = new Intent();
            intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
            intent.putExtra(JoinConstants.EXCEPTION, "2");
            C2511g.m12477a(JoinConstants.EXCEPTION, "2");
            intent.putExtra("mLogUploadInfo", logUpload);
            AppContext.getInstance().getApplication().sendBroadcast(intent);
            if (logUpload.isSetTime() && !C2529l.m12607a()) {
                c2519o = new C2519o(Looper.getMainLooper());
                c2519o.sendMessage(c2519o.obtainMessage(0));
            }
        }
    }

    private static void m12615h(LogUpload logUpload) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.handlerHttpsConnectTimeOut] https 请求超时处理");
        logUpload.setTimeout(logUpload.getTimeout() + 1);
        C2529l.m12612e(logUpload);
    }

    public static void m12613f(LogUpload logUpload) {
        boolean z;
        C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.prepareUpload] logUpload.getTimeReconnect()=" + logUpload.getTimeReconnect());
        C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.prepareUpload] logUpload.getTimeReconnect()=" + logUpload.getTimeAuthOverTime());
        logUpload.setTimeout(0);
        logUpload.setSetTime(false);
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] prepareUpload");
        if (logUpload.getSize() < 1024000) {
            logUpload.setType(0);
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] prepareUpload 小文件上传");
            synchronized (C2507c.f8987a) {
                C2496a.m12418a(f9014b, logUpload, false);
            }
            C2529l.m12608b(C2529l.m12616i(logUpload), logUpload);
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] prepareUpload 大文件上传");
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] 此时type值为" + logUpload.getType());
            logUpload.setType(2);
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] logUpload.setType(2)");
            synchronized (C2507c.f8987a) {
                C2496a.m12418a(f9014b, logUpload, false);
            }
            int i = C2529l.m12616i(logUpload);
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] result=" + i);
            C2529l.m12604a(i, logUpload);
        }
        String contentRange = logUpload.getContentRange();
        long size = logUpload.getSize();
        if (StringUtils.isNullOrEmpty(contentRange)) {
            z = false;
        } else {
            String[] split = contentRange.split(",");
            if (!StringUtils.isNullOrEmpty(split[1])) {
                contentRange = split[1].substring(0, split[1].length() - 1);
            }
            z = !StringUtils.isNullOrEmpty(contentRange) ? contentRange.equals(String.valueOf(size)) : false;
        }
        C2511g.m12477a("BETACLUB_SDK", "logUpload.isPaused()" + logUpload.isPaused());
        C2511g.m12477a("BETACLUB_SDK", "logUpload.isPaused()" + z);
        if (!(logUpload.isPaused() || z)) {
            C2511g.m12477a("BETACLUB_SDK", "任务上传结束");
            Intent intent = new Intent();
            intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
            intent.putExtra(JoinConstants.EXCEPTION, "2");
            C2511g.m12477a(JoinConstants.EXCEPTION, "2");
            intent.putExtra("mLogUploadInfo", logUpload);
            AppContext.getInstance().getApplication().sendBroadcast(intent);
        }
        if (logUpload.isReconnect()) {
            if (logUpload.getUserType() == 1) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] *****Beta Log End Upload******");
            } else if (logUpload.getUserType() == 2) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] *****Fans Log End Upload******");
            } else if (logUpload.getUserType() == 3) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.prepareUpload] *****Dev Log End Upload******");
            }
            logUpload.setReconnect(false);
            if (!logUpload.isSetTime() && !C2529l.m12607a()) {
                C2519o c2519o = new C2519o(Looper.getMainLooper());
                c2519o.sendMessage(c2519o.obtainMessage(0));
            }
        }
    }

    private static void m12604a(int i, LogUpload logUpload) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] result=" + i);
        Intent intent = new Intent();
        intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
        if (!(i == 200 || i == HttpStatus.SC_BAD_REQUEST || i == HttpStatus.SC_FORBIDDEN || i == HttpStatus.SC_INSUFFICIENT_STORAGE)) {
            int a = C2517m.m12561a(C2517m.m12562a(AppContext.getInstance().getApplication().getApplicationContext()));
            C2507c.m12461b(a);
            int flags = logUpload.getFlags() & 1;
            int flags2 = logUpload.getFlags() & 2;
            int flags3 = logUpload.getFlags() & 4;
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] networkType=" + a + ", flagWifi=" + flags + ", flag3g=" + flags2 + ", flag2g=" + flags3);
            if (a == 1) {
                if (flags != 1) {
                    C2517m.m12582c(logUpload);
                    return;
                }
            } else if (a == 0 || !(flags2 == 2 || flags3 == 4)) {
                C2517m.m12582c(logUpload);
                return;
            }
        }
        int timeReconnect;
        switch (i) {
            case -3:
                timeReconnect = logUpload.getTimeReconnect() + 1;
                logUpload.setTimeReconnect(timeReconnect);
                if (timeReconnect <= 30) {
                    SystemClock.sleep(2000);
                    C2529l.m12613f(logUpload);
                    return;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming]  重试的次数超过30次");
                C2517m.m12582c(logUpload);
                return;
            case 200:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 发送成功result=" + i + ", type=" + logUpload.getType());
                logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                C2529l.m12606a(logUpload, true);
                return;
            case 201:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 处理断点续传 返回值为201");
                if (logUpload.getContentRange() == null) {
                    logUpload.setType(0);
                    C2529l.m12604a(C2529l.m12616i(logUpload), logUpload);
                    return;
                }
                String a2;
                synchronized (C2507c.f8987a) {
                    a2 = C2496a.m12415a(f9014b, String.valueOf(logUpload.getId()));
                }
                if ("1".equals(a2)) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] ID=" + logUpload.getId() + " 已暂停");
                    C2517m.m12582c(logUpload);
                    return;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] ID=" + logUpload.getId() + " 没有暂停");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 处理断点续传 返回值为201 range:" + logUpload.getContentRange());
                logUpload.setType(1);
                synchronized (C2507c.f8987a) {
                    C2496a.m12418a(f9014b, logUpload, false);
                }
                C2529l.m12604a(C2529l.m12616i(logUpload), logUpload);
                return;
            case HttpStatus.SC_BAD_REQUEST /*400*/:
            case HttpStatus.SC_FORBIDDEN /*403*/:
            case HttpStatus.SC_INSUFFICIENT_STORAGE /*507*/:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 返回值为result=" + i + ", type=" + logUpload.getType());
                C2517m.m12582c(logUpload);
                return;
            case HttpStatus.SC_UNAUTHORIZED /*401*/:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 鉴权失败，需要重新获取鉴权result=" + i + ", type=" + logUpload.getType());
                logUpload.setRefresh(true);
                timeReconnect = logUpload.getTimeAuthOverTime() + 1;
                logUpload.setTimeAuthOverTime(timeReconnect);
                if (timeReconnect <= 15) {
                    SystemClock.sleep(2000);
                    C2529l.m12612e(logUpload);
                    return;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 401");
                C2517m.m12582c(logUpload);
                return;
            case 408:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 服务器超时，重连");
                timeReconnect = logUpload.getTimeAuthOverTime() + 1;
                logUpload.setTimeAuthOverTime(timeReconnect);
                if (timeReconnect <= 15) {
                    SystemClock.sleep(2000);
                    C2529l.m12613f(logUpload);
                    return;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming]  408");
                C2517m.m12582c(logUpload);
                return;
            case 500:
            case HttpStatus.SC_BAD_GATEWAY /*502*/:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming] 服务器错误，5分钟重试result=" + i + ", type=" + logUpload.getType());
                timeReconnect = logUpload.getTimeAuthOverTime() + 1;
                logUpload.setTimeAuthOverTime(timeReconnect);
                if (timeReconnect <= 15) {
                    logUpload.setSetTime(true);
                    Timer timer = new Timer();
                    timer.schedule(new C2531n(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                    return;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming]  500,502");
                C2517m.m12582c(logUpload);
                return;
            case 789:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming]789, not valid wifi!");
                C2517m.m12582c(logUpload);
                return;
            default:
                return;
        }
    }

    private static void m12608b(int i, LogUpload logUpload) {
        boolean z = true;
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] result=" + i);
        int a = C2517m.m12561a(C2517m.m12562a(AppContext.getInstance().getApplication().getApplicationContext()));
        C2507c.m12461b(a);
        int flags = logUpload.getFlags() & 1;
        int flags2 = logUpload.getFlags() & 2;
        int flags3 = logUpload.getFlags() & 4;
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] networkType=" + a + ", flagWifi=" + flags + ", flag3g=" + flags2 + ", flag2g=" + flags3);
        Intent intent = new Intent();
        intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
        int timeReconnect;
        switch (i) {
            case -3:
                if (a != 1) {
                    if (a == 0 || !(flags2 == 2 || flags3 == 4)) {
                        C2517m.m12582c(logUpload);
                        z = false;
                        break;
                    }
                } else if (flags != 1) {
                    C2517m.m12582c(logUpload);
                    z = false;
                    break;
                }
                timeReconnect = logUpload.getTimeReconnect();
                C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.dealWithResult] timeReconnect:" + timeReconnect);
                timeReconnect++;
                logUpload.setTimeReconnect(timeReconnect);
                C2511g.m12484d("BETACLUB_SDK", "[UploadRequest.dealWithResult] timeReconnect=" + timeReconnect + "logUpload.getTimeReconnect() " + logUpload.getTimeReconnect());
                if (timeReconnect > 30) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 重试的次数超过30次");
                    C2517m.m12582c(logUpload);
                    break;
                }
                SystemClock.sleep(2000);
                C2529l.m12613f(logUpload);
                break;
            case -1:
                if (logUpload.getSize() < 1024000) {
                    C2529l.m12606a(logUpload, false);
                    break;
                }
                break;
            case 200:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 发送成功result=" + i + ", type=" + logUpload.getType());
                logUpload.setContentRange("[0," + String.valueOf(logUpload.getSize()) + "]");
                intent.putExtra("mLogUploadInfo", logUpload);
                AppContext.getInstance().getApplication().sendBroadcast(intent);
                C2529l.m12606a(logUpload, true);
                break;
            case HttpStatus.SC_BAD_REQUEST /*400*/:
            case HttpStatus.SC_INSUFFICIENT_STORAGE /*507*/:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 返回值为result=" + i + ", type=" + logUpload.getType());
                C2529l.m12606a(logUpload, false);
                break;
            case HttpStatus.SC_UNAUTHORIZED /*401*/:
            case HttpStatus.SC_FORBIDDEN /*403*/:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] networkType=" + a);
                if (a != 1) {
                    if (a == 0 || !(flags2 == 2 || flags3 == 4)) {
                        C2517m.m12582c(logUpload);
                        z = false;
                        break;
                    }
                } else if (flags != 1) {
                    C2517m.m12582c(logUpload);
                    z = false;
                    break;
                }
                a = logUpload.getTimeAuthOverTime() + 1;
                logUpload.setTimeAuthOverTime(a);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 鉴权失败，需要重新获取鉴权result=" + i + ", type=" + logUpload.getType());
                if (a > 15) {
                    C2517m.m12582c(logUpload);
                    z = false;
                    break;
                }
                logUpload.setRefresh(true);
                C2529l.m12612e(logUpload);
                break;
            case 408:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] networkType:" + a);
                if (a != 1) {
                    if (a == 0 || !(flags2 == 2 || flags3 == 4)) {
                        C2517m.m12582c(logUpload);
                        z = false;
                        break;
                    }
                } else if (flags != 1) {
                    C2517m.m12582c(logUpload);
                    z = false;
                    break;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 服务器超时，重连");
                timeReconnect = logUpload.getTimeAuthOverTime() + 1;
                logUpload.setTimeAuthOverTime(timeReconnect);
                if (timeReconnect > 15) {
                    C2517m.m12582c(logUpload);
                    break;
                }
                C2517m.m12570a(logUpload, 1);
                C2529l.m12613f(logUpload);
                break;
            case 500:
            case HttpStatus.SC_BAD_GATEWAY /*502*/:
                if (a != 1) {
                    if (a == 0 || !(flags2 == 2 || flags3 == 4)) {
                        C2517m.m12582c(logUpload);
                        z = false;
                        break;
                    }
                } else if (flags != 1) {
                    C2517m.m12582c(logUpload);
                    z = false;
                    break;
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 服务器错误，5分钟重试result=" + i + ", type=" + logUpload.getType());
                timeReconnect = logUpload.getTimeAuthOverTime() + 1;
                logUpload.setTimeAuthOverTime(timeReconnect);
                if (timeReconnect > 15) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResult] 500,502");
                    C2517m.m12582c(logUpload);
                    break;
                }
                logUpload.setSetTime(true);
                Timer timer = new Timer();
                timer.schedule(new C2532o(timer, logUpload), LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                break;
            case 789:
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.dealWithResultForResuming]789, not valid wifi!");
                C2517m.m12582c(logUpload);
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            C2517m.m12582c(logUpload);
        }
    }

    private static int m12616i(LogUpload logUpload) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] <>");
        File file = null;
        C2534q c2534q = new C2534q();
        int i = -1;
        if (logUpload == null) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] logUpload == null");
            return i;
        } else if (logUpload.isPaused()) {
            return 10000;
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] logUpload =" + logUpload.toString());
            if (StringUtils.isNullOrEmpty(logUpload.getSecret()) && !StringUtils.isNullOrEmpty(logUpload.getFilePath())) {
                C2511g.m12481b("BETACLUB_SDK", "Uploader mLogUploadInfo.getFilePath()=" + logUpload.getFilePath());
                file = new File(logUpload.getFilePath());
            }
            if (file == null && !StringUtils.isNullOrEmpty(logUpload.getEncryptedFile())) {
                C2511g.m12481b("BETACLUB_SDK", "Uploader mLogUploadInfo.getEncryptFile()=" + logUpload.getEncryptedFile());
                file = new File(logUpload.getEncryptedFile());
            }
            if (file == null && !StringUtils.isNullOrEmpty(logUpload.getFilePath())) {
                file = new File(logUpload.getFilePath());
            }
            if (file == null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] file == null");
                return i;
            } else if (file.exists()) {
                C2511g.m12481b("BETACLUB_SDK", file.getAbsolutePath());
                try {
                    return c2534q.m12641a(file, logUpload);
                } catch (SocketTimeoutException e) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] SocketTimeoutException");
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    if (logUpload.getTimeout() < 8) {
                        C2529l.m12617j(logUpload);
                        return i;
                    }
                    C2517m.m12582c(logUpload);
                    return i;
                } catch (Throwable e2) {
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    C2517m.m12582c(logUpload);
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.Uploader] HttpHostConnectException", e2);
                    return i;
                } catch (Throwable e22) {
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.Uploader] ConnectTimeoutException", e22);
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    if (logUpload.getTimeout() < 8) {
                        C2529l.m12617j(logUpload);
                        return i;
                    }
                    C2517m.m12582c(logUpload);
                    return i;
                } catch (Throwable e222) {
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    C2517m.m12582c(logUpload);
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.Uploader] UnsupportedEncodingException", e222);
                    return i;
                } catch (Throwable e2222) {
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    C2517m.m12582c(logUpload);
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.Uploader] ClientProtocolException", e2222);
                    return i;
                } catch (IOException e3) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] IOException");
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    C2517m.m12582c(logUpload);
                    return i;
                } catch (Throwable e22222) {
                    if (logUpload.getUserType() != 0) {
                        return -3;
                    }
                    C2517m.m12582c(logUpload);
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.Uploader] Exception", e22222);
                    return i;
                }
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.Uploader] 需要发送的文件不存在，退出");
                C2529l.m12606a(logUpload, false);
                return -2;
            }
        }
    }

    static void m12606a(LogUpload logUpload, boolean z) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.deleteTaskAndReport] succeed=" + z + ", getTaskId()=" + logUpload.getTaskId());
        Context applicationContext = AppContext.getInstance().getApplication().getApplicationContext();
        C2517m.m12569a(logUpload);
        C2517m.m12566a(applicationContext, logUpload, z);
        C2517m.m12582c(logUpload);
        synchronized (C2507c.f8987a) {
            C2496a.m12421b(f9014b, logUpload);
        }
        synchronized (C2507c.f8987a) {
            f9013a = C2496a.m12414a(f9014b);
        }
        if (f9013a != null) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.deleteTaskAndReport] lstUploadInfo.size()=" + f9013a.size());
        }
    }

    private static void m12617j(LogUpload logUpload) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.handlerConnectionTimeOut] The times of timeount is=" + logUpload.getTimeout());
        logUpload.setTimeout(logUpload.getTimeout() + 1);
        C2529l.m12616i(logUpload);
    }

    public static boolean m12607a() {
        synchronized (C2507c.f8987a) {
            f9013a = C2496a.m12414a(f9014b);
        }
        if (f9013a != null) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.isTaskProcessing] lstUploadInfo.size()=" + f9013a.size());
        }
        if (f9013a == null || f9013a.size() <= 0) {
            return false;
        }
        for (int i = 0; i < f9013a.size(); i++) {
            if (C2517m.m12576b((LogUpload) f9013a.valueAt(i)) == 1) {
                return true;
            }
        }
        return false;
    }

    public static void m12614g(LogUpload logUpload) {
        Closeable dataOutputStream;
        Closeable inputStream;
        String stringBuffer;
        Throwable e;
        C2533p c2533p;
        Closeable closeable = null;
        try {
            System.setProperty("http.keepAlive", "false");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://192.168.111.5:8080/osgFileServlet/upload").openConnection();
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setChunkedStreamingMode(1024000);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------40612316912668");
            httpURLConnection.setChunkedStreamingMode(1024000);
            httpURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
            httpURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] addLogServiceField");
                C2527j.m12601a(dataOutputStream, logUpload.getFilePath());
                C2527j.m12602a(dataOutputStream);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] dos.flush()");
                dataOutputStream.flush();
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] urlConnection.getInputStream()");
                inputStream = httpURLConnection.getInputStream();
                try {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        stringBuffer2.append(new String(bArr, 0, read, "utf-8"));
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 读取" + new String(bArr, 0, read, "utf-8"));
                    }
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 读取完毕");
                    stringBuffer = stringBuffer2.toString();
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 读取完成 " + stringBuffer);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
                    C2517m.m12571a(inputStream, "BETACLUB_SDK");
                    C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
                } catch (RuntimeException e2) {
                    e = e2;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (RuntimeException e4) {
                e = e4;
                inputStream = null;
                try {
                    C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] RuntimeException ", e);
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
                    C2517m.m12571a(inputStream, "BETACLUB_SDK");
                    C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
                    if (stringBuffer != null) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] response: " + stringBuffer);
                    }
                    c2533p = new C2533p();
                    if (c2533p.m12621b(stringBuffer) != 0) {
                    }
                    if (1 == c2533p.m12636i()) {
                        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 异常情况");
                        C2517m.m12582c(logUpload);
                    }
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 数据发送失败");
                    C2517m.m12582c(logUpload);
                } catch (Throwable th) {
                    e = th;
                    closeable = inputStream;
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
                    C2517m.m12571a(closeable, "BETACLUB_SDK");
                    C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
                C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] Exception ", e);
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
                C2517m.m12571a(inputStream, "BETACLUB_SDK");
                C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
                if (stringBuffer != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] response: " + stringBuffer);
                }
                c2533p = new C2533p();
                if (c2533p.m12621b(stringBuffer) != 0) {
                }
                if (1 == c2533p.m12636i()) {
                    C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 数据发送失败");
                    C2517m.m12582c(logUpload);
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 异常情况");
                C2517m.m12582c(logUpload);
            } catch (Throwable th2) {
                e = th2;
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
                C2517m.m12571a(closeable, "BETACLUB_SDK");
                C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
                throw e;
            }
        } catch (RuntimeException e6) {
            e = e6;
            inputStream = null;
            dataOutputStream = null;
            C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] RuntimeException ", e);
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
            C2517m.m12571a(inputStream, "BETACLUB_SDK");
            C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
            if (stringBuffer != null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] response: " + stringBuffer);
            }
            c2533p = new C2533p();
            if (c2533p.m12621b(stringBuffer) != 0) {
            }
            if (1 == c2533p.m12636i()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 异常情况");
                C2517m.m12582c(logUpload);
            }
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 数据发送失败");
            C2517m.m12582c(logUpload);
        } catch (Exception e7) {
            e = e7;
            inputStream = null;
            dataOutputStream = null;
            C2511g.m12482b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] Exception ", e);
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
            C2517m.m12571a(inputStream, "BETACLUB_SDK");
            C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
            if (stringBuffer != null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] response: " + stringBuffer);
            }
            c2533p = new C2533p();
            if (c2533p.m12621b(stringBuffer) != 0) {
            }
            if (1 == c2533p.m12636i()) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 数据发送失败");
                C2517m.m12582c(logUpload);
            }
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 异常情况");
            C2517m.m12582c(logUpload);
        } catch (Throwable th3) {
            e = th3;
            dataOutputStream = null;
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] finally close ");
            C2517m.m12571a(closeable, "BETACLUB_SDK");
            C2517m.m12571a(dataOutputStream, "BETACLUB_SDK");
            throw e;
        }
        if (stringBuffer != null) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] response: " + stringBuffer);
        }
        c2533p = new C2533p();
        if (c2533p.m12621b(stringBuffer) != 0 && c2533p.m12636i() == 0) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 日志分发服务器结果解析正确,数据成功发送");
            C2529l.m12606a(logUpload, true);
        } else if (1 == c2533p.m12636i()) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 数据发送失败");
            C2517m.m12582c(logUpload);
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.uploadToInnerNet] 异常情况");
            C2517m.m12582c(logUpload);
        }
    }
}
