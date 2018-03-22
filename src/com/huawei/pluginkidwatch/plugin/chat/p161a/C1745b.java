package com.huawei.pluginkidwatch.plugin.chat.p161a;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.common.util.EncryptUtil;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.ui.login.C1093a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.SecretItem;
import com.huawei.pluginkidwatch.common.lib.p145d.C1475h;
import com.huawei.pluginkidwatch.common.lib.utils.C1481a;
import com.huawei.pluginkidwatch.common.lib.utils.C1487g;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.ab;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: CloudUtil */
public class C1745b {
    private static String f4788b = "";
    private static final byte[] f4789c = new byte[0];
    private Context f4790a;

    public C1745b(Context context) {
        this.f4790a = context.getApplicationContext();
    }

    public static void m8473a(String str) {
        f4788b = str;
    }

    public String m8478a() {
        HttpEntity entity;
        InputStream content;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Exception e;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        Throwable th;
        HttpEntity httpEntity = null;
        C2538c.m12674b("CloudUtil", "==ww==  entry  executeGet ");
        if ("".equals(f4788b) || f4788b == null) {
            C1745b.m8473a(C1487g.m6873a(this.f4790a, "09F98935DF23B3E011F5638614670662IrzLoccccR72B/H4EI3GKB6ny7lTZGH7IB4hQWa2qra9LliDA6e9/qgL/9yUjVL0"));
        }
        String str = System.currentTimeMillis() + "";
        String str2 = "";
        if (f4788b == null) {
            C2538c.m12674b("CloudUtil", "executeGet fragement is null");
            str = "https://health.vmall.com/v2/rest?method=com.huawei.watchApp.uploadFile&appID=10131836&sign=&ts=" + str + "&type=voice&filePost=voice&uploadAppID=82619&client=" + C1462f.m6746j();
        } else {
            str = "https://health.vmall.com/v2/rest?method=com.huawei.watchApp.uploadFile&appID=10131836&sign=" + m8470a(EncryptUtil.HEALTH_APP_ID + str, f4788b) + "&ts=" + str + "&type=voice&filePost=voice&uploadAppID=82619&client=" + C1462f.m6746j();
        }
        C2538c.m12674b("CloudUtil", "==ww==executeGet huid=  " + C1462f.m6744i());
        C2538c.m12674b("CloudUtil", "==ww==executeGet base huid=  " + C1492l.m6908a(C1462f.m6744i()));
        C2538c.m12674b("CloudUtil", "==ww==executeGet url=  " + str);
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
            defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(30000));
            defaultHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", new C1475h(KeyStore.getInstance(KeyStore.getDefaultType()), this.f4790a), 443));
            HttpUriRequest httpGet = new HttpGet();
            httpGet.setURI(new URI(str));
            entity = defaultHttpClient.execute(httpGet).getEntity();
            try {
                content = entity.getContent();
                try {
                    inputStreamReader = new InputStreamReader(content, GameManager.DEFAULT_CHARSET);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Exception e2) {
                        e = e2;
                        InputStreamReader inputStreamReader3 = inputStreamReader;
                        inputStream = content;
                        bufferedReader2 = null;
                        inputStreamReader2 = inputStreamReader3;
                        try {
                            C2538c.m12680e("CloudUtil", "Exception = ", e.getMessage());
                            if (entity != null) {
                                try {
                                    entity.consumeContent();
                                } catch (IOException e3) {
                                    C2538c.m12680e("CloudUtil", "consumeContent error!", e3.getMessage(), Boolean.valueOf(false));
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e32) {
                                    C2538c.m12680e("CloudUtil", "IOException e = " + e32.getMessage());
                                }
                            }
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (IOException e322) {
                                    C2538c.m12680e("CloudUtil", "IOException = ", e322.getMessage());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3222) {
                                    C2538c.m12680e("CloudUtil", "IOException = ", e3222.getMessage());
                                }
                            }
                            C2538c.m12674b("CloudUtil", "==ww== content=" + stringBuffer.toString());
                            return stringBuffer.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            content = inputStream;
                            inputStreamReader = inputStreamReader2;
                            httpEntity = entity;
                            if (httpEntity != null) {
                                try {
                                    httpEntity.consumeContent();
                                } catch (IOException e4) {
                                    C2538c.m12680e("CloudUtil", "consumeContent error!", e4.getMessage(), Boolean.valueOf(false));
                                }
                            }
                            if (content != null) {
                                try {
                                    content.close();
                                } catch (IOException e42) {
                                    C2538c.m12680e("CloudUtil", "IOException e = " + e42.getMessage());
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e422) {
                                    C2538c.m12680e("CloudUtil", "IOException = ", e422.getMessage());
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4222) {
                                    C2538c.m12680e("CloudUtil", "IOException = ", e4222.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        httpEntity = entity;
                        if (httpEntity != null) {
                            httpEntity.consumeContent();
                        }
                        if (content != null) {
                            content.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    inputStream = content;
                    bufferedReader2 = null;
                    C2538c.m12680e("CloudUtil", "Exception = ", e.getMessage());
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    C2538c.m12674b("CloudUtil", "==ww== content=" + stringBuffer.toString());
                    return stringBuffer.toString();
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    bufferedReader = null;
                    httpEntity = entity;
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                    if (content != null) {
                        content.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
                bufferedReader2 = null;
                C2538c.m12680e("CloudUtil", "Exception = ", e.getMessage());
                if (entity != null) {
                    entity.consumeContent();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                C2538c.m12674b("CloudUtil", "==ww== content=" + stringBuffer.toString());
                return stringBuffer.toString();
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                content = null;
                bufferedReader = null;
                httpEntity = entity;
                if (httpEntity != null) {
                    httpEntity.consumeContent();
                }
                if (content != null) {
                    content.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            try {
                str = "";
                str = System.getProperty("line.separator");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine + str);
                }
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e32222) {
                        C2538c.m12680e("CloudUtil", "consumeContent error!", e32222.getMessage(), Boolean.valueOf(false));
                    }
                }
                if (content != null) {
                    try {
                        content.close();
                    } catch (IOException e322222) {
                        C2538c.m12680e("CloudUtil", "IOException e = " + e322222.getMessage());
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3222222) {
                        C2538c.m12680e("CloudUtil", "IOException = ", e3222222.getMessage());
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e32222222) {
                        C2538c.m12680e("CloudUtil", "IOException = ", e32222222.getMessage());
                    }
                }
            } catch (Exception e7) {
                e = e7;
                inputStreamReader2 = inputStreamReader;
                inputStream = content;
                bufferedReader2 = bufferedReader;
                C2538c.m12680e("CloudUtil", "Exception = ", e.getMessage());
                if (entity != null) {
                    entity.consumeContent();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                C2538c.m12674b("CloudUtil", "==ww== content=" + stringBuffer.toString());
                return stringBuffer.toString();
            } catch (Throwable th6) {
                th = th6;
                httpEntity = entity;
                if (httpEntity != null) {
                    httpEntity.consumeContent();
                }
                if (content != null) {
                    content.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            entity = null;
            inputStream = null;
            bufferedReader2 = null;
            C2538c.m12680e("CloudUtil", "Exception = ", e.getMessage());
            if (entity != null) {
                entity.consumeContent();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            C2538c.m12674b("CloudUtil", "==ww== content=" + stringBuffer.toString());
            return stringBuffer.toString();
        } catch (Throwable th7) {
            th = th7;
            inputStreamReader = null;
            content = null;
            bufferedReader = null;
            if (httpEntity != null) {
                httpEntity.consumeContent();
            }
            if (content != null) {
                content.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        C2538c.m12674b("CloudUtil", "==ww== content=" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public String m8483b(String str) throws JSONException {
        return ((JSONObject) new JSONTokener(str).nextValue()).getString(LightCloudConstants.DOWNLOAD_URL);
    }

    private SecretItem m8477c(String str) throws Exception {
        SecretItem secretItem;
        C2538c.m12674b("CloudUtil", "Enter getNsptsAndSecret content: " + str);
        try {
            secretItem = (SecretItem) new Gson().fromJson(((JSONObject) new JSONTokener(str).nextValue()).getJSONArray("secretList").get(0).toString(), SecretItem.class);
        } catch (JSONException e) {
            C2538c.m12674b("CloudUtil", "getNsptsAndSecret ERROR : " + e.getMessage());
            secretItem = null;
        } catch (JsonSyntaxException e2) {
            C2538c.m12674b("CloudUtil", "getNsptsAndSecret ERROR : " + e2.getMessage());
            secretItem = null;
        }
        if (secretItem == null) {
            secretItem = new SecretItem();
        }
        C2538c.m12674b("CloudUtil", "getNsptsAndSecret res: " + secretItem.toString());
        return secretItem;
    }

    public boolean m8482a(String str, String str2, String str3, String str4) throws Exception {
        C2538c.m12674b("CloudUtil", "Enter uploadVideoFile  cloudUrlContent:" + str + " filepath" + str2 + "\n key:" + str3 + "  iv:" + str4);
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            C2538c.m12674b("CloudUtil", "Enter uploadVideoFile Error ");
            return false;
        }
        int i = 0;
        InputStream fileInputStream;
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            String string = jSONObject.getString(JoinConstants.ACTION);
            String string2 = jSONObject.getString("callback");
            SecretItem c = m8477c(str);
            C2538c.m12674b("CloudUtil", "=======actionUrl:" + string);
            String str5 = c.secret;
            String str6 = c.nspTs;
            String substring = str2.substring(str2.lastIndexOf("/"));
            C2538c.m12674b("CloudUtil", "=======name:" + substring);
            HttpUriRequest httpPut = new HttpPut(string + substring);
            TreeMap treeMap = new TreeMap();
            httpPut.addHeader("Expect", "100-continue");
            httpPut.addHeader("Host", "upload.dbank.com");
            httpPut.addHeader("Nsp-Ts", str6);
            httpPut.addHeader("Nsp-Callback-Status", "200");
            httpPut.addHeader("Nsp-Callback", string2 + "?filePath=" + substring + "&huid=" + C1462f.m6744i() + "&deviceCode=" + C1462f.m6746j());
            treeMap.put("Nsp-Ts", str6);
            treeMap.put("Nsp-Callback", string2 + "?filePath=" + substring + "&huid=" + C1462f.m6744i() + "&deviceCode=" + C1462f.m6746j());
            treeMap.put("Nsp-Callback-Status", "200");
            str6 = HttpPut.METHOD_NAME;
            string2 = "";
            StringBuffer stringBuffer = new StringBuffer();
            for (Entry entry : treeMap.entrySet()) {
                String obj = entry.getKey().toString();
                stringBuffer.append(SNBConstant.FILTER + obj.toLowerCase() + "=" + entry.getValue().toString());
            }
            C2538c.m12674b("CloudUtil", "=======tmp:" + stringBuffer.toString());
            C2538c.m12674b("CloudUtil", "=======tmp:" + string2.substring(1));
            C2538c.m12674b("CloudUtil", "=======uri:" + (string.substring(string.indexOf("/dl")) + substring));
            C2538c.m12674b("CloudUtil", "=======source_string:" + (str6 + SNBConstant.FILTER + URLEncoder.encode(string, GameManager.DEFAULT_CHARSET) + SNBConstant.FILTER + URLEncoder.encode(string2, GameManager.DEFAULT_CHARSET)));
            Key secretKeySpec = new SecretKeySpec(str5.getBytes(GameManager.DEFAULT_CHARSET), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            httpPut.addHeader("Nsp-Sig", C1492l.m6909a(instance.doFinal(string2.getBytes(GameManager.DEFAULT_CHARSET))));
            C2538c.m12674b("CloudUtil", "=======Nsp-Sig:" + string2);
            HttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
            defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(30000));
            File file = new File(str2);
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read(bArr);
            C2538c.m12674b("CloudUtil", "uploadVideoFile read file ret=" + read);
            fileInputStream.close();
            C2538c.m12674b("CloudUtil", "========加密前文件长度:" + bArr.length);
            C2538c.m12674b("CloudUtil", "========加密前原始二进制:" + C1492l.m6915b(bArr));
            C2538c.m12674b("CloudUtil", "========加密前原始二进制:" + bArr.length);
            C2538c.m12674b("CloudUtil", "=======加密后二进制长度:" + C1481a.m6813b(bArr, str3.getBytes(GameManager.DEFAULT_CHARSET), str4.getBytes(GameManager.DEFAULT_CHARSET)).length);
            C2538c.m12674b("CloudUtil", "=======加密后二进制:" + C1492l.m6915b(r4));
            HttpEntity byteArrayEntity = new ByteArrayEntity(r4);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPut.setEntity(byteArrayEntity);
            HttpResponse execute = defaultHttpClient.execute(httpPut);
            defaultHttpClient.getConnectionManager().shutdown();
            C2538c.m12674b("CloudUtil", "========response== " + execute.toString());
            C2538c.m12674b("CloudUtil", "========statusLine== " + execute.getStatusLine().toString());
            i = r2.getStatusCode();
            C2538c.m12674b("CloudUtil", "========code==" + i + "  ,response== " + execute.toString());
        } catch (IOException e) {
            fileInputStream.close();
            throw e;
        } catch (Exception e2) {
            fileInputStream.close();
            throw e2;
        } catch (Exception e22) {
            C2538c.m12674b("CloudUtil", "=============ERROR " + e22.getMessage());
        }
        boolean z = false;
        if (200 == i) {
            z = true;
        }
        C2538c.m12674b("CloudUtil", "========leave uploadVideoFile res:" + z);
        return z;
    }

    private String m8470a(String str, String str2) {
        C2538c.m12674b("CloudUtil", "=======Enter hmacsha256  macData:" + str + "  macKey:" + str2);
        try {
            byte[] bytes = str2.getBytes(GameManager.DEFAULT_CHARSET);
            byte[] bytes2 = str.getBytes(GameManager.DEFAULT_CHARSET);
            Key secretKeySpec = new SecretKeySpec(bytes, "HMACSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return URLEncoder.encode(Base64.encodeToString(instance.doFinal(bytes2), 2), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("CloudUtil", "UnsupportedEncodingException e" + e.getMessage());
            return "";
        } catch (NoSuchAlgorithmException e2) {
            C2538c.m12674b("CloudUtil", "NoSuchAlgorithmException e" + e2.getMessage());
            return "";
        } catch (InvalidKeyException e3) {
            C2538c.m12674b("CloudUtil", "InvalidKeyException e" + e3.getMessage());
            return "";
        }
    }

    public void m8481a(Context context, ab abVar, Class<?> cls, boolean z) {
        C2538c.m12674b("CloudUtil", "=======Enter downloadRecord 1");
        if (abVar == null) {
            C2538c.m12674b("CloudUtil", "=======downloadRecord  error return");
            return;
        }
        C2538c.m12674b("CloudUtil", "=======downloadRecord  table.tostring:" + abVar.toString());
        new C1746c(this, context, abVar.f2997h, abVar.f2991b, abVar.f3004o, abVar.f3005p, abVar.f2990a, abVar.f2992c, cls, z).start();
    }

    public void m8480a(Context context, ab abVar) {
        C2538c.m12674b("CloudUtil", "=======Enter downloadRecord 2");
        if (abVar == null) {
            C2538c.m12674b("CloudUtil", "=======downloadRecord  error return");
            return;
        }
        C2538c.m12674b("CloudUtil", "=======downloadRecord  table.tostring:" + abVar.toString());
        new C1746c(this, context, abVar.f2997h, abVar.f2991b, abVar.f3004o, abVar.f3005p).start();
    }

    private void m8475a(String str, Context context) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.chat.refresh");
        intent.putExtra("chat_voice_path", str);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private void m8474a(String str, int i, String str2) {
        C2538c.m12674b("CloudUtil", "=======Enter updateVoiceDb");
        if ("".equals(C1462f.m6744i()) || "".equals(C1462f.m6746j())) {
            C1462f.m6729c(C1093a.m4739a(BaseApplication.m2632b()).m4750c());
            C1462f.m6731d(C1497q.m6945b(this.f4790a, "sharedpreferences_watch_device_code", ""));
        }
        if (this.f4790a != null && str != null) {
            ab a = C1392h.m6268a(this.f4790a, C1462f.m6744i(), str2, str);
            if (a == null) {
                C2538c.m12674b("CloudUtil", "=======getVoiceByurl table is null ,return");
                return;
            }
            a.f3002m = i;
            C1392h.m6277a(this.f4790a, a);
        }
    }

    public String m8479a(Context context, int i, String str) {
        int i2;
        C2538c.m12674b("CloudUtil", "=======Enter getDownloadFilepath  deviceCode:" + i + "\nhuid:" + str + "\n");
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + String.valueOf(i);
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        C2538c.m12674b("CloudUtil", "getDownloadFilepath dirPath:" + str2);
        File file = new File(str2);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            C2538c.m12674b("CloudUtil", "res:" + mkdirs);
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i3 = 0;
            i2 = 0;
            while (i3 < length) {
                int parseInt;
                String name = listFiles[i3].getName();
                int indexOf = name.indexOf(95);
                if (indexOf >= 1) {
                    parseInt = Integer.parseInt(name.substring(0, indexOf));
                    if (parseInt >= i2) {
                        i3++;
                        i2 = parseInt;
                    }
                }
                parseInt = i2;
                i3++;
                i2 = parseInt;
            }
        } else {
            i2 = 0;
        }
        stringBuilder.append(str2).append(File.separator).append(i2 + 1).append(HwAccountConstants.SPLIIT_UNDERLINE).append(i).append(HwAccountConstants.SPLIIT_UNDERLINE).append(simpleDateFormat.format(date)).append("").append("" + System.currentTimeMillis()).append(".amr");
        return stringBuilder.toString();
    }

    public static boolean m8476a(Context context, boolean z) {
        boolean z2 = false;
        boolean z3 = true;
        if (context != null) {
            synchronized (f4789c) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (z) {
                    z2 = audioManager.requestAudioFocus(null, 3, 2) == 1;
                } else {
                    if (audioManager.abandonAudioFocus(null) != 1) {
                        z3 = false;
                    }
                    z2 = z3;
                }
            }
        }
        return z2;
    }
}
