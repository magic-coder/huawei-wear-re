package com.huawei.common.applog.p380a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.common.applog.bean.C4349b;
import com.huawei.common.applog.bean.C4351e;
import com.huawei.logupload.c.h;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.phoneserviceuni.common.d.a;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5767b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.zip.DeflaterOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReportRequestManage */
public class C4346b {
    static final char[] f16160a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private BlockingQueue<HashMap<String, String>> f16161b = null;

    public void m20896a(Context context, boolean z, boolean z2) {
        this.f16161b = C4349b.m20911a().m20918f();
        if (this.f16161b.size() == 0) {
            c.d("ReportApi/ReportRequestManage", "reportRequest MessageQueue is empty , timer cancel");
            C4349b.m20911a().m20916d();
            C4351e.m20921a().m20924c();
        } else if (com.huawei.feedback.c.p(context)) {
            for (Entry entry : m20892a().entrySet()) {
                String str = (String) entry.getKey();
                ArrayList arrayList = (ArrayList) entry.getValue();
                if (arrayList == null || arrayList.size() <= 0) {
                    c.d("ReportApi/ReportRequestManage", str + "reportRequest list is Empty");
                } else {
                    m20893a(context, z, str, arrayList);
                }
            }
        } else {
            if (z2) {
                C4349b.m20911a().m20916d();
            }
            c.d("ReportApi/ReportRequestManage", "reportRequest network is not connected");
        }
    }

    private HashMap<String, ArrayList<String>> m20892a() {
        HashMap<String, ArrayList<String>> hashMap = new HashMap();
        int size = this.f16161b.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap2 = (HashMap) this.f16161b.poll();
            Object obj = "";
            Object obj2 = "";
            if (hashMap2 != null) {
                obj = (String) hashMap2.get(SNBConstant.FIELD_PKG);
                obj2 = (String) hashMap2.get("msg_value");
            }
            ArrayList arrayList = (ArrayList) hashMap.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(obj2);
            hashMap.put(obj, arrayList);
        }
        return hashMap;
    }

    private static byte[] m20895b(byte[] bArr) {
        DeflaterOutputStream deflaterOutputStream;
        byte[] toByteArray;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                try {
                    deflaterOutputStream.write(bArr);
                    deflaterOutputStream.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    if (deflaterOutputStream != null) {
                        try {
                            deflaterOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            c.d("ReportApi/ReportRequestManage", "packData getZipBts IOException:" + e);
                        }
                    }
                } catch (IOException e2) {
                    try {
                        c.d("ReportApi/ReportRequestManage", "packData getZipBts IOException");
                        toByteArray = new byte[1];
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                c.d("ReportApi/ReportRequestManage", "packData getZipBts IOException:" + e3);
                            }
                        }
                        return toByteArray;
                    } catch (Throwable th2) {
                        th = th2;
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e32) {
                                c.d("ReportApi/ReportRequestManage", "packData getZipBts IOException:" + e32);
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                deflaterOutputStream = null;
                c.d("ReportApi/ReportRequestManage", "packData getZipBts IOException");
                toByteArray = new byte[1];
                if (deflaterOutputStream != null) {
                    deflaterOutputStream.close();
                    byteArrayOutputStream.close();
                }
                return toByteArray;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                deflaterOutputStream = null;
                th = th4;
                if (deflaterOutputStream != null) {
                    deflaterOutputStream.close();
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            deflaterOutputStream = null;
            byteArrayOutputStream = null;
            c.d("ReportApi/ReportRequestManage", "packData getZipBts IOException");
            toByteArray = new byte[1];
            if (deflaterOutputStream != null) {
                deflaterOutputStream.close();
                byteArrayOutputStream.close();
            }
            return toByteArray;
        } catch (Throwable th32) {
            byteArrayOutputStream = null;
            th = th32;
            deflaterOutputStream = null;
            if (deflaterOutputStream != null) {
                deflaterOutputStream.close();
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return toByteArray;
    }

    private void m20893a(Context context, boolean z, String str, ArrayList<String> arrayList) {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2;
        InputStream inputStream2 = null;
        if (z) {
            try {
                c.c("ReportApi/ReportRequestManage", "start http");
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://opsdata.hicloud.com:8089/sdkv2").openConnection();
            } catch (MalformedURLException e) {
                inputStream = null;
                try {
                    c.d("ReportApi/ReportRequestManage", "MalformedURLException");
                    C5767b.m26475a(inputStream, "ReportApi/ReportRequestManage");
                    C5767b.m26472a(dataOutputStream, "ReportApi/ReportRequestManage");
                    C4349b.m20911a().m20916d();
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    inputStream2 = inputStream;
                    r0 = th;
                    C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
                    C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
                    C4349b.m20911a().m20916d();
                    throw r0;
                }
            } catch (ProtocolException e2) {
                dataOutputStream2 = null;
                try {
                    c.d("ReportApi/ReportRequestManage", "ProtocolException");
                    C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
                    C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
                    C4349b.m20911a().m20916d();
                } catch (Throwable th3) {
                    r0 = th3;
                    C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
                    C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
                    C4349b.m20911a().m20916d();
                    throw r0;
                }
            } catch (IOException e3) {
                dataOutputStream2 = null;
                c.d("ReportApi/ReportRequestManage", "urlConnection IOException");
                C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
                C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
                C4349b.m20911a().m20916d();
            } catch (Throwable th4) {
                Throwable th5;
                th5 = th4;
                dataOutputStream2 = null;
                C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
                C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
                C4349b.m20911a().m20916d();
                throw th5;
            }
        }
        c.c("ReportApi/ReportRequestManage", "start https");
        URL url = new URL("https://opsdata.hicloud.com/sdkv2");
        h.c();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        if (httpURLConnection == null) {
            c.d("ReportApi/ReportRequestManage", "httpConnection fail empty");
            C5767b.m26475a(null, "ReportApi/ReportRequestManage");
            C5767b.m26472a(null, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
            return;
        }
        httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.connect();
        dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            byte[] a = m20894a(context, str, (ArrayList) arrayList);
            if (a.length > 0) {
                dataOutputStream2.write(a);
            } else {
                c.d("ReportApi/ReportRequestManage", "requestData is null");
            }
            dataOutputStream2.flush();
            c.d("ReportApi/ReportRequestManage", "ResponseCode()==" + httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
        } catch (MalformedURLException e4) {
            inputStream = null;
            dataOutputStream = dataOutputStream2;
            c.d("ReportApi/ReportRequestManage", "MalformedURLException");
            C5767b.m26475a(inputStream, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        } catch (ProtocolException e5) {
            c.d("ReportApi/ReportRequestManage", "ProtocolException");
            C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        } catch (IOException e6) {
            c.d("ReportApi/ReportRequestManage", "urlConnection IOException");
            C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        }
        try {
            c.b("ReportApi/ReportRequestManage", "response ==" + C5767b.m26471a(inputStream));
            C5767b.m26475a(inputStream, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        } catch (MalformedURLException e7) {
            dataOutputStream = dataOutputStream2;
            c.d("ReportApi/ReportRequestManage", "MalformedURLException");
            C5767b.m26475a(inputStream, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        } catch (ProtocolException e8) {
            inputStream2 = inputStream;
            c.d("ReportApi/ReportRequestManage", "ProtocolException");
            C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        } catch (IOException e9) {
            inputStream2 = inputStream;
            c.d("ReportApi/ReportRequestManage", "urlConnection IOException");
            C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            th5 = th;
            C5767b.m26475a(inputStream2, "ReportApi/ReportRequestManage");
            C5767b.m26472a(dataOutputStream2, "ReportApi/ReportRequestManage");
            C4349b.m20911a().m20916d();
            throw th5;
        }
    }

    private byte[] m20894a(Context context, String str, ArrayList<String> arrayList) {
        String str2 = "";
        String str3 = "";
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.s());
        stringBuilder.append("," + a.b());
        stringBuilder.append("," + a.c());
        try {
            JSONArray jSONArray = new JSONArray();
            String str4 = str2;
            for (int i = 0; i < arrayList.size(); i++) {
                JSONObject jSONObject3 = new JSONObject();
                String str5 = (String) arrayList.get(i);
                StringBuilder stringBuilder2 = new StringBuilder();
                if (!TextUtils.isEmpty(str5)) {
                    String[] split = str5.split("\\|");
                    if (split.length > 2) {
                        str5 = str3;
                        str3 = str4;
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (i2 == 0) {
                                str5 = split[0];
                            } else if (i2 == 1) {
                                str3 = split[1];
                            } else {
                                stringBuilder2.append(split[i2]).append("|");
                            }
                        }
                        str4 = str3;
                        str3 = str5;
                    }
                    jSONObject3.put("e", stringBuilder2.deleteCharAt(stringBuilder2.length() - 1).toString());
                    jSONObject3.put("h", str3);
                }
                jSONArray.put(jSONObject3);
            }
            jSONObject2.put("s", jSONArray);
            stringBuilder.append("," + str4);
            jSONObject2.put("g", stringBuilder.toString());
            jSONObject2.put("tm", C4345a.m20883a());
            jSONObject.put("vs", "11");
            jSONObject.put("sn", "1");
            jSONObject.put("pn", str);
            jSONObject.put("ed", C4346b.m20891a(C4346b.m20895b(jSONObject2.toString().getBytes("utf-8"))));
            jSONObject.put("ek", "");
            c.b("ReportApi/ReportRequestManage", "packData==:" + jSONObject.toString());
            return jSONObject.toString().getBytes("utf-8");
        } catch (JSONException e) {
            c.d("ReportApi/ReportRequestManage", "packData JSONException:");
        } catch (UnsupportedEncodingException e2) {
            c.d("ReportApi/ReportRequestManage", "packData UnsupportedEncodingException:");
        }
        return new byte[0];
    }

    public static String m20891a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(f16160a[(b & 240) >> 4]).append(f16160a[b & 15]);
        }
        return stringBuilder.toString();
    }
}
