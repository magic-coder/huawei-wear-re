package com.aps;

import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C3191c;
import com.amap.api.location.core.C3192d;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.leisen.wallet.sdk.http.RequestParams;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetManager */
public class bh {
    private static bh f13023a = null;

    private bh() {
    }

    public static bh m17409a() {
        if (f13023a == null) {
            f13023a = new bh();
        }
        return f13023a;
    }

    public String m17417a(Context context, String str, byte[] bArr, String str2) throws AMapLocException {
        InputStream content;
        InputStreamReader inputStreamReader;
        HttpClient httpClient;
        Throwable th;
        BufferedReader bufferedReader;
        Throwable th2;
        Object obj;
        HttpPost httpPost;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return null;
        }
        HttpClient b = bu.m17461b(context);
        if (m17408a((NetworkInfo) b) == -1) {
            return null;
        }
        HttpPost httpPost2 = null;
        HttpPost httpPost3 = null;
        InputStream inputStream = null;
        GZIPInputStream gZIPInputStream = null;
        InputStreamReader inputStreamReader2 = null;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = "";
        GZIPInputStream gZIPInputStream2;
        try {
            b = m17412a(context, (NetworkInfo) b);
            try {
                httpPost2 = new HttpPost(str);
                try {
                    String str4;
                    HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
                    httpPost2.addHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                    httpPost2.addHeader("User-Agent", "AMAP Location SDK Android 1.3.3");
                    httpPost2.addHeader("Accept-Encoding", "gzip");
                    httpPost2.addHeader("Connection", "Keep-Alive");
                    httpPost2.addHeader("X-INFO", C3191c.m14119a(null).m14134a(str2));
                    httpPost2.addHeader("ia", "1");
                    httpPost2.addHeader(SMSKeyInfo.TAG_KEY, C3191c.m14120a());
                    stringBuffer.delete(0, stringBuffer.length());
                    httpPost2.setEntity(byteArrayEntity);
                    HttpResponse execute = b.execute(httpPost2);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    if (statusCode == 200) {
                        content = execute.getEntity().getContent();
                        try {
                            str3 = execute.getEntity().getContentType().getValue();
                            CharSequence charSequence = "";
                            int indexOf = str3.indexOf("charset=");
                            if (indexOf != -1) {
                                charSequence = str3.substring(indexOf + 8);
                            }
                            if (TextUtils.isEmpty(charSequence)) {
                                str3 = GameManager.DEFAULT_CHARSET;
                            } else {
                                CharSequence charSequence2 = charSequence;
                            }
                            if (m17414a(execute)) {
                                gZIPInputStream2 = new GZIPInputStream(content);
                            } else {
                                inputStream = null;
                            }
                            if (gZIPInputStream2 != null) {
                                try {
                                    inputStreamReader = new InputStreamReader(gZIPInputStream2, str3);
                                } catch (UnknownHostException e) {
                                    gZIPInputStream = gZIPInputStream2;
                                    inputStream = content;
                                    httpPost3 = httpPost2;
                                    httpClient = b;
                                    try {
                                        throw new AMapLocException("未知主机 - UnKnowHostException");
                                    } catch (Throwable th3) {
                                        th = th3;
                                        b = httpClient;
                                        httpPost2 = httpPost3;
                                        content = inputStream;
                                        gZIPInputStream2 = gZIPInputStream;
                                        inputStreamReader = inputStreamReader2;
                                        bufferedReader = bufferedReader2;
                                        th2 = th;
                                        if (httpPost2 != null) {
                                            httpPost2.abort();
                                        }
                                        if (b != null) {
                                            b.getConnectionManager().shutdown();
                                        }
                                        if (gZIPInputStream2 != null) {
                                            try {
                                                gZIPInputStream2.close();
                                            } catch (Throwable th4) {
                                            }
                                        }
                                        if (content != null) {
                                            try {
                                                content.close();
                                            } catch (Throwable th5) {
                                                th5.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable th6) {
                                                th6.printStackTrace();
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable th7) {
                                                th7.printStackTrace();
                                            }
                                        }
                                        throw th2;
                                    }
                                } catch (SocketException e2) {
                                    gZIPInputStream = gZIPInputStream2;
                                    inputStream = content;
                                    throw new AMapLocException("socket 连接异常 - SocketException");
                                } catch (SocketTimeoutException e3) {
                                    gZIPInputStream = gZIPInputStream2;
                                    inputStream = content;
                                    throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                                } catch (ConnectTimeoutException e4) {
                                    gZIPInputStream = gZIPInputStream2;
                                    inputStream = content;
                                    throw new AMapLocException("http连接失败 - ConnectionException");
                                } catch (Throwable th62) {
                                    th = th62;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    th2 = th;
                                    if (httpPost2 != null) {
                                        httpPost2.abort();
                                    }
                                    if (b != null) {
                                        b.getConnectionManager().shutdown();
                                    }
                                    if (gZIPInputStream2 != null) {
                                        gZIPInputStream2.close();
                                    }
                                    if (content != null) {
                                        content.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th2;
                                }
                            }
                            inputStreamReader = new InputStreamReader(content, str3);
                        } catch (UnknownHostException e5) {
                            inputStream = content;
                            httpPost3 = httpPost2;
                            httpClient = b;
                            throw new AMapLocException("未知主机 - UnKnowHostException");
                        } catch (SocketException e6) {
                            inputStream = content;
                            throw new AMapLocException("socket 连接异常 - SocketException");
                        } catch (SocketTimeoutException e7) {
                            inputStream = content;
                            throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                        } catch (ConnectTimeoutException e8) {
                            inputStream = content;
                            throw new AMapLocException("http连接失败 - ConnectionException");
                        } catch (Throwable th52) {
                            th = th52;
                            gZIPInputStream2 = null;
                            inputStreamReader = null;
                            bufferedReader = null;
                            th2 = th;
                            if (httpPost2 != null) {
                                httpPost2.abort();
                            }
                            if (b != null) {
                                b.getConnectionManager().shutdown();
                            }
                            if (gZIPInputStream2 != null) {
                                gZIPInputStream2.close();
                            }
                            if (content != null) {
                                content.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th2;
                        }
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader, 2048);
                            try {
                                str4 = "";
                                while (true) {
                                    str4 = bufferedReader.readLine();
                                    if (str4 == null) {
                                        break;
                                    }
                                    stringBuffer.append(str4);
                                }
                                str4 = stringBuffer.toString();
                                stringBuffer.delete(0, stringBuffer.length());
                            } catch (UnknownHostException e9) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream = gZIPInputStream2;
                                inputStream = content;
                                httpPost3 = httpPost2;
                                httpClient = b;
                                throw new AMapLocException("未知主机 - UnKnowHostException");
                            } catch (SocketException e10) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream = gZIPInputStream2;
                                inputStream = content;
                                throw new AMapLocException("socket 连接异常 - SocketException");
                            } catch (SocketTimeoutException e11) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream = gZIPInputStream2;
                                inputStream = content;
                                throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                            } catch (ConnectTimeoutException e12) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream = gZIPInputStream2;
                                inputStream = content;
                                throw new AMapLocException("http连接失败 - ConnectionException");
                            } catch (Throwable th8) {
                                th2 = th8;
                                th2.printStackTrace();
                                throw new AMapLocException("未知的错误");
                            }
                        } catch (UnknownHostException e13) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream = gZIPInputStream2;
                            inputStream = content;
                            httpPost3 = httpPost2;
                            httpClient = b;
                            throw new AMapLocException("未知主机 - UnKnowHostException");
                        } catch (SocketException e14) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream = gZIPInputStream2;
                            inputStream = content;
                            throw new AMapLocException("socket 连接异常 - SocketException");
                        } catch (SocketTimeoutException e15) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream = gZIPInputStream2;
                            inputStream = content;
                            throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                        } catch (ConnectTimeoutException e16) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream = gZIPInputStream2;
                            inputStream = content;
                            throw new AMapLocException("http连接失败 - ConnectionException");
                        } catch (Throwable th72) {
                            th = th72;
                            bufferedReader = null;
                            th2 = th;
                            if (httpPost2 != null) {
                                httpPost2.abort();
                            }
                            if (b != null) {
                                b.getConnectionManager().shutdown();
                            }
                            if (gZIPInputStream2 != null) {
                                gZIPInputStream2.close();
                            }
                            if (content != null) {
                                content.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th2;
                        }
                    } else if (statusCode == HttpStatus.SC_NOT_FOUND) {
                        throw new AMapLocException("服务器连接失败 - UnknownServiceException");
                    } else {
                        content = null;
                        gZIPInputStream2 = null;
                        inputStreamReader = null;
                        bufferedReader = null;
                        str4 = str3;
                    }
                    if (httpPost2 != null) {
                        httpPost2.abort();
                    }
                    if (b != null) {
                        b.getConnectionManager().shutdown();
                    }
                    if (gZIPInputStream2 != null) {
                        try {
                            gZIPInputStream2.close();
                        } catch (Throwable th9) {
                        }
                    }
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Throwable th522) {
                            th522.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable th622) {
                            th622.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th722) {
                            th722.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str4)) {
                        return null;
                    }
                    return str4;
                } catch (UnknownHostException e17) {
                    httpPost3 = httpPost2;
                    httpClient = b;
                    throw new AMapLocException("未知主机 - UnKnowHostException");
                } catch (SocketException e18) {
                    throw new AMapLocException("socket 连接异常 - SocketException");
                } catch (SocketTimeoutException e19) {
                    throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                } catch (ConnectTimeoutException e20) {
                    throw new AMapLocException("http连接失败 - ConnectionException");
                } catch (Throwable th10) {
                    th = th10;
                    content = null;
                    gZIPInputStream2 = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    th2 = th;
                    if (httpPost2 != null) {
                        httpPost2.abort();
                    }
                    if (b != null) {
                        b.getConnectionManager().shutdown();
                    }
                    if (gZIPInputStream2 != null) {
                        gZIPInputStream2.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th2;
                }
            } catch (UnknownHostException e21) {
                httpClient = b;
                throw new AMapLocException("未知主机 - UnKnowHostException");
            } catch (SocketException e22) {
                httpPost2 = null;
                throw new AMapLocException("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e23) {
                obj = null;
                throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
            } catch (ConnectTimeoutException e24) {
                obj = null;
                throw new AMapLocException("http连接失败 - ConnectionException");
            } catch (Throwable th11) {
                th = th11;
                httpPost2 = null;
                content = null;
                gZIPInputStream2 = null;
                inputStreamReader = null;
                bufferedReader = null;
                th2 = th;
                if (httpPost2 != null) {
                    httpPost2.abort();
                }
                if (b != null) {
                    b.getConnectionManager().shutdown();
                }
                if (gZIPInputStream2 != null) {
                    gZIPInputStream2.close();
                }
                if (content != null) {
                    content.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        } catch (UnknownHostException e25) {
            throw new AMapLocException("未知主机 - UnKnowHostException");
        } catch (SocketException e26) {
            b = null;
            httpPost2 = null;
            throw new AMapLocException("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e27) {
            httpPost = null;
            obj = null;
            throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
        } catch (ConnectTimeoutException e28) {
            httpPost = null;
            obj = null;
            throw new AMapLocException("http连接失败 - ConnectionException");
        } catch (Throwable th102) {
            th = th102;
            content = inputStream;
            gZIPInputStream2 = gZIPInputStream;
            inputStreamReader = inputStreamReader2;
            bufferedReader = bufferedReader2;
            th2 = th;
            if (httpPost2 != null) {
                httpPost2.abort();
            }
            if (b != null) {
                b.getConnectionManager().shutdown();
            }
            if (gZIPInputStream2 != null) {
                gZIPInputStream2.close();
            }
            if (content != null) {
                content.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
    }

    public String m17419a(byte[] bArr, Context context, JSONObject jSONObject) throws Exception {
        HttpClient httpClient;
        Throwable th;
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        BufferedReader bufferedReader;
        Throwable th2;
        Object obj;
        HttpPost httpPost;
        HttpClient b = bu.m17461b(context);
        if (m17408a((NetworkInfo) b) == -1) {
            throw new AMapLocException("http连接失败 - ConnectionException");
        }
        HttpPost httpPost2 = null;
        HttpPost httpPost3 = null;
        InputStream inputStream2 = null;
        GZIPInputStream gZIPInputStream2 = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        InputStreamReader inputStreamReader2;
        try {
            String[] a;
            b = m17412a(context, (NetworkInfo) b);
            try {
                a = m17415a(jSONObject);
                httpPost2 = new HttpPost(C3191c.m14131j());
            } catch (UnknownHostException e) {
                httpClient = b;
                try {
                    throw new AMapLocException("未知主机 - UnKnowHostException");
                } catch (Throwable th3) {
                    th = th3;
                    b = httpClient;
                    httpPost2 = httpPost3;
                    inputStream = inputStream2;
                    gZIPInputStream = gZIPInputStream2;
                    inputStreamReader2 = inputStreamReader;
                    bufferedReader = bufferedReader2;
                    th2 = th;
                    if (httpPost2 != null) {
                        httpPost2.abort();
                    }
                    if (b != null) {
                        b.getConnectionManager().shutdown();
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th42) {
                            th42.printStackTrace();
                        }
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th2;
                }
            } catch (SocketException e2) {
                httpPost2 = null;
                throw new AMapLocException("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e3) {
                obj = null;
                throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
            } catch (ConnectTimeoutException e4) {
                obj = null;
                throw new AMapLocException("http连接失败 - ConnectionException");
            } catch (Throwable th5) {
                th = th5;
                httpPost2 = null;
                inputStream = null;
                gZIPInputStream = null;
                inputStreamReader2 = null;
                bufferedReader = null;
                th2 = th;
                if (httpPost2 != null) {
                    httpPost2.abort();
                }
                if (b != null) {
                    b.getConnectionManager().shutdown();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
            try {
                String str2;
                String str3 = GameManager.DEFAULT_CHARSET;
                HttpEntity byteArrayEntity = new ByteArrayEntity(bu.m17458a(bArr));
                byteArrayEntity.setContentType(RequestParams.APPLICATION_OCTET_STREAM);
                httpPost2.addHeader("Accept-Encoding", "gzip");
                httpPost2.addHeader("gzipped", "1");
                httpPost2.addHeader("X-INFO", a[2]);
                httpPost2.addHeader("X-BIZ", a[3]);
                httpPost2.addHeader("KEY", a[1]);
                httpPost2.addHeader("ec", "1");
                httpPost2.addHeader("enginever", "4.2");
                if (a[4] != null && a[4].length() > 0) {
                    httpPost2.addHeader("User-Agent", a[4]);
                }
                String a2 = C3192d.m14139a();
                String a3 = C3192d.m14140a(a2, "key=" + a[1]);
                httpPost2.addHeader("ts", a2);
                httpPost2.addHeader("scode", a3);
                stringBuffer.delete(0, stringBuffer.length());
                httpPost2.setEntity(byteArrayEntity);
                HttpResponse execute = b.execute(httpPost2);
                int statusCode = execute.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    inputStream = execute.getEntity().getContent();
                    try {
                        str = execute.getEntity().getContentType().getValue();
                        CharSequence charSequence = "";
                        int indexOf = str.indexOf("charset=");
                        if (indexOf != -1) {
                            charSequence = str.substring(indexOf + 8);
                        }
                        if (TextUtils.isEmpty(charSequence)) {
                            str = str3;
                        } else {
                            CharSequence charSequence2 = charSequence;
                        }
                        if (m17414a(execute)) {
                            gZIPInputStream = new GZIPInputStream(inputStream);
                        } else {
                            gZIPInputStream = null;
                        }
                        if (gZIPInputStream != null) {
                            try {
                                inputStreamReader2 = new InputStreamReader(gZIPInputStream, str);
                            } catch (UnknownHostException e5) {
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream2 = inputStream;
                                httpPost3 = httpPost2;
                                httpClient = b;
                                throw new AMapLocException("未知主机 - UnKnowHostException");
                            } catch (SocketException e6) {
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream2 = inputStream;
                                throw new AMapLocException("socket 连接异常 - SocketException");
                            } catch (SocketTimeoutException e7) {
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream2 = inputStream;
                                throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                            } catch (ConnectTimeoutException e8) {
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream2 = inputStream;
                                throw new AMapLocException("http连接失败 - ConnectionException");
                            } catch (Throwable th6) {
                                th = th6;
                                inputStreamReader2 = null;
                                bufferedReader = null;
                                th2 = th;
                                if (httpPost2 != null) {
                                    httpPost2.abort();
                                }
                                if (b != null) {
                                    b.getConnectionManager().shutdown();
                                }
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th2;
                            }
                        }
                        inputStreamReader2 = new InputStreamReader(inputStream, str);
                    } catch (UnknownHostException e9) {
                        inputStream2 = inputStream;
                        httpPost3 = httpPost2;
                        httpClient = b;
                        throw new AMapLocException("未知主机 - UnKnowHostException");
                    } catch (SocketException e10) {
                        inputStream2 = inputStream;
                        throw new AMapLocException("socket 连接异常 - SocketException");
                    } catch (SocketTimeoutException e11) {
                        inputStream2 = inputStream;
                        throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                    } catch (ConnectTimeoutException e12) {
                        inputStream2 = inputStream;
                        throw new AMapLocException("http连接失败 - ConnectionException");
                    } catch (Throwable th422) {
                        th = th422;
                        gZIPInputStream = null;
                        inputStreamReader2 = null;
                        bufferedReader = null;
                        th2 = th;
                        if (httpPost2 != null) {
                            httpPost2.abort();
                        }
                        if (b != null) {
                            b.getConnectionManager().shutdown();
                        }
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th2;
                    }
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2, 2048);
                        try {
                            str2 = "";
                            while (true) {
                                str2 = bufferedReader.readLine();
                                if (str2 == null) {
                                    break;
                                }
                                stringBuffer.append(str2);
                            }
                            str2 = stringBuffer.toString();
                            stringBuffer.delete(0, stringBuffer.length());
                        } catch (UnknownHostException e13) {
                            bufferedReader2 = bufferedReader;
                            inputStreamReader = inputStreamReader2;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream2 = inputStream;
                            httpPost3 = httpPost2;
                            httpClient = b;
                            throw new AMapLocException("未知主机 - UnKnowHostException");
                        } catch (SocketException e14) {
                            bufferedReader2 = bufferedReader;
                            inputStreamReader = inputStreamReader2;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream2 = inputStream;
                            throw new AMapLocException("socket 连接异常 - SocketException");
                        } catch (SocketTimeoutException e15) {
                            bufferedReader2 = bufferedReader;
                            inputStreamReader = inputStreamReader2;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream2 = inputStream;
                            throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                        } catch (ConnectTimeoutException e16) {
                            bufferedReader2 = bufferedReader;
                            inputStreamReader = inputStreamReader2;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream2 = inputStream;
                            throw new AMapLocException("http连接失败 - ConnectionException");
                        } catch (Throwable th7) {
                            th2 = th7;
                            if (httpPost2 != null) {
                                httpPost2.abort();
                            }
                            if (b != null) {
                                b.getConnectionManager().shutdown();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th2;
                        }
                    } catch (UnknownHostException e17) {
                        inputStreamReader = inputStreamReader2;
                        gZIPInputStream2 = gZIPInputStream;
                        inputStream2 = inputStream;
                        httpPost3 = httpPost2;
                        httpClient = b;
                        throw new AMapLocException("未知主机 - UnKnowHostException");
                    } catch (SocketException e18) {
                        inputStreamReader = inputStreamReader2;
                        gZIPInputStream2 = gZIPInputStream;
                        inputStream2 = inputStream;
                        throw new AMapLocException("socket 连接异常 - SocketException");
                    } catch (SocketTimeoutException e19) {
                        inputStreamReader = inputStreamReader2;
                        gZIPInputStream2 = gZIPInputStream;
                        inputStream2 = inputStream;
                        throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
                    } catch (ConnectTimeoutException e20) {
                        inputStreamReader = inputStreamReader2;
                        gZIPInputStream2 = gZIPInputStream;
                        inputStream2 = inputStream;
                        throw new AMapLocException("http连接失败 - ConnectionException");
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedReader = null;
                        th2 = th;
                        if (httpPost2 != null) {
                            httpPost2.abort();
                        }
                        if (b != null) {
                            b.getConnectionManager().shutdown();
                        }
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th2;
                    }
                } else if (statusCode == HttpStatus.SC_NOT_FOUND) {
                    throw new AMapLocException("服务器连接失败 - UnknownServiceException");
                } else {
                    inputStream = null;
                    gZIPInputStream = null;
                    inputStreamReader2 = null;
                    bufferedReader = null;
                    str2 = str;
                }
                if (httpPost2 != null) {
                    httpPost2.abort();
                }
                if (b != null) {
                    b.getConnectionManager().shutdown();
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable th4222) {
                        th4222.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th42222) {
                        th42222.printStackTrace();
                    }
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return TextUtils.isEmpty(str2) ? null : str2;
            } catch (UnknownHostException e21) {
                httpPost3 = httpPost2;
                httpClient = b;
                throw new AMapLocException("未知主机 - UnKnowHostException");
            } catch (SocketException e22) {
                throw new AMapLocException("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e23) {
                throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
            } catch (ConnectTimeoutException e24) {
                throw new AMapLocException("http连接失败 - ConnectionException");
            } catch (Throwable th9) {
                th = th9;
                inputStream = null;
                gZIPInputStream = null;
                inputStreamReader2 = null;
                bufferedReader = null;
                th2 = th;
                if (httpPost2 != null) {
                    httpPost2.abort();
                }
                if (b != null) {
                    b.getConnectionManager().shutdown();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        } catch (UnknownHostException e25) {
            throw new AMapLocException("未知主机 - UnKnowHostException");
        } catch (SocketException e26) {
            b = null;
            httpPost2 = null;
            throw new AMapLocException("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e27) {
            httpPost = null;
            obj = null;
            throw new AMapLocException("socket 连接超时 - SocketTimeoutException");
        } catch (ConnectTimeoutException e28) {
            httpPost = null;
            obj = null;
            throw new AMapLocException("http连接失败 - ConnectionException");
        } catch (Throwable th92) {
            th = th92;
            inputStream = inputStream2;
            gZIPInputStream = gZIPInputStream2;
            inputStreamReader2 = inputStreamReader;
            bufferedReader = bufferedReader2;
            th2 = th;
            if (httpPost2 != null) {
                httpPost2.abort();
            }
            if (b != null) {
                b.getConnectionManager().shutdown();
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.http.client.HttpClient m17412a(android.content.Context r13, android.net.NetworkInfo r14) throws java.lang.Exception {
        /*
        r6 = -1;
        r8 = 80;
        r9 = 1;
        r10 = 0;
        r7 = 0;
        r11 = new org.apache.http.params.BasicHttpParams;
        r11.<init>();
        r0 = r14.getType();
        if (r0 != 0) goto L_0x0189;
    L_0x0011:
        r0 = com.aps.bu.m17463c();
        r1 = 11;
        if (r0 < r1) goto L_0x006b;
    L_0x0019:
        r0 = m17411a(r13);
        if (r0 == 0) goto L_0x0185;
    L_0x001f:
        r0 = r0.address();	 Catch:{ Exception -> 0x0068 }
        r0 = (java.net.InetSocketAddress) r0;	 Catch:{ Exception -> 0x0068 }
    L_0x0025:
        if (r0 == 0) goto L_0x0185;
    L_0x0027:
        r1 = r0.getHostName();
        r0 = r0.getPort();
    L_0x002f:
        r6 = r0;
    L_0x0030:
        r0 = m17413a(r1, r6);
        if (r0 == 0) goto L_0x0042;
    L_0x0036:
        r0 = "http";
        r2 = new org.apache.http.HttpHost;
        r2.<init>(r1, r6, r0);
        r0 = "http.route.default-proxy";
        r11.setParameter(r0, r2);
    L_0x0042:
        r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        com.aps.bu.m17453a(r11, r0);
        org.apache.http.params.HttpProtocolParams.setUseExpectContinue(r11, r10);
        r0 = new org.apache.http.conn.scheme.SchemeRegistry;
        r0.<init>();
        r1 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory();
        r2 = new org.apache.http.conn.scheme.Scheme;
        r3 = "http";
        r2.<init>(r3, r1, r8);
        r0.register(r2);
        r1 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
        r1.<init>(r11, r0);
        r0 = new org.apache.http.impl.client.DefaultHttpClient;
        r0.<init>(r1, r11);
        return r0;
    L_0x0068:
        r0 = move-exception;
        r0 = r7;
        goto L_0x0025;
    L_0x006b:
        r0 = "content://telephony/carriers/preferapn";
        r1 = android.net.Uri.parse(r0);
        r0 = r13.getContentResolver();
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ SecurityException -> 0x00f4, Exception -> 0x014e, all -> 0x0158 }
        if (r2 == 0) goto L_0x017e;
    L_0x007f:
        r0 = r2.moveToFirst();	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r0 == 0) goto L_0x017e;
    L_0x0085:
        r0 = "apn";
        r0 = r2.getColumnIndex(r0);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r0 = r2.getString(r0);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r0 == 0) goto L_0x00a5;
    L_0x0091:
        r1 = java.util.Locale.US;	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r0 = r0.toLowerCase(r1);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r1 = 2;
        r1 = new java.lang.Object[r1];	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r3 = 0;
        r4 = "nm|found apn:";
        r1[r3] = r4;	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r3 = 1;
        r1[r3] = r0;	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        com.aps.bu.m17454a(r1);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
    L_0x00a5:
        if (r0 == 0) goto L_0x00cf;
    L_0x00a7:
        r1 = "ctwap";
        r1 = r0.contains(r1);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r1 == 0) goto L_0x00cf;
    L_0x00af:
        r0 = m17416b();	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r1 != 0) goto L_0x0181;
    L_0x00b9:
        r1 = "null";
        r1 = r0.equals(r1);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r1 != 0) goto L_0x0181;
    L_0x00c1:
        r1 = r9;
    L_0x00c2:
        if (r1 != 0) goto L_0x00c6;
    L_0x00c4:
        r0 = "10.0.0.200";
    L_0x00c6:
        r6 = r8;
        r1 = r0;
    L_0x00c8:
        if (r2 == 0) goto L_0x0030;
    L_0x00ca:
        r2.close();
        goto L_0x0030;
    L_0x00cf:
        if (r0 == 0) goto L_0x017e;
    L_0x00d1:
        r1 = "wap";
        r0 = r0.contains(r1);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r0 == 0) goto L_0x017e;
    L_0x00da:
        r0 = m17416b();	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r1 != 0) goto L_0x017a;
    L_0x00e4:
        r1 = "null";
        r1 = r0.equals(r1);	 Catch:{ SecurityException -> 0x016d, Exception -> 0x0165 }
        if (r1 != 0) goto L_0x017a;
    L_0x00ec:
        r1 = r9;
    L_0x00ed:
        if (r1 != 0) goto L_0x00f1;
    L_0x00ef:
        r0 = "10.0.0.172";
    L_0x00f1:
        r6 = r8;
        r1 = r0;
        goto L_0x00c8;
    L_0x00f4:
        r0 = move-exception;
        r0 = r7;
    L_0x00f6:
        r1 = r14.getExtraInfo();	 Catch:{ all -> 0x0162 }
        if (r1 == 0) goto L_0x0176;
    L_0x00fc:
        r1 = r14.getExtraInfo();	 Catch:{ all -> 0x0162 }
        r2 = java.util.Locale.US;	 Catch:{ all -> 0x0162 }
        r2 = r1.toLowerCase(r2);	 Catch:{ all -> 0x0162 }
        r1 = m17416b();	 Catch:{ all -> 0x0162 }
        r3 = "ctwap";
        r3 = r2.indexOf(r3);	 Catch:{ all -> 0x0162 }
        if (r3 == r6) goto L_0x012e;
    L_0x0112:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0162 }
        if (r2 != 0) goto L_0x0178;
    L_0x0118:
        r2 = "null";
        r2 = r1.equals(r2);	 Catch:{ all -> 0x0162 }
        if (r2 != 0) goto L_0x0178;
    L_0x0120:
        r0 = r1;
    L_0x0121:
        if (r9 != 0) goto L_0x0125;
    L_0x0123:
        r0 = "10.0.0.200";
    L_0x0125:
        r6 = r8;
        r1 = r0;
    L_0x0127:
        if (r7 == 0) goto L_0x0030;
    L_0x0129:
        r7.close();
        goto L_0x0030;
    L_0x012e:
        r3 = "wap";
        r2 = r2.indexOf(r3);	 Catch:{ all -> 0x0162 }
        if (r2 == r6) goto L_0x0176;
    L_0x0137:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0162 }
        if (r2 != 0) goto L_0x0174;
    L_0x013d:
        r2 = "null";
        r2 = r1.equals(r2);	 Catch:{ all -> 0x0162 }
        if (r2 != 0) goto L_0x0174;
    L_0x0145:
        r0 = r1;
        r1 = r9;
    L_0x0147:
        if (r1 != 0) goto L_0x014b;
    L_0x0149:
        r0 = "10.0.0.200";
    L_0x014b:
        r6 = r8;
        r1 = r0;
        goto L_0x0127;
    L_0x014e:
        r0 = move-exception;
        r2 = r7;
        r1 = r7;
    L_0x0151:
        com.aps.bu.m17452a(r0);	 Catch:{ all -> 0x0160 }
        if (r2 == 0) goto L_0x0030;
    L_0x0156:
        goto L_0x00ca;
    L_0x0158:
        r0 = move-exception;
        r2 = r7;
    L_0x015a:
        if (r2 == 0) goto L_0x015f;
    L_0x015c:
        r2.close();
    L_0x015f:
        throw r0;
    L_0x0160:
        r0 = move-exception;
        goto L_0x015a;
    L_0x0162:
        r0 = move-exception;
        r2 = r7;
        goto L_0x015a;
    L_0x0165:
        r0 = move-exception;
        r1 = r7;
        goto L_0x0151;
    L_0x0168:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x0151;
    L_0x016d:
        r0 = move-exception;
        r0 = r7;
        r7 = r2;
        goto L_0x00f6;
    L_0x0171:
        r1 = move-exception;
        r7 = r2;
        goto L_0x00f6;
    L_0x0174:
        r1 = r10;
        goto L_0x0147;
    L_0x0176:
        r1 = r0;
        goto L_0x0127;
    L_0x0178:
        r9 = r10;
        goto L_0x0121;
    L_0x017a:
        r1 = r10;
        r0 = r7;
        goto L_0x00ed;
    L_0x017e:
        r1 = r7;
        goto L_0x00c8;
    L_0x0181:
        r1 = r10;
        r0 = r7;
        goto L_0x00c2;
    L_0x0185:
        r0 = r6;
        r1 = r7;
        goto L_0x002f;
    L_0x0189:
        r1 = r7;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.bh.a(android.content.Context, android.net.NetworkInfo):org.apache.http.client.HttpClient");
    }

    private static Proxy m17411a(Context context) {
        List select;
        try {
            select = ProxySelector.getDefault().select(new URI(C3191c.m14131j()));
        } catch (Exception e) {
            select = null;
        }
        if (select == null || select.isEmpty()) {
            return null;
        }
        Proxy proxy = (Proxy) select.get(0);
        if (proxy == null || proxy.type() == Type.DIRECT) {
            return null;
        }
        return proxy;
    }

    private static boolean m17413a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    public static int m17408a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static String m17410a(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return (String) ax.f12982l.get(i, "UNKNOWN");
    }

    private static boolean m17414a(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("gzip")) {
            return false;
        }
        return true;
    }

    public static String[] m17415a(JSONObject jSONObject) {
        String[] strArr = new String[]{null, null, null, null, null};
        if (jSONObject == null || C3191c.m14131j().length() == 0) {
            strArr[0] = "false";
        } else {
            try {
                CharSequence string = jSONObject.getString(SMSKeyInfo.TAG_KEY);
                String string2 = jSONObject.getString("X-INFO");
                String string3 = jSONObject.getString("X-BIZ");
                CharSequence string4 = jSONObject.getString("User-Agent");
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string4))) {
                    strArr[0] = "true";
                    strArr[1] = string;
                    strArr[2] = string2;
                    strArr[3] = string3;
                    strArr[4] = string4;
                }
            } catch (JSONException e) {
            }
            if (strArr[0] == null || !strArr[0].equals("true")) {
                strArr[0] = "true";
            }
        }
        return strArr;
    }

    private static String m17416b() {
        String defaultHost;
        try {
            defaultHost = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            th.printStackTrace();
            defaultHost = null;
        }
        if (defaultHost == null) {
            return "null";
        }
        return defaultHost;
    }

    public String m17418a(byte[] bArr, Context context) throws Exception {
        HttpClient a;
        HttpPost httpPost;
        BufferedReader bufferedReader;
        Reader reader;
        String str;
        HttpPost httpPost2;
        BufferedReader bufferedReader2;
        InputStream inputStream;
        HttpClient httpClient;
        BufferedReader bufferedReader3;
        Throwable th;
        String str2 = "";
        NetworkInfo b = bu.m17461b(context);
        if (m17408a(b) == -1) {
            return null;
        }
        HttpClient httpClient2 = null;
        HttpPost httpPost3 = null;
        InputStream inputStream2 = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader4 = null;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&");
        stringBuffer2.append("zei=").append(ax.f12971a);
        stringBuffer2.append("&zsi=").append(ax.f12972b);
        int i = 0;
        Object obj = null;
        StringBuffer stringBuffer3 = stringBuffer;
        String str3 = str2;
        while (i < 1 && r1 == null) {
            try {
                a = m17412a(context, b);
                try {
                    httpPost = new HttpPost(stringBuffer2.toString());
                    try {
                        stringBuffer3.delete(0, stringBuffer3.length());
                        stringBuffer3.append("application/soap+xml;charset=");
                        stringBuffer3.append(GameManager.DEFAULT_CHARSET);
                        stringBuffer3.delete(0, stringBuffer3.length());
                        httpPost.addHeader("gzipped", "1");
                        HttpEntity byteArrayEntity = new ByteArrayEntity(bu.m17458a(bArr));
                        byteArrayEntity.setContentType(RequestParams.APPLICATION_OCTET_STREAM);
                        httpPost.setEntity(byteArrayEntity);
                        HttpResponse execute = a.execute(httpPost);
                        if (execute.getStatusLine().getStatusCode() == 200) {
                            InputStream content = execute.getEntity().getContent();
                            try {
                                Reader inputStreamReader2 = new InputStreamReader(content, GameManager.DEFAULT_CHARSET);
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader2, 2048);
                                } catch (UnknownHostException e) {
                                    reader = inputStreamReader2;
                                    str = str3;
                                    httpPost2 = httpPost;
                                    bufferedReader2 = bufferedReader4;
                                    inputStream = content;
                                    httpClient = a;
                                    if (httpPost2 != null) {
                                        httpPost2.abort();
                                        httpPost2 = null;
                                    }
                                    if (httpClient != null) {
                                        httpClient.getConnectionManager().shutdown();
                                        httpClient = null;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (SocketException e2) {
                                    reader = inputStreamReader2;
                                    str = str3;
                                    bufferedReader2 = bufferedReader4;
                                    inputStream = content;
                                    if (httpPost == null) {
                                        httpPost2 = httpPost;
                                    } else {
                                        httpPost.abort();
                                        httpPost2 = null;
                                    }
                                    if (a == null) {
                                        httpClient = a;
                                    } else {
                                        a.getConnectionManager().shutdown();
                                        httpClient = null;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (SocketTimeoutException e3) {
                                    reader = inputStreamReader2;
                                    str = str3;
                                    bufferedReader2 = bufferedReader4;
                                    inputStream = content;
                                    if (httpPost == null) {
                                        httpPost2 = httpPost;
                                    } else {
                                        httpPost.abort();
                                        httpPost2 = null;
                                    }
                                    if (a == null) {
                                        httpClient = a;
                                    } else {
                                        a.getConnectionManager().shutdown();
                                        httpClient = null;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (ConnectTimeoutException e4) {
                                    reader = inputStreamReader2;
                                    str = str3;
                                    bufferedReader2 = bufferedReader4;
                                    inputStream = content;
                                    if (httpPost == null) {
                                        httpPost2 = httpPost;
                                    } else {
                                        httpPost.abort();
                                        httpPost2 = null;
                                    }
                                    if (a == null) {
                                        httpClient = a;
                                    } else {
                                        a.getConnectionManager().shutdown();
                                        httpClient = null;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    reader = inputStreamReader2;
                                    inputStream2 = content;
                                }
                                try {
                                    String str4 = "";
                                    while (true) {
                                        str4 = bufferedReader.readLine();
                                        if (str4 == null) {
                                            break;
                                        }
                                        stringBuffer3.append(str4);
                                    }
                                    str3 = stringBuffer3.toString();
                                    stringBuffer3.delete(0, stringBuffer3.length());
                                    stringBuffer3 = null;
                                    obj = 1;
                                    inputStream = content;
                                    str = str3;
                                    bufferedReader2 = bufferedReader;
                                    inputStreamReader = inputStreamReader2;
                                } catch (UnknownHostException e5) {
                                    inputStream = content;
                                    str = str3;
                                    bufferedReader2 = bufferedReader;
                                    httpClient = a;
                                    inputStreamReader = inputStreamReader2;
                                    httpPost2 = httpPost;
                                    if (httpPost2 != null) {
                                        httpPost2.abort();
                                        httpPost2 = null;
                                    }
                                    if (httpClient != null) {
                                        httpClient.getConnectionManager().shutdown();
                                        httpClient = null;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (SocketException e6) {
                                    inputStream = content;
                                    str = str3;
                                    bufferedReader2 = bufferedReader;
                                    inputStreamReader = inputStreamReader2;
                                    if (httpPost == null) {
                                        httpPost.abort();
                                        httpPost2 = null;
                                    } else {
                                        httpPost2 = httpPost;
                                    }
                                    if (a == null) {
                                        a.getConnectionManager().shutdown();
                                        httpClient = null;
                                    } else {
                                        httpClient = a;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (SocketTimeoutException e7) {
                                    inputStream = content;
                                    str = str3;
                                    bufferedReader2 = bufferedReader;
                                    inputStreamReader = inputStreamReader2;
                                    if (httpPost == null) {
                                        httpPost.abort();
                                        httpPost2 = null;
                                    } else {
                                        httpPost2 = httpPost;
                                    }
                                    if (a == null) {
                                        a.getConnectionManager().shutdown();
                                        httpClient = null;
                                    } else {
                                        httpClient = a;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (ConnectTimeoutException e8) {
                                    inputStream = content;
                                    str = str3;
                                    bufferedReader2 = bufferedReader;
                                    inputStreamReader = inputStreamReader2;
                                    if (httpPost == null) {
                                        httpPost.abort();
                                        httpPost2 = null;
                                    } else {
                                        httpPost2 = httpPost;
                                    }
                                    if (a == null) {
                                        a.getConnectionManager().shutdown();
                                        httpClient = null;
                                    } else {
                                        httpClient = a;
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        inputStream = null;
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                        inputStreamReader = null;
                                    }
                                    if (bufferedReader2 == null) {
                                        bufferedReader2.close();
                                        bufferedReader2 = null;
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    } else {
                                        i++;
                                        bufferedReader3 = bufferedReader2;
                                        str3 = str;
                                        httpClient2 = httpClient;
                                        httpPost3 = httpPost2;
                                        inputStream2 = inputStream;
                                        bufferedReader4 = bufferedReader3;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedReader4 = bufferedReader;
                                    inputStreamReader = inputStreamReader2;
                                    inputStream2 = content;
                                }
                            } catch (UnknownHostException e9) {
                                httpPost2 = httpPost;
                                str = str3;
                                bufferedReader2 = bufferedReader4;
                                inputStream = content;
                                httpClient = a;
                                if (httpPost2 != null) {
                                    httpPost2.abort();
                                    httpPost2 = null;
                                }
                                if (httpClient != null) {
                                    httpClient.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                    inputStreamReader = null;
                                }
                                if (bufferedReader2 == null) {
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                } else {
                                    bufferedReader2.close();
                                    bufferedReader2 = null;
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                }
                            } catch (SocketException e10) {
                                str = str3;
                                bufferedReader2 = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost2 = httpPost;
                                } else {
                                    httpPost.abort();
                                    httpPost2 = null;
                                }
                                if (a == null) {
                                    httpClient = a;
                                } else {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                    inputStreamReader = null;
                                }
                                if (bufferedReader2 == null) {
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                } else {
                                    bufferedReader2.close();
                                    bufferedReader2 = null;
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                }
                            } catch (SocketTimeoutException e11) {
                                str = str3;
                                bufferedReader2 = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost2 = httpPost;
                                } else {
                                    httpPost.abort();
                                    httpPost2 = null;
                                }
                                if (a == null) {
                                    httpClient = a;
                                } else {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                    inputStreamReader = null;
                                }
                                if (bufferedReader2 == null) {
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                } else {
                                    bufferedReader2.close();
                                    bufferedReader2 = null;
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                }
                            } catch (ConnectTimeoutException e12) {
                                str = str3;
                                bufferedReader2 = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost2 = httpPost;
                                } else {
                                    httpPost.abort();
                                    httpPost2 = null;
                                }
                                if (a == null) {
                                    httpClient = a;
                                } else {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                    inputStreamReader = null;
                                }
                                if (bufferedReader2 == null) {
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                } else {
                                    bufferedReader2.close();
                                    bufferedReader2 = null;
                                    i++;
                                    bufferedReader3 = bufferedReader2;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = content;
                            }
                        } else {
                            str = str3;
                            bufferedReader2 = bufferedReader4;
                            inputStream = inputStream2;
                        }
                        if (httpPost != null) {
                            httpPost.abort();
                            httpPost2 = null;
                        } else {
                            httpPost2 = httpPost;
                        }
                        if (a != null) {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        } else {
                            httpClient = a;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                            inputStreamReader = null;
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                            bufferedReader2 = null;
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        } else {
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        }
                    } catch (UnknownHostException e13) {
                        httpClient = a;
                        str = str3;
                        bufferedReader2 = bufferedReader4;
                        inputStream = inputStream2;
                        httpPost2 = httpPost;
                        if (httpPost2 != null) {
                            httpPost2.abort();
                            httpPost2 = null;
                        }
                        if (httpClient != null) {
                            httpClient.getConnectionManager().shutdown();
                            httpClient = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                            inputStreamReader = null;
                        }
                        if (bufferedReader2 == null) {
                            bufferedReader2.close();
                            bufferedReader2 = null;
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        } else {
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        }
                    } catch (SocketException e14) {
                        str = str3;
                        bufferedReader2 = bufferedReader4;
                        inputStream = inputStream2;
                        if (httpPost == null) {
                            httpPost.abort();
                            httpPost2 = null;
                        } else {
                            httpPost2 = httpPost;
                        }
                        if (a == null) {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        } else {
                            httpClient = a;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                            inputStreamReader = null;
                        }
                        if (bufferedReader2 == null) {
                            bufferedReader2.close();
                            bufferedReader2 = null;
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        } else {
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        }
                    } catch (SocketTimeoutException e15) {
                        str = str3;
                        bufferedReader2 = bufferedReader4;
                        inputStream = inputStream2;
                        if (httpPost == null) {
                            httpPost.abort();
                            httpPost2 = null;
                        } else {
                            httpPost2 = httpPost;
                        }
                        if (a == null) {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        } else {
                            httpClient = a;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                            inputStreamReader = null;
                        }
                        if (bufferedReader2 == null) {
                            bufferedReader2.close();
                            bufferedReader2 = null;
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        } else {
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        }
                    } catch (ConnectTimeoutException e16) {
                        str = str3;
                        bufferedReader2 = bufferedReader4;
                        inputStream = inputStream2;
                        if (httpPost == null) {
                            httpPost.abort();
                            httpPost2 = null;
                        } else {
                            httpPost2 = httpPost;
                        }
                        if (a == null) {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        } else {
                            httpClient = a;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                            inputStreamReader = null;
                        }
                        if (bufferedReader2 == null) {
                            bufferedReader2.close();
                            bufferedReader2 = null;
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        } else {
                            i++;
                            bufferedReader3 = bufferedReader2;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (UnknownHostException e17) {
                    str = str3;
                    bufferedReader2 = bufferedReader4;
                    inputStream = inputStream2;
                    httpPost2 = httpPost3;
                    httpClient = a;
                    if (httpPost2 != null) {
                        httpPost2.abort();
                        httpPost2 = null;
                    }
                    if (httpClient != null) {
                        httpClient.getConnectionManager().shutdown();
                        httpClient = null;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                        inputStreamReader = null;
                    }
                    if (bufferedReader2 == null) {
                        bufferedReader2.close();
                        bufferedReader2 = null;
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    } else {
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    }
                } catch (SocketException e18) {
                    httpPost = httpPost3;
                    str = str3;
                    bufferedReader2 = bufferedReader4;
                    inputStream = inputStream2;
                    if (httpPost == null) {
                        httpPost.abort();
                        httpPost2 = null;
                    } else {
                        httpPost2 = httpPost;
                    }
                    if (a == null) {
                        a.getConnectionManager().shutdown();
                        httpClient = null;
                    } else {
                        httpClient = a;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                        inputStreamReader = null;
                    }
                    if (bufferedReader2 == null) {
                        bufferedReader2.close();
                        bufferedReader2 = null;
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    } else {
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    }
                } catch (SocketTimeoutException e19) {
                    httpPost = httpPost3;
                    str = str3;
                    bufferedReader2 = bufferedReader4;
                    inputStream = inputStream2;
                    if (httpPost == null) {
                        httpPost.abort();
                        httpPost2 = null;
                    } else {
                        httpPost2 = httpPost;
                    }
                    if (a == null) {
                        a.getConnectionManager().shutdown();
                        httpClient = null;
                    } else {
                        httpClient = a;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                        inputStreamReader = null;
                    }
                    if (bufferedReader2 == null) {
                        bufferedReader2.close();
                        bufferedReader2 = null;
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    } else {
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    }
                } catch (ConnectTimeoutException e20) {
                    httpPost = httpPost3;
                    str = str3;
                    bufferedReader2 = bufferedReader4;
                    inputStream = inputStream2;
                    if (httpPost == null) {
                        httpPost.abort();
                        httpPost2 = null;
                    } else {
                        httpPost2 = httpPost;
                    }
                    if (a == null) {
                        a.getConnectionManager().shutdown();
                        httpClient = null;
                    } else {
                        httpClient = a;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                        inputStreamReader = null;
                    }
                    if (bufferedReader2 == null) {
                        bufferedReader2.close();
                        bufferedReader2 = null;
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    } else {
                        i++;
                        bufferedReader3 = bufferedReader2;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpPost = httpPost3;
                }
            } catch (UnknownHostException e21) {
                bufferedReader3 = bufferedReader4;
                inputStream = inputStream2;
                httpPost2 = httpPost3;
                httpClient = httpClient2;
                str = str3;
                bufferedReader2 = bufferedReader3;
                if (httpPost2 != null) {
                    httpPost2.abort();
                    httpPost2 = null;
                }
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                    inputStreamReader = null;
                }
                if (bufferedReader2 == null) {
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                } else {
                    bufferedReader2.close();
                    bufferedReader2 = null;
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                }
            } catch (SocketException e22) {
                httpPost = httpPost3;
                a = httpClient2;
                str = str3;
                bufferedReader2 = bufferedReader4;
                inputStream = inputStream2;
                if (httpPost == null) {
                    httpPost2 = httpPost;
                } else {
                    httpPost.abort();
                    httpPost2 = null;
                }
                if (a == null) {
                    httpClient = a;
                } else {
                    a.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                    inputStreamReader = null;
                }
                if (bufferedReader2 == null) {
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                } else {
                    bufferedReader2.close();
                    bufferedReader2 = null;
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                }
            } catch (SocketTimeoutException e23) {
                httpPost = httpPost3;
                a = httpClient2;
                str = str3;
                bufferedReader2 = bufferedReader4;
                inputStream = inputStream2;
                if (httpPost == null) {
                    httpPost2 = httpPost;
                } else {
                    httpPost.abort();
                    httpPost2 = null;
                }
                if (a == null) {
                    httpClient = a;
                } else {
                    a.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                    inputStreamReader = null;
                }
                if (bufferedReader2 == null) {
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                } else {
                    bufferedReader2.close();
                    bufferedReader2 = null;
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                }
            } catch (ConnectTimeoutException e24) {
                httpPost = httpPost3;
                a = httpClient2;
                str = str3;
                bufferedReader2 = bufferedReader4;
                inputStream = inputStream2;
                if (httpPost == null) {
                    httpPost2 = httpPost;
                } else {
                    httpPost.abort();
                    httpPost2 = null;
                }
                if (a == null) {
                    httpClient = a;
                } else {
                    a.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                    inputStreamReader = null;
                }
                if (bufferedReader2 == null) {
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                } else {
                    bufferedReader2.close();
                    bufferedReader2 = null;
                    i++;
                    bufferedReader3 = bufferedReader2;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader3;
                }
            } catch (Throwable th7) {
                th = th7;
                httpPost = httpPost3;
                a = httpClient2;
            }
        }
        stringBuffer2.delete(0, stringBuffer2.length());
        if (str3.equals("")) {
            return null;
        }
        return str3;
        if (httpPost != null) {
            httpPost.abort();
        }
        if (a != null) {
            a.getConnectionManager().shutdown();
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (bufferedReader4 != null) {
            bufferedReader4.close();
        }
        throw th;
    }
}
