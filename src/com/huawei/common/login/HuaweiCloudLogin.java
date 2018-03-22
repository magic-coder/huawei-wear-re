package com.huawei.common.login;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.common.util.EncryptUtil;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import org.apache.http.HttpResponse;
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
import org.json.JSONObject;

public class HuaweiCloudLogin {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String AUTHORIZATION_KEY = "Authorization";
    public static final String CLIENT_ID_KEY = "FD0C4443C30A3FDC10D56AF2DBDE2BD2mKhgT4YSVHf+dCwbmSJdpUpo2DFjyHc+I+h6MvNeKyw=";
    private static final String CLIENT_ID_key1 = "FD0C4443C30A3FDC10D56";
    public static final String DEVICE_ID = "6824CF96-FFE5-4C7D-B376-91918C8F570D";
    public static final String ERROR_IS_KEY = "ERROR_IS_KEY";
    public static final String EXPIRES_IN_KEY = "expires_in";
    public static final String MODEL = (TextUtils.isEmpty(Build.MODEL) ? "G510" : Build.MODEL);
    public static final String RESULT_CODE_KEY = "resultCode";
    public static final String RESULT_KEY = "result";
    private static final String TAG = "HuaweiCloudLogin";
    public static final String USER_ID_KEY = "userID";
    private static String mHostUrl = "https://health.vmall.com/v2/rest";

    final class C43581 implements Runnable {
        final /* synthetic */ IHwCloudLoginCallback val$callback;
        final /* synthetic */ String val$client_id;
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$device_id;
        final /* synthetic */ String val$packageName;
        final /* synthetic */ String val$sso_st;
        final /* synthetic */ String val$userID;

        C43581(String str, String str2, String str3, Context context, String str4, String str5, IHwCloudLoginCallback iHwCloudLoginCallback) {
            this.val$sso_st = str;
            this.val$userID = str2;
            this.val$device_id = str3;
            this.val$context = context;
            this.val$packageName = str4;
            this.val$client_id = str5;
            this.val$callback = iHwCloudLoginCallback;
        }

        public void run() {
            Bundle bundle = new Bundle();
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("sso_st", this.val$sso_st);
                hashMap.put("userID", this.val$userID);
                hashMap.put(Constant.KEY_METHOD, "stToAt");
                if (TextUtils.isEmpty(this.val$device_id)) {
                    hashMap.put(SNBConstant.FIELD_DEVICE_ID, HuaweiCloudLogin.DEVICE_ID);
                } else {
                    hashMap.put(SNBConstant.FIELD_DEVICE_ID, this.val$device_id);
                }
                hashMap.put("tid", System.currentTimeMillis() + "");
                hashMap.put("appID", EncryptUtil.decrypt(this.val$context, EncryptUtil.APP_ID));
                hashMap.put("ts", System.currentTimeMillis() + "");
                hashMap.put("packageName", this.val$packageName);
                hashMap.put("terminalType", HuaweiCloudLogin.MODEL);
                hashMap.put(WBConstants.AUTH_PARAMS_CLIENT_ID, this.val$client_id);
                C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"=====st2at: map:" + hashMap.toString()});
                HttpResponse access$000 = HuaweiCloudLogin.getHttpResponse(hashMap, this.val$context);
                if (access$000.getStatusLine().getStatusCode() == 200) {
                    String entityUtils = EntityUtils.toString(access$000.getEntity());
                    C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"stToAt response= " + entityUtils});
                    bundle.putString("result", entityUtils);
                    JSONObject jSONObject = new JSONObject(entityUtils);
                    entityUtils = jSONObject.getString("access_token");
                    int i = jSONObject.getInt("expires_in");
                    int i2 = jSONObject.getInt("code");
                    C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"code::: " + i2});
                    bundle.putInt("resultCode", i2);
                    bundle.putString("access_token", entityUtils);
                    bundle.putInt("expires_in", i);
                    bundle.putString("userID", this.val$userID);
                } else {
                    C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"error code:" + access$000.getStatusLine().getStatusCode()});
                    bundle.putInt("resultCode", access$000.getStatusLine().getStatusCode());
                    bundle.putString("result", "error code:" + access$000.getStatusLine().getStatusCode());
                    bundle.putBoolean(HuaweiCloudLogin.ERROR_IS_KEY, true);
                    bundle.putString("userID", this.val$userID);
                }
            } catch (RuntimeException e) {
                bundle.putString("result", e.getMessage());
                bundle.putBoolean(HuaweiCloudLogin.ERROR_IS_KEY, true);
                C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"error message:RuntimeException" + e.getMessage()});
                C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"error message:RuntimeException" + e.toString()});
            } catch (Exception e2) {
                bundle.putString("result", e2.getMessage());
                bundle.putBoolean(HuaweiCloudLogin.ERROR_IS_KEY, true);
                C2538c.b(HuaweiCloudLogin.TAG, new Object[]{"error message:" + e2.getMessage()});
                C2538c.e(HuaweiCloudLogin.TAG, new Object[]{"error message, Exception e"});
            }
            this.val$callback.onComplete(bundle);
        }
    }

    private static HttpResponse getHttpResponse(HashMap<String, String> hashMap, Context context) throws ClientProtocolException, IOException {
        Object hmacsha256;
        hashMap.put("ts", System.currentTimeMillis() + "");
        hashMap.put("tid", System.currentTimeMillis() + "");
        hashMap.put("appID", EncryptUtil.decrypt(context, EncryptUtil.APP_ID));
        C2538c.b(TAG, new Object[]{"mHostUrl= " + mHostUrl});
        HttpUriRequest httpPost = new HttpPost(mHostUrl);
        httpPost.addHeader("Authorization", "" + new Date().getTime());
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        try {
            hmacsha256 = EncryptUtil.hmacsha256(((String) hashMap.get("appID")) + ((String) hashMap.get("ts")), EncryptUtil.decrypt(context, EncryptUtil.APP_SECRET));
        } catch (Exception e) {
            C2538c.b(TAG, new Object[]{"getHttpResponse Exception" + e.getMessage()});
            C2538c.c(TAG, new Object[]{"getHttpResponse Exception~"});
            hmacsha256 = null;
        }
        hashMap.put("sign", hmacsha256);
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry key : hashMap.entrySet()) {
            String str = (String) key.getKey();
            arrayList.add(new BasicNameValuePair(str, (String) hashMap.get(str)));
            stringBuilder.append(str + "=" + ((String) hashMap.get(str)) + SNBConstant.FILTER);
        }
        C2538c.b(TAG, new Object[]{"stringBuilder=" + stringBuilder.toString()});
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, GameManager.DEFAULT_CHARSET));
        return defaultHttpClient.execute(httpPost);
    }

    public static void stToAt(String str, String str2, String str3, String str4, String str5, IHwCloudLoginCallback iHwCloudLoginCallback, Context context) {
        Executors.newSingleThreadExecutor().execute(new C43581(str, str2, str4, context, str5, str3, iHwCloudLoginCallback));
    }

    public static boolean isRequestSuccess(Bundle bundle) {
        return bundle.getInt("resultCode", -1) == 0;
    }

    public static String getAToken(Bundle bundle) {
        return bundle.getString("access_token");
    }

    public static String getUserId(Bundle bundle) {
        return bundle.getString("userID");
    }
}
