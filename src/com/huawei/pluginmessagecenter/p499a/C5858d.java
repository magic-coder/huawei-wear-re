package com.huawei.pluginmessagecenter.p499a;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hwcommonmodel.p064d.C4730i;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import com.snowballtech.common.code.WSBaseMessageCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HttpUtils */
public class C5858d {
    private static Context f20116a = null;
    private static ExecutorService f20117b = Executors.newFixedThreadPool(5);

    public static void m27011a(String str, String str2, Map<String, String> map, C5857c c5857c) {
        f20117b.execute(new C5859e(str, str2, map, c5857c));
    }

    public static void m27013a(HttpsURLConnection httpsURLConnection) {
        SSLSocketFactory c4730i;
        try {
            c4730i = new C4730i();
        } catch (KeyManagementException e) {
            C5861g.m27023b("HttpUtils", "initHttpsURLConnection KeyManagementException e = " + e.getMessage());
            c4730i = null;
        } catch (NoSuchAlgorithmException e2) {
            C5861g.m27023b("HttpUtils", "initHttpsURLConnection NoSuchAlgorithmException e = " + e2.getMessage());
            c4730i = null;
        } catch (KeyStoreException e3) {
            C5861g.m27023b("HttpUtils", "initHttpsURLConnection KeyStoreException e = " + e3.getMessage());
            c4730i = null;
        } catch (UnrecoverableKeyException e4) {
            C5861g.m27023b("HttpUtils", "initHttpsURLConnection UnrecoverableKeyException e = " + e4.getMessage());
            c4730i = null;
        } catch (IOException e5) {
            C5861g.m27023b("HttpUtils", "initHttpsURLConnection IOException e = " + e5.getMessage());
            c4730i = null;
        }
        if (c4730i != null) {
            httpsURLConnection.setSSLSocketFactory(c4730i);
        }
        httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private static boolean m27014a(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    private static void m27010a(C5857c c5857c, int i) {
        if (c5857c != null) {
            c5857c.mo5123a(i);
        }
    }

    private static HttpURLConnection m27015b(String str) throws IOException {
        URL url = new URL(str);
        if (url == null) {
            return null;
        }
        C5861g.m27024c("HttpUtils", "doGet===" + url.toString());
        if (url.getProtocol() == null || !"https".equals(url.getProtocol().toLowerCase())) {
            return (HttpURLConnection) url.openConnection();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        C5858d.m27013a(httpsURLConnection);
        return httpsURLConnection;
    }

    private static void m27009a(int i, String str, int i2, C5857c c5857c) {
        if (i == 200) {
            C5860f c = C5858d.m27017c(str);
            if (c == null) {
                C5858d.m27010a(c5857c, i2);
                return;
            } else if (c.m27019a() == 0) {
                String b = c.m27020b();
                if (c5857c != null) {
                    c5857c.mo5124a(b);
                    return;
                }
                return;
            } else {
                C5858d.m27010a(c5857c, i2);
                return;
            }
        }
        C5858d.m27010a(c5857c, i2);
    }

    private static void m27018c(String str, String str2, Map<String, String> map, C5857c c5857c) {
        HttpURLConnection b;
        OutputStreamWriter outputStreamWriter;
        PrintWriter printWriter;
        MalformedURLException e;
        PrintWriter printWriter2;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        ProtocolException e2;
        IOException e3;
        Reader inputStreamReader;
        Reader reader;
        InputStreamReader inputStreamReader2 = null;
        if (!C5858d.m27014a(str)) {
            String str3 = "";
            String str4 = (String) map.get("huid");
            String str5 = (String) map.get("version");
            try {
                b = C5858d.m27015b(str);
                try {
                    int responseCode;
                    b.setRequestMethod(HttpPost.METHOD_NAME);
                    b.setRequestProperty("accept", "*/*");
                    b.setRequestProperty("connection", "Keep-Alive");
                    b.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                    b.setRequestProperty(SNBConstant.FIELD_CHARSET, "utf-8");
                    b.setRequestProperty("x-huid", str4);
                    b.setRequestProperty("x-version", str5);
                    b.setRequestProperty(WSBaseMessageCode.HEADER_DATE, String.valueOf(SystemClock.currentThreadTimeMillis()));
                    b.setUseCaches(false);
                    b.setDoOutput(true);
                    b.setDoInput(true);
                    b.setReadTimeout(10000);
                    b.setConnectTimeout(10000);
                    if (str2 == null || str2.trim().equals("")) {
                        outputStreamWriter = null;
                        printWriter = null;
                    } else {
                        outputStreamWriter = new OutputStreamWriter(b.getOutputStream(), GameManager.DEFAULT_CHARSET);
                        try {
                            PrintWriter printWriter3 = new PrintWriter(outputStreamWriter);
                            try {
                                printWriter3.print(str2);
                                printWriter3.flush();
                                printWriter = printWriter3;
                            } catch (MalformedURLException e4) {
                                e = e4;
                                printWriter2 = printWriter3;
                                httpURLConnection = b;
                                bufferedReader = null;
                                try {
                                    C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                                    C5858d.m27010a(c5857c, -1);
                                    C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
                                } catch (Throwable th2) {
                                    th = th2;
                                    b = httpURLConnection;
                                    printWriter = printWriter2;
                                    bufferedReader2 = bufferedReader;
                                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                                    throw th;
                                }
                            } catch (ProtocolException e5) {
                                e2 = e5;
                                bufferedReader2 = null;
                                printWriter = printWriter3;
                                try {
                                    C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                                    C5858d.m27010a(c5857c, -1);
                                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                                } catch (Throwable th3) {
                                    th = th3;
                                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e3 = e6;
                                bufferedReader2 = null;
                                printWriter = printWriter3;
                                C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                                C5858d.m27010a(c5857c, -1);
                                C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader2 = null;
                                printWriter = printWriter3;
                                C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                                throw th;
                            }
                        } catch (MalformedURLException e7) {
                            e = e7;
                            bufferedReader = null;
                            printWriter2 = null;
                            httpURLConnection = b;
                            C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                            C5858d.m27010a(c5857c, -1);
                            C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
                        } catch (ProtocolException e8) {
                            e2 = e8;
                            bufferedReader2 = null;
                            printWriter = null;
                            C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                            C5858d.m27010a(c5857c, -1);
                            C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                        } catch (IOException e9) {
                            e3 = e9;
                            bufferedReader2 = null;
                            printWriter = null;
                            C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                            C5858d.m27010a(c5857c, -1);
                            C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = null;
                            printWriter = null;
                            C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                            throw th;
                        }
                    }
                    try {
                        b.connect();
                        responseCode = b.getResponseCode();
                        C5861g.m27024c("HttpUtils", "responseCode == " + responseCode);
                        inputStreamReader = new InputStreamReader(b.getInputStream(), GameManager.DEFAULT_CHARSET);
                    } catch (MalformedURLException e10) {
                        e = e10;
                        bufferedReader = null;
                        printWriter2 = printWriter;
                        httpURLConnection = b;
                        C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                        C5858d.m27010a(c5857c, -1);
                        C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
                    } catch (ProtocolException e11) {
                        e2 = e11;
                        bufferedReader2 = null;
                        C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                        C5858d.m27010a(c5857c, -1);
                        C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                    } catch (IOException e12) {
                        e3 = e12;
                        bufferedReader2 = null;
                        C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                        C5858d.m27010a(c5857c, -1);
                        C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader2 = null;
                        C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                        throw th;
                    }
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    stringBuffer.append(readLine);
                                } else {
                                    String str6 = str3 + stringBuffer.toString();
                                    C5861g.m27024c("HttpUtils", "result == " + str6);
                                    C5858d.m27009a(responseCode, str6, -1, c5857c);
                                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader, outputStreamWriter);
                                    return;
                                }
                            }
                        } catch (MalformedURLException e13) {
                            e = e13;
                            inputStreamReader2 = inputStreamReader;
                            bufferedReader = bufferedReader2;
                            printWriter2 = printWriter;
                            httpURLConnection = b;
                            C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                            C5858d.m27010a(c5857c, -1);
                            C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
                        } catch (ProtocolException e14) {
                            e2 = e14;
                            reader = inputStreamReader;
                            C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                            C5858d.m27010a(c5857c, -1);
                            C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                        } catch (IOException e15) {
                            e3 = e15;
                            reader = inputStreamReader;
                            C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                            C5858d.m27010a(c5857c, -1);
                            C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                        } catch (Throwable th7) {
                            th = th7;
                            reader = inputStreamReader;
                            C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                            throw th;
                        }
                    } catch (MalformedURLException e16) {
                        e = e16;
                        printWriter2 = printWriter;
                        httpURLConnection = b;
                        Reader reader2 = inputStreamReader;
                        bufferedReader = null;
                        reader = reader2;
                        C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                        C5858d.m27010a(c5857c, -1);
                        C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
                    } catch (ProtocolException e17) {
                        e2 = e17;
                        bufferedReader2 = null;
                        reader = inputStreamReader;
                        C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                        C5858d.m27010a(c5857c, -1);
                        C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                    } catch (IOException e18) {
                        e3 = e18;
                        bufferedReader2 = null;
                        reader = inputStreamReader;
                        C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                        C5858d.m27010a(c5857c, -1);
                        C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedReader2 = null;
                        reader = inputStreamReader;
                        C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                        throw th;
                    }
                } catch (MalformedURLException e19) {
                    e = e19;
                    outputStreamWriter = null;
                    bufferedReader = null;
                    printWriter2 = null;
                    httpURLConnection = b;
                    C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                    C5858d.m27010a(c5857c, -1);
                    C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
                } catch (ProtocolException e20) {
                    e2 = e20;
                    outputStreamWriter = null;
                    bufferedReader2 = null;
                    printWriter = null;
                    C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                    C5858d.m27010a(c5857c, -1);
                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                } catch (IOException e21) {
                    e3 = e21;
                    outputStreamWriter = null;
                    bufferedReader2 = null;
                    printWriter = null;
                    C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                    C5858d.m27010a(c5857c, -1);
                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                } catch (Throwable th9) {
                    th = th9;
                    outputStreamWriter = null;
                    bufferedReader2 = null;
                    printWriter = null;
                    C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                    throw th;
                }
            } catch (MalformedURLException e22) {
                e = e22;
                outputStreamWriter = null;
                bufferedReader = null;
                printWriter2 = null;
                httpURLConnection = null;
                C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
                C5858d.m27010a(c5857c, -1);
                C5858d.m27012a(httpURLConnection, printWriter2, bufferedReader, inputStreamReader2, outputStreamWriter);
            } catch (ProtocolException e23) {
                e2 = e23;
                outputStreamWriter = null;
                bufferedReader2 = null;
                printWriter = null;
                b = null;
                C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
                C5858d.m27010a(c5857c, -1);
                C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
            } catch (IOException e24) {
                e3 = e24;
                outputStreamWriter = null;
                bufferedReader2 = null;
                printWriter = null;
                b = null;
                C5861g.m27024c("HttpUtils", "doPost=======" + e3.getMessage());
                C5858d.m27010a(c5857c, -1);
                C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
            } catch (Throwable th10) {
                th = th10;
                outputStreamWriter = null;
                bufferedReader2 = null;
                printWriter = null;
                b = null;
                C5858d.m27012a(b, printWriter, bufferedReader2, inputStreamReader2, outputStreamWriter);
                throw th;
            }
        }
    }

    private static void m27012a(HttpURLConnection httpURLConnection, PrintWriter printWriter, BufferedReader bufferedReader, InputStreamReader inputStreamReader, OutputStreamWriter outputStreamWriter) {
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                C5861g.m27024c("HttpUtils", "doPost=======" + e.getMessage());
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                C5861g.m27024c("HttpUtils", "doPost=======" + e2.getMessage());
            }
        }
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (IOException e22) {
                C5861g.m27024c("HttpUtils", "doPost=======" + e22.getMessage());
            }
        }
        if (printWriter != null) {
            printWriter.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (f20116a != null) {
            f20116a = null;
        }
    }

    private static C5860f m27017c(String str) {
        C5860f c5860f;
        JSONException e;
        try {
            String str2;
            JSONObject jSONObject = new JSONObject(str);
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (jSONObject.isNull("resultCode")) {
                str2 = str3;
            } else {
                str2 = jSONObject.getString("resultCode");
            }
            if (jSONObject.isNull("resultDesc")) {
                str3 = str4;
            } else {
                str3 = jSONObject.getString("resultDesc");
            }
            if (jSONObject.isNull("messages")) {
                str4 = str5;
            } else {
                str4 = jSONObject.getString("messages");
            }
            c5860f = new C5860f(Integer.parseInt(str2), str3, str4);
            try {
                C5861g.m27024c("HttpUtils", "resResult = " + c5860f.toString());
            } catch (JSONException e2) {
                e = e2;
                C5861g.m27024c("HttpUtils", "parseResult() ==> JSONException");
                C5861g.m27024c("HttpUtils", "parseResult=======" + e.getMessage());
                return c5860f;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            c5860f = null;
            e = jSONException;
            C5861g.m27024c("HttpUtils", "parseResult() ==> JSONException");
            C5861g.m27024c("HttpUtils", "parseResult=======" + e.getMessage());
            return c5860f;
        }
        return c5860f;
    }
}
