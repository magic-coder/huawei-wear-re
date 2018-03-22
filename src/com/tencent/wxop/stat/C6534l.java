package com.tencent.wxop.stat;

import android.content.Context;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.p527a.p528a.p529a.p530a.C6242g;
import com.tencent.p527a.p528a.p529a.p530a.C6243h;
import com.tencent.wxop.stat.p546a.C6495d;
import com.tencent.wxop.stat.p547b.C6507b;
import com.tencent.wxop.stat.p547b.C6511f;
import com.tencent.wxop.stat.p547b.C6512g;
import com.tencent.wxop.stat.p547b.C6517l;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class C6534l {
    private static C6507b f22758d = C6517l.m29740c();
    private static C6534l f22759e = null;
    private static Context f22760f = null;
    DefaultHttpClient f22761a = null;
    C6511f f22762b = null;
    StringBuilder f22763c = new StringBuilder(4096);
    private long f22764g = 0;

    private C6534l(Context context) {
        try {
            f22760f = context.getApplicationContext();
            this.f22764g = System.currentTimeMillis() / 1000;
            this.f22762b = new C6511f();
            if (C6544v.m29830b()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f22761a = new DefaultHttpClient(basicHttpParams);
            this.f22761a.setKeepAliveStrategy(new C6535m(this));
        } catch (Throwable th2) {
            f22758d.m29705b(th2);
        }
    }

    static Context m29801a() {
        return f22760f;
    }

    static void m29802a(Context context) {
        f22760f = context.getApplicationContext();
    }

    static C6534l m29803b(Context context) {
        if (f22759e == null) {
            synchronized (C6534l.class) {
                if (f22759e == null) {
                    f22759e = new C6534l(context);
                }
            }
        }
        return f22759e;
    }

    final void m29804a(C6495d c6495d, C6505k c6505k) {
        m29806b(Arrays.asList(new String[]{c6495d.m29635g()}), c6505k);
    }

    final void m29805a(List<?> list, C6505k c6505k) {
        Throwable th;
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            try {
                int i2;
                String str;
                this.f22763c.delete(0, this.f22763c.length());
                this.f22763c.append("[");
                String str2 = "rc4";
                for (i2 = 0; i2 < size; i2++) {
                    this.f22763c.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        this.f22763c.append(",");
                    }
                }
                this.f22763c.append("]");
                String stringBuilder = this.f22763c.toString();
                size = stringBuilder.length();
                String str3 = C6544v.m29849p() + "/?index=" + this.f22764g;
                this.f22764g++;
                if (C6544v.m29830b()) {
                    f22758d.m29702a("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost a = C6548z.m29898a(f22760f).m29902a();
                httpPost.addHeader("Content-Encoding", str2);
                if (a == null) {
                    this.f22761a.getParams().removeParameter(ConnRoutePNames.DEFAULT_PROXY);
                } else {
                    if (C6544v.m29830b()) {
                        f22758d.m29710g("proxy:" + a.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.f22761a.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, a);
                    httpPost.addHeader("X-Online-Host", C6544v.f22816l);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes(GameManager.DEFAULT_CHARSET);
                int length = bytes.length;
                if (size > C6544v.f22820p) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (a != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (C6544v.m29830b()) {
                        f22758d.m29710g("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(C6512g.m29720a(bytes)));
                HttpResponse execute = this.f22761a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (C6544v.m29830b()) {
                    f22758d.m29702a("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    f22758d.m29708e("Server response no data.");
                    if (c6505k != null) {
                        c6505k.mo5350b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = C6512g.m29722b(C6517l.m29736a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = C6517l.m29736a(C6512g.m29722b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = C6517l.m29736a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = C6512g.m29722b(bytes);
                        }
                    }
                    str = new String(bytes, GameManager.DEFAULT_CHARSET);
                    if (C6544v.m29830b()) {
                        f22758d.m29702a("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        try {
                            stringBuilder = jSONObject.optString("mid");
                            if (C6243h.m28695b(stringBuilder)) {
                                if (C6544v.m29830b()) {
                                    f22758d.m29702a("update mid:" + stringBuilder);
                                }
                                C6242g.m28686a(f22760f).m28688a(stringBuilder);
                            }
                            if (!jSONObject.isNull("cfg")) {
                                C6544v.m29822a(f22760f, jSONObject.getJSONObject("cfg"));
                            }
                            if (!jSONObject.isNull("ncts")) {
                                i2 = jSONObject.getInt("ncts");
                                i = (int) (((long) i2) - (System.currentTimeMillis() / 1000));
                                if (C6544v.m29830b()) {
                                    f22758d.m29702a("server time:" + i2 + ", diff time:" + i);
                                }
                                C6517l.m29769w(f22760f);
                                C6517l.m29734a(f22760f, i);
                            }
                        } catch (Throwable th2) {
                            f22758d.m29706c(th2);
                        }
                        if (c6505k != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                c6505k.mo5349a();
                            } else {
                                f22758d.m29707d("response error data.");
                                c6505k.mo5350b();
                            }
                        }
                    } else {
                        f22758d.m29707d("Server response error code:" + size + ", error:" + new String(bytes, GameManager.DEFAULT_CHARSET));
                        if (c6505k != null) {
                            c6505k.mo5350b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th2 = null;
                if (th2 != null) {
                    f22758d.m29703a(th2);
                    if (c6505k != null) {
                        try {
                            c6505k.mo5350b();
                        } catch (Throwable th3) {
                            f22758d.m29705b(th3);
                        }
                    }
                    if (th2 instanceof OutOfMemoryError) {
                        System.gc();
                        this.f22763c = null;
                        this.f22763c = new StringBuilder(2048);
                    }
                    C6548z.m29898a(f22760f).m29906d();
                }
            } catch (Throwable th4) {
            }
        }
    }

    final void m29806b(List<?> list, C6505k c6505k) {
        if (this.f22762b != null) {
            this.f22762b.m29719a(new C6536n(this, list, c6505k));
        }
    }
}
