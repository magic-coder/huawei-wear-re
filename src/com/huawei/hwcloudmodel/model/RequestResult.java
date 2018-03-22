package com.huawei.hwcloudmodel.model;

import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

public class RequestResult {
    private HttpURLConnection con;
    private InputStream is;
    private String responseAsString = null;
    private int statusCode;

    public RequestResult(HttpURLConnection httpURLConnection) throws IOException {
        this.con = httpURLConnection;
        this.statusCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.is = errorStream;
        if (errorStream == null) {
            this.is = httpURLConnection.getInputStream();
        }
        if (this.is != null && "gzip".equals(httpURLConnection.getContentEncoding())) {
            this.is = new GZIPInputStream(this.is);
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public InputStream asStream() {
        return this.is;
    }

    public byte[] asByte() throws IOException {
        byte[] bArr = new byte[1024];
        InputStream asStream = asStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (true) {
            try {
                int read = asStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i += read;
            } catch (IOException e) {
                C2538c.e("", new Object[]{"Exception e = " + e.getMessage()});
            }
        }
        asStream.close();
        this.con.disconnect();
        return byteArrayOutputStream.toByteArray();
    }

    public String asString() throws Exception {
        if (this.responseAsString == null) {
            try {
                InputStream asStream = asStream();
                if (asStream == null) {
                    return null;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(asStream, GameManager.DEFAULT_CHARSET));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (stringBuffer != null) {
                        try {
                            stringBuffer.append(readLine);
                        } catch (Exception e) {
                            C2538c.e("RequestResult", new Object[]{"Exception e = " + e.getMessage()});
                            this.responseAsString = "";
                        }
                    }
                }
                this.responseAsString = stringBuffer.toString();
                stringBuffer.delete(0, stringBuffer.length());
                bufferedReader.close();
                asStream.close();
                this.con.disconnect();
            } catch (NullPointerException e2) {
                C2538c.e("RequestResult", new Object[]{"Exception e = " + e2.getMessage()});
            } catch (IOException e3) {
                C2538c.b("error IOException", new Object[]{e3.getMessage()});
            }
        }
        return this.responseAsString;
    }

    public void asFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                C2538c.e("RequestResult", new Object[]{"Exception e = " + e.getMessage()});
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(asByte());
            fileOutputStream.flush();
        } catch (Exception e2) {
            C2538c.e("RequestResult", new Object[]{"Exception e = " + e2.getMessage()});
        } finally {
            fileOutputStream.close();
        }
    }
}
