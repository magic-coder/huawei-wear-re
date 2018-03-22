package com.tencent.open.yyb;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ProGuard */
class C6431g extends AsyncTask<String, Void, byte[]> {
    private C6428f f22315a;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m29325a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m29324a((byte[]) obj);
    }

    public C6431g(C6428f c6428f) {
        this.f22315a = c6428f;
    }

    protected byte[] m29325a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                httpURLConnection.setConnectTimeout(5000);
                try {
                    httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            if (httpURLConnection.getResponseCode() == 200) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        byteArrayOutputStream.close();
                                        inputStream.close();
                                        return byteArrayOutputStream.toByteArray();
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (ProtocolException e3) {
                    e3.printStackTrace();
                    return null;
                }
            } catch (IOException e22) {
                e22.printStackTrace();
                return null;
            }
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    protected void m29324a(byte[] bArr) {
        super.onPostExecute(bArr);
        this.f22315a.mo5341a(bArr);
    }
}
