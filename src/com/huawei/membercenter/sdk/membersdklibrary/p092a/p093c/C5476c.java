package com.huawei.membercenter.sdk.membersdklibrary.p092a.p093c;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.gson.Gson;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p093c.C5475d.C5477a;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5481c;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5482d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5486h;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;

/* compiled from: NspRequest */
public class C5476c extends C5475d {
    private String f19331a = null;
    private Context f19332b = null;
    private Object f19333c = null;
    private boolean f19334d = true;
    private boolean f19335e;

    public C5476c(Context context, String str, Object obj, boolean z, boolean z2) {
        this.f19332b = context;
        this.f19331a = str;
        this.f19333c = obj;
        this.f19334d = z;
        this.f19335e = z2;
    }

    public C5477a m26176a() {
        URL url = new URL(this.f19331a);
        if ("https://ccpc-cn.consumer.huawei.com/ccpcmd/services/dispatch".startsWith("http://")) {
            return m26173a((HttpURLConnection) url.openConnection());
        }
        if (!"https://ccpc-cn.consumer.huawei.com/ccpcmd/services/dispatch".startsWith("https://")) {
            return null;
        }
        C5481c.m26182a();
        return m26173a((HttpsURLConnection) url.openConnection());
    }

    @SuppressLint({"UseSparseArrays"})
    private C5477a m26173a(HttpURLConnection httpURLConnection) {
        OutputStream dataOutputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        C5477a c5477a = new C5477a();
        try {
            m26175b(httpURLConnection);
            String b = m26174b();
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.write(b.getBytes("utf-8"));
                dataOutputStream.flush();
                c5477a.m26178a(httpURLConnection.getResponseCode());
                inputStream = httpURLConnection.getInputStream();
                c5477a.m26179a(C5486h.m26196a(inputStream));
                C5486h.m26200a(inputStream, "NspRequest");
                C5486h.m26201a(dataOutputStream, "NspRequest");
            } catch (ProtocolException e2) {
                e = e2;
                try {
                    C5486h.m26202a(e, "NspRequest");
                    C5486h.m26200a(inputStream, "NspRequest");
                    C5486h.m26201a(dataOutputStream, "NspRequest");
                    return c5477a;
                } catch (Throwable th2) {
                    th = th2;
                    C5486h.m26200a(inputStream, "NspRequest");
                    C5486h.m26201a(dataOutputStream, "NspRequest");
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                C5486h.m26202a(e, "NspRequest");
                C5486h.m26200a(inputStream, "NspRequest");
                C5486h.m26201a(dataOutputStream, "NspRequest");
                return c5477a;
            } catch (JSONException e4) {
                e = e4;
                C5486h.m26202a(e, "NspRequest");
                C5486h.m26200a(inputStream, "NspRequest");
                C5486h.m26201a(dataOutputStream, "NspRequest");
                return c5477a;
            } catch (Exception e5) {
                e = e5;
                C5482d.m26186d("NspRequest", e.getMessage());
                C5486h.m26200a(inputStream, "NspRequest");
                C5486h.m26201a(dataOutputStream, "NspRequest");
                return c5477a;
            }
        } catch (ProtocolException e6) {
            e = e6;
            dataOutputStream = null;
            C5486h.m26202a(e, "NspRequest");
            C5486h.m26200a(inputStream, "NspRequest");
            C5486h.m26201a(dataOutputStream, "NspRequest");
            return c5477a;
        } catch (IOException e7) {
            e = e7;
            dataOutputStream = null;
            C5486h.m26202a(e, "NspRequest");
            C5486h.m26200a(inputStream, "NspRequest");
            C5486h.m26201a(dataOutputStream, "NspRequest");
            return c5477a;
        } catch (JSONException e8) {
            e = e8;
            dataOutputStream = null;
            C5486h.m26202a(e, "NspRequest");
            C5486h.m26200a(inputStream, "NspRequest");
            C5486h.m26201a(dataOutputStream, "NspRequest");
            return c5477a;
        } catch (Exception e9) {
            e = e9;
            dataOutputStream = null;
            C5482d.m26186d("NspRequest", e.getMessage());
            C5486h.m26200a(inputStream, "NspRequest");
            C5486h.m26201a(dataOutputStream, "NspRequest");
            return c5477a;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            C5486h.m26200a(inputStream, "NspRequest");
            C5486h.m26201a(dataOutputStream, "NspRequest");
            throw th;
        }
        return c5477a;
    }

    private void m26175b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
    }

    private String m26174b() {
        return new Gson().toJson(this.f19333c);
    }
}
