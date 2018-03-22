package com.huawei.hwid.update.p451b;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p075d.C5207c;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/* compiled from: HttpRequestHelper */
public class C5273b implements C5272d {
    private HttpURLConnection f18956a;
    private volatile int f18957b = -1;

    public void mo4661a() {
        this.f18957b = -1;
        if (this.f18956a != null) {
            this.f18956a.disconnect();
        }
    }

    public void mo4662b() {
        this.f18957b = 1;
    }

    public int mo4658a(String str, InputStream inputStream, OutputStream outputStream) throws IOException, C5271a {
        Throwable th;
        OutputStream outputStream2;
        InputStream inputStream2;
        Throwable th2;
        InputStream inputStream3 = null;
        try {
            m25537a(str);
            this.f18956a.setRequestMethod(HttpPost.METHOD_NAME);
            OutputStream outputStream3 = this.f18956a.getOutputStream();
            try {
                m25536a(inputStream, outputStream3);
                outputStream3.flush();
                int responseCode = this.f18956a.getResponseCode();
                if (responseCode == 200) {
                    inputStream3 = this.f18956a.getInputStream();
                    try {
                        m25536a(new BufferedInputStream(inputStream3, 4096), outputStream);
                        outputStream.flush();
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream2 = outputStream3;
                        inputStream2 = inputStream3;
                        th2 = th;
                        C5207c.m25333a(inputStream2);
                        C5207c.m25334a(outputStream2);
                        throw th2;
                    }
                }
                C5207c.m25333a(inputStream3);
                C5207c.m25334a(outputStream3);
                return responseCode;
            } catch (Throwable th32) {
                th = th32;
                outputStream2 = outputStream3;
                inputStream2 = null;
                th2 = th;
                C5207c.m25333a(inputStream2);
                C5207c.m25334a(outputStream2);
                throw th2;
            }
        } catch (Throwable th322) {
            inputStream2 = null;
            th2 = th322;
            outputStream2 = null;
            C5207c.m25333a(inputStream2);
            C5207c.m25334a(outputStream2);
            throw th2;
        }
    }

    public int mo4659a(String str, OutputStream outputStream) throws IOException, C5271a {
        return mo4660a(str, outputStream, 0, 0);
    }

    public int mo4660a(String str, OutputStream outputStream, int i, int i2) throws IOException, C5271a {
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        InputStream inputStream2 = null;
        try {
            m25537a(str);
            this.f18956a.setRequestMethod(HttpGet.METHOD_NAME);
            if (i > 0) {
                this.f18956a.addRequestProperty("Range", "bytes=" + i + "-" + i2);
            }
            int responseCode = this.f18956a.getResponseCode();
            if ((i > 0 && responseCode == 206) || (i <= 0 && responseCode == 200)) {
                inputStream2 = this.f18956a.getInputStream();
                try {
                    m25536a(new BufferedInputStream(inputStream2, 4096), outputStream);
                    outputStream.flush();
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    th2 = th;
                    C5207c.m25333a(inputStream);
                    throw th2;
                }
            }
            C5207c.m25333a(inputStream2);
            return responseCode;
        } catch (Throwable th32) {
            th = th32;
            inputStream = null;
            th2 = th;
            C5207c.m25333a(inputStream);
            throw th2;
        }
    }

    private void m25537a(String str) throws IOException {
        if (this.f18957b == 0) {
            C5165e.m24910d("HttpRequestHelper", "Not allowed to repeat open http(s) connection.");
        }
        this.f18956a = (HttpURLConnection) new URL(str).openConnection();
        if (this.f18956a instanceof HttpsURLConnection) {
            C5274c.m25543a((HttpsURLConnection) this.f18956a);
        }
        this.f18956a.setConnectTimeout(30000);
        this.f18956a.setReadTimeout(30000);
        this.f18956a.setDoInput(true);
        this.f18956a.setDoOutput(true);
        this.f18956a.setUseCaches(false);
        this.f18957b = 0;
    }

    private void m25536a(InputStream inputStream, OutputStream outputStream) throws IOException, C5271a {
        byte[] bArr = new byte[4096];
        do {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        } while (this.f18957b != 1);
        throw new C5271a("HTTP(s) request was canceled.");
    }
}
