package com.huawei.feedback.logic;

import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.feedback.bean.C4410d;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import com.huawei.phoneserviceuni.common.p493b.C5759a;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: SendFeedbackScore */
public class C4424o implements Runnable {
    private C4410d f16427a;

    public C4424o(C4410d c4410d) {
        this.f16427a = c4410d;
    }

    public void run() {
        DataOutputStream dataOutputStream;
        String stringBuffer;
        InputStream inputStream;
        DataOutputStream dataOutputStream2;
        C4417h c4417h;
        Throwable th;
        InputStream inputStream2 = null;
        C5759a.m26446a();
        InputStream inputStream3;
        try {
            System.setProperty("http.keepAlive", "false");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://iservice.vmall.com:8081/osg/feedbackAction!addAnswerScore.htm").openConnection();
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------40612316912668");
            httpURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
            httpURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                C4426q.m21279b("questionId", this.f16427a.m21218l(), dataOutputStream);
                c.a("sendFeedbackScore", "feedbackInfo.getQuestionId()" + this.f16427a.m21218l());
                C4426q.m21279b(WBConstants.GAME_PARAMS_SCORE, Integer.toString(this.f16427a.m21235x()), dataOutputStream);
                C4426q.m21274a(dataOutputStream);
                dataOutputStream.flush();
                inputStream3 = httpURLConnection.getInputStream();
                try {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream3.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        stringBuffer2.append(new String(bArr, 0, read, "utf-8"));
                    }
                    c.a("sendFeedbackScore", "read over");
                    stringBuffer = stringBuffer2.toString();
                    C5767b.m26475a(inputStream3, "sendFeedbackScore");
                    C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
                } catch (RuntimeException e) {
                    inputStream = inputStream3;
                    dataOutputStream2 = dataOutputStream;
                } catch (ConnectTimeoutException e2) {
                } catch (Exception e3) {
                }
            } catch (RuntimeException e4) {
                inputStream = null;
                dataOutputStream2 = dataOutputStream;
                try {
                    c.d("sendFeedbackScore", "RuntimeException");
                    C5767b.m26475a(inputStream, "sendFeedbackScore");
                    C5767b.m26472a(dataOutputStream2, "sendFeedbackScore");
                    stringBuffer = null;
                    c4417h = new C4417h();
                    if (c4417h.m21262a(stringBuffer) == 0) {
                    }
                    c.a("sendFeedbackScore", "handler FAIL");
                } catch (Throwable th2) {
                    dataOutputStream = dataOutputStream2;
                    InputStream inputStream4 = inputStream;
                    th = th2;
                    inputStream2 = inputStream4;
                    C5767b.m26475a(inputStream2, "sendFeedbackScore");
                    C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
                    throw th;
                }
            } catch (ConnectTimeoutException e5) {
                inputStream3 = null;
                try {
                    c.d("sendFeedbackScore", "ConnectTimeoutException ...");
                    C5767b.m26475a(inputStream3, "sendFeedbackScore");
                    C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
                    stringBuffer = null;
                    c4417h = new C4417h();
                    if (c4417h.m21262a(stringBuffer) == 0) {
                    }
                    c.a("sendFeedbackScore", "handler FAIL");
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = inputStream3;
                    C5767b.m26475a(inputStream2, "sendFeedbackScore");
                    C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
                    throw th;
                }
            } catch (Exception e6) {
                inputStream3 = null;
                c.d("sendFeedbackScore", "connect unkown Exception ...");
                C5767b.m26475a(inputStream3, "sendFeedbackScore");
                C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
                stringBuffer = null;
                c4417h = new C4417h();
                if (c4417h.m21262a(stringBuffer) == 0) {
                }
                c.a("sendFeedbackScore", "handler FAIL");
            } catch (Throwable th4) {
                th = th4;
                C5767b.m26475a(inputStream2, "sendFeedbackScore");
                C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
                throw th;
            }
        } catch (RuntimeException e7) {
            inputStream = null;
            dataOutputStream2 = null;
            c.d("sendFeedbackScore", "RuntimeException");
            C5767b.m26475a(inputStream, "sendFeedbackScore");
            C5767b.m26472a(dataOutputStream2, "sendFeedbackScore");
            stringBuffer = null;
            c4417h = new C4417h();
            if (c4417h.m21262a(stringBuffer) == 0) {
            }
            c.a("sendFeedbackScore", "handler FAIL");
        } catch (ConnectTimeoutException e8) {
            inputStream3 = null;
            dataOutputStream = null;
            c.d("sendFeedbackScore", "ConnectTimeoutException ...");
            C5767b.m26475a(inputStream3, "sendFeedbackScore");
            C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
            stringBuffer = null;
            c4417h = new C4417h();
            if (c4417h.m21262a(stringBuffer) == 0) {
            }
            c.a("sendFeedbackScore", "handler FAIL");
        } catch (Exception e9) {
            inputStream3 = null;
            dataOutputStream = null;
            c.d("sendFeedbackScore", "connect unkown Exception ...");
            C5767b.m26475a(inputStream3, "sendFeedbackScore");
            C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
            stringBuffer = null;
            c4417h = new C4417h();
            if (c4417h.m21262a(stringBuffer) == 0) {
            }
            c.a("sendFeedbackScore", "handler FAIL");
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            C5767b.m26475a(inputStream2, "sendFeedbackScore");
            C5767b.m26472a(dataOutputStream, "sendFeedbackScore");
            throw th;
        }
        c4417h = new C4417h();
        if (c4417h.m21262a(stringBuffer) == 0 || c4417h.m21261a() != 0) {
            c.a("sendFeedbackScore", "handler FAIL");
        } else {
            c.a("sendFeedbackScore", "handler SUCCESS");
        }
    }
}
