package com.huawei.android.pushagent.plugin.tools.p335b;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p018c.p019a.C4105g;
import com.huawei.android.pushagent.p018c.p019a.C4106i;
import com.huawei.android.pushagent.plugin.p331a.C4125a;
import com.huawei.android.pushagent.plugin.p331a.C4127c;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy.Type;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class C4145a {

    class C4143a {
        private static String f15549a = "http://";
        private static String f15550b = "pushaix.hicloud.com";
        private static String f15551c = "80";
        private static String f15552d = "/report";
    }

    class C4144b {
        private static String f15553a = "https://";
        private static String f15554b = "pushaix.hicloud.com";
        private static String f15555c = "443";
        private static String f15556d = "/getSalt";
    }

    private static String m20240a(Context context, int i, String str) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        e.a("PushLogSC2712", "httpRequest requestType is " + i);
        InputStream inputStream2 = null;
        BufferedReader bufferedReader = null;
        HttpURLConnection a;
        try {
            a = C4145a.m20244a(context, i, false, true, str);
            if (a == null) {
                try {
                    a = C4145a.m20244a(context, i, false, false, str);
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = null;
                    inputStream = null;
                    try {
                        e.a("PushLogSC2712", "connect url err:" + e.toString(), e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e3) {
                                e.a("PushLogSC2712", "close is err:" + e3.toString(), e3);
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (a == null) {
                            return null;
                        }
                        a.disconnect();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e32) {
                                e.a("PushLogSC2712", "close is err:" + e32.toString(), e32);
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable e322) {
                    bufferedReader = null;
                    inputStream = null;
                    th = e322;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw th;
                }
            }
            if (a == null) {
                a = C4145a.m20244a(context, i, true, false, str);
            }
            if (a == null) {
                a = C4145a.m20244a(context, i, true, true, str);
            }
            if (a == null) {
                e.b("PushLogSC2712", "get conn failed");
                if (null != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e3222) {
                        e.a("PushLogSC2712", "close is err:" + e3222.toString(), e3222);
                    }
                }
                if (null != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e422) {
                        e422.printStackTrace();
                    }
                }
                if (a == null) {
                    return null;
                }
                a.disconnect();
                return null;
            }
            e.b("PushLogSC2712", "get conn success");
            inputStream = a.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, GameManager.DEFAULT_CHARSET));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                e.a("PushLogSC2712", "close is err:" + th3.toString(), th3);
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        return readLine;
                    }
                    e.b("PushLogSC2712", "response is null");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32222) {
                            e.a("PushLogSC2712", "close is err:" + e32222.toString(), e32222);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4222) {
                            e4222.printStackTrace();
                        }
                    }
                    if (a == null) {
                        return null;
                    }
                    a.disconnect();
                    return null;
                } catch (IOException e6) {
                    e32222 = e6;
                    e.a("PushLogSC2712", "connect url err:" + e32222.toString(), e32222);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (a == null) {
                        return null;
                    }
                    a.disconnect();
                    return null;
                }
            } catch (IOException e7) {
                e32222 = e7;
                bufferedReader = null;
                e.a("PushLogSC2712", "connect url err:" + e32222.toString(), e32222);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (a == null) {
                    return null;
                }
                a.disconnect();
                return null;
            } catch (Throwable e322222) {
                bufferedReader = null;
                th3 = e322222;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                throw th3;
            }
        } catch (IOException e8) {
            e322222 = e8;
            a = null;
            bufferedReader = null;
            inputStream = null;
            e.a("PushLogSC2712", "connect url err:" + e322222.toString(), e322222);
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (a == null) {
                return null;
            }
            a.disconnect();
            return null;
        } catch (Throwable e3222222) {
            a = null;
            bufferedReader = null;
            inputStream = null;
            th3 = e3222222;
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (a != null) {
                a.disconnect();
            }
            throw th3;
        }
    }

    public static String m20241a(Context context, C4127c c4127c) {
        return C4145a.m20240a(context, 2, c4127c.m20184a(context));
    }

    public static String m20242a(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SNBConstant.FIELD_TOKEN).append("=").append(str).append(SNBConstant.FILTER).append("securityAlg").append("=").append(2);
        return C4145a.m20240a(context, 1, stringBuffer.toString());
    }

    private static String m20243a(Context context, boolean z) {
        String a = C4144b.f15554b;
        String b = C4144b.f15555c;
        String c = C4144b.f15556d;
        StringBuffer stringBuffer = new StringBuffer();
        return z ? stringBuffer.append(C4144b.f15553a).append(a).append(":").append(b).append(c).toString() : stringBuffer.append(C4144b.f15553a).append(a).append(c).toString();
    }

    private static HttpURLConnection m20244a(Context context, int i, boolean z, boolean z2, String str) {
        HttpURLConnection httpURLConnection;
        Throwable e;
        HttpURLConnection httpURLConnection2;
        byte[] bytes;
        OutputStream outputStream;
        Throwable e2;
        int responseCode;
        MalformedURLException malformedURLException;
        Throwable th;
        Object obj = 1;
        if (1 == i) {
            try {
                C4145a.m20245a(context);
                String a = C4145a.m20243a(context, z2);
            } catch (MalformedURLException e3) {
                MalformedURLException e4 = e3;
                httpURLConnection = null;
                e.d("PushLogSC2712", "connect to srv cause MalformedURLException:" + e4.toString());
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e5) {
                        e.c("PushLogSC2712", "close connection cause Exception:" + e5.toString(), e5);
                    }
                }
                return null;
            } catch (IOException e6) {
                e5 = e6;
                httpURLConnection = null;
                e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            } catch (NullPointerException e7) {
                e5 = e7;
                httpURLConnection = null;
                e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            } catch (IllegalArgumentException e8) {
                e5 = e8;
                httpURLConnection = null;
                e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            } catch (UnsupportedOperationException e9) {
                e5 = e9;
                httpURLConnection = null;
                e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
        }
        a = C4145a.m20246b(context, z2);
        if (z && 1 != C4103b.m20122a(context)) {
            String property;
            int parseInt;
            if (VERSION.SDK_INT < 11) {
                obj = null;
            }
            if (obj != null) {
                property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                parseInt = Integer.parseInt(property2);
            } else {
                property = Proxy.getHost(context);
                parseInt = Proxy.getPort(context);
            }
            if (property == null || property.length() <= 0 || parseInt == -1) {
                e.b("PushLogSC2712", "proxy param invalid");
            } else {
                e.b("PushLogSC2712", "use Proxy " + property + ":" + parseInt + " to open:" + a);
                httpURLConnection = (HttpURLConnection) new URL(a).openConnection(new java.net.Proxy(Type.HTTP, new InetSocketAddress(property, parseInt)));
                if (httpURLConnection != null) {
                    try {
                        e.a("PushLogSC2712", "direct to open " + a);
                        httpURLConnection2 = (HttpURLConnection) new URL(a).openConnection();
                    } catch (MalformedURLException e10) {
                        e4 = e10;
                        e.d("PushLogSC2712", "connect to srv cause MalformedURLException:" + e4.toString());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (IOException e11) {
                        e5 = e11;
                        e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (NullPointerException e12) {
                        e5 = e12;
                        e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (IllegalArgumentException e13) {
                        e5 = e13;
                        e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (UnsupportedOperationException e14) {
                        e5 = e14;
                        e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                }
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    httpURLConnection2 = (HttpsURLConnection) httpURLConnection2;
                }
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setReadTimeout(20000);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    if (!TextUtils.isEmpty(str)) {
                        bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
                        try {
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                outputStream.write(bytes);
                                outputStream.flush();
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e22) {
                                        e.c("PushLogSC2712", "connect to srv cause IOException:" + e22.toString(), e22);
                                    }
                                }
                            } catch (Exception e15) {
                                e22 = e15;
                                try {
                                    e.c("PushLogSC2712", "connect to srv cause IOException:" + e22.toString(), e22);
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Throwable e222) {
                                            e.c("PushLogSC2712", "connect to srv cause IOException:" + e222.toString(), e222);
                                        }
                                    }
                                    httpURLConnection2.connect();
                                    responseCode = httpURLConnection2.getResponseCode();
                                    e.a("PushLogSC2712", "httpRequest responseCode is " + responseCode + "/" + httpURLConnection2.getResponseMessage());
                                    return httpURLConnection2;
                                } catch (Throwable th2) {
                                    e222 = th2;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Throwable e16) {
                                            e.c("PushLogSC2712", "connect to srv cause IOException:" + e16.toString(), e16);
                                        }
                                    }
                                    throw e222;
                                }
                            }
                        } catch (Exception e17) {
                            e222 = e17;
                            outputStream = null;
                            e.c("PushLogSC2712", "connect to srv cause IOException:" + e222.toString(), e222);
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            httpURLConnection2.connect();
                            responseCode = httpURLConnection2.getResponseCode();
                            e.a("PushLogSC2712", "httpRequest responseCode is " + responseCode + "/" + httpURLConnection2.getResponseMessage());
                            return httpURLConnection2;
                        } catch (Throwable th3) {
                            e222 = th3;
                            outputStream = null;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            throw e222;
                        }
                    }
                    httpURLConnection2.connect();
                    responseCode = httpURLConnection2.getResponseCode();
                    e.a("PushLogSC2712", "httpRequest responseCode is " + responseCode + "/" + httpURLConnection2.getResponseMessage());
                    return httpURLConnection2;
                } catch (MalformedURLException e18) {
                    malformedURLException = e18;
                    httpURLConnection = httpURLConnection2;
                    e4 = malformedURLException;
                } catch (Throwable e2222) {
                    th = e2222;
                    httpURLConnection = httpURLConnection2;
                    e5 = th;
                    e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable e22222) {
                    th = e22222;
                    httpURLConnection = httpURLConnection2;
                    e5 = th;
                    e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable e222222) {
                    th = e222222;
                    httpURLConnection = httpURLConnection2;
                    e5 = th;
                    e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable e2222222) {
                    th = e2222222;
                    httpURLConnection = httpURLConnection2;
                    e5 = th;
                    e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
            }
        }
        httpURLConnection = null;
        if (httpURLConnection != null) {
            httpURLConnection2 = httpURLConnection;
        } else {
            e.a("PushLogSC2712", "direct to open " + a);
            httpURLConnection2 = (HttpURLConnection) new URL(a).openConnection();
        }
        try {
            if (httpURLConnection2 instanceof HttpsURLConnection) {
                httpURLConnection2 = (HttpsURLConnection) httpURLConnection2;
            }
            httpURLConnection2.setConnectTimeout(30000);
            httpURLConnection2.setReadTimeout(20000);
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setDoInput(true);
            if (TextUtils.isEmpty(str)) {
                bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
                outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            httpURLConnection2.connect();
            responseCode = httpURLConnection2.getResponseCode();
            e.a("PushLogSC2712", "httpRequest responseCode is " + responseCode + "/" + httpURLConnection2.getResponseMessage());
            return httpURLConnection2;
        } catch (MalformedURLException e182) {
            malformedURLException = e182;
            httpURLConnection = httpURLConnection2;
            e4 = malformedURLException;
            e.d("PushLogSC2712", "connect to srv cause MalformedURLException:" + e4.toString());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable e22222222) {
            th = e22222222;
            httpURLConnection = httpURLConnection2;
            e5 = th;
            e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable e222222222) {
            th = e222222222;
            httpURLConnection = httpURLConnection2;
            e5 = th;
            e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable e2222222222) {
            th = e2222222222;
            httpURLConnection = httpURLConnection2;
            e5 = th;
            e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable e22222222222) {
            th = e22222222222;
            httpURLConnection = httpURLConnection2;
            e5 = th;
            e.c("PushLogSC2712", "connect to srv cause IOException:" + e5.toString(), e5);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        }
    }

    private static void m20245a(Context context) {
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
            instance.init(null, new TrustManager[]{new C4106i(context)}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(new C4105g(instance.getSocketFactory()));
            HttpsURLConnection.setDefaultHostnameVerifier(new C4146b());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private static String m20246b(Context context, boolean z) {
        String a = C4143a.f15550b;
        String b = C4143a.f15551c;
        String c = C4143a.f15552d;
        StringBuffer stringBuffer = new StringBuffer();
        int c2 = new C4125a(context).m20177c();
        if (c2 > 0 && a.contains("pushaix")) {
            int indexOf = C4143a.f15550b.indexOf(".");
            a = C4143a.f15550b.substring(0, indexOf) + c2 + C4143a.f15550b.substring(indexOf);
        }
        return z ? stringBuffer.append(C4143a.f15549a).append(a).append(":").append(b).append(c).toString() : stringBuffer.append(C4143a.f15549a).append(a).append(c).toString();
    }
}
