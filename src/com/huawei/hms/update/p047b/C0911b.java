package com.huawei.hms.update.p047b;

import com.huawei.hms.p039c.C0854c;
import com.huawei.hms.support.log.C0887a;
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
public class C0911b implements C0910d {
    private HttpURLConnection f1502a;
    private volatile int f1503b = -1;

    public void mo2274a() {
        this.f1503b = -1;
        if (this.f1502a != null) {
            this.f1502a.disconnect();
        }
    }

    public void mo2275b() {
        this.f1503b = 1;
    }

    public int mo2271a(String str, InputStream inputStream, OutputStream outputStream) throws IOException, C0909a {
        Throwable th;
        OutputStream outputStream2;
        InputStream inputStream2;
        Throwable th2;
        InputStream inputStream3 = null;
        try {
            m3183a(str);
            this.f1502a.setRequestMethod(HttpPost.METHOD_NAME);
            OutputStream outputStream3 = this.f1502a.getOutputStream();
            try {
                m3182a(inputStream, outputStream3);
                outputStream3.flush();
                int responseCode = this.f1502a.getResponseCode();
                if (responseCode == 200) {
                    inputStream3 = this.f1502a.getInputStream();
                    try {
                        m3182a(new BufferedInputStream(inputStream3, 4096), outputStream);
                        outputStream.flush();
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream2 = outputStream3;
                        inputStream2 = inputStream3;
                        th2 = th;
                        C0854c.m3009a(inputStream2);
                        C0854c.m3010a(outputStream2);
                        throw th2;
                    }
                }
                C0854c.m3009a(inputStream3);
                C0854c.m3010a(outputStream3);
                return responseCode;
            } catch (Throwable th32) {
                th = th32;
                outputStream2 = outputStream3;
                inputStream2 = null;
                th2 = th;
                C0854c.m3009a(inputStream2);
                C0854c.m3010a(outputStream2);
                throw th2;
            }
        } catch (Throwable th322) {
            inputStream2 = null;
            th2 = th322;
            outputStream2 = null;
            C0854c.m3009a(inputStream2);
            C0854c.m3010a(outputStream2);
            throw th2;
        }
    }

    public int mo2272a(String str, OutputStream outputStream) throws IOException, C0909a {
        return mo2273a(str, outputStream, 0, 0);
    }

    public int mo2273a(String str, OutputStream outputStream, int i, int i2) throws IOException, C0909a {
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        InputStream inputStream2 = null;
        try {
            m3183a(str);
            this.f1502a.setRequestMethod(HttpGet.METHOD_NAME);
            if (i > 0) {
                this.f1502a.addRequestProperty("Range", "bytes=" + i + "-" + i2);
            }
            int responseCode = this.f1502a.getResponseCode();
            if ((i > 0 && responseCode == 206) || (i <= 0 && responseCode == 200)) {
                inputStream2 = this.f1502a.getInputStream();
                try {
                    m3182a(new BufferedInputStream(inputStream2, 4096), outputStream);
                    outputStream.flush();
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    th2 = th;
                    C0854c.m3009a(inputStream);
                    throw th2;
                }
            }
            C0854c.m3009a(inputStream2);
            return responseCode;
        } catch (Throwable th32) {
            th = th32;
            inputStream = null;
            th2 = th;
            C0854c.m3009a(inputStream);
            throw th2;
        }
    }

    private void m3183a(String str) throws IOException {
        if (this.f1503b == 0) {
            C0887a.m3098d("HttpRequestHelper", "Not allowed to repeat open http(s) connection.");
        }
        this.f1502a = (HttpURLConnection) new URL(str).openConnection();
        if (this.f1502a instanceof HttpsURLConnection) {
            C0912c.m3189a((HttpsURLConnection) this.f1502a);
        }
        this.f1502a.setConnectTimeout(30000);
        this.f1502a.setReadTimeout(30000);
        this.f1502a.setDoInput(true);
        this.f1502a.setDoOutput(true);
        this.f1502a.setUseCaches(false);
        this.f1503b = 0;
    }

    private void m3182a(InputStream inputStream, OutputStream outputStream) throws IOException, C0909a {
        byte[] bArr = new byte[4096];
        do {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        } while (this.f1503b != 1);
        throw new C0909a("HTTP(s) request was canceled.");
    }
}
