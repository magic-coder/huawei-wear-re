package com.huawei.ui.main.stories.account.interactor;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.huawei.common.login.HuaweiCloudLogin;
import com.huawei.common.util.EncryptUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.UserAccountInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HuaweiCloudLogin */
public class C2354d {
    public static final String f8514a = (TextUtils.isEmpty(Build.MODEL) ? "G510" : Build.MODEL);
    private static String f8515b = "1C8xI199whUNEO9K1fUDl3F5LpQY0NacS3Ea2ZljClBqLggdl5VjE17s9sk7ybqMD";
    private static String f8516c = "1b9QiH6xjCW6o8ens59BvKKhqa5594wllpf1vizzzLLnHIAwuC72YiQhBdnJog3tRMcrxSPctft7EWZIlOOFIfA==";
    private static String f8517d = "https://health.vmall.com/v2/rest";
    private static String f8518e = "http://223.202.123.136:10180/health/v2/rest";
    private static String f8519f = "1aY3veaBJ2SiiTFzWtVVwK+T3dlrURmmgWKGukdDrNIpap02z6g4AFvOwoTPm3tO3";
    private static String f8520g = "1BKdL6XDw8Tza+LQuQQncNTO9IfrbXAbfpUCudPPJATKIHMS9m0CvGUcC5xkFiSPq";

    public static void m11948a(Context context, C2353b c2353b, C2344c c2344c) {
        C2538c.m12677c("HuaweiCloudLogin_main", "Enter Login");
        String packageName = context.getPackageName();
        switch (c2353b.m11937c()) {
            case 1:
            case 4:
            case 5:
            case 7:
                C2354d.m11949a(context, c2353b, packageName, new C2358h(context, c2344c));
                return;
            case 2:
                C2354d.m11955f(context, c2353b, new C2359i(context, c2344c));
                return;
            default:
                C2538c.m12677c("HuaweiCloudLogin_main", "login-->loginHWCloudChangeSTToAT");
                C2354d.m11954e(context, c2353b, c2344c);
                return;
        }
    }

    private static void m11954e(Context context, C2353b c2353b, C2344c c2344c) {
        C2538c.m12677c("HuaweiCloudLogin_main", "loginHWCloudChangeSTToAT");
        String a = C2354d.m11945a(context);
        if (TextUtils.isEmpty(a)) {
            a = HuaweiCloudLogin.DEVICE_ID;
        }
        C2354d.m11950a(context, c2353b, a, context.getPackageName(), c2344c);
    }

    private static void m11955f(Context context, C2353b c2353b, C2344c c2344c) {
        C2538c.m12677c("HuaweiCloudLogin_main", "checkIsActive");
        new C2355e(context, c2353b, c2344c).execute(new Void[0]);
    }

    public static String m11945a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public static Void m11951b(Context context, C2353b c2353b, C2344c c2344c) {
        String entityUtils;
        RuntimeException e;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("sso_st", c2353b.m11940d());
            hashMap.put("userID", c2353b.m11942e());
            hashMap.put(Constant.KEY_METHOD, "getAccountState");
            hashMap.put("tid", System.currentTimeMillis() + "");
            hashMap.put("ts", System.currentTimeMillis() + "");
            hashMap.put("packageName", context.getPackageName());
            hashMap.put("siteId", c2353b.m11931a() + "");
            Object a = C2354d.m11945a(context);
            if (TextUtils.isEmpty(a)) {
                a = HuaweiCloudLogin.DEVICE_ID;
            }
            hashMap.put(SNBConstant.FIELD_DEVICE_ID, a);
            hashMap.put("terminalType", f8514a);
            HttpResponse a2 = C2354d.m11947a(hashMap, context);
            if (a2.getStatusLine().getStatusCode() == 200) {
                entityUtils = EntityUtils.toString(a2.getEntity());
                try {
                    C2538c.m12674b("HuaweiCloudLogin_main", "check is Active response=" + entityUtils);
                    if (new JSONObject(entityUtils).getInt(UserAccountInfo.TAG_ACCOUNT_STATE) != 0) {
                        if (c2344c != null) {
                            c2344c.mo2657a(c2353b);
                        }
                    } else if (c2344c != null) {
                        c2344c.mo2656a(4, "checkIsActive = " + entityUtils);
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    C2538c.m12680e("HuaweiCloudLogin_main", e, "checkIsActive = json = ", entityUtils);
                    if (c2344c != null) {
                        c2344c.mo2656a(1, "checkIsActive = json = " + entityUtils + "  error message:" + e.getMessage());
                    }
                    return null;
                } catch (JSONException e3) {
                    e = e3;
                    C2538c.m12680e("HuaweiCloudLogin_main", e, "checkIsActive = json = ", entityUtils);
                    if (c2344c != null) {
                        c2344c.mo2656a(1, entityUtils);
                    }
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    C2538c.m12680e("HuaweiCloudLogin_main", e, "checkIsActive = json = ", entityUtils);
                    if (c2344c != null) {
                        c2344c.mo2656a(1, entityUtils);
                    }
                    return null;
                }
            }
            C2538c.m12677c("HuaweiCloudLogin_main", "error code:" + a2.getStatusLine().getStatusCode());
            C2538c.m12674b("HuaweiCloudLogin_main", "error code:" + a2.getStatusLine().getStatusCode());
            if (c2344c != null) {
                c2344c.mo2656a(6, "checkIsActive = error code:" + a2.getStatusLine().getStatusCode());
            }
        } catch (RuntimeException e5) {
            e = e5;
            entityUtils = null;
            C2538c.m12680e("HuaweiCloudLogin_main", e, "checkIsActive = json = ", entityUtils);
            if (c2344c != null) {
                c2344c.mo2656a(1, "checkIsActive = json = " + entityUtils + "  error message:" + e.getMessage());
            }
            return null;
        } catch (JSONException e6) {
            JSONException e7;
            e7 = e6;
            entityUtils = null;
            C2538c.m12680e("HuaweiCloudLogin_main", e7, "checkIsActive = json = ", entityUtils);
            if (c2344c != null) {
                c2344c.mo2656a(1, entityUtils);
            }
            return null;
        } catch (IOException e8) {
            IOException e9;
            e9 = e8;
            entityUtils = null;
            C2538c.m12680e("HuaweiCloudLogin_main", e9, "checkIsActive = json = ", entityUtils);
            if (c2344c != null) {
                c2344c.mo2656a(1, entityUtils);
            }
            return null;
        }
        return null;
    }

    private static void m11949a(Context context, C2353b c2353b, String str, C2344c c2344c) {
        C2538c.m12677c("HuaweiCloudLogin_main", "userThirdAuth");
        new C2356f(context, c2353b, c2344c).execute(new Void[0]);
    }

    public static Void m11952c(Context context, C2353b c2353b, C2344c c2344c) {
        RuntimeException e;
        IOException e2;
        JSONException e3;
        String a = C2354d.m11944a(c2353b.m11937c());
        if (a == null) {
            c2344c.mo2656a(2, " userThirdAuth  不支持类型  accountContext.getLoginType() = " + c2353b.m11937c());
        } else {
            try {
                Object a2 = C2354d.m11945a(context);
                if (TextUtils.isEmpty(a2)) {
                    a2 = HuaweiCloudLogin.DEVICE_ID;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(Constant.KEY_METHOD, "userThirdAuth");
                hashMap.put("accountType", a);
                hashMap.put("userAccount", c2353b.m11942e());
                hashMap.put("thirdToken", c2353b.m11940d());
                hashMap.put("deviceType", "0");
                hashMap.put("deviceId", a2);
                hashMap.put("packageName", context.getPackageName());
                hashMap.put("terminalType", f8514a);
                HttpResponse a3 = C2354d.m11947a(hashMap, context);
                if (a3.getStatusLine().getStatusCode() == 200) {
                    a = EntityUtils.toString(a3.getEntity());
                    try {
                        C2538c.m12674b("HuaweiCloudLogin_main", "userThirdAuth json =  ", a);
                        JSONObject jSONObject = new JSONObject(a);
                        if (jSONObject.getInt("code") == 0) {
                            String string = jSONObject.getString("sso_st");
                            String string2 = jSONObject.getString("userID");
                            int i = jSONObject.getInt("siteId");
                            C2353b c2353b2 = new C2353b();
                            c2353b2.m11938c(c2353b.m11937c());
                            c2353b2.m11939c(string2);
                            c2353b2.m11936b(string);
                            c2353b2.m11932a(i);
                            c2353b2.m11941d(c2353b.m11943f());
                            c2344c.mo2657a(c2353b2);
                        } else {
                            c2344c.mo2656a(5, "userThirdAuth = " + a);
                        }
                    } catch (RuntimeException e4) {
                        e = e4;
                        C2538c.m12680e("HuaweiCloudLogin_main", "error message:" + e.getMessage());
                        c2344c.mo2656a(1, "userThirdAuth =   json = " + a + "  error message:" + e.getMessage());
                        return null;
                    } catch (IOException e5) {
                        e2 = e5;
                        C2538c.m12680e("HuaweiCloudLogin_main", "error message:" + e2.getMessage());
                        c2344c.mo2656a(1, "userThirdAuth =   json = " + a + "  error message:" + e2.getMessage());
                        return null;
                    } catch (JSONException e6) {
                        e3 = e6;
                        C2538c.m12680e("HuaweiCloudLogin_main", "error message:" + e3.getMessage());
                        c2344c.mo2656a(1, "userThirdAuth =   json = " + a + "  error message:" + e3.getMessage());
                        return null;
                    }
                }
                C2538c.m12680e("HuaweiCloudLogin_main", "error code:" + a3.getStatusLine().getStatusCode());
                c2344c.mo2656a(6, "userThirdAuth = error code:" + a3.getStatusLine().getStatusCode());
            } catch (RuntimeException e7) {
                e = e7;
                a = null;
                C2538c.m12680e("HuaweiCloudLogin_main", "error message:" + e.getMessage());
                c2344c.mo2656a(1, "userThirdAuth =   json = " + a + "  error message:" + e.getMessage());
                return null;
            } catch (IOException e8) {
                e2 = e8;
                a = null;
                C2538c.m12680e("HuaweiCloudLogin_main", "error message:" + e2.getMessage());
                c2344c.mo2656a(1, "userThirdAuth =   json = " + a + "  error message:" + e2.getMessage());
                return null;
            } catch (JSONException e9) {
                e3 = e9;
                a = null;
                C2538c.m12680e("HuaweiCloudLogin_main", "error message:" + e3.getMessage());
                c2344c.mo2656a(1, "userThirdAuth =   json = " + a + "  error message:" + e3.getMessage());
                return null;
            }
        }
        return null;
    }

    private static String m11944a(int i) {
        switch (i) {
            case 1:
                return HwAccountConstants.TYPE_WEIXIN;
            case 4:
                return "4";
            case 5:
                return "23";
            case 7:
                return "7";
            default:
                return null;
        }
    }

    private static HttpResponse m11947a(HashMap<String, String> hashMap, Context context) throws ClientProtocolException, IOException {
        String hmacsha256;
        hashMap.put(WBConstants.AUTH_PARAMS_CLIENT_ID, EncryptUtil.decrypt(context, EncryptUtil.APP_ID));
        String str = f8517d;
        hashMap.put("ts", System.currentTimeMillis() + "");
        hashMap.put("tid", System.currentTimeMillis() + "");
        hashMap.put("appID", EncryptUtil.decrypt(context, EncryptUtil.APP_ID));
        HttpUriRequest httpPost = new HttpPost(str);
        httpPost.addHeader(AUTH.WWW_AUTH_RESP, "" + new Date().getTime());
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        List arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        try {
            hmacsha256 = EncryptUtil.hmacsha256(((String) hashMap.get("appID")) + ((String) hashMap.get("ts")), EncryptUtil.decrypt(context, EncryptUtil.APP_SECRET));
        } catch (NoSuchAlgorithmException e) {
            C2538c.m12677c("HuaweiCloudLogin_main", "NoSuchAlgorithmException Exception");
            hmacsha256 = null;
        } catch (InvalidKeyException e2) {
            C2538c.m12677c("HuaweiCloudLogin_main", "InvalidKeyException Exception");
            hmacsha256 = null;
        }
        arrayList.add(new BasicNameValuePair("sign", hmacsha256));
        hashMap.put("sign", hmacsha256);
        C2538c.m12674b("HuaweiCloudLogin_main", "paramMap = " + hashMap);
        C2538c.m12674b("HuaweiCloudLogin_main", "hostUrl = " + str);
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, GameManager.DEFAULT_CHARSET));
        return defaultHttpClient.execute(httpPost);
    }

    private static void m11950a(Context context, C2353b c2353b, String str, String str2, C2344c c2344c) {
        C2538c.m12677c("HuaweiCloudLogin_main", "stToAt");
        C2538c.m12677c("HuaweiCloudLogin_main", "accountContext:" + c2353b.toString());
        new C2357g(c2353b, context, c2344c).execute(new Void[0]);
    }

    public static Void m11946a(Context context, C2344c c2344c, String str, String str2, String str3, int i) {
        try {
            Object a = C2354d.m11945a(context);
            if (TextUtils.isEmpty(a)) {
                a = HuaweiCloudLogin.DEVICE_ID;
            }
            String packageName = context.getPackageName();
            HashMap hashMap = new HashMap();
            hashMap.put("sso_st", str3);
            hashMap.put("userID", str);
            hashMap.put(Constant.KEY_METHOD, "stToAt");
            hashMap.put(SNBConstant.FIELD_DEVICE_ID, a);
            hashMap.put("tid", System.currentTimeMillis() + "");
            hashMap.put("ts", System.currentTimeMillis() + "");
            hashMap.put("packageName", packageName);
            hashMap.put("terminalType", f8514a);
            hashMap.put("siteId", i + "");
            C2538c.m12677c("HuaweiCloudLogin_main", "stToAt :" + hashMap.toString());
            HttpResponse a2 = C2354d.m11947a(hashMap, context);
            if (a2.getStatusLine().getStatusCode() == 200) {
                String entityUtils = EntityUtils.toString(a2.getEntity());
                C2538c.m12677c("HuaweiCloudLogin_main", "stToAt response");
                packageName = "";
                int i2 = 0;
                if (!(entityUtils == null || "".equals(entityUtils))) {
                    JSONObject jSONObject = new JSONObject(entityUtils);
                    packageName = jSONObject.getString("access_token");
                    i2 = jSONObject.getInt("expires_in");
                }
                C2353b c2353b = new C2353b();
                c2353b.m11938c(2);
                c2353b.m11939c(str);
                c2353b.m11936b(str3);
                c2353b.m11933a(packageName);
                c2353b.m11935b(i2);
                c2353b.m11932a(i);
                c2353b.m11941d(str2);
                c2344c.mo2657a(c2353b);
                return null;
            }
            C2538c.m12680e("HuaweiCloudLogin_main", "error code:" + a2.getStatusLine().getStatusCode());
            c2344c.mo2656a(6, "stToAt = error code:" + a2.getStatusLine().getStatusCode());
            return null;
        } catch (RuntimeException e) {
            C2538c.m12680e("HuaweiCloudLogin_main", e, "stToAt = json = ", null);
            c2344c.mo2656a(1, "stToAt =  json = " + null + "  error message:" + e.getMessage());
            return null;
        } catch (IOException e2) {
            C2538c.m12680e("HuaweiCloudLogin_main", e2, "stToAt = json = ", null);
            c2344c.mo2656a(1, "stToAt =  json = " + null + "  error message:" + e2.getMessage());
            return null;
        } catch (JSONException e3) {
            C2538c.m12680e("HuaweiCloudLogin_main", e3, "stToAt = json = ", null);
            c2344c.mo2656a(1, "stToAt =  json = " + null + "  error message:" + e3.getMessage());
            return null;
        }
    }
}
