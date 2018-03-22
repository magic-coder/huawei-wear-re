package com.amap.api.services.core;

import android.os.Build.VERSION;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: HttpUrlUtil */
public class bq {
    private static br f12463a;
    private static TrustManager f12464g = new bw();
    private int f12465b;
    private int f12466c;
    private boolean f12467d;
    private SSLContext f12468e;
    private Proxy f12469f;

    public static void m16850a(br brVar) {
        f12463a = brVar;
    }

    bq(int i, int i2, Proxy proxy, boolean z) {
        this.f12465b = i;
        this.f12466c = i2;
        this.f12469f = proxy;
        this.f12467d = z;
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
                instance.init(null, new TrustManager[]{f12464g}, null);
                this.f12468e = instance;
            } catch (Throwable e) {
                ay.m16709a(e, "HttpUrlUtil", "HttpUrlUtil");
                e.printStackTrace();
            } catch (Throwable e2) {
                ay.m16709a(e2, "HttpUrlUtil", "HttpUrlUtil");
                e2.printStackTrace();
            } catch (Throwable e22) {
                ay.m16709a(e22, "HttpUtil", "HttpUtil");
                e22.printStackTrace();
            }
        }
    }

    bv m16852a(String str, Map<String, String> map, Map<String, String> map2) throws C3433v {
        try {
            String a = m16848a((Map) map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a != null) {
                stringBuffer.append(LocationInfo.NA).append(a);
            }
            HttpURLConnection a2 = m16849a(new URL(stringBuffer.toString()));
            m16851a(map, a2);
            a2.setRequestMethod(HttpGet.METHOD_NAME);
            a2.setDoInput(true);
            a2.connect();
            return m16847a(a2);
        } catch (Throwable e) {
            ay.m16709a(e, "HttpUrlUtil", "getRequest");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            ay.m16709a(e2, "HttpUrlUtil", "getRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            ay.m16709a(e22, "HttpUrlUtil", "getRequest");
            e22.printStackTrace();
            return null;
        }
    }

    bv m16854a(String str, Map<String, String> map, Map<String, String> map2, byte[] bArr) throws C3433v {
        if (map2 != null) {
            try {
                String a = m16848a((Map) map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a != null) {
                    stringBuffer.append(LocationInfo.NA).append(a);
                }
                str = stringBuffer.toString();
            } catch (Throwable th) {
                ay.m16709a(th, "HttpUrlUtil", "PostReqeust3");
                th.printStackTrace();
                return null;
            }
        }
        return m16855a(str, (Map) map, bArr);
    }

    bv m16855a(String str, Map<String, String> map, byte[] bArr) throws C3433v {
        try {
            HttpURLConnection a = m16849a(new URL(str));
            m16851a(map, a);
            a.setRequestMethod(HttpPost.METHOD_NAME);
            a.setUseCaches(false);
            a.setDoInput(true);
            a.setDoOutput(true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            a.connect();
            return m16847a(a);
        } catch (Throwable e) {
            ay.m16709a(e, "HttpUrlUtil", "postRequest");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            ay.m16709a(e2, "HttpUrlUtil", "postRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            ay.m16709a(e22, "HttpUrlUtil", "postRequest");
            e22.printStackTrace();
            return null;
        }
    }

    bv m16856b(String str, Map<String, String> map, Map<String, String> map2) throws C3433v {
        String a = m16848a((Map) map2);
        if (a == null) {
            return m16855a(str, (Map) map, new byte[0]);
        }
        try {
            return m16855a(str, (Map) map, a.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (Throwable e) {
            ay.m16709a(e, "HttpUrlUtil", "postRequest1");
            e.printStackTrace();
            return m16855a(str, (Map) map, a.getBytes());
        }
    }

    bv m16853a(String str, Map<String, String> map, Map<String, String> map2, HttpEntity httpEntity) throws C3433v {
        Throwable e;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Exception exception;
        bv bvVar = null;
        if (map2 != null) {
            try {
                String a = m16848a((Map) map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a != null) {
                    stringBuffer.append(LocationInfo.NA).append(a);
                }
                str = stringBuffer.toString();
            } catch (IllegalStateException e2) {
                e = e2;
                Object obj = bvVar;
                Object obj2 = bvVar;
                try {
                    ay.m16709a(e, "HttpUrlUtil", "postRequest2");
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e3) {
                            ay.m16709a(e3, "HttpUrlUtil", "postRequest2");
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            e3 = e4;
                            ay.m16709a(e3, "HttpUrlUtil", "postRequest2");
                            exception.printStackTrace();
                            return bvVar;
                        }
                    }
                    return bvVar;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e32) {
                            ay.m16709a(e32, "HttpUrlUtil", "postRequest2");
                            e32.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e322) {
                            ay.m16709a(e322, "HttpUrlUtil", "postRequest2");
                            e322.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e322 = e5;
                inputStream = bvVar;
                byteArrayOutputStream = bvVar;
                ay.m16709a(e322, "HttpUrlUtil", "postRequest2");
                e322.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e3222) {
                        ay.m16709a(e3222, "HttpUrlUtil", "postRequest2");
                        e3222.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        e3222 = e6;
                        ay.m16709a(e3222, "HttpUrlUtil", "postRequest2");
                        exception.printStackTrace();
                        return bvVar;
                    }
                }
                return bvVar;
            } catch (Throwable e32222) {
                Throwable th2;
                inputStream = bvVar;
                byteArrayOutputStream = bvVar;
                th2 = e32222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th2;
            }
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = httpEntity.getContent();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                bvVar = m16855a(str, (Map) map, byteArrayOutputStream.toByteArray());
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e322222) {
                        ay.m16709a(e322222, "HttpUrlUtil", "postRequest2");
                        e322222.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                        exception = e7;
                        ay.m16709a((Throwable) exception, "HttpUrlUtil", "postRequest2");
                        exception.printStackTrace();
                        return bvVar;
                    }
                }
            } catch (IllegalStateException e8) {
                e322222 = e8;
                ay.m16709a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bvVar;
            } catch (IOException e9) {
                e322222 = e9;
                ay.m16709a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bvVar;
            } catch (Throwable th3) {
                e322222 = th3;
                ay.m16709a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bvVar;
            }
        } catch (IllegalStateException e10) {
            e322222 = e10;
            obj = bvVar;
            ay.m16709a(e322222, "HttpUrlUtil", "postRequest2");
            e322222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bvVar;
        } catch (IOException e11) {
            e322222 = e11;
            obj = bvVar;
            ay.m16709a(e322222, "HttpUrlUtil", "postRequest2");
            e322222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bvVar;
        } catch (Throwable e3222222) {
            obj = bvVar;
            th2 = e3222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th2;
        }
        return bvVar;
    }

    private void m16851a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        httpURLConnection.setConnectTimeout(this.f12465b);
        httpURLConnection.setReadTimeout(this.f12466c);
    }

    private HttpURLConnection m16849a(URL url) throws IOException {
        HttpURLConnection httpURLConnection;
        if (this.f12469f != null) {
            URLConnection openConnection = url.openConnection(this.f12469f);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f12467d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f12468e.getSocketFactory());
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        return httpURLConnection;
    }

    private bv m16847a(HttpURLConnection httpURLConnection) throws C3433v, IOException {
        InputStream inputStream;
        IOException e;
        Throwable th;
        InputStream inputStream2;
        PushbackInputStream pushbackInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream pushbackInputStream2;
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new C3433v("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
            }
            byte[] bArr;
            InputStream gZIPInputStream;
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    pushbackInputStream2 = new PushbackInputStream(inputStream, 2);
                } catch (IOException e2) {
                    e = e2;
                    pushbackInputStream2 = null;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pushbackInputStream2 = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e3) {
                            ay.m16709a(e3, "HttpUrlUtil", "parseResult");
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e4) {
                            ay.m16709a(e4, "HttpUrlUtil", "parseResult");
                            e4.printStackTrace();
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable e5) {
                            ay.m16709a(e5, "HttpUrlUtil", "parseResult");
                            e5.printStackTrace();
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable e52) {
                            ay.m16709a(e52, "HttpUrlUtil", "parseResult");
                            e52.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable e522) {
                            ay.m16709a(e522, "HttpUrlUtil", "parseResult");
                            e522.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                pushbackInputStream2 = null;
                inputStream = null;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                pushbackInputStream2 = null;
                inputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bArr = new byte[2];
                pushbackInputStream2.read(bArr);
                pushbackInputStream2.unread(bArr);
                if (bArr[0] == TagName.TRADE_STATUS && bArr[1] == TagName.PAY_CHANNEL_MIN) {
                    gZIPInputStream = new GZIPInputStream(pushbackInputStream2);
                } else {
                    gZIPInputStream = pushbackInputStream2;
                }
            } catch (IOException e7) {
                e = e7;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th5) {
                th = th5;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (f12463a != null) {
                    f12463a.mo4110a();
                }
                bv bvVar = new bv();
                bvVar.f12476a = byteArrayOutputStream.toByteArray();
                bvVar.f12477b = headerFields;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e32) {
                        ay.m16709a(e32, "HttpUrlUtil", "parseResult");
                        e32.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e42) {
                        ay.m16709a(e42, "HttpUrlUtil", "parseResult");
                        e42.printStackTrace();
                    }
                }
                if (pushbackInputStream2 != null) {
                    try {
                        pushbackInputStream2.close();
                    } catch (Throwable e8) {
                        ay.m16709a(e8, "HttpUrlUtil", "parseResult");
                        e8.printStackTrace();
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable e5222) {
                        ay.m16709a(e5222, "HttpUrlUtil", "parseResult");
                        e5222.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e52222) {
                        ay.m16709a(e52222, "HttpUrlUtil", "parseResult");
                        e52222.printStackTrace();
                    }
                }
                return bvVar;
            } catch (IOException e9) {
                e = e9;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = gZIPInputStream;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = gZIPInputStream;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            pushbackInputStream2 = null;
            inputStream = null;
            byteArrayOutputStream = null;
            throw e;
        } catch (Throwable th7) {
            th = th7;
            pushbackInputStream2 = null;
            inputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (pushbackInputStream != null) {
                pushbackInputStream.close();
            }
            if (pushbackInputStream2 != null) {
                pushbackInputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private String m16848a(Map<String, String> map) {
        List linkedList = new LinkedList();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        if (linkedList.size() > 0) {
            return URLEncodedUtils.format(linkedList, GameManager.DEFAULT_CHARSET);
        }
        return null;
    }
}
