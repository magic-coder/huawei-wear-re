package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.huawei.common.util.EncryptUtil;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.p145d.C1475h;
import com.huawei.pluginkidwatch.common.lib.utils.C1481a;
import com.huawei.pluginkidwatch.common.lib.utils.C1487g;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1494n;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
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

/* compiled from: UploadProfileUtils */
public class C1906x {
    private static String f6240a = "";
    private static String f6241b = "";
    private static String f6242c = "";
    private static String f6243d = "";
    private static String f6244e = "";

    public static byte[] m9701a(String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(GameManager.DEFAULT_CHARSET), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("UploadProfileUtils", "UnsupportedEncodingException e = " + e.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e2) {
            C2538c.m12674b("UploadProfileUtils", "NoSuchAlgorithmException e = " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            C2538c.m12674b("UploadProfileUtils", "InvalidKeyException e = " + e3.getMessage());
            return new byte[0];
        }
    }

    public static String m9697a(Context context) {
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        C2538c.m12674b("UploadProfileUtils", "==ww==  entry  executeGet ");
        f6243d = System.currentTimeMillis() + "";
        if ("".equals(f6242c) || f6242c == null) {
            f6242c = C1487g.m6873a(context, "09F98935DF23B3E011F5638614670662IrzLoccccR72B/H4EI3GKB6ny7lTZGH7IB4hQWa2qra9LliDA6e9/qgL/9yUjVL0");
        }
        f6244e = "https://health.vmall.com/v2/rest?method=com.huawei.watchApp.getUploadInfo&appID=10131836&sign=" + C1906x.m9705b(EncryptUtil.HEALTH_APP_ID + f6243d, f6242c) + "&ts=" + f6243d + "&type=headIcon&filePost=headIcon&uploadAppID=82619&client=" + C1462f.m6744i();
        C2538c.m12674b("UploadProfileUtils", "==ww==executeGet huid=  " + C1462f.m6744i());
        C2538c.m12674b("UploadProfileUtils", "==ww==executeGet base huid=  " + C1492l.m6908a(C1462f.m6744i()));
        C2538c.m12674b("UploadProfileUtils", "==ww==executeGet url=  " + f6244e);
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", new C1475h(KeyStore.getInstance(KeyStore.getDefaultType()), context.getApplicationContext()), 443));
            HttpUriRequest httpGet = new HttpGet();
            httpGet.setURI(new URI(f6244e));
            bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpGet).getEntity().getContent(), GameManager.DEFAULT_CHARSET));
            try {
                String str = "";
                str = System.getProperty("line.separator");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine + str);
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        C2538c.m12680e("UploadProfileUtils", "Exception = ", e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C2538c.m12680e("UploadProfileUtils", "Exception = ", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            C2538c.m12680e("UploadProfileUtils", "Exception = ", e22.getMessage());
                        }
                    }
                    C2538c.m12674b("UploadProfileUtils", "==ww== content=" + stringBuffer.toString());
                    return stringBuffer.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            C2538c.m12680e("UploadProfileUtils", "Exception = ", e4.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            C2538c.m12680e("UploadProfileUtils", "Exception = ", e.getMessage());
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            C2538c.m12674b("UploadProfileUtils", "==ww== content=" + stringBuffer.toString());
            return stringBuffer.toString();
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        C2538c.m12674b("UploadProfileUtils", "==ww== content=" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static void m9698a(String str, String str2, String str3, String str4, String str5, HttpPut httpPut) {
        try {
            TreeMap treeMap = new TreeMap();
            httpPut.addHeader("Expect", "100-continue");
            httpPut.addHeader("Host", "upload.dbank.com");
            httpPut.addHeader("Nsp-ts", str4);
            httpPut.addHeader("nsp-file-md5", str5);
            treeMap.put("nsp-file-md5", str5);
            treeMap.put("nsp-ts", str4);
            String str6 = HttpPut.METHOD_NAME;
            String str7 = "";
            StringBuffer stringBuffer = new StringBuffer();
            for (Entry entry : treeMap.entrySet()) {
                String obj = entry.getKey().toString();
                stringBuffer.append(SNBConstant.FILTER + obj.toLowerCase() + "=" + entry.getValue().toString());
            }
            C2538c.m12674b("UploadProfileUtils", "tmp = ", stringBuffer.toString().substring(1));
            C2538c.m12674b("UploadProfileUtils", "uri = ", str.substring(str.indexOf("/dl")));
            C2538c.m12674b("UploadProfileUtils", "source_string = ", str6 + SNBConstant.FILTER + URLEncoder.encode(str7, GameManager.DEFAULT_CHARSET) + SNBConstant.FILTER + URLEncoder.encode(r0, GameManager.DEFAULT_CHARSET));
            C2538c.m12674b("UploadProfileUtils", "nsp_sig = ", C1492l.m6909a(C1906x.m9701a(r0, str3)));
            httpPut.addHeader("Nsp-Sig", r0);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("UploadProfileUtils", "UnsupportedEncodingException e = " + e.getMessage());
        }
    }

    public static Bitmap m9694a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] m9699a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] m9706b(Drawable drawable) {
        return C1906x.m9699a(C1906x.m9694a(drawable));
    }

    public static int m9693a(String str, String str2, int i, byte[] bArr, Context context) {
        C2538c.m12674b("UploadProfileUtils", "==ww== parJson  result=" + str);
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            String string = jSONObject.getString(JoinConstants.ACTION);
            String string2 = jSONObject.getString("callback");
            String string3 = jSONObject.getString("secret");
            String string4 = jSONObject.getString("nspTs");
            String string5 = jSONObject.getString(LightCloudConstants.DOWNLOAD_URL);
            String string6 = jSONObject.getString(SMSKeyInfo.TAG_KEY);
            if (1 == i) {
                f6241b = string6 + string5;
            } else if (2 == i) {
                f6240a = string6 + string5;
            }
            C2538c.m12674b("UploadProfileUtils", "==ww==  bigHeadIcon=" + f6241b);
            C2538c.m12674b("UploadProfileUtils", "==ww==  headIconUrl=" + f6240a);
            HttpUriRequest httpPut = new HttpPut(string);
            HttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            if (bArr == null || bArr.length == 0) {
                bArr = C1906x.m9706b(context.getResources().getDrawable(C1617f.kw_pic_ist_user_common));
            }
            byte[] bArr2 = null;
            byte[] bArr3 = null;
            if (1 == i) {
                C2538c.m12674b("UploadProfileUtils", "==ww== 1 bigHeadIcon=" + f6241b);
                bArr2 = f6241b.substring(0, 16).getBytes(GameManager.DEFAULT_CHARSET);
                bArr3 = f6241b.substring(16, 32).getBytes(GameManager.DEFAULT_CHARSET);
            } else if (2 == i) {
                C2538c.m12674b("UploadProfileUtils", "==ww== 2 headIconUrl=" + f6240a);
                bArr2 = f6240a.substring(0, 16).getBytes(GameManager.DEFAULT_CHARSET);
                bArr3 = f6240a.substring(16, 32).getBytes(GameManager.DEFAULT_CHARSET);
            }
            string6 = C1481a.m6811a(C1906x.m9700a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), i), bArr2, bArr3);
            C2538c.m12674b("UploadProfileUtils", "==ww== yasuo hou daxiao ==" + r9.length);
            C2538c.m12674b("UploadProfileUtils", "==ww== yasuo hou daxiao jiamihou ==" + string6.getBytes(GameManager.DEFAULT_CHARSET).length);
            Object byteArrayEntity = new ByteArrayEntity(string6.getBytes(GameManager.DEFAULT_CHARSET));
            C1906x.m9698a(string, string2, string3, string4, C1494n.m6927a(string6), httpPut);
            int i2 = 0;
            if (byteArrayEntity != null) {
                httpPut.setEntity(byteArrayEntity);
                byteArrayEntity.setContentType("binary/octet-stream");
                HttpResponse execute = defaultHttpClient.execute(httpPut);
                defaultHttpClient.getConnectionManager().shutdown();
                i2 = execute.getStatusLine().getStatusCode();
            }
            C2538c.m12674b("UploadProfileUtils", "==ww== parJson  type == " + i + " code --==" + i2);
            return i2;
        } catch (JSONException e) {
            C2538c.m12674b("UploadProfileUtils", "JSONException e = " + e.getMessage());
            return 0;
        } catch (IOException e2) {
            C2538c.m12674b("UploadProfileUtils", "IOException e = " + e2.getMessage());
            return 0;
        } catch (NotFoundException e3) {
            C2538c.m12674b("UploadProfileUtils", "Resources.NotFoundException e = " + e3.getMessage());
            return 0;
        }
    }

    private static byte[] m9700a(Bitmap bitmap, int i) {
        int i2 = 100;
        int i3 = 1 == i ? 50 : 2 == i ? 3 : 1;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > i3) {
            C2538c.m12674b("UploadProfileUtils", "==ww== da yu 3 jinlaile=" + (byteArrayOutputStream.toByteArray().length / 1024));
            byteArrayOutputStream.reset();
            bitmap.compress(CompressFormat.JPEG, i2, byteArrayOutputStream);
            C2538c.m12674b("UploadProfileUtils", "==ww== option qian =" + i2);
            i2 -= 10;
            C2538c.m12674b("UploadProfileUtils", "==ww== option  hou  =" + i2);
            if (i2 <= 0) {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] m9702a(byte[] bArr, int i, int i2) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int width = decodeByteArray.getWidth();
        int height = decodeByteArray.getHeight();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, width, height, matrix, true);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeByteArray.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static String m9705b(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes(GameManager.DEFAULT_CHARSET);
            byte[] bytes2 = str.getBytes(GameManager.DEFAULT_CHARSET);
            Key secretKeySpec = new SecretKeySpec(bytes, "HMACSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return URLEncoder.encode(Base64.encodeToString(instance.doFinal(bytes2), 2), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("UploadProfileUtils", "UnsupportedEncodingException e" + e.getMessage());
            return "";
        } catch (NoSuchAlgorithmException e2) {
            C2538c.m12674b("UploadProfileUtils", "NoSuchAlgorithmException e" + e2.getMessage());
            return "";
        } catch (InvalidKeyException e3) {
            C2538c.m12674b("UploadProfileUtils", "InvalidKeyException e" + e3.getMessage());
            return "";
        }
    }

    public static String m9704b(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static Bitmap m9695a(String str) {
        Bitmap bitmap = null;
        if (!(str == null || "".equals(str))) {
            try {
                byte[] decode = Base64.decode(str, 0);
                bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception e) {
            }
        }
        return bitmap;
    }

    public static String m9696a() {
        return (String) C1489i.m6887a(f6240a);
    }

    public static String m9703b() {
        return (String) C1489i.m6887a(f6241b);
    }
}
