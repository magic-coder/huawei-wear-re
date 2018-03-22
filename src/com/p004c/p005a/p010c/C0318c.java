package com.p004c.p005a.p010c;

import com.p004c.p005a.p008b.p009a.C0313a;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;

public final class C0318c {
    public static boolean m159a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        IOException iOException;
        Throwable th;
        OutputStream outputStream = null;
        boolean z = true;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                C0313a.m146h();
                httpURLConnection2.setRequestMethod(HttpPost.METHOD_NAME);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                int responseCode = httpURLConnection2.getResponseCode();
                C0313a.m146h();
                if (responseCode != 200) {
                    z = false;
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (httpURLConnection2 == null) {
                    return z;
                }
                httpURLConnection2.disconnect();
                C0313a.m146h();
                return z;
            } catch (IOException e2) {
                IOException iOException2 = e2;
                httpURLConnection = httpURLConnection2;
                iOException = iOException2;
                try {
                    new StringBuilder("IOException:").append(iOException.getMessage());
                    C0313a.m146h();
                    iOException.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException iOException3) {
                            iOException3.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        C0313a.m146h();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        C0313a.m146h();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection = httpURLConnection2;
                th = th4;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    C0313a.m146h();
                }
                throw th;
            }
        } catch (IOException e4) {
            iOException3 = e4;
            httpURLConnection = null;
            new StringBuilder("IOException:").append(iOException3.getMessage());
            C0313a.m146h();
            iOException3.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                C0313a.m146h();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                C0313a.m146h();
            }
            throw th;
        }
    }
}
