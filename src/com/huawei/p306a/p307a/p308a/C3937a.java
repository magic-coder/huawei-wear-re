package com.huawei.p306a.p307a.p308a;

import android.content.Context;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import com.huawei.phoneserviceuni.common.p493b.C5759a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONException;

/* compiled from: NspRequestEx */
public class C3937a extends C3936b {
    private String f15138a = null;
    private String f15139b = null;
    private String f15140c = null;
    private Context f15141d = null;
    private Map<String, String> f15142e = null;
    private int f15143f = 0;

    public C3937a(Context context, String str, String str2, String str3, Map<String, String> map) {
        this.f15141d = context;
        this.f15139b = str;
        this.f15138a = str3;
        this.f15142e = map;
        this.f15140c = str2;
    }

    public void m19586a(int i) {
        this.f15143f = i;
    }

    public C3938c m19584a() {
        String a = m19580a(this.f15141d, this.f15139b, this.f15140c, this.f15138a);
        URL url = new URL(a);
        if (a.startsWith("http://")) {
            return m19585a(this.f15141d, (HttpURLConnection) url.openConnection());
        } else if (!a.startsWith("https://")) {
            return null;
        } else {
            C5759a.m26446a();
            return m19585a(this.f15141d, (HttpsURLConnection) url.openConnection());
        }
    }

    protected C3938c m19585a(Context context, HttpURLConnection httpURLConnection) {
        DataOutputStream dataOutputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        C3938c c3938c = new C3938c();
        try {
            m19583a(httpURLConnection);
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.write(m19581a(context, this.f15142e).getBytes("utf-8"));
                dataOutputStream.flush();
                c3938c.m19588a(httpURLConnection.getResponseCode());
                inputStream = httpURLConnection.getInputStream();
                c3938c.m19589a(C5767b.m26471a(inputStream));
                C5767b.m26475a(inputStream, "NspRequest");
                C5767b.m26472a(dataOutputStream, "NspRequest");
            } catch (ProtocolException e2) {
                e = e2;
                c.a(e, "NspRequest");
                throw e;
            } catch (IOException e3) {
                e = e3;
                c.a(e, "NspRequest");
                throw e;
            } catch (JSONException e4) {
                e = e4;
                c.a(e, "NspRequest");
                C5767b.m26475a(inputStream, "NspRequest");
                C5767b.m26472a(dataOutputStream, "NspRequest");
                return c3938c;
            }
        } catch (ProtocolException e5) {
            e = e5;
            dataOutputStream = null;
            c.a(e, "NspRequest");
            throw e;
        } catch (IOException e6) {
            e = e6;
            dataOutputStream = null;
            c.a(e, "NspRequest");
            throw e;
        } catch (JSONException e7) {
            e = e7;
            dataOutputStream = null;
            c.a(e, "NspRequest");
            C5767b.m26475a(inputStream, "NspRequest");
            C5767b.m26472a(dataOutputStream, "NspRequest");
            return c3938c;
        } catch (Throwable th2) {
            th = th2;
            C5767b.m26475a(inputStream, "NspRequest");
            C5767b.m26472a(dataOutputStream, "NspRequest");
            throw th;
        }
        return c3938c;
    }

    private void m19583a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
        httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        if (this.f15143f > 0) {
            c.b("NspRequest", "timeOut==" + this.f15143f);
            httpURLConnection.setConnectTimeout(this.f15143f);
            httpURLConnection.setReadTimeout(this.f15143f);
            return;
        }
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
    }
}
