package com.huawei.hwversionmgr.utils;

import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: HwOucHttpsUtil */
public class C5378a {
    public static String m25856a(String str, String str2) {
        if (str2 != null) {
            return C5378a.m25857a(str, str2, false);
        }
        C2538c.c("HwOucHttpsUtil", new Object[]{"param is null when doHttpsPost"});
        return null;
    }

    private static String m25857a(String str, String str2, boolean z) {
        InputStream a;
        Exception e;
        String str3;
        try {
            URL url = new URL(str);
            HostnameVerifier hostnameVerifier = SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                C2538c.c("HwOucHttpsUtil", new Object[]{"(HttpsURLConnection)url.openConnection(); !"});
                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest openConnection already!"});
                if (C5378a.m25859a(httpsURLConnection)) {
                    return null;
                }
                try {
                    httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    C2538c.c("HwOucHttpsUtil", new Object[]{"setRequestMethod(HTTP_POST);!"});
                    byte[] a2 = C5378a.m25860a(str2, z, httpsURLConnection, hostnameVerifier);
                    if (a2 == null) {
                        return null;
                    }
                    try {
                        a = C5378a.m25854a(a2, httpsURLConnection);
                        try {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsResponsesStream!"});
                            C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsResponsesStream exception!", e});
                                C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                                str3 = "";
                                if (a == null) {
                                    return C5378a.m25855a(a, str3);
                                }
                                return str3;
                            } catch (Throwable th) {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                            }
                        }
                    } catch (Exception e3) {
                        Exception exception = e3;
                        a = null;
                        e = exception;
                        C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsResponsesStream exception!", e});
                        C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                        str3 = "";
                        if (a == null) {
                            return str3;
                        }
                        return C5378a.m25855a(a, str3);
                    }
                    str3 = "";
                    if (a == null) {
                        return str3;
                    }
                    return C5378a.m25855a(a, str3);
                } catch (ProtocolException e4) {
                    C2538c.c("HwOucHttpsUtil", new Object[]{e4.getMessage() + "setRequestMethod failed"});
                    return null;
                }
            } catch (IOException e5) {
                C2538c.c("HwOucHttpsUtil", new Object[]{e5.getMessage() + "openConnection failed"});
                return null;
            }
        } catch (MalformedURLException e6) {
            C2538c.c("HwOucHttpsUtil", new Object[]{e6.getMessage()});
            return null;
        }
    }

    private static String m25855a(InputStream inputStream, String str) {
        IOException e;
        UnsupportedEncodingException e2;
        Throwable th;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, GameManager.DEFAULT_CHARSET);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    str = bufferedReader2.readLine();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close InputStreamReader error!", e3});
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e32) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e32});
                        }
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e322) {
                        C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e322});
                    }
                } catch (UnsupportedEncodingException e4) {
                    e2 = e4;
                    bufferedReader = bufferedReader2;
                    try {
                        C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest UnsupportedEncodingException!", e2});
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e3222) {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close InputStreamReader error!", e3222});
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e32222) {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e32222});
                            }
                        }
                        try {
                            inputStream.close();
                        } catch (IOException e322222) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e322222});
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e5) {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close InputStreamReader error!", e5});
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e52) {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e52});
                            }
                        }
                        try {
                            inputStream.close();
                        } catch (IOException e522) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e522});
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e322222 = e6;
                    bufferedReader = bufferedReader2;
                    C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest IOException!", e322222});
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3222222) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close InputStreamReader error!", e3222222});
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e32222222) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e32222222});
                        }
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e322222222) {
                        C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest close BufferedReader error!", e322222222});
                    }
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    inputStream.close();
                    throw th;
                }
            } catch (UnsupportedEncodingException e7) {
                e2 = e7;
                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest UnsupportedEncodingException!", e2});
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                inputStream.close();
                return str;
            } catch (IOException e8) {
                e322222222 = e8;
                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest IOException!", e322222222});
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                inputStream.close();
                return str;
            }
        } catch (UnsupportedEncodingException e9) {
            e2 = e9;
            inputStreamReader = null;
            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest UnsupportedEncodingException!", e2});
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            return str;
        } catch (IOException e10) {
            e322222222 = e10;
            inputStreamReader = null;
            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest IOException!", e322222222});
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            return str;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            throw th;
        }
        return str;
    }

    private static byte[] m25860a(String str, boolean z, HttpsURLConnection httpsURLConnection, HostnameVerifier hostnameVerifier) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                C2538c.c("HwOucHttpsUtil", new Object[]{e.getMessage() + "UnsupportedEncodingException"});
            }
            if (bytes != null) {
                C2538c.c("HwOucHttpsUtil", new Object[]{"Get null post data!"});
                return null;
            }
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            httpsURLConnection.setRequestProperty("Connection", "keep-alive");
            C2538c.c("HwOucHttpsUtil", new Object[]{"set end"});
            if (!z) {
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
            }
            C2538c.c("HwOucHttpsUtil", new Object[]{"setRequestProperty jsonObject already!"});
            return bytes;
        }
        bytes = null;
        if (bytes != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            httpsURLConnection.setRequestProperty("Connection", "keep-alive");
            C2538c.c("HwOucHttpsUtil", new Object[]{"set end"});
            if (z) {
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
            }
            C2538c.c("HwOucHttpsUtil", new Object[]{"setRequestProperty jsonObject already!"});
            return bytes;
        }
        C2538c.c("HwOucHttpsUtil", new Object[]{"Get null post data!"});
        return null;
    }

    private static boolean m25859a(HttpsURLConnection httpsURLConnection) {
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            C2538c.c("HwOucHttpsUtil", new Object[]{"HwOucHttpsUtil", "TLSv1.2!"});
            instance.init(null, new TrustManager[]{new C5392d(null)}, null);
            javax.net.ssl.SSLSocketFactory socketFactory = instance.getSocketFactory();
            if (socketFactory == null) {
                C2538c.c("HwOucHttpsUtil", new Object[]{"HwOucHttpsUtil", "socketFactory is null error!"});
                return true;
            }
            C2538c.c("HwOucHttpsUtil", new Object[]{"HwOucSSLSocketFactory hssocketFactory !"});
            httpsURLConnection.setSSLSocketFactory(new C5391b(socketFactory));
            C2538c.c("HwOucHttpsUtil", new Object[]{"SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER !"});
            return false;
        } catch (NoSuchAlgorithmException e) {
            C2538c.c("HwOucHttpsUtil", new Object[]{"NoSuchAlgorithmException " + e.getMessage()});
            return true;
        } catch (KeyManagementException e2) {
            C2538c.c("HwOucHttpsUtil", new Object[]{"KeyManagementException " + e2.getMessage()});
            return true;
        } catch (KeyStoreException e3) {
            C2538c.c("HwOucHttpsUtil", new Object[]{"KeyStoreException " + e3.getMessage()});
            return true;
        }
    }

    private static InputStream m25854a(byte[] bArr, HttpsURLConnection httpsURLConnection) {
        IOException e;
        Throwable th;
        OutputStream outputStream;
        try {
            httpsURLConnection.connect();
            C2538c.c("HwOucHttpsUtil", new Object[]{"connect "});
            outputStream = httpsURLConnection.getOutputStream();
            try {
                C2538c.c("HwOucHttpsUtil", new Object[]{"getoutput"});
                outputStream.write(bArr);
                C2538c.c("HwOucHttpsUtil", new Object[]{"write"});
                C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest finally closeOutputStream!"});
                C5378a.m25858a(outputStream);
                return C5378a.m25862b(httpsURLConnection);
            } catch (IOException e2) {
                e = e2;
                try {
                    C2538c.c("HwOucHttpsUtil", new Object[]{e.getMessage(), e});
                    C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest finally closeOutputStream!"});
                    C5378a.m25858a(outputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest finally closeOutputStream!"});
                    C5378a.m25858a(outputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            outputStream = null;
            C2538c.c("HwOucHttpsUtil", new Object[]{e.getMessage(), e});
            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest finally closeOutputStream!"});
            C5378a.m25858a(outputStream);
            return null;
        } catch (Throwable th3) {
            outputStream = null;
            th = th3;
            C2538c.c("HwOucHttpsUtil", new Object[]{"doPostRequest finally closeOutputStream!"});
            C5378a.m25858a(outputStream);
            throw th;
        }
    }

    private static InputStream m25862b(HttpsURLConnection httpsURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpsURLConnection.getInputStream();
        } catch (UnsupportedEncodingException e) {
            C2538c.c("HwOucHttpsUtil", new Object[]{"UnsupportedEncodingException ", e});
        } catch (IOException e2) {
            C2538c.c("HwOucHttpsUtil", new Object[]{"IOException ", e2});
        }
        return inputStream;
    }

    private static void m25858a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                C2538c.c("HwOucHttpsUtil", new Object[]{e.getMessage()});
            }
        }
    }

    public static int m25853a(String str, OutputStream outputStream) {
        int b;
        Exception e;
        byte[] bArr = null;
        try {
            URL url = new URL(str);
            C2538c.c("HwOucHttpsUtil", new Object[]{"doReportStatus url: " + str});
            HostnameVerifier hostnameVerifier = SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                C2538c.c("HwOucHttpsUtil", new Object[]{"doReportStatus (HttpsURLConnection)url.openConnection(); !"});
                C2538c.c("HwOucHttpsUtil", new Object[]{"doReportStatus openConnection already!"});
                try {
                    SSLContext instance = SSLContext.getInstance("TLSv1.2");
                    C2538c.c("HwOucHttpsUtil", new Object[]{"HwOucHttpsUtil", "TLSv1.2!"});
                    instance.init(null, new TrustManager[]{new C5392d(null)}, null);
                    javax.net.ssl.SSLSocketFactory socketFactory = instance.getSocketFactory();
                    if (socketFactory == null) {
                        C2538c.c("HwOucHttpsUtil", new Object[]{"HwOucHttpsUtil", "doReportStatus socketFactory is null error!"});
                        return -1;
                    }
                    C2538c.c("HwOucHttpsUtil", new Object[]{"HwOucSSLSocketFactory hssocketFactory !"});
                    httpsURLConnection.setSSLSocketFactory(new C5391b(socketFactory));
                    C2538c.c("HwOucHttpsUtil", new Object[]{"SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER !"});
                    try {
                        httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                        C2538c.c("HwOucHttpsUtil", new Object[]{"doReportStatus setRequestMethod(HTTP_POST);!"});
                        if (outputStream != null) {
                            try {
                                bArr = outputStream.toString().getBytes(GameManager.DEFAULT_CHARSET);
                            } catch (UnsupportedEncodingException e2) {
                                C2538c.c("HwOucHttpsUtil", new Object[]{e2.getMessage() + "UnsupportedEncodingException"});
                            }
                        }
                        if (bArr == null) {
                            C2538c.c("HwOucHttpsUtil", new Object[]{"Get null post data!"});
                            return -1;
                        }
                        httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setConnectTimeout(30000);
                        httpsURLConnection.setReadTimeout(30000);
                        httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                        httpsURLConnection.setRequestProperty("Connection", "keep-alive");
                        C2538c.c("HwOucHttpsUtil", new Object[]{"doReportStatus set end"});
                        try {
                            b = C5378a.m25861b(bArr, httpsURLConnection);
                            try {
                                C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsResponsesStream!"});
                                C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsResponsesStream exception!", e});
                                    C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                                    C2538c.c("HwOucHttpsUtil", new Object[]{"StatusCode is " + b});
                                    return b;
                                } catch (Throwable th) {
                                    C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            b = -1;
                            C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsResponsesStream exception!", e});
                            C2538c.c("HwOucHttpsUtil", new Object[]{"Release wakeLock now"});
                            C2538c.c("HwOucHttpsUtil", new Object[]{"StatusCode is " + b});
                            return b;
                        }
                        C2538c.c("HwOucHttpsUtil", new Object[]{"StatusCode is " + b});
                        return b;
                    } catch (ProtocolException e5) {
                        C2538c.c("HwOucHttpsUtil", new Object[]{e5.getMessage() + "setRequestMethod failed"});
                        return -1;
                    }
                } catch (NoSuchAlgorithmException e6) {
                    C2538c.c("HwOucHttpsUtil", new Object[]{"NoSuchAlgorithmException " + e6.getMessage()});
                    return -1;
                } catch (KeyManagementException e7) {
                    C2538c.c("HwOucHttpsUtil", new Object[]{"KeyManagementException " + e7.getMessage()});
                    return -1;
                } catch (KeyStoreException e8) {
                    C2538c.c("HwOucHttpsUtil", new Object[]{"KeyStoreException " + e8.getMessage()});
                    return -1;
                }
            } catch (IOException e9) {
                C2538c.c("HwOucHttpsUtil", new Object[]{e9.getMessage() + "openConnection failed"});
                return -1;
            }
        } catch (MalformedURLException e10) {
            C2538c.c("HwOucHttpsUtil", new Object[]{e10.getMessage()});
            return -1;
        }
    }

    private static int m25861b(byte[] bArr, HttpsURLConnection httpsURLConnection) {
        int responseCode;
        IOException e;
        OutputStream outputStream = null;
        try {
            httpsURLConnection.connect();
            C2538c.c("HwOucHttpsUtil", new Object[]{"connect "});
            outputStream = httpsURLConnection.getOutputStream();
            C2538c.c("HwOucHttpsUtil", new Object[]{"getoutput"});
            outputStream.write(bArr);
            C2538c.c("HwOucHttpsUtil", new Object[]{"write"});
            httpsURLConnection.getInputStream();
            responseCode = httpsURLConnection.getResponseCode();
            try {
                C2538c.c("HwOucHttpsUtil", new Object[]{"StatusCode: " + responseCode});
                C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsReportCode finally closeOutputStream!"});
                C5378a.m25858a(outputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    C2538c.c("HwOucHttpsUtil", new Object[]{e.getMessage(), e});
                    C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsReportCode finally closeOutputStream!"});
                    C5378a.m25858a(outputStream);
                    return responseCode;
                } catch (Throwable th) {
                    C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsReportCode finally closeOutputStream!"});
                    C5378a.m25858a(outputStream);
                }
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            responseCode = -1;
            e = iOException;
            C2538c.c("HwOucHttpsUtil", new Object[]{e.getMessage(), e});
            C2538c.c("HwOucHttpsUtil", new Object[]{"getHttpsReportCode finally closeOutputStream!"});
            C5378a.m25858a(outputStream);
            return responseCode;
        }
        return responseCode;
    }
}
